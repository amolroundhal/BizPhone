   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
  <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          
           <%-- <%int path=(Integer)session.getAttribute("profile_image");
                  
                  System.out.println("pathhhh--"+path);%>
                  <% 
                  if(path==1){  System.out.println("<c:if --"+path);
                  %> --%>

          <div class="user-panel">

            <div class="pull-left image">
            
            
              <img src="dist/img/avatar5.png" class="img-circle" alt="User Image">
              
             
            </div>
            <div class="pull-left info">
              <p>${sessionScope.department } - ${sessionScope.role_name }</p>
              <a href="#"><i class="fa fa-circle text-success"></i> ${sessionScope.username }</a>
            </div>
          </div>
          
           
          
          
          
         
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MENU</li>
            <li class="active treeview">
              <a href="dashboard">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
              </a>
            </li>
            
          <%--   <security:authorize access="hasAnyRole('dealer_user','dealer_role')"> --%>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-wrench"></i>
                <span>Master Settings</span><i class="fa fa-angle-left pull-right"></i>
			  </a>
               <ul class="treeview-menu">
                
                <%--   <security:authorize access="hasAnyRole('dealer_user')"> --%>
			        <li class="treeview">  <a href="getUsers"> <span>Users</span> </a> </li> 
			      <%-- </security:authorize> --%>
			       
			      <%-- <security:authorize access="hasAnyRole('dealer_role')"> --%>
			        <li class="treeview">  <a href="RoleList"> <span>Roles</span>  </a> </li> 
			     <%--  </security:authorize> --%>
			      
			     
          		    
            	</ul>
            </li>
			
         
              </ul>
		           
            
            
            
        </section>
        <!-- /.sidebar -->
      </aside>