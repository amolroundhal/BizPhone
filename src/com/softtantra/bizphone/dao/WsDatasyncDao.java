package com.softtantra.bizphone.dao;

import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsCounts;
import com.softtantra.bizphone.ws.WsLogin;

public interface WsDatasyncDao {

	AjaxResponse check_counts(WsCounts count, int userId);

	AjaxResponse getUsers(WsLogin login, int userId);

	AjaxResponse getRegistration_types(WsLogin login, int userId);

	AjaxResponse getCategories(WsLogin login, int userId);

	AjaxResponse getIrrigation_types(WsLogin login, int userId);

	AjaxResponse getIrrigation_methods(WsLogin login, int userId);

	AjaxResponse getPlantation_types(WsLogin login, int userId);

	AjaxResponse getPlantation_methods(WsLogin login, int userId);

	AjaxResponse getSugarcane_seasons(WsLogin login, int userId);

	AjaxResponse getSugarcane_varities(WsLogin login, int userId);

	AjaxResponse getSections(WsLogin login, int userId);

	AjaxResponse getRoutes(WsLogin login, int userId);

	AjaxResponse getVillages(WsLogin login, int userId);

	AjaxResponse getFarmers(WsLogin login, int userId);
	
}
