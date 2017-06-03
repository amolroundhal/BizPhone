package com.softtantra.bizphone.daoImpl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.LoginDao;
import com.softtantra.bizphone.pojo.LoginDetails;
import com.softtantra.bizphone.pojo.PermissionsList;

public class LoginDaoImpl implements LoginDao{

	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session initiateSession() {
		return sessionFactory.openSession();
	}

	private void destroySession(Session session) {
		if (session != null) {
			session.flush();
			session.close();
		}
	}

	@Override
	public LoginDetails checkLogin(String username) {
		// TODO Auto-generated method stub

		//System.out.println("Inside checkLogin method dao");
		LoginDetails details=new LoginDetails();
		Session session = initiateSession();
		try {
			
		
		
		Object object = session.createSQLQuery("SELECT ld.login_id, ld.role_id, ld.user_id, ld.user_name, r.name FROM login_details ld LEFT OUTER JOIN role r ON ld.role_id=r.id WHERE ld.user_name='"+username+"'").setMaxResults(1).uniqueResult();

		if(object != null){
			Object[] objects = (Object[]) object;
			details.setLogin_id(((BigInteger) objects[0]).longValue());
			details.setRole_id((int) objects[1]);
			details.setUser_id((int) objects[2]);
			details.setUser_name(username);
			details.setPassword((String) objects[4]);
		}
		
		//System.out.println("details "+details);
		
		return details;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			destroySession(session);
		
		}
		
		
		
	}

	@Override
	public String getDepartment(int user_id) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		String dept = "";
		try {
			Query query = session.createSQLQuery("select d.department_name from user_details u inner join department_details d on u.department_id=d.department_id and u.user_id="+user_id);
			dept = (String) query.setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			destroySession(session);
		}
		return dept;
	}
	

}
