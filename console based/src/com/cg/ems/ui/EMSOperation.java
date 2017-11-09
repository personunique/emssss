package com.cg.ems.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.exception.EMSException;
import com.cg.ems.service.AdminManagementServiceImpl;
import com.cg.ems.service.EmployeeManagementServiceImpl;
import com.cg.ems.service.IAdminManagementService;
import com.cg.ems.service.IEmployeeManagementService;


public class EMSOperation{
	
	Scanner sc = new Scanner(System.in);
	EmployeeBean employee = new EmployeeBean();
	IAdminManagementService adminServiceRef = new AdminManagementServiceImpl();
	IEmployeeManagementService empServiceRef = new EmployeeManagementServiceImpl();
	ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
	
	
	
	void displayEmployeeListDetails(ArrayList<EmployeeBean> empBeanList) throws EMSException{
		
		
		if(empBeanList != null && empBeanList.isEmpty())
		{
				System.out.println("Not exist");
		}
		
		else
		{
			System.out.println("ID  || FirstName || LastName  || Department || Grade || Designation \n");
			
			for(EmployeeBean beanEmp :empBeanList){
				int deptId=beanEmp.getDeptId();
				DepartmentBean deptBean= empServiceRef.giveDeptName(deptId);
				//System.out.println("in UI"+);
				
				int desigId=beanEmp.getDesignationId();
				DesignationBean desigBean= empServiceRef.giveDesigName(desigId);
				
				//System.out.println(deptBean.getDeptName());
				//System.out.println(desigBean.getDesigName());
				
				
				System.out.println(beanEmp.getEmpId()+" || "+beanEmp.getFirstName()+" || "+beanEmp.getLastName()+" || "+deptBean.getDeptName()+" || "+beanEmp.getGrade()+" || "+desigBean.getDesigName());
				
				
	}
		}
	}

	void displayEmployeeDetails(EmployeeBean beanEmp) throws EMSException{
		if(beanEmp.getFirstName()!=null)
		{
		System.out.println("ID  || FirstName || LastName  || Department || Grade || Designation \n");
		int deptId=beanEmp.getDeptId();
		DepartmentBean deptBean= empServiceRef.giveDeptName(deptId);
		//System.out.println("in UI"+);
		
		int desigId=beanEmp.getDesignationId();
		DesignationBean desigBean= empServiceRef.giveDesigName(desigId);
		
		//System.out.println(deptBean.getDeptName());
		//System.out.println(desigBean.getDesigName());
		
		
		System.out.println(beanEmp.getEmpId()+" || "+beanEmp.getFirstName()+" || "+beanEmp.getLastName()+" || "+deptBean.getDeptName()+" || "+beanEmp.getGrade()+" || "+desigBean.getDesigName());
		
		
		}
		else
		{
			System.out.println("ID does not Exist");
		}
	}
	
	
	
	
	
	
	public void showOptionsOfEmployee() throws EMSException {
		
		while(true)
		{
		System.out.println("\n\n----------:: Welcome ::-------- ");
		System.out.println("1.Search based on Employee ID");
		System.out.println("2.Search based on Employee's First name");
		System.out.println("3.Search based on Employee's Last name");
		System.out.println("4.Search based on Department ID");
		System.out.println("5.Search based on Employee's grade");
		System.out.println("6.Search based on Employee's marital status");
		System.out.println("7.Get All Employee");
		System.out.println("8.Exit");
		System.out.println("What you want :");
		String choice=sc.next();
		 if (empServiceRef.validateValue(choice))
		 {
		
		
		switch(choice)
		{
		case "1":searchBasedOnID();
			    break;
		case "2":searchBasedOnFirstName();
				break;
		case "3":searchBasedOnLastname();
				break;
		case "4":searchBasedOnDepartmentID();
	    		break;
		case "5":searchBasedOnGrade();
				break;
		case "6":searchBasedOnMaritalStatus();
				break;
		case "7":getAllEmployeeDetails();
				break;
		case "8":System.out.println("Thank You");
			   System.exit(0);
		}
		}
		}
		
		}
		
	

	/*********************************************** User Operation 
	 * @throws EMSException **********************************************************/
	
	public void searchBasedOnFirstName() throws EMSException {
		System.out.println("Enter First name");
		String name=sc.next();
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnFirstName(name);
		displayEmployeeListDetails(empBeanList);
	}

	public void searchBasedOnMaritalStatus() throws EMSException {
		System.out.println("Enter Marital Status");
		String mstatus=sc.next();
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnMaritalStatus(mstatus);
		displayEmployeeListDetails(empBeanList);
	}

	public void searchBasedOnGrade() throws EMSException {
		System.out.println("Enter Grade");
		String grade=sc.next();
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnGrade(grade);
		displayEmployeeListDetails(empBeanList);
		
	}

	public void searchBasedOnDepartmentID() throws EMSException {
		System.out.println("Enter Department");
		String dept=sc.next();
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnDepartment(dept);
		displayEmployeeListDetails(empBeanList);
		
	}

	public void searchBasedOnLastname() throws EMSException {
		System.out.println("Enter Last name");
		String lname=sc.next();
		empBeanList = empServiceRef.getEmployeeDetailsBasedOnLastName(lname);
		displayEmployeeListDetails(empBeanList);
		
	}

	public void searchBasedOnID() throws EMSException {
		System.out.println("Enter ID");
		int ID=sc.nextInt();
		EmployeeBean empB = empServiceRef.getEmployeeDetailsBasedOnId(ID);
		displayEmployeeDetails(empB);
	}
		     

	public void getAllEmployeeDetails() throws EMSException {
		empBeanList = empServiceRef.getAllEmployeeDetails();
		displayEmployeeListDetails(empBeanList);
		
	}


	
	
	
	
	/*********************************************** Admin Operation 
	 * @throws EMSException **********************************************************/
	public void showOptionsOfAdmin() throws EMSException {
		while(true)
		{
		System.out.println("\n\n----------:: Welcome Admin ::-------- ");
		System.out.println("1.Add new Employee");
		System.out.println("2.Update Employee details");
		System.out.println("3.View all Employee");
		System.out.println("4.Search Employee"
				+ "\n5.Exit");
		System.out.println("\nWhat you want :");
		int option=sc.nextInt();
		
		switch(option)
		{
		case 1:addNewEmployee();
			    break;
		case 2:updateEmployeeDetails();
				break;
		case 3:viewAllEmployee();
				break;
		case 4:searchEmployee();
				break;
		case 5:
			System.out.println("Thank You");
			System.exit(0);
			break;
		}
		}
	}

	public void searchEmployee() throws EMSException{
		System.out.println("\n\nEmployee Details Based on Id\n\n Enter Id Of Employee to Search");
		int empId = sc.nextInt();
		
		EmployeeBean empB = null;
		try {
			empB = adminServiceRef.getEmployeeDetailsBasedOnId(empId);
		} catch (EMSException e) {
			
			System.out.println(e.getMessage());
		
		}
		
		
		displayEmployeeDetails(empB);
	}

	public void viewAllEmployee() throws EMSException {
		
		/****All Employee Details **/
		System.out.println("\n\nAll Employee Details");
		ArrayList<EmployeeBean> empBeanList = adminServiceRef.getAllEmployeeDetails();
		displayEmployeeListDetails(empBeanList);
		
	}

	public void updateEmployeeDetails() throws EMSException {

		System.out.println("\n\nEmployee Details Based on Id\n\n Enter Id Of Employee to Update");
		int empId = sc.nextInt();
		
		EmployeeBean empB = adminServiceRef.getEmployeeDetailsBasedOnId(empId);
		displayEmployeeDetails(empB);
		
		updateOptions(empB);
	}

	public void updateOptions(EmployeeBean empB) throws EMSException {
		int empId = empB.getEmpId();
		
		System.out.println("in update method "+empB);
		
		System.out.println("Option to Update Details "
				+ "\n1: Update First Name"
				+ "\n2: Update Last Name"
				+ "\n3: Update Department Name"
				+ "\n4: Update Designation"
				+ "\n5: Update Basic Salary"
				+ "\n6: Update Marital Status"
				+ "\n7: Update Home Address"
				+ "\n8: Update Contact Number\n ::::: Enter Your Choice :::::\n");
		int choice = sc.nextInt();
		switch(choice){
		case 1: {
				System.out.println("Enter First Name to Update\n");
				String fName = sc.next();
				int update = adminServiceRef.updateFirstName(fName,empId);
				if(update>0){
					System.out.println("First Name is Updated Successfully");
				}
				else
					System.out.println("Data is not updated successfully...");
		}
		break;
		
		case 2: {
			System.out.println("Enter Last Name to Update\n");
			String lName = sc.next();
			int update = adminServiceRef.updateLastName(lName,empId);
			if(update>0){
				System.out.println("Last Name is Updated Successfully");
			}
			else
				System.out.println("Data is not updated successfully...");
			
		}
		break;
	
		case 3:
		{ 
			System.out.println("Enter Department Name to Update\n");
		String dName = sc.next();
		
		
		int deptId = adminServiceRef.isDeptNameExist(dName);	
		System.out.println("Department Id is "+deptId);
		if(deptId >0){
			
			int employeeId = empB.getEmpId();
			int update = adminServiceRef.updateDepartmentName(deptId,employeeId);
			if(update>0){
				
				System.out.println("Department Name is Updated Successfully");
				System.out.println("New Department Details "+update);

			}
			else
				System.out.println("Data is not updated successfully...");

			
			
		}
		else
			System.out.println("Department Name is Not Exist in Database");
		
			}
	break;
	
	
		case 4: {
			System.out.println("Enter Designation Name to Update\n");
			String desigName = sc.next();
		
			
			int desigId = adminServiceRef.isDesigNameExist(desigName);	
			System.out.println("Department Id is "+desigId);
			if(desigId >0){
				
				int employeeId = empB.getEmpId();
				int update = adminServiceRef.updateDesignationName(desigId,employeeId);
				if(update>0){
					
					System.out.println("Designation Name is Updated Successfully");
					System.out.println("New Designation Details "+update);

				}
				else
					System.out.println("Data is not updated successfully...");

				
				
			}
			else
				System.out.println("Designation Name is Not Exist in Database");
			
			/*
			DesignationBean designB = new DesignationBean();
			
			int desigId = empB.getDesignationId();
			
			designB.setDesigId(desigId);
			
			
			int update =adminServiceRef.updateDesignationName(desigName,desigId);
			
			if(update>0){
				System.out.println("Designation Name is Updated Successfully");
			}
			else
				System.out.println("Data is not updated successfully...");*/
		}
		break;
	
		case 5: {
			System.out.println("Enter Basic Salary to Update\n");
			String salary = sc.next();
			int update =adminServiceRef.updateSalary(salary,empId);
			if(update>0){
				System.out.println("Basic Salary is Updated Successfully");
			}
			else
				System.out.println("Data is not updated successfully...");
		}
		break;
		
		case 6: {
			System.out.println("Enter Marital Status to Update\n");
			String marital = sc.next();
			int update =adminServiceRef.updateMaritalStatus(marital,empId);
			if(update>0){
				System.out.println("Marital Status is Updated Successfully");
			}
			else
				System.out.println("Data is not updated successfully...");
		}
		break;
		
		case 7: {
			AddressBean bean=new AddressBean();
			System.out.println("Enter Home Address to Update\n");
			int addressId = empB.getAddressId();
			bean.setAddressId(addressId);
			System.out.println("Enter Door No ::");
			int doorNo = sc.nextInt();
			sc.nextLine();
			bean.setDoorNo(doorNo);
			System.out.println("Enter Street ::");
			String street = sc.nextLine();
			bean.setStreet(street);
			System.out.println("Enter Landmark ::");
			String landmark = sc.nextLine();
			bean.setLandmark(landmark);
			System.out.println("Enter Area ::");
			String area =sc.nextLine();
			bean.setArea(area);
			System.out.println("Enter Pincode ::");
			int pincode = sc.nextInt();
			sc.nextLine();
			bean.setPincode(pincode);
			System.out.println("Enter District ::");
			String district = sc.nextLine();
			bean.setDistrict(district);
			System.out.println("Enter State");
			String state = sc.nextLine();
			bean.setState(state);
			AddressBean addr = new AddressBean(addressId,doorNo,street,landmark,area,pincode,district,state);
		
			int update =adminServiceRef.updateHomeAddr(addr,addressId);
			if(update>0){
				System.out.println("Home Address is Updated Successfully");
			}
			else
				System.out.println("Data is not updated successfully...");
		}
		break;
		
		
		case 8: {
			System.out.println("Enter Contact Number to Update\n");
			String contactNum = sc.next();
			int update =adminServiceRef.updateContactNumber(contactNum,empId);
			if(update>0){
				System.out.println("Contact Number is Updated Successfully");
			}
			else
				System.out.println("Data is not updated successfully...");
		}
		break;
		
		}
		
		
		
	}

	public void addNewEmployee() throws EMSException {
IAdminManagementService service=new AdminManagementServiceImpl();

		
		EmployeeBean employee = new EmployeeBean();	
		System.out.println("\nEnter Employee's first name:");
		sc.nextLine();
		String FirstName=sc.nextLine();
		employee.setFirstName(FirstName);

		if(service.validateFname(FirstName))
		{
			
		if(service.validateFName(FirstName))
		{
		
		
		System.out.println("\nEnter Employee's last name:");
	
		String LastName=sc.nextLine();
		employee.setLastName(LastName);
		if(service.validateLname(LastName))
		{
		if(service.validateLName(LastName))
		{
		
			
		
		System.out.println("\nEnter Employee's date Of joining: dd/MMM/yyyy : ");
		String df = sc.next();
		System.out.println("\nEnter Employee's date Of Birth: dd/MMM/yyyy : ");
		String dt = sc.next();
		
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		    LocalDate datef = LocalDate.parse(df, formatter);
		    LocalDate datet = LocalDate.parse(dt, formatter); 
		
		    Date df1 = Date.valueOf(datef);
		    Date dt1 = Date.valueOf(datet);
		    employee.setDateOfBirth(dt1);
			employee.setDateOfJoining( df1);
	
			if(service.validatedate(datef,datet))
			{
				
				
	long age=service.calculateAge(datet);
			
	if(service.validateAge(age))
			{
		
		
			
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateOfJoining = LocalDate.parse(d1,formatter);
		Date doj = Date.valueOf(dateOfJoining);
		if(service.validateDate(dateOfJoining))
		{
		*/
		
		/*LocalDate dateOfBirth = LocalDate.parse(d2,formatter);
		Date dob = Date.valueOf(dateOfBirth);*/
		
		
		System.out.println("Enter Department Name:");
		String deptName=sc.next();
		
		
		int deptid  = adminServiceRef.isDeptNameExist(deptName);
		//System.out.println(deptid);

		DepartmentBean deptB = new DepartmentBean();
		deptB.setDeptName(deptName);
		int deptid1=isDeptNameExist(deptName);
	
		
		int deptID = 0;
		
		if(deptid1 > 0)
		{
			//System.out.println("In If Dept Id"+deptid1);
			deptB.setDeptId(deptid1);
			employee.setDeptId(deptid1);
		}
		
		if(deptid1 == 0)
		{
		
			deptB = adminServiceRef.insertDepartment(deptB);
		
			if(deptB.getDeptId() >0){
				deptID =deptB.getDeptId();
				employee.setDeptId(deptID);
				//System.out.println("Dept Id"+deptID);
			}
		}
		
		System.out.println("Enter Designation Name:");
		String desigName=sc.next();
		
		int desigid  = adminServiceRef.isDesigNameExist(desigName);
		//System.out.println(desigid);
		
		DesignationBean desigB = new DesignationBean();
		desigB.setDesigName(desigName);
		
		int desigid1=isDesigNameExist(desigName);
		int desigId = 0;
		
		if(desigid1 >0)
		{
			//System.out.println("Desig Id"+desigid1);
			desigB.setDesigId(desigid1);
			employee.setDesignationId(desigid1);
		}
		
		if(desigid1 == 0)
		{
			desigB = adminServiceRef.insertDesignation(desigB);
			
			if(desigB.getDesigId() >0)
			{
			desigId =desigB.getDesigId();
			employee.setDesignationId(desigId);
			//System.out.println("Desig Id"+desigId);
		
		}
			
		}
		
		
		System.out.println("\nEnter Employee's Salary:");
		Long salary=sc.nextLong();
		employee.setSalary(salary);
		
		String grade=service.obtaingrade(salary);
	
			
		employee.setGrade(grade);
	//	System.out.println(grade);
		System.out.println("\nEnter Gender:");
		String gender=sc.next();
		employee.setGender(gender);
		
		System.out.println("\nEnter martial Status:");
		String martialStatus=sc.next();
		//if(adminServiceRef.validateMaritalStatus(martialStatus));
		//{
		employee.setMartialStatus(martialStatus);
		
		
		AddressBean addB = new AddressBean();
		System.out.println("Enter door number:");
		int doorNo=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter street:");
		String street=sc.nextLine();
		
		System.out.println("Enter landmark:");
		String landmark=sc.nextLine();
		
		System.out.println("Enter Area:");
		String area=sc.nextLine();
		
		System.out.println("Enter pincode:");
		int pincode=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter district:");
		String district=sc.nextLine();
		
		System.out.println("Enter state:");
		String state=sc.nextLine();
		
		addB.setDoorNo(doorNo);
		addB.setStreet(street);
		addB.setLandmark(landmark);
		addB.setArea(area);
		addB.setPincode(pincode);
		addB.setDistrict(district);
		addB.setState(state);
		
		addB = adminServiceRef.insertAddress(addB);
		//System.out.println("Address Id is "+addB.getAddressId());
		
		
		int addId =0;
		if(addB.getAddressId()>0){
			addId =addB.getAddressId();
		}
		
		employee.setAddressId(addId);
		
		
		//System.out.println("Enter Address ID:");
		//int addressId=sc.nextInt();
		//employee.setAddressId(addressId);
	
		System.out.println("Enter Contact number:");
		long contactNo=sc.nextLong();
		employee.setContactNo(contactNo);	

		EmployeeBean emp= adminServiceRef.addEmployeeDetails(employee);
		//System.out.println(emp);
		//displayEmployeeDetails(emp);

		}
		
		
		}
		}
		}
		}
		}
		}
		//}


	private int isDesigNameExist(String desigName) {
		return adminServiceRef.isDesigNameExist(desigName);
	}


	private int isDeptNameExist(String deptName) {
		return adminServiceRef.isDeptNameExist(deptName);
	}
		
	}

	

