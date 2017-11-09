package com.cg.ems.ui;



import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ems.bean.LoginDetailsBean;
import com.cg.ems.exception.EMSException;
import com.cg.ems.service.ILoginService;
import com.cg.ems.service.LoginServiceImpl;

public class EmployeeManagementSystemUI {
	static Logger logger=Logger.getRootLogger();
	public EmployeeManagementSystemUI()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static void main(String[] args) throws EMSException {
		
		ILoginService is = new LoginServiceImpl();
		EMSOperation emsOp = new EMSOperation();
		LoginDetailsBean loginDetails = new LoginDetailsBean();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee Management System");
		System.out.println("******************************");
		while(true)
		{
		System.out.println("1.Login");
		System.out.println("2.Exit");
		System.out.println("\nEnter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		System.out.println("\nLogin");
		System.out.println("Enter Username");
		loginDetails.setUserName(sc.next());
		System.out.println("Enter Password");
		loginDetails.setPassword(sc.next());
		System.out.println("Enter your role Admin or Employee");
		String role=sc.next();
		loginDetails.setRole(role);
		
		int valid  = is.validateLogin(loginDetails);
		
		if(valid == 1 && role.equals("Admin"))
		{
			emsOp.showOptionsOfAdmin();
		}
		else if(valid == 1 && role.equals("Employee"))
		{
			emsOp.showOptionsOfEmployee();
		}
		else
			logger.error("error occured");
			System.out.println("\nWrong User Name and Password");
		break;
		
		case 2:
			System.out.println("Thank You");
			System.exit(0);
			break;
		}
	
		}
		
	}
}
