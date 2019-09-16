/**
 * This script file is used to add Asset Hardware related functions in it
 */

// **************************************
//              CONSTANTS
//***************************************

var selRowArr = [];
var  attach_categ_arr=[];
var ATTACHMNT_CATGRY_VAR;
var attachmentTbl="";

var __PDF_DOC,
__CURRENT_PAGE,
__TOTAL_PAGES=0,
__PAGE_RENDERING_IN_PROGRESS = 0,
__CANVAS,
__CANVAS_CTX;



// TOOL BAR FUNCTIONS
function toolBarSrchFun()
{ 
	 $("#noofrecdiv").css("display","none");
	$("#noofrecdiv").find("input#noofattached").val("");
		
	searchRecords();
}//end of toolBarSrchFun

function toolBarSaveFun()
{
	assetCUDOpern();
	
}//end of toolBarSaveFun

function loadinit()
{
	$('#successmsgdiv').delay(2000).fadeOut('blind');
	$("#side-menu").find("li a").removeClass("active")
	$("#liassetattachment").find("a").addClass("active");
	var attach_Catg_Type= ATTACHMNT_CATGRY_VAR.substr(1,ATTACHMNT_CATGRY_VAR.length-2);
	var attach_Catg_Split = attach_Catg_Type.split(",");
	
	 for(var hw_Catg_Loop=0;hw_Catg_Loop<attach_Catg_Split.length;hw_Catg_Loop++)
	 {
		 attach_categ_arr.push(trim(attach_Catg_Split[hw_Catg_Loop]))
   	 }//end of for 
 
		 attachmentTbl = $('#AttachmentTable').DataTable( {
		    destroy: true,
		     responsive: false,
		    ordering: false,
		    searching: false,
		    scrollY:  "30vh",
		    scrollX: true,
		    scroller: false,
		    scrollCollapse:false,
		    paging:false,
		    filter:false,
		    columnDefs: [],
		    dom: '<<"top" ip>flt>',
		    oLanguage: {"sEmptyTable": 'No Records',"sInfoEmpty": 'No Records' },
		  columnDefs: [  { width: '50px', targets: [0,1,2]}, 
		                   {"className": "dt-head-center text-center",targets: [0,1,2,3,4,5,6,7],"orderable": false,"searchable": false}],        
		       		    fnDrawCallback: function(oSettings) {
		       		        if (oSettings._iDisplayLength > oSettings.fnRecordsDisplay()) {
		       		            $(oSettings.nTableWrapper).find('.dataTables_paginate').hide(); 
		       		        } 
		       		        ctrlOverFlowDataTable('AttachmentTable'); 
		       		    }
		}).draw();
	 	showTooltip('btnFldAssAtchAddRow','Add Row');
		showTooltip('btnFldAssAtchEditRow','Edit Row');
		showTooltip('btnFldAssAtchDelRow','Delete Row');
		showTooltip('btnFldAssAtchExpRow','Expand Row'); 
		hideLoader();
		
		
		$(function(){
			 __CANVAS = document.getElementById('pdf-canvas');
			 __CANVAS_CTX = __CANVAS.getContext('2d');
			
			
			$("#testBase64").on("click",function(){
				
			});
			
			
		$("#zoomIn").on("click",function(){
			if(__TOTAL_PAGES==0){alert("Load document");return;}
			zoomIn();
		});	
		
		$("#zoomOut").on("click",function(){
			if(__TOTAL_PAGES==0){alert("Load document");return;}
			zoomOut();
		});	
		
		 $("#pdf-prev").off("click").on('click', function(event) {
       	 event.stopPropagation();
       	$("#scaleSelect").val("0.5") 
       	if(__TOTAL_PAGES==0){alert("Load document");return;}
       	
           if(__CURRENT_PAGE != 1)
               showPage(--__CURRENT_PAGE);
       });

       // Next page of the PDF
       $("#pdf-next").off("click").on('click', function(event) {
       	 event.stopPropagation();
       	 $("#scaleSelect").val("0.5");
       	 if(__TOTAL_PAGES==0){alert("Load document");return;}
       	 
           if(__CURRENT_PAGE != __TOTAL_PAGES)
               showPage(++__CURRENT_PAGE);
       });
		
		$("#pdfBtnSrch").on("click",function(){
			 $("#scaleSelect").val("0.5")
			 if(__TOTAL_PAGES==0){alert("Load document");return;}
			 
			 var strPageNo=$("#txtFldPdfSrchNo").val();
			 
			 if(isEmpty(strPageNo) || Number(strPageNo)==0){alert("Key in Page No.");$("#txtFldPdfSrchNo").focus();return}
			 
	         if(strPageNo>__TOTAL_PAGES){alert("Enter available Page No. from 1 to "+__TOTAL_PAGES);$("#txtFldPdfSrchNo").focus();}
	         else {__CURRENT_PAGE=Number(strPageNo);
	         showPage(__CURRENT_PAGE);
	         }
		});
		
		$("#btnExpColDiv").click(function(){
			console.log("Waiting............")
			if($("#attchSplitDivTbl").hasClass("col-md-12")){
				$("#attchSplitDivTbl").removeClass("col-md-12");
				$("#attchSplitDivTbl").addClass("col-md-7");
				$("#attchSplitDivView").removeClass("hidden");
			}else{
				$("#attchSplitDivView").addClass("hidden");
				$("#attchSplitDivTbl").removeClass("col-md-7");
				$("#attchSplitDivTbl").addClass("col-md-12");
			}
			
		});
		 $("#noofrecdiv").css("display","none");
			$("#noofrecdiv").find("input#noofattached").val("");
			
		/*$('body').on('click', function (e) {
			console.log(event.target.tagName.toLowerCase());
			if(event.target.tagName.toLowerCase()=="img")return;
			
//			 if(e.target == e.currentTarget) {
				 	$('[data-toggle=popover]').each(function () {
		        // hide any open popovers when the anywhere else in the body is clicked
				 		if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
				 			$(this).popover('hide');
				 		}
				 	});
//			 }	
		 });*/
		
	});
}

function deselect(e) {
	  $('.pop').slideFadeToggle(function() {
	    e.removeClass('selected');
	  });    
	}

	$(function() {
	  $('#contact').on('click', function() {
	    if($(this).hasClass('selected')) {
	      deselect($(this)); 
	     formFunctionEdit();
	    } else {
	      $(this).addClass('selected');
	      $('.pop').slideFadeToggle();
	     // showAlert("Select on show");
	      formFunction();
	    }
	    return false;
	  });

	  $('.close').on('click', function() {
	    deselect($('#contact'));
	    return false;
	  });
	});

	$.fn.slideFadeToggle = function(easing, callback) {
	  return this.animate({ opacity: 'toggle', height: 'toggle' }, 'fast', easing, callback);
	};

	

	function myFunction( id) {
		
		//	MastervendorId=id.value;
	var td=id.parentNode;//td
	var tr=td.parentNode//tr
	var HardwareName= tr.cells[3].childNodes[0].value;
	//showAlert("HardwareName--->"+HardwareName);
	

	}// end of myFunction()



	function myFunction() {
	    var x = document.getElementById("txtFldAsstAttachDocuments");
	    x.disabled = true;
	}
	
function attachmentCatg()
   {
	
	var name =$("#txtFldAsstAttachmntCatgry").val() ;
	
	if(isEmptyFld(name)){
		showAlert("Attachment Category can't be Empty",$("#txtFldAsstAttachmntCatgry"))
	   return false;  
	}
 }


function docType(){
	var name =$("#txtFldAsstDocumntType").val() ;
	
	if(isEmptyFld(name)){
		showAlert("Document Type can't be Empty",$("#txtFldAsstDocumntType"))
	   return false;  
	}
}


function docTitle(){
	var name =$("#txtFldAsstAttachDocTitle").val() ;
	
	if(isEmptyFld(name)){
		showAlert("Document Title can't be Empty",$("#txtFldAsstAttachDocTitle"))
	   return false;  
	}
}

function attachmentload(){
	
var name =$("#upload").val() ;
	
	if(isEmptyFld(name)){
		showAlert("Please Upload a file",$("#upload"))
	   return false;  
	}
}

		
function addRow(){
	
	 removeInfoError('AttachmentTable');
	 $("#noofrecdiv").css("display","none");
	 $("#noofrecdiv").find("input#noofattached").val("");
		
	 
	$("#AttachmentTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
    });
	var tbl = document.getElementById('AttachmentTable'),tblBody = tbl.tBodies[0],
	    len = tblBody.rows.length;
	
	if(len>0){
		
		var table = document.getElementById('AttachmentTable');
		var tbody = table.tBodies[0];
		var rowCount = tbody.rows.length;
		 
		
		for(var del=0;del<rowCount;del++){
			var row = tbody.rows[del];
			//var chkbox = row.cells[1].childNodes[0];
			var	mode = row.cells[2].childNodes[0].value;
			if(mode == 'I') {
				if(!chkMandatoryFields(tblBody.rows[len-1].cells[3].childNodes[0], CONSTANTS_VAR.KEYIN_ATTCK_CATG))return;
				//if(!chkMandatoryFields(tblBody.rows[len-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_DOCTYPE))return;
				if(!chkMandatoryFields(tblBody.rows[len-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_DOCTITLE))return;
				if(!chkMandatoryFields(tblBody.rows[len-1].cells[6].childNodes[0], CONSTANTS_VAR.KEYIN_DOCUPLOAD))return; 
			}
		}
		
		
		
		
		 
	}//end of if
	 
	
	var row = tblBody.insertRow(len);
	
	var cell0 = row.insertCell(0);
	cell0.innerHTML = '<input type="text" name="txtFldAsstAttachmntSlno"  maxlength="30"  id="txtFldAsstAttachmntSlno" readonly="true" value="'+(len+1)+'" class="writableFieldDHTML" />';
	cell0.childNodes[0].style.textAlign = 'center'; 
	
	var cell1 = row.insertCell(1);
	cell1.innerHTML = '<input type="checkbox" name="radAsstAssetAttachmntSelect" id="radAsstAssetAttachmntSelect" onclick="selectRowFun(this)" />'+'<input type="hidden" id="hSelRow" name="hSelRow" value="'+len+'">';
	cell1.childNodes[0].style.textAlign = 'center';
	
	var cell2 = row.insertCell(2);
	cell2.innerHTML = '<input type="text" name="txtFldAsstAttachmentMode" id="txtFldAsstAttachmentMode"   readonly="true" value="'+CONSTANTS_VAR.INSERT_MODE+'" class="writableFieldDHTML" />';
	cell2.childNodes[0].style.textAlign = 'center';
	 
	var cell3 = row.insertCell(3);
	cell3.innerHTML ='<select name="txtFldAsstAttachmntCatgry" id="txtFldAsstAttachmntCatgry" class="form-control"  maxlength="150"  onmouseover="assetTooltip(this);"  > </select>'+'<input type="hidden" name="txtFldAsstAttachmntId" id="txtFldAsstAttachmntId"  />';
	var cnt=0;
	cell3.childNodes[0].options[cnt]=  new Option("--select--","");
	for(var st=0;st<attach_categ_arr.length;st++)
	{ 
		cnt=cell3.childNodes[0].options.length;
		cell3.childNodes[0].options[cnt++]=  new Option(attach_categ_arr[st],attach_categ_arr[st]);
	}//end of for 
	 
	var cell4= row.insertCell(4);
	cell4.innerHTML = '<input type="text" name="txtFldAsstAttachDocTitle"  class="form-control" id="txtFldAsstAttachDocTitle"  value="" maxlength="60" onmouseover="assetTooltip(this);" />'+
	'<input type="hidden" name="txtFldAsstDocumntType" id="txtFldAsstDocumntType" value=""    onmouseover="assetTooltip(this);"/>';
	
	var cell5 = row.insertCell(5);
	cell5.innerHTML = '<input type="text" name="txtFldAsstAttachmentRemarks" class="form-control" id="txtFldAsstAttachmentRemarks" value="" maxlength="500"   onmouseover="assetTooltip(this);" />';
	
	var cell6 = row.insertCell(6);
	cell6.innerHTML = '<input type="file" name="upload" id="upload"  class="form-control" />';

	/*var cell6 = atchmtRow.insertCell(6);
	cell6.innerHTML = "<input type='file' class='fpFileBrowseBtn' name='upload' style='width:100%;'>"+
						"<input type='hidden' name='txtFldAdvAttachfilename'  value=''>";*/
	var cell7 = row.insertCell(7);
	cell7.innerHTML = '<input type="text" name="txtFldAsstAttachmntDate" id="txtFldAsstAttachmntDate" value="" onblur="validateDate(this);"   class="form-control" readonly="true" onmouseover="assetTooltip(this);" />';
	
	var cell8 = row.insertCell(8);
	cell8.innerHTML = '<input type="text" name="txtFldAsstAttachmntFileType" id="txtFldAsstAttachmntFileType" value="" maxlength="60" class="form-control" readonly="true"  onmouseover="assetTooltip(this);" />'+
	'<input type="hidden" name="txtFldAsstAttachmntCrtdBy" id="txtFldAsstAttachmntCrtdBy" value="" maxlength="30"  onmouseover="assetTooltip(this);" />'+
	'<input type="hidden" name="txtFldAsstAttachmntCrtdDate" id="txtFldAsstAttachmntCrtdDate" value="" onblur="validateDate(this);" maxlength="60"  onmouseover="assetTooltip(this);" />'+
	'<input type="hidden" name="txtFldAsstAttachmntModifdBy" id="txtFldAsstAttachmntModifdBy" value="" maxlength="30" onmouseover="assetTooltip(this);" />'+
	'<input type="hidden" name="txtFldAsstAttachmntModfdDate" id="txtFldAsstAttachmntModfdDate" value="" onblur="validateDate(this);" maxlength="60"  onmouseover="assetTooltip(this);" />';
//	var cell10= row.insertCell(10);
//	cell10.innerHTML = '<input type="text" name="txtFldAsstAttachmntCrtdBy" id="txtFldAsstAttachmntCrtdBy" value="" maxlength="60" class="writableFieldDHTML" onmouseover="assetTooltip(this);" />';
//	
//	var cell11= row.insertCell(11);
//	cell11.innerHTML = '<input type="text" name="txtFldAsstAttachmntCrtdDate" id="txtFldAsstAttachmntCrtdDate" value="" onblur="validateDate(this);" maxlength="60" class="writableFieldDHTML" onmouseover="assetTooltip(this);" />';
//	
//	var cell12= row.insertCell(12);
//	cell12.innerHTML = '<input type="text" name="txtFldAsstAttachmntModifdBy" id="txtFldAsstAttachmntModifdBy" value="" maxlength="60" class="writableFieldDHTML" onmouseover="assetTooltip(this);" />';
//	
//	var cell13= row.insertCell(13);
//	cell13.innerHTML = '<input type="text" name="txtFldAsstAttachmntModfdDate" id="txtFldAsstAttachmntModfdDate" value="" onblur="validateDate(this);" maxlength="60" class="writableFieldDHTML" onmouseover="assetTooltip(this);" />';
	
		cell3.childNodes[0].focus();
}//end of add row


function deleteRow()
{
	attachtableDeleteRow("AttachmentTable",false);  
 
	
}//end of deleteRow
function attachtableDeleteRow(tableId,autodelete){
	
	var table = document.getElementById(tableId);
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;
	 
	
	var deleteFlag = 0;
	
	if(rowCount<1){
		showAlert("No rows to delete!");
		return;
	}
	
	if(rowCount>=1){
		 
		
		if(!autodelete){
			
			for(var del=0;del<rowCount;del++){
				var row = tbody.rows[del];
				var chkbox = row.cells[1].childNodes[0];
				
				if(null != chkbox && true == chkbox.checked) {
				        deleteFlag = 1;
				}
			}// End of for(del)
			if(!deleteFlag){
				showAlert("Select a row to delete!");
				return;
			}	
			
		}
		
			

		// to delete the rows checked
		for(var del=0;del<rowCount;del++){
			var row = tbody.rows[del];
			
			mode = row.cells[2].childNodes[0].value;
			var chkbox = row.cells[1].childNodes[0];
		 
			if(((null != chkbox && true == chkbox.checked)||autodelete)) {
				if(mode == 'I'){
					tbody.deleteRow(del);
					if(isValidObject(document.getElementById('hSelectRow'))){
						document.getElementById('hSelectRow').value = '';
					}
					rowCount--;
					del--;
				}
				if(mode == 'Q'){
			        row.cells[2].childNodes[0].value = 'D';
			        chkbox.checked = false;
				}
			}
		}// End of for(del)
		
		reorderTableRows(tableId,true);
		
	}

}
	
//function delRow(row,type)
//{
//    var mode = document.getElementsByName("txtFldAsstAttachmentMode");
//    var hdID = document.getElementsByName("txtFldAsstAttachmntId");
//    if(mode[row].value == CONSTANTS_VAR.QUERY_MODE)
//	   {
//          mode[row].className='writableFieldDHTML';
//          mode=CONSTANTS_VAR.DELETE_MODE;
//          hdID[row].className='writableFieldDHTML';
//
//	     var paramDelete = 'hActionType=HWDELETE'+ '&txtFldAsstAttachmntId='+encodeURIComponent(hdID[row].value);
//		 var data = assetAjax(paramDelete);
//		 populateAssetTbl(data);
//	   }//end of if 
//    else(mode[row].value == CONSTANTS_VAR.INSERT_MODE)
//      {
//	    //showAlert(mode[row].value);
//	     if(selRowArr.length >0)
//	     {
//		    for(var sel=0;sel<selRowArr.length;sel++)
//		    {
//			var selRow = selRowArr[sel];
//			var assetHWChk = tblBody.rows[selRow].cells[1].childNodes[0];
//			tblBody.deleteRow(selRow);
//			rearrangeDHTMLCount('AttachmentTable');
//			if(assetHWChk.checked)assetHWChk.checked = false;
//		    }//end of for
//		    selRowArr = [];
//	      }//end of if 
//	     else
//	     {
//		  showAlert('Select the rows to do deletion!');
//		  return;
//         }//end of else
//    }//end of else
//}//end of delRow

function rearrangeDHTMLCount(tblId)
{
	    var tbl = document.getElementById(tblId),
	    tblBody = tbl.tBodies[0],
	    tblLen = tblBody.rows.length;
	
	if(tblLen >0)
	{
		for(var cnt=0;cnt<tblLen;cnt++)
		{
			tblBody.rows[cnt].cells[0].childNodes[0].value = (cnt+1);
		}//end of for{cnt}
	}//end of if
	
}//end of rearrangeDHTMLCount

function submitForm()
{
	//showAlert("submit form!!!!")
	var tbl = document.getElementById('assetHardwareTable'),tblBody = tbl.tBodies[0],
    len = tblBody.rows.length;
	document.getElementById('hActionType').value = 'ASEET_CUD';
	
if(len <= 0)
{
	showAlert(CONSTANTS_VAR.ADDROW_BFR_SMT);
	return;
}
 

//showAlert("len--->"+len);

if(len>0)
{
//	if(!chkMandatoryFields(tblBody.rows[len-1].cells[3].childNodes[0], CONSTANTS_VAR.KEYIN_HRDWRE_ID))return;
//	if(!chkMandatoryFields(tblBody.rows[len-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_ASSET_NAME))return;
//	if(!chkMandatoryFields(tblBody.rows[len-1].cells[5].childNodes[0], CONSTANTS_VAR.KEYIN_HRDWRE_NAME))return;
//	if(!chkMandatoryFields(tblBody.rows[len-1].cells[11].childNodes[0], CONSTANTS_VAR.KEYIN_PROSSR_NAME))return;
}//end of if

	var doc = document.getElementsByName("upload");	
	//showAlert(doc.length);
	
	document.forms[0].action = 'register';
	document.forms[0].submit();
	
}//end of submitForm


function searchRecords()
{
	//showAlert("====Search Rec====");
	showLoader();
	clearRecords('AttachmentTable');
	var AtmntDate,AtmntCatgy,AtmntDocType;
	 
	AtmntDate =    $('#txtFldAttachmntDate').val(); 
	AtmntCatgy =   $('#txtFldAttachmntCatgry').val(); 	   
	AtmntDocType = $('#txtFldDocType').val(); 	   
//	alert("AtmntDate---"+AtmntDate);		   
	  
	if( isEmptyFld(AtmntDate) && isEmptyFld(AtmntCatgy)  && isEmptyFld(AtmntDocType) ){
		showAlert(CONSTANTS_VAR.SEL_ANYSRCH_CRIT,$('#txtFldAttachmntDate'));  
		showInfoError('AttachmentTable');
		hideLoader();
		return;
	}//end of if
	
	
 
	var param = 'hActionType=ATTACHSEARCH'+ 
		        '&txtFldAttachmntDate='+encodeURIComponent(AtmntDate)
		        +'&txtFldAttachmntCatgry='+encodeURIComponent(AtmntCatgy)+
	            '&txtFldDocType='+encodeURIComponent(AtmntDocType);
	     
	var data = assetAjax(param);
	
	populateAssetTbl(data);
	populateAssetForm(data);
}//end of searchRecords


function assetAjax(param)
{
		 
	var response = '';var result='';
	$.ajax({
		url            : 'AssetDetails',
		data           : param,
		dataType       : 'json',
		type           : 'POST',
		async          : false,
		success        :function(data){
		                response = data;
		},complete     : function(){
			
		},error        : function(){
			
		}
	});
	return response;
}//end of assetAjax


function populateAssetForm(response){
	var value = response;
	for ( var formfield in value) {
		
		if (value.hasOwnProperty(formfield)) {							
			var fieldvalue = value[formfield];	
			//showAlert(""+fieldvalue);
			//showAlert("formfield"+formfield);
			if(document.getElementById(formfield))
			document.getElementById(formfield).value=fieldvalue;
		}
	}
}



function populateAssetTbl(responce)
{
	//showAlert("POPULA?TE");
	var len = responce.length;
	 if(len >0)
	 {
		//populateForm(responce)
		 for(var asset=0;asset<len;asset++)
		 { 
			 $("#noofrecdiv").css("display","block");
			$("#noofrecdiv").find("input#noofattached").val((asset+1));
				
			 removeInfoError('AttachmentTable');
		    	var tbl = document.getElementById('AttachmentTable'),
		    		tblBody = tbl.tBodies[0];
				var row = tblBody.insertRow(asset);
				
				var cell0 = row.insertCell(0);
				cell0.innerHTML = '<input type="text" name="txtFldAsstAttachmntSlno"  id="txtFldAsstAttachmntSlno"   value="'+(asset+1)+'" class="readOnlyFieldDHTML" readonly="true" />';
				cell0.childNodes[0].style.textAlign = 'center'; 
				
				var cell1 = row.insertCell(1);
				cell1.innerHTML = '<input type="checkbox" name="radAsstAssetAttachmntSelect" id="radAsstAssetAttachmntSelect"  />'+'<input type="hidden" id="hSelRow" name="hSelRow" value="'+asset+'" />';
				cell1.childNodes[0].style.textAlign = 'center'; 
				
				var cell2 = row.insertCell(2);
				cell2.innerHTML = '<input type="text" name="txtFldAsstAttachmentMode" id="txtFldAsstAttachmentMode"  class="writableFieldDHTML"  value="'+CONSTANTS_VAR.QUERY_MODE+'"  readonly="true" />';
				cell2.childNodes[0].style.textAlign = 'center';
				  
				var cell3 = row.insertCell(3);
				cell3.innerHTML ='<select name="txtFldAsstAttachmntCatgry" id="txtFldAsstAttachmntCatgry" disabled="true"     class="form-control"  onmouseover="assetTooltip(this);" > </select>'+'<input type="hidden" name="txtFldAsstAttachmntId" id="txtFldAsstAttachmntId"  />';
				var cnt=0;
				cell3.childNodes[0].options[cnt]=  new Option("--select--","");
				for(var st=0;st<attach_categ_arr.length;st++)
				{ 
					cnt=cell3.childNodes[0].options.length;
					cell3.childNodes[0].options[cnt++]=  new Option(attach_categ_arr[st],attach_categ_arr[st]);
				}//end of for 
				cell3.childNodes[0].value=chkNull(responce[asset]['txtFldAsstAttachmntCatgry']);
				cell3.childNodes[1].value=chkNull(responce[asset]['txtFldAsstAttachmntId']);
				
				
//				var cell4 = row.insertCell(4);
//				cell4.innerHTML = '<input type="text" name="txtFldAsstDocumntType" id="txtFldAsstDocumntType" value="'+chkNull(responce[asset]['txtFldAsstDocumntType'])+'" onmouseover="assetTooltip(this);" maxlength="30" class="readOnlyFieldDHTML" readonly="readonly" />';
 
				var cell4 = row.insertCell(4);
				cell4.innerHTML ='<input type="text" name="txtFldAsstAttachDocTitle"  id="txtFldAsstAttachDocTitle" class="form-control"  value="'+chkNull(responce[asset]['txtFldAsstAttachDocTitle'])+'" onmouseover="assetTooltip(this);" maxlength="30" readonly= "true" />';
//				'<input type="hidden" name="txtFldAsstDocumntType" id="txtFldAsstDocumntType" value="'+chkNull(responce[asset]['txtFldAsstDocumntType'])+'" onmouseover="assetTooltip(this);" maxlength="30" class="readOnlyFieldDHTML" readonly="readonly" />';
				
				var cell5 = row.insertCell(5);
				cell5.innerHTML = '<input type="text" name="txtFldAsstAttachmentRemarks" id="txtFldAsstAttachmentRemarks" class="form-control"  value="'+chkNull(responce[asset]['txtFldAsstAttachmentRemarks'])+'" onmouseover="assetTooltip(this);" maxlength="60"  readonly="true" />';
				
 
				var cell6 = row.insertCell(6);
				cell6.innerHTML = "<div style='width:100px'><input type='hidden'  name='txtFldAsstAttachFileName' /><a  style='white-space: pre-wrap;word-break: break-all;' target=\'_new\'>"+responce[asset].txtFldAsstAttachFileName+"</a>"+
				'<input type="file" name="upload" id="upload"  style="display:none" />'+
				'<img src="styles/images/doc-view.png" width="20px" title="Document Preview"  />'+
								  '<input type="hidden" value="'+responce[asset].txtFldAsstAttachmntId+'"></div>';

				 
//				cell6.childNodes[2].href='FeedbackDownloadFile.do?txtFldAttachDocId='+responce[asset].txtFldAsstAttachmntId;
				$(cell6).find("a").attr("href",'FeedbackDownloadFile.do?txtFldAttachDocId='+responce[asset].txtFldAsstAttachmntId);
				$(cell6).find("img:first").click(function(){
					
					 __CANVAS_CTX.clearRect(0, 0, __CANVAS.width, __CANVAS.height);
					 __TOTAL_PAGES=0;
				var curndDocId=$(this).closest("div").find("input:eq(2)").val();	 
					
				setTimeout(function(){	 
					loadPdfDocument(curndDocId);
				},10);	
				
				});
				
				var cell7 = row.insertCell(7);
				cell7.innerHTML = '<input type="text" name="txtFldAsstAttachmntDate" id="txtFldAsstAttachmntDate" class="form-control"  onblur="validateDate(this);" value="'+chkNull(responce[asset]['txtFldAsstAttachmntDate'])+'"  onmouseover="assetTooltip(this);" maxlength="60" readonly="true" />';
				
				var cell8 = row.insertCell(8);
				cell8.innerHTML = '<input type="text" name="txtFldAsstAttachmntFileType" id="txtFldAsstAttachmntFileType" class="form-control"  value="'+chkNull(responce[asset]['txtFldAsstAttachmntFileType'])+'" onmouseover="assetTooltip(this);" maxlength="60" readonly="true" />';
 	
//				var cell10 = row.insertCell(10);
//				cell10.innerHTML = '<input type="text" name="txtFldAsstAttachmntCrtdBy" id="txtFldAsstAttachmntCrtdBy" value="'+chkNull(responce[asset]['txtFldAsstAttachmntCrtdBy'])+'" onmouseover="assetTooltip(this);" maxlength="10" class="readOnlyFieldDHTML" readonly="readonly" />';
//				
//				var cell11 = row.insertCell(11);
//				cell11.innerHTML = '<input type="text" name="txtFldAsstAttachmntCrtdDate" id="txtFldAsstAttachmntCrtdDate" onblur="validateDate(this);" value="'+chkNull(responce[asset]['txtFldAsstAttachmntCrtdDate'])+'" onmouseover="assetTooltip(this);" maxlength="10" class="readOnlyFieldDHTML" readonly="readonly" />';
//				
//				var cell12 = row.insertCell(12);
//				cell12.innerHTML = '<input type="text" name="txtFldAsstAttachmntModifdBy" id="txtFldAsstAttachmntModifdBy" value="'+chkNull(responce[asset]['txtFldAsstAttachmntModifdBy'])+'" onmouseover="assetTooltip(this);" maxlength="10" class="readOnlyFieldDHTML" readonly="readonly" />';
//				
//				var cell13 = row.insertCell(13);
//				cell13.innerHTML = '<input type="text" name="txtFldAsstAttachmntModfdDate" id="txtFldAsstAttachmntModfdDate" onblur="validateDate(this);" value="'+chkNull(responce[asset]['txtFldAsstAttachmntModfdDate'])+'" onmouseover="assetTooltip(this);" maxlength="10" class="readOnlyFieldDHTML" readonly="readonly" />';
				
		 }//end of for{asset}
		
	}//end of if
	 else{
		 showAlert("NO Record Found");
		 showInfoError('AttachmentTable');
	 }//end of else
	 
	 
}//end of populateAssetTbl

function clearRecords(tblId,typ)
{
    var tbl = document.getElementById(tblId),
	    tblBody = tbl.tBodies[0],
	    tblLen = tblBody.rows.length;
	
  //  var hdrSelObj = document.getElementById('chkHwbox');
	
	if(typ && typ == 'CLR')
	{
		if(tblLen <=0)
		{
			showAlert(CONSTANTS_VAR.NO_RECORDS);
			return;
		}//end of if	
	}//end of if
	
	if(tblLen >0)
	{
		for(var rmv=0;rmv<tblLen;rmv++)
		{
			tblBody.deleteRow(0);
		}//end of for
	}//end of if
	
	
	//if(hdrSelObj.checked)hdrSelObj.checked = false;
}//end of clearRecords



function selectRowFun(chkObj)
{
	
	if(chkObj.checked)
	{
		selRowArr.push(chkObj.parentNode.childNodes[1].value) ;
//		showAlert("Checked");
//		showAlert(selRowArr.push(chkObj.parentNode.childNodes[1].value));
//		myFunction(selRowArr);
	}//end of id
	
}//end of selectRowFun


function editRow()
{
	    var tbl     = document.getElementById('AttachmentTable'),
	    tblBody = tbl.tBodies[0],
	    tblLen  = tblBody.rows.length;
	    var editFlag=0;
	    if(tblLen <= 0)
		{
			showAlert(CONSTANTS_VAR.NO_ROWS);
			return;
		}//end of if
	    

		for(var edit=0;edit<tblLen;edit++){
			
			var row = tblBody.rows[edit];
			var chkbox = row.cells[1].childNodes[0];

			if(null != chkbox && true == chkbox.checked) {
			        editFlag = 1;
			}
		}
		
		if(!editFlag){
			showAlert("Select row to edit!");
			return;
		}	
		
	    
		//showAlert(tblLen);
		if(tblLen > 0)
		{
			
			for(var r=0;r<tblLen;r++){
				var chkbox = tblBody.rows[r].cells[1].childNodes[0];
				if(chkbox.checked ==true && tblBody.rows[r].cells[2].childNodes[0].value=="Q"){
					
					 tblBody.rows[r].cells[0].childNodes[0].className='writableFieldDHTML';
					
					 tblBody.rows[r].cells[1].childNodes[0].className='writableFieldDHTML';
					
					 tblBody.rows[r].cells[2].childNodes[0].className='writableFieldDHTML';
				     tblBody.rows[r].cells[2].childNodes[0].value="U";
				        
				     tblBody.rows[r].cells[3].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[3].childNodes[0].readOnly=false; 
					 
					 
					 tblBody.rows[r].cells[4].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[4].childNodes[0].readOnly=false;
					 
					 tblBody.rows[r].cells[5].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[5].childNodes[0].readOnly=false;
					
					 tblBody.rows[r].cells[6].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[6].childNodes[0].readOnly=false;
					
					 tblBody.rows[r].cells[7].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[7].childNodes[0].readOnly=false;
					
					 
					 tblBody.rows[r].cells[8].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[8].childNodes[0].readOnly=false;
					 
					 tblBody.rows[r].cells[9].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[9].childNodes[0].readOnly=false;
					
					 tblBody.rows[r].cells[10].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[10].childNodes[0].readOnly=false;
					 
					 tblBody.rows[r].cells[11].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[11].childNodes[0].readOnly=false;
					
					 tblBody.rows[r].cells[12].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[12].childNodes[0].readOnly=false;
					
					 tblBody.rows[r].cells[13].childNodes[0].className='writableFieldDHTML';
					 tblBody.rows[r].cells[13].childNodes[0].readOnly=false;
					  
				}	
					
			}
		}
		
	
}
 

function enableOrDisableRow(row,type)
{
	
	var hdSlno        = document.getElementsByName('txtFldAsstHDSlno');
	var hdChk         = document.getElementsByName('radAsstHDSelect');
	var hdMode        = document.getElementsByName("txtFldAsstHDMode");
	var hdID          = document.getElementsByName("txtFldAsstHDId");
	var hdAsstName    = document.getElementsByName("txtFldAsstHDAssdName");
	var hdName        = document.getElementsByName("txtFldAsstHDName");
	var hdMake        = document.getElementsByName("txtFldAsstHDMake");
	var hdModel       = document.getElementsByName("txtFldAsstHDModel");
	var hdSerlNo      = document.getElementsByName("txtFldAsstHDSerlNo");
	var hdAllotTo     = document.getElementsByName("txtFldAsstHDAllotTo");
	var hdOS          = document.getElementsByName('txtFldAsstHDOperSys');
	var hdProcssr     = document.getElementsByName("txtFldAsstHDProssr");
	var hdPrssrSpd    = document.getElementsByName("txtFldAsstHDProssrSpd");
	var hdRAM         = document.getElementsByName("txtFldAsstHDRAM");
	var hdLocID       = document.getElementsByName("txtFldAsstHDLocID");
	var hdRmks        = document.getElementsByName("txtFldAsstHDRmks");
	var hdPartNo      = document.getElementsByName("txtFldAsstHDPartNo");
	var hdCateg = document.getElementsByName("txtFldAsstHDCateg");
	var hdStatus = document.getElementsByName("txtFldAsstHDStatus");
	var hdpurchDate = document.getElementsByName("txtFldAsstHDPurchaseDate");
	var hdWrntyStartDate = document.getElementsByName("txtFldAsstHDWarrantyStartDate");
	var hdWrntyEndDate = document.getElementsByName("txtFldAsstHDWarrantyEndDate");
	
	
	if(hdMode[row].value == CONSTANTS_VAR.QUERY_MODE && type == CONSTANTS_VAR.ENABLE )
	{
		hdSlno[row].className='writableFieldDHTML';
		
		hdMode[row].className='writableFieldDHTML';
		hdMode[row].value = CONSTANTS_VAR.UPDATE_MODE;
		 

		hdID[row].className='writableFieldDHTML';
        hdID[row].readOnly=true;
        
//        hdAsstName[row].className='writableFieldDHTML';
//        hdAsstName[row].readOnly=false;
        
        hdName[row].className='writableFieldDHTML';
        hdName[row].readOnly=false;
        
        hdMake[row].className='writableFieldDHTML';
        hdMake[row].readOnly=false;
        
        hdModel[row].className='writableFieldDHTML';
        hdModel[row].readOnly=false;
        
        hdSerlNo[row].className='writableFieldDHTML';
        hdSerlNo[row].readOnly=false;
        
        hdAllotTo[row].className='writableFieldDHTML';
        hdAllotTo[row].readOnly=false;
        
        hdOS[row].className='writableFieldDHTML';
        hdOS[row].readOnly=false;
        
        hdProcssr[row].className='writableFieldDHTML';
        hdProcssr[row].readOnly=false;
        
        hdPrssrSpd[row].className='writableFieldDHTML';
        hdPrssrSpd[row].readOnly=false;
        
        hdRAM[row].className='writableFieldDHTML';
        hdRAM[row].readOnly=false;
        
        hdLocID[row].className='writableFieldDHTML';
        hdLocID[row].readOnly=false;
        
        hdRmks[row].className='writableFieldDHTML';
        hdRmks[row].readOnly=false;
        
        hdPartNo[row].readOnly=false;
        hdPartNo[row].className='writableFieldDHTML';
     
        hdCateg[row].readOnly=false;
        hdCateg[row].className='writableFieldDHTML';
        
        hdStatus[row].readOnly=false;
        hdStatus[row].className='writableFieldDHTML';
        
        hdpurchDate[row].readOnly=false;
        hdpurchDate[row].className='writableFieldDHTML';
        
        hdWrntyStartDate[row].readOnly=false;
        hdWrntyStartDate[row].className='writableFieldDHTML';
        
        hdWrntyEndDate[row].readOnly=false;
        hdWrntyEndDate[row].className='writableFieldDHTML';
        
       if(hdChk[row].checked) hdChk[row].checked = false;
        
	}
	else if(type == CONSTANTS_VAR.DISABLE)
	{
		
        hdSlno[row].className='readOnlyFieldDHTML';
		
		hdMode[row].className='readOnlyFieldDHTML';
		hdMode[row].value = CONSTANTS_VAR.UPDATE_MODE;
		  

		hdID[row].className='readOnlyFieldDHTML';
        hdID[row].readOnly=true;
        
//        hdAsstName[row].className='readOnlyFieldDHTML';
//        hdAsstName[row].readOnly=true;
//        
        hdName[row].className='readOnlyFieldDHTML';
        hdName[row].readOnly=true;
        
        hdMake[row].className='readOnlyFieldDHTML';
        hdMake[row].readOnly=true;
        
        hdModel[row].className='readOnlyFieldDHTML';
        hdModel[row].readOnly=true;
        
        hdSerlNo[row].className='readOnlyFieldDHTML';
        hdSerlNo[row].readOnly=true;
        
        hdAllotTo[row].className='readOnlyFieldDHTML';
        hdAllotTo[row].readOnly=true;
        
        hdOS[row].className='readOnlyFieldDHTML';
        hdOS[row].readOnly=true;
        
        hdProcssr[row].className='readOnlyFieldDHTML';
        hdProcssr[row].readOnly=true;
        
        hdPrssrSpd[row].className='readOnlyFieldDHTML';
        hdPrssrSpd[row].readOnly=true;
        
        hdRAM[row].className='readOnlyFieldDHTML';
        hdRAM[row].readOnly=true;
        
        hdLocID[row].className='readOnlyFieldDHTML';
        hdLocID[row].readOnly=true;
        
       
        hdRmks[row].className='readOnlyFieldDHTML';
        hdRmks[row].readOnly=true;
        
        hdPartNo[row].readOnly=true;
        hdPartNo[row].className='readOnlyFieldDHTML';
     
        hdCateg[row].readOnly=false;
        hdCateg[row].className='readOnlyFieldDHTML';
        
        hdStatus[row].readOnly=false;
        hdStatus[row].className='readOnlyFieldDHTML';
        
        hdpurchDate[row].readOnly=false;
        hdpurchDate[row].className='readOnlyFieldDHTML';
        
        hdWrntyStartDate[row].readOnly=false;
        hdWrntyStartDate[row].className='readOnlyFieldDHTML';
        
        hdWrntyEndDate[row].readOnly=false;
        hdWrntyEndDate[row].className='readOnlyFieldDHTML';
        
	}
	if(hdMode[row].value == CONSTANTS_VAR.UPDATE_MODE)
	{
		hdChk[row].checked = false;
	}//end of if
	
	
}//end of enableRow

function today()
{
	var date = new Date();
	var dd = date.getDate();
	var month = date.getMonth()+1;
	var year = date.getFullYear();
	
	if(dd < 10)
	{
		dd = '0'+dd;
	}
	
	if(month < 10)
	{
		month = '0'+month;
	}
	 
	return dd+'/'+month+'/'+year;
	
}//end of today



function chkNull(value)
{
	
	var retVal = '';
	
	if(value == null      || 
	   value == ''        || 
	   value == undefined || 
	   value == 'undefined')
		
		return retVal;
	
	else retVal = value;
	
	return retVal;
}//end of chkNull



function selAllRows(radObj)
{
	
	var tbl = document.getElementById('assetHardwareTable');
	var tblBody = tbl.tBodies[0],
	tblLen = tblBody.rows.length;
	
	if(radObj.checked)
	{
		if(tblLen ==0)
		{
			showAlert('No rows to select!');
			radObj.checked = false;
			return;
		}//end of if
		
		for(var row=0;row<tblLen;row++)
		{
			var selElem = tblBody.rows[row].cells[1].childNodes[0];
			var rowCnt = tblBody.rows[row].cells[1].childNodes[1].value;
			selRowArr.push(rowCnt);
			if(!selElem.checked)selElem.checked = true;
			
		}//end of for
		
	}
	else
	{
	   for(var row=0;row<tblLen;row++)
	    {
			var selElem = tblBody.rows[row].cells[1].childNodes[0];
			if(selElem.checked)selElem.checked = false;
		}//end of for
		selRowArr.length = 0;
	}//end of else
}//end of selAllRows


function assetCUDOpern()
{
	
	var asstAttachmntForm = document.forms["assetForm"];
	var tbl = document.getElementById('AttachmentTable');
	var tblBody = tbl.tBodies[0];
	var tblLen = tblBody.rows.length;
	assetForm.asset.value=tblLen;
	
	
//	var table = document.getElementById('AttachmentTable');
//	var tbody = table.tBodies[0];
//	var rowCount = tbody.rows.length;
	// len = tblBody.rows.length;
		
		if(tblLen>0){
	
	for(var del=0;del<tblLen;del++){
		var row = tblBody.rows[del];
		//var chkbox = row.cells[1].childNodes[0];
		var	mode = row.cells[2].childNodes[0].value;
		if(mode == 'I') {
			if(!chkMandatoryFields(tblBody.rows[tblLen-1].cells[3].childNodes[0], CONSTANTS_VAR.KEYIN_ATTCK_CATG))return;
			//if(!chkMandatoryFields(tblBody.rows[len-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_DOCTYPE))return;
			if(!chkMandatoryFields(tblBody.rows[tblLen-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_DOCTITLE))return;
			if(!chkMandatoryFields(tblBody.rows[tblLen-1].cells[6].childNodes[0], CONSTANTS_VAR.KEYIN_DOCUPLOAD))return; 
		}
	}
	
	
	
		}
	
	
	
	
	
	var doc = document.getElementsByName("upload");	
	//showAlert(doc.length);
	
	
	//showAlert(document.getElementById("asset").value)
	$("input,select").attr("disabled",false);
	asstAttachmntForm.action = 'asstAttachmntCUDOpern.do';
	asstAttachmntForm.submit();
	
}//end of assetCUDOpern




//function showATFreeForm(){
//		//showAlert("trialfreeform")
//	
//	var tbl     = document.getElementById('AttachmentTable'),
//    tblBody = tbl.tBodies[0],
//    tblLen  = tblBody.rows.length;
//	 var editFlag=0;
//	 if(tblLen <= 0)
//		{
//			showAlert(CONSTANTS_VAR.NO_ROWS);
//			return;
//		}//end of if
//		
//
//		for(var edit=0;edit<tblLen;edit++){
//			
//			var row = tblBody.rows[edit];
//			var chkbox = row.cells[1].childNodes[0];
//			var mode = row.cells[2].childNodes[0].value;
//		//	alert("mode==="+mode);
//			if(null != chkbox && true == chkbox.checked) {
//			        editFlag = 1;
//			        if(mode == CONSTANTS_VAR.INSERT_MODE){
//			        	$('#attachfreeformdiv').modal('hide');
//			        	//var chkbox = row.cells[1].childNodes[0];
//						chkbox.checked = false;
//			        }
//			        else{
//			        	showAssetModel('attachfreeformdiv','Asset Attachments Details');
//			        	$('#attachfreeformdiv').on('shown.bs.modal', function() {   
//			        		  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
//			        			  	//formFunctionEdit();
//			        			  	if(!validateAttch())return;
//			        			  	$('#attachfreeformdiv').modal('hide'); 
//			        		  });
//			        		  
//			        		});
//			        	
//			        	}
//			        
////			        if(mode == CONSTANTS_VAR.UPDATE_MODE){
////			        	showAssetModel('attachfreeformdiv','Asset Attachments Details');
////			        	$('#attachfreeformdiv').on('shown.bs.modal', function() {   
////			        		  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
////			        			  	formFunctionEdit();
////			        			  	if(!validateAttch())return;
////			        			  	$('#attachfreeformdiv').modal('hide'); 
////			        		  });
////			        		  
////			        		});
////		        	}
//			}
//		}
//		
//		if(!editFlag){
//			showAlert("Select row to edit!");
//			return;
//		}	
//		
//		
//		
////	showAssetModel('attachfreeformdiv','Asset Attachments Details');
////	$('#attachfreeformdiv').on('shown.bs.modal', function() {   
////		  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
////			  	formFunctionEdit();
////			  	if(!validateAttch())return;
////			  	$('#attachfreeformdiv').modal('hide'); 
////		  });
////		  
////		});
//	
//	 
//	// formFunction();  
//	
//}

function showATFreeForm(){

//
//	$("#AttachmentTable tbody").find('tr.odd').each(function(){
//        $(this).remove();        
//     
//    });
	
	
	var table = document.getElementById('AttachmentTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#AttachmentTable").find("input[type=checkbox]:checked").length;
	
	var editFlag = 0;
	
	if(rowCount<1){
		
		showAlert("Insert rows before view!");
		return;
	}
	
	for(var edit=0;edit<rowCount;edit++){
		
		var row = tbody.rows[edit];
		var chkbox = row.cells[1].childNodes[0];

		if(null != chkbox && true == chkbox.checked) {
			if(checkedlen ==1){
				editFlag = 1;
			}
		}
	}
	
	if(!editFlag){
		
		showAlert("Single row to be selected");
		
		for(var edit=0;edit<rowCount;edit++){
			
			var row = tbody.rows[edit];
			var chkbox = row.cells[1].childNodes[0];
			chkbox.checked = false;
			
		}
		return;
	}	
	
	for(var editrow=0;editrow<rowCount;editrow++){
		
		var editCurRow = tbody.rows[editrow];
		
		var chkbox = editCurRow.cells[1].childNodes[0];
		
		var mode = editCurRow.cells[2].childNodes[0].value;
		
		if(null != chkbox && true == chkbox.checked) {
			
				if((mode == CONSTANTS_VAR.INSERT_MODE)  ){
					
				
						chkbox.checked = false;

						
				 
			}// I/U Mode

			if(mode == CONSTANTS_VAR.QUERY_MODE){
				 	
				 
				 editCurRow.cells[2].childNodes[0].value = mode;
				 chkbox.checked = false;
				 hdwRdlyflds(mode);
				 hdwfilldlgval(editCurRow);
				 showAssetModel('attachfreeformdiv','Asset Attachments Details'); 
				 $('#attachfreeformdiv').on('shown.bs.modal', function() {   
				  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
					  	$('#attachfreeformdiv').modal('hide'); 
				  });
				  
				});	
				 
				
				   
			}// Q Mode
			
		}
		}
	

}


function hdwRdlyflds(mode){
	 
	if(mode == CONSTANTS_VAR.QUERY_MODE){
		 $("#attachfreeformdiv :input").prop('disabled', false);  
	} 
	
	$("#attachfreeformdiv").find(".modal-footer").find("button:eq(0)").attr("disabled",false);
	$("#attachfreeformdiv").find(".modal-footer").find("button:eq(1)").attr("disabled",false);
}

function validateAttch(){
	if(!chkModelMandatory($("#attachfreeformdiv #txtFldAsstATFrmCatgry"), CONSTANTS_VAR.KEYIN_ATTCK_CATG))return;
	if(!chkModelMandatory($("#attachfreeformdiv #txtFldAsstATFrmDocumentType"), CONSTANTS_VAR.KEYIN_DOCTYPE))return;
	if(!chkModelMandatory($("#attachfreeformdiv #txtFldAsstATFrmDocumentTitle"), CONSTANTS_VAR.KEYIN_DOCTITLE))return;
	
	return true;
}
 
function hdwfilldlgval(editCurRow){

	//alert("test");
			
			  $('#attachfreeformdiv #txtFldAsstATFrmCatgry').val(editCurRow.cells[3].childNodes[0].value);
			  $('#attachfreeformdiv #txtFldAsstATFrmDocumentTitle').val(editCurRow.cells[4].childNodes[0].value);
			  $('#attachfreeformdiv #txtFldAsstATFrmRemarks').val(editCurRow.cells[5].childNodes[0].value);
			  $('#attachfreeformdiv #txtFldAsstATFrmDoc').val(editCurRow.cells[6].childNodes[0].value);
			  $('#attachfreeformdiv #txtFldAsstATFrmDoc').find("div[id='attachFile']").html("");
			  $("#attachfreeformdiv #txtFldAsstATFrmDoc").find("div[id='attachFile']").append(editCurRow.cells[6].childNodes[1].outerHTML);
			  $("#attachfreeformdiv #txtFldAsstATFrmAttchDate").val(editCurRow.cells[7].childNodes[0].value);
			  $('#attachfreeformdiv #txtFldAsstATFrmFileType').val(editCurRow.cells[8].childNodes[0].value);

			
	}


function loadPdfDocument(strDocId){
	
//	$(".simplebar-wrapper").css("height","100% !important");
	
	if($("#attchSplitDivTbl").hasClass("col-md-12")){
		$("#attchSplitDivTbl").removeClass("col-md-12");
		$("#attchSplitDivTbl").addClass("col-md-7");
		$("#attchSplitDivView").removeClass("hidden");
	}else{
		/*$("#attchSplitDivView").addClass("hidden");
		$("#attchSplitDivTbl").removeClass("col-md-7");
		$("#attchSplitDivTbl").addClass("col-md-12");*/
	}
	
	 $.ajax({
		 data:{hActionType:"PDFVIEWER",
			 	txtFldAttachDocId:strDocId},
		 method:"POST",
		 url:urlPath+"/AssetDetailsServlets", 
		 success: function(result){
		    var jsnRslt=$.parseJSON(result);
		    
		    if(jsnRslt[0].FILE_NOT_FOUND=="FILE_NOT_FOUND"){
		    	alert("file not found!");
		    	
		    	return;
		    }
			 
		    
			 var pdfData = atob(jsnRslt[0].BASE64);
			 
//			 var pdfjsLib = window['pdfjs-dist/build/pdf'];

			// The workerSrc property shall be specified.
//			pdfjsLib.GlobalWorkerOptions.workerSrc = '//mozilla.github.io/pdf.js/build/pdf.worker.js';
			 
			
			$("#pdf-loader").show();
			
			 var loadingTask = pdfjsLib.getDocument({data: pdfData});
			 loadingTask.promise.then(function(pdf_doc) {
				 __PDF_DOC = pdf_doc;
			        __TOTAL_PAGES = __PDF_DOC.numPages;
				 
				 
			        $("#pdf-loader").hide();
			        $("#pdf-contents").show();
			        $("#pdf-total-pages").text(__TOTAL_PAGES);
				  
			        $("#scaleSelect").val("0.5") 
			        
			        showPage(1);
			        
			       /* if($("#attchSplitDivTbl").hasClass("col-md-12")){
		                $("#attchSplitDivTbl").removeClass("col-md-12");
		                $("#attchSplitDivTbl").addClass("col-md-7");
		                $("#attchSplitDivView").removeClass("hidden");
		            }*/
//			        setTimeout(function(){	 
//			        	$(".simplebar-wrapper").css("height","34vh");
//					},1000);
				 /*  // Fetch the first page
				  var pageNumber = 1;
				  pdf.getPage(pageNumber).then(function(page) {
					    console.log('Page loaded');
					    
					    var scale = 0.50;
					    var viewport = page.getViewport(scale);
					    
					    viewport.height=330;
					    viewport.width=450;
					    
					    // Prepare canvas using PDF page dimensions
					    var canvas = document.getElementById('the-canvas');
					    var context = canvas.getContext('2d');
					    canvas.height =  viewport.height;
					    canvas.width = viewport.width;

					    // Render PDF page into canvas context
					    var renderContext = {
					      canvasContext: context,
					      viewport: viewport
					    };
					    var renderTask = page.render(renderContext);
					    renderTask.then(function () {
					      console.log('Page rendered');
					    });
					  });
					*/},function (reason) {
						  // PDF loading error
						  console.error(reason); 
				 
					});
		 },
		 complete: function () {
//			 $(".simplebar-wrapper").css("height","34vh");
		 }
	 });	
}

function showPage(page_no) {
    __PAGE_RENDERING_IN_PROGRESS = 1;
    __CURRENT_PAGE = page_no;

    // Disable Prev & Next buttons while page is being loaded
    $("#pdf-next, #pdf-prev").attr('disabled', 'disabled');

    // While page is being rendered hide the canvas and show a loading message
    $("#pdf-canvas").hide();
    $("#page-loader").show();

    // Update current page in HTML
    $("#pdf-current-page").text(page_no);
    
    // Fetch the page
    __PDF_DOC.getPage(page_no).then(function(page) {
        // As the canvas is of a fixed width we need to set the scale of the viewport accordingly
        var scale_required = /*__CANVAS.width / page.getViewport(1).width;*/0.6;
        // Get viewport of the page at required scale
        var viewport = page.getViewport(scale_required);

        // Set canvas height
        __CANVAS.height = viewport.height;
        	
       

        var renderContext = {
            canvasContext: __CANVAS_CTX,
            viewport: viewport
        };
        
        // Render the page contents in the canvas
        page.render(renderContext).then(function() {
            __PAGE_RENDERING_IN_PROGRESS = 0;

            // Re-enable Prev & Next buttons
            $("#pdf-next, #pdf-prev").removeAttr('disabled');

            // Show the canvas and hide the page loader
            $("#pdf-canvas").show();
            $("#page-loader").hide();
        });
    });
    
    __CANVAS_CTX.fillStyle = "blue";
    __CANVAS_CTX.fillRect(0, 0, __CANVAS.width, __CANVAS.height);
}


function zoom(newScale) {
	 // Using promise to fetch the page
	 pdfDoc.getPage(__CURRENT_PAGE).then(function (page) {
	 var viewport = page.getViewport(newScale);
	 __CANVAS.height = viewport.height;
	 __CANVAS.width = viewport.width;
	 // Render PDF page into canvas context
	 var renderContext = {
	 canvasContext: __CANVAS_CTX,
	 viewport: viewport
	 };
	 page.render(renderContext);
	 });
}	

function zoomIn() {

	var scaleSelect = document.getElementById("scaleSelect");
	var last = scaleSelect.options.length-1;
	if (scaleSelect.selectedIndex < last) {
	scale = scaleSelect.options[scaleSelect.selectedIndex+1].value;
	scaleSelect.selectedIndex+= 1;
	showPageWithScale(__CURRENT_PAGE,scale);
	}
}	

function zoomOut() {

 var scaleSelect = document.getElementById("scaleSelect");
 var last = scaleSelect.options.length-1;
 if (scaleSelect.selectedIndex > 0) {
 scale = scaleSelect.options[scaleSelect.selectedIndex-1].value;
 scaleSelect.selectedIndex-=1;
 showPageWithScale(__CURRENT_PAGE,scale);
}
}

function showPageWithScale(page_no,scale) {

__PAGE_RENDERING_IN_PROGRESS = 1;
__CURRENT_PAGE = page_no;

// Disable Prev & Next buttons while page is being loaded
//$("#pdf-next, #pdf-prev").attr('disabled', 'disabled');

// While page is being rendered hide the canvas and show a loading message
//$("#pdf-canvas").hide();
//$("#page-loader").show();

// Update current page in HTML
//$("#pdf-current-page").text(page_no);

// Fetch the page
__PDF_DOC.getPage(page_no).then(function(page) {
    // As the canvas is of a fixed width we need to set the scale of the viewport accordingly
    var scale_required = scale;
    // Get viewport of the page at required scale
    var viewport = page.getViewport(scale_required);

    // Set canvas height
    __CANVAS.height = viewport.height;

    var renderContext = {
        canvasContext: __CANVAS_CTX,
        viewport: viewport
    };
    
    // Render the page contents in the canvas
    page.render(renderContext).then(function() {
        __PAGE_RENDERING_IN_PROGRESS = 0;

        // Re-enable Prev & Next buttons
//        $("#pdf-next, #pdf-prev").removeAttr('disabled');

        // Show the canvas and hide the page loader
//        $("#pdf-canvas").show();
//        $("#page-loader").hide();
    });
});
}
