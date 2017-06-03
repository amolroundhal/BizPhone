package com.softtantra.bizphone.daoImpl;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.CommonDao;

public class CommonDaoImpl implements CommonDao {

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
	public int getTotalRecordCount(String query) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		try{
			return ((BigInteger) session.createSQLQuery(query).setMaxResults(1).uniqueResult()).intValue();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			destroySession(session);
		}
		return 0;
	}
	
	@Override
	public List getDataList(String query1, int iNITIAL, int rECORD_SIZE) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		try{
			Query query = session.createSQLQuery(query1).setFirstResult(iNITIAL).setMaxResults(rECORD_SIZE);
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			destroySession(session);
		}
	}

	@Override
	public Map<Integer, String> getChitBoys(HttpSession session1) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		Map<Integer, String> chitboys = new HashMap<>();
		try{
			Query query = session.createQuery("Select user_id, name from User where role_id=(select id from Role where name='Chit Boy') and status<>0");
			for (Object object : query.list()) {
				Object [] objects = (Object[]) object;
				chitboys.put((Integer) objects[0], (String) objects[1]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			destroySession(session);
		}
		return chitboys;
	}

	@Override
	public Map<Integer, String> getDepartments(HttpSession session1) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		Map<Integer, String> departments = new HashMap<>();
		try{
			Query query = session.createQuery("Select department_id, department_name from Department where status<>0");
			for (Object object : query.list()) {
				Object [] objects = (Object[]) object;
				departments.put((Integer) objects[0], (String) objects[1]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			destroySession(session);
		}
		return departments;
	}

}
