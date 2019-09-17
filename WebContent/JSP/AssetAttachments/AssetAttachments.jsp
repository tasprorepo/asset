<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="scripts/AssetAttachments.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles/popup.css" type="text/css">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<%--   <script src="https://code.jquery.com/jquery-1.12.4.js"></script> --%>
<%--   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> --%>
<title>Insert title here</title>
<script>
ATTACHMNT_CATGRY_VAR="<%= session.getAttribute("ATTACHMNT_CATGRY")%>";



window.onload =  function()
{
	loadinit(); 
}
$( function() {
//  $( "#txtFldAsstHDFrmPurchaseDate" ).datepicker();
  $('#txtFldAttachmntDate').datepicker({dateFormat: 'dd/mm/yy'});
} );
</script>

<script type="text/javascript">

	$(function()
			{
		
		$("#btnFldAssAtchAddRow").click(function(){
			addRow();
		});
		
		$("#btnFldAssAtchEditRow").click(function(){
		//	editRow();
		});
		
		$("#btnFldAssAtchDelRow").click(function(){
			deleteRow();
		});
	});
	
	function cleaRecftn() {
		clearRecords('AttachmentTable');
		}
</script>
</head>
<body >
 <div class="panel panel-default">
    <div class="panel-heading">
    <span class="greycolor" >Asset Attachments Details</span></div>
   <div class="panel-body "> 
    <input type="hidden" name="asset" id="asset" />
<%--     <span class="greencolor">Search Criteria</span>  --%>
   <div class="table-responsive fieldsetClsborder"> 
   <div class="col-md-12">
   <div class="row">
   <div class="col-md-4">
  <div class="form-group">
    <label for="txtFldAttachmntDate" class="assetLabel">Date</label>
    <input type="text" id="txtFldAttachmntDate" name="txtFldAttachmntDate" class="form-control fld-resp-md required" onblur="validateDate(this);" onmouseover="assetTooltip(this);"/>	
  </div>
  </div>
    <div class="col-md-4">
  <div class="form-group">
    <label for="txtFldAttachmntCatgry" class="assetLabel">Attachment category </label>
   <s:select label="AttachmntCatgry" headerKey="" headerValue="--- Select ---" name="txtFldAttachmntCatgry" id="txtFldAttachmntCatgry" list="%{#session.ATTACHMNT_CATGRY}" cssClass="form-control fld-resp-md required" theme="simple" onchange="cleaRecftn()" onmouseover="assetTooltip(this);"/>				
  </div>
  </div>
    <div class="col-md-4">
  <div class="form-group">
   <label for="txtFldDocType" class="assetLabel"> Document Title </label>
     <input type="text" id="txtFldDocType" name="txtFldDocType" class="form-control fld-resp-md required"  onmouseover="assetTooltip(this);"/>	
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
						<span class="btn btn-default navbar-btn"  id="spnAsstAtchAdd" >
						<img src="styles/images/addrow.png" width="20px" title="Add Row"  id="btnFldAssAtchAddRow"  name="btnFldAssAtchAddRow"/>
					</span> 
<%-- 					<span class="btn btn-default navbar-btn" id="spnAsstAtchEdit"> --%>
<!-- 						<img src="styles/images/editrow.png" width="20px" title="Edit Row" id="btnFldAssAtchEditRow" name="btnFldAssAtchEditRow"/> -->
<%-- 					</span> --%>
					 <span class="btn btn-default navbar-btn"  id="spnAsstAtchDel">
						<img src="styles/images/delrow.png" width="20px" title="Delete Row" id="btnFldAssAtchDelRow" name="btnFldAssAtchDelRow"/>
					</span> 
<%-- 					<span class="btn btn-default navbar-btn"  id="spnAsstAtchExpand"> --%>
<!-- 						<img src="styles/images/expandrow.png" width="20px" title="Expand Row"  id="btnFldAssAtchExpRow" name="btnFldAssAtchExpRow" onclick="showATFreeForm()"/> -->
<%-- 					</span> --%>
					</div>
					
					<div class="btn-group pull-right" role="group" style="">
					<span class="btn btn-default navbar-btn"  title="Expand or Collapse Documents Preview."  id="btnExpColDiv">
						<img src="styles/images/exp-col.png" width="20px"/>
					</span>	
					</div>	
					
					
				</div>


<div class="form-group" style="color:maroon;display:none" id="noofrecdiv">
	<div class="row" >
	<div class="col-md-2 col-sm-2 col-xs-2 "> 
             <label for="noofattached" class="control-label ">
              <font color="maroon">No.of Records:</font></label>
             </div> 
           <div class="col-md-1 col-sm-1 col-xs-1"> 
         <input type="text" class="form-control" name="noofattached" id="noofattached" disabled="true">
           </div> 
            </div>
      </div> 			
<div class="row">	
	<div class="col-md-12" style="height:41vh;" id="attchSplitDivTbl">					
		<div class="table-responsive fieldsetClsborder"> 
<!-- 		<div style="overflow: scroll;width: 1020px;height:250px" >    -->



		<table id="AttachmentTable" class="dataTable table-striped table-bordered display nowrap"  style="width:100%">
                                     <thead>
                                       <tr>
                                      <!--     class="assetSubHeader" --><th>Sl No</th>
                                       <!-- class="assetSubHeader" -->  <th >Select</th>
<%--                                           <span id="spnSelAllRow" style="display: none;"> --%>
<!--                                             <input type="checkbox" name="chkSwbox" id="chkSwbox" onclick="selAllRows(this);" /> -->
<%--                                           </span> --%>
<!--                                           class="assetSubHeader" -->
                                         <th>Mode</th>
<!--                                           class="assetSubHeaderMand" -->
                                         <th style="color:maroon">Attachment Category</th>
<!--                                          <th class="assetSubHeaderMand">Document Type</th> -->
                                         <th style="color:maroon">Document Title</th>
                                         <th>Remarks</th>
                                         <th  style="color:maroon"><div style="width:150px">Document</div></th>
                                         <th>Attached Date</th>
                                         <th>File Type</th>
<!--                                          <th class="assetSubHeader">Created By</th> -->
<!--                                          <th class="assetSubHeader">Created Date</th> -->
<!--                                          <th class="assetSubHeader">Modified By</th> -->
<!--                                          <th class="assetSubHeader">Modified Date</th> -->
                                       </tr>
                                     </thead>
                                     <tbody>
                                     </tbody>
                                   </table>	 
<!--                                    </div> -->
                                   
		</div>
	 
	  </div>
	  
	  <div class="col-md-5 fieldsetClsborder hidden" id="attchSplitDivView" style="height:39vh;">	
<!--  start -->
	  
        	<div id="pdf-main-container">
<!--     <div id="pdf-loader">Loading document ...</div> -->
    <div id="pdf-contents">
        <div id="pdf-meta">
            <div class="row">
            <div class="col-md-2 text-center" style="padding-right: 0;">
            <div id="pdf-buttons" class="btn-group" role="group" >
                <button id="pdf-prev" class="btn btn-primary btn-xs" type="button"><span class="glyphicon glyphicon-circle-arrow-left" aria-hidden="true"></span></button>
                <button id="pdf-next" class="btn btn-primary btn-xs" type="button"><span class="glyphicon glyphicon-circle-arrow-right" aria-hidden="true"></span></button>
            </div>
            </div>
            <div class="col-md-3" style="padding-left:0;">
            <div id="page-count-container" style="display: inline;font-weight:bold;font-size:7pt; transform: scale(.5, 1);">Page <div id="pdf-current-page" style="display: inline;"></div> of <div id="pdf-total-pages" style="display: inline;"></div></div>
            </div>
            
            <div class="col-md-4">
            	 <div class="form-group">
    				<div class="input-group">
      				<input type="text" class="form-control" id="txtFldPdfSrchNo" placeholder="Page No">
      				<div class="input-group-addon btn btn-default" style="height:26px !important;padding:3px 12px;" id="pdfBtnSrch"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></div>
    				</div>
  				</div>
            </div>
            
            <div class="col-md-3">
            <div class="btn-group" role="group" >
            	<button id="zoomOut" class="btn btn-primary btn-xs" type="button" onclick=""><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
				 <button id="zoomIn" class="btn btn-primary btn-xs" type="button" onclick=""><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
			</div>
		<select style="display:none" id="scaleSelect">
			<option value="0.5" selected="selected">50%</option>
			<option value="0.75">75%</option>
			<option value="1">100%</option>
			<option value="1.25">125%</option>
			<option value="1.50">150%</option>
			<!-- <option value="3">300%</option>
			<option value="4">400%</option> -->
		</select>
            </div>
            
            </div>
        </div>
        <div class="row">
        <div class="col-md-12" style="max-height: 30.5vh !important;max-width:58vh !important;" id="railScroll" data-simplebar>
        <canvas id="pdf-canvas" width="1000px" height="512px"></canvas>
        </div>
        </div>
<!--         <div id="page-loader">Loading page ...</div> -->
    </div>
</div> <!-- end -->
      </div>
	  
	  
	 </div>
	
<!-- 	 start -->
	</div> 
     
  </div>  
  
  
  
  
  
   <!-- Modal  -->
<div class="modal fade" id="attachfreeformdiv" style="display: none"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog scrollModelBodyWidth1000" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span data-dismiss="modal" aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
     <fieldset class="fieldsetClsborder scrollModelBody60">
     
		<div class="col-md-6"> 
		<div class="form-group required">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstATFrmCatgry" class="control-label pull-right ">
			<font color="maroon">Attachment Category</font></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6">   	
       <input type="text" id="txtFldAsstATFrmCatgry"  name="txtFldAsstATFrmCatgry"  maxlength="150" class="form-control" onmouseover="assetTooltip(this);" readonly/>
          </div> 
            </div>
      </div>
      
      
<!--       <div class="form-group required"> -->
<!-- 	<div class="row" > -->
<!-- 	<div class="col-md-6 col-sm-6 col-xs-6 ">  -->
<!--              <label for="txtFldAsstATFrmDocumentType" class="control-label pull-right "> -->
<!--               <font color="maroon">Document Type</font></label> -->
<!--              </div>  -->
<!--            <div class="col-md-6 col-sm-6 col-xs-6">  -->
<!--         <input type="text" id="txtFldAsstATFrmDocumentType" name="txtFldAsstATFrmDocumentType" maxlength="150" onmouseover="assetTooltip(this);" class="form-control" readonly/> -->
<!--             </div>  -->
<!--             </div> -->
<!--       </div> -->
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstATFrmDocumentTitle" class="control-label pull-right ">
              <font color="maroon">Document Title</font></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstATFrmDocumentTitle" name="txtFldAsstATFrmDocumentTitle" maxlength="150" onmouseover="assetTooltip(this);" class="form-control" readonly/>
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label for="txtFldAsstATFrmRemarks" class="control-label pull-right ">
             Remarks</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
         <input type="text" id="txtFldAsstATFrmRemarks" name="txtFldAsstATFrmRemarks" maxlength="150"  onmouseover="assetTooltip(this);" class="form-control" readonly/>
            </div> 
            </div>
      </div>
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstATFrmDoc">
             <font color="maroon">Document</font></label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6" id="attachFile"> 
            
            </div> 
            </div>
      </div>
      
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstATFrmAttchDate">
              Attached Date	</label>
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
        <input type="text" id="txtFldAsstATFrmAttchDate" name="txtFldAsstATFrmAttchDate" onblur="validateDate(this);" onmouseover="assetTooltip(this);" class="form-control" readonly/>                                  
            </div> 
            </div>
      </div>
      
      <div class="form-group">
	<div class="row" >
	<div class="col-md-6 col-sm-6 col-xs-6 "> 
             <label class="control-label pull-right " for="txtFldAsstATFrmFileType">
				 File Type</label> 
             </div> 
           <div class="col-md-6 col-sm-6 col-xs-6"> 
          <input type="text" id="txtFldAsstATFrmFileType" name="txtFldAsstATFrmFileType" maxlength="150" onmouseover="assetTooltip(this);" class="form-control" readonly/> 
            </div>
      </div>
      </div>
      
       </div>
       <div class="col-md-6"> 
       
        
      
<!--       <div class="form-group"> -->
<!-- 	<div class="row" > -->
<!-- 	<div class="col-md-6 col-sm-6 col-xs-6 ">  -->
<!--              <label class="control-label pull-right " for="txtFldAsstATFrmCreatedby"> -->
<!--              Created By</label> -->
<!--              </div>  -->
<!--            <div class="col-md-6 col-sm-6 col-xs-6">  -->
<!--          <input type="text" id="txtFldAsstATFrmCreatedby" name="txtFldAsstATFrmCreatedby" maxlength="150" onmouseover="assetTooltip(this);" class="form-control" readonly/> -->
<!--             </div>  -->
<!--             </div> -->
<!--       </div> -->
      
<!--       <div class="form-group"> -->
<!-- 	<div class="row" > -->
<!-- 	<div class="col-md-6 col-sm-6 col-xs-6 ">  -->
<!--              <label class="control-label pull-right " for="txtFldAsstATFrmCrtdDate"> -->
<!--              Created Date</label> -->
<!--              </div>  -->
<!--            <div class="col-md-6 col-sm-6 col-xs-6">  -->
<!--          <input type="text" id="txtFldAsstATFrmCrtdDate" name="txtFldAsstATFrmCrtdDate" onblur="validateDate(this);" onmouseover="assetTooltip(this);" class="form-control" readonly/>                                   -->
<!--             </div>  -->
<!--             </div> -->
<!--       </div> -->
      
      
<!--        <div class="form-group"> -->
<!-- 	<div class="row" > -->
<!-- 	<div class="col-md-6 col-sm-6 col-xs-6 ">  -->
<!--              <label class="control-label pull-right " for="txtFldAsstATFrmMdyby"> -->
<!--              Modified By</label> -->
<!--              </div>  -->
<!--            <div class="col-md-6 col-sm-6 col-xs-6">  -->
<!--          <input type="text" id="txtFldAsstATFrmMdyby" name="txtFldAsstATFrmMdyby" maxlength="150" onmouseover="assetTooltip(this);" class="form-control" readonly/> -->
<!--             </div>  -->
<!--             </div> -->
<!--       </div> -->
      
      
<!--       <div class="form-group"> -->
<!-- 	<div class="row" > -->
<!-- 	<div class="col-md-6 col-sm-6 col-xs-6 ">  -->
<!--             <label class="control-label pull-right " for="txtFldAsstATFrmMdyDate"> -->
<!-- 					 Modified Date</label> -->
<!--              </div>  -->
<!--            <div class="col-md-6 col-sm-6 col-xs-6">  -->
<!--          <input type="text" id="txtFldAsstATFrmMdyDate" name="txtFldAsstATFrmMdyDate" onblur="validateDate(this);" onmouseover="assetTooltip(this);" class="form-control" readonly/>                                   -->
<!--             </div>  -->
<!--             </div> -->
<!--       </div>  -->
      
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
</html>
