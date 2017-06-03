<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap1.css">
<link rel="stylesheet" href="bootstrap/css/style1.css">
<title>FieldMI</title>
<!-- Custom Theme files -->
<link href="bootstrap/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="" />
<style>
		 @font-face {
		    font-family: 'MarathiFont'; /*a name to be used later*/
		    src: url('fonts/DVBWYG0B.TTF'); /*URL to font*/
		}
		.marathi{
		font-family : MarathiFont
		} 
		
	</style>

</head>
<body style="background-image: url('dist/img/background.jpg');">
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container" style="margin-left:10%;">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><img src="dist/img/appasaheb-icon.jpg" class="pull-left" height="75"> 
          <h19 class="site-title pull-left marathi">${plantName}</h19></a></a>
        </div>
        <div class="navbar-collapse collapse">
        
        </div><!--/.nav-collapse -->
      </div>
    </div>
<!--login form end here-->

<div class="container">
   
     <div class="clearfix"></div>
    	  <div class="table-responsive">
          	<div class="pull-right" style="padding-right:10%;"><h3><span id="ct"></span></h3></div>
          </div> 
<br/>  

       
   		 <div class="table-responsive" style="margin-top: 50px;">

        	 <table width="100%;">
            	<tr>
                	<td width="10%;" style="padding: 12px 7px;line-height: 1.42857143;"><a class="btn btn-lg btn-default btn-block" href="ledger_details.php"><img src="dist/img/ledger.png" width="20%;" height="20%;"/><strong>${ledgerInfo}</strong></a></td>
                    <td width="60%;" style="padding: 12px 7px;line-height: 1.42857143;"><h1 align="center"> Welcome   <strong>"Ashutosh Ramdasi"</strong></h1></td>
                	<td width="20%;" style="padding: 18px 9px;line-height: 1.42857143;"><a class="btn btn-lg btn-default btn-block" href="share_details.php"><img src="dist/img/share.png" width="20%;" height="20%;"/><strong>${shareInfo}</strong></a></td>
                </tr>
                <tr>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"><a  class="btn btn-lg btn-default btn-block" href="profile.php"><img src="dist/img/profile.png" width="20%;" height="20%;"/><strong>${ownInfo}</strong></a></td>
                    <td width="60%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"><a class="btn btn-lg btn-default btn-block" href="cane_details.php"><img src="dist/img/sugarcane.png" width="20%;" height="20%;"/> <strong>${sugarcaneInfo}</strong></a></td>
                </tr>
                <tr>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;">
                    	<a  class="btn btn-lg btn-default btn-block" href="setting_details.php"><img src="dist/img/settings.png" width="20%;" height="20%;"/><strong>${settingInfo}</strong></a>
                    </td>
                    <td width="60%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"><a class="btn btn-lg btn-default btn-block" href="bill_details.php"><img src="dist/img/bill.png" width="20%;" height="20%;"/><strong>${billInfo}</strong></a></td>
                </tr>
                <tr>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                    <td width="60%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                </tr>
                <tr>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                    <td width="60%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"><a class="btn btn-lg btn-default btn-block" href="sugar_details.php"><img src="dist/img/sugar.png" width="20%;" height="20%;"/><strong>${stockInfo}</strong></a></td>
                </tr>
                
                <tr>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                    <td width="60%;" style="padding: 12px 7px;line-height: 1.42857143;"></td>
                	<td width="20%;" style="padding: 12px 7px;line-height: 1.42857143;"><a  class="btn btn-lg btn-danger btn-block" href="user_pin.php"><strong>Exit</strong></a></td>							                
                </tr>
                
               
            </table>
            
             
        </div>
 
 
    <div class="clearfix"></div>
    <div class="clearfix"></div>
   </div>

</body>
</html>