package com.cg.ems.dao;

import java.util.ArrayList;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.exception.EMSException;

public interface IAdminManagementDAO {

	void addEmployeeDetails(EmployeeBean empBean) throws EMSException;

	EmployeeBean getEmployeeDetailsBasedOnId(int empId) throws EMSException;

	ArrayList<EmployeeBean> getAllEmpoyeeDetails() throws EMSException;

	int updateFirstName(String fName, int empId) throws EMSException;

	int updateLastName(String lName, int empId) throws EMSException;

	int updateDepartmentName(int deptId2, int deptId) throws EMSException;

	int updateDesignationName(int desigId, int empId) throws EMSException;

	int updateSalary(String salary, int empId) throws EMSException;

	int updateMaritalStatus(String marital, int empId) throws EMSException;

	int updateHomeAddr(AddressBean addr, int empId) throws EMSException;

	int updateContactNumber(String contactNum, int empId) throws EMSException;

	DepartmentBean getDepartmentDetails(int deptId) throws EMSException;

	DepartmentBean insertDepartment(DepartmentBean deptB) throws EMSException;

	DesignationBean insertDesignation(DesignationBean desigB) throws EMSException;

	AddressBean insertAddress(AddressBean addB) throws EMSException;

	int isDeptNameExist(String deptName);

	int isDesigNameExist(String desigName);

	DesignationBean getDesignationDetails(int desigId) throws EMSException;
	


	
}
