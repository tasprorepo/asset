
var selRowArr = []; 
var SW_CATEGORY_VAR;
var LICENSE_TYPE_VAR;
var SW_STATUS_VAR;
var softwareTbl="";
var  sw_categ_arr=[];
var license_type_arr=[];
var sw_status_arr=[];
 


function toolBarSrchFun()
{ 
	searchSwRecords();
} 

function toolBarSaveFun()
{
	assetCUDOpern();
} 

function assetCUDOpern()
{
	var asstSwForm = document.assetForm;
	var tbl = document.getElementById('assetSoftwareTable');
	var tblBody = tbl.tBodies[0];
	tblLen = tblBody.rows.length;
	
	var cellCount = tbl.rows[0].cells.length;
	var setFlg=true;
	$("#assetSoftwareTable tbody").find('tr.odd').each(function(){//only when no records founds
		showAlert(CONSTANTS_VAR.NO_ROWS); 
	    setFlg=false;
	    return;
	});
	
	asstSwForm.asset.value=tblLen;
	var flag=false;
	
	if(setFlg)
	{
		for(var row=0;row<tblLen;row++)
			{
			
			  var assetCUDValidation=tblBody.rows[row].cells[2].childNodes[0].value;
			  if(assetCUDValidation == "U" || assetCUDValidation == "I" || assetCUDValidation == "D")
			  {
				flag=true;
			  }
			}
	}
		
	if(flag==true)
		{
		$("select").attr("disabled",false);
		asstSwForm.action = 'assetSftwareCUDOpern.do';
		asstSwForm.submit();
		}
	
}



function loadSWinit()
{
	
	$('#successmsgdiv').delay(2000).fadeOut('blind');
	$("#side-menu").find("li a").removeClass("active")
	$("#liassetsoft").find("a").addClass("active");
	var sw_Catg_Type= SW_CATEGORY_VAR.substr(1,SW_CATEGORY_VAR.length-2);
	var sw_Catg_Split = sw_Catg_Type.split(",");
	
	 for(var sw_Catg_Loop=0;sw_Catg_Loop<sw_Catg_Split.length;sw_Catg_Loop++)
	 {
	  sw_categ_arr.push(trim(sw_Catg_Split[sw_Catg_Loop]))
   	 }//end of for 
	
	
	var linseType=LICENSE_TYPE_VAR.substr(1,LICENSE_TYPE_VAR.length-2);
	var licensesplit = linseType.split(",");
	
	for(var linsedata=0;linsedata<licensesplit.length;linsedata++)
	{
		license_type_arr.push(trim(licensesplit[linsedata]))	
	}
	var swStatus=SW_STATUS_VAR.substr(1,SW_STATUS_VAR.length-2);
	var swStatusplit = swStatus.split(",");
	
	for(var swStatusfor=0;swStatusfor<swStatusplit.length;swStatusfor++)
	{
		sw_status_arr.push(trim(swStatusplit[swStatusfor]))
	}
	
	
	$("#btnFldAssSwAddRow").click(function(){ 
		sftwAddRow(null);
	});
	
	$("#btnFldAssSWEditRow").click(function(){ 
		sftwEditRow();
	});
	
	$("#btnFldAssSWDelRow").click(function(){ 
		sftDelRow();
	});
	
	$("#btnFldAssSWEXpandRow").click(function(){ 
		sftwViewRow();
	});
	
	showTooltip('btnFldAssSwAddRow','Add Row');
	showTooltip('btnFldAssSWEditRow','Edit Row');
	showTooltip('btnFldAssSWDelRow','Delete Row');
	showTooltip('btnFldAssSWEXpandRow','Expand Row');
	showTooltip('btnExportSWXls','Export XLS');
	showTooltip('btnExportSWPdf','Export PDF'); 
	
	
	softwareTbl=$("#assetSoftwareTable").DataTable({ 
		destroy:true,
		scrollX: true,
	    scrollY: "50vh",
	    scrollCollapse: true,
	    bSorting:false,
	    bPaginate: true, 
	    bLengthChange:false, 
	    bInfo: false,
	    bFilter: false,
	    paging: true,
        pagingType:"full_numbers",
        fixedHeader:true,
        bAutoWidth: false , 
        "aaSorting": [[ 1, "asc" ]],
	    oLanguage: {"sEmptyTable": 'No Records',"sInfoEmpty": 'No Records' },
	    		    fnDrawCallback: function(oSettings) {
	        if (oSettings._iDisplayLength > oSettings.fnRecordsDisplay()) {
	            $(oSettings.nTableWrapper).find('.dataTables_paginate').hide(); 
	        } 
	        ctrlOverFlowDataTable('assetSoftwareTable'); 
	    }
	   
	}); 
	hideLoader(); 
}
function fnExcelReport()
{
	showLoader()  
	var strswname = $('#txtFldSrchSWName').val();
 	var strswlic = $('#txtFldSrchSWLicense').val();
 	var strswcatg = $('#txtFldSrchSWCategory').val();
 	var param = 'hActionType=EXPSWSEARCH'+ 
     '&txtFldSrchSWName='+encodeURIComponent(strswname)
     +'&txtFldSrchSWLicense='+encodeURIComponent(strswlic)+
     '&txtFldSrchSWCategory='+encodeURIComponent(strswcatg)+"&"+$('#assetForm').serialize();
 	
 	window.open(urlPath+"/AssetDetails?"+param,'_new');
	
 	hideLoader();
}


function searchSwRecords()
{  
	 showLoader();
	clearRecords('assetSoftwareTable');
	
	var softwareName = $('#txtFldSrchSWName').val();
	var licenseType =  $('#txtFldSrchSWLicense').val();
	var categoryType = $('#txtFldSrchSWCategory').val();
	
	
	if( isEmptyFld(softwareName) && isEmptyFld(licenseType)  && isEmptyFld(categoryType) ){
		showAlert(CONSTANTS_VAR.SEL_ANYSRCH_CRIT,$('#txtFldSrchSWName'));  
		hideLoader();
		return;
	}//end of if
	
	
	 	   
	var param = 'hActionType=SWSEARCH'+ 
		        '&txtFldSrchSWName='+encodeURIComponent(softwareName)+
	            '&txtFldSrchSWLicense='+encodeURIComponent(licenseType)+
	            '&txtFldSrchSWCategory='+encodeURIComponent(categoryType);
   
	var data = assetAjax(param);  
	for ( var tab in data) {
		

		if (data.hasOwnProperty(tab)) {
		 
			var key = tab;
			var value = data[tab];
				 getsftwRows(value);
		}
	}
}


function sftwAddRow(dataset)
{
	 sftwclearFlds();
	 showAssetModel('swfreeformdiv','Asset Software Details'); 
	 sftwMethods('swfreeformdiv',dataset,'INS','','');   

}



function getsftwRows(dataset){
	
	$("#assetSoftwareTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	var tbl = document.getElementById('assetSoftwareTable'),
	tblBody = tbl.tBodies[0],
    len = tblBody.rows.length;
	 
	var row = tblBody.insertRow(len);
	
	if(len<1){
		   removeInfoError('assetSoftwareTable');
	}
	
	var cell0 = row.insertCell(0);
	cell0.innerHTML = '<input type="text" name="txtFldAsstSWSlno"  style="width:30px;" id="txtFldAsstSWSlno" readonly="true" value="'+(len+1)+'" class="writableFieldDHTML" />';
	cell0.childNodes[0].style.textAlign = 'center';
	
	var cell1 = row.insertCell(1);
	cell1.innerHTML = '<input type="checkbox" name="radAsstSWSelect" style="width:100%; id="radAsstSWSelect" class="writableFieldDHTML" onclick="selectRowFun(this)" />'+'<input type="hidden" id="hSelRow" name="hSelRow" value="'+len+'">';
	cell1.childNodes[0].style.textAlign = 'center';
	
	var cell2 = row.insertCell(2);
	cell2.innerHTML = '<input type="text" name="txtFldAsstSWMode" id="txtFldAsstSWMode"   value="'+CONSTANTS_VAR.INSERT_MODE+'" class="writableFieldDHTML" readonly="true"/>';
	cell2.childNodes[0].style.textAlign = 'center';
	
	var cell3 = row.insertCell(3);
	cell3.innerHTML = '<input type="text" name="txtFldAsstSWName" id="txtFldAsstSWName" value=""  onmouseover="assetTooltip(this);"  maxlength="30"  class="writableFieldDHTML" readonly="true"/>'+
	'<input type="hidden" name="txtFldAsstSWId" id="txtFldAsstSWId" value="" maxlength="150"  class="writableFieldDHTML" />';
	cell3.childNodes[0].value = document.getElementById("txtFldAsstSWFrmName").value; 
	
	
	var cell4 = row.insertCell(4);
	cell4.innerHTML ='<select name="txtFldAsstSWCateg" id="txtFldAsstSWCateg" style="width:100%"  onmouseover="assetTooltip(this);" disabled="true"> </select>';
	var cnt=0;
	cell4.childNodes[0].options[cnt]=  new Option("--select--","");
	for(var st=0;st<sw_categ_arr.length;st++)
	{ 
		cnt=cell4.childNodes[0].options.length;
		cell4.childNodes[0].options[cnt++]=  new Option(sw_categ_arr[st],sw_categ_arr[st]);
	}
	cell4.childNodes[0].value = document.getElementById("txtFldAsstSWFrmCatrgy").value; 
	
	var cell5 = row.insertCell(5);
	cell5.innerHTML ='<select name="txtFldAsstSWLicenseType" id="txtFldAsstSWLicenseType" style="width:100%"  onmouseover="assetTooltip(this);" disabled="true"> </select>';
	var cnt=0;
	cell5.childNodes[0].options[cnt]=  new Option("--select--","");
	for(var st=0;st<license_type_arr.length;st++)
	{ 
		cnt=cell5.childNodes[0].options.length;
		cell5.childNodes[0].options[cnt++]=  new Option(license_type_arr[st],license_type_arr[st]);
	}
	cell5.childNodes[0].value = document.getElementById("txtFldAsstSWFrmLType").value; 
	
	var cell6 = row.insertCell(6);
	cell6.innerHTML = '<input type="text" name="txtFldAsstSWLicenseKey" id="txtFldAsstSWLicenseKey" value=""    onmouseover="assetTooltip(this);" maxlength="150" class="writableFieldDHTML" readonly="true"/>';
	cell6.childNodes[0].value = document.getElementById("txtFldAsstSWFrmLKey").value; 
	
	var cell7 = row.insertCell(7);
	cell7.innerHTML ='<select name="txtFldAsstSWStatus" id="txtFldAsstSWStatus" style="width:100%" onmouseover="assetTooltip(this);"  disabled="true"> </select>';
	var cnt=0;
	cell7.childNodes[0].options[cnt]=  new Option("--select--","");
	for(var st=0;st<sw_status_arr.length;st++)
	{ 
		cnt=cell7.childNodes[0].options.length;
		cell7.childNodes[0].options[cnt++]=  new Option(sw_status_arr[st],sw_status_arr[st]);
	}
	cell7.childNodes[0].value = document.getElementById("txtFldAsstSWFrmStatus").value; 
	
	var cell8 = row.insertCell(8);
	cell8.innerHTML = '<input type="text" name="txtFldAsstSWRmks" id="txtFldAsstSWRmks" value="" maxlength="300" class="writableFieldDHTML" onmouseover="assetTooltip(this);" readonly="true" />';
	cell8.childNodes[0].value = document.getElementById("txtFldAsstSWFrmRmks").value; 
	
	cell3.childNodes[0].focus();

if(dataset != null){

			 cell2.childNodes[0].value = "Q";
			 
			
	var infoDetsArr = new Array();
	
	for(var data in dataset){
		var col = dataset[data];
		
		switch(data){
			case "txtFldAsstSWName":
				cell3.childNodes[0].value=col;
				break;
				
			case "txtFldAsstSWId":
				cell3.childNodes[1].value=col;
				break; 
				
			case "txtFldAsstSWCateg":
				cell4.childNodes[0].value=col;
				cell4.childNodes[0].disabled=true;
				break;
				
			case "txtFldAsstSWLicenseType":
				cell5.childNodes[0].value=col;
				cell5.childNodes[0].disabled=true;
				break;
				
			case "txtFldAsstSWLicenseKey":
				cell6.childNodes[0].value=col;
				cell6.childNodes[0].readOnly=true;
				break;
				
			case "txtFldAsstSWStatus":
				cell7.childNodes[0].value=col;
				cell7.childNodes[0].disabled=true;
				break;
				
			case "txtFldAsstSWRmks":
				cell8.childNodes[0].value=col;
				cell8.childNodes[0].readOnly=true;
				break;
		   }
		removeInfoError('assetSoftwareTable');
      }
	}
 



}


function sftwEditRow(){
	$("#assetSoftwareTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById('assetSoftwareTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetSoftwareTable").find("input[type=checkbox]:checked").length;
	var editFlag = 0;
	
	if(rowCount<1){
		showAlert("Insert rows before edit!");
		return;
	} 
	for(var edit=0;edit<rowCount;edit++){
		
		var row = tbody.rows[edit];
		var chkbox = row.cells[1].childNodes[0];
		 
		if(null != chkbox && true == chkbox.checked) { 
			if(checkedlen ==1 ){
		       editFlag = 1;
			}
		}
	 
	}
	
	if(!editFlag){
		showAlert("Select a row to edit!");
		return;
	}	
	
	for(var editrow=0;editrow<rowCount;editrow++){
		

		var editCurRow = tbody.rows[editrow];
		
		var chkbox = editCurRow.cells[1].childNodes[0];
		
		var mode = editCurRow.cells[2].childNodes[0].value;
		 
		if(null != chkbox && true == chkbox.checked) { 
		
			if(mode == CONSTANTS_VAR.QUERY_MODE  || mode == CONSTANTS_VAR.UPDATE_MODE){
				

				var RowId=editCurRow.cells[0].childNodes[0].value;		
				 
				
				editCurRow.cells[2].childNodes[0].value = CONSTANTS_VAR.UPDATE_MODE;
				chkbox.checked = false;
				 
		        
		        sftwRdlyflds(CONSTANTS_VAR.UPDATE_MODE);
		        sftwfilldlgval(editCurRow);
		         
			   	showAssetModel('swfreeformdiv','Asset Software Details'); 
				sftwMethods('swfreeformdiv','','QRY/UPD',RowId,table);
				  
			}// Q Mode
			
			
			
			for(var editcell=3;editcell<cellCount;editcell++){
				editCurRow.cells[editcell].childNodes[0].readOnly=false;
				editCurRow.cells[editcell].childNodes[0].disabled=false;
				
				if(editCurRow.cells[editcell].childNodes[2]){					
					if(editCurRow.cells[editcell].childNodes[2].tagName.toLowerCase() == 'img'){
						editCurRow.cells[editcell].childNodes[1].value=CONSTANTS_VAR.UPDATE_MODE;
					}
				}
				
			}
			
			 
		}
		
		
	}
}


function sftwViewRow(){
	$("#assetSoftwareTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById("assetSoftwareTable");
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	
	var checkedlen=$("#assetSoftwareTable").find("input[type=checkbox]:checked").length;
	
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
		showAlert("Select a row to view!");
		return;
	}	
	
	for(var editrow=0;editrow<rowCount;editrow++){
		
		var editCurRow = tbody.rows[editrow];
		
		var chkbox = editCurRow.cells[1].childNodes[0];
		
		var mode = editCurRow.cells[2].childNodes[0].value;
		
		if(null != chkbox && true == chkbox.checked) {
			
				if((mode == CONSTANTS_VAR.INSERT_MODE) || (mode == CONSTANTS_VAR.UPDATE_MODE) ){
					 var RowId=editCurRow.cells[0].childNodes[0].value;		 
						editCurRow.cells[2].childNodes[0].value = mode;
						chkbox.checked = false;
						sftwRdlyflds(mode);
						sftwfilldlgval(editCurRow);
						showAssetModel('swfreeformdiv','Asset Software Details'); 
						sftwMethods('swfreeformdiv','','INS/UPD',RowId,table);
				 }// I/U Mode
			
			if(mode == CONSTANTS_VAR.QUERY_MODE){
				
				 sftwRdlyflds(mode);
				 sftwfilldlgval(editCurRow);
				 showAssetModel('swfreeformdiv','Asset Software Details'); 
				 sftwMethods('swfreeformdiv','','QRY',RowId,table);
				   
			}// Q Mode
			
		}
		}
	
}



function sftDelRow(){
	
	tableDeleteRow("assetSoftwareTable",false); 
	var table = document.getElementById("assetSoftwareTable");
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	 
	if(rowCount<1){
		showInfoError('assetSoftwareTable');
	}
	
}

function sftwclearFlds(){
	$("#swfreeformdiv").find("input[type=text]").val("");
	$("#swfreeformdiv").find("textarea").val("");
	$("#swfreeformdiv").find("select").val("");      
}


function sftwRdlyflds(mode){
	 
	if(mode == CONSTANTS_VAR.QUERY_MODE){
		 $("#swfreeformdiv :input").prop('disabled',true);  
		 $("select#swfreeformdiv").prop('disabled',true);  
	}else if((mode == CONSTANTS_VAR.INSERT_MODE) || (mode == CONSTANTS_VAR.UPDATE_MODE) ){
		  $("#swfreeformdiv :input").prop('disabled',false); 
		  $("select#swfreeformdiv").prop('disabled',false); 
	}

	$("#swfreeformdiv").find(".modal-footer").find("button:eq(0)").attr("disabled",false);
	$("#swfreeformdiv").find(".modal-footer").find("button:eq(1)").attr("disabled",false);
	
}


function valiSftwDetails(){
	if(!chkModelMandatory($("#swfreeformdiv #txtFldAsstSWFrmName"), CONSTANTS_VAR.KEYIN_SOFTWRE_NAME))return;
	if(!chkModelMandatory($("#swfreeformdiv #txtFldAsstSWFrmLKey"), CONSTANTS_VAR.KEYIN_SOFTWRE_LIC))return;
	return true;
}

function sftwfilldlgval(editCurRow){
	  $('#swfreeformdiv #txtFldAsstSWFrmId').val(editCurRow.cells[3].childNodes[1].value); 
	  $('#swfreeformdiv #txtFldAsstSWFrmName').val(editCurRow.cells[3].childNodes[0].value);
	  $('#swfreeformdiv #txtFldAsstSWFrmCatrgy').val(editCurRow.cells[4].childNodes[0].value);
	  $('#swfreeformdiv #txtFldAsstSWFrmLType').val(editCurRow.cells[5].childNodes[0].value);
	  $('#swfreeformdiv #txtFldAsstSWFrmLKey').val(editCurRow.cells[6].childNodes[0].value);
	  $('#swfreeformdiv #txtFldAsstSWFrmStatus').val(editCurRow.cells[7].childNodes[0].value);
	  $('#swfreeformdiv #txtFldAsstSWFrmRmks').val(editCurRow.cells[8].childNodes[0].value);
}

function sftwfilldomval(RowId,table){
		table.rows[RowId].cells[3].childNodes[0].value = document.getElementById("txtFldAsstSWFrmName").value;
		table.rows[RowId].cells[4].childNodes[0].value = document.getElementById("txtFldAsstSWFrmCatrgy").value;
		table.rows[RowId].cells[5].childNodes[0].value = document.getElementById("txtFldAsstSWFrmLType").value;
		table.rows[RowId].cells[6].childNodes[0].value = document.getElementById("txtFldAsstSWFrmLKey").value;
		table.rows[RowId].cells[7].childNodes[0].value = document.getElementById("txtFldAsstSWFrmStatus").value;
		table.rows[RowId].cells[8].childNodes[0].value = document.getElementById("txtFldAsstSWFrmRmks").value;
}
 

function sftwMethods(dialogId,dataset,Opts,RowId,table){
	if(Opts == 'INS'){
		 sftwRdlyflds(CONSTANTS_VAR.INSERT_MODE);
			$('#'+dialogId).on('shown.bs.modal', function() { 
				  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
			           if(!valiSftwDetails())return;
			            sftwRdlyflds(CONSTANTS_VAR.INSERT_MODE);
			      		getsftwRows(dataset);
			      		sftwclearFlds();
						$('#'+dialogId).modal('hide'); 
				  }); 
		});
	}
	
	if(Opts == 'QRY/UPD'){
		$('#'+dialogId).on('shown.bs.modal', function() {   
			  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
			        if(!valiSftwDetails())return; 
			      		if(!isEmpty(RowId) && !(RowId==undefined)){ 
			      			
			      			sftwfilldomval(RowId,table); 
			      		}
			      		sftwclearFlds();
			      	  $("#swfreeformdiv :input").prop('readonly', false);  
					$('#'+dialogId).modal('hide'); 
			  });
	  }); 
	}
	
	
	

	if(Opts == 'INS/UPD'){
		
		$('#'+dialogId).on('shown.bs.modal', function() {   
			  $(this).find(".modal-footer").find("button:eq(0)").click(function (){  
	        	  if(!valiSftwDetails())return;  
		      		if(!isEmpty(RowId) && !(RowId==undefined)){  
		      			sftwfilldomval(RowId,table); 
		      		}  
		      		
					$('#'+dialogId).modal('hide'); 
					sftwclearFlds();
			  });
	  });  
	}//End of INS/UPD Options
	
	

	if(Opts == 'QRY'){ 
		$('#'+dialogId).on('shown.bs.modal', function() {   
			  $(this).find(".modal-footer").find("button:eq(0)").click(function (){  
	        	  sftwclearFlds();
	        	  $("#swfreeformdiv :input").prop('readonly', false); 
				  $('#'+dialogId).modal('hide'); 
					
			  });
	  });  
	}//End of INS/UPD Options 
}
function fnPdfReport()
{
	
	 	
	/*  var doc = new jsPDF() */
	 var doc= new jsPDF('l');
	var tbl     = document.getElementById('assetSoftwareTable'),
	    tblBody = tbl.tBodies[0],
	    tblLen  = tblBody.rows.length;
	 
	 if(tblLen <= 0)
		{
			showAlert(CONSTANTS_VAR.NO_ROWS_EXPORT);
			return;
		}
		
		
	
		if(tblLen > 0)
		{
			 var y=60;
			var row=0;
			for(var r=0;r<tblLen;r++){
				    
				    var chkbox = tblBody.rows[r].cells[1].childNodes[0];
				    
				    var mode = tblBody.rows[r].cells[2].childNodes[0].value;
				
					var softwareID  = tblBody.rows[r].cells[3].childNodes[0].value;					
				
					var softwarename  = tblBody.rows[r].cells[3].childNodes[1].value;					
			    
					var softwarwcatg  = tblBody.rows[r].cells[4].childNodes[0].value;					
				
					var softwarelicetyp  = tblBody.rows[r].cells[5].childNodes[0].value;					
			
					var softwarelicekey  = tblBody.rows[r].cells[6].childNodes[0].value;
					
					var softwarestatus  = tblBody.rows[r].cells[7].childNodes[0].value;
					
					var softwareremarks  = tblBody.rows[r].cells[8].childNodes[0].value;
		
					
		 doc.setFont("calibri");
		 doc.setFontType("bold");
         doc.setTextColor(100);	
         doc.setFontSize(10);
         var img = new Image();
         img.addEventListener('load', function() {
            
             doc.addImage(img, 'png', 9, 9);
         });
         img.src = 'images/logo_AVALLIS.png';
       
	    
	     
	     

	     doc.rect(10, 10, 275, 185);
	     doc.text(190,9, 'Avallis Asset Software Details');
	     doc.text(190,200,'PageNo-'+(r+1));
	     doc.setFontSize(20);
	     doc.text(100,20, 'Avallis Asset Details');
	     
	     doc.setFont("calibri");
         doc.setFontType("normal");
         doc.setTextColor(100);	
         doc.setFontSize(10);
	   
	     doc.setLineWidth(3.5);
	     doc.setDrawColor(1);
         doc.line(20, 30, 275, 30);
         doc.setLineWidth(0.3);
	   
	     doc.text(20,50, 'Software Id');
	     doc.text(50,50, 'Software Name');
	     doc.text(80,50, 'Software Catgry');
	     doc.text(110,50, 'License Type');
	     doc.text(140,50, 'License Key');
	     doc.text(180,50, 'License Status');
	     doc.text(210,50, 'Remarks');
	     doc.line(20,52, 275, 52);
	     
	           
	    		 while(row ==r)
	    			 {
	    		  doc.text(20,y, softwarename);
	   	          doc.text(50,y, softwareID);
	   		      doc.text(80,y, softwarwcatg); 
	   		      doc.text(110,y, softwarelicetyp);
	   		      doc.text(140,y, softwarelicekey);
	   		      doc.text(180,y, softwarestatus); 
	   		      doc.text(210,y, softwareremarks); 
	   		      doc.line(20,y+2, 275,y+2 );
	   		      y=y+10
	   		      row++;
	   		      
	    			 }
	    	  
			}
			
		}
	
		doc.save('AssetSoftware.pdf')

}
 