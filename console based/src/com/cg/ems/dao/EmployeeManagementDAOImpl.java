package com.cg.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dbconfig.DbUtil;
import com.cg.ems.exception.EMSException;

public class EmployeeManagementDAOImpl implements IEmployeeManagementDAO{

	Connection conn=null;
	Logger logger=Logger.getRootLogger();
	public EmployeeManagementDAOImpl()
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	@Override
	public EmployeeBean getEmployeeDetailsBasedOnId(int empId) throws EMSException {
		
		EmployeeBean empB = new EmployeeBean();
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where Emp_Id = ?");
				pst.setInt(1, empId);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptId(rs.getInt(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				System.out.println(empB);
				logger.info("execute successfully");
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			e.printStackTrace();
		}
		return empB;
	}

	
	@Override
	public ArrayList<EmployeeBean> getAllEmpoyeeDetails() throws EMSException {
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		EmployeeBean empB =null;
		try {
			Connection con = DbUtil.getConnection();
			String query = "select * from Employee_table";
			Statement st = con.createStatement();

			
 			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				empB = new EmployeeBean();
				
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptId(rs.getInt(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				//System.out.println(empB);
				empBeanList.add(empB);
				logger.info("execute successfully");
			}
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			e.printStackTrace();
		}
		return empBeanList;
	}

	

	
	
	// Employee Method
	
	
	
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnFirstName(
			String firstName) throws EMSException{
		
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_firstname = ?");
				pst.setString(1, firstName);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptId(rs.getInt(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
				logger.info("execute successfully");
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			e.printStackTrace();
		}
		return empBeanList;
	}

	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnLastName(
			String lastname) throws EMSException{
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_lastname = ?");
				pst.setString(1, lastname);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptId(rs.getInt(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
				logger.info("execute successfully");
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			e.printStackTrace();
		}
		return empBeanList;
	}

	
	
	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnDepartment(
			String deptName) throws EMSException {
		ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		int dId = 0;
		Connection con;
		try {
			con = DbUtil.getConnection();
			PreparedStatement deptIdQuery = con.prepareStatement("select department_id from Department_table where department_Name = ?");
			deptIdQuery.setString(1, deptName);
			ResultSet rst = deptIdQuery.executeQuery();
			if(rst.next()){
				dId = rst.getInt(1);
			}
			
			
			
					PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_dept_id = ?");
						pst.setInt(1, dId);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						empB= new EmployeeBean();
						empB.setEmpId(rs.getInt(1));
						empB.setFirstName(rs.getString(2));
						empB.setLastName(rs.getString(3));
						empB.setDateOfJoining(rs.getDate(4));
						empB.setDateOfBirth(rs.getDate(5));
						empB.setDeptId(rs.getInt(6));
						empB.setDesignationId(rs.getInt(7));
						empB.setGrade(rs.getString(8));
						empB.setGender(rs.getString(9));
						empB.setSalary(rs.getLong(10));
						empB.setMartialStatus(rs.getString(11));
						empB.setAddressId(rs.getInt(12));
						empB.setContactNo(rs.getLong(13));
						empBeanList.add(empB);
						logger.info("execute successfully");
			
					}
			
			
		} catch (IOException | SQLException e1) {

			logger.error("error occured");
			e1.printStackTrace();
		}
		
		
		return empBeanList;
	
	}

	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnGrade(String grade) throws EMSException{
ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_grade = ?");
				pst.setString(1, grade);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptId(rs.getInt(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
				logger.info("execute successfully");
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			e.printStackTrace();
		}
		return empBeanList;
	}

	@Override
	public ArrayList<EmployeeBean> getEmployeeDetailsBasedOnMaritalStatus(
			String marStatus) throws EMSException{
ArrayList<EmployeeBean> empBeanList = new ArrayList<EmployeeBean>();
		
		EmployeeBean empB;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from Employee_table where emp_marital_status = ?");
				pst.setString(1, marStatus);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				empB= new EmployeeBean();
				empB.setEmpId(rs.getInt(1));
				empB.setFirstName(rs.getString(2));
				empB.setLastName(rs.getString(3));
				empB.setDateOfJoining(rs.getDate(4));
				empB.setDateOfBirth(rs.getDate(5));
				empB.setDeptId(rs.getInt(6));
				empB.setDesignationId(rs.getInt(7));
				empB.setGrade(rs.getString(8));
				empB.setGender(rs.getString(9));
				empB.setSalary(rs.getLong(10));
				empB.setMartialStatus(rs.getString(11));
				empB.setAddressId(rs.getInt(12));
				empB.setContactNo(rs.getLong(13));
				empBeanList.add(empB);
				logger.info("execute successfully");
			}
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			e.printStackTrace();
		}
		return empBeanList;
	}
	@Override
	public DepartmentBean giveDeptName(int deptId) throws EMSException {
		
		DepartmentBean deptB = new DepartmentBean();
		
		Connection con;
		try {
			con = DbUtil.getConnection();
			String query = "select * from department_table where Department_id = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, deptId);
 			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				deptB.setDeptId(rs.getInt(1));
				deptB.setDeptName(rs.getString(2));
			}
		//System.out.println("In dao Layer"+deptB);
		logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		
	
	
	return deptB;
}
	@Override
	public DesignationBean giveDesigName(int desigId) throws EMSException {
		DesignationBean desigB = new DesignationBean();
		
		Connection con;
		try {
			con = DbUtil.getConnection();
			String query = "select * from designation_table where Designation_id = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, desigId);
 			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				desigB.setDesigId(rs.getInt(1));
				desigB.setDesigName(rs.getString(2));
			}
		//System.out.println("In dao Layer"+desigB);
		logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		
	
		//System.out.println("in DAO"+desigB);
	return desigB;
	}
}

