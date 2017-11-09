package com.cg.ems.dao;

import com.cg.ems.bean.LoginDetailsBean;

public interface ILoginDAO {

	int validateLogin(LoginDetailsBean loginDetails);

}
