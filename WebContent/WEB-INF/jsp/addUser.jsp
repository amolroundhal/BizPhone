<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header"></section>

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
				<h3 class="box-title">Add User</h3>
			</div>
			
			<form method="post" id="userForm" action="saveUser" >
			<div class="box-body">
				<div class="form-horizontal">
					<div class="row">
					<div class="col-md-12 col-xs-12">
					<div class="col-md-6 col-xs-12">

						<div class="form-group">
							<label for="name" class="col-sm-4 control-label">First Name <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="first_name"
									name="first_name" placeholder="First Name">
							</div>

						</div>
					</div>
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="name" class="col-sm-4 control-label">Last Name <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="last_name"
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
								<input type="email" class="form-control" id="email" name="email" 
									placeholder="Email">
							</div>
						</div>
					</div>
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="mobile_no" class="col-sm-4 control-label">Mobile No <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="mobile_no" name="mobile_no" onchange="checkMobileNoUnique(this.value)"
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
								<label for="password" class="col-sm-4 control-label">Password <label style="color:red;">*</label></label>
								<div class="col-sm-8">
									<input type="password" class="form-control" onchange="CheckSpecial(this.value)" id="password" name="password"
										placeholder="Password">
										<span id="passwordSpan"></span>
								</div>
							</div>
						</div>	
							
							<div class="col-md-6 col-xs-12">
							<div class="form-group">
								<label for="confirm_password" class="col-sm-4 control-label">Confirm Password <label style="color:red;">*</label></label>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="confirm_password" name="confirm_password"
										placeholder="Confirm Password">
								</div>
	
							</div>
						</div>
					</div>
					</div>
							
					<div class="row">
					<div class="col-md-12 col-xs-12">
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="role_id" class="col-sm-4 control-label">Role <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<select class="form-control" id="role_id" name="role_id">
									<option value="">--Select Role--</option>
									 <c:forEach items="${roles}" var="roles">
							       <option value="${roles.id}">${roles.name}</option>
				                       </c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label for="status" class="col-sm-4 control-label">Status <label style="color:red;">*</label></label>
							<div class="col-sm-8">
								<select class="form-control" id="status" name="status">
									<option value="">--Select Status--</option>
									<option value="1">Active</option>
									<option value="2">Deactive</option>
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
				$("#confirm_password").val("");
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
	
	$.ajax({

			url : '${home}checkMobileNoUnique',
			type : 'POST',
			data : {
				mobile_no : mobile_no
				
			},
			dataType : 'json',
			success : function(result) {
				if (result) {
				
					//alert("success");
					document.getElementById('email').value = '';
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
        password : {
        	required : true,
        	minlength : 7
        	
        },
        confirm_password : {
        	//required : true,
        	equalTo: "#password"
        		
        }, 
        role_id : {
        	required : true
        },
        status : {
        	required : true
        },
        
        
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
        	required : "<font color=red>Please select status.</font>"
        }, 
        
        
    }
});

</script>