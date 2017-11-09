package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.exception.EMSException;

public interface IEmployeeManagementService {

	EmployeeBean getEmployeeDetailsBasedOnId(int empid) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(String string) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(String string) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(String string) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String string) throws EMSException;

	ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(String string) throws EMSException;

	ArrayList<EmployeeBean> getAllEmployeeDetails() throws EMSException;

	boolean validateValue(String choice);

	DepartmentBean giveDeptName(int deptId) throws EMSException;

	DesignationBean giveDesigName(int desigId) throws EMSException;

	
}
