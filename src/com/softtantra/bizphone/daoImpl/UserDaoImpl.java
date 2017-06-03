package com.softtantra.bizphone.daoImpl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.commons.DateConversions;
import com.softtantra.bizphone.dao.UserDao;
import com.softtantra.bizphone.pojo.LoginDetails;
import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.User;

public class UserDaoImpl implements UserDao{

	
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
	public List<Role> geRoles() {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		List<Role> role = new ArrayList<Role>();
		try {
			Query query = session.createSQLQuery("select id,name from role where status=1");
			List list = query.list();
			
			//System.out.println("query--"+query.list());
			for(int i=0;i<list.size();i++){
				Role r=new  Role();
			Object[] object= (Object[]) list.get(i);
			int s1= (Integer) object[0];
		    String s2=(String) object[1];
		    r.setId(s1);
		    r.setName(s2);
		    //System.out.println("id and name--"+s1+"-"+s2);
			   role.add(r);
			}	
			
			
			
			return role;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			destroySession(session);
		}
		
	}
	
	
	@Override
	public boolean saveUser(User user, int u_id) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		try {
			
			user.setCreated_by(u_id);
			user.setCreated_date(DateConversions.getCurrentDate());
			user.setUpdated_by(u_id);
			user.setUpdated_date(DateConversions.getCurrentDate());
			
			session.save(user);
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			destroySession(session);
		}
		
	}
	
	
	
	@Override
	public List<User> getAllUserList(int status,int c_id) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		List<User> user = new ArrayList<User>();
		try {
			
			String main_query="SELECT  u.user_id,u.first_name,u.last_name,'' as update_date_time,r.name FROM user_details u join   role r on u.role_id=r.id and u.status="+status+" and  u.company_id="+c_id+"  ";

			
			Query query = session.createSQLQuery(main_query);
		    //System.out.println("in getAllUserList main_query--"+main_query);
			
			List list=query.list();
			
			for(int a=0;a<list.size();a++){
				User u=new User();
					Object[] obj = (Object[]) list.get(a);
					
					
					u.setUser_id((Integer) obj[0]);
					//u.setFirst_name((String) obj[1]);
					//u.setLast_name((String) obj[2]);
					
					//u.setRole_name((String) obj[4]);
					user.add(u);
					//System.out.println("obj---"+obj[0]+"-"+obj[1]+"-"+obj[2]+"-"+obj[3]+"-"+obj[4]+"newlist--"+user);
				}
			
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			destroySession(session);
		}
	}
	
	@Override
	public boolean deleteUser(int user_id) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		Transaction transaction=session.beginTransaction();
		try {
			Query query1=session.createQuery("update  User set status=0 where user_id="+user_id+"");
			query1.executeUpdate();
			
			/*Query query=session.createQuery("update  LoginDetails set is_active=0  where user_id="+user_id+"");
			query.executeUpdate();*/
		    transaction.commit();	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			destroySession(session);
		}
		return true;
	}
	
	@Override
	public User getUserInfoForEdit(int user_id) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		
		try {
			
			String main_query="SELECT u.user_id,u.email,u.first_name,u.mobile_no,u.role_id,u.status,login.password,u.last_name FROM user_details u INNER JOIN login_details login ON u.user_id=login.user_id where u.user_id="+user_id+" ";
			
			Query query = session.createSQLQuery(main_query);
			
			if(query.setMaxResults(1).uniqueResult()!=null){
				User u=new User();
					Object[] obj = (Object[]) query.setMaxResults(1).uniqueResult();
					
					u.setUser_id((Integer) obj[0]);
					u.setEmail((String) obj[1]);
					u.setFirst_name((String) obj[2]);
					u.setMobile_no((String) obj[3]);
					u.setRole_id((Integer) obj[4]);
					u.setStatus((Integer) obj[5]);
					u.setPassword((String) obj[6]);
					u.setLast_name((String) obj[7]);
					return u; 
			  }else{
				  return null;
			  }
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			destroySession(session);
		}
	}
	
	@Override
	public boolean saveEditedUser(User user,int u_id) {
		// TODO Auto-generated method stub
		Session session = initiateSession();
		Transaction transaction=session.beginTransaction();
		try {
		
			Query query1=session.createQuery("update  User set first_name='"+user.getFirst_name()+"',last_name='"+user.getLast_name()+"',email='"+user.getEmail()+"',role_id="+user.getRole_id()+",mobile_no='"+user.getMobile_no()+"',updated_by="+u_id+",updated_date='"+DateConversions.parseDateToString(DateConversions.getCurrentDate(), DateConversions.SQL_DATE)+"',role_id="+user.getRole_id()+",status="+user.getStatus()+",password='"+user.getPassword()+"' where user_id="+user.getUser_id()+"");
			query1.executeUpdate();
			
			/* query1=session.createQuery("update  LoginDetails set password=:pd,role_id=:rid where user_id=:uid ")
					.setParameter("pd", user.getPassword())
					.setParameter("rid", user.getRole_id())
					.setParameter("uid", user.getUser_id());
			query1.executeUpdate();*/
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			destroySession(session);
		}
		return true;
	}

	@Override
	public boolean CheckMobileNoUnique(String mobile_no, HttpSession session1) {
		// TODO Auto-generated method stub
		Session session=initiateSession();
		try {
			Query query=session.createQuery("select user_id from User where mobile_no='"+mobile_no+"'");
			
				if(query.setMaxResults(1).uniqueResult()==null){
					return false;
				}else{
					return true;
				}
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return true;
		}finally{
			destroySession(session);
		}
	}

	@Override
	public boolean CheckMobileNoUniqueEdit(String mobile_no, String mobile_no1,
			HttpSession session1) {
		// TODO Auto-generated method stub
		Session session=initiateSession();
		try {
			Query query=session.createQuery("select user_id from User where mobile_no='"+mobile_no+"'");
			
				if(query.setMaxResults(1).uniqueResult()==null){
					return false;
				}else{
					return true;
				}
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return true;
		}finally{
			destroySession(session);
		}

	}

	

}
