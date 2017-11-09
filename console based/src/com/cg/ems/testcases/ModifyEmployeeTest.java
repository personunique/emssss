package com.cg.ems.testcases;

import static org.junit.Assert.*;

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

public class ModifyEmployeeTest {

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
	public void validateUpdate(){
		
		try {
			empBean=adminServiceRef.getEmployeeDetailsBasedOnId(100002);
			
			assertNotNull(empBean);
			//emsOp.updateOptions(empBean);
			assertSame(1,adminServiceRef.updateFirstName("Aditi",100002));
			assertSame(1,adminServiceRef.updateLastName("Chaskar",100002));	
			
			assertSame(1,adminServiceRef.updateDepartmentName(10001,103));
			assertSame(1,adminServiceRef.updateDesignationName(1000,1015));
			
			assertSame(1,adminServiceRef.updateSalary("12000",100002));
			assertSame(1,adminServiceRef.updateMaritalStatus("Single",100002));
			
			assertSame(1,adminServiceRef.updateHomeAddr(addBean,13));
			
			String contactNo="7845124578";
			assertSame(1, adminServiceRef.updateContactNumber(contactNo,100002));
			
			
		} catch (EMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 
}
