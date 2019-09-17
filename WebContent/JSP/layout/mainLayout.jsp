<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" type="text/css"  href="scripts/jquery112/jquery-ui.css" />   
<link rel="stylesheet" type="text/css"  href="styles/bs/font-awesome.css" />   
<link rel="stylesheet" type="text/css"  href="styles/bs/uielements.css" />   
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/simplebar@latest/dist/simplebar.css">


  <link rel="stylesheet" type="text/css"  href="styles/bs/bootstrap.css" /> 
 <!-- SCRIPT CONFIGURATION STARTS HERE  -->
 
   <script type="text/javascript" src="scripts/jquery112/jquery-1.12.4.js"></script>
   <script type="text/javascript" src="scripts/jquery112/jquery-ui.js"></script>
  
   
   
   
  <script src="https://cdn.jsdelivr.net/npm/simplebar@latest/dist/simplebar.js"></script>
  
  <script src="scripts/plugins/pdf.js"></script>
  <script src="scripts/plugins/pdf.worker.js"></script>  
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfobject/2.1.1/pdfobject.min.js"></script>
     
   <script type="text/javascript" src="scripts/ASSETConstants.js"></script>
   <script type="text/javascript" src="scripts/CommonScripts.js"></script>
   <script type="text/javascript" src="scripts/ASSETScripts.js"></script>
   
   
   
   
  
   
 <!-- LAYOUT SCRIPTS  -->  
   <script type="text/javascript" src="scripts/layouts/assetToolBar.js"></script>
 <!-- SCRIPT CONFIGURATION ENDS HERE  -->
 
 <!-- BASIC STYLE FILES STARTS HERE  -->
 <link rel="stylesheet" type="text/css" media="all" href="styles/ASSETStyles.css"/>
 <link rel="stylesheet" type="text/css"   href="qTip/jquery.qtip.css"/>
 <script type="text/javascript" src="qTip/jquery.qtip.js"></script>

 
 
 
 <script type="text/javascript"> 
 
 window.onload = function(){
 		assetOnloadFun();
  }

	  

</script>
 <!-- Datatables -->
<link href="styles/datatable/jquery.dataTables.css" rel="stylesheet">   
<link href="styles/datatable/fixedColumns.dataTables.min.css" rel="stylesheet">   
<link href="styles/datatable/jquery.dataTables.min.css" rel="stylesheet">   
<link href="styles/datatable/jquery.dataTables.css" rel="stylesheet">   
<link href="styles/datatable/keyTable.dataTables.min.css" rel="stylesheet">   
<link href="styles/datatable/responsive.bootstrap.css" rel="stylesheet">   
<link href="styles/datatable/select.dataTables.min.css" rel="stylesheet">   


<script src="scripts/datatable/jquery.dataTables.min.js"></script> 

<script src="scripts/datatable/dataTables.fixedColumns.min.js"></script> 
<script src="scripts/datatable/dataTables.keyTable.min.js"></script> 
<script src="scripts/datatable/dataTables.responsive.js"></script> 
<script src="scripts/datatable/dataTables.select.min.js"></script> 
<script src="scripts/datatable/jquery.dataTables.js"></script> 









</head>
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
<body>


<div id="layoutSkeleton" align="left" class="layoutSkeleton">
 <s:form id="assetForm" theme="simple" name="assetForm" method="POST" enctype="multipart/form-data">
 <div class="container-fluid fill" style="border: 1px solid #459c81; margin: -16px; min-height: 93vh">
		
		<div class="row" >
	 
			<tiles:insertAttribute name="header" /> 
		</div> 
		  
		<div class="row">
		
		<div id="sidebar-wrapper" class="col-md-2" style="margin-left: -14px;top: -15px;">
				<div id="sidebar">
					<tiles:insertAttribute name="sideMenu" />
				</div>
	   	</div>   
			 
	    <div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 pull-right" style="top: -15px;">
			<tiles:insertAttribute name="body" />
		</div> 
		
		</div>
		
		<div class="row footerStyles"  >
		<tiles:insertAttribute name="footer" />
		</div>
		
		</div>
		 
   <input type="hidden" name="hTxtFldASSETThemes"  id="hTxtFldASSETThemes" />
   <input type="hidden" name="hTxtFldASSETBldGrp"  id="hTxtFldASSETBldGrp" value=""/>
   <input type="hidden" name="hTxtFldASSETGendr"  id="hTxtFldASSETGendr" value=""/>
   
 </s:form>
 
   </div>
   <!-- On click Log Out - text wrapping issu-->
<!--   <div id="assetLogoutDiv" title="ASSET Logout"> -->
<%--     <p><span class="ui-icon ui-icon-alert" style="float: left;margin: 0 7px 20px 0;"></span> --%>
<!--     Are you sure to Logout ?</p> -->
<!--   </div>	 -->
  
	<div class="modal fade bs-example-modal-sm"  id="alertmsglogdiv" style="display: none;" 
tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel"></h4>
      </div>
      <div class="modal-body">
      <div id="alertimg" style="display: inline;"></div>
      <div id="alertmsg"  style="text-align: center; display: inline-block;"></div> 
      </div>
       <div class="modal-footer" > 
        <button type="button" class="btn btn-primary" >Ok</button> 
      </div>
      </div>
      </div>
      </div>
      
      
<div class="modal fade bs-example-modal-sm"  id="alertmsgdiv" style="display: none;" 
tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel"></h4>
      </div>
      <div class="modal-body">
      <div id="alertimg" style="display: inline;"></div>
      <div id="alertmsg"  style="text-align: center; display: inline-block;"></div> 
      </div>
       <div class="modal-footer" > 
        <button type="button" class="btn btn-primary" >Ok</button> 
      </div>
      </div>
      </div>
      </div>
      <input type="hidden" name="username" id="username" value="<%= session.getAttribute("uname")%>"> 
            
<script type="text/javascript"> 
	$( "#assetHeaderLinkLogout" ).on( "click", function() 
 	{ 
		showLogout("Are you sure to Logout ?");
	 });	
	var urlPath="<%=request.getContextPath()%>";
	
</script>
<!--         Loader -->
<div class="loading" style="">
        <img  src="images/Preloader_3.gif" class="imageloader" width="50%">
</div>
</body>
</html>



