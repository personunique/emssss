package com.cg.ems.dao;

import java.util.ArrayList;

import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.exception.EMSException;

public interface IEmployeeManagementDAO {

	
	EmployeeBean getEmployeeDetailsBasedOnId(int empId) throws EMSException;

	ArrayList<EmployeeBean> getAllEmpoyeeDetails() throws EMSException;
	
	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(String firstName) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(String lastname) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(String deptName) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String grade) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(
			String marStatus)throws EMSException;

	DepartmentBean giveDeptName(int deptId) throws EMSException;

	DesignationBean giveDesigName(int desigId) throws EMSException;

	
}
