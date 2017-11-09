package com.cg.ems.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.exception.EMSException;

public interface IAdminManagementService {

	
	EmployeeBean addEmployeeDetails(EmployeeBean empBean) throws EMSException;

	EmployeeBean getEmployeeDetailsBasedOnId(int empid) throws EMSException;

	ArrayList<EmployeeBean> getAllEmployeeDetails() throws EMSException;

	int updateFirstName(String fName, int empId) throws EMSException;

	int updateLastName(String lName, int empId) throws EMSException;

	int updateDepartmentName(int deptId2, int deptId) throws EMSException;

	int updateDesignationName(int desigId, int empId) throws EMSException;

	int updateSalary(String salary, int empId) throws EMSException;

	int updateMaritalStatus(String marital, int empId) throws EMSException;

	int updateHomeAddr(AddressBean addr, int empId) throws EMSException;

	int updateContactNumber(String contactNum, int empId) throws EMSException;

	DepartmentBean getDepartmentDetailsById(int deptId) throws EMSException;

	DesignationBean getDesignationDetails(int desigId) throws EMSException;
	
	public boolean validatedate(LocalDate df1,LocalDate dt1);
	public long calculateAge(LocalDate dateOfBirth);
	public boolean validateEmpId(int empId);
	public boolean validateEmpId1(int empId);
	public boolean validateFname(String FirstName);
	public boolean validateFName(String FirstName);
	public boolean validateLname(String LastName);
	public boolean validateLName(String LastName);
	public boolean validateSalary(long salary);
	public boolean validateAge(long age);
	//public boolean validateMaritalStatus(String martialStatus) throws EMSException;
	AddressBean insertAddress(AddressBean addB) throws EMSException;

	DesignationBean insertDesignation(DesignationBean desigB) throws EMSException;

	DepartmentBean insertDepartment(DepartmentBean deptB) throws EMSException;
	public String obtaingrade(long salary) throws EMSException;

	int isDeptNameExist(String deptName);

	int isDesigNameExist(String desigName);
	
	
}
