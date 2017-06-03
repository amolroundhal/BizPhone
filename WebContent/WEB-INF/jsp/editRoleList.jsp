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
    <section class="content">
    
    <p>
    <c:if test="${flag eq 1 }">
		      	<div class="alert alert-success alert-dismissable" class="close"
								data-dismiss="alert">
								<p><i class="fa fa-check-circle"></i> Role updated successfully.</p>
			   </div>
		      </c:if>
		      <c:if test="${flag eq 0 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> Role updation failed.</p>
							</div>
		      </c:if>
		      
		      <c:if test="${flag eq 1111 }">
		      	<div class="alert alert-success alert-dismissable" class="close"
								data-dismiss="alert">
								<p><i class="fa fa-check-circle"></i> Role Deleted successfully.</p>
			   </div>
		      </c:if>
		      <c:if test="${flag eq 2222 }">
		      	<div class="alert alert-warning alert-dismissable" class="close"
								data-dismiss="alert">
								<p> Role Deleted failed.</p>
							</div>
		      </c:if>
    </p>
        <!-- Default box -->
        <div class="box box-danger">
            <div class="box-header with-border">
              <h3 class="box-title">Roles</h3>
            </div>
            
            <div class="box-body">
            <a href="addRole"><button type="button" class="btn btn-success" style="margin-left: 950px"><span class="glyphicon glyphicon-plus"></span> Add Role</button></a>
             <form  method="post" id="userReport">
	           <!-- <div class="form-horizontal">
				<div class="box" id="hidefirst"> -->
                <!--  <div class="box box-danger"> -->
               <!--  <div class="box-header with-border">
                  <h3 class="box-title">User Report :<b> <span id="userSelectedName"></span></b></h3>
                </div> -->
                <div class="box-body" style="height:500px;overflow:scroll;overflow-x:scroll;overflow-y:scroll;">
               			<!-- <div class="overlay" id="imgLoader">
              				<i class="fa fa-refresh fa-spin"></i>
            			</div> -->
               			<table id="example1" class="table table-bordered table-striped">
                    <thead>
                      <tr>
                        <th>SR No.</th>
                        <th>Role Name</th>
                        <!-- <th>Status</th> -->
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                 <%--  <c:forEach items="${customerList}" var="customerList">
                            <tr>
                         <td>${customerList.customer_name }</td>
                         <td>${customerList.distributor_name }</td>
                     
                     </tr>
                     </c:forEach>    --%>
                  </tbody>
                  
                  <tfoot>
                 
                    </tfoot>
                  </table>
                </div><!-- /.box-body -->
             <!--  </div> -->
          <!-- </div> -->
				
             <!--   </div> -->
               </form>
            </div><!-- /.box-body -->
			<!-- <div class="modal-footer">
						<button type="button" onclick="displayTable()" class="btn btn-success">Submit</button>
						 <a type="button" id="export1" href="exportUserData?status=1" class="btn btn-info">Export</a>
						<a href="userReport"><button type="reset" id="reset" class="btn btn-danger" >Reset</button></a>
			</div> -->
        </div><!-- /.box -->
		

    </section><!-- /.content -->
  </div><!-- /.content-wrapper -->
  
   <!-- delete model -->

 <div class="modal fade" id="DeleteRoleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h3 class="modal-title" id="myModalLabel">Delete Role</h3>
			</div>


			<form  action="deleteRole" method="post" role="form">

				<div class="modal-body">

					<div class="row">
						<div class="col-md-12">
							<div class="isa_warning">
								<h4><center>
								<i class="fa fa-warning"></i>
								<b>Do you really want to delete this role ?</b>
								</center></h4>
							</div>
						</div>
						
						 <div class="col-md-12">
							<input type="hidden" id="id" name="id">
							<div class="modal-footer">
								<input type="submit" class="btn btn-success" value="Delete">&nbsp;
								<a href="#" class="btn btn-danger" data-dismiss="modal">Cancel</a>
							</div>
							<!-- /.row -->
						</div>
				  </div>
				</div>
			</form>
		</div>
	</div>
</div>
  
  
  
  
	
	<!-- <div id="imgLoader" style="display: none;">
  		<img id="loading-image" src="dist/img/Loading_icon.gif" alt="Loading..." />
	</div> -->
	
	<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="plugins/jQueryUI/jquery-ui.min.js"></script>
    <script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script> 
    <script src="plugins/jquery.validate.min.js"></script>
    <script src="plugins/additional-methods.min.js"></script>
    <!-- <script src="plugins/locations.js"></script> -->
   
      <!-- DATA TABES SCRIPT -->
  	<script src="plugins/datatables/jquery.dataTables.js" 
  	type="text/javascript"></script>
  	<script src="plugins/datatables/dataTables.bootstrap.js"
  	type="text/javascript"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyCEYryRhhLSTMWGQvyALGPfXYZO5zEcOsU&sensor=false"></script>
    <script src="plugins/daterangepicker/moment.js"></script>  
    <script src="plugins/daterangepicker/moment.min.js"></script>  
    <script src="plugins/daterangepicker/daterangepicker.js"></script>  
    
    <script type="text/javascript">
    
    $('#DeleteRoleModal').on('show.bs.modal', function(e) {

    	//alert("inside DeleteDealerRoleModal...:");

    	var id = $(e.relatedTarget).data('id');
    	$(e.currentTarget).find('input[name="id"]').val(id);

    });
    
    </script>
    
    
    
    

	<script>
	 var status=1;
	 
	 
	$(function(){
	
		/*  	if ($.fn.DataTable.isDataTable( '#example1' ) ) {
  				  $('#example1').DataTable().destroy();
  			} */
		 
	var table=$('#example1').DataTable({
			"bServerSide": true,
		    "bProcessing": true,
		    "sPaginationType": "full_numbers",
		    "sAjaxSource":  "editRoleData?status="+status,
		    "bFilter": false,
		    "lengthMenu": [[20, 30, 50], [20, 30, 50]],
		   });
		 
	} ); 
		

	$(document).ajaxStart(function(){
		 //alert("inside")
		 $("#imgLoader").show();
	    });
	    $(document).ajaxComplete(function(){
	    	//alert("inside")
	    	$("#imgLoader").hide();
	    }); 
	</script>
    
