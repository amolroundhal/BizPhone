package com.softtantra.bizphone.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.CommonDao;
import com.softtantra.bizphone.service.CommonService;

public class CommonServiceImpl implements CommonService {
	
	@Autowired
	CommonDao commonDao;

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public int getTotalRecordCount(String query) {
		// TODO Auto-generated method stub
		return commonDao.getTotalRecordCount(query);
	}

	@Override
	public List getDataList(String query1, int iNITIAL, int rECORD_SIZE) {
		// TODO Auto-generated method stub
		return commonDao.getDataList(query1, iNITIAL, rECORD_SIZE);
	}

	@Override
	public Map<Integer, String> getChitBoys(HttpSession session) {
		// TODO Auto-generated method stub
		return commonDao.getChitBoys(session);
	}

	@Override
	public Map<Integer, String> getDepartments(HttpSession session) {
		// TODO Auto-generated method stub
		return commonDao.getDepartments(session);
	}

}
