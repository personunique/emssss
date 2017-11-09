package com.cg.ems.testcases;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.BeforeClass;










import org.junit.Test;

import com.cg.ems.bean.AddressBean;
import com.cg.ems.bean.DepartmentBean;
import com.cg.ems.bean.DesignationBean;
import com.cg.ems.bean.EmployeeBean;
import com.cg.ems.exception.EMSException;
import com.cg.ems.service.AdminManagementServiceImpl;
import com.cg.ems.service.IAdminManagementService;
import com.cg.ems.ui.EMSOperation;

public class AddEmployeeTest {


	static IAdminManagementService adminServiceRef= null;
	static EMSOperation emsOp= null;
	static DepartmentBean deptBean = null;
	static DesignationBean designBean = null;
	static EmployeeBean empBean = null;
	static AddressBean addBean = null;
	
	@BeforeClass
	public static void initialize() {
		emsOp = new EMSOperation();
		adminServiceRef = new AdminManagementServiceImpl();
		deptBean =new DepartmentBean();
		empBean =new EmployeeBean();
		addBean = new AddressBean();
		designBean = new DesignationBean();
		
	}
	
	@Test
	public void validateObj(){
		assertNotNull(emsOp);
		assertNotNull(adminServiceRef);
		assertNotNull(deptBean);
		assertNotNull(empBean);
		assertNotNull(addBean);
		assertNotNull(designBean);
		
	}
	
	
	@Test
	public void validateEmployee() {
		
		empBean.setFirstName("Govind");
		empBean.setLastName("Prajapti");
		
		String df="09/Mar/2017";
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		    LocalDate datef = LocalDate.parse(df, formatter);
		   Date df1 = Date.valueOf(datef);
		empBean.setDateOfJoining(df1);
		
		String dt="09/Mar/1995";
		  LocalDate datet = LocalDate.parse(dt, formatter);
		 Date dt1 = Date.valueOf(datet);
		empBean.setDateOfJoining(dt1);
		
		
		empBean.setDeptId(11);
		empBean.setDesignationId(1002);
		empBean.setSalary(51000);
		empBean.setGrade("M3");
		empBean.setGender("Female");
		empBean.setMartialStatus("Single");
		empBean.setAddressId(100);
		
		String cn="7845124578";
		long contactNo=Long.parseLong(cn);
		empBean.setContactNo(contactNo);
		
		
	}
	
	
	@Test
	public void validateInsert(){
		try {
			empBean= adminServiceRef.addEmployeeDetails(empBean);
		} catch (EMSException e) {
			e.printStackTrace();
		}
		assertNotNull(empBean);
	}
	
	
	
}
