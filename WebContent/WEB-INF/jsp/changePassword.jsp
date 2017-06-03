<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FieldMI | Change password</title>
<!-- Custom Theme files -->
<link href="bootstrap/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="" />


</head>
<body>
<div class="header-cont">
		<div class="header">
		<img src="dist/img/Fieldmilogo.png" class="logo">
		</div>
</div>
<!--login form start here-->	
<div class="login">
	<form  action="changepasswordcompany" method='POST' id="userForm">
	    <h1>Change password</h1>
	    
	    			
			<c:if test="${failtryagain eq '1'}">
				<center> <font color="ffff">Something went wrong..!! Please try again. </font></center>
			</c:if>
				
			
	    
		   <input type="hidden"  placeholder="company_id" name="company_id" id="company_id" value="${company_id }" required="required">
            <input type="hidden"  placeholder="company_id" name="key" id="key" value="${key }" required="required">
            <input type="hidden"  placeholder="username" name="username" id="username" value="${username }" required="required">
            
            <input type="password"  name='newpassword' id="newpassword" class="form-control" placeholder="new password" onchange="CheckSpecial(this.value)"  >
            <span id="passwordSpan"></span>
            
		 <input type="password"  name='confirmpassword' id="confirmpassword"  class="form-control" placeholder="confirm password" >
		<div class="clear"> </div>
		<label  class="hvr-sweep-to-bottom margint-15">
		<input type="submit" value="Login"/>
		</label>
	</form>
	
</div>
<!--login form end here-->

<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="plugins/jQueryUI/jquery-ui.min.js"></script>
 <script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script> 
    <script src="plugins/jquery.validate.min.js"></script>
    <script src="plugins/additional-methods.min.js"></script>
    
    
    <script type="text/javascript">
    

    var validator = $("#userForm").validate({

    	ignore: "",
    	rules: {
    		
    		
    		newpassword : {
            	required : true,
            	minlength : 7
            	//maxlength : 7
            },
            confirmpassword : {
            	//required : true,
            	equalTo: "#newpassword"
            		
            }
            
            
           
        },
        messages: {
        	newpassword : {
            	required : "<font color='ffff'>Please enter password</font>",
            	minlength : "<font color='ffff'>Password must have min 7 character</font>"
            	//maxlength : 7
            },
            confirmpassword : {
            	//required : true,
            	equalTo: "<font color='ffff'>Please enter same value again</font>"
            		
            }
            
        }
    });

    
    function CheckSpecial(value){
    	//alert(value);
    	var count=0;
    	//var splChars = "*|,\":<>[]{}`\';()@&$#%";
    	var splChars = "!@#$%&*(,)_';+=|<:>?{}\"[/]~-";
    		for (var i = 0; i < value.length; i++) {
    		    if (splChars.indexOf(value.charAt(i)) != -1){
    		    	//alert ("in if"); 
    			    count++;
    			    
    		    //nick.focus(); 
    		     }
    		    
    		}
    			if(count==1){
    				//alert ("1 special character!"); 
    				document.getElementById("passwordSpan").innerHTML="";
    			}else if(count>1 || count==0){
    				//alert ("multiple special character!"); 
    				$("#newpassword").val("");
    				$("#confirmpassword").val("");
    				document.getElementById("passwordSpan").innerHTML="<font color='ffff'>Password must contain 1 special character</font>";
    		
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
    
    </script>

</body>
</html>