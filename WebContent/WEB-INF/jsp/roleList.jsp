<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#imgLoader {
   width: 100%;
   height: 100%;
   top: 0;
   left: 0;
   position: absolute;
   display: block;
   opacity: 0.9;
   background-color: #fff;
   z-index: 50;
   text-align: center;
}
/* #loading-image {
  position: absolute;
  top: 25%;
  left: 25%;
  z-index: 50;
}
 */
</style>
  <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            <small></small>
          </h1>
          <!-- <ol class="breadcrumb">
            <li><a href="#">Role</a></li>
            <li class="active">Role List</li>
          </ol> -->
        </section>

        <!-- Main content -->
        <section class="content">
        
<%-- <div class="box box-danger">
            <div class="box-header with-border">
              <h3 class="box-title">User Role List</h3>
              <div class="box-tools pull-right"> 
                <!-- <button class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button> -->
                <!-- <button class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button> -->
              </div>
            </div>
            <div class="box-body">
	           <div class="form-horizontal">
	          <form action=""  id="getProductList" name="getProductList" method="post"> 
	           
				<div class="col-md-12 col-xs-12">
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
					 	
					 <div class="col-md-2">
					      <a href="#" class="btn btn-sm btn-success" type="button"><span class="glyphicon glyphicon-plus"></span>Add User Role</a>
					 </div>
					 
					 <div class="col-md-2">
					     <!--<a href="" class="btn btn-success" type="button">Show Archive Product</a> -->
					      <!-- <button type="button" id="archivebtn" onclick="hideDiv(2)" class="btn btn-warning">Show Archive User Role</button>
					      <button type="button" id="activebtn" onclick="hideDiv(1)" class="btn btn-success" style="display: none;">Show Active User Role</button> -->
					     <!-- <a href="getRole?status=1" id="archivebtn" onclick="hideDiv()" class="btn btn-success" type="button">Show Archive User Role</a>
					     <a href="getRole?status=2" id="activebtn" onclick="hideDiv()" class="btn btn-success" type="button" style="display: none;">Show Archive User Role</a> -->
					      
                         <c:if test="${rolestatus eq 2}">
                         	<a href="getUserRole?status=2" id="archivebtn"  class="btn btn-sm btn-warning" type="button">Show Archive User Role</a>
                         </c:if>
                         <c:if test="${rolestatus eq 1}">
                         	 <a href="getUserRole?status=1" id="activebtn"  class="btn btn-sm btn-success" type="button" >Show Active User Role</a>
                         </c:if>
					 </div>
				 </div>
				 <%
				 session.setAttribute("rolestatus", "");
				 %>
              </form>
             </div>
            </div><!-- /.box-body -->
          </div><!-- /.box -->
 --%>
         
          <div class="box">
          <form action=""  id="getProductList" name="getProductList" method="post">
          <div class="box box-danger">
                <div class="box-header with-border">
                 <c:if test="${rolestatus eq 1}">
                <h3 class="box-title" id="box_header">Active User List</h3>
                </c:if>
                <c:if test="${rolestatus eq 2}">
                <h3 class="box-title" id="box_header">Archive User List</h3>
                </c:if>
                <div class="col-md-12 col-xs-12">
                  <div class="col-md-4"></div>
                  <div class="col-md-2"></div>
                  <div class="col-md-6">
                     <div class="col-md-3">
                          <a href="#" class="btn btn-sm btn-success" type="button" ><span class="glyphicon glyphicon-plus"></span>Add User Role</a>
                     </div> 
                     <div class="col-md-3">
                     	  <%-- <c:if test="${rolestatus eq 2}">
                         	<a href="getUserRole?status=2" id="archivebtn" onclick="hideDiv(1)" class="btn btn-sm btn-warning" type="button">Show Archive User Role</a>
                          </c:if> --%>
                          <c:if test="${rolestatus eq 1}">
                         	 <a href="getUserRole?status=1" id="activebtn" onclick="hideDiv(2)" class="btn btn-sm btn-success" type="button" >Show Active User Role</a>
                          </c:if>
                          <c:if test="${rolestatus eq 2}">
                         	<a href="getUserRole?status=2" id="archivebtn" onclick="hideDiv(1)" class="btn btn-sm btn-warning" type="button">Show Archive User Role</a>
                          </c:if>
                    </div> 
                  </div>
                </div>
                 <%
				    session.setAttribute("rolestatus", "");
				 %>
                </div><!-- /.box-header -->
                <div class="box-body">
                <div class="overlay" id="imgLoader">
                  <i class="fa fa-refresh fa-spin"></i>
                </div>
               		<table id="example1" class="table table-bordered table-striped">
                    <thead>
                      <tr>
                        <th>SR.No</th>
                        <th>Role Name</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${userroleList}" var="userroleList" varStatus="stat">
                      <tr>
                        <td>${stat.count}</td>
                        <td>${userroleList.name}</td>
                        <td><a href="#" class="btn btn-info" ><span class="glyphicon glyphicon-edit"></span></a>
                        </td>
                      </tr>
                     </c:forEach>				  
                  </tbody>
                  <tfoot>
                 
                    </tfoot>
                  </table>
                </div><!-- /.box-body -->
              </div>
            </form>
          </div>

      </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      
     <!--  <div id="imgLoader" style="display: none;">
  		<img id="loading-image" src="dist/img/Loading_icon.gif" alt="Loading..." />
	  </div> -->
      
            <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
			<!-- <script src="bootstrap/js/bootstrap.min.js"></script> -->
			<script type="text/javascript" src="plugins/jquery.validate.min.js"></script>
            <script type="text/javascript" src="plugins/additional-methods.min.js"></script>
            <script src="plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>


<script type="text/javascript">
$(function(){
	$("#imgLoader").show();
});

$("#imgLoader").hide();

$('#example1').dataTable({
  	"paging": true,
      "lengthChange": true,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": false
  });
  
  
</script>
           

<script type="text/javascript">
function hideDiv(value){
	
	//alert("hi");
	status = value;
	 
	if(value==1){
		/* $("#div11").hide();
		$("#div12").show(); */
		//$("#box_header").text('Active Role List');
		$("#box_header").text('Active Role List');
		
	    }else{
		/* $("#div11").show();
		$("#div12").hide(); */
		//$("#box_header").text('Archive Role List');
		$("#box_header").text('Archive Role List');
		
	}
	   
} 

$(document).ajaxStart(function(){
	 //alert("inside")
	 $("#imgLoader").show();
   });
   $(document).ajaxComplete(function(){
   	//alert("inside")
   	$("#imgLoader").hide();
   }); 
</script>



