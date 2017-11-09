package com.cg.ems.service;

import com.cg.ems.bean.LoginDetailsBean;
import com.cg.ems.dao.ILoginDAO;
import com.cg.ems.dao.LoginDAOImpl;

public class LoginServiceImpl implements ILoginService{

	ILoginDAO id = new LoginDAOImpl();
	@Override
	public int validateLogin(LoginDetailsBean loginDetails) {
		
		return id.validateLogin(loginDetails);
	}

}
