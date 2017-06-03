package com.softtantra.bizphone.serviceImpl;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.UserDao;
import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.User;
import com.softtantra.bizphone.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

	public UserDao getUserDao() {
		return userDao;
	}


	@Override
	public List<Role> geRoles() {
		// TODO Auto-generated method stub
		return userDao.geRoles();
	}
	
	
	@Override
	public boolean saveUser(User user,int u_id) {
		// TODO Auto-generated method stub
			 
			return userDao.saveUser(user,u_id);
		
		
	}
	
	@Override
	public List<User> getAllUserList(int status,int c_id) {
		// TODO Auto-generated method stub
		return userDao.getAllUserList(status,c_id);
	}
	
	@Override
	public boolean deleteUser(int user_id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user_id);
	}
	
	@Override
	public User getUserInfoForEdit(int user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserInfoForEdit(user_id);
	}
	
	@Override
	public boolean saveEditedUser(User user,int u_id) {
		// TODO Auto-generated method stub
		return userDao.saveEditedUser(user,u_id);
	}


	@Override
	public boolean CheckMobileNoUnique(String mobile_no, HttpSession session) {
		// TODO Auto-generated method stub
		return userDao.CheckMobileNoUnique(mobile_no,session);
	}


	@Override
	public boolean CheckMobileNoUniqueEdit(String mobile_no, String mobile_no1,
			HttpSession session) {
		// TODO Auto-generated method stub
		return userDao.CheckMobileNoUniqueEdit(mobile_no,mobile_no1,session);
	}



}
