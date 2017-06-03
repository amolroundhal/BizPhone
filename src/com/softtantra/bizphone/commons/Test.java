package com.softtantra.bizphone.commons;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String deviceID  ="cr5F2A7alX4:APA91bF1B9hS13VROqqGsVezgDq9qoWU98ILxyjTTDjE_MwPwEEO6i8j0wOC815xocFBhSWm35vw9gXKjVgeS9ah7E3rIVY3d8uMQ0B7d4Aqw6I-eWUaWo-bCYBkc-mlsa9p4zU_qc-m";//"fL25jWPnnFA:APA91bHqSVQjHgZCR7ZMu79V0ATNtdYbwVtZU_DRsawRMXoWf8ebNBMFEvV07CaBFdz2nhqm2K-phvoShOv6vLtKfm50n4IJ_qnFGugV3Y1oQS6CEYJIbe7ZNOov8uO79IOPcuvXsGzW"; 
		//sendMessage(deviceID, "Hello test notification from softtantra");
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
		System.out.println(sdf.format(new Date()));
	}
	
	public static boolean sendMessage(String deviceID, String message){
		
		//sample to POST to the server for GCM message
		System.out.println("inside send message!! ");
		final String GCM_API_KEY = "AIzaSyBEggB4vHbEXZJTnih22UU_pgXUZZT-xEI";
	    final int retries = 3;
	    Sender sender = new Sender(GCM_API_KEY);
	    Message msg = new Message.Builder().addData("message",message).build();
	    try {
	                Result result = sender.send(msg, deviceID, retries);

	                if (StringUtils.isEmpty(result.getErrorCodeName())) {
	                   System.out.println("Notification sent successfullly..!" );
	                }else {
						System.out.println("Notification Failed..");
					}

	    } catch (InvalidRequestException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	               e.printStackTrace();
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
	    return true;
	}

}
