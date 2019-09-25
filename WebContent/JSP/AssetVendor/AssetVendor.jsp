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


 


</head>

<body>

<div class="panel panel-default">
    <div class="panel-heading">
    <span class="greycolor">Asset Vendor Details</span></div>
   <div class="panel-body scrollpanelBody"> 
    <input type="hidden" name="asset" id="asset" />

  <!--  <div class="table-responsive fieldsetClsborder">   -->
   <!--  <div class="col-md-4 col-md-offset-4">     comment by poovathi -->
  
       <div class="col-md-12 fieldsetClsborder">
             <div class="row">
             <div class="col-md-4">
         <div class="form-group">
            <label for="txtFldSrchVDName conrtol-label" class="assetLabel" >Vendor Name</label>
              <input type="text" id="txtFldSrchVDName" name="txtFldSrchVDName" class="form-control required" autocomplete="off"  onmouseover="assetTooltip(this);"/>
         </div> 
         </div>
          <div class="col-md-6"></div>
          
          <div class="col-md-2">
                 
				        <div class="btn-group pull-left role="group" style="padding-left:50px;">
						
					       <span class="btn btn-default navbar-btn"  id="spnAsstVdDel">
						         <img src="styles/images/addrow.png" width="20px" title="Insert Vendor Details" id="btnFldAssVdAddDtls" name="btnFldAssVdAddDtls"/>
					       </span>
					    
					    </div>
					
          
          </div>
          
      </div>  
   </div> 
   <!-- </div> -->
    
        <div class="col-md-12 fieldsetClsBorder" style="padding-top:15px;">

	 	<s:if test="hasActionMessages()">
					<div id="successmsgdiv" class="alert alert-success alert-dismissible fade in" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button> 
    							  <s:actionmessage/> 
					</div>
		 </s:if>
		 
		    
           
		 
		 
		 
		  <div class="tab" role="tabpanel" id="vendornavdiv">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"  id="li_vd_Search"><a href="#Search" aria-controls="home" role="tab" data-toggle="tab">Search Result</a></li>
                    <li role="presentation"  id="li_vd_Vendor"><a href="#Vendor" aria-controls="profile" role="tab" data-toggle="tab">Vendor Details</a></li>
                    <li role="presentation"  id="li_vd_Contact"><a href="#Contacts" aria-controls="messages" role="tab" data-toggle="tab">Contact Details</a></li>
                </ul>
             
                
                <!-- Tab panes -->
                <div class="tab-content" style="height:540px;">
                 <div role="tabpanel" class="tab-pane fade in active" id="Search">
                        <%-- <span class="greycolor">Search Result</span>  --%>
                        <div class="table-responsive" style="padding-top:25px;"> 
<!--                         <div style="overflow: scroll;width: 690px;height:250px" >  -->
                        <table id="assetVendorNamTable" class="dataTable table-striped table-bordered display nowrap"  style="width:100%">
                       
                                       <thead>
                                         <tr>
                                         <th class="assetSubHeader">Sl No</th>
                                         <th class="assetSubHeader"  style="display:none;">Select
                                           <span id="spnSelAllRow" style="display:none;">
                                         <input type="checkbox" name="chkVdbox" id="chkVdbox" onclick="selAllRows(this);" />
                                         </span>
                                         </th>
                                         <th class="assetSubHeader" style="display:none;">Mode</th>
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
                                   </table>

                                 </div>  
                    </div>
                   
                    
                    
                     
                    <div role="tabpanel" class="tab-pane fade" id="Vendor">
              
                    
                    <!-- <div class="table-responsive" style="height:16vh;"> -->
				       
					    
					<!-- </div> VndrOutlineBorder-->
					
					<div class="col-md-12 ">
                     <div class="row">
                     <div class="col-md-6">
                     <fieldset class=" fieldset col-md-6">  
                      <legend><i class="fa fa-users" style="color:#067af1;" aria-hidden="true"></i>&nbsp;Vendor Details</legend>
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
                      <div class="col-sm-3">
                       <label for="txtFldServiceVendrRep control-label" class="assetLabel pull-right ">
                      Vendor Rep<sup style="color:red; font-size:15px;">*</sup></label>
                      </div>
                      <div class="col-sm-2">
                      <input type="text" id="txtFldServiceVendrRep" name="txtFldServiceVendrRep" maxlength="150" class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
                      </div>
                      </div> 
				  </div>
				  
				  
				  <div class="form-group">
                      <div class="row">
                      <div class="col-sm-3">
                       <label for="txtFldAsstVDServiceName control-label" class="assetLabel pull-right ">
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
                      
                      
              <!--   <div class="col-md-4" style="margin-top:25px;">
                      
                        <div class="form-group">
                             <div class="row">
                                   <div class="col-sm-4">
                                      <label for="txtFldAsstVDServiceRemarks" class="assetLabel pull-right ">
                                                     Remarks</label>
                                    </div>
                                    
                                         <div class="col-sm-4">
                                           <input type="text" id="txtFldAsstVDServiceRemarks" name="txtFldAsstVDServiceRemarks"  maxlength="300"class="form-control fld-resp-md required" onmouseover="assetTooltip(this);"/>
                                         </div>
                                         
                                         
                                         <div class="col-md-8"> 
                                     <textarea  class="form-control" rows="4" name="txtFldAsstVDServiceRemarks" id="txtFldAsstVDServiceRemarks" cols="35" style="resize:none" onmouseover="assetTooltip(this);"  maxLength="4000" ></textarea>
                                      </div>
                              </div> 
                       </div> 
                      
                 </div> -->
                      
                      
                       <div class="col-md-2" style="margin-top:30px; float:right; margin-right:-78px;">
                       
                              <div class="btn-group role="group">
								 <span class="btn btn-default navbar-btn"  id="spnAsstVdDel">
						            <img src="styles/images/delrow.png" width="20px" title="Delete Vendor Details" id="btnFldAssVdDelRow" name="btnFldAssVdDelRow"/>
					           </span>
					    
					        </div>
                      </div>
                      
                 </div><!--col-md-6 end  -->
         </div> <!--col-md-12 end  -->
                      
                      
                      <div class="col-md-12 ">
                      
                      <div class="row">
                      <div class="col-md-6">
                      <fieldset class="vndrAddrfieldset col-md-6"> 
                      <legend> <i class="fa fa-map-marker" style="color:#ff0000;" aria-hidden="true"></i>&nbsp; Address Details </legend>
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
				  </div>
                       
                      <div class="col-md-6">
                      
                      <fieldset class="VndrContfieldset col-md-6"> 
                      <legend><i class="fa fa-phone-square" style="color:#10af15;" aria-hidden="true"></i>&nbsp; Contact Details </legend>
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
                      <div class="col-sm-1" style="margin-left: 75px; width:25px; height:25px;padding-top:2px;padding-top:2px;border:1px solid #b5b3b3;padding:5px;border-radius:5px;"> 
                      <a href="mailto:thulasy@avallis.com?Subject=Vendor Service Email From Asset System" target="_top">
                       		<img src="images/mail.png" width="100%" style="margin-bottom:5px;"/>
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
                       <div class="col-sm-1"  style="margin-left: 75px; width:25px; height:25px;padding-top:2px;padding-top:2px;border:1px solid #b5b3b3;padding:5px;border-radius:5px;"> 
                      <a id="weblink" style="cursor:pointer">
                       		<img src=" styles/images/websiteicon.png" width="100%" style="margin-bottom:5px;"/>
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
                          <div class="col-md-6"> 
                                     <textarea  class="form-control" rows="4" name="txtFldAsstVDServiceRemarks" id="txtFldAsstVDServiceRemarks" cols="35" style="resize:none" onmouseover="assetTooltip(this);"  maxLength="4000" ></textarea>
                                      </div>
                      </div> 
                      </div>  
                      
                      
                      
                      </div>
                     
                      </fieldset> 
                    </div>
                    </div>
                    </div>
                   
                    
                </div>

<div role="tabpanel" class="tab-pane fade" id="Contacts">
                      <%--   <span  class="greycolor" style="padding-top:10px;">Contact Details</span> --%>
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
				
                        <div class="table-responsive"> 
<!-- 				<div style="overflow: scroll;width: 690px;height:250px" >  -->
                        <table  id="assetVendorContTable" class="dataTable table-striped table-bordered display nowrap"  style="width:100%">
                                    <thead>
                                         <tr>
                                         <th class="assetSubHeader">Sl No</th>
                                         
                                         
                                        
                                         
                                          <th class="assetSubHeader">Select
                                         <span id="spnSelAllRow" style="display: none;">
                                        <!--   -->
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

                                   </div>
                    </div>

   
        
 </div>
</div>
	 
	</div> 
     
  </div>  
 
 </div>
 
 <input type="hidden" name="sid" id="sid" value="<%=request.getParameter("sid") %>"> 
</body>
<script>
 VN_COUNTRY_VAR = "<%= session.getAttribute("VN_COUNTRY") %>";
 baseUrl = "<%= request.getContextPath() %>";
 avadsid = "<%= session.getAttribute("fpssoid") %>";
	
  $(function() {
    loadVeninit();
  });
 </script>
  
  
</html>