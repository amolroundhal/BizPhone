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
<title>BizPhone</title>
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
	<form  action="loginsimple" method='POST'>
	    <h1>LOGIN</h1>
	    
	    	<c:if test="${error eq 'error'}">
				  <font color="ffff">User Name and Password is incorrect!! </font>
			</c:if>
				
			<h3>Enter User Name and Password below</h3>
	    
		<!--  <input type="hidden"  placeholder="company_id" name="company_id" id="company_id" value="0">
            <input type="hidden"  placeholder="company_id" name="loginidentity" id="loginidentity" value="2"> -->
            <input type="text"  name='username' id="username" placeholder="Mobile No" required="required">
		<input type="password"  name='password' id="password"   placeholder="Password" required="required">
		<div class="clear"> </div>
		<label  class="hvr-sweep-to-bottom margint-15">
		<input type="submit" value="Login"/>
		</label>
	</form>
	<h3> <a href="#">I forgot my password</a> | <a href="#">Sign Up for an Account</a>  </h3>
</div>
<!--login form end here-->
</body>
</html>