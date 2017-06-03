package com.softtantra.bizphone.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.WsUploadDao;
import com.softtantra.bizphone.service.WsUploadService;
import com.softtantra.bizphone.ws.AjaxResponse;

public class WsUploadServiceImpl implements WsUploadService {
	
	@Autowired
	WsUploadDao wsUploadDao;

	public void setWsUploadDao(WsUploadDao wsUploadDao) {
		this.wsUploadDao = wsUploadDao;
	}

	
}
