package com.softtantra.bizphone.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.WsLoginDao;
import com.softtantra.bizphone.service.WsLoginService;
import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsBusinessPerson;
import com.softtantra.bizphone.ws.WsLogin;

public class WsLoginServiceImpl implements WsLoginService {

	@Autowired
	WsLoginDao wsLoginDao;

	public void setWsLoginDao(WsLoginDao wsLoginDao) {
		this.wsLoginDao = wsLoginDao;
	}

	@Override
	public int CheckLogin(String username, String password) {
		// TODO Auto-generated method stub
		return wsLoginDao.CheckLogin(username, password);
	}

	@Override
	public AjaxResponse login(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsLoginDao.login(login,userId);
	}

	@Override
	public AjaxResponse uploadBusiness(WsBusinessPerson business, int userId,int roleId) {
		// TODO Auto-generated method stub
		return wsLoginDao.uploadBusiness(business,userId,roleId);
	}

	@Override
	public int getRoleId(int userId) {
		// TODO Auto-generated method stub
		return wsLoginDao.getRoleId(userId);
	}
}
