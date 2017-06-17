package com.softtantra.bizphone.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtantra.bizphone.service.WsLoginService;
import com.softtantra.bizphone.service.WsUploadService;
import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsBusinessPerson;
import com.softtantra.bizphone.ws.WsCounts;

@Controller
public class WsUploadController {
	@Autowired
	WsLoginService wsLoginService;

	public void setWsLoginService(WsLoginService wsLoginService) {
		this.wsLoginService = wsLoginService;
	}
	
	@Autowired
	WsUploadService wsUploadService;

	public void setWsUploadService(WsUploadService wsUploadService) {
		this.wsUploadService = wsUploadService;
	}
	
	@ResponseBody
    @RequestMapping("uploadBusinessPerson")
    public AjaxResponse uploadBusinessPerson(@RequestBody WsBusinessPerson business){
		
    int UserId = wsLoginService.CheckLogin(business.getUsername(),business.getPassword());
	int roleId = wsLoginService.getRoleId(UserId);	 
		AjaxResponse response = wsLoginService.uploadBusiness(business,UserId,roleId);
		return response;
    	
    }
}
