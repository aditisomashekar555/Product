package com.src.service;


public class FactoryClass {

private FactoryClass() {
		
		
	}
	
	private static DbIntr di;
	public static DbIntr getInstance() {
		di=new DbImpl();
		return di;
		
		
	}
}
