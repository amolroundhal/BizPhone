<%--  <%@ include file="/WEB-INF/templates/header.jsp" %> 
<%@ include file="/WEB-INF/templates/menu.jsp" %> --%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            Dashboard
          </h1>
         
        </section>

        <!-- Main content -->
        <section class="content">
          
          <c:if test="${flagcompany eq 1 }">
		      	<div class="alert alert-success alert-dismissable" class="close"
								data-dismiss="alert">
								<p> Company edited successfully.</p>
							</div>
		      </c:if>
		      <c:if test="${flagcompany eq 2 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> Company failed to edit.</p>
							</div>
		      </c:if>
		      <%
		      session.setAttribute("flagcompany",0);
		      %>
          
      <div class="row">

		<div class="col-md-3 col-sm-6 col-xs-12">
			<input type="hidden" name="Admin" value="<%=session.getAttribute("Admin")%>" id="Admin">
              <div class="info-box">
                <span  class="info-box-icon bg-aqua"><i  class="fa fa-users"></i></span>
                <div class="info-box-content">
                  <span class="info-box-text">Total users</span>
                  <span class="info-box-number" id="total_user_span"></span>       
                  </div>
                <!-- /.info-box-content -->
              </div><!-- /.info-box -->
            </div><!-- /.col -->
            
          
             <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="info-box">
                <span class="info-box-icon bg-red"><i class="fa fa-male"></i></span>
                <div class="info-box-content">
                  <span class="info-box-text"> logged in users</span>
                  <span class="info-box-number" id="login_user_span"></span>
                </div><!-- /.info-box-content -->
              </div><!-- /.info-box -->
            </div><!-- /.col -->
            
            
            <div class="clearfix visible-sm-block"></div>

            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="info-box">
                <span class="info-box-icon bg-green"><i class="fa fa-shopping-cart"></i></span>
                <div class="info-box-content">
                  <span class="info-box-text">Sales Orders</span>
                  <span class="info-box-number" id="total_sales_span"></span>
                </div><!-- /.info-box-content -->
              </div><!-- /.info-box -->
            </div><!-- /.col -->
            
             <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="info-box">
                <span class="info-box-icon bg-yellow"><i class="ion ion-ios-people-outline"></i></span>
                <div class="info-box-content"><span class="info-box-text">Customer Visits</span><span class="info-box-number" id="total_visit_span"></span>                </div>
                <!-- /.info-box-content -->
              </div><!-- /.info-box -->
            </div><!-- /.col -->
          </div>
          <!-- Main row -->
          
          
          <div class="row">
	<div class="col-md-4">
  <div class="box box-danger">
                <div class="box-header with-border">
                  <h3 class="box-title">Current Employee Status</h3>
                  
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="row">
                    <div class="col-md-8">
                      <div class="chart-responsive">
                        <canvas id="pieChart" height="200"></canvas>
                      </div><!-- ./chart-responsive -->
                    </div><!-- /.col -->
                    <div class="col-md-4">
                      <ul class="chart-legend clearfix">
                        <li><i class="fa fa-circle-o text-red"></i> Present Employee</li>
                        <li><i class="fa fa-circle-o text-green"></i> On Leave</li>
                        <li><i class="fa fa-circle-o text-yellow"></i> No Attendance</li>
                        <li><i class="fa fa-circle-o text-aqua"></i> Done with Out </li>
                      </ul>
                    </div><!-- /.col -->
                  </div><!-- /.row -->
                </div><!-- /.box-body -->
                <div class="box-footer no-padding">
                  <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">Present Employee <span class="pull-right text-red" id="p_span"><i class="fa fa-angle-down"></i> </span></a></li>
                    <li><a href="#">On Leave <span class="pull-right text-green" id="l_span"><i class="fa fa-angle-up"></i></span></a></li>
                    <li><a href="#">No Attendance <span class="pull-right text-yellow" id="n_span"><i class="fa fa-angle-left"></i></span></a></li>
                             <li><a href="#"> Done with Out<span class="pull-right text-aqua" id="o_span"><i class="fa fa-angle-left"></i></span></a></li>
                  </ul>
                </div><!-- /.footer -->
              </div><!-- /.box -->

            
    </div>
    <div class="col-md-4">
    <div class="box box-danger">
                <div class="box-header with-border">
                  <h3 class="box-title">Leave Requests</h3>
                  
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="table-responsive">
                    <table id="table1" class="table no-margin">
                      <thead>
                        <tr>
                          <th>Sr. No</th>
                          <th>Username</th>
                          <th>Manager</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody>
                           
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                  <a href="leaveReport" class="btn btn-sm btn-default btn-flat pull-right">View All</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
          
    
    
    </div>

 <div class="col-md-4">
    
    <div class="box box-danger">
                <div class="box-header with-border">
                  <h3 class="box-title">Attendance Records</h3>
                  
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="table-responsive">
                    <table id="table2" class="table no-margin">
                      <thead>
                        <tr>
                          <th>Sr. No</th>
                          <th>Username</th>
                          <th>Time</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">
                  <a href="attendanceReport" class="btn btn-sm btn-default btn-flat pull-right">View All</a>
                </div><!-- /.box-footer -->
              </div><!-- /.box -->
    </div>
</div>


<div class="row">
<div class="col-md-12">
<div class="box box-danger">
                <div class="box-header with-border">
                  <h3 class="box-title">Latest Orders</h3>
                 
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="table-responsive">
                    <table id="table3" class="table no-margin">
                      <thead>
                        <tr>
                          <th>Order ID</th>
                          <th>Username</th>
                          <th>Customer Name</th>
                          <th>Distributor Name</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody>
                      
                      </tbody>
                    </table>
                  </div><!-- /.table-responsive -->
                </div><!-- /.box-body -->
                <div class="box-footer clearfix">

                  <a href="salesOrderReport" class="btn btn-sm btn-default btn-flat pull-right">View All</a>
                </div><!-- /.box-footer -->
              </div>
		</div>
		</div>
      
      </section>
      </div>
  <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
   <!--  <script src="bootstrap/js/bootstrap.min.js"></script> -->
    <!-- FastClick -->
   <!--  <script src="plugins/fastclick/fastclick.min.js"></script> -->
    <!-- AdminLTE App -->
   <!--  <script src="dist/js/app.min.js"></script> -->
    <!-- Sparkline -->
    <!-- <script src="plugins/sparkline/jquery.sparkline.min.js"></script> -->
    <!-- jvectormap -->
   <!--  <script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    SlimScroll 1.3.0
    <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script> -->
    <!-- ChartJS 1.0.1 -->
    <script src="plugins/chartjs/Chart.min.js"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <!-- <script src="dist/js/pages/dashboard2.js"></script> -->
    <!-- AdminLTE for demo purposes -->
   <!--  <script src="dist/js/demo.js"></script> -->
 <script src="plugins/timezones.full.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
 <script src="plugins/chartjs/Chart.min.js"></script>
 <script src="plugins/chartjs/Chart.js"></script>
 <script src="plugins/sparkline/jquery.sparkline.min.js"></script> 
  
 <script type="text/javascript">
    var a=0; //total users
	var b=0; //present users
	var c=0; //leave user
	var d=0; //not_in_user
	var e=0;  //out user 
	var admin=$("#Admin").val();
	//alert(admin);
	if(admin==1){
 $.ajax({
		
		url : '${home}getLoginUserCount',
		type : 'POST',
		data : {
		},
		dataType : 'json',
		success : function(result) {
			//alert(result);
			if (result) {
			//alert("success");
			//alert(result.login_user);
			//alert(result.total_user);
				$("#login_user_span").text(result.login_user);
				$("#total_user_span").text(result.total_user);
			}
		
		}
		});
 
 $.ajax({
		
		url : '${home}getSalesVisitCount',
		type : 'POST',
		data : {
		},
		dataType : 'json',
		success : function(result) {
			//alert(result);
			if (result) {
			//alert("success11");
			//alert(result.total_sales);
			//alert(result.total_visit);
				$("#total_sales_span").text(result.total_sales);
				$("#total_visit_span").text(result.total_visit);				
			}
		
		}
		});
 
 $.ajax({
		
		url : '${home}getTodaysUsers',
		type : 'POST',
		data : {
		},
		dataType : 'json',
		success : function(result) {
			//alert(result);
			if (result) {
			
				// var a=0; //total users
				//	var b=0; //present users
					//var c=0; //leave user
					//var d=0; //not_in_user
				//	var e=0;  //out user 
			a=result.user_id;
			b=result.status;
			//alert(a)
			//alert(b)
			//alert((b/a)*100)
			c=result.attendance_id;
			d=result.company_id;
			e=result.created_by;
			
			$("#p_span").text(Math.round((b/a)*100)+"%");
			$("#l_span").text(Math.round((c/a)*100)+"%");
			$("#n_span").text(Math.round((d/a)*100)+"%");
			$("#o_span").text(Math.round((e/a)*100)+"%");
			//alert("success22");
			/* alert(a);
			alert(b);
			alert(c);
			alert(d);
			alert(e);*/	
			chart(); 				
			}
		
		}
		});
 
 $.ajax({
		
		url : '${home}getLast5Attendance',
		type : 'POST',
		data : {
		},
		dataType : 'json',
		success : function(result) {
			//alert(result);
			if (result) {
			//alert("success33");
			var count=1;
			for(var i=0;i<result.length;i++){
				//alert(result.total_sales);
				//alert(result.total_visit);
				
				var status="";
				var msg="";
				if(result[i].inout_type=="1"){
					status="In";
					msg="success";
				}
				if(result[i].inout_type=="2"){
					status="Out";
					msg="danger";
				}
				
				var rows = "";
				//$.each(items, function(){
				    rows += "<tr><td>" +count+++ "</td><td>" + result[i].user_name + "</td><td>" + result[i].inout_location_name + "</td><td><span class='label label-"+msg+"'>"+status+"</span></td></tr>";
				//});

				$( rows ).appendTo( "#table2 tbody" );
				
				}
			
								
			}
		
		}
		});
 
 $.ajax({
		
		url : '${home}getLast5Leave',
		type : 'POST',
		data : {
		},
		dataType : 'json',
		success : function(result) {
			//alert(result);
			if (result) {
			//alert("success44"+result.length);
			var count=1;
			for(var i=0;i<result.length;i++){
				//alert(result.total_sales);
				//alert(result.total_visit);
				
				/* var li = $("<li />");
				li.append(" <img src='dist/img/user1.png' alt='User Image'>");
				li.append("<label class='control-label'>"+result[i].user_first_name+" "+result[i].user_last_name+"</label>");
				li.append("<span class='users-list-date'>"+result[i].no_of_trucks+" Trips</span>")
				$("#topUsers").append(li); */
				var status="";
				var msg="";
				if(result[i].approval_status=="1"){
					status="Pending";
					msg="warning";
				}
				if(result[i].approval_status=="2"){
					status="Approved";
					msg="success";
				}
				if(result[i].approval_status=="3"){
					status="Rejected";
					msg="danger";
				}
				var rows = "";
				//$.each(items, function(){
				    rows += "<tr><td>" +count+++ "</td><td>" + result[i].userName + "</td><td>" + result[i].leave_title + "</td><td><span class='label label-"+msg+"'>"+status+"</span></td></tr>";
				//});

				$( rows ).appendTo( "#table1 tbody" );
				
				}
			
								
			}
		
		}
		});
 
 $.ajax({
		
		url : '${home}getLast5SalesVisit',
		type : 'POST',
		data : {
		},
		dataType : 'json',
		success : function(result) {
			//alert(result);
			if (result) {
			//alert("success555");
				var count=1;
				for(var i=0;i<result.length;i++){
					//alert(result.total_sales);
					//alert(result.total_visit);
					
					var status="";
					var msg="";
					if(result[i].address=="0"){
						status="Visit";
						msg="warning";
					}else{
						status="Ordered";
						msg="success";
					}
					
					var rows = "";
					//$.each(items, function(){
					    rows += "<tr><td>" + result[i].sales_master_id + "</td><td>" + result[i].signature + "</td><td>" + result[i].customer_name + "</td><td>" + result[i].distributor_name + "</td><td><span class='label label-"+msg+"'>"+status+"</span></td></tr>";
					//});

					$( rows ).appendTo( "#table3 tbody" );
					
					}
			
								
			}
		
		}
		});
	}
 
 var st1=0;
 var tempArr1=new Array();
 
   
	
	
 $( document ).ready(function() {
	 //alert("11111");
	 
 
	

	/*  var li = $("<li />");
	 li.append(" <img src='plugins/user12.png' alt='User Image'>");
	 li.append("<label class='control-label'>username</label>");
	 //li.append("<span class='users-list-date'>"+result[i].no_of_trucks+" Trips</span>")
	 $("#topUsers").append(li); */
	 
	
	  
	  
	});
 $(function () {
	 //alert("hiiii");
 });
function chart(){
	
	
	
	
	//#FE9A2E yello
	//3c8dbc  dark blue
 var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
 var pieChart = new Chart(pieChartCanvas);
 var PieData = [
    /* {
     value: 10,
     color: "#f39c12",
     highlight: "#f39c12",
     label: "Chrome"
   },  */
   {
     value: b,
     color: "#f56954",
     highlight: "#f56954",
     label: "Present Employee"
   },
   {
     value: c,
     color: "#00a65a",
     highlight: "#00a65a",
     label: "On Leave"
   },
   {
     value: d,
     color: "#FE9A2E",
     highlight: "#FE9A2E",
     label: "No Attendance"
   },
   {
     value: e,
     color: "#00c0ef",
     highlight: "#00c0ef",
     label: "Logout Users"
   },
    /* {
     value: 10,
     color: "#d2d6de",
     highlight: "#d2d6de",
     label: "Navigator"
   }  */
 ];
 var pieOptions = {
   //Boolean - Whether we should show a stroke on each segment
   segmentShowStroke: true,
   //String - The colour of each segment stroke
   segmentStrokeColor: "#fff",
   //Number - The width of each segment stroke
   segmentStrokeWidth: 2,
   //Number - The percentage of the chart that we cut out of the middle
   percentageInnerCutout: 50, // This is 0 for Pie charts
   //Number - Amount of animation steps
   animationSteps: 100,
   //String - Animation easing effect
   animationEasing: "easeOutBounce",
   //Boolean - Whether we animate the rotation of the Doughnut
   animateRotate: true,
   //Boolean - Whether we animate scaling the Doughnut from the centre
   animateScale: false,
   //Boolean - whether to make the chart responsive to window resizing
   responsive: true,
   // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
   maintainAspectRatio: true,
   //String - A legend template
 };
 //Create pie or douhnut chart
 // You can switch between pie and douhnut using the method below.
 pieChart.Doughnut(PieData, pieOptions);
}
 
 /* $(".sparkline").each(function () {
     var $this = $(this);
     $this.sparkline('html', $this.data());
   }); */

   /* SPARKLINE DOCUMENTAION EXAMPLES http://omnipotent.net/jquery.sparkline/#s-about */
   //drawDocSparklines();
   //drawMouseSpeedDemo();
   
   
 
 
 </script> 
<!--  <script src="plugins/jquery.validate.min.js"></script>
    <script src="plugins/additional-methods.min.js"></script> -->

 <%-- <%@ include file="/WEB-INF/templates/footer.jsp" %>   --%>