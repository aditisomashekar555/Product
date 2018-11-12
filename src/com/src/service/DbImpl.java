package com.src.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.src.model.Clothes;


public class DbImpl implements DbIntr{
		private static Connection con;
		
		static {
			try {
				Class.forName("org.h2.Driver");
				
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		public Clothes fetchById(int id)throws SQLException {
			String sql="select * from clothes where cloth_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Clothes c=new Clothes();
			
			while(rs.next()) {
				c.setClothes_id(rs.getInt("cloth_id"));
				c.setCategory(rs.getString("category"));
				c.setType(rs.getString("type"));
				c.setStyle(rs.getString("style"));
				c.setColour(rs.getString("colour"));
				c.setSize(rs.getInt("size"));
				c.setCost(rs.getInt("cost"));
			}
			return c;			
		}

}
