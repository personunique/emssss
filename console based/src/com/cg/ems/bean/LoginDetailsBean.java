package com.cg.ems.bean;

public class LoginDetailsBean {

	private int loginId;
	private String userName;
	private String password;
	private String role;
	private int empId;
	
	public LoginDetailsBean() {
		
	}

	public LoginDetailsBean(int loginId, String userName, String password,
			String role, int empId) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.empId = empId;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "LoginDetailsBean [loginId=" + loginId + ", userName="
				+ userName + ", password=" + password + ", role=" + role
				+ ", empId=" + empId + "]";
	}
	
	
	
}
