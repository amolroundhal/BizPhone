package com.softtantra.bizphone.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.RolePermissions;
import com.softtantra.bizphone.service.CommonService;
import com.softtantra.bizphone.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	RoleService roleService;
	
	
	public RoleService getRoleService() {
		return roleService;
	}


	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@Autowired
	CommonService commonService;

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	@RequestMapping("addRole")
	public String addNewRoles(ModelMap map,HttpSession session){
		if(session.getAttribute("username")!=null)
		{
		List<RolePermissions> rolePermissionList = roleService.getRolePermissionList(session);
		map.addAttribute("rolePermissionList", rolePermissionList);
		
		
		return "addRole";
		}
		else
		{
		return "adminlogin";
		}
		
	}
	
	@RequestMapping("insertRoles")
	public String InsertRoles(@RequestParam("name") String roleName,@RequestParam("description") String description,@RequestParam("adminCheck") String adminCheck,@RequestParam("admin_name") String admin_name,HttpSession session,@RequestParam("admin_permission_id") String admin_permission_id,RedirectAttributes redirectAttributes){
	
		System.out.println("admin check "+adminCheck);
		//System.out.println("mobile check "+mobileCheck);
		System.out.println("inside controller"+session.getAttribute("username"));
		if(session.getAttribute("username")!=null)
		{
			System.out.println("inside sesion action");
		boolean result = roleService.insertNewRole(roleName,description,adminCheck,admin_name,session,admin_permission_id);
		
		if(result){
			redirectAttributes.addFlashAttribute("flag", 1);
		}else {
			redirectAttributes.addFlashAttribute("flag", 0);
		}
		return "redirect:RoleList";
		}
		else
		{
		return "adminlogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="RoleName_unique",method=RequestMethod.POST)
	public boolean  RoleName_unique(@RequestParam("value") String roleName,HttpSession session){
		boolean result = roleService.RoleName_unique(roleName,session);
		return result;
		
	}
	
	@RequestMapping("RoleList")
	public String AllRoleList(HttpSession session){
		if(session.getAttribute("username")!=null)
		{
		return "RoleList";
		}
		else
		{
		return "adminlogin";
		}
	}  
	

	@ResponseBody
	@RequestMapping(value="editRoleData",method = RequestMethod.GET)
	String  getUserJsonData(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		String COLUMN_NAME;
		String DIRECTION;
		int INITIAL;
		int RECORD_SIZE;
		//int c_id=Integer.parseInt(session.getAttribute("company_id")+"");
		//String[] columnNames ={"product_id ","product_code" , "name" , "mrp" , " pack "," brand_name"," category_name "," sub_category_name "};
		
		String[] columnNames ={"role.name","role.id","role.id","role.name"};
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
			/*if (listDisplayAmount < 10 || listDisplayAmount > 50) {
				listDisplayAmount = 10;
			}*/
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
		totalRecords = commonService.getTotalRecordCount("select count(*) from role where status!=0");
		
		
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
			int iNITIAL, int rECORD_SIZE, String pageNo, String pageSize
			) {

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
		
	    query1="SELECT role.name,role.id,role.status FROM role WHERE role.status!=0";
		 
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
					
					String [] str = new String[3];
					
					str[0] = String.valueOf(index++);  //String.valueOf(o[0]);//ID
					str[1] = (String) o[0];//Lat
					
                    /*if((o[2].toString()).equals("1")){
						
						str[2] = "<span class='label label-success'>Active</span>";
						
					}else{
						str[2] = "<span class='label label-danger'>Deactive</span>";
					}*/
					
					str[2] = "<a href='editRole?RoleId="+(Integer)o[1]+"'  class='btn btn-info'  data-toggle='tooltip' title='Edit'><i class='glyphicon glyphicon-edit'></i></a> ";
							/*+"<a href='#DeleteRoleModal' data-id="+(Integer)o[1]+" data-toggle='modal' class='btn btn-danger'  title='Delete'><i class='glyphicon glyphicon-trash'></i></a>";*/
					array[i] = str; 
					i++;
					
				}	
				
			}catch(Exception e){
				e.printStackTrace();
			}
			String query = "";
			
			query = "SELECT " + "COUNT(*) as count " + "FROM " + "role where role.status!=0";
			
			
			
		     
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
	
	@RequestMapping("editRole")
	public String editAddedRole(ModelMap map,HttpSession session,@RequestParam("RoleId") int roleId){
		if(session.getAttribute("username")!=null)
		{
		List<RolePermissions> rolePermissionList = roleService.getRolePermissionList(session);
		map.addAttribute("rolePermissionList", rolePermissionList);
		
		
		Role roleInfo = roleService.getEditInfo(session,roleId);
		map.addAttribute("roleInfo", roleInfo);
		
		List<Role> roleHasPermissiomInfo = roleService.getRoleHasPermissiomInfo(session,roleId);
		map.addAttribute("roleHasPermissionInfo", roleHasPermissiomInfo);
		
		
		map.addAttribute("roleId", roleId);
		return "editRole"; 
		}
		else
		{
		return "adminlogin";
		}
	}
	
	@RequestMapping("updateRoles")
	public String updateRole(@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("adminCheck") String adminCheck,@RequestParam("role_id") int role_id,HttpSession session,RedirectAttributes redirectAttributes){
		if(session.getAttribute("username")!=null)
		{
		//System.out.println("inside update" +role_id+" "+adminCheck);
		boolean result = roleService.updateRole(name,description,adminCheck,role_id,session);
		
		if(result){
			redirectAttributes.addFlashAttribute("flag", 1);
		}else {
			redirectAttributes.addFlashAttribute("flag", 0);
		}
		return "redirect:RoleList";
		}
		else
		{
		return "login";
		}	
	}

	
	@RequestMapping(value="deleteRole")
	public String deleteDealerRole(@ModelAttribute Role role,RedirectAttributes redirectAttributes,HttpSession session){
		
		//System.out.println("Inside deleteDealerRole Controller........!!!!");
		
		boolean result=roleService.deleteRole(role,session);
		
		if(result){
			
	    	   redirectAttributes.addFlashAttribute("flag", 1111);
				
			}else{
				
				redirectAttributes.addFlashAttribute("flag", 2222);
			}
		
		return "redirect:RoleList";
		
	}
	
	
}
