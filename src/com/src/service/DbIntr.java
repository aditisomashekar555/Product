package com.src.service;

import java.sql.SQLException;
import com.src.model.Clothes;


public interface DbIntr {

	public Clothes fetchById(int id)throws SQLException ;

}
