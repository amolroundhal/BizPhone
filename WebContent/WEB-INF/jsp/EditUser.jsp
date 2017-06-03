<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">

	<!-- Main content -->
	<section class="content">


	       <div id="ajax_div" style="display: none;" class="alert alert-warning alert-dismissable" class="close"
												data-dismiss="alert">
						<p>
						 <i class="fa fa-info-circle"></i> Mobile number already exists.Please enter unique mobile number.
						</p>
		  </div>
	      
		<!-- Default box -->
		<div class="box box-danger">
			<div class="box-header with-border">
				<h3 class="box-title">Edit User</h3>
			</div>
			<form method="post" id="userForm" action="saveEditedUser" >
			<div class="box-body">
				<div class="form-horizontal">
					<div class="row">
					<div class="col-md-12 col-xs-12">
					<div class="col-md-6 col-xs-12">
                    <input type="hidden" value="${user.user_id}" id="user_id" name="user_id">
                    <input type="hidden" value="${user.mobile_no }" id="mobile_no1" name="mobile_no1">
						<div class="form-group">
							<label for="first_name" class="col-sm-4 control-label">First Name <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="first_name" value="${user.first_name }" name="first_name" placeholder="First name">
							</div>

						</div>
					</div>
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="name" class="col-sm-4 control-label">Last Name <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="last_name" value="${user.last_name }"
									name="last_name" placeholder="Last Name">
							</div>

						</div>
					</div>
				</div>
			</div>		
			
			
					<div class="row">
					<div class="col-md-12 col-xs-12">
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="email" class="col-sm-4 control-label">Email <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<input type="email" value="${user.email }" class="form-control" id="email" 
								 name="email" onchange="checkEmailUnique(this.value)" placeholder="Email">
							</div>

						</div>
					</div>
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="mobile_no" class="col-sm-4 control-label">Mobile No <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<input type="text" value="${user.mobile_no }" class="form-control" id="mobile_no" name="mobile_no" onchange="checkMobileNoUnique(this.value)"
									placeholder="mobile no">
							</div>

						</div>
                       </div>
					</div>
				</div>	
						

					<div class="row">
					<div class="col-md-12 col-xs-12">
					<div class="col-md-6 col-xs-12">

						<div class="form-group">
							<label for="password" class="col-sm-4 control-label">Password </label>
							<div class="col-sm-8">
								<input type="password" value="${user.password }" class="form-control" onchange="CheckSpecial(this.value)" id="password" name="password" 
									placeholder="Password">
									<span id="passwordSpan"></span>
							</div>

						</div>
					</div>	
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="role_id" class="col-sm-4 control-label">Role <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<select class="form-control" id="role_id" name="role_id">
									<option value="">--Select Role--</option>
									 
				                       
				                        <c:forEach items="${roles}" var="roles">
			                      <c:if test="${roles.id eq user.role_id}">
			                      <option value="${roles.id }" selected="selected">${roles.name }</option>
			                      </c:if>
			                        <c:if test="${roles.id ne user.role_id}">
			                        <option value="${roles.id }">${roles.name }</option>
			                        </c:if>
									 
								  </c:forEach>
					  
								</select>
							</div>
						</div>
					</div>
					</div>
				</div>
					<div class="row">
					<div class="col-md-12 col-xs-12">
						<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-4 control-label">Status <label style="color:red;">*</label></label>
							<div class="col-sm-8">
							
								<select class="form-control" id="status" name="status">
									<option value="">--Select Status--</option>
									<c:if test="${user.status eq 1}">
                       					<option selected="selected" value="1">Active</option>
			                        	<option value="2">Deactive</option>
			                        </c:if>
			                       <c:if test="${user.status eq 2}">
					                      <option value="1">Active</option>
					                      <option selected="selected" value="2">Deactive</option>
			                      </c:if>
								</select>
							</div>
						</div> 
					</div>
					</div>
					</div>
					</div>
					
					
				
			</div>
			<!-- /.box-body -->
			<div class="box-footer" style="text-align: center;">
				<button type="submit" class="btn btn-success">Save</button>&nbsp
				<a href="getUsers" class="btn btn-danger">Cancel</a>
			</div>
			<!-- /.box-footer-->
			</form>
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

 <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
 <script src="plugins/timezones.full.js"></script>
 <script src="plugins/jquery.validate.min.js"></script>
 <script src="plugins/additional-methods.min.js"></script>
    
<script type="text/javascript">

$("#time_zone").timezones();

function CheckSpecial(value){
	//alert(value);
	var count=0;
	//var splChars = "*|,\":<>[]{}`\';()@&$#%";
	var splChars = "!@#$%&*(,)_';+=|<:>?{}\"[/]~-";
		for (var i = 0; i < value.length; i++) {
		    if (splChars.indexOf(value.charAt(i)) != -1){
		    	//alert("in if"); 
			    count++;
			    
		    //nick.focus(); 
		     }
		    
		}
			if(count==1){
				//alert ("1 special character!"); 
				document.getElementById("passwordSpan").innerHTML="";
			}else if(count>1 || count==0){
				//alert ("multiple special character!"); 
				$("#password").val("");
				//$("#confirm_password").val("");
				document.getElementById("passwordSpan").innerHTML="<font color=red>Password must contain 1 special character</font>";
		
			}
		/* var minNumberofChars = 7;
		
		var regularExpression  = /^[a-zA-Z0-9!@#$%^&*]$/;
		//alert(newPassword); 
		if(value.length > minNumberofChars){
		    alert("in f1")
		}
		if(!regularExpression.test(value)) {
		    alert("password should contain atleast one special character");
		   
		} */
		
}



function checkMobileNoUnique(mobile_no){
	
	var mobile_no1 = $("#mobile_no1").val();
	//alert(mobile_no1)
	$.ajax({

			url : '${home}checkMobileNoUniqueEdit',
			type : 'POST',
			data : {
				mobile_no : mobile_no,
				mobile_no1 : mobile_no1
				
			},
			dataType : 'json',
			success : function(result) {
				if (result) {
				
					//alert("success");
					document.getElementById('mobile_no').value = '';
					$("#ajax_div").show();
					$('#mobile_no').focus();
				} else {
				//alert("failure111");
					$("#ajax_div").hide();
				}

			}
		});
}
 
    
		
var validator = $("#userForm").validate({

	ignore: "",
	rules: {
		
		first_name : {
        	required : true,
        	lettersonly : true
        	//alphanumerics: true
		},
		last_name : {
        	required : true,
        	lettersonly : true
        	//alphanumerics: true
		}, 
		mobile_no : {
			required : true,
        	digits : true,
        	minlength : 10,
        	maxlength : 10
	    }, 
       
        email : {
        	required : true,
        	email : true
        }, 
        
        role_id : {
        	required : true
        },
        status : {
        	required : true
        },
        
        state : {
        	required : true
        },
        city_name : {
        	required : true
        },
        password : {
        	required : true
        },
        department_id : {
        	required : true
        }
        
        
       
    },
    messages: {
    	first_name : {
        	required : "<font color=red>Please enter first name.</font>"
        },
        last_name : {
        	required : "<font color=red>Please enter last name.</font>"
        },
       
        mobile_no : {
        	 required : "<font color=red>Please enter mobile no.</font>",
         	maxlength : "<font color=red>Mobile no.should be 10 digits long.</font>",
         	minlength : "<font color=red>Mobile no.should be 10 digits long.</font>"
        }, 
        
        password : {
        	required : "<font color=red>Please enter password.</font>"
        	
        },
        email : {
        	required : "<font color=red>Please enter email.</font>",
        	email :"<font color=red>Please enter valid email.</font>"
        }, 
        role_id : {
        	required : "<font color=red>Please select role.</font>"
        },
        status : {
        	required : "<font color=red>Please select reporting role.</font>"
        },
        reporting_role_id : {
        	required : "<font color=red>Please select reporting role.</font>"
        },
        reporting_manager_id : {
        	required : "<font color=red>Please select reporting manager.</font>"
        },
        distributor_id : {
        	required : "<font color=red>Please select distributor.</font>"
        },
        
        routes : {
        	required : "<font color=red>Please select routes.</font>"
        },
        state : {
        	required : "<font color=red>Please select state.</font>"
        },
        city_name : {
        	required : "<font color=red>Please select city.</font>"
        },
        profile_img1:{
        	filesize : "<font color='red'>File must be less than 200KB</font>",
        	accept : "<font color='red'>please select png format image</font>"
        },
        signature1:{
        	filesize : "<font color='red'>File must be less than 200KB</font>",
        	accept : "<font color='red'>please select png format image</font>"
        },
        department_id : {
        	required : "Please select department."
        }
        
    }
});




</script>