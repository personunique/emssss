package com.cg.ems.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ems.bean.LoginDetailsBean;
import com.cg.ems.service.ILoginService;
import com.cg.ems.service.LoginServiceImpl;

public class LoginTest {

	
	static ILoginService is = null;
	static LoginDetailsBean loginDetails = null;
	
	
	@BeforeClass
	public static void initialize() {
		is = new LoginServiceImpl();
		loginDetails = new LoginDetailsBean();
	}
	
	@Test
	public void validateAdmin() {
		loginDetails.setUserName("Admin");
		loginDetails.setPassword("Admin");
		loginDetails.setRole("Admin");	
		assertSame(1,is.validateLogin(loginDetails));	
	}
	
	@Test
	public void validateEmployee() {
		loginDetails.setUserName("Aditi");
		loginDetails.setPassword("Aditi");
		loginDetails.setRole("Employee");	
		assertSame(1,is.validateLogin(loginDetails));	
	}
	
	
			
}
