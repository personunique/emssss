package com.cg.ems.service;

import com.cg.ems.bean.LoginDetailsBean;

public interface ILoginService {
	int validateLogin(LoginDetailsBean loginDetails);

}
