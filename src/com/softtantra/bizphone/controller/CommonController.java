package com.softtantra.bizphone.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;

import com.softtantra.bizphone.service.CommonService;



@Controller
public class CommonController {

	@Autowired
	CommonService commonService;

	private static  CommonService commonService2;
	
	@PostConstruct
	public void init(){
		CommonController.commonService2=commonService;
	}
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}


	@Async
	public static Future<Boolean> SendSMS(){


		try{

			String message = ""; 

			URLConnection myURLConnection=null;
			URL myURL=null;
			BufferedReader reader=null; 
			//encoding message 
			String encoded_message=URLEncoder.encode(message); 
			//Send SMS API 
			String mainUrl=""; 
			try { 
				//prepare connection 
				System.out.println("mian "+mainUrl);
				myURL = new URL(mainUrl); 
				myURLConnection = myURL.openConnection(); 
				myURLConnection.connect(); 
				reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream())); 
				//reading response 
				String response; 
				while ((response = reader.readLine()) != null) 
					//print response 
					System.out.println(response); 
				//finally close connection 
				reader.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 




		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{

		}
		return new AsyncResult<Boolean>(true);
	}

}
