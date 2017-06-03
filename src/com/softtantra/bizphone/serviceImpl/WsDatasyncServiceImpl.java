package com.softtantra.bizphone.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.WsDatasyncDao;
import com.softtantra.bizphone.service.WsDatasyncService;
import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsCounts;
import com.softtantra.bizphone.ws.WsLogin;

public class WsDatasyncServiceImpl implements WsDatasyncService{
	
	@Autowired
	WsDatasyncDao wsDatasyncDao;

	public void setWsDatasyncDao(WsDatasyncDao wsDatasyncDao) {
		this.wsDatasyncDao = wsDatasyncDao;
	}

	@Override
	public AjaxResponse check_counts(WsCounts count, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.check_counts(count, userId);
	}

	@Override
	public AjaxResponse getUsers(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getUsers(login, userId);
	}

	@Override
	public AjaxResponse getRegistration_types(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getRegistration_types(login, userId);
	}

	@Override
	public AjaxResponse getCategories(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getCategories(login, userId);
	}

	@Override
	public AjaxResponse getIrrigation_types(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getIrrigation_types(login, userId);
	}

	@Override
	public AjaxResponse getIrrigation_methods(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getIrrigation_methods(login, userId);
	}

	@Override
	public AjaxResponse getPlantation_types(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getPlantation_types(login, userId);
	}

	@Override
	public AjaxResponse getPlantation_methods(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getPlantation_methods(login, userId);
	}

	@Override
	public AjaxResponse getSugarcane_seasons(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getSugarcane_seasons(login, userId);
	}

	@Override
	public AjaxResponse getSugarcane_varities(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getSugarcane_varities(login, userId);
	}

	@Override
	public AjaxResponse getSections(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getSections(login, userId);
	}

	@Override
	public AjaxResponse getRoutes(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getRoutes(login, userId);
	}

	@Override
	public AjaxResponse getVillages(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getVillages(login, userId);
	}

	@Override
	public AjaxResponse getFarmers(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		return wsDatasyncDao.getFarmers(login, userId);
	}
	
	
}
