package com.softtantra.bizphone.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface CommonService {
	
	int getTotalRecordCount(String query);

	List getDataList(String query1, int iNITIAL, int rECORD_SIZE);

	Map<Integer, String> getChitBoys(HttpSession session);

	Map<Integer, String> getDepartments(HttpSession session);
}
