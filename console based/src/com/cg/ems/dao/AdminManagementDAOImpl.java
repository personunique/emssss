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

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.dbconfig.DbUtil;
import com.cg.ems.exception.EMSException;

public class AdminManagementDAOImpl implements IAdminManagementDAO{
	Connection conn=null;
	Logger logger=Logger.getRootLogger();
	public AdminManagementDAOImpl()
	{
		PropertyConfigurator.configure("log4j.properties");
	}

	@Override
	public void addEmployeeDetails(EmployeeBean empBean) throws EMSException {
		try {
			//System.out.println(empBean);
			Connection con = DbUtil.getConnection();
			PreparedStatement pst = con.prepareStatement("INSERT INTO Employee_table VALUES(empl_table_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, empBean.getFirstName());
			pst.setString(2, empBean.getLastName());
			pst.setDate(3, empBean.getDateOfJoining());
			pst.setDate(4, empBean.getDateOfBirth());
			pst.setInt(5, empBean.getDeptId());
			pst.setInt(6, empBean.getDesignationId());
			pst.setString(7, empBean.getGrade());
			pst.setString(8, empBean.getGender());
			pst.setLong(9,empBean.getSalary());
			pst.setString(10, empBean.getMartialStatus());
			pst.setInt(11, empBean.getAddressId());
			pst.setLong(12, empBean.getContactNo());
			
			int noOfRows = pst.executeUpdate();
			if(noOfRows > 0)
			{
				int empId = 0;
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select empl_table_seq.currval from Employee_table");
				while(rs.next()){
					empId = rs.getInt(1);
				}
				
				if(empId > 0){
				String username = empBean.getFirstName();
				String password = empBean.getDeptId()+empBean.getGrade();
				
				String insertLoginDetails ="insert into login_details values(login_seq.nextval,?,?,'Employee',?)"; 
				PreparedStatement ps = con.prepareStatement(insertLoginDetails);
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setInt(3,empId);
				
					int update = ps.executeUpdate();
					if(update>0){
						System.out.println("Data Inserted SuccessFully \n Registered Successfully :::\n");
						System.out.println("Your UserName :: "+username);

						System.out.println("Your Password :: "+password);

						System.out.println("Your Role :: Employee");
					}
				}
				
			}
			else
				System.out.println("Failed");
			logger.info("execute successfully");
			
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
			
		}
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
			}
			logger.info("execute successfully");
			//System.out.println("Result is "+rs);
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			System.out.println(e.getMessage());
			throw new EMSException(e.getMessage());
			
		}
		return empB;
	}

	
	@Override
	public ArrayList<EmployeeBean> getAllEmpoyeeDetails() throws EMSException{
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
			throw new EMSException("ERROR" +e.getMessage());
		}
		return empBeanList;
	}

	
	
	/**************************** Update Methods ********************************/
	@Override
	public int updateFirstName(String fName, int empId) throws EMSException {
		int result = 0;
		try {
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Employee_table SET emp_firstName = ? WHERE Emp_id = ?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setString(1, fName);
			pst.setInt(2, empId);
			result = pst.executeUpdate();
			logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
	}

	@Override
	public int updateLastName(String lName, int empId) throws EMSException {
		int result = 0;
		try {
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Employee_table SET emp_lastName = ? WHERE Emp_id = ?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setString(1, lName);
			pst.setInt(2, empId);
			result = pst.executeUpdate();
			logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
	}

	@Override
	public int updateDepartmentName(int deptId, int employeeId) throws EMSException{
		int result = 0;
		try {
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Employee_table SET emp_dept_id = ? WHERE emp_id = ?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setInt(1, deptId);
			pst.setInt(2, employeeId);
			result = pst.executeUpdate();
			
			logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
	}

	@Override
	public int updateDesignationName(int desigId, int employeeId) throws EMSException {
		int result = 0;
		try {
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Employee_table SET emp_designation_id = ? WHERE emp_id = ?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setInt(1, desigId);
			pst.setInt(2, employeeId);
			result = pst.executeUpdate();
			
			logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
	}

	@Override
	public int updateSalary(String salary, int empId) throws EMSException{
		int result = 0;
		try {
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Employee_table SET emp_Salary = ? WHERE Emp_id = ?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setString(1, salary);
			pst.setInt(2, empId);
			result = pst.executeUpdate();
			logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
	}

	@Override
	public int updateMaritalStatus(String marital, int empId) throws EMSException {
		int result = 0;
		try {
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Employee_table SET emp_marital_status = ? WHERE Emp_id = ?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setString(1, marital);
			pst.setInt(2, empId);
			result = pst.executeUpdate();
			logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
	}

	@Override
	public int updateHomeAddr(AddressBean addr, int addressId)throws EMSException {
		int result = 0;
		try {
		//System.out.println("in dao "+addr);
		//System.out.println("in dao "+addressId);
			
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Address_table SET door_number=?,street=?,landmark=?,area=?,pincode=?,district=?,state=? WHERE Address_id=?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setInt(1, addr.getDoorNo());
			pst.setString(2, addr.getStreet());
			pst.setString(3, addr.getLandmark());
			pst.setString(4, addr.getArea());
			pst.setInt(5,addr.getPincode());
			pst.setString(6, addr.getDistrict());
			pst.setString(7, addr.getState());
			pst.setInt(8, addressId);
			result = pst.executeUpdate();
			
			
		//System.out.println("from dao "+result);
		
		logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
		
	}

	@Override
	public int updateContactNumber(String contactNum, int empId) throws EMSException{
		int result = 0;
		try {
			Connection con = DbUtil.getConnection();
			
			String updateQ = "UPDATE Employee_table SET emp_contact = ? WHERE Emp_id = ?";
			PreparedStatement pst = con.prepareStatement(updateQ);
			pst.setString(1, contactNum);
			pst.setInt(2, empId);
			result = pst.executeUpdate();
			logger.info("execute successfully");
		} catch (IOException | SQLException e) {
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
		return result;
	}

	@Override
	public DepartmentBean getDepartmentDetails(int deptId) throws EMSException{
	
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
	public DesignationBean getDesignationDetails(int desigId) throws EMSException{
	
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
			
		
		
		return desigB;
	}

	
	@Override
	public DepartmentBean insertDepartment(DepartmentBean db) throws EMSException{
		int dId = 0;
		int value=0;
		Connection con;
		try {
			con = DbUtil.getConnection();
			PreparedStatement deptIdQuery = con.prepareStatement("insert into Department_table values(deptId_seq.nextval,?)");
			deptIdQuery.setString(1, db.getDeptName());
			
			value = deptIdQuery.executeUpdate();
			if(value > 0)
			{
			Statement st = con.createStatement();
			
			ResultSet rsp=st.executeQuery("Select deptId_seq.currval from dual");
			while(rsp.next())
				{
					dId=rsp.getInt(1);
					
				}
			
			db.setDeptId(dId);
			}
			logger.info("execute successfully");
		} 
		catch (IOException | SQLException e) 
		{
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
	
		return db;
}
	
	@Override
	public int isDeptNameExist(String deptName) {
		Connection con;
		int dId3 = 0;
		 
		try {
			con = DbUtil.getConnection();
			
			String isExist = "Select department_id from department_table where department_name = (?)";
			
			PreparedStatement pst = con.prepareStatement(isExist);
			pst.setString(1, deptName);
			
			ResultSet rsp=pst.executeQuery();
			
			
			while(rsp.next()) 
			{
				dId3 = rsp.getInt(1);
			}
			
			//System.out.println("in DAO Layer"+dId3);
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dId3;

		
	}
	
	
	
	@Override
	public DesignationBean insertDesignation(DesignationBean db1) throws EMSException{
		int dId1 = 0;
		int value=0;
		Connection con;
		try {
			con = DbUtil.getConnection();
			PreparedStatement desigIdQuery = con.prepareStatement("insert into Designation_table values(desigId_seq.nextval,?)");
			desigIdQuery.setString(1, db1.getDesigName());
			
			value = desigIdQuery.executeUpdate();
			if(value > 0)
			{
			Statement st = con.createStatement();
			
			ResultSet rsp=st.executeQuery("Select desigId_seq.currval from dual");
			while(rsp.next())
				{
					dId1=rsp.getInt(1);
					
				}
			
			db1.setDesigId(dId1);
			}
			logger.info("execute successfully");
		} 
		catch (IOException | SQLException e) 
		{
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
	
		return db1;
	}


	@Override
	public int isDesigNameExist(String desigName) {
		Connection con;
		int dId4 = 0;
		 
		try {
			con = DbUtil.getConnection();
			
			String isExist = "Select designation_id from designation_table where designation_name = (?)";
			
			PreparedStatement pst = con.prepareStatement(isExist);
			pst.setString(1, desigName);
			
			ResultSet rsp=pst.executeQuery();
			
			
			while(rsp.next()) 
			{
				dId4 = rsp.getInt(1);
			}
			
			//System.out.println("in DAO Layer"+dId4);
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dId4;
	}
	
	@Override
	public AddressBean insertAddress(AddressBean db2) throws EMSException {
		int dId2 = 0;
		int value=0;
		Connection con;
		try {
			con = DbUtil.getConnection();
			PreparedStatement addIdQuery = con.prepareStatement("insert into Address_table values(add_seq.nextval,?,?,?,?,?,?,?)");
			addIdQuery.setInt(1, (db2.getDoorNo()));
			addIdQuery.setString(2, db2.getStreet());
			addIdQuery.setString(3, db2.getLandmark());
			addIdQuery.setString(4, db2.getArea());
			addIdQuery.setInt(5, db2.getPincode());
			addIdQuery.setString(6, db2.getDistrict());
			addIdQuery.setString(7, db2.getState());
			
			
			value = addIdQuery.executeUpdate();
			if(value > 0)
			{
			Statement st = con.createStatement();
			
			ResultSet rsp=st.executeQuery("Select add_seq.currval from dual");
			while(rsp.next()) 
				{
					dId2=rsp.getInt(1);
					
				}
			
			db2.setAddressId(dId2);
			}
			logger.info("execute successfully");
		} 
		catch (IOException | SQLException e) 
		{
			logger.error("error occured");
			throw new EMSException("ERROR" +e.getMessage());
		}
	
		return db2;
	}

	
	
	
}
