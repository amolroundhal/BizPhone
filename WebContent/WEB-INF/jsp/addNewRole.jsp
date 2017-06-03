 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!-- Main content -->
    <section class="content">
     <p>
	         <div id="ajax_div" style="display: none;" class="alert alert-warning alert-dismissable" class="close"
						data-dismiss="alert">
						<p>   <i class="fa fa-info-circle"></i> Role Name already exists. Please enter unique Role Name. </p>
			</div>
			
			<c:if test="${flag eq 1 }">
		      	<div class="alert alert-success alert-dismissable" class="close"
								data-dismiss="alert">
								<p><i class="fa fa-check-circle"></i> Role added successfully.</p>
			   </div>
		      </c:if>
		      <c:if test="${flag eq 0 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> Role addition failed.</p>
							</div>
		      </c:if>
	</p>
		<div class="box box-danger">
            <div class="box-header with-border">
              <h3 class="box-title">Add Role </h3>
            </div>
            <form  method="post" action="insertRoles" id="insertRoles">
            <div class="box-body">
				<div class="form-horizontal">
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							  <label for="inputEmail3" class="col-sm-4 control-label">Role Name <label style="color:red;">*</label></label>
							  <div class="col-sm-8">
								<input type="text" class="form-control" onchange="checkRoleName(this.value)" id="name" name="name" placeholder="Role Name" required="required">
							  <span id="RoleNameSpan" class="website"></span>
							  </div>
						</div>
						<div class="form-group">
							  <label for="inputEmail3" class="col-sm-4 control-label">Description <label style="color:red;">*</label> </label>
							  <div class="col-sm-8">
								<textarea rows="3" cols="50" id="description" name="description" class="form-control"></textarea>
							  </div>
						</div>
						<!-- <div class="form-group">
							  <label for="inputEmail3" class="col-sm-4 control-label">Status <label style="color:red;">*</label></label>
							  <div class="col-sm-8">
								<select class="form-control" id="status" name="status">
									<option value="1">Active</option>
									<option value="2">Deactive</option>
								</select>
							  </div>
						</div> -->
					</div>
					<div class="col-md-6 col-xs-12">
					<div class="alert alert-warning" class="close" id="msgDiv" style="display: none;">
								<p><i class="fa fa-check-circle"></i> Please select atleast one permission.</p>
			 		  </div>
						<div class="col-sm-12">
						<label for="inputEmail3" class="col-sm-6 control-label">Admin panel</label><br><br>
                 <div class="row">
                <div class="box-body" id="adminPer" style="height:500px;overflow:scroll;overflow-x: hidden;overflow-y:scroll;">
                <input type="hidden" value="0"  name="adminCheck">
               
               			<table id="example" class="table table-bordered table-striped">
                    <thead>
                      <tr>
                      	<th>Select</th>
						 <th>Name</th>
						
                      </tr>
                    </thead>
                    <tbody>
                 <c:forEach items="${rolePermissionList}" var="rolePermissionList" varStatus="stat">
                     <tr>
                         <td><input type="checkbox" value="${rolePermissionList.id}" name="adminCheck"></td>  
                         <%-- <td>${rolePermissionList.name}<input type="hidden" value="${rolePermissionList.id}"  name="admin_permission_id"><input type="hidden" value="${rolePermissionList.name}"  name="admin_name"></td> --%>
                     
                         <td>${rolePermissionList.role_title}<input type="hidden" value="${rolePermissionList.id}"  name="admin_permission_id"><input type="hidden" value="${rolePermissionList.role_title}"  name="admin_name"></td>
                     </tr>
                     </c:forEach>  
                  </tbody>
                  
                  <tfoot>
                 
                    </tfoot>
                    
                  </table>
                   
                </div><!-- /.box-body -->
                </div>
             </div>
             
             
             <%-- <div class="col-sm-6">
             <label for="inputEmail3" class="col-sm-6 control-label">Mobile App</label><br><br>
                 <div class="row">
                <div class="box-body" id="mobilePer" style="height:500px;overflow:scroll;overflow-x: hidden;overflow-y:scroll;">
                <input type="hidden" value="0" name="mobileCheck">
                		<table id="example1" class="table table-bordered table-striped">
                    <thead>
                      <tr>
                      	<th>Select</th>
						 <th>Name</th>
					 </tr>
                    </thead>
                    <tbody>
                 <c:forEach items="${mobilePermissionsList}" var="mobilePermissionsList" varStatus="stat">
                     <tr>
                         <td><input type="checkbox" value="${mobilePermissionsList.mobile_permissions_id}" name="mobileCheck"></td>  
                         <td>${mobilePermissionsList.permission_name}<input type="hidden" value="${mobilePermissionsList.mobile_permissions_id}"  name="mobile_permission_id"><input type="hidden" value="${mobilePermissionsList.permission_name}"  name="permission_name1"></td>
                         	                 
                     </tr>
                     </c:forEach>  
                  </tbody>
                  
                  <tfoot>
                 
                    </tfoot>
                    
                  </table>
                   
                </div><!-- /.box-body -->
                </div>
             </div> --%>
             
             </div>	
							
					</div>
				</div>	
				 <div class="box-footer" style="text-align: center;">
				 <button type="button" class="btn btn-success" onclick="checkCheckbox()">Save</button>
				 <!-- <input type="submit" id="submitButton" style="display: none;"> -->
				<a type="button" href="RoleList" class="btn btn-danger">Cancel</a>
				
            </div><!-- /.box-footer-->
            </form>
			</div><!-- /.box-body -->
           
       
	</section><!-- /.content -->
 </div><!-- /.box -->

<div id="imgLoader" style="display: none;">
  <img id="loading-image" src="dist/img/Loading_icon.gif" alt="Loading..." />
</div>
<!-- jQuery 2.1.4 -->
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
   <!-- <script src="bootstrap/js/bootstrap.min.js"></script> -->
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="plugins/jquery.validate.min.js"></script>
    <script src="plugins/additional-methods.min.js"></script>
      <script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyCEYryRhhLSTMWGQvyALGPfXYZO5zEcOsU&sensor=false"></script>



<script type="text/javascript">
//$("#adminCheck").is(':checked') ? 1 : 0;
//$("#mobileCheck").is(':checked') ? 1 : 0;

 $(document).ready(function() {
    $('#example').DataTable( {
       /*  "scrollY":        "160px",
        "scrollCollapse": true, */
        "paging":         false,
        "bPaginate": false,
        'searchable': false,
        "bLengthChange": false,
	      "bFilter": false,
	      "bInfo": false
    } );
} ); 

 $(document).ready(function() {
	    $('#example1').DataTable( {
	       /*  "scrollY":        "160px",
	        "scrollCollapse": true, */
	        "paging":         false,
	        "bPaginate": false,
	        'searchable': false,
	        "bLengthChange": false,
		      "bFilter": false,
		      "bInfo": false
	    } );
	} ); 

var valid = false;
 function checkCheckbox(){
	
	 //validatonFields();
	 if($("#insertRoles").valid()){
	 
	 
	var $inputs = $("#adminPer").find('input');
	$inputs.each(function(){
		if($(this).is(':checked')){
			valid = true;
			return ;
		}
	});
	/* if(!valid){
		var $inputs1 = $("#mobilePer").find('input');
		$inputs1.each(function(){
			if($(this).is(':checked')){
				valid = true;
				return ;
			}
		});
	} */
	
	if(valid){
		$("#msgDiv").hide();
		$("#insertRoles").submit();
	}else{
		$("#msgDiv").show();
	}
	
   
    }else{
	 var $inputs = $("#adminPer").find('input');
		$inputs.each(function(){
			if($(this).is(':checked')){
				valid = true;
				return ;
			}
		}); 
		if(!valid){
			$("#msgDiv").show();
		}else{
			$("#msgDiv").hide();
		}
 }
	
	
	
} 
function checkRoleName(value)
{
	 $('div.alert').hide();
	  $.ajax({

			url : '${home}RoleName_unique',
			type : 'POST',
			data : {
				value : value
			},
			dataType : 'json',
			success : function(result) {
				if(result){
					//alert("success");
				 	document.getElementById('name').value='';
	  				$("#ajax_div").show();
	  			  $('#name').focus();   
				}else{
				 	//alert("failure");
					$("#ajax_div").hide(); 
				}
				
				}
		});
	  
}

$("#name").keypress(function(event){
	var ew = event.which;
	//alert(ew)
	if(ew == 32) 
	return true;
	if(48 <= ew && ew <= 57) 
		return true;
	if(65 <= ew && ew <= 90)
		return true;
	if(97 <= ew && ew <= 122)
		return true;
	return false; 
	
	});

			
	/* function hideSpan(){
		$('.alert').hide();
		 $('span.website').hide();
	}	 */	

	$(document).ajaxStart(function(){
		 //alert("inside")
		 $("#imgLoader").show();
	    });
	    $(document).ajaxComplete(function(){
	    	//alert("inside")
	    	$("#imgLoader").hide();
	    }); 
</script>
<script type="text/javascript">
 (function($,W,D)
		 {
		    var JQUERY4U = {};

		    JQUERY4U.UTIL =
		    {
		        setupFormValidation: function()
		        {	
		            
		            $("#insertRoles").validate({
		                rules: {
		                	name :{
		                    	required : true ,
		                    	lettersonly:true 
		                 	
		                    },
		                    description :{
		                    	required : true,
		                    	alphanumerics:true
		                    },
		                     
		                },
		                messages:{
		                	name :{
		                    	
		                		required : "<font color='red'>Please Enter Role Name </font>"
		                    	
		                    }, 
		                    description :{
			                    	
		                    	 required : "<font color='red'>Please Enter Description.</font>"
			                    	
			                },	
		                  
		              	},
		                saveHandler: function(form) {
		                    form.save();
		                }
		            });
		        }
		    }

		    //when the dom has loaded setup form validation rules
		    $(D).ready(function($) {
		        JQUERY4U.UTIL.setupFormValidation();
		    });

		 })(jQuery, window, document);
 
 
 ///clearfield
 function editorClear(){
	  var dvPreview = $("#dvPreview");
     dvPreview.html("");
	}
 </script>
