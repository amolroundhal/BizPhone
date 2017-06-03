package com.softtantra.bizphone.daoImpl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.dao.WsDatasyncDao;
import com.softtantra.bizphone.ws.AjaxResponse;
import com.softtantra.bizphone.ws.WsCounts;
import com.softtantra.bizphone.ws.WsLogin;

public class WsDatasyncDaoImpl implements WsDatasyncDao {
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
	public AjaxResponse check_counts(WsCounts count, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				Query query = session.createSQLQuery("SELECT count(*) FROM farmer_details fd INNER JOIN village_allocation va ON fd.village_id=va.village_id AND va.status=1 AND va.user_id=:uid")
						.setParameter("uid", userId);
				int num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setFarmers(num);
				query = session.createSQLQuery("SELECT count(*) FROM village_allocation va WHERE va.status=1 AND va.user_id=:uid")
						.setParameter("uid", userId);
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setVillages(num);
				query = session.createSQLQuery("SELECT count(*) FROM category_details");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setCategories(num);
				query = session.createSQLQuery("SELECT count(*) FROM section_details where status=1");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setSections(num);
				query = session.createSQLQuery("SELECT count(*) FROM route_details rd INNER JOIN village_allocation va ON rd.village_id=va.village_id AND va.status=1 AND va.user_id=:uid")
							.setParameter("uid", userId);
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setRoutes(num);
				query = session.createSQLQuery("SELECT count(*) FROM irrigation_type");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setIrrigation_types(num);
				query = session.createSQLQuery("SELECT count(*) FROM irrigation_method");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setIrrigation_methods(num);
				query = session.createSQLQuery("SELECT count(*) FROM plantation_type");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setPlantation_types(num);
				query = session.createSQLQuery("SELECT count(*) FROM plantation_method");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setPlantation_methods(num);
				query = session.createSQLQuery("SELECT count(*) FROM sugarcane_variety");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setSugarcane_varieties(num);
				query = session.createSQLQuery("SELECT count(*) FROM sugarcane_season");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setSugarcane_seasons(num);
				query = session.createSQLQuery("SELECT count(*) FROM registration_type");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setRegistration_types(num);
				query = session.createSQLQuery("SELECT count(*) FROM user_details ud INNER JOIN role r ON ud.role_id=r.id AND r.name='Chit Boy' and ud.status=1");
				num = ((BigInteger) query.setMaxResults(1).uniqueResult()).intValue();
				count.setUsers(num);
				response.setStatus("success");
				response.setMsg("Counts checked.");
				response.getData().put("count", count);
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
	public AjaxResponse getUsers(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT ud.user_id, ud.name, ud.email, ud.password FROM user_details ud INNER JOIN role r ON ud.role_id=r.id AND r.name='Chit Boy' and ud.status=1");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int user_id = (int) objects[0];
					String name = (String) objects[1];
					String email = (String) objects[2];
					String password = (String) objects[3];
					
					values += "(" + user_id + ", '" + name + "', '" + email + "', '" + password + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Users loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getRegistration_types(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT registration_type_id, type from registration_type");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String type = (String) objects[1];
					
					values += "(" + id + ", '" + type + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Registration types loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getCategories(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT category_id, english_name, marathi_name from category_details");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Categories loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getIrrigation_types(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT irrigation_type_id, english_name, marathi_name from irrigation_type");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Irrigation types loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getIrrigation_methods(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT irrigation_method_id, english_name, marathi_name from irrigation_method");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Irrigation methods loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getPlantation_types(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT plantation_type_id, english_name, marathi_name from plantation_type");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Plantation types loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getPlantation_methods(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT plantation_method_id, english_name, marathi_name from plantation_method");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Plantation methods loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getSugarcane_seasons(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT sugarcane_season_id, english_name, marathi_name from sugarcane_season");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Sugarcane seasons loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getSugarcane_varities(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT sugarcane_variety_id, english_name, marathi_name from sugarcane_variety");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Sugarcane varities loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getSections(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT section_id, english_name, marathi_name from section_details");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Sections loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getRoutes(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT route_id, route_name, village_id from route_details");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String rName = (String) objects[1];
					int vid = (int) objects[2];
					
					values += "(" + id + ", '" + rName + "', " + vid + "),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Routes loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getVillages(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT village_id, english_name, marathi_name, section_id from village_details");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					int sid = (int) objects[3];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "', " + sid + "),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Villages loaded.");
				response.getData().put("values", values);
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
	public AjaxResponse getFarmers(WsLogin login, int userId) {
		// TODO Auto-generated method stub
		AjaxResponse response = new AjaxResponse();
		Session session = initiateSession();
		try {
			if(userId==0){
				response.setStatus("Error");
				response.setMsg("Login Failed");
			}else {
				String values = "";
				Query query = session.createSQLQuery("SELECT farmer_id, english_name, marathi_name, category, village_id, address, mobile_no from farmer_details");
				List list = query.setFirstResult(login.getPage_size() * (login.getPage_no() - 1)).setMaxResults(login.getPage_size()).list();
				for (Object object : list) {
					Object[] objects = (Object[]) object;
					int id = (int) objects[0];
					String eName = (String) objects[1];
					String mName = (String) objects[2];
					int cid = (int) objects[3];
					int vid = (int) objects[4];
					String addr = (String) objects[5];
					String mob = (String) objects[6];
					
					values += "(" + id + ", '" + eName + "', '" + mName + "', " + cid + ", " + vid + ", '" + addr + "', '" + mob + "'),";
				}
				if(values.endsWith(",")){
					values = values.substring(0, values.length() - 1);
				}
				response.setStatus("success");
				response.setMsg("Farmers loaded.");
				response.getData().put("values", values);
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
}
