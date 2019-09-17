<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<%--  --%>
<html>
<head>
  <script type="text/javascript"  src="scripts/plugins/jquery-ui.js"></script>
<script type="text/javascript" src="scripts/serviceTracking.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  

<title>
  <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>

<script>

HW_NAME_LIST="<%= session.getAttribute("HARDWARE_LIST")%>"; 
SW_NAME_LIST="<%= session.getAttribute("SOFTWARE_LIST")%>"; 
VENDOR_NAME_LIST="<%= session.getAttribute("VENDOR_LIST")%>"; 


window.onload =  function()
{
	loadStinit(); 
}
</script>

<script type="text/javascript">

	$(function()
			{
		
		$("#btnFldSrvcTrAddRow").click(function(){ 
			srvcaddRow();
		});
		
		$("#btnFldSrvcTrEditRow").click(function(){
			srvceditRow();
		});
		
		$("#btnFldSrvcTrDelRow").click(function(){
			srvcdeleteRow();
		});
	});<%  %>
	
</script>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
    <span class="greycolor">Service Tracking Details</span></div>
   <div class="panel-body scrollpanelBody"> 
    <input type="hidden" name="asset" id="asset" />
<%--     <span class="greencolor">Search Criteria</span>  --%>
   <div class="table-responsive fieldsetClsborder"> 
   <div class="col-md-12">
   <div class="row">
   <div class="col-md-4">
  <div class="form-group">
    <label for="txtFldSrchHWName" class="assetLabel">Hardware Name</label>
    <s:select  label="HWName" headerKey="" headerValue="--- Select ---" name="txtFldSrchHWName" id="txtFldSrchHWName" list="%{#session.HARDWARE_LIST}" cssClass="form-control fld-resp-md required"   onmouseover="assetTooltip(this);"/>
  </div>
  </div>
    <div class="col-md-4">
  <div class="form-group">
    <label for="txtFldSrchSWName" class="assetLabel">Software Name </label>
     <s:select  label="SWName" headerKey="" headerValue="--- Select ---" name="txtFldSrchSWName" id="txtFldSrchSWName" list="%{#session.SOFTWARE_LIST}" cssClass="form-control fld-resp-md required"   onmouseover="assetTooltip(this);"/>
  </div>
  </div>
    <div class="col-md-4">
  <div class="form-group">
   <label for="txtFldSrchVDName" class="assetLabel"> Vendor Name </label>
      <s:select  label="VDName" headerKey="" headerValue="--- Select ---" name="txtFldSrchVDName" id="txtFldSrchVDName" list="%{#session.VENDOR_LIST}" cssClass="form-control fld-resp-md required"   onmouseover="assetTooltip(this);"/>
     </div>
  </div>
   </div>
   </div>
    
   </div> 
<%-- 	<span class="greencolor">Details</span> --%>
	 	<s:if test="hasActionMessages()">
					<div id="successmsgdiv" class="alert alert-success alert-dismissible fade in" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button> 
    							  <s:actionmessage/> 
					</div>
		 </s:if>
     <div class="table-responsive">
				<div class="btn-group pull-left" role="group">
						<span class="btn btn-default navbar-btn"  id="spnSrvcTrAdd" >
						<img src="styles/images/addrow.png" width="20px" id="btnFldSrvcTrAddRow"  name="btnFldSrvcTrAddRow"/>
					</span> <span class="btn btn-default navbar-btn" id="spnSrvcTrEdit">
						<img src="styles/images/editrow.png" width="20px" id="btnFldSrvcTrEditRow" name="btnFldSrvcTrEditRow"/>
					</span> <span class="btn btn-default navbar-btn"  id="spnSrvcTrDel">
						<img src="styles/images/delrow.png" width="20px" id="btnFldSrvcTrDelRow" name="btnFldSrvcTrDelRow"/>
					</span> 
<%-- 					<span class="btn btn-default navbar-btn"  id="spnAsstSWExpand"> --%>
<!-- 						<img src="styles/images/expandrow.png" width="20px"   onclick="showServTrFreeForm()"/> -->
						
<%-- 					</span> --%>
					</div>
<!-- 						 <div class="pull-right"> -->
<!-- 						<img src="styles/images/xlsicon.png" width="35px" id="btnExport" title="Export to xls" onclick="fnExcelReport();"/> -->
					 
<!-- 						<img src="styles/images/pdficon.png" width="35px" id="btnExport" title="Export to pdf" onclick="fnPdfReport();"/> -->
<!-- 				 </div> -->
				</div>
		<div class="table-responsive fieldsetClsborder"> 
<!-- 		<div style="overflow: scroll;width: 1020px;height:250px" >    -->
		<table   id="serviceTrackingTable" class="dataTable table-striped table-bordered display nowrap"  style="width:100%">
                                     <thead>
                                       <tr>
                                         <th class="assetSubHeader">#Sl No</th>
                                         
                                         <th class="assetSubHeader">Select
                                          <span id="spnSelAllRow" style="display: none;">
                                            <input type="checkbox" name="chkSwbox" id="chkSwbox" onclick="selcAllRows(this);" />
                                          </span>
                                         </th>
                                         <th class="assetSubHeader">Mode</th>
                                         <th class="assetSubHeaderMand">Hardware Name</th>
                                         <th class="assetSubHeaderMand">Software Name</th>
                                         <th class="assetSubHeaderMand">Vendor Name</th>
                                         <th class="assetSubHeaderMand">Service Request</th>
                                         <th class="assetSubHeaderMand">Service Date</th>
                                       	 <th class="assetSubHeader">Remarks</th>
                                       	 <th class="assetSubHeader">Created User ID</th>
                                         <th class="assetSubHeader">Created Date Time</th>
                                         <th class="assetSubHeader">Modified User ID</th>
                                         <th class="assetSubHeader">Modified Date Time</th>
                                       </tr>
                                     </thead>
                                     <tbody>
                                     </tbody>
                                   </table>
<!--                                    </div> -->
                                   
	</div>
	 
	</div> 
     
  </div>  
  
  
 

</body>
</html>