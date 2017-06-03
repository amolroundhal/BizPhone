package com.softtantra.bizphone.service;

import java.util.List;

import com.softtantra.bizphone.pojo.LoginDetails;
import com.softtantra.bizphone.pojo.PermissionsList;



public interface LoginService {
	
	LoginDetails checkLogin(String username);

	String getDepartment(int user_id);
}
