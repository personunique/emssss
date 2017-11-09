package com.cg.ems.dbconfig;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	
	public static Connection getConnection() throws IOException, SQLException{
	
		Connection con = null;
		Properties pro = readDbInfo(); 
		
		String url = pro.getProperty("url");
		String password = pro.getProperty("password");
		String username = pro.getProperty("username");
		con = DriverManager.getConnection(url,username,password);
	/*
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);*/
		return con;
	}

	private static Properties readDbInfo() throws IOException {

			Properties p = new Properties();
			
			FileReader fr = new FileReader("ems.properties");
			p.load(fr);
			
		return p;
	}
	
	
}
