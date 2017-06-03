package com.softtantra.bizphone.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtantra.bizphone.service.WsDatasyncService;
import com.softtantra.bizphone.service.WsLoginService;
import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsCounts;
import com.softtantra.bizphone.ws.WsLogin;

@Controller
public class WsDatasyncController {
	@Autowired
	WsLoginService wsLoginService;

	public void setWsLoginService(WsLoginService wsLoginService) {
		this.wsLoginService = wsLoginService;
	}
	
	@Autowired
	WsDatasyncService wsDatasyncService;

	public void setWsDatasyncService(WsDatasyncService wsDatasyncService) {
		this.wsDatasyncService = wsDatasyncService;
	}
	
	@ResponseBody
	@RequestMapping(value="WsCheckCounts", method=RequestMethod.POST)
	public AjaxResponse check_counts(@RequestBody WsCounts count) {
		
		int UserId = 1;//wsLoginService.CheckLogin(count.getUsername(),count.getPassword());
		
		AjaxResponse response = wsDatasyncService.check_counts(count, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetUsers", method=RequestMethod.POST)
	public AjaxResponse getUsers(@RequestBody WsLogin login) {
		System.out.println("get users..");
		int UserId = 1;//wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getUsers(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetRegistration_types", method=RequestMethod.POST)
	public AjaxResponse getRegistration_types(@RequestBody WsLogin login) {
		System.out.println("get getRegistration_types..");
		int UserId = 1;//wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getRegistration_types(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetCategories", method=RequestMethod.POST)
	public AjaxResponse getCategories(@RequestBody WsLogin login) {
		System.out.println("get getCategories..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getCategories(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetIrrigation_types", method=RequestMethod.POST)
	public AjaxResponse getIrrigation_types(@RequestBody WsLogin login) {
		System.out.println("get getIrrigation_types..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getIrrigation_types(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetIrrigation_methods", method=RequestMethod.POST)
	public AjaxResponse getIrrigation_methods(@RequestBody WsLogin login) {
		System.out.println("get getIrrigation_methods..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getIrrigation_methods(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetPlantation_types", method=RequestMethod.POST)
	public AjaxResponse getPlantation_types(@RequestBody WsLogin login) {
		System.out.println("get getPlantation_types..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getPlantation_types(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetPlantation_methods", method=RequestMethod.POST)
	public AjaxResponse getPlantation_methods(@RequestBody WsLogin login) {
		System.out.println("get getPlantation_methods..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getPlantation_methods(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetSugarcane_seasons", method=RequestMethod.POST)
	public AjaxResponse getSugarcane_seasons(@RequestBody WsLogin login) {
		System.out.println("get getSugarcane_seasons..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getSugarcane_seasons(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetSugarcane_varities", method=RequestMethod.POST)
	public AjaxResponse getSugarcane_varities(@RequestBody WsLogin login) {
		System.out.println("get getSugarcane_varities..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getSugarcane_varities(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetSections", method=RequestMethod.POST)
	public AjaxResponse getSections(@RequestBody WsLogin login) {
		System.out.println("get getSections..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getSections(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetRoutes", method=RequestMethod.POST)
	public AjaxResponse getRoutes(@RequestBody WsLogin login) {
		System.out.println("get getRoutes..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getRoutes(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetVillages", method=RequestMethod.POST)
	public AjaxResponse getVillages(@RequestBody WsLogin login) {
		System.out.println("get getVillages..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getVillages(login, UserId);
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsGetFarmers", method=RequestMethod.POST)
	public AjaxResponse getFarmers(@RequestBody WsLogin login) {
		System.out.println("get getFarmers..");
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		AjaxResponse response = wsDatasyncService.getFarmers(login, UserId);
		
		return response;
	}
}
