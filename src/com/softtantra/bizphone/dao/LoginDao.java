package com.softtantra.bizphone.dao;

import java.util.List;

import com.softtantra.bizphone.pojo.LoginDetails;
import com.softtantra.bizphone.pojo.PermissionsList;

public interface LoginDao {

	LoginDetails checkLogin(String username);

	String getDepartment(int user_id);

	
	
}
