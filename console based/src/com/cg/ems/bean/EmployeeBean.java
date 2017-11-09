package com.cg.ems.bean;

import java.sql.Date;


public class EmployeeBean {

	private int empId;
	private String FirstName;
	private String LastName;
	private Date dateOfJoining;
	private Date dateOfBirth;
	private int deptId;
	private int designationId;
	private String grade;
	private String gender;
	private long salary;
	private String martialStatus;
	private int addressId;
	private long contactNo;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	

	//"Govind","Prajapati","16/AUG/2017","20/DEC/1995",111,1112,"M2","Male",25000,"Single",1010,"8286301908");
	

	public EmployeeBean(){}
	
	
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	
	
	public EmployeeBean(int empId ,String firstName, String lastName,Date dateOfJoining, Date dateOfBirth, int deptId,int designationId, String grade, String gender,long salary,String martialStatus, int addressId, long contactNo) {
		this.empId = empId;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.deptId = deptId;
		this.designationId = designationId;
		this.grade = grade;
		this.gender = gender;
		this.salary = salary;
		this.martialStatus = martialStatus;
		this.addressId = addressId;
		this.contactNo = contactNo;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfBirth=" + dateOfBirth + ", deptId=" + deptId
				+ ", designationId=" + designationId + ", grade=" + grade
				+ ", gender=" + gender + ", salary=" + salary
				+ ", martialStatus=" + martialStatus + ", addressId="
				+ addressId + ", contactNo=" + contactNo + "]";
	}
	
	
	
	
}
