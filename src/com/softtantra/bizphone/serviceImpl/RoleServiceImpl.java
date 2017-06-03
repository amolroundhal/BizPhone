package com.softtantra.bizphone.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.RoleDao;
import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.RolePermissions;
import com.softtantra.bizphone.service.RoleService;

public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDao roleDao;

	
	public RoleDao getRoleDao() {
		return roleDao;
	}


	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}


	@Override
	public List<RolePermissions> getRolePermissionList(HttpSession session) {
		// TODO Auto-generated method stub
		return roleDao.getRolePermissionList(session);
	}
	
	@Override
	public boolean insertNewRole(String roleName, String description,
			String adminCheck, String admin_name,
			 HttpSession session,String admin_permission_id) {
		// TODO Auto-generated method stub
		return roleDao.insertNewRole(roleName,description,adminCheck,admin_name,session,admin_permission_id);
	}
	
	@Override
	public boolean RoleName_unique(String roleName,HttpSession session) {
		// TODO Auto-generated method stub
		return roleDao.RoleName_unique(roleName,session);
	}
	
		
		@Override
		public Role getEditInfo(HttpSession session, int roleId) {
			// TODO Auto-generated method stub
			return roleDao.getEditInfo(session,roleId);
		}


		@Override
		public List<Role> getRoleHasPermissiomInfo(HttpSession session, int roleId) {
			// TODO Auto-generated method stub
			return roleDao.getRoleHasPermissiomInfo(session,roleId);
		}
		
		@Override
		public boolean updateRole(String name, String description,
				String adminCheck,int role_id, 
				HttpSession session) {
			// TODO Auto-generated method stub
			return roleDao.updateRole(name,description,adminCheck,role_id,session);
		}


		@Override
		public boolean deleteRole(Role role, HttpSession session) {
			// TODO Auto-generated method stub
			return roleDao.deleteRole(role,session);
		}

	
}
