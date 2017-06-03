package com.softtantra.bizphone.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.User;
import com.softtantra.bizphone.service.CommonService;
import com.softtantra.bizphone.service.RoleService;
import com.softtantra.bizphone.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	public UserService getUserService() {
		return userService;
	}
	
	

	@Autowired
	CommonService commonService;

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	@RequestMapping(value="addUser")
	public String addUser(ModelMap map,HttpSession session,RedirectAttributes redirectAttributes){ 
		if(session.getAttribute("username")!=null)
		{
					List<Role> roles = userService.geRoles(); 
					Map<Integer, String> departments = commonService.getDepartments(session);
					map.addAttribute("roles", roles);
					map.addAttribute("departments", departments);
		return "addUser";
		
		}
		else
		{
		return "adminlogin";
		}
	} 
	
	
	@ResponseBody
	@RequestMapping(value="checkMobileNoUnique",method=RequestMethod.POST)
	public boolean CheckMobileNoUnique(@RequestParam("mobile_no") String mobile_no,HttpSession session){
		boolean result = userService.CheckMobileNoUnique(mobile_no,session);
		return result;
		
	}
	
	
	@RequestMapping(value="saveUser", method=RequestMethod.POST)
	public String saveUser( HttpServletRequest request, RedirectAttributes redirectAttributes,HttpSession session){
		System.out.println("inside1");
		if(session.getAttribute("username")!=null)
		{System.out.println("inside2");
			try {
				//int c_id=(Integer.parseInt(session.getAttribute("company_id")+""));
				int u_id=(Integer.parseInt( session.getAttribute("user_id")+""));

				
				User user=new User();
				
				user.setFirst_name(request.getParameter("first_name"));
				user.setLast_name(request.getParameter("last_name"));
				user.setEmail(request.getParameter("email"));
				user.setRole_id(Integer.parseInt(request.getParameter("role_id")));
				user.setPassword(request.getParameter("password"));
				user.setMobile_no(request.getParameter("mobile_no"));
				user.setStatus(Integer.parseInt(request.getParameter("status")));
				 
				
				boolean result = userService.saveUser(user,u_id);


					if(result){
						redirectAttributes.addFlashAttribute("flag", 1);
					}else{
						redirectAttributes.addFlashAttribute("flag", 0);
					}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("flag", 0);
			}
				
		return "redirect:getUsers";
		}
		else
		{
		return "adminlogin";
		}
	}
	
	
	@RequestMapping("getUsers")
	public String getUsers(ModelMap map,HttpSession session){
		
		if(session.getAttribute("username")!=null)
		{
		
		try {
			List<Role> roles = userService.geRoles();
			map.addAttribute("roles", roles);
			
			//List<User> userList = userService.getAllUserList();
			//map.addAttribute("userList", userList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "getUsers";
		
		}
		else
		{
		return "adminlogin";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="UserListData",method = RequestMethod.GET)
	String  getUserJsonData(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		String COLUMN_NAME;
		String DIRECTION;
		int INITIAL;
		int RECORD_SIZE;
		//int c_id=Integer.parseInt(session.getAttribute("company_id")+"");
		//String[] columnNames ={"product_id ","product_code" , "name" , "mrp" , " pack "," brand_name"," category_name "," sub_category_name "};
		
		String[] columnNames ={"u.user_id","u.username"," r.name","u.status","u.user_id"};
		//System.out.println("hi..."+request.getParameter("status"));
		
		HashMap<String, Object> jsonResult = new HashMap();
		int listDisplayAmount = 20;
		int start = 0;
		int column = 0;
		String dir = "asc";
		String pageNo = request.getParameter("iDisplayStart");
		String pageSize = request.getParameter("iDisplayLength");
		String colIndex = request.getParameter("iSortCol_0");
		String sortDirection = request.getParameter("sSortDir_0");
		
		if (pageNo != null) {
			start = Integer.parseInt(pageNo);
			if (start < 0) {
				start = 0;
			}
		}
		
		if (pageSize != null) {
			listDisplayAmount = Integer.parseInt(pageSize);
			if (listDisplayAmount < 10 || listDisplayAmount > 50) {
				listDisplayAmount = 10;
			}
		}
		if (colIndex != null) {
			column = Integer.parseInt(colIndex);
			if (column < 0 || column > 8)
				column = 0;
		}
		if (sortDirection != null) {
			if (!sortDirection.equals("asc"))
				dir = "desc";
		}
		
		String colName = columnNames[column];
		int totalRecords= -1;
		String status = request.getParameter("status");
		//int userId=Integer.parseInt(request.getParameter("user")!=null && !"".equals(request.getParameter("user")) ?request.getParameter("user"):"0");
		totalRecords = commonService.getTotalRecordCount("select count(*) from user_details where status!=0");
		
		
		RECORD_SIZE = listDisplayAmount;
		COLUMN_NAME = colName;
		DIRECTION = dir;
		INITIAL = start;
		
		
		jsonResult = getEditRoleDetails(totalRecords, request, COLUMN_NAME, DIRECTION, INITIAL, RECORD_SIZE, pageNo, pageSize);
		Gson gson = new Gson();
		String atr = gson.toJson(jsonResult);
		return atr;

	}


	private HashMap<String, Object> getEditRoleDetails(int totalRecords,
			HttpServletRequest request, String cOLUMN_NAME, String dIRECTION,
			int iNITIAL, int rECORD_SIZE, String pageNo, String pageSize) {

		String GLOBAL_SEARCH_TERM;
		GLOBAL_SEARCH_TERM = request.getParameter("sSearch"); 
		
		int totalAfterSearch = totalRecords;
		HashMap<String, Object> result = new HashMap();
		String searchSQL = "";
		
		String status = request.getParameter("status");
		
		//int stateId=Integer.parseInt(request.getParameter("state")!=null && !"".equals(request.getParameter("state"))?request.getParameter("state"):"0");
		//int userId=Integer.parseInt(request.getParameter("user")!=null && !"".equals(request.getParameter("user")) ?request.getParameter("user"):"0");
		//String fromDate = request.getParameter("fromDate");
		//String toDate = request.getParameter("toDate");
		
		String query1 = "";
		
	    query1="SELECT u.user_id,u.first_name as username,r.name,u.status,u.last_name FROM user_details u join   role r on u.role_id=r.id and u.status!=0 ";
		 
	     query1 += searchSQL;
			query1 += " order by " + cOLUMN_NAME + " " + dIRECTION;
			System.out.println(query1);
			//p
			List list = commonService.getDataList(query1, iNITIAL, rECORD_SIZE);
			
			Object [] array = new Object[list.size()];
			int i = 0;
			int index = iNITIAL + 1;
			//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Iterator itr = list.iterator();
			
			try{
				
				while (itr.hasNext()){
					
					Object obj = itr.next();
					Object o[] = (Object []) obj;
					
					String [] str = new String[5];
					
					str[0] = String.valueOf(index++);  //String.valueOf(o[0]);//ID
					str[1] = (o[1] +" "+o[4]);//Lat
					str[2] = (String) o[2];
					
					
                    if((o[3].toString()).equals("1")){
						
						str[3] = "<span class='label label-success'>Active</span>";
						
					}else{
						str[3] = "<span class='label label-danger'>Deactive</span>";
					}
					
					
						str[4] = "<a href='getUserInfoForEdit?user_id="+(Integer)o[0]+"' class='btn btn-info' data-toggle='tooltip' title='Edit'><span class='glyphicon glyphicon-edit'></span></a>|"
			                   /*	 +"<a href='getUserView?user_id="+(Integer)o[0]+"' class='btn btn-warning' data-toggle='tooltip' title='View'><span class='glyphicon glyphicon-eye-open'></span></a>|"*/
			                    	 +"<a href='#DeleteUserModal' data-id='"+(Integer)o[0]+"' data-toggle='modal' class='btn btn-danger'  title='Delete'><span class='glyphicon glyphicon-trash'></span></a>";
					
					array[i] = str; 
					i++;
					
				}	
				
			}catch(Exception e){
				e.printStackTrace();
			}
			String query = "";
			
			query = "SELECT " + "COUNT(*) as count " + "FROM " + "user_details where status!=0";
			
		     System.out.println("search "+query);
		     if (GLOBAL_SEARCH_TERM != "")
		 	{
		 		query += searchSQL;
		 		
		 		//p1
		 		totalAfterSearch = commonService.getTotalRecordCount(query);
		 		
		 	}
		 	try{
		 		result.put("sEcho", request.getParameter("sEcho"));
		 		result.put("iTotalRecords", totalRecords);
		 		result.put("iTotalDisplayRecords", totalAfterSearch);
		 		result.put("aaData", array);
		 		
		 	}catch(Exception e){
		 		e.printStackTrace();
		 	}
		 	
		 		return result;
		
	}
	
	@RequestMapping(value="/exportUsers",method = RequestMethod.GET)
	public ModelAndView exportUsers(@RequestParam("status") int status,ModelMap map,HttpSession session){
		
		//List<CustomerDetails> customerList = customerListService.getAllCustomerList();
		//List<User> userList = userService.getUserList(first_name.trim(),last_name.trim(),user.getState(),user.getCity(),user.getRole_id());
		//map.addAttribute("userList", userList);
		int c_id=(Integer.parseInt(session.getAttribute("company_id")+""));
		System.out.println("in exportUsers--"+status);
		List<User> userList = userService.getAllUserList(status,c_id);
		map.addAttribute("userList", userList);
		return new ModelAndView("userExcelView", "userList", userList);
		
	}
	
	
	@RequestMapping(value="deleteUser")
	public String deleteUser(@RequestParam("user_id") int user_id,RedirectAttributes redirectAttributes,HttpSession session){
		
		if(session.getAttribute("username")!=null)
		{

		
		boolean result = userService.deleteUser(user_id);
		
		if(result){
	    	redirectAttributes.addFlashAttribute("flag3", 1);
		}else {
			redirectAttributes.addFlashAttribute("flag3", 0);
		}
		
		return "redirect:getUsers";
		
		}
		else
		{
		return "adminlogin";
		}
			
	}
	
	@RequestMapping(value="getUserInfoForEdit")
	public String getUserInfoForEdit(@RequestParam("user_id") int user_id,ModelMap map,HttpSession session) {
		
		
		User user=userService.getUserInfoForEdit(user_id);
		map.addAttribute("user",user);
		map.addAttribute("userId", user_id);
		
		List<Role> roles = userService.geRoles();
		Map<Integer, String> departments = commonService.getDepartments(session);
		map.addAttribute("roles", roles);
		map.addAttribute("departments", departments);
		 
		return "getUserInfoForEdit";
	}
	
	@RequestMapping(value="/saveEditedUser", method=RequestMethod.POST)
	public String saveEditedUser(HttpServletRequest request, RedirectAttributes redirectAttributes,HttpSession session){
		
		if(session.getAttribute("username")!=null)
		{
			try {
				//int c_id=(Integer.parseInt(session.getAttribute("company_id")+""));
				int u_id=(Integer.parseInt( session.getAttribute("user_id")+""));
				
				User user=new User();
				
				user.setUser_id(Integer.parseInt(request.getParameter("user_id")));
				user.setFirst_name(request.getParameter("first_name"));
				user.setLast_name(request.getParameter("last_name"));
				user.setEmail(request.getParameter("email"));
				user.setRole_id(Integer.parseInt(request.getParameter("role_id")));
				user.setPassword(request.getParameter("password"));
				user.setMobile_no(request.getParameter("mobile_no"));
				user.setStatus(Integer.parseInt(request.getParameter("status")));
				boolean result = userService.saveEditedUser(user,u_id);


				if(result){
				redirectAttributes.addFlashAttribute("flag1", 1);
				}else{
				redirectAttributes.addFlashAttribute("flag1", 0);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "redirect:getUsers";
		}
		else
		{
		return "adminlogin";
		}
	}
	
	@RequestMapping(value="getUserView")
	public String getUserView(@RequestParam("user_id") int user_id,ModelMap map,HttpSession session) {
		
		if(session.getAttribute("username")!=null)
		{
		User user=userService.getUserInfoForEdit(user_id);
		map.addAttribute("user",user);
	
		List<Role> roles = userService.geRoles();
		Map<Integer, String> departments = commonService.getDepartments(session);
		map.addAttribute("roles", roles);
		map.addAttribute("departments", departments);
		
		return "getUserView";
		
		}
		else
		{
		return "adminlogin";
		}
	}

	@ResponseBody
	@RequestMapping(value="checkMobileNoUniqueEdit",method=RequestMethod.POST)
	public boolean CheckMobileNoUniquEdit(@RequestParam("mobile_no") String mobile_no,@RequestParam("mobile_no1") String mobile_no1,HttpSession session){
		boolean result = userService.CheckMobileNoUniqueEdit(mobile_no,mobile_no1,session);
		return result;
		
	}
	
}
