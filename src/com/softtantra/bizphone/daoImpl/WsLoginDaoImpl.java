package com.softtantra.bizphone.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.WsLoginDao;

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
			Query query = session.createSQLQuery("select ld.user_id from login_details ld INNER JOIN role r ON ld.role_id=r.id where binary ld.user_name=:un and binary ld.password=:pd AND ld.is_active=1 AND r.name='Chit Boy'")
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
}
