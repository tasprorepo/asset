<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>

<html>
<head>

<script type="text/javascript" src="scripts/assetVendor.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>jQuery UI Tabs - Default functionality</title>   


<title>
  <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
<% HttpSession sess=request.getSession();
String fpssoid=(request.getParameter("ses") != null ? request.getParameter("ses") : ""); 
sess.setAttribute("fpssoid",fpssoid);

%>


 <script>
 VN_COUNTRY_VAR = "<%= session.getAttribute("VN_COUNTRY") %>";
 baseUrl = "<%= request.getContextPath() %>";
 avadsid = "<%= session.getAttribute("fpssoid") %>";
	
  $(function() {
    loadVeninit();
  });
 </script>
  
  <script type="text/javascript">

	$(function(){
		/* $("#btnFldAssVdAddRow").click(function(){
			navToVendor();
		}) */;
		
		$("#btnFldAssVdAddRow").click(function(){ 
			VendorAddRow(null);
		});
		
		
		
		/*  $("#btnFldAssVdEditRow").click(function(){
			
			editVDRow(); 
			
			 selectRowFun(this);myFunction(this); 
			 alert("Please ");
		});  */
		
		/* $("#btnFldAssVdDelRow").click(function(){
			deleteVDRow();
		}); */
		
		$("#btnFldAssVdserAddRow").click(function(){
			
			addSerRow();
		});
		$("#btnFldAssVdserEditRow").click(function(){
			
			editSerRow();
		});
		$("#btnFldAssVdserDelRow").click(function(){
			
			deleteSerRow();
		});
		$("#btnFldAssVdconAddRow").click(function(){
			
			addConRow();
		});
		$("#btnFldAssVdconEditRow").click(function(){
			
			editConRow();
		});
		$("#btnFldAssVdconDelRow").click(function(){
			
			deleteConRow();
		});
	});
</script>


</head>

<body>

<div class="panel panel-default">
    <div class="panel-heading">
    <span class="greycolor">Asset Vendor Details</span></div>
   <div class="panel-body scrollpanelBody"> 
    <input type="hidden" name="asset" id="asset" />

   <div class="table-responsive fieldsetClsborder">  
    <div class="col-md-4 col-md-offset-4">
         <div class="form-group">
    <label for="txtFldSrchVDName" class="assetLabel">Vendor Name</label>
    <input type="text" id="txtFldSrchVDName" name="txtFldSrchVDName" class="form-control required"  onmouseover="assetTooltip(this);"/>
  </div> 
</div>  
   </div> 
    
        <div class="col-md-9">

	 	<s:if test="hasActionMessages()">
					<div id="successmsgdiv" class="alert alert-success alert-dismissible fade in" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button> 
    							  <s:actionmessage/> 
					</div>
		 </s:if>
		 
		 
		  <!-- ASSET VENDOR CRUD BY POOVATHI -->
                    
                    <div class="table-responsive">
				        <div class="btn-group pull-left" role="group">
						<span class="btn btn-default navbar-btn"  id="spnAsstVdAdd" >
						<img src="styles/images/addrow.png" width="20px" title="Add Row"  id="btnFldAssVdAddRow"  name="btnFldAssVdAddRow"/>
					    </span> 
					    <span class="btn btn-default navbar-btn" id="spnAsstVdEdit">
						<img src="styles/images/editrow.png" width="20px" title="Edit Row" id="btnFldAssVdEditRow" name="btnFldAssVdEditRow" data-toggle="modal" data-target="#myModalAssVdEditRow"/>
					    </span>
					     <span class="btn btn-default navbar-btn"  id="spnAsstVdDel">
						<img src="styles/images/delrow.png" width="20px" title="Delete Row" id="btnFldAssVdDelRow" name="btnFldAssVdDelRow"/>
					    </span>
					     <span class="btn btn-default navbar-btn"  id="spnAsstVdExpand">
						<img src="styles/images/expandrow.png" width="20px" title="Expand Row"  id="btnFldAssVdViewRow"  name="btnFldAssVdViewRow" data-toggle="modal" data-target="#myModalAssVdViewRow" />
					    </span>
					    </div>
					    
					                   <div class="pull-right">
						  
						          <img src="styles/images/xlsicon.png" width="35px" id="btnExportHWXls" title="Export to xls" onclick="fnExcelReport();"/>
					 
						          <img src="styles/images/pdficon.png" width="35px" id="btnExportHWPdf" title="Export to pdf" onclick="fnPdfReport();"/>
				
				         </div>
				 
				 
					</div>
					<!-- END VENDOR CRUD BY POOVATHI -->
		 
		 
		 
		 
		  <div class="tab" role="tabpanel" id="vendornavdiv">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"  id="li_vd_Search"><a href="#Search" aria-controls="home" role="tab" data-toggle="tab">Search Result</a></li>
                    <li role="presentation"  id="li_vd_Vendor"><a href="#Vendor" aria-controls="profile" role="tab" data-toggle="tab">Vendor Details</a></li>
                    <li role="presentation"  id="li_vd_Contact"><a href="#Contacts" aria-controls="messages" role="tab" data-toggle="tab">Contact Details</a></li>
                </ul>
                
               <%--  <!-- ASSET VENDOR CRUD BY POOVATHI -->
                    
                    <div class="table-responsive">
				        <div class="btn-group pull-left" role="group">
						<span class="btn btn-default navbar-btn"  id="spnAsstVdAdd" >
						<img src="styles/images/addrow.png" width="20px" title="Add Row"  id="btnFldAssVdAddRow"  name="btnFldAssVdAddRow"/>
					    </span> 
					    <span class="btn btn-default navbar-btn" id="spnAsstVdEdit">
						<img src="styles/images/editrow.png" width="20px" title="Edit Row" id="btnFldAssVdEditRow" name="btnFldAssVdEditRow"/>
					    </span>
					     <span class="btn btn-default navbar-btn"  id="spnAsstVdDel">
						<img src="styles/images/delrow.png" width="20px" title="Delete Row" id="btnFldAssVdDelRow" name="btnFldAssVdDelRow"/>
					    </span>
					     <span class="btn btn-default navbar-btn"  id="spnAsstVdExpand">
						<img src="styles/images/expandrow.png" width="20px" title="Expand Row"  id="btnFldAssVdViewRow"  name="btnFldAssVdViewRow" />
					    </span>
					    </div>
					</div>
					<!-- END VENDOR CRUD BY POOVATHI --> --%>
                
                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active" id="Search">
                        <span class="greycolor">Search Result</span> 
                        <div class="table-responsive fieldsetClsborder"> 
<!--                         <div style="overflow: scroll;width: 690px;height:250px" >  -->


<!--Vendor table commented by poovathi  -->

                       <%--  <table id="assetVendorNamTable" class="dataTable table-striped table-bordered display nowrap"  style="width:100%">
                       
                                       <thead>
                                         <tr>
                                         <th class="assetSubHeader">Sl No</th>
                                         <th class="assetSubHeader" style="display: none;" >Select
                                         <span id="spnSelAllRow" >
                                         <input type="checkbox" name="chkVdbox" id="chkVdbox" onclick="selAllRows(this);" />
                                         </span>
                                         </th>
                                         <th class="assetSubHeader">Mode</th>
                                         <th class="assetSubHeaderMand">Select</th>
                                         <th class="assetSubHeaderMand">Vendor Rep</th>
                                         <th class="assetSubHeaderMand">Name</th> 
                                         <th class="assetSubHeader">Vendor HP</th>
                                         <th class="assetSubHeader">Email</th> 
                                         <th class="assetSubHeader">Contacts 24/7</th> 
                                         </tr>
                                     </thead>
                                     
                                     <tbody>
                                     </tbody>
                                   </table> --%>
                                   
                                   <table id="assetVendorNamTable"   class="dataTable table-striped table-bordered"  style="width:100%">
                                   	  
                                     <thead  >
                                       <tr>
                                         <th class="assetSubHeader">#</th>
                                         <th class="assetSubHeader">Mode</th>
                                         <th class="assetSubHeader">Select</th>
                                        <th class="assetSubHeaderMand">Vender Rep</th>
                                         <th class="assetSubHeader">Vendor Name</th>
                                         <th class="assetSubHeader">Vendor HP</th>
                                         <th class="assetSubHeader">Email </th>
                                         <th class="assetSubHeader">Contacts 24/7</th>
                                 
                                       </tr>
                                     </thead>
                                     <tbody></tbody>
                                   </table>	  
                                   
                                   
                                   

                                 </div>  
                    </div>
                    
                    <div role="tabpanel" class="tab-pane fade" id="Vendor">
                     <div class="row">
                      <fieldset class="fieldsetClsgreyborder col-md-12" style="top: -25px;">
                      <legend> Vendor Details </legend>
                     <div class="row vertical-divider">  
                      <div class="form-group" style="display:none">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldServiceVendrId" class="assetLabel pull-right ">
                       Vendor ID</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldServiceVendrId" name="txtFldServiceVendrId" readonly="true" class="form-control fld-resp-md required" />
                      </div>
                      </div> 
				  </div>
				  
				  
				  <div class="form-group">
                      <div class="row">
                      <div class="col-sm-2">
                       <label for="txtFldServiceVendrRep" class="assetLabel pull-right ">
                      Vendor Rep<sup style="color:red; font-size:15px;">*</sup></label>
                      </div>
                      <div class="col-sm-2">
                      <input type="text" id="txtFldServiceVendrRep" name="txtFldServiceVendrRep" maxlength="150" class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
                      </div>
                      </div> 
				  </div>
				  
				  
				  <div class="form-group">
                      <div class="row">
                      <div class="col-sm-2">
                       <label for="txtFldAsstVDServiceName" class="assetLabel pull-right ">
                       Name<sup style="color:red; font-size:15px;">*</sup></label>
                      </div>
                      <div class="col-sm-2">
                     <input type="text" id="txtFldAsstVDServiceName" name="txtFldAsstVDServiceName" maxlength="60" onBlur="validateName(this.id)" class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
                      </div>
                      </div> 
				  </div>
				  
				  </div>
                      </fieldset>
                      </div>
                      <div class="row">
                       <fieldset class="fieldsetClsgreyborder col-md-6" style="top: -25px;">
                      <legend> Address Details </legend>
                     <div class="row vertical-divider">  
                     
                      <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceAddr1" class="assetLabel pull-right ">
                       Address1</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServiceAddr1" name="txtFldAsstVDServiceAddr1"  onmouseover="assetTooltip(this);" maxlength="60" class="form-control fld-resp-md required" />
                      </div>
                      </div> 
                      </div> 
                      
                      
                     <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceAddr2" class="assetLabel pull-right ">
                       Address2</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServiceAddr2" name="txtFldAsstVDServiceAddr2" 
                       onmouseover="assetTooltip(this);" maxlength="60" class="form-control fld-resp-md required" />
                      </div>
                      </div> 
                      </div> 
                      
                      
                      
                      <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceAddr3" class="assetLabel pull-right">
                       Address3</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServiceAddr3" name="txtFldAsstVDServiceAddr3" onmouseover="assetTooltip(this);"  maxlength="60" class="form-control fld-resp-md required" />
                      </div>
                      </div> 
                      </div>
                      
                      
                      <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceCity" class="assetLabel pull-right ">
                       City</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServiceCity" name="txtFldAsstVDServiceCity"  onmouseover="assetTooltip(this);" maxlength="60" class="form-control fld-resp-md required" />
                      </div>
                      </div> 
                      </div>
                      
                      
                      <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceCountry" class="assetLabel pull-right">
                       Country</label>
                      </div>
                      <div class="col-sm-4">
                      <s:select   label="AssetVDCountry" headerKey="" headerValue="--- Select ---" name="txtFldAsstVDServiceCountry" id="txtFldAsstVDServiceCountry" list="%{#session.VN_COUNTRY}" onmouseover="assetTooltip(this);" cssClass="form-control fld-resp-md required" theme="simple"/>
                      </div>
                      </div> 
                      </div>
                      
                      <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServicePcode" class="assetLabel pull-right">
                       Pincode</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServicePcode" name="txtFldAsstVDServicePcode"  onmouseover="assetTooltip(this);" maxlength="20"class="form-control fld-resp-md required" />
                      </div>
                      </div> 
                      </div> 
                       
				  </div>
                      </fieldset> 
                       <fieldset class="fieldsetClsgreyborder col-md-6" style="top: -25px;height: 285px;left: 2px;">
                      <legend> Contact Details </legend>
                      <div class="row vertical-divider">  
                      <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceFax" class="assetLabel pull-right ">
                       Fax</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServiceFax" name="txtFldAsstVDServiceFax" maxlength="30" onmouseover="assetTooltip(this);" class="form-control fld-resp-md required" />
                      </div>
                      </div> 
                      </div> 
                      
                      
                      
                    <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceEmail" class="assetLabel pull-right ">
                       Email<sup style="color:red; font-size:15px;">*</sup></label>
                    </div>
                      
                    <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServiceEmail" name="txtFldAsstVDServiceEmail" maxlength="60"
                             onBlur="validateEmail(this.id)" onmouseover="assetTooltip(this);" 
                             class="form-control fld-resp-md required" />	
                      </div>
                      <div class="col-sm-1" style="margin-left: 30px;"> 
                      <a href="mailto:thulasy@avallis.com?Subject=Vendor Service Email From Asset System" target="_top">
                       		<img src="images/mail.png" width="100%"/>
                       	</a>
                      </div>
                     </div> 
                    </div> 
                    
                    <div class="form-group">
                      <div class="row">
                       <div class="col-sm-4">
                        <label for="txtFldAsstVDServiceWebsite" class="assetLabel pull-right ">
                         Website</label>
                       </div>
                       <div class="col-sm-4">
                        <input type="text" id="txtFldAsstVDServiceWebsite" name="txtFldAsstVDServiceWebsite"
                         maxlength="150" onBlur="validateWebsite(this.id)" onchange="openWeblink(this)" onmouseover="assetTooltip(this);" 
                         class="form-control fld-resp-md required" />
                       </div>
                       <div class="col-sm-1" style="margin-left: 30px;"> 
                      <a id="weblink" style="cursor:pointer">
                       		<img src=" styles/images/websiteicon.png" width="100%"/>
                       	</a>
                      </div>
                      
                      </div> 
                     </div> 
                      
                      
                      <div class="form-group">
                      <div class="row">
                      <div class="col-sm-4">
                       <label for="txtFldAsstVDServiceRemarks" class="assetLabel pull-right ">
                       Remarks</label>
                      </div>
                      <div class="col-sm-4">
                      <input type="text" id="txtFldAsstVDServiceRemarks" name="txtFldAsstVDServiceRemarks"  maxlength="300"class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
                      </div>
                      </div> 
                      </div> 
                      
                      
                      
                      </div>
                     
                      </fieldset> 
                    </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="Contacts">
                        <span class="greycolor">Contact Details</span>
                        <div class="table-responsive"> 
				<div class="btn-group pull-left" role="group">
						<span class="btn btn-default navbar-btn"  id="spnAsstVDconAdd" >
						<img src="styles/images/addrow.png" width="20px" id="btnFldAssVdconAddRow"  name="btnFldAssVdconAddRow"/>
					</span> <span class="btn btn-default navbar-btn" id="spnAsstVDconEdit">
						<img src="styles/images/editrow.png" width="20px" id="btnFldAssVdconEditRow" name="btnFldAssVdconEditRow"/>
					</span> <span class="btn btn-default navbar-btn"  id="spnAsstVDconDel">
						<img src="styles/images/delrow.png" width="20px" id="btnFldAssVdconDelRow" name="btnFldAssVdconDelRow"/>
					</span>  
					</div> 
				</div>
				
                        <div class="table-responsive fieldsetClsborder"> 
<!-- 				<div style="overflow: scroll;width: 690px;height:250px" >  -->
                        <table  id="assetVendorContTable" class="dataTable table-striped table-bordered display nowrap"  style="width:100%">
                                    <thead>
                                         <tr>
                                         <th class="assetSubHeader">Sl No</th>
                                         <th class="assetSubHeader">Select
                                         <span id="spnSelAllRow" style="display: none;">
                                         <input type="checkbox" name="chkHwbox" id="chkHwbox" onclick="selAllRows(this);" />
                                         </span>
                                         </th>
                                         <th class="assetSubHeader">Mode</th>
                                         <th class="assetSubHeaderMand">Contacts 24/7</th>
                                         <th class="assetSubHeaderMand">Key Person Name</th>
                                         <th class="assetSubHeader">Designation Name</th>
                                         <th class="assetSubHeader">Mobile </th>
                                         <th class="assetSubHeaderMand">Office Direct No</th>
                                         <th class="assetSubHeader">Remarks</th>
                                         
                                       </tr>
                                     </thead>
                                   <tbody>
                                   </tbody>
                                     <tbody>
                                     </tbody>
                                   </table>
<!--                                    </div> -->
                                   </div>
                    </div>
                </div>

           
        
    </div>
</div>
   <!-- Modal  -->
<div class="modal fade" id="Vendorfreeformdiv" style="display: none"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
              <label for="txtFldServiceVendrId" class="assetLabel pull-right ">
                       Vendor ID</label>
		
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6">  
			<input type="text" id="txtFldServiceVendrId" name="txtFldServiceVendrId" readonly="true" class="form-control fld-resp-md required" />		
          </div> 
            </div>
      </div>
		
		 
		<div class="form-group required">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldServiceVendrRep" class="assetLabel pull-right ">
                      Vendor Rep<sup style="color:red; font-size:15px;">*</sup></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6">  
	         	<input type="text" id="txtFldServiceVendrRep" name="txtFldServiceVendrRep" maxlength="150" class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>			
          </div> 
            </div>
      </div>
      
      
      <div class="form-group required">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
            <label for="txtFldAsstVDServiceName" class="assetLabel pull-right ">
                     Vendor  Name<sup style="color:red; font-size:15px;">*</sup></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
           <input type="text" id="txtFldAsstVDServiceName" name="txtFldAsstVDServiceName" maxlength="60" onBlur="validateName(this.id)" class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
              <label for="txtFldAsstVDServiceAddr1" class="assetLabel pull-right ">
                       Address1</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstVDServiceAddr1" name="txtFldAsstVDServiceAddr1"  onmouseover="assetTooltip(this);" maxlength="60" class="form-control fld-resp-md required" />
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
              <label for="txtFldAsstVDServiceAddr2" class="assetLabel pull-right ">
                       Address2</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstVDServiceAddr2" name="txtFldAsstVDServiceAddr2" 
                       onmouseover="assetTooltip(this);" maxlength="60" class="form-control fld-resp-md required" />
         
            </div> 
            </div>
      </div>
      
      
       <div class="form-group">
	    <div class="row" >
	        <div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstVDServiceAddr3" class="assetLabel pull-right">
                       Address3</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
            
            <input type="text" id="txtFldAsstVDServiceAddr3" name="txtFldAsstVDServiceAddr3" onmouseover="assetTooltip(this);"  maxlength="60" class="form-control fld-resp-md required" />
           
            </div>
      </div>
      
</div>
</div>
       
       <div class="col-md-4"> 
		 <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstVDServiceCity" class="assetLabel pull-right ">
                       City</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstVDServiceCity" name="txtFldAsstVDServiceCity"  onmouseover="assetTooltip(this);" maxlength="60" class="form-control fld-resp-md required" />
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
            <label for="txtFldAsstVDServiceCountry" class="assetLabel pull-right">
                       Country</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <s:select   label="AssetVDCountry" headerKey="" headerValue="--- Select ---" name="txtFldAsstVDServiceCountry" id="txtFldAsstVDServiceCountry" list="%{#session.VN_COUNTRY}" onmouseover="assetTooltip(this);" cssClass="form-control fld-resp-md required" theme="simple"/>
            </div> 
            </div>
      </div>
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 

               <label for="txtFldAsstVDServicePcode" class="assetLabel pull-right">
                       Pincode</label>

             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
          <input type="text" id="txtFldAsstVDServicePcode" name="txtFldAsstVDServicePcode"  onmouseover="assetTooltip(this);" maxlength="20"class="form-control fld-resp-md required" />
            </div>
      </div>
    </div>
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
            <label for="txtFldAsstVDServiceFax" class="assetLabel pull-right ">
                       Fax</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6 "> 
           <input type="text" id="txtFldAsstVDServiceFax" name="txtFldAsstVDServiceFax" maxlength="30" onmouseover="assetTooltip(this);" class="form-control fld-resp-md required" />
            </div>
      </div>
    </div>
     <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
              <label for="txtFldAsstVDServiceEmail" class="assetLabel pull-right ">
                       Email<sup style="color:red; font-size:15px;">*</sup></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstVDServiceEmail" name="txtFldAsstVDServiceEmail" maxlength="60"
                             onBlur="validateEmail(this.id)" onmouseover="assetTooltip(this);" 
                             class="form-control fld-resp-md required" />	
            </div> 
            <div class="col-sm-1" style="margin-left: 30px;"> 
                      <a href="mailto:thulasy@avallis.com?Subject=Vendor Service Email From Asset System" target="_top">
                       		<img src="images/mail.png" width="100%"/>
                       	</a>
                      </div>
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
              <label for="txtFldAsstVDServiceWebsite" class="assetLabel pull-right ">
                         Website</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstVDServiceWebsite" name="txtFldAsstVDServiceWebsite"
                         maxlength="150" onBlur="validateWebsite(this.id)" onchange="openWeblink(this)" onmouseover="assetTooltip(this);" 
                         class="form-control fld-resp-md required" />
            </div> 
            
            <div class="col-sm-1" style="margin-left: 30px;"> 
                      <a id="weblink" style="cursor:pointer">
                       		<img src=" styles/images/websiteicon.png" width="100%"/>
                       	</a>
                      </div>
            
            </div>
      </div>
    
</div>
       
       
       <div class="col-md-4"> 
     
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstVDServiceRemarks" class="assetLabel pull-right ">
                       Remarks</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstVDServiceRemarks" name="txtFldAsstVDServiceRemarks"  maxlength="300"class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
            </div> 
            </div>
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

 <input type="hidden" name="sid" id="sid" value="<%=request.getParameter("sid") %>"> 














</body>


</html>