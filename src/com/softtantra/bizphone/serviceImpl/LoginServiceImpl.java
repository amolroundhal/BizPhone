package com.softtantra.bizphone.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.LoginDao;
import com.softtantra.bizphone.pojo.LoginDetails;
import com.softtantra.bizphone.pojo.PermissionsList;
import com.softtantra.bizphone.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao logindao;

	public void setLogindao(LoginDao logindao) {
		this.logindao = logindao;
	}

	@Override
	public LoginDetails checkLogin(String username) {
		// TODO Auto-generated method stub
		return logindao.checkLogin(username);
	}

	@Override
	public String getDepartment(int user_id) {
		// TODO Auto-generated method stub
		return logindao.getDepartment(user_id);
	}
	
	

}
