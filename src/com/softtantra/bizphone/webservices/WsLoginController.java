package com.softtantra.bizphone.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtantra.bizphone.service.WsLoginService;
import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsLogin;

@Controller
public class WsLoginController {
	@Autowired
	WsLoginService wsLoginService;

	public void setWsLoginService(WsLoginService wsLoginService) {
		this.wsLoginService = wsLoginService;
	}
	
	@ResponseBody
	@RequestMapping(value="wsLogin", method=RequestMethod.POST)
	public AjaxResponse login(@RequestBody WsLogin login) {
		
		int UserId = wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		
		//AjaxResponse response = wsLoginService.login(login,UserId);
		//response.setStatus("error");
		return null;//response;
	}
	
	@ResponseBody
	@RequestMapping(value="WsCheckConnection", method=RequestMethod.POST)
	public AjaxResponse check_connection(@RequestBody WsLogin login) {
		System.out.println("hello");
		int UserId = 1;//wsLoginService.CheckLogin(login.getUsername(),login.getPassword());
		AjaxResponse response = new AjaxResponse();
		if(UserId > 0){
			response.setStatus("success");
			response.setMsg("Connection available");
		}else{
			response.setStatus("Error");
			response.setMsg("Login Failed");
		}
		return response;
	}
}
