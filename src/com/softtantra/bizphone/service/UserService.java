package com.softtantra.bizphone.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.User;

public interface UserService {

	List<Role> geRoles();
	
	
	boolean saveUser(User user, int c_id);
	
	List<User> getAllUserList(int status, int c_id);
	
	boolean deleteUser(int user_id);
	
	User getUserInfoForEdit(int user_id);
	
	boolean saveEditedUser(User user, int c_id);

	boolean CheckMobileNoUnique(String mobile_no, HttpSession session);


	boolean CheckMobileNoUniqueEdit(String mobile_no, String mobile_no1,
			HttpSession session);

	
}
