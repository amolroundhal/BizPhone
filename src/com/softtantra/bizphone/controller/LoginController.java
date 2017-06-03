package com.softtantra.bizphone.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.record.formula.functions.Lognormdist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softtantra.bizphone.pojo.LoginDetails;
import com.softtantra.bizphone.pojo.PermissionsList;
import com.softtantra.bizphone.service.LoginService;


@Controller
public class LoginController {
	
	
	
	@Autowired
	private LoginService loginservice;
	
	public void setLoginservice(LoginService loginservice) {
		this.loginservice = loginservice;
	}


	@RequestMapping(value="/adminlogin", method = RequestMethod.GET)
	 public String adminlogin() {
	  return "adminlogin";
	 
	 } 
	 
	 @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
		public String loginfailed(RedirectAttributes map,HttpSession session) {
			System.out.println("Inside loginfailed action controller");
			map.addFlashAttribute("error", "error");
			
				return "redirect:adminlogin";
			
		}
	 
	 @RequestMapping("/login")
		public String login(HttpSession session) {
			System.out.println("Inside login action controller");
			
				return "adminlogin";
		}
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public String logout(RedirectAttributes map) {
		 System.out.println("Inside logout action controller");
		 map.addFlashAttribute("logoutSuccess", "logoutSuccess");
				return "redirect:adminlogin";
			
		 
		 
	 }
	 
	 @RequestMapping("/dashboard")
		public String dashboard(ModelMap model, Principal principal,HttpServletRequest request ,HttpSession session ) {
			
		 if(principal!=null)
			{
			 
			try {
				System.out.println("Inside dashboard action controller");
				
				String username = principal.getName();
				LoginDetails result=loginservice.checkLogin(username);
				String department = loginservice.getDepartment(result.getUser_id());
				session.setAttribute("username",username);
				session.setAttribute("user_id", result.getUser_id());
				session.setAttribute("role_name", result.getPassword());
				session.setAttribute("department", department);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 return "index";
			}
			else 
			{
				return "adminlogin";
			
			}
		}
	 
	 @RequestMapping("fail2login")
	 public String failLogin(RedirectAttributes redirectAttributes){
		 redirectAttributes.addFlashAttribute("flag", 1);
		return "redirect:adminlogin"; 
		 
	 }

	 @RequestMapping("userPinLogin")
	 public String UserPinLogin(ModelMap map){
		 map.addAttribute("plantName", "�?Öß ×ÃÖ¬¤êüÀ¾Ö¸ü ÃÖÆüÛúÖ¸üß ÃÖÖÜÖ¸ü ÛúÖ¸üÜÖÖ®ÖÖ <br>×»Ö,Ûãú´Öšêü ÃÖÖê»ÖÖ¯Öæ¸ü¯ÖÖê.×™üÛêúÛú¸ü¾ÖÖ›üß,ŸÖÖ.ˆ¢Ö¸ü ÃÖÖê»ÖÖ¯Öæ¸ü,×•Ö.ÃÖÖê»ÖÖ¯Öæ¸ü(´Ö.¸üÖ.)");
		return "userPinLogin";
		 
	 }
	 
	 @RequestMapping("userHome")
	 public String UserHome(ModelMap map){
		 map.addAttribute("plantName", "�?Öß ×ÃÖ¬¤êüÀ¾Ö¸ü ÃÖÆüÛúÖ¸üß ÃÖÖÜÖ¸ü ÛúÖ¸üÜÖÖ®ÖÖ <br>×»Ö,Ûãú´Öšêü ÃÖÖê»ÖÖ¯Öæ¸ü¯ÖÖê.×™üÛêúÛú¸ü¾ÖÖ›üß,ŸÖÖ.ˆ¢Ö¸ü ÃÖÖê»ÖÖ¯Öæ¸ü,×•Ö.ÃÖÖê»ÖÖ¯Öæ¸ü(´Ö.¸üÖ.)");
		 map.addAttribute("ledgerInfo", "लेजर संबंधी माहिती");
		 map.addAttribute("shareInfo", "शेअर संबंधी माहिती");
		 map.addAttribute("ownInfo", "स�?वतः विषयी");
		 map.addAttribute("sugarcaneInfo", "ऊस संबंधी माहिती");
		 map.addAttribute("settingInfo", "सेटीन�?ग�?स");
		 map.addAttribute("billInfo", "बिल माहिती");
		 map.addAttribute("stockInfo", "साखर स�?टॉक");
		return "userHome"; 
		 
	 }
}
