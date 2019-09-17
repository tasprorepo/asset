<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>


<script type="text/javascript" src="scripts/assetSw.js"></script>

<script type="text/javascript" src="scripts/TableExport/jquerrybase64.js"></script>
<script type="text/javascript" src="scripts/TableExport/tableExport.js"></script>
<script type="text/javascript" src="scripts/TableExport/base64.js"></script>
<script type="text/javascript" src="scripts/TableExport/jspdf.js"></script>
<script type="text/javascript" src="scripts/TableExport/sprintf.js"></script>
<script type="text/javascript" src="scripts/base64.js"></script>
<script type="text/javascript" src="scripts/tableexport-2.1.js"></script>
<script type="text/javascript" src="scripts/Export2Excel.js"></script>
<script type="text/javascript" src="scripts/xlsx.core.min.js"></script>
<script type="text/javascript" src="scripts/tableexport-2.1.min.js"></script>
<script type="text/javascript" src="scripts/base64.js"></script>
<script type="text/javascript" src="scripts/tableexport-2.1.js"></script>
<script type="text/javascript" src="scripts/Export2Excel.js"></script>
<script type="text/javascript" src="scripts/xlsx.core.min.js"></script>
<script type="text/javascript" src="scripts/tableexport-2.1.min.js"></script>
<script type="text/javascript" src="scripts/jspdf.js"></script>
<script type="text/javascript" src="scripts/sprintf.js"></script>
<script type="text/javascript" src="scripts/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.debug.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<link rel="stylesheet" href="styles/popup.css" type="text/css">
<title>
  <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
    <span class="greycolor">Asset Software Details</span></div>
   <div class="panel-body scrollpanelBody"> 
    <input type="hidden" name="asset" id="asset" />

   <div class="table-responsive fieldsetClsborder"> 
   <div class="col-md-12">
   <div class="row">
   <div class="col-md-4">
  <div class="form-group">
    <label for="txtFldSrchSWName" class="assetLabel" style ="text-indent: unset;padding-left: 2px;">Software Name</label>
    <input type="text" id="txtFldSrchSWName" name="txtFldSrchSWName" 
    class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
  </div>
  </div>
    <div class="col-md-4">
  <div class="form-group">
    <label for="txtFldSrchSWLicense" class="assetLabel" style="text-indent: unset;padding-left: 2px;">License </label>
   <s:select label="LicenseType" headerKey="" headerValue="--- Select ---" 
   name="txtFldSrchSWLicense" id="txtFldSrchSWLicense" 
   list="%{#session.LICENSE_TYPE}" cssClass="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
  </div>
  </div>
    <div class="col-md-4">
  <div class="form-group">
   <label for="txtFldSrchSWCategory" class="assetLabel" style="text-indent: unset;padding-left: 2px;"> Software category </label>
    <s:select label="SWCategory" headerKey="" headerValue="--- Select ---" 
    name="txtFldSrchSWCategory" id="txtFldSrchSWCategory" 
    list="%{#session.SW_CATEGORY}" cssClass="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
  </div>
  </div>
   </div>
   </div>
    
   </div> 

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
						<span class="btn btn-default navbar-btn"  id="spnAsstSWAdd" >
						<img src="styles/images/addrow.png" width="20px" id="btnFldAssSwAddRow"  name="btnFldAssSwAddRow"/>
					</span> <span class="btn btn-default navbar-btn" id="spnAsstSWEdit">
						<img src="styles/images/editrow.png" width="20px" id="btnFldAssSWEditRow" name="btnFldAssSWEditRow"/>
					</span> <span class="btn btn-default navbar-btn"  id="spnAsstSWDel">
						<img src="styles/images/delrow.png" width="20px" id="btnFldAssSWDelRow" name="btnFldAssSWDelRow"/>
					</span> <span class="btn btn-default navbar-btn"  id="spnAsstSWExpand">
						<img src="styles/images/expandrow.png" width="20px"   id="btnFldAssSWEXpandRow" name="btnFldAssSWEXpandRow"  />
					</span>
					</div>
						 <div class="pull-right">
						<img src="styles/images/xlsicon.png" width="35px" id="btnExportSWXls" title="Export to xls" onclick="fnExcelReport();"/>
					 
						<img src="styles/images/pdficon.png" width="35px" id="btnExportSWPdf" title="Export to pdf" onclick="fnPdfReport();"/>
				 </div>
				</div>
		<div class="table-responsive fieldsetClsborder"> 

		<table id="assetSoftwareTable"  class="dataTable table-striped table-bordered display nowrap"  style="width:100%">
                                     <thead>
                                       <tr>
                                         <th class="assetSubHeader">Sl No</th>
                                         <th class="assetSubHeader">Select
                                          <span id="spnSelAllRow" style="display: none;">
                                            <input type="checkbox" name="chkSwbox" id="chkSwbox" onclick="selAllRows(this);" />
                                          </span>
                                         </th>
                                         <th class="assetSubHeader">Mode</th>
                                         <th class="assetSubHeaderMand">Software Name</th>
                                         <th class="assetSubHeader">Software Category</th>
                                         <th class="assetSubHeader">License Type</th>
                                         <th class="assetSubHeaderMand">License Key</th>
                                         <th class="assetSubHeader">Status</th>
                                         <th class="assetSubHeader">Remarks</th>
                                       </tr>
                                     </thead>
                                     <tbody>
                                     </tbody>
                                   </table> 
                                   </div>
                                   

	</div> 
     
  </div>  
  
 <!-- Modal  -->
<div class="modal fade" id="swfreeformdiv" style="display: none"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog scrollModelBodyWidth1000" role="document">
    <div class="modal-content" style="width:60%; margin: 0px 153px 0px 205px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span data-dismiss="modal" aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
     <fieldset class="fieldsetClsborder scrollModelBody60">
     
		<div class="col-md-8"> 
		<div class="form-group required">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstSWFrmName" class="control-label pull-right" style="text-indent:-48px;">
			 Software Name<sup style="color:red; font-size:15px;">*</sup> </label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6">  
		  <input type="text" id="txtFldAsstSWFrmName"  name="txtFldAsstSWFrmName"  maxlength="60" class="form-control" onmouseover="assetTooltip(this);" />
          </div> 
            </div>
      </div>
      
      
      <div class="form-group required">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstSWFrmCatrgy" class="control-label pull-right " style="text-indent:-68px;">
              Software Category</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <s:select  label="SWCategory" headerKey="" headerValue="--- Select ---" name="txtFldAsstSWFrmCatrgy" id="txtFldAsstSWFrmCatrgy" list="%{#session.SW_CATEGORY}" cssClass="form-control" onmouseover="assetTooltip(this);" theme="simple"/>				
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstSWFrmLType" class="control-label pull-right ">
              License Type</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <s:select  label="SWLicenseType" headerKey="" headerValue="--- Select ---" name="txtFldAsstSWFrmLType" id="txtFldAsstSWFrmLType" list="%{#session.LICENSE_TYPE}" cssClass="form-control" onmouseover="assetTooltip(this);" theme="simple"/>
            </div> 
            </div>
      </div>
      <div class="form-group">
	          <div class="row" >
	              <div class="col-md-6 col-sm-6 col-xs-6 "> 
                     <label for="txtFldAsstSWFrmLKey" class="control-label pull-right" >
                        License Key<sup style="color:red; font-size:15px;">*</sup></label>
                    </div> 
                        <div class="col-md-6 col-sm-6 col-xs-6"> 
                          <input type="text" id="txtFldAsstSWFrmLKey" name="txtFldAsstSWFrmLKey"   maxlength="150" class="form-control" onmouseover="assetTooltip(this);"  />
                         </div> 
            </div>
       </div>
       
        <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstSWFrmStatus">
             Status</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <s:select  label="SWStatus" headerKey="" headerValue="--- Select ---" name="txtFldAsstSWFrmStatus" id="txtFldAsstSWFrmStatus" list="%{#session.SW_STATUS}" onmouseover="assetTooltip(this);" cssClass="form-control"  theme="simple"/>
            </div> 
            </div>
      </div>
      
     <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstSWFrmRmks">
              Remarks</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <textarea  rows="6" name="txtFldAsstSWFrmRmks" id="txtFldAsstSWFrmRmks" class="form-control"  onmouseover="assetTooltip(this);"   maxlength="300" cols="30"></textarea>
            </div> 
            </div>
      </div>
 </div>
 
        <div class="form-group">
        <input type="hidden" id="txtFldAsstSWFrmId" name="txtFldAsstSWFrmId"/>
        </div>
       
      </fieldset> 
      </div>
      <div class="modal-footer text-center"> 
        <button type="button" class="btn btn-primary">Ok</button>
         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
  </div>
  </body>
  <script>
SW_CATEGORY_VAR="<%= session.getAttribute("SW_CATEGORY")%>";

LICENSE_TYPE_VAR="<%= session.getAttribute("LICENSE_TYPE")%>";

SW_STATUS_VAR="<%= session.getAttribute("SW_STATUS")%>";

window.onload =  function()
{
	loadSWinit(); 
}

</script>
</html>