package com.softtantra.bizphone.daoImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.softtantra.bizphone.controller.LoginController;
import com.softtantra.bizphone.dao.RoleDao;
import com.softtantra.bizphone.pojo.Role;
import com.softtantra.bizphone.pojo.RolePermissions;

public class RoleDaoImpl implements RoleDao{

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
		public List<RolePermissions> getRolePermissionList(HttpSession session1) {
			Session session = initiateSession();
		//	int c_id=(int) session1.getAttribute("company_id");
			try{
				Criteria criteria = session.createCriteria(RolePermissions.class)
						.setProjection(Projections.projectionList()
								.add(Projections.property("id"), "id")
								.add(Projections.property("role_title"), "role_title")
								).setResultTransformer(Transformers.aliasToBean(RolePermissions.class));
						
				return criteria.list();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				destroySession(session);
			}
			return null;
		}

		
		@Override
		public boolean insertNewRole(String roleName, String description,
				 String adminCheck, String admin_name,
				 HttpSession session1,String admin_permission_id) {
			//System.out.println("inside inserRole");
			Session session=initiateSession();
			//int c_id=Integer.parseInt(session1.getAttribute("company_id")+"");
			int u_id=(int) session1.getAttribute("user_id");
			String role_name=(String) session1.getAttribute("role_name");

			/*if (role_name.equals("Dealer")){
				u_id=d_id;
					}*/
			
		Transaction tr = session.beginTransaction(); 
			try {
				Role role = new Role();
				role.setCreated_by(u_id);//
				role.setCreated_date(new Date());
				role.setDescription(description);
				role.setName(roleName);
				role.setStatus(1);
				role.setUpdated_by(u_id);//Integer.parseInt((String) session1.getAttribute("user_id"))
				role.setUpdated_date(new Date());
				//String[] adminRowSplit = admin_name.split(",");
				//String[] adminIdRowSplit = admin_permission_id.split(",");
				
				String[] adminCheckSplit = adminCheck.split(",");
				for(int i=0;i<adminCheckSplit.length;i++){	
					/*if(countSplit.length>1){*/
				
						//Long permissionId = (long) Integer.parseInt(adminIdRowSplit[i]);
						Long permissionId = Long.parseLong(adminCheckSplit[i]);	
						role.getRolePermissions().add((RolePermissions) session.get(RolePermissions.class, permissionId));
							
							
					}
				
				
				session.save(role);
				tr.commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				tr.rollback();
				e.printStackTrace();
				return false;
			}finally{
				destroySession(session);
			}
			return true;
		}


		@Override
		public boolean RoleName_unique(String roleName,HttpSession session1) {
			Session session = initiateSession();
			//int c_id=(int) session1.getAttribute("company_id");
			try {
				//if(!"Dealer".equalsIgnoreCase(roleName) && !"Admin".equalsIgnoreCase(roleName)){
					
					Query query = session.createQuery("select count(*) from Role where name=:mn and status<>0 ")
							.setParameter("mn", roleName);
					//return query.list();
					long count = (Long) query.setMaxResults(1).uniqueResult();
					//System.out.println("count "+count);
					if(count==0){
						return false;
					}
				//}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				destroySession(session);
			}
			return true;
		}
		
		//pagination
		
			
			
			@Override
			public Role getEditInfo(HttpSession session1, int roleId) {
				Session session = initiateSession();
				//int c_id=Integer.parseInt(session1.getAttribute("company_id")+"");
				try {
					Query query=session.createSQLQuery("SELECT role.name,role.description,role.status FROM role WHERE  role.id="+roleId+"");
					List list=query.list();
					for(Object object : list){
						Object[] obj=(Object[]) object;
						Role role = new Role();
						role.setName((String) obj[0]);
						role.setDescription((String) obj[1]);
						role.setStatus(Integer.parseInt(obj[2]+""));
						return role;
						
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					destroySession(session);
				}
				return null;
			}

			@Override
			public List<Role> getRoleHasPermissiomInfo(HttpSession session1, int roleId) {
				Session session = initiateSession();
				//int c_id=Integer.parseInt(session1.getAttribute("company_id")+"");
				List<Role> list2=new ArrayList<Role>();
				try {
					String query1="SELECT role_has_rolepermission.permission_id FROM role_has_rolepermission WHERE role_has_rolepermission.role_id="+roleId+"";
					
					Query query=session.createSQLQuery(query1);
					//System.out.println("query "+query);
					List list=query.list();
					
					for (Object object : list) {
						//Object[] obj=(Object[]) object;
						Role role = new Role();
						role.setPermission_id(((BigInteger) object).intValue());
						list2.add(role);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally{
					destroySession(session);
				}
				return list2;
			
			}
			
			@Override
			public boolean updateRole(String name, String description,
					String adminCheck,int role_id,
					HttpSession session1) {
			Session session=initiateSession();
			//int c_id=Integer.parseInt(session1.getAttribute("company_id")+"");
			int u_id=(int) session1.getAttribute("user_id");
			String role_name=(String) session1.getAttribute("role_name");

			/*if (role_name.equals("Dealer")){
				u_id=d_id;
					}*/
			try {
				Role role = new Role();
				role.setId(role_id);
				
				role.setCreated_by(u_id);//Integer.parseInt(session1.getAttribute("user_id")+"")
				role.setCreated_date(new Date());
				role.setDescription(description);
				role.setName(name);
				role.setStatus(1);
				role.setUpdated_by(u_id);//Integer.parseInt(session1.getAttribute("user_id")+"")
				role.setUpdated_date(new Date());
				String[] adminCheckSplit = adminCheck.split(",");
				
				for (String string : adminCheckSplit) {
					
					if(!string.equals(""))
					{
						Long permissionId=(Long.parseLong(string));
						role.getRolePermissions().add((RolePermissions) session.get(RolePermissions.class, permissionId));
					}
					}
				
					
				try {				
					Transaction tr=session.beginTransaction();
					session.saveOrUpdate(role);
					tr.commit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return true;
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				destroySession(session);
			}
			return false;
			}

			@Override
			public boolean deleteRole(Role role, HttpSession session1) {
				// TODO Auto-generated method stub
				
				Session session=initiateSession();
				try{
					
					//System.out.println("Inside deleteRole DaoImpl........!!!!");
					//System.out.println("rolerolerolerolerole"+role.getId());
					Query query= session.createQuery("update Role set status=:st where id=:id ")
							.setParameter("st",0)
							.setParameter("id",role.getId());
					int val= query.executeUpdate();
					if(val==0){
					return false;
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}finally{
					destroySession(session);
				}
				return true;
			}


}
