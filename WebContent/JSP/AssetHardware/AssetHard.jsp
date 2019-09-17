<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="styles/jquery.freezeheader.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href  ="styles/popup.css" type="text/css"> 



  
<title>
  <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body > 
  <div class="panel panel-default">
    <div class="panel-heading">
    <span class="greycolor">Asset Hardware Details</span></div>
   <div class="panel-body scrollpanelBody"  style="height:450px" > 
    <input type="hidden" name="asset" id="asset" />

   <div class="table-responsive fieldsetClsborder"> 
   <div class="col-md-12">
   <div class="row">
   <div class="col-md-4">
   <div class="form-group">
    <label for="txtFldSrchHDName" class="assetLabel" style="text-indent:unset;padding-left: 2px;">Hardware Name /Machine Name</label>
    <input type="text" id="txtFldSrchHDName" name="txtFldSrchHDName" class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
  </div>
  </div>
    <div class="col-md-4">
   <div class="form-group">
    <label for="txtFldSrchHDModel" class="assetLabel" style="text-indent:unset;padding-left: 2px;">Hardware Model </label>
   <input type="text" id="txtFldSrchHDModel" name="txtFldSrchHDModel"  class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
  </div>
  </div>
    <div class="col-md-4">
  <div class="form-group">
   <label for="txtFldSrchHDAttotTo" class="assetLabel" style="text-indent:unset;padding-left: 2px;"> Allotted To </label>
    <input type="text" id="txtFldSrchHDAttotTo" name="txtFldSrchHDAttotTo"   class="form-control fld-resp-md required"  onmouseover="assetTooltip(this);"/>
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
					<span class="btn btn-default navbar-btn"  id="spnAsstHWAdd" >
						<img src="styles/images/addrow.png" width="20px" title="Add Row"  id="btnFldAssHdAddRow"  name="btnFldAssHdAddRow"/>
					</span> 
					<span class="btn btn-default navbar-btn" id="spnAsstHWEdit">
						<img src="styles/images/editrow.png" width="20px" title="Edit Row" id="btnFldAssHdEditRow" name="btnFldAssHdEditRow"/>
					</span>
					 <span class="btn btn-default navbar-btn"  id="spnAsstHWDel">
						<img src="styles/images/delrow.png" width="20px" title="Delete Row" id="btnFldAssHdDelRow" name="btnFldAssHdDelRow"/>
					</span>
					 <span class="btn btn-default navbar-btn"  id="spnAsstHWExpand">
						<img src="styles/images/expandrow.png" width="20px" title="Expand Row"  id="btnFldAssHdViewRow"  name="btnFldAssHdViewRow" />
					</span>
					</div>
						 <div class="pull-right">
						  
						<img src="styles/images/xlsicon.png" width="35px" id="btnExportHWXls" title="Export to xls" onclick="fnExcelReport();"/>
					 
						<img src="styles/images/pdficon.png" width="35px" id="btnExportHWPdf" title="Export to pdf" onclick="fnPdfReport();"/>
				
				 </div>
				</div>
		<div class="table-responsive fieldsetClsborder"> 

		<table id="assetHardwareTable"   class="dataTable table-striped table-bordered"  style="width:100%">
                                   	  
                                     <thead  >
                                       <tr>
                                         <th class="assetSubHeader">#</th>
                                         <th class="assetSubHeader">Select</th>
                                         <th class="assetSubHeader">Mode</th>
                                        <th class="assetSubHeaderMand">Hardware Name</th>
                                         <th class="assetSubHeader">Hardware Make</th>
                                         <th class="assetSubHeader">Hardware Model</th>
                                         <th class="assetSubHeader">Serial No</th>
                                         <th class="assetSubHeader">Alloted To</th>
                                 
                                       </tr>
                                     </thead>
                                     <tbody></tbody>
                                   </table>	 

  
  
  
  
  
   <!-- Modal  -->
<div class="modal fade" id="hwfreeformdiv" style="display: none"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog scrollModelBodyWidth1000" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span data-dismiss="modal" aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
     <fieldset class="fieldsetClsborder">
     
		<div class="col-md-4"> 
		<div class="form-group required">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmName" class="control-label pull-right ">
			 Hardware Name<sup style="color:red; font-size:15px;">*</sup></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6">  
		<input type="text" id="txtFldAsstHDFrmName"  name="txtFldAsstHDFrmName" class="form-control" onmouseover="assetTooltip(this);"  maxLength="150" />			
          </div> 
            </div>
      </div>
      
      
      <div class="form-group required">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmMake" class="control-label pull-right ">
              Hardware Make</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmMake" name="txtFldAsstHDFrmMake" maxlength="150" class="form-control" onmouseover="assetTooltip(this);"    />
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmModel" class="control-label pull-right ">
              Hardware Model</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstHDFrmModel" name="txtFldAsstHDFrmModel"  class="form-control" onmouseover="assetTooltip(this);" maxLength="150" />
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmSerlNo" class="control-label pull-right ">
             Serial No<sup style="color:red; font-size:15px;">*</sup></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstHDFrmSerlNo" name="txtFldAsstHDFrmSerlNo"  onmouseover="assetTooltip(this);" maxlength="150" class="form-control"  />
            </div> 
            </div>
      </div>
      
       <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmMACId" class="control-label pull-right ">
             MAC ID</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstHDFrmMACId" name="txtFldAsstHDFrmMACId"  onmouseover="assetTooltip(this);"  class="form-control"  maxLength="60"/>
            </div> 
            </div>
      </div>
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right" for="txtFldAsstHDFrmAllotTo">
             Alotted To</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmAllotTo" name="txtFldAsstHDFrmAllotTo"  onmouseover="assetTooltip(this);" class="form-control"  maxLength="120"/>
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmOperSys">
              Operating System<sup style="color:red; font-size:15px;">*</sup></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmOperSys" name="txtFldAsstHDFrmOperSys" onmouseover="assetTooltip(this);" class="form-control"  maxLength="150" />
            </div> 
            </div>
      </div>
      
         
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmOperSysver" style="text-indent:-73px; padding-left:58px;">
              Operating System Version</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
         <input type="text" id="txtFldAsstHDFrmOperSysver" name="txtFldAsstHDFrmOperSysver"  onmouseover="assetTooltip(this);" class="form-control" maxLength="120"  />
            </div> 
            </div>
      </div>
       <div class="form-group">
	    <div class="row" >
	        <div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right" for="txtFldAsstHDProssr">
			Processor</label> 
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstHDFrmProssr" name="txtFldAsstHDFrmProssr"  class="form-control" onmouseover="assetTooltip(this);" maxLength="60" /></div> 
            </div>
      </div>
      
</div>
       
       <div class="col-md-4"> 
		 <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmProssrSpd">
             Processor Speed</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmProssrSpd" name="txtFldAsstHDFrmProssrSpd" class="form-control" onmouseover="assetTooltip(this);"  maxLength="30"/>
            </div> 
            </div>
      </div>
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmRAM">
             RAM</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmRAM" name="txtFldAsstHDFrmRAM"  class="form-control" onmouseover="assetTooltip(this);"  maxLength="10"/>
            </div> 
            </div>
      </div>
       <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmLocID">
             Loc Id</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmLocID" name="txtFldAsstHDFrmLocID"  class="form-control" onmouseover="assetTooltip(this);" maxLength="30" />
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
            <label class="control-label pull-right " for="txtFldAsstHDFrmHDD">
						HDD</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmHDD" name="txtFldAsstHDFrmHDD"  class="form-control" onmouseover="assetTooltip(this);"  maxLength="120"/>
            </div> 
            </div>
      </div>
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmServCatxtFldAsstHDFrmOperSysteg" class="control-label pull-right ">
             Server Category</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmServCateg" name="txtFldAsstHDFrmServCateg"class="form-control" onblur="" onmouseover="assetTooltip(this);"   maxlength="150" /> 
            </div>
      </div>
    </div>
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmIP" class="control-label pull-right ">
             IP No</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmIP" name=""class="form-control" onblur="txtFldAsstHDFrmIP" onmouseover="assetTooltip(this);"   maxlength="20" /> 
            </div>
      </div>
    </div>
     <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmHDDPartitions"> 
             HDD Partitions</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmHDDPartitions" name="txtFldAsstHDFrmHDDPartitions"  class="form-control" onmouseover="assetTooltip(this);"  maxLength="120" />
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmRmks"> 
            Remarks</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
        <textarea  class="form-control" rows="6" name="txtFldAsstHDFrmRmks" id="txtFldAsstHDFrmRmks" cols="35" style="resize:none" onmouseover="assetTooltip(this);"  maxLength="4000" ></textarea>
            </div> 
            </div>
      </div>
    
</div>
       
       
       <div class="col-md-4"> 
     
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmPartNo">
             Part No</label> 
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstHDFrmPartNo" name="txtFldAsstHDFrmPartNo"  class="form-control" onmouseover="assetTooltip(this);"  maxLength="30" />
            </div> 
            </div>
      </div>
      
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmCateg">
             Category</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <s:select  label="HWCategory" headerKey="" headerValue="--- Select ---" name="txtFldAsstHDFrmCateg" id="txtFldAsstHDFrmCateg" list="%{#session.HW_CATEGORY}" cssClass="form-control" onmouseover="assetTooltip(this);" theme="simple" />				
            </div> 
            </div>
      </div>
      
      
      
      <div class="form-group" >
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmStatus">
             Hardware Status </label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
        <s:select   label="HWStatus" headerKey="" headerValue="--- Select ---" name="txtFldAsstHDFrmStatus" id="txtFldAsstHDFrmStatus" list="%{#session.HW_STATUS}" cssClass="form-control" onmouseover="assetTooltip(this);" theme="simple"  />				
            </div> 
            </div>
      </div>
      
      
      <div class="form-group" >
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstHDFrmPurchaseDate">
             Purchase Date</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
        <input type="text" id="txtFldAsstHDFrmPurchaseDate" name="txtFldAsstHDFrmPurchaseDate"  class="form-control"
         onblur="validateDate(this);" onmouseover="assetTooltip(this);" onkeyup="hideDatepickerIt(this)" onfocus="showDatepickerIt(this)" /> 
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmWarrantyStartDate" class="control-label pull-right ">
             Warranty StartDate</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmWarrantyStartDate" name="txtFldAsstHDFrmWarrantyStartDate"
           class="form-control"  
           onblur="ChkWarrantyEndDateValidation('txtFldAsstHDFrmWarrantyStartDate','txtFldAsstHDFrmWarrantyEndDate')"
           onmouseover="assetTooltip(this);" onkeyup="hideDatepickerIt(this)" onfocus="showDatepickerIt(this)"/>
           </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmWarrantyEndDate" class="control-label pull-right ">
             Warranty EndDate</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmWarrantyEndDate" name="txtFldAsstHDFrmWarrantyEndDate"  class="form-control"  onblur="ChkWarrantyEndDateValidation('txtFldAsstHDFrmWarrantyStartDate','txtFldAsstHDFrmWarrantyEndDate')" 
          onmouseover="assetTooltip(this);" onkeyup="hideDatepickerIt(this)" onfocus="showDatepickerIt(this)"/> 
            </div>
      </div>
    </div>
     <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmWarrantyStatusDescription" class="control-label pull-right " style="padding-left: 35px; text-indent:65px;">
             Warranty Status Description</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmWarrantyStatusDescription" name="txtFldAsstHDFrmWarrantyStatusDescription" class="form-control" onblur="" onmouseover="assetTooltip(this);"  maxLength="4000" /> 
            </div>
      </div>
    </div>
        <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmCpuSockets" class="control-label pull-right ">
             CPU Socket </label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmCpuSockets" name="txtFldAsstHDFrmCpuSockets"  class="form-control" onblur="" onmouseover="assetTooltip(this);"  maxLength="150" /> 
            </div>
      </div>
    </div>
     <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmTotCores" class="control-label pull-right ">
             Total Cores</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmTotCores" name="txtFldAsstHDFrmTotCores"class="form-control" onblur="" onmouseover="assetTooltip(this);"   maxlength="150" /> 
            </div>
      </div>
    </div>
    <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstHDFrmLogProcess" class="control-label pull-right " style="text-indent:-50px">
            Logical Processors </label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstHDFrmLogProcess" name="txtFldAsstHDFrmLogProcess" class="form-control" onblur="" onmouseover="assetTooltip(this);" maxlength="150"  /> 
            </div>
      </div>
    </div>
      
        <div class="form-group">
        <input type="hidden" id="txtFldAsstHDFrmId" name="txtFldAsstHDFrmId"/>
         </div>
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
  </div>
  </div>
  </div>
  
</body>





 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.debug.js"></script>

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
<script type="text/javascript" src="scripts/jquery.freezeheader.js"></script>

<script type="text/javascript" src="scripts/ASSETConstants.js"></script>
<script type="text/javascript" src="scripts/base64.js"></script>
<script type="text/javascript" src="scripts/tableexport-2.1.js"></script>
<script type="text/javascript" src="scripts/Export2Excel.js"></script>
<script type="text/javascript" src="scripts/xlsx.core.min.js"></script>
<script type="text/javascript" src="scripts/tableexport-2.1.min.js"></script>
<script type="text/javascript" src="scripts/jspdf.js"></script>
<script type="text/javascript" src="scripts/sprintf.js"></script>
<script type="text/javascript" src="scripts/jspdf.min.js"></script>

<script type="text/javascript" src="scripts/assetHw.js"></script>

<script>
HW_CATEGORY_VAR="<%= session.getAttribute("HW_CATEGORY")%>";
HW_STATUS_VAR="<%= session.getAttribute("HW_STATUS")%>"; 
window.onload =  function()
{ 
	loadHWinit();  
}

function loadFixedHeadTbl()
{
}
</script>
  

</html>