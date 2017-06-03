<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <meta charset="utf-8">

    <title> Login :: uInvoice </title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
    <link rel="icon" href="img/favicon.ico" type="image/x-icon" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/opensans.css" rel="stylesheet" />  
          
    <link href="http://pptresource.com.s3.amazonaws.com/css/bootstrap.min.css" rel="stylesheet" />
    <link href="http://pptresource.com.s3.amazonaws.com/css/bootstrap-responsive.min.css" rel="stylesheet" />
   
    <link href="http://pptresource.com.s3.amazonaws.com/css/font-awesome.min.css" rel="stylesheet" />  
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/ui-lightness/jquery-ui-1.10.0.custom.min.css" rel="stylesheet" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/base-admin-3.css" rel="stylesheet" />
    <link href="http://pptresource.com.s3.amazonaws.com/css/base-admin-3-responsive.css" rel="stylesheet" />

    <link href="http://pptresource.com.s3.amazonaws.com/css/pages/signin.css" rel="stylesheet" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/js/plugins/lightbox/themes/minimalist/jquery.lightbox.css" rel="stylesheet" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/daterangepicker-bs3.css" rel="stylesheet" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/pages/dashboard.css" rel="stylesheet" />  
         
    <link href="http://pptresource.com.s3.amazonaws.com/css/pages/password.css" rel="stylesheet" />   
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/ladda-themeless.min.css" rel="stylesheet" /> 
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/bootstrap-tags.css" rel="stylesheet" />
     
    <link href="http://pptresource.com.s3.amazonaws.com/css/bootstrap-switch.min.css" rel="stylesheet" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/js/plugins/chosen/chosen.min.css" rel="stylesheet" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/colorPicker.css" rel="stylesheet" />
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/tinyeditor.css" rel="stylesheet" /> 
    
    <link href="http://pptresource.com.s3.amazonaws.com/css/jquery.gridly.css" rel="stylesheet" /> 

    <link href="http://pptresource.com.s3.amazonaws.com/css/multi-select.css" rel="stylesheet" />

    <link href="http://pptresource.com.s3.amazonaws.com/css/master.css" rel="stylesheet" />
    
	<link href="<spring:url value="/css/uinvoice.css" htmlEscape="true"/>" rel="stylesheet" />

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<script src="http://pptresource.com.s3.amazonaws.com/js/libs/jquery-1.11.1.min.js"></script>
	<script src="http://pptresource.com.s3.amazonaws.com/js/libs/jquery-ui-1.10.4.custom.min.js"></script>

	<script src="http://pptresource.com.s3.amazonaws.com/js/libs/bootstrap.min.js"></script>
    
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/dateRangePicker/moment.min.js"></script>
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/dateRangePicker/daterangepicker.js"></script>    
    
    <script src="http://pptresource.com.s3.amazonaws.com/js/plugins/lightbox/jquery.lightbox.min.js"></script> 
    
    <script src="http://pptresource.com.s3.amazonaws.com/js/plugins/hover-dropdown/bootstrap-hover-dropdown.min.js"></script>

	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/password/password.js"></script>     
   
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/bootstrap-tags/bootstrap-tags.min.js"></script> 
    
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/bootstrap-switch/bootstrap-switch.min.js"></script>  
    
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/chosen/chosen.jquery.min.js"></script> 
    
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/multi-select/jquery.multi-select.js"></script>  
    
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/jquery.gridly/jquery.gridly.js"></script>
    
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/colorPicker/jquery.colorPicker.min.js"></script>   
    
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/tinyEditor/tiny.editor.packed.js"></script> 
	
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/tablesorter/jquery.tablesorter.min.js"></script>
	
	<script src="http://pptresource.com.s3.amazonaws.com/js/plugins/inputMask/inputmask.js"></script>
     
    <script> <!--input character counter -->
		(function($) {
			$.fn.extend( {
				limiter: function(limit, elem) {
					$(this).on("keyup focus", function() {
						setCount(this, elem);
					});
					function setCount(src, elem) {
						var chars = src.value.length;
						if (chars > limit) {
							src.value = src.value.substr(0, limit);
							chars = limit;
						}
						elem.html( limit - chars );
					}
					setCount($(this)[0], elem);
				}
			});
		})(jQuery);
    </script>
    
    <script> <!-- Applies .active class to the menu item currently open -->
	$(function(){
		var url = window.location;
		// Will only work if string in href matches with location
		$('ul.mainnav a[href="'+ url +'"]').parent().addClass('active');
		
		// Will also work for relative and absolute hrefs
		$('ul.mainnav a').filter(function() {
			return this.href == url;
		}).parent().addClass('active');
	})
    </script> 



  </head>

<body>
<div id="wrapper">

	<div class="subnavbar visible-xs visible-sm visible-md visible-lg">

	<div class="subnavbar-inner">
	
		<div class="container">
			
             <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header visible-md visible-lg" style="display: none;">
                    <a class="navbar-brand" href="<spring:url value="/dashboard"/>"><img src='<spring:url value="/img/uInvoice_Logo_white.png" />'> </a>
                  </div>

		</div> <!-- /container -->
    
	</div> <!-- /subnavbar-inner -->
</div> <!-- /subnavbar-->

<div class="account-container stacked">
	
	<div class="content clearfix">
				Access is denied please contact to the system admin Please login again <a href="<c:url value="/j_spring_security_logout" />" >Secure Login</a>

			<div class="login-actions">

			</div> <!-- .actions -->

		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="footer">
		
	<div class="container">
		
		<div class="row">
			
			<div id="footer-copyright" class="col-md-6">
				&copy; 2014 Processing Point.
			</div> <!-- /span6 -->
			<div id="footer-copyright" class="col-md-6 text-right">
				<script type="text/javascript" src="https://sealserver.trustwave.com/seal.js?code=7c19c3860ca511e0b34b005056b201e5"></script>
           </div>
		</div> <!-- /row -->
		
	</div> <!-- /container -->
	
</div> <!-- /footer -->

</div> <!-- /wrapper -->

    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->



<script src="http://pptresource.com/js/plugins/flot/jquery.flot.js"></script>
<script src="http://pptresource.com/js/plugins/flot/jquery.flot.pie.js"></script>
<script src="http://pptresource.com/js/plugins/flot/jquery.flot.orderBars.js"></script>
<script src="http://pptresource.com/js/plugins/flot/jquery.flot.resize.js"></script>
<script src="http://pptresource.com/js/plugins/flot/jquery.flot.time.js"></script>
<script src="http://pptresource.com/js/plugins/flot/jquery.flot.axislabels.js"></script>

<script src="http://pptresource.com/js/plugins/validate/jquery.validate.js"></script>
<script src="http://pptresource.com/js/Application.js"></script>
<script src="http://pptresource.com/js/demo/validation.js"></script>

<script src="http://pptresource.com/js/charts/bar.js"></script>
<script src="http://pptresource.com/js/charts/bar2.js"></script>
<script src="http://pptresource.com/js/charts/donut.js"></script>
<script src="http://pptresource.com/js/charts/line.js"></script>
<script src="http://pptresource.com/js/charts/pie.js"></script>
<script src="http://pptresource.com/js/charts/area.js"></script>

<script src="http://pptresource.com/js/plugins/ladda/spin.min.js"></script>
<script src="http://pptresource.com/js/plugins/ladda/ladda.min.js"></script>

<script>

	// Bind normal buttons
	Ladda.bind( 'button.ladda-button', { timeout: 2000 } );


</script>

         

  </body>
</html>