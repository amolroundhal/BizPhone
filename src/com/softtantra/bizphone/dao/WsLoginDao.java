package com.softtantra.bizphone.dao;

import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsBusinessPerson;
import com.softtantra.bizphone.ws.WsLogin;

public interface WsLoginDao {

	int CheckLogin(String username, String password);

	AjaxResponse login(WsLogin login, int userId);

	AjaxResponse uploadBusiness(WsBusinessPerson business, int userId, int roleId);

	int getRoleId(int userId);

}
