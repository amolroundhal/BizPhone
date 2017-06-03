<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

      <style>

#imgLoader {
   width: 100%;
   height: 100%;
   top: 0;
   left: 0;
   position: fixed;
   display: block;
   opacity: 0.9;
   background-color: #fff;
   z-index: 200;
   text-align: center;
}

#loading-image {
  position: absolute;
  top: 100px;
  left: 540px;
  z-index: 200;
}
</style>

  <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            <small></small>
          </h1>
          <!-- <ol class="breadcrumb">
            <li><a href="#">Users</a></li>
            <li class="active">user List</li>
          </ol> -->
        </section>

        <!-- Main content -->
        <section class="content">
		<p>
		
		<c:if test="${flagCount eq 1 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> You cross the limit to register users.</p>
							</div>
		      </c:if>
	
			<c:if test="${flag eq 1 }">
		      	<div class="alert alert-success alert-dismissable" class="close"
								data-dismiss="alert">
								<p> User added successfully.</p>
							</div>
		      </c:if>
		      <c:if test="${flag eq 0 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> User failed to add.</p>
							</div>
		      </c:if>
		      
		      
		      <c:if test="${flag1 eq 1 }">
		      	<div class="alert alert-success alert-dismissable" class="close"
								data-dismiss="alert">
								<p> User edited successfully.</p>
							</div>
		      </c:if>
		      <c:if test="${flag1 eq 0 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> User failed to edit.</p>
							</div>
		      </c:if>
		      
		         <c:if test="${flag3 eq 1 }">
		      	<div class="alert alert-success alert-dismissable" class="close"
								data-dismiss="alert">
								<p> User deleted successfully.</p>
							</div>
		      </c:if>
		      <c:if test="${flag3 eq 0 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> User failed to delete.</p>
							</div>
		      </c:if>
		      
	      
		   <c:if test="${flag2 eq 1}">
				      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> Please select at least one field.</p>
							</div>
		      </c:if>
       </p>
          <!-- Default box -->
          <%-- <div class="box box-danger">
            <div class="box-header with-border">
              <h3 class="box-title">Search User</h3>
            
            </div>
            <div class="box-body">
	           <div class="form-horizontal">
	           <form  method="post" id="searchUser1" name="searchUser1">
	           
	           <div class="row">
				<div class="col-md-12">
					 <div class="col-md-4 col-xs-8">
									<div class="col-xs-12">
                <div class="form-group">
                   
                   <div class="input-group" id="active_group">
                    <div class="input-group-btn">
                      <button type="button" class="btn btn-danger">User</button>
                    </div><!-- /btn-group -->
                    <input type="text" id="user_full_name" name="user_full_name" class="form-control">
                  </div>
                  
                  
                  <div class="input-group" id="archive_group" style="display: none;">
                    <div class="input-group-btn">
                      <button type="button" class="btn btn-danger">User</button>
                    </div><!-- /btn-group -->
                    <input type="text" id="user_full_name1" name="user_full_name1" class="form-control">
                  </div>
                  </div>
				</div>
                </div>
               <div class="col-md-2 col-xs-4">
									<div class="col-xs-12">
                      <div class="form-group">

                    
                      <select class="form-control" id="state" onchange="getStateWiseCity(this.value)" name="state">
                      <option value="">--Select State--</option>
                      <c:forEach items="${states}" var="states">
					 <option value="${states.state_id}">${states.state_name}</option>
				    </c:forEach>
                      </select>
                      </div>

                    </div>
              </div>
           <div class="col-md-2 col-xs-4">
									<div class="col-xs-12">
                   <div class="form-group">

                      
                      <select class="form-control" id="city" name="city">
                      <option value="">--Select City--</option>
                     
                      </select>
                      </div>

                    </div>
               </div>
       				<div class="col-md-2 col-xs-4">
									<div class="col-xs-12">
                    <div class="form-group">

                     
                      <select class="form-control" id="role_id" name="role_id">
                      <option value="">--Select Role--</option> 
                     <c:forEach items="${roles}" var="roles">
							    <option value="${roles.id}">${roles.name}</option>
				    </c:forEach>
                      </select>
                      </div>

                    </div>
                    </div>
                
                	<div class="col-md-1 col-xs-2">
                    <button  onclick="searchUserParam()" type="button" class="btn btn-danger"><span class="glyphicon glyphicon-search"></span></button>
                   
                    </div>
                    
                     <div class="col-md-1 col-xs-2">
					     <!--<a href="" class="btn btn-success" type="button">Show Archive Product</a> -->
					        <a type="button"  href="getUsers" class="btn btn-danger">Reset</a> 
					     
					       	 
					
					 </div>
                    
                   
                    
                    
                </div>
                </div>
                
               <!-- new design --> 
                <div class="row">
					<div class="col-md-12">
					<div class="col-md-6"></div>
						<div class="col-md-2 col-xs-6">
							 <a href="addUser" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>&nbsp&nbsp&nbsp  Add User &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </a>
					      
						</div>
						<div class="col-md-2 col-xs-6">
							 <button type="button" id="archivebtn" onclick="hideDiv(2)" class="btn btn-warning">Show Archive Users</button>
					      <button type="button" id="activebtn" onclick="hideDiv(1)" class="btn btn-success" style="display: none;">Show Active Users</button>
			    </div>
						
						<div class="col-md-1 col-xs-6">
							<a  class="btn btn-warning" href="importUser">Import</a>
               
						</div>
						
						<div class="col-md-1 col-xs-6">
							 <a type="button" id="export1" href="exportUsers?status=1" class="btn btn-danger">Export</a> 
					      <a type="button" id="export2" href="exportUsers?status=2" class="btn btn-danger" style="display: none;">Export</a>
			
						
						</div>
						
						
					</div>
				</div>
				
				
				
                
               
                
               </form>
            </div>
            </div>
          </div> --%>
              
          <div class="box">
           
          <div class="box box-danger">
         
                <div class="box-header with-border">
                  <h3 class="box-title" id="box_header">Users</h3>
                   <div style="" align="right">
                   
                   			<a href="addUser" class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> Add User </a>
							 <!-- <a type="button" id="export1" href="exportUsers?status=1" class="btn btn-danger">Export</a> --> 
					     
						
						</div>
                </div><!-- /.box-header -->
               
						
                <div class="box-body" style="overflow-x:auto;">
               			<table id="example1" class="table table-bordered table-striped">
                    <thead>
                      <tr>
                        <th>SR. No</th>
                        <th>Name</th>
                        <th>Role</th>
                        <th>Status</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                   <%--  <c:forEach items="${userList}" var="userList" varStatus="stat">
                   
                      <tr>
                        <td>${stat.count}</td>
                        <td><b>${userList.first_name} ${userList.last_name}</b></td>
                        <td>${userList.role_name}</td>
                        <!-- 12 Jun 2016 10:30:26 -->
                        <td>${userList.last_login}</td>
                        <td>
                        
                        <a href="getUserInfoForEdit?user_id=${userList.user_id}" class="btn btn-danger"><span class="glyphicon glyphicon-user"></span></a>
                        |<a class="btn btn-warning"><span class="glyphicon glyphicon-road"></span></a>
                        |<a class="btn btn-info" ><span class="glyphicon glyphicon-edit"></span></a>
                        
                        </td>
                      </tr>
                  </c:forEach> --%>
                  </tbody>
                  <tfoot>
                 
                    </tfoot>
                  </table>
                </div><!-- /.box-body -->
              </div>
          </div>

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
   
      <!-- delete model -->
 <div id="imgLoader" style="display: none;">
  <img id="loading-image" src="dist/img/Loading_icon.gif" alt="Loading..." />
             </div>
<div class="modal fade" id="DeleteUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="myModalLabel">Delete Users</h3>
			</div>


			<form role="form" action="deleteUser" method="post">

				<div class="modal-body">

					<div class="row">
						<div class="col-md-12">
							<div class="isa_warning">
								<h4><center> <i class="fa fa-warning"></i> <b>Do you want to delete this user ?</b></center></h4>
							</div>
						</div>
						<div class="col-md-12">
							<input type="hidden" id="user_id" name="user_id">
							<div class="modal-footer" ><center>
								<input type="submit" class="btn btn-success" value="Delete">&nbsp;
								<a href="#" class="btn btn-danger" data-dismiss="modal">Cancel</a></center>
							</div>
							<!-- /.row -->
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>  

 <div id="imgLoader" style="display: none;">
  <img id="loading-image" src="dist/img/Loading_icon.gif" alt="Loading..." />
</div>
      <!-- <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
       -->
       <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
			<!-- <script src="bootstrap/js/bootstrap.min.js"></script> -->
			<script type="text/javascript" src="plugins/jquery.validate.min.js"></script>
            <script type="text/javascript" src="plugins/additional-methods.min.js"></script>
            <script src="plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
            
          <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>  
  
			 <!-- <script src="bootstrap/js/bootstrap.min.js"></script> -->
			
<script type="text/javascript">

$('#DeleteUserModal').on('show.bs.modal', function(e) {


	var id = $(e.relatedTarget).data('id');
	//alert("inside DeleteUserModal...:"+id);
	$(e.currentTarget).find('input[name="user_id"]').val(id);

});

$(function() {
	  //alert("in fun");
	 $("#imgLoader").show();   
	    var st=0;
	    var tempArr=new Array();
	  <c:forEach items="${users1}" var="users1">
	    
	 tempArr[st]="<c:out value="${users1}" />";
	  //alert(st);
	  st++;
	  </c:forEach> 


	 
	  $("#user_full_name").autocomplete({
		 
	  source: tempArr
	 
	  });
	  
	  /////////////////////
	   var st1=0;
	    var tempArr1=new Array();
	  <c:forEach items="${users2}" var="users2">
	    
	 tempArr1[st1]="<c:out value="${users2}" />";
	  //alert(st);
	  st1++;
	  </c:forEach>  


	 
	  $("#user_full_name1").autocomplete({
		 
	  source: tempArr1
	 
	  });
	  
	  

	
	 
});

function getStateWiseCity(state_id){
	//$("#city").value("");
	                 $("#city").empty();
		  				var option = $('<option />');
		  				option.attr('value',"").text("Select City");
		  				$("#city").append(option);
	$.ajax({

		url : '${home}getStateWiseCity',
		type : 'POST',
		data : {
			state_id : state_id
			
		},
		dataType : 'json',
		success : function(result) {
			if (result) {
				
				//alert("success");
				for(var i=0;i<result.length;i++){
					var option = $('<option />');
				option.attr('value',result[i].city_id).text(result[i].city_name);
				$("#city").append(option);
					
					}
			} else {
			//alert("failure111");
				//$("#ajax_div").hide();
			}

		}
	});
}



function GetRoutesInfo(value)
{
//alert("inside modal"+value);

	 $.ajax({

	url : '${home}getRoutes',
	type : 'POST',
	data : {
	value : value,
	},
	dataType : 'json',
	success : function(result) {
	//alert(result.length);
	for(var i=0;i<result.length;i++){
	var option = $('<option />');
option.attr('value',result[i].route_id).text(result[i].route_name);
$("#route_id").append(option);
	
	}
	
	}
	});
	 
}
</script>


<!-- page initation -->
 <script type="text/javascript">
 var status = 1;

 //alert("innnnnnnn");
 $("#imgLoader").hide();
$('#example1').DataTable({
	"bServerSide": true,
    "bProcessing": true,
    "sPaginationType": "full_numbers",
    "sAjaxSource":  "UserListData?status="+status,
    "bFilter": false,
    "lengthMenu": [[20, 30, 50], [20, 30, 50]],
   });

</script>


<script type="text/javascript">

function searchUserParam() {
	var value = '';
	var state=$("#state").val();
	var city=$("#city").val();
	var role=$("#role_id").val();
	if(status==1){
		 value = $("#user_full_name").val();
	}
	if(status==2){
		 value = $("#user_full_name1").val();
	}
   
	//alert("hello "+value);
	if ($.fn.DataTable.isDataTable( '#example1')) {
		  $('#example1').DataTable().destroy();
	}
	$('#example1').DataTable({
		"bServerSide": true,
	    "bProcessing": true,
	    "sPaginationType": "full_numbers",
	    "sAjaxSource":  "UserListData?userName="+value+"&state="+state+"&city="+city+"&role="+role+"&status="+status,
	    "bFilter": false,
	    "lengthMenu": [[20, 30, 50], [20, 30, 50]],
	   });
	
	$("#state").val("");
	$("#city").val("");
	$("#role_id").val("");
	$("#user_full_name").val("");
	$("#user_full_name1").val("");

}
</script>



<script type="text/javascript">
function hideDiv(value){
	status = value;
	//alert("hello "+status);
	if(value==1){
		$("#activebtn").hide();
		$("#archivebtn").show();
		$("#box_header").text('Active User List');
		$("#archive_group").hide();
		$("#active_group").show();
		$("#export1").show();
		$("#export2").hide();
		
	}else{
		$("#archivebtn").hide();
		$("#activebtn").show();
		$("#box_header").text('Archive User List');
		$("#active_group").hide();
		$("#archive_group").show();
		$("#export1").hide();
		$("#export2").show();
	}
	if ($.fn.DataTable.isDataTable( '#example1' ) ) {
		  $('#example1').DataTable().destroy();
	}
	$('#example1').DataTable({
		"bServerSide": true,
	    "bProcessing": true,
	    "sPaginationType": "full_numbers",
	    "sAjaxSource":  "UserListData?status="+status,
	    "bFilter": false,
	    "lengthMenu": [[20, 30, 50], [20, 30, 50]],
	   });
	
	$("#state").val("");
	$("#city").val("");
	$("#role_id").val("");
	$("#user_full_name").val("");
	$("#user_full_name1").val("");
	
	   /* if( $("#hidefirst").is(':visible')){
		   $("#archivebtn").text("Product List");
		   $("#hidefirst").hide();
		   $("#hidesec").show();
	   }else{
		 
		   $("#archivebtn").text("Show Archive Product");
		   $("#hidefirst").show();
		   $("#hidesec").hide();
	   } */
	   
}

function exportUsers(status){
	alert(status);
	 $.ajax({

			url : '${home}exportUsers',
			type : 'POST',
			data : {
				status : status,
			},
			dataType : 'json',
			success : function(result) {
			alert("success");
			
			}
			});
}

$(document).ajaxStart(function(){
	 $("#imgLoader").show();
   });
   $(document).ajaxComplete(function(){
   	$("#imgLoader").hide();
   });
</script>
 