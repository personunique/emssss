package com.cg.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ems.bean.LoginDetailsBean;
import com.cg.ems.dbconfig.DbUtil;

public class LoginDAOImpl implements ILoginDAO{
	Connection conn=null;
	Logger logger=Logger.getRootLogger();
	public LoginDAOImpl()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	@Override
	public int validateLogin(LoginDetailsBean loginDetails) {
		try {
			//System.out.println(loginDetails);
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select login_id from login_details where login_username = ? AND login_password = ? AND login_role = ?");
			pst.setString(1, loginDetails.getUserName());
			pst.setString(2, loginDetails.getPassword());
			pst.setString(3, loginDetails.getRole());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				//System.out.println("Login id is "+rs.getInt(1));
				return 1;
			}
			logger.info("execute successfully");
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			e.printStackTrace();
		}
		return 0;
	}

}
