package com.softtantra.bizphone.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.WsLoginDao;
import com.softtantra.bizphone.service.WsLoginService;

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
}
