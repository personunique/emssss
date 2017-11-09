package com.cg.ems.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dao.AdminManagementDAOImpl;
import com.cg.ems.dao.IAdminManagementDAO;
import com.cg.ems.exception.EMSException;
import com.cg.ems.ui.EMSOperation;

public class AdminManagementServiceImpl implements IAdminManagementService{

	IAdminManagementDAO ied = new AdminManagementDAOImpl();
	

	@Override
	public EmployeeBean addEmployeeDetails(EmployeeBean empBean) throws EMSException {
		ied.addEmployeeDetails(empBean);
		return empBean; 
	}
	@Override
	public EmployeeBean getEmployeeDetailsBasedOnId(int empId) throws EMSException {
		return ied.getEmployeeDetailsBasedOnId(empId);
	}
	@Override
	public ArrayList<EmployeeBean> getAllEmployeeDetails() throws EMSException {
		return ied.getAllEmpoyeeDetails();
	}
	
	
	
	
	@Override
	public int updateFirstName(String fName, int empId) throws EMSException {
		return ied.updateFirstName(fName,empId);
	}
	@Override
	public int updateLastName(String lName, int empId) throws EMSException {
		return ied.updateLastName(lName,empId);
	}
	@Override
	public int updateDepartmentName(int deptId, int employeeId) throws EMSException {
		return ied.updateDepartmentName(deptId,employeeId);
	}
	@Override
	public int updateDesignationName(int desigId, int empId) throws EMSException {
		return ied.updateDesignationName(desigId,empId);
	}
	@Override
	public int updateSalary(String salary, int empId) throws EMSException {
		return ied.updateSalary(salary, empId);
	}
	@Override
	public int updateMaritalStatus(String marital, int empId) throws EMSException {
		return ied.updateMaritalStatus(marital,empId);
	}

	
	@Override
	public int updateContactNumber(String contactNum, int empId) throws EMSException {
		return ied.updateContactNumber(contactNum, empId);
	}
	@Override
	public DepartmentBean getDepartmentDetailsById(int deptId) throws EMSException {
		return ied.getDepartmentDetails(deptId);
	}
	
	
	public boolean validatedate(LocalDate df1,LocalDate dt1)
	{
		if(df1.compareTo(dt1)>0)
		{
			return true;
		}
		else
		{
			System.out.println("please enter valid date");
			return false;
		}
	}
	
	public long calculateAge(LocalDate dateOfBirth) {
		LocalDate currentDate=LocalDate.now();
        if ((dateOfBirth != null) && (currentDate != null)) 
        {
        	
        	
        	
        	//Years age=Years.yearsBetween(dateOfBirth,currentDate)
        	int Age=Period.between(dateOfBirth, currentDate).getYears();
        	//age.getYears();
        	
        	// long diffInYears = ChronoUnit.YEARS.between(dateOfBirth, currentDate);
        	
        	
        	//System.out.println(currentDate);
        	//System.out.println(Age);
        	//System.out.println("uhygjhg  "+diffInYears);
        	
            return Age;
        } 
        else 
        {
            return 0;
        }
    }
	
	
	public boolean validateEmpId(int empId)
	{
		String empId1=Integer.toString(empId);
	
		if(empId1.isEmpty()||empId1.equals(null))
		{ 
			
			
			System.out.println("This Field cannot be Empty");
			return false;
		}
		else
		{
			return true;
		}
		}
			
	public boolean validateEmpId1(int empId)
	{
		String empId1=Integer.toString(empId);
		String reg="[1-9]{1}[0-9]{5}";
		if (Pattern.matches(reg,empId1))
			{
		
					return true;
			}
		else
			{
				System.out.println("Please enter Valid Employee ID");
				return false;
			}
	}
		

	
	public boolean validateFname(String FirstName)
	{
		
		if(FirstName.isEmpty()||FirstName.equals(null))
		{ 
			
				
				System.out.println("This field cannot be empty");
				return false;
			}

		else
		{
			return true;
		}
	}
	
	public boolean validateFName(String FirstName)
	{
		String fnamePattern=
				"[a-zA-Z]*";
		if(Pattern.matches(fnamePattern,FirstName))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the Proper First Name");
			return false;
		}
		
	}
	
	public boolean validateLname(String LastName)
	{
		
		if(LastName.isEmpty()||LastName.equals(null))
		{ 
			
				
				System.out.println("This field cannot be empty");
				return false;
			}

		else
		{
			return true;
		}
	}
	
	public boolean validateLName(String LastName)
	{
		
		String lnamePattern=
				"[a-zA-Z]*";
		if(Pattern.matches(lnamePattern,LastName))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the Proper Last Name");
			return false;
		}
		
	}
	
	
	public boolean validateSalary(long salary)
	{
		String salary1=Long.toString(salary);
		String sal = String.valueOf(salary1);
		
		if(sal.isEmpty()||sal.equals(null))
		{
			System.out.println("This field cannot be Empty");
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean validateAge(long age) {
		if(age>=18 && age<=58)
		{
			return true;
		}
		else
		{
			System.out.println("Please enter valid Date of Birth. Age should be between 18 to 58");
			return false;
		}
	}
	@Override
	public AddressBean insertAddress(AddressBean db) throws EMSException {
		return  ied.insertAddress(db);
	}
	@Override
	public DesignationBean insertDesignation(DesignationBean db1) throws EMSException {
		return  ied.insertDesignation(db1);
	}
	@Override
	public DepartmentBean insertDepartment(DepartmentBean db2) throws EMSException {
		return ied.insertDepartment(db2);
	}
	@Override
	public int updateHomeAddr(AddressBean addr, int empId) throws EMSException {
	
			return ied.updateHomeAddr(addr,empId);
	}
	
	public String obtaingrade(long salary) throws EMSException {
		String grade=null;
		if(salary>10000 && salary<=20000)
		{
			 grade="M7";
		}
		else if(salary>20000 && salary<=30000)
		{
			 grade="M6";
		}
		else if(salary>30000 && salary<=40000)
		{
			 grade="M5";
		}
		else if(salary>40000 && salary<=50000)
		{
			 grade="M4";
		}
		else if(salary>50000 && salary<=60000)
		{
			 grade="M3"; 
		}
		else if(salary>60000 && salary<=70000)
		{
			 grade="M2"; 
		}
		else if(salary>=70000)
		{
			grade="M1";
		}
		else 
		{
			System.out.println("Salary is out of band");
			System.exit(0);
		}
		return grade;
	}
	
	
	/*public boolean validateMaritalStatus(String martialStatus) throws EMSException {
	     String ms=null;
		if(martialStatus=="Single")
			// || martialStatus=="Married" || martialStatus=="Divorced" || martialStatus=="Separated" || martialStatus=="Widowed"
		{
			return true;
		}
		else
		{
			System.out.println("Please enter valid marital status");
			System.exit(0);
			return false;
		}
	}*/
	
	@Override
	public int isDeptNameExist(String deptName) {
		return ied.isDeptNameExist(deptName);
	}
	@Override
	public int isDesigNameExist(String desigName) {
		return ied.isDesigNameExist(desigName);
	}
	@Override
	public DesignationBean getDesignationDetails(int desigId)
			throws EMSException {
		// TODO Auto-generated method stub
		return ied.getDesignationDetails(desigId);
	}
}
