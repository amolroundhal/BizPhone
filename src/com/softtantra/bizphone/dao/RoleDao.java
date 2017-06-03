package com.softtantra.bizphone.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.RolePermissions;

public interface RoleDao {

	List<RolePermissions> getRolePermissionList(HttpSession session);

	boolean insertNewRole(String roleName, String description, String adminCheck, String admin_name, HttpSession session, String admin_permission_id);
	
	boolean RoleName_unique(String roleName, HttpSession session);
	
		
		Role getEditInfo(HttpSession session, int roleId);

		List<Role> getRoleHasPermissiomInfo(HttpSession session, int roleId);
	
		boolean updateRole(String name, String description, String adminCheck, int role_id,
				HttpSession session);

		boolean deleteRole(Role role, HttpSession session);
}
