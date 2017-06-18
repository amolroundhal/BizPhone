package com.softtantra.bizphone.daoImpl;

import java.math.BigInteger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.commons.DateConversions;
import com.softtantra.bizphone.dao.WsLoginDao;
import com.softtantra.bizphone.pojo.User;
import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsBusinessPerson;
import com.softtantra.bizphone.ws.WsLogin;

public class WsLoginDaoImpl implements WsLoginDao {
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Session initiateSession(){
		return sessionFactory.openSession();
	}
	
	private void destroySession(Session session) {
		if (session != null) {
			session.flush();
			session.close();
		}
	}

	@Override
	public int CheckLogin(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println(username+" - "+password);
		Session session = initiateSession();
		try {
			Query query = session.createSQLQuery("select ld.user_id from login_details ld INNER JOIN role r ON ld.role_id=r.id where binary ld.user_name=:un and binary ld.password=:pd AND ld.is_active=1 AND r.name in ('Business','Agent')")
					.setParameter("un", username)
					.setParameter("pd", password);
			int user_id =  (int) (query.setMaxResults(1).uniqueResult()!=null?query.setMaxResults(1).uniqueResult():0);
			if(user_id==0){
				return 0;
			}
			return user_id;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			destroySession(session);
		}
		return 0;
	}

	@Override
	public AjaxResponse login(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("select first_name,last_name,user_id from user_details where user_id="+userId+"");
				Object list = query.setMaxResults(1).uniqueResult();
				if(list!=null){
					Object[] objects = (Object[]) list;
					User user = new User();
					user.setFirst_name(objects[0] +" "+objects[1]);
					response.getData().put("user_name", user);
				}
				
				response.setStatus("success");
				response.setMsg("User name loaded.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("Error");
			response.setMsg("Exception : "+e.getMessage());
			e.printStackTrace();
		} finally {
			destroySession(session);
		}
		return response;

	}

	@Override
	public AjaxResponse uploadBusiness(WsBusinessPerson business, int userId,int roleId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				User user = new User();
				
			boolean result = mobileNumnerUniqueCheck(business.getMobile_no());
			if(result){
				user.setCreated_by(userId);
				user.setCreated_date(DateConversions.getCurrentDate());
				user.setEmail(business.getEmail());
				user.setFirst_name(business.getFirst_name());
				user.setLast_name(business.getLast_name());
				user.setMobile_no(business.getMobile_no());
				user.setPassword(business.getBusiness_password());
				user.setStatus(1);
				user.setRole_id(roleId);
				user.setUpdated_by(userId);
				user.setUpdated_date(DateConversions.getCurrentDate());
				session.save(user);
				response.setStatus("success");
				response.setMsg("Business added sucessfully.");
			}else{
				response.setStatus("failed");
				response.setMsg("This mobile number is already registered.");
			}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("Error");
			response.setMsg("Exception : "+e.getMessage());
			e.printStackTrace();
		} finally {
			destroySession(session);
		}
		return response;

	}

	private boolean mobileNumnerUniqueCheck(String mobile_no) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		try {
			Query query = session.createSQLQuery("select count(*) from user_details where mobile_no='"+mobile_no+"'") ;
			BigInteger count =  (BigInteger) (query.setMaxResults(1).uniqueResult()!=null?query.setMaxResults(1).uniqueResult():0);
			if(count.intValue()==0){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			destroySession(session);
		}
		return false;
	}

	@Override
	public int getRoleId(int userId) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		try {
			Query query = session.createSQLQuery("select role_id from user_details   where user_id="+userId+"");
			int role_id =  (int) (query.setMaxResults(1).uniqueResult()!=null?query.setMaxResults(1).uniqueResult():0);
			if(role_id==0){
				return 0;
			}
			return role_id;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			destroySession(session);
		}
		return 0;
	}
}
