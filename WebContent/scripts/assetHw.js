/**
 *  Asset Hardware Details
 */
 

 
var selRowArr = [];

var HW_CATEGORY_VAR;
var  hw_categ_arr=[];
var HW_STATUS_VAR;
var hw_status_arr=[]; 
var hardwareTbl="";



function toolBarSrchFun()
{ 
	searchHwRecords();
} 

function toolBarSaveFun()
{
	assetCUDOpern();
} 
function assetCUDOpern()
{
//	var asstHWForm = document.assetForm;
//	var tbl = document.getElementById('assetHardwareTable');
//	var tblBody = tbl.tBodies[0];
//	tblLen = tblBody.rows.length;
//	assetForm.asset.value=tblLen; 
//	
//	$("select").attr("disabled",false);
//	asstHWForm.action = 'asstHdWareCUDOpern.do';
//	asstHWForm.submit();
	
	
	
	var asstHWForm = document.assetForm;
	var tbl = document.getElementById('assetHardwareTable');
	var tblBody = tbl.tBodies[0];
	tblLen = tblBody.rows.length;
	var cellCount = tbl.rows[0].cells.length;
	var setFlg=true;//records exist
	
	$("#assetHardwareTable tbody").find('tr.odd').each(function(){//only when no records founds
		showAlert(CONSTANTS_VAR.NO_ROWS); 
        setFlg=false;
        return;
    });
//	 if(tblLen <= 0)
//		{
//			showAlert(CONSTANTS_VAR.NO_ROWS);
//			return;
//		}//end of if
		
	 asstHWForm.asset.value=tblLen;
		var flag=false;
//		alert("tblLen=>"+tblLen);
//	if(!setFlg)
//		{
//		
//		showAlert("No Rows"+tblLen);
//		}
	
	if(setFlg)
		{
			for(var row=0;row<tblLen;row++)
				{
				
				  var assetCUDValidation=tblBody.rows[row].cells[2].childNodes[0].value;
				  if(assetCUDValidation == "U" || assetCUDValidation == "I" || assetCUDValidation == "D")
				  {
					flag=true;
				  }
				}//end of for
		}//end of if
	
	if(flag==true)
		{
//		$("select").attr("disabled",false);
		$("input,select").attr("disabled",false);
		asstHWForm.action = 'asstHdWareCUDOpern.do';
		asstHWForm.submit();
		}//end ofif
	
//	for(var editcell=3;editcell<tblLen;editcell++){
//		editCurRow.cells[editcell].childNodes[0].readOnly=true;
//		editCurRow.cells[editcell].childNodes[0].disabled=true;
//		
//	}
	
	
//var strHdMasterId = document.getElementById("txtFldAsstHDId").value;
//	
//	if(strHdMasterId == ""){
//		alert("Insert");
//		$("select").attr("disabled",false);
//		asstHWForm.action = "";
//		asstHWForm.submit();
//			
//	}else{
//		$("select").attr("disabled",false);
//		alert("Update");
//		asstHWForm.action = "";
//		asstHWForm.submit();
//	}
//	for(var editrow=0;editrow<tblLen;editrow++){
//		
//		
//		var editCurRow = tblBody.rows[editrow];
//		var mode = editCurRow.cells[2].childNodes[0].value;
//	    alert("mode=="+mode);
////		if(mode == U) { 
//		
//			
//			for(var editcell=3;editcell<cellCount;editcell++){
//				editCurRow.cells[editcell].childNodes[0].readOnly=false;
//				editCurRow.cells[editcell].childNodes[0].disabled=false;
//				
//			}
//			
////		}
//		
//	}
	
}//end of assetCUDOpern

function loadHWinit()
{
	$('#hwfreeformdiv').on('shown.bs.modal', function () {
	    $('#txtFldAsstHDFrmName').focus();
	}) 
	 
	 
	$('#successmsgdiv').delay(2000).fadeOut('blind');
	$("#side-menu").find("li a").removeClass("active")
	$("#liassethard").find("a").addClass("active");
	
//	showTooltip('btnFldAssHdAddRow','Add Row');
//	showTooltip('btnFldAssHdEditRow','Edit Row');
//	showTooltip('btnFldAssHdDelRow','Delete Row');
//	showTooltip('spnAsstHWExpand','Expand Row');
//	showTooltip('btnExportHWXls','Export XLS');
//	showTooltip('btnExportHWPdf','Export PDF'); 
	
	$("#btnFldAssHdAddRow").click(function(){ 
		hdwAddRow(null);
	});
	
	$("#btnFldAssHdEditRow").click(function(){ 
		//hdwEditRow();
		EditRow();
	});
	
	$("#btnFldAssHdDelRow").click(function(){ 
//		alert("btnFldAssHdDelRow");
		hdwDelRow();
	});
	
	$("#btnFldAssHdViewRow").click(function(){ 
		hdwViewRow();
	});
	
//	hardwareTbl=$("#assetHardwareTable").DataTable({ 
//		destroy: true,
//		  responsive: false,
//		  ordering: false,
//		  searching: false,
//		  scrollY:  "40vh",
//		  scrollX: true,
//		  scroller: false,
//		  scrollCollapse:false,
//		  paging:false,
//		  filter:false,
//		  info:true,
//		  dom: '<<"top" ip>flt>',
//		     oLanguage: {"sEmptyTable": 'No Records',"sInfoEmpty": 'No Records' },
//		  columnDefs: [ 
//		                  {"className": "dt-head-center text-center","orderable": false,"searchable": false}],        
//		         fnDrawCallback: function(oSettings) {
//		             if (oSettings._iDisplayLength > oSettings.fnRecordsDisplay()) {
//		                
//		                }
//
//		         },
//		}).draw();
	
	var hardwareTbl = $('#assetHardwareTable').DataTable( {
	    destroy: true,
	     responsive: false,
	    ordering: false,
	    searching: false,
	    scrollY:  "40vh",
	    scrollX: true,
	    scroller: false,
	    scrollCollapse:false,
	    paging:false,
	    filter:false,
	    columnDefs: [],
	    dom: '<<"top" ip>flt>',
	    oLanguage: {"sEmptyTable": 'No Records',"sInfoEmpty": 'No Records' }, 
	  columnDefs: [  { width: '50px', targets: [0,1,2]},
		  { width: '150px', targets: [2,3,4,5,6,7]},
	                   {"className": "dt-head-center text-center",targets: [0,1,2,3,4,5,6,7],"orderable": false,"searchable": false}],        
	       		    fnDrawCallback: function(oSettings) {
	       		        if (oSettings._iDisplayLength > oSettings.fnRecordsDisplay()) {
	       		            $(oSettings.nTableWrapper).find('.dataTables_paginate').hide(); 
	       		        } 
	       		        ctrlOverFlowDataTable('assetHardwareTable'); 
	       		    }
	}).draw();
	
	var hw_Catg_Type= HW_CATEGORY_VAR.substr(1,HW_CATEGORY_VAR.length-2);
	var hw_Catg_Split = hw_Catg_Type.split(",");
	
	 for(var hw_Catg_Loop=0;hw_Catg_Loop<hw_Catg_Split.length;hw_Catg_Loop++)
	 {
	  hw_categ_arr.push(trim(hw_Catg_Split[hw_Catg_Loop]))
   	 }//end of for 
 
	 var hwStatus=HW_STATUS_VAR.substr(1,HW_STATUS_VAR.length-2);
		var hwStatusplit = hwStatus.split(",");
		
		for(var hwStatusfor=0;hwStatusfor<hwStatusplit.length;hwStatusfor++)
		{
			hw_status_arr.push(trim(hwStatusplit[hwStatusfor]))
		}//end of for 
		
		$('#txtFldAsstHDFrmPurchaseDate').datepicker({dateFormat: 'dd/mm/yy'});
	    $("#txtFldAsstHDFrmWarrantyStartDate").datepicker({
	    	dateFormat: 'dd/mm/yy',
	    	numberOfMonths: 2,
	        onSelect: function(selected) {
	          $("#txtFldAsstHDFrmWarrantyEndDate").datepicker("option","minDate", selected)
	        }
	    });
	    
	    $("#txtFldAsstHDFrmWarrantyEndDate").datepicker({
	    	dateFormat: 'dd/mm/yy',
	        numberOfMonths: 2,
	        onSelect: function(selected) {
	           $("#txtFldAsstHDFrmWarrantyStartDate").datepicker("option","maxDate", selected)
	        }
	    });  
		
	    var oslist = [
	        "Windows 7",
	        "Windows 8",
	        "Windows 10",
	        "Ubuntu",
	        "macOs",
	        "Time Machine",
	        "IRIX",
	        "iOs",
	        "MS-DOS",
	        "BeOS",
	        "Unix shell",
	        "NEXTSTEP",
	     ];
	    $("#txtFldAsstHDFrmOperSys").autocomplete({ source: oslist });

            hideLoader();
		  //#txtFldAsstHDFrmOperSys
}



function ChkWarrantyEndDateValidation(startdate,enddate)
{
	  var WarrantySrtDate = $("#"+startdate).val();
	  var WarrantyEndDate = $("#"+enddate).val();
	  if(!isEmpty(WarrantySrtDate)&&!isEmpty(WarrantyEndDate))
		  {
	         WarrantySrtDate = WarrantySrtDate.split("/")[2] + "-" + WarrantySrtDate.split("/")[1] + "-" +  WarrantySrtDate.split("/")[0] ;
	         WarrantyEndDate = WarrantyEndDate.split("/")[2] + "-" +  WarrantyEndDate.split("/")[1] + "-" +  WarrantyEndDate.split("/")[0] ;
		
              var StartDate = new Date(WarrantySrtDate);
	            var EndDate = new Date(WarrantyEndDate);
	               if(EndDate < StartDate)
	                  {
	            	   alert("Warranty Start Date Should be lesser than Warranty End Date!");
	    	             $("#"+enddate).val("");
	                  } 
	                
	     }
	  return false;
}


function fnExcelReport()
{
	showLoader()//shows loader  
	var strhdname = $('#txtFldSrchHDName').val();
 	var strhdModel = $('#txtFldSrchHDModel').val();
 	var strallotTo = $('#txtFldSrchHDAttotTo').val();
 	var param = 'hActionType=EXPSEARCH'+ 
     '&txtFldSrchHDName='+encodeURIComponent(strhdname)
     +'&txtFldSrchHDModel='+encodeURIComponent(strhdModel)+
     '&txtFldSrchHDAttotTo='+encodeURIComponent(strallotTo)+"&"+$('#assetForm').serialize();
 	
 	window.open(urlPath+"/AssetDetails?"+param,'_new');
	
 	hideLoader();
	/*var data = assetAjax(param); 
	for ( var tab in data) {
		

		if (data.hasOwnProperty(tab)) {
		 
			var key = tab;
			var value = data[tab];
				// gethdwRows(value);
		}
	}*/
	
	
//	var ExportForm = document.assetForm;
//	ExportForm.action = 'asstHdWareExportOpern.do';
//	ExportForm.submit();
	}

function searchHwRecords()
{  
	showLoader()//shows loader  
	clearRecords('assetHardwareTable'); 
	
	var strhdname = $('#txtFldSrchHDName').val();
	var strhdModel = $('#txtFldSrchHDModel').val();
	var strallotTo = $('#txtFldSrchHDAttotTo').val();

	 
 
	if( isEmptyFld(strhdname) && isEmptyFld(strhdModel)  && isEmptyFld(strallotTo) ){
		showAlert(CONSTANTS_VAR.SEL_ANYSRCH_CRIT,$('#txtFldSrchHDName'));  
		hideLoader();
		return;
		
	}//end of if
			   
	var param = 'hActionType=SEARCH'+ 
		        '&txtFldSrchHDName='+encodeURIComponent(strhdname)
		        +'&txtFldSrchHDModel='+encodeURIComponent(strhdModel)+
	            '&txtFldSrchHDAttotTo='+encodeURIComponent(strallotTo);
	  
	var data = assetAjax(param); 
	for ( var tab in data)
	{
		

		if (data.hasOwnProperty(tab)) {
		 
			var key = tab;
			var value = data[tab];
				 gethdwRows(value);
		}
	}
//hideLoader();
}//end of searchRecords


function hdwAddRow(dataset)
{
//	alert("hdwAddRow");
	hdwclearFlds();
	 showAssetModel('hwfreeformdiv','Asset Hardware Details'); 
	 hdwMethods('hwfreeformdiv',dataset,'INS','','');   

}//end of hdwAddRow



function gethdwRows(dataset){
	
//	alert(JSON.stringify(dataset));
//
	$("#assetHardwareTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	var tbl = document.getElementById('assetHardwareTable'),
	tblBody = tbl.tBodies[0],
    len = tblBody.rows.length;
	
var row = tblBody.insertRow(len);
if(len<1){
	
	   removeInfoError('assetHardwareTable');
	  
}

var cell0 = row.insertCell(0);
cell0.innerHTML = '<input type="text" name="txtFldAsstHDSlno" id="txtFldAsstHDSlno" readonly="readonly" value="'+(len+1)+'" class="writableFieldDHTML" />';
cell0.childNodes[0].style.textAlign = 'center';  

var cell1 = row.insertCell(1);
cell1.innerHTML = '<img src="images/AssetHardwareIcon.png"  align="center" width="1px" id="openHardwaredetail"   onclick="myFunctionMastrSrch(this);" />'+'<input type="checkbox" name="radAsstHDSelect" id="radAsstHDSelect"  class="writableFieldDHTML"  onclick="selectRowFun(this);"/>'+'<input type="hidden" id="hSelRow" name="hSelRow" value="'+len+'">';
//cell1.innerHTML = '<img src="styles/images/searchIcon.png" width="30%" id="openHardwaredetail" title="Click To View Vendor Details"  onclick="myFunctionMastrSrch(this)" /><input type="hidden" name="txtFldAsstHDMastrId" id="txtFldAsstHDMastrId"  value="'+ chkNull(responce[asset]["txtFldAsstHDMastrId"])+ '" />';
cell1.childNodes[0].style.textAlign = 'center';
cell1.childNodes[1].style.textAlign = 'center';

var cell2 = row.insertCell(2);
cell2.innerHTML = '<input type="text" name="txtFldAsstHDMode" id="txtFldAsstHDMode" readonly="readonly" value="'+CONSTANTS_VAR.INSERT_MODE+'" class="writableFieldDHTML" />';
cell2.childNodes[0].style.textAlign = 'center';
 

//var cell3 = row.insertCell(3);
//cell3.innerHTML = '<img src="styles/images/searchIcon.png" width="30%" id="openHardwaredetail" title="Click To View Hardware Details"  onclick="myFunctionMastrSrch(this);" /><input type="hidden" name="txtFldAsstHDMastrId" id="txtFldAsstHDMastrId"  />';
//cell3.childNodes[0].style.margin = '0  0 0 32px'; 

var cell3 = row.insertCell(3);
cell3.innerHTML = '<input type="text" name="txtFldAsstHDName" id="txtFldAsstHDName"  value=""   onmouseover="assetTooltip(this);" maxlength="60" class="writableFieldDHTML" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDId" id="txtFldAsstHDId"  maxlength="30" value="" class="writableFieldDHTML"  />';
//'<input type="hidden" name="txtFldAsstHDAssdName" id="txtFldAsstHDAssdName" maxlength="30" value="" class="writableFieldDHTML" />';
cell3.childNodes[0].value = document.getElementById("txtFldAsstHDFrmName").value; 

var cell4 = row.insertCell(4);
cell4.innerHTML = '<input type="text" name="txtFldAsstHDMake" id="txtFldAsstHDMake" value="" maxlength="30" onmouseover="assetTooltip(this);" class="writableFieldDHTML" readonly="true"/>';
cell4.childNodes[0].value = document.getElementById("txtFldAsstHDFrmMake").value; 


var cell5= row.insertCell(5);
cell5.innerHTML = '<input type="text" name="txtFldAsstHDModel" id="txtFldAsstHDModel" value="" maxlength="30" onmouseover="assetTooltip(this);" class="writableFieldDHTML" readonly="true"/>';
cell5.childNodes[0].value = document.getElementById("txtFldAsstHDFrmModel").value; 


var cell6 = row.insertCell(6);
cell6.innerHTML = '<input type="text" name="txtFldAsstHDSerlNo" id="txtFldAsstHDSerlNo" value="" maxlength="30"  onmouseover="assetTooltip(this);"  class="writableFieldDHTML" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDMacId" id="txtFldAsstHDMacId" value="" maxlength="30"  onmouseover="assetTooltip(this);"  class="writableFieldDHTML" readonly="true"/>';
cell6.childNodes[0].value = document.getElementById("txtFldAsstHDFrmSerlNo").value; 
cell6.childNodes[1].value = document.getElementById("txtFldAsstHDFrmMACId").value; 


var cell7 = row.insertCell(7);
cell7.innerHTML = '<input type="text" name="txtFldAsstHDAllotTo" id="txtFldAsstHDAllotTo" value=""  maxlength="60" onmouseover="assetTooltip(this);" class="writableFieldDHTML" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDOperSys" id="txtFldAsstHDOperSys" value="" maxlength="30"  onmouseover="assetTooltip(this);"  class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDOperSysver" id="txtFldAsstHDOperSysver" value="" maxlength="30"  onmouseover="assetTooltip(this);"  class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDProssr" id="txtFldAsstHDProssr" value=""   onmouseover="assetTooltip(this);" maxlength="60" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDProssrSpd" id="txtFldAsstHDProssrSpd" value="" maxlength="30" onmouseover="assetTooltip(this);" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDRAM" id="txtFldAsstHDRAM" value="" maxlength="10" onmouseover="assetTooltip(this);" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDD" id="txtFldAsstHDD" value="" maxlength="10" onmouseover="assetTooltip(this);" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDDPartitions" id="txtFldAsstHDDPartitions" value="" onmouseover="assetTooltip(this);" maxlength="10" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDWarrantyStatusDescription" id="txtFldAsstHDWarrantyStatusDescription" value="" onmouseover="assetTooltip(this);" maxlength="10" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDCpuSockets" id="txtFldAsstHDCpuSockets" value="" onmouseover="assetTooltip(this);" maxlength="10" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDTotCores" id="txtFldAsstHDTotCores" value="" onmouseover="assetTooltip(this);" maxlength="10" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDLogProcess" id="txtFldAsstHDLogProcess" value="" onmouseover="assetTooltip(this);" maxlength="10" class="" readonly="true"/>'+

'<input type="hidden" name="txtFldAsstHDLocID" id="txtFldAsstHDLocID" value="" maxlength="30" onmouseover="assetTooltip(this);" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDRmks" id="txtFldAsstHDRmks" value="" maxlength="500" onmouseover="assetTooltip(this);" class="" readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDPartNo" id="txtFldAsstHDPartNo" value="" maxlength="30" onmouseover="assetTooltip(this);" class="" readonly="true"/>'+
'<select name="txtFldAsstHDCateg" id="txtFldAsstHDCateg" onmouseover="assetTooltip(this);" style="display:none;font:calibri"  > </select>'+
'<select name="txtFldAsstHDStatus" id="txtFldAsstHDStatus" onmouseover="assetTooltip(this);" style="display:none;font:calibri"  > </select>'+
'<input type="hidden" name="txtFldAsstHDPurchaseDate" id="txtFldAsstHDPurchaseDate" value="" onmouseover="assetTooltip(this);" maxlength="10"  class=""  readonly="true"/>'+
'<input type="hidden" name="txtFldAsstHDWarrantyStartDate" id="txtFldAsstHDWarrantyStartDate" value="" maxlength="10" onmouseover="assetTooltip(this);" onblur="validateDate(this);" class="" readonly="true" />'+
'<input type="hidden" name="txtFldAsstHDWarrantyEndDate" id="txtFldAsstHDWarrantyEndDate" value="" maxlength="10" onmouseover="assetTooltip(this);" onblur="validateDate(this);" class="" readonly="true" />'+
'<input type="hidden" name="txtFldAsstHDServCatg" id="txtFldAsstHDServCatg" value="" maxlength="10" onmouseover="assetTooltip(this);"  class="" readonly="true" />'+
'<input type="hidden" name="txtFldAsstHDIPNo" id="txtFldAsstHDIPNo" value="" maxlength="10" onmouseover="assetTooltip(this);"  class="" readonly="true" />';

cell7.childNodes[0].value = document.getElementById("txtFldAsstHDFrmAllotTo").value;
cell7.childNodes[1].value = document.getElementById("txtFldAsstHDFrmOperSys").value;
cell7.childNodes[2].value = document.getElementById("txtFldAsstHDFrmOperSysver").value; 
cell7.childNodes[3].value = document.getElementById("txtFldAsstHDFrmProssr").value; 
cell7.childNodes[4].value = document.getElementById("txtFldAsstHDFrmProssrSpd").value; 
cell7.childNodes[5].value = document.getElementById("txtFldAsstHDFrmRAM").value; 
cell7.childNodes[6].value = document.getElementById("txtFldAsstHDFrmHDD").value; 
cell7.childNodes[7].value = document.getElementById("txtFldAsstHDFrmHDDPartitions").value; 


cell7.childNodes[8].value = document.getElementById("txtFldAsstHDFrmWarrantyStatusDescription").value; 
cell7.childNodes[9].value = document.getElementById("txtFldAsstHDFrmCpuSockets").value; 
cell7.childNodes[10].value = document.getElementById("txtFldAsstHDFrmTotCores").value; 
cell7.childNodes[11].value = document.getElementById("txtFldAsstHDFrmLogProcess").value; 

cell7.childNodes[12].value = document.getElementById("txtFldAsstHDFrmLocID").value; 
cell7.childNodes[13].value = document.getElementById("txtFldAsstHDFrmRmks").value; 
cell7.childNodes[14].value = document.getElementById("txtFldAsstHDFrmPartNo").value; 


var cnt=0;
cell7.childNodes[15].options[cnt]=  new Option("--select--","");

for(var st=0;st<hw_categ_arr.length;st++)
{ 
	//showAlert("st"+st);
	cnt=cell7.childNodes[15].options.length;
	cell7.childNodes[15].options[cnt++]=  new Option(hw_categ_arr[st],hw_categ_arr[st]);
	
}//end of for
cell7.childNodes[15].value = document.getElementById("txtFldAsstHDFrmCateg").value; 


var cnt=0;
cell7.childNodes[16].options[cnt]=  new Option("--select--","");

for(var st=0;st<hw_status_arr.length;st++)
{ 
	//showAlert("st"+st);
	cnt=cell7.childNodes[16].options.length;
	cell7.childNodes[16].options[cnt++]=  new Option(hw_status_arr[st],hw_status_arr[st]);
	
}//end of for
cell7.childNodes[16].value = document.getElementById("txtFldAsstHDFrmStatus").value; 
cell7.childNodes[17].value = document.getElementById("txtFldAsstHDFrmPurchaseDate").value; 
cell7.childNodes[18].value = document.getElementById("txtFldAsstHDFrmWarrantyStartDate").value; 
cell7.childNodes[19].value = document.getElementById("txtFldAsstHDFrmWarrantyEndDate").value; 
cell7.childNodes[20].value = document.getElementById("txtFldAsstHDFrmServCateg").value; 
cell7.childNodes[21].value = document.getElementById("txtFldAsstHDFrmIP").value; 


//alert(document.getElementById("txtFldAsstHDFrmServCateg").value);
//alert(document.getElementById("txtFldAsstHDFrmIP").value);

//alert(cell7.childNodes[20].value);
//alert(cell7.childNodes[21].value);
//cell3.childNodes[0].focus();

if(dataset != null){

			 cell2.childNodes[0].value = "Q";
			 
			
	var infoDetsArr = new Array();
	
	for(var data in dataset){
		var col = dataset[data];
		
		//console.log("data="+data+"/col="+col)
		
		
		
		switch(data){
			case "txtFldAsstHDName":
				cell3.childNodes[0].value=col;
				break;
				
			case "txtFldAsstHDId":
				cell3.childNodes[1].value=col;
				break;
				
//			case "txtFldAsstHDAssdName":
//				cell3.childNodes[2].value=col;
//				break;
//				 
				
			case "txtFldAsstHDMake":
				cell4.childNodes[0].value=col;
				cell4.childNodes[0].readOnly=true;
				break;
				
			case "txtFldAsstHDModel":
				cell5.childNodes[0].value=col;
				cell5.childNodes[0].readOnly=true;
				break;
				
			case "txtFldAsstHDSerlNo":
				cell6.childNodes[0].value=col;
				cell6.childNodes[0].readOnly=true;
				break;
				
				
			case "txtFldAsstHDMacId":
				cell6.childNodes[1].value=col;
				cell6.childNodes[1].readOnly=true;
				break;
				
				
				
			case "txtFldAsstHDAllotTo":
				cell7.childNodes[0].value=col;
			    cell7.childNodes[0].readOnly=true;
				break;
				
			case "txtFldAsstHDOperSys":
				cell7.childNodes[1].value=col;
			    cell7.childNodes[1].readOnly=true;
				break;
				
			case "txtFldAsstHDOperSysver":
				cell7.childNodes[2].value=col;
				cell7.childNodes[2].readOnly=true;
				break;
				
			case "txtFldAsstHDProssr":
				cell7.childNodes[3].value=col;
				cell7.childNodes[3].readOnly=true;
				break;
				
				
			case "txtFldAsstHDProssrSpd":
				cell7.childNodes[4].value=col;
				cell7.childNodes[4].readOnly=true;
				break;
				
			case "txtFldAsstHDRAM":
				cell7.childNodes[5].value=col;
				cell7.childNodes[5].readOnly=true;
				break;
				
				
			case "txtFldAsstHDD":
				cell7.childNodes[6].value=col;
				cell7.childNodes[6].readOnly=true;
				break;
				
				
			case "txtFldAsstHDDPartitions":
				cell7.childNodes[7].value=col;
				cell7.childNodes[7].readOnly=true;
				break;
				
			case "txtFldAsstHDWarrantyStatusDescription":
				cell7.childNodes[8].value=col;
				cell7.childNodes[8].readOnly=true;
				break;
				
			case "txtFldAsstHDCpuSockets":
				cell7.childNodes[9].value=col;
				cell7.childNodes[9].readOnly=true;
				break;
				
			case "txtFldAsstHDTotCores":
				cell7.childNodes[10].value=col;
				cell7.childNodes[10].readOnly=true;
				break;
				
				
			case "txtFldAsstHDLogProcess":
				cell7.childNodes[11].value=col;
				cell7.childNodes[11].readOnly=true;
				break;
			
			case "txtFldAsstHDLocID":
				cell7.childNodes[12].value=col;
				cell7.childNodes[12].readOnly=true;
				break;
				
				
				
			case "txtFldAsstHDRmks":
				cell7.childNodes[13].value=col;
				cell7.childNodes[13].readOnly=true;
				break;
				
				
			case "txtFldAsstHDPartNo":
				cell7.childNodes[14].value=col;
				cell7.childNodes[14].readOnly=true;
				break;
				
			case "txtFldAsstHDPurchaseDate":
				cell7.childNodes[17].value=col;
				cell7.childNodes[17].readOnly=true;
				break;
				
			case "txtFldAsstHDWarrantyStartDate":
				cell7.childNodes[18].value=col;
				cell7.childNodes[18].readOnly=true;
				break;
				
			case "txtFldAsstHDWarrantyEndDate":
				cell7.childNodes[19].value=col;
				cell7.childNodes[19].readOnly=true;
				break;
			case "txtFldAsstHDServCatg":
				cell7.childNodes[20].value=col;
				cell7.childNodes[20].readOnly=true;
				break;
			case "txtFldAsstHDIPNo":
				cell7.childNodes[21].value=col;
				cell7.childNodes[21].readOnly=true;
				break;
				
		}
		removeInfoError('assetHardwareTable');
      }
	}
 
//else{
//	alert("No Records Found");
//}



}//end gethdwRows

//function selectRowhwFun(chkObj)
//{
//	
//	if(chkObj.checked)
//	{
//		alert("select");
//		selRowArr.push(chkObj.parentNode.childNodes[2].value) ; 
//	}//end of id
//	
//}//end of selectRowFun

function myFunctionMastrSrch(id) {
	
	//	MastervendorId=id.value;
var td=id.parentNode;//td
var tr=td.parentNode//tr
var MasterHarwareId= tr.cells[3].childNodes[1].value;
//alert(MasterHarwareId);

var chkbox = tr.cells[1].childNodes[1];
chkbox.checked = true;

//if(null != chkbox && true == chkbox.checked) {
//	alert("Checked");
//	
//	
//}
hdwEditRow();
//alert("param");
var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(MasterHarwareId);

var data = assetAjax(param);// assetAjax function call
//hdwAddRow(null);
populateAssetHardwareTbl(data);



//navToVendor();
}// end of myFunction()

function populateAssetHardwareTbl(responce) {
//	alert("populateAssetHardwareTbl ");
	var retval = responce;
	
	for ( var val in retval) {
		
		var tabdets = retval[val];
//		showAlert(tabdets)
		
		for ( var tab in tabdets) {
			
			if (tabdets.hasOwnProperty(tab)) {
				
				var key = tab;
				var value = tabdets[tab];
				
//         	showAlert(key + " = " +value);
				if(key == "MASTER_HARDWARE_DETAILS"){
				
					for ( var formfield in value) {
						
						if (value.hasOwnProperty(formfield)) {							
							var fieldvalue = value[formfield];	
//							showAlert(""+fieldvalue);
//							showAlert("formfield"+formfield);
							document.getElementById(formfield).value=fieldvalue;
						}
					}
				}//end of if key == "MASTER_VENDOR_DETAILS"
			
			}
			
			
			
		}//end of for 
		
	}//end of for 
	
}// end of populateAssetVendorTbl

function hdwEditRow(){


	$("#assetHardwareTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById('assetHardwareTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetHardwareTable").find("input[type=checkbox]:checked").length;
	//alert("checkedlen=============="+checkedlen)
	//alert("rowCount=============="+rowCount)
	var editFlag = 0;
	
	if(rowCount<1){
		showAlert("Insert rows before edit!");
		return;
	} 
	for(var edit=0;edit<rowCount;edit++){
		
		var row = tbody.rows[edit];
		var chkbox = row.cells[1].childNodes[1];
		 
		if(null != chkbox && true == chkbox.checked) { 
			if(checkedlen ==1 ){
				//alert("check");
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
		
		var chkbox = editCurRow.cells[1].childNodes[1];
		//alert("chkbox"+chkbox)
		var mode = editCurRow.cells[2].childNodes[0].value;
		//alert("mode"+mode)
		if(null != chkbox && true == chkbox.checked) { 
		
			if(mode == CONSTANTS_VAR.QUERY_MODE  || mode == CONSTANTS_VAR.UPDATE_MODE){
				
			//	hdwclearFlds();
				var RowId=editCurRow.cells[0].childNodes[0].value;		
				 
				
				editCurRow.cells[2].childNodes[0].value = CONSTANTS_VAR.UPDATE_MODE;
				chkbox.checked = false;
				 
				
				hdwclearFlds();
		        hdwRdlyflds(CONSTANTS_VAR.UPDATE_MODE);
		        hdwfilldlgval(editCurRow);
		        
			   	showAssetModel('hwfreeformdiv','Asset Hardware Details'); 
				hdwMethods('hwfreeformdiv','','QRY/UPD',RowId,table);
				  
			}// Q Mode
			
			
			
			for(var editcell=3;editcell<cellCount;editcell++){
				editCurRow.cells[editcell].childNodes[0].readOnly=true;
				editCurRow.cells[editcell].childNodes[0].disabled=true;
				
				if(editCurRow.cells[editcell].childNodes[2]){					
					if(editCurRow.cells[editcell].childNodes[2].tagName.toLowerCase() == 'img'){
						editCurRow.cells[editcell].childNodes[1].value=CONSTANTS_VAR.UPDATE_MODE;
					}
				}
				
			}
			
			 
		}
		
		
	}
}// end  



function EditRow(){
	//alert("Second Edit");

	$("#assetHardwareTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById('assetHardwareTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetHardwareTable").find("input[type=checkbox]:checked").length;
	
	//alert("checkedlen=============="+checkedlen)
	//alert("rowCount=============="+rowCount)
	
	var editFlag = 0;
	var CountFlag =1;
	if(rowCount<1){
		showAlert("Insert rows before edit!");
		return;
	} 
	for(var edit=0;edit<rowCount;edit++){
		
		var row = tbody.rows[edit];
		var chkbox = row.cells[1].childNodes[1];
		 var id=row.cells[3].childNodes[1].value;
		
			
		if(null != chkbox && true == chkbox.checked) { 
			if(checkedlen ==1 ){
				
		       editFlag = 1;
		      
			}
//			if(checkedlen >1 ){
//				alert(checkedlen);
//				showAlert("Only single row to be selected!");
//				for(var edit=0;edit<rowCount;edit++){
//					
//					var row = tbody.rows[edit];
//					var chkbox = row.cells[1].childNodes[1];
//					chkbox.checked = false;
//					
//				}
//			}
		}
	 
	}
	if(!editFlag){
		showAlert("Single row to be selected");
		for(var edit=0;edit<rowCount;edit++){
			
			var row = tbody.rows[edit];
			var chkbox = row.cells[1].childNodes[1];
			chkbox.checked = false;
			
		}
		return;
	}
	
	
//	if(!editFlag){
//		
//		showAlert("Select a row to edit!");
//		return;
//	}	
	
	for(var editrow=0;editrow<rowCount;editrow++){
		

		var editCurRow = tbody.rows[editrow];
		
		var chkbox = editCurRow.cells[1].childNodes[1];
		//alert("chkbox"+chkbox)
		var mode = editCurRow.cells[2].childNodes[0].value;
		
	//	var id=row.cells[3].childNodes[1].value;
		
		if(null != chkbox && true == chkbox.checked) { 
		
			if(mode == CONSTANTS_VAR.QUERY_MODE  || mode == CONSTANTS_VAR.UPDATE_MODE){
				

				var RowId=editCurRow.cells[0].childNodes[0].value;	
				var id=editCurRow.cells[3].childNodes[1].value;
			//	alert("RowId=============="+id);
				
				editCurRow.cells[2].childNodes[0].value = CONSTANTS_VAR.UPDATE_MODE;
				chkbox.checked = false;
				
			
				
		        hdwRdlyflds(CONSTANTS_VAR.UPDATE_MODE);
		        hdwfilldlgval(editCurRow);
		        
			   	showAssetModel('hwfreeformdiv','Asset Hardware Details'); 
			   	$('#myModal').off("hidden.bs.modal").on('hidden.bs.modal', function () {
			   	 $(this).find("input:text").val("");
			   	})
				hdwMethods('hwfreeformdiv','','QRY/UPD',RowId,table);
				var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
				var data = assetAjax(param);// assetAjax function call
				populateAssetHardwareTbl(data);
			}// Q Mode
			
			
			
//			for(var editcell=3;editcell<cellCount;editcell++){
//				editCurRow.cells[editcell].childNodes[0].readOnly=false;
//				editCurRow.cells[editcell].childNodes[0].disabled=false;
//				
//				if(editCurRow.cells[editcell].childNodes[2]){					
//					if(editCurRow.cells[editcell].childNodes[2].tagName.toLowerCase() == 'img'){
//						editCurRow.cells[editcell].childNodes[1].value=CONSTANTS_VAR.UPDATE_MODE;
//					}
//				}
//				
//			}
			
			 
		}
		
		
	}
}// end  

function hdwViewRow(){

	$("#assetHardwareTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById('assetHardwareTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetHardwareTable").find("input[type=checkbox]:checked").length;
	
	var editFlag = 0;
	
	if(rowCount<1){
		
		showAlert("Insert rows before view!");
		return;
	}
	
	for(var edit=0;edit<rowCount;edit++){
		
		var row = tbody.rows[edit];
		var chkbox = row.cells[1].childNodes[1];

		if(null != chkbox && true == chkbox.checked) {
			if(checkedlen ==1){
		        editFlag = 1;
			}
		}
	}
	
	if(!editFlag){
		//showAlert("Select a row to view!");
		//showAlert("Only single row to be selected!");
		showAlert("Single row to be selected");
		//chkbox.checked = false;
		for(var edit=0;edit<rowCount;edit++){
			
			var row = tbody.rows[edit];
			var chkbox = row.cells[1].childNodes[1];
			chkbox.checked = false;
			
		}
		return;
	}	
	
	for(var editrow=0;editrow<rowCount;editrow++){
		
		var editCurRow = tbody.rows[editrow];
		
		var chkbox = editCurRow.cells[1].childNodes[1];
		
		var mode = editCurRow.cells[2].childNodes[0].value;
		
		if(null != chkbox && true == chkbox.checked) {
			
				if((mode == CONSTANTS_VAR.INSERT_MODE) || (mode == CONSTANTS_VAR.UPDATE_MODE) ){
					 var RowId=editCurRow.cells[0].childNodes[0].value;		
					 
						editCurRow.cells[2].childNodes[0].value = mode;
						chkbox.checked = false;
						hdwRdlyflds(mode);
						hdwfilldlgval(editCurRow);
						showAssetModel('hwfreeformdiv','Asset Hardware Details'); 
						hdwMethods('hwfreeformdiv','','INS/UPD',RowId,table);
//						var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
//						var data = assetAjax(param);// assetAjax function call
//						populateAssetHardwareTbl(data);
				 
			}// I/U Mode
				if( (mode == CONSTANTS_VAR.UPDATE_MODE) ){
					 	
					 var RowId=editCurRow.cells[0].childNodes[0].value;		
					 var id=editCurRow.cells[3].childNodes[1].value;
						editCurRow.cells[2].childNodes[0].value = mode;
						chkbox.checked = false;
						hdwRdlyflds(mode);
						hdwfilldlgval(editCurRow);
						showAssetModel('hwfreeformdiv','Asset Hardware Details'); 
						hdwMethods('hwfreeformdiv','','INS/UPD',RowId,table);
						var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
						var data = assetAjax(param);// assetAjax function call
						populateAssetHardwareTbl(data);
				 
			}// I/U Mode
			
			if(mode == CONSTANTS_VAR.QUERY_MODE){
				 var RowId=editCurRow.cells[0].childNodes[0].value;		
				 var id=editCurRow.cells[3].childNodes[1].value;
				 editCurRow.cells[2].childNodes[0].value = mode;
				 chkbox.checked = false;
				 hdwRdlyflds(mode);
				 hdwfilldlgval(editCurRow);
				 showAssetModel('hwfreeformdiv','Asset Hardware Details'); 
				 hdwMethods('hwfreeformdiv','','QRY',RowId,table);
				 var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
					var data = assetAjax(param);// assetAjax function call
					populateAssetHardwareTbl(data);
				   
			}// Q Mode
			
		}
		}
	
}



function hdwDelRow(){
	//alert("delete");


	
	var table = document.getElementById('assetHardwareTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetHardwareTable").find("input[type=checkbox]:checked").length;
	var editFlag = false;
	//alert("checkedlen=="+checkedlen);
	if(rowCount<1){
		showAlert("Insert rows before Delete!");
		return;
	} 
	for(var edit=0;edit<rowCount;edit++){
		//alert(" rowCount=============="+rowCount)
		var row = tbody.rows[edit];
		var chkbox = row.cells[1].childNodes[1];
		var mode = row.cells[2].childNodes[0].value;
		if(null != chkbox && true == chkbox.checked) { 
//			if(checkedlen ==1 ){
//			//alert("if conditin=============="+checkedlen)
//		       editFlag = 1;
//			}
			if(mode == CONSTANTS_VAR.QUERY_MODE ){
			row.cells[2].childNodes[0].value = CONSTANTS_VAR.DELETE_MODE;
			chkbox.checked = false;
			
			}
			if(mode == CONSTANTS_VAR.INSERT_MODE ){
				for(var editrow=0;editrow<rowCount;editrow++){
					var editCurRow = tbody.rows[editrow];
					
					var chkbox = editCurRow.cells[1].childNodes[1];
					
					var mode = editCurRow.cells[2].childNodes[0].value;
			
					if(null != chkbox && true == chkbox.checked) { 
					
					var RowId=editCurRow.cells[0].childNodes[0].value;	
							var id=editCurRow.cells[3].childNodes[1].value;
							
						if(id == "" ){
							tbody.deleteRow(editrow);
							if(isValidObject(document.getElementById('hSelectRow'))){
								document.getElementById('hSelectRow').value = '';
							}
							rowCount--;
							editrow--;
							
					       
						}
						
			
						 
					}
					
					
				}
				//reorderTableRows('assetHardwareTable',true);
				}
			reorderTableRows('assetHardwareTable',true);
			editFlag = true;
		}
	 
	}
	if(rowCount<1){
		showInfoError('assetHardwareTable');
	}
	//alert("if editFlag=============="+editFlag)
	if(!editFlag){
		//alert("editFlag--"+editFlag)
		showAlert("Select a row to Delete!");
//		for(var edit=0;edit<rowCount;edit++){
//			
//			var row = tbody.rows[edit];
//			var chkbox = row.cells[1].childNodes[1];
//			chkbox.checked = false;
//			
//		}
		return;
	}	
	
	for(var editrow=0;editrow<rowCount;editrow++){
		

		var editCurRow = tbody.rows[editrow];
		
		var chkbox = editCurRow.cells[1].childNodes[1];
		//alert("chkbox"+chkbox)
		var mode = editCurRow.cells[2].childNodes[0].value;
//		alert("mode"+mode)
		if(null != chkbox && true == chkbox.checked) { 
		
			if(mode == CONSTANTS_VAR.QUERY_MODE ){
				
				//alert("mode========="+mode)
				var RowId=editCurRow.cells[0].childNodes[0].value;		
				 
				
				editCurRow.cells[2].childNodes[0].value = CONSTANTS_VAR.DELETE_MODE;
				chkbox.checked = false;
				 
				  
			}// Q Mode
			
			
				if(mode == CONSTANTS_VAR.INSERT_MODE ){
					//alert("mode=1=="+mode)
					for(var editrow=0;editrow<rowCount;editrow++){
						var editCurRow = tbody.rows[editrow];
						
						var chkbox = editCurRow.cells[1].childNodes[1];
						
						var mode = editCurRow.cells[2].childNodes[0].value;
					//	alert("mode=2=="+mode)
					//	var id=row.cells[3].childNodes[1].value;
						
						if(null != chkbox && true == chkbox.checked) { 
						//	alert("checked==="+chkbox)
						var RowId=editCurRow.cells[0].childNodes[0].value;	
								var id=editCurRow.cells[3].childNodes[1].value;
								//alert("RowId=============="+id);
							if(id == "" ){
								

								//alert("if comndition=============="+id);
							
								
							//	editCurRow.cells[2].childNodes[0].value = CONSTANTS_VAR.UPDATE_MODE;
							//	chkbox.checked = false;
								
								tbody.deleteRow(editrow);
								if(isValidObject(document.getElementById('hSelectRow'))){
									document.getElementById('hSelectRow').value = '';
								}
								rowCount--;
								editrow--;
								
						       
							}// Q Mode
							
				
							 
						}
						
						
					}
		
				  
			}// Q Mode
//			
				reorderTableRows('assetHardwareTable',true);
			 
		}
		
		
	}
	
}















function hdwclearFlds(){
	$("#hwfreeformdiv").find("input[type=text]").val("");
	$("#hwfreeformdiv").find("textarea").val("");
	$("#hwfreeformdiv").find("select").val("");      
}


function hdwRdlyflds(mode){
	 
	if(mode == CONSTANTS_VAR.QUERY_MODE){
		 $("#hwfreeformdiv :input").prop('disabled', true);  
	}else if((mode == CONSTANTS_VAR.INSERT_MODE) || (mode == CONSTANTS_VAR.UPDATE_MODE) ){
		  $("#hwfreeformdiv :input").prop('disabled', false); 
		}
	
	$("#hwfreeformdiv").find(".modal-footer").find("button:eq(0)").attr("disabled",false);
	$("#hwfreeformdiv").find(".modal-footer").find("button:eq(1)").attr("disabled",false);
}


function valiHdwDetails(){
	
	if(!chkModelMandatory($("#hwfreeformdiv #txtFldAsstHDFrmName"), CONSTANTS_VAR.KEYIN_HRDWRE_NAME))return;
	//if(!chkModelMandatory($("#hwfreeformdiv #txtFldAsstHDFrmMake"), CONSTANTS_VAR.KEYIN_PROSSR_NAME))return;
	if(!chkModelMandatory($("#hwfreeformdiv #txtFldAsstHDFrmSerlNo"), CONSTANTS_VAR.KEYIN_SERIAL_NO))return;
	if(!chkModelMandatory($("#hwfreeformdiv #txtFldAsstHDFrmOperSys"), CONSTANTS_VAR.KEYIN_OS))return;
	
	return true;
		
}

function hdwfilldlgval(editCurRow){

//alert("test");
		
		  $('#hwfreeformdiv #txtFldAsstHDFrmId').val(editCurRow.cells[3].childNodes[1].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmName').val(editCurRow.cells[3].childNodes[0].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmMake').val(editCurRow.cells[4].childNodes[0].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmModel').val(editCurRow.cells[5].childNodes[0].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmSerlNo').val(editCurRow.cells[6].childNodes[0].value);
	 	  $('#hwfreeformdiv #txtFldAsstHDFrmMACId').val(editCurRow.cells[6].childNodes[1].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmAllotTo').val(editCurRow.cells[7].childNodes[0].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmOperSys').val(editCurRow.cells[7].childNodes[1].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmOperSysver').val(editCurRow.cells[7].childNodes[2].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmProssr').val(editCurRow.cells[7].childNodes[3].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmProssrSpd').val(editCurRow.cells[7].childNodes[4].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmRAM').val(editCurRow.cells[7].childNodes[5].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmHDD').val(editCurRow.cells[7].childNodes[6].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmHDDPartitions').val(editCurRow.cells[7].childNodes[7].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmWarrantyStatusDescription').val(editCurRow.cells[7].childNodes[8].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmCpuSockets').val(editCurRow.cells[7].childNodes[9].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmTotCores').val(editCurRow.cells[7].childNodes[10].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmLogProcess').val(editCurRow.cells[7].childNodes[11].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmLocID').val(editCurRow.cells[7].childNodes[12].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmRmks').val(editCurRow.cells[7].childNodes[13].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmPartNo').val(editCurRow.cells[7].childNodes[14].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmCateg').val(editCurRow.cells[7].childNodes[15].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmStatus').val(editCurRow.cells[7].childNodes[16].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmPurchaseDate').val(editCurRow.cells[7].childNodes[17].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmWarrantyStartDate').val(editCurRow.cells[7].childNodes[18].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmWarrantyEndDate').val(editCurRow.cells[7].childNodes[19].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmServCateg').val(editCurRow.cells[7].childNodes[20].value);
		  $('#hwfreeformdiv #txtFldAsstHDFrmIP').val(editCurRow.cells[7].childNodes[21].value);
}
function hdwfilldomval(RowId,table){
		table.rows[RowId].cells[3].childNodes[0].value = document.getElementById("txtFldAsstHDFrmName").value;
		table.rows[RowId].cells[4].childNodes[0].value = document.getElementById("txtFldAsstHDFrmMake").value;
		table.rows[RowId].cells[5].childNodes[0].value = document.getElementById("txtFldAsstHDFrmModel").value;
		table.rows[RowId].cells[6].childNodes[0].value = document.getElementById("txtFldAsstHDFrmSerlNo").value;
		table.rows[RowId].cells[6].childNodes[1].value = document.getElementById("txtFldAsstHDFrmMACId").value;
		table.rows[RowId].cells[7].childNodes[0].value = document.getElementById("txtFldAsstHDFrmAllotTo").value;
		table.rows[RowId].cells[7].childNodes[1].value = document.getElementById("txtFldAsstHDFrmOperSys").value;
		table.rows[RowId].cells[7].childNodes[2].value = document.getElementById("txtFldAsstHDFrmOperSysver").value;
		table.rows[RowId].cells[7].childNodes[3].value = document.getElementById("txtFldAsstHDFrmProssr").value;
		table.rows[RowId].cells[7].childNodes[4].value = document.getElementById("txtFldAsstHDFrmProssrSpd").value;
		table.rows[RowId].cells[7].childNodes[5].value = document.getElementById("txtFldAsstHDFrmRAM").value;
		table.rows[RowId].cells[7].childNodes[6].value = document.getElementById("txtFldAsstHDFrmHDD").value;
		table.rows[RowId].cells[7].childNodes[7].value = document.getElementById("txtFldAsstHDFrmHDDPartitions").value;
		table.rows[RowId].cells[7].childNodes[8].value = document.getElementById("txtFldAsstHDFrmWarrantyStatusDescription").value;	
		table.rows[RowId].cells[7].childNodes[9].value = document.getElementById("txtFldAsstHDFrmCpuSockets").value;	
		table.rows[RowId].cells[7].childNodes[10].value = document.getElementById("txtFldAsstHDFrmTotCores").value;	
		table.rows[RowId].cells[7].childNodes[11].value = document.getElementById("txtFldAsstHDFrmLogProcess").value;	
		table.rows[RowId].cells[7].childNodes[12].value = document.getElementById("txtFldAsstHDFrmLocID").value;		
		table.rows[RowId].cells[7].childNodes[13].value = document.getElementById("txtFldAsstHDFrmRmks").value;
		table.rows[RowId].cells[7].childNodes[14].value =  document.getElementById("txtFldAsstHDFrmPartNo").value;
		table.rows[RowId].cells[7].childNodes[15].value = document.getElementById("txtFldAsstHDFrmCateg").value;
		table.rows[RowId].cells[7].childNodes[16].value = document.getElementById("txtFldAsstHDFrmStatus").value;
		table.rows[RowId].cells[7].childNodes[17].value = document.getElementById("txtFldAsstHDFrmPurchaseDate").value;
		table.rows[RowId].cells[7].childNodes[18].value = document.getElementById("txtFldAsstHDFrmWarrantyStartDate").value;
		table.rows[RowId].cells[7].childNodes[19].value = document.getElementById("txtFldAsstHDFrmWarrantyEndDate").value;
		table.rows[RowId].cells[7].childNodes[20].value = document.getElementById("txtFldAsstHDFrmServCateg").value;
		table.rows[RowId].cells[7].childNodes[21].value = document.getElementById("txtFldAsstHDFrmIP").value;
}
 

function hdwMethods(dialogId,dataset,Opts,RowId,table){
	//alert("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%555hdwMethods");
	if(Opts == 'INS'){
		//alert("========================Opts == 'INS'")
		 hdwRdlyflds(CONSTANTS_VAR.INSERT_MODE);
	$('#'+dialogId).on('shown.bs.modal', function() { 
		  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
	           if(!valiHdwDetails())return;
	            hdwRdlyflds(CONSTANTS_VAR.INSERT_MODE);
	      		gethdwRows(dataset);
	      		hdwclearFlds();
				$('#'+dialogId).modal('hide'); 
		  });
		  
		});
	}//End of INS Options
	
	if(Opts == 'QRY/UPD'){
		//alert("=============Opts == 'QRY/UPD'")
		$('#'+dialogId).on('shown.bs.modal', function() {   
			  $(this).find(".modal-footer").find("button:eq(0)").click(function (){
			        if(!valiHdwDetails())return; 
			      		if(!isEmpty(RowId) && !(RowId==undefined)){ 
			      			
			      			hdwfilldomval(RowId,table); 
			      		}
			      		hdwclearFlds();
			      	  $("#hwfreeformdiv :input").prop('readonly', false);  
					$('#'+dialogId).modal('hide'); 
			  });
	  }); 
	}//End of QRY/UPD Options
	
	
	

	if(Opts == 'INS/UPD'){
		
		$('#'+dialogId).on('shown.bs.modal', function() {   
			  $(this).find(".modal-footer").find("button:eq(0)").click(function (){  
	        	  if(!valiHdwDetails())return; 
		      		if(!isEmpty(RowId) && !(RowId==undefined)){ 
		      			
		      			hdwfilldomval(RowId,table); 
		      		}  
		      		
					$('#'+dialogId).modal('hide'); 
					hdwclearFlds();
			  });
	  });  
	}//End of INS/UPD Options
	
	

	if(Opts == 'QRY'){ 
		$('#'+dialogId).on('shown.bs.modal', function() {   
			  $(this).find(".modal-footer").find("button:eq(0)").click(function (){  
	        	  hdwclearFlds();
	        	  $("#hwfreeformdiv :input").prop('readonly', false); 
				  $('#'+dialogId).modal('hide'); 
					
			  });
	  });  
	}//End of INS/UPD Options
	 
	
}
 
function fnPdfReport()
{ 
	showLoader();//shows loader  
		var strhdname = $('#txtFldSrchHDName').val();
		var strhdModel = $('#txtFldSrchHDModel').val();
		var strallotTo = $('#txtFldSrchHDAttotTo').val();
		var param = 'hActionType=SEARCH'+ 
	    '&txtFldSrchHDName='+encodeURIComponent(strhdname)
	    +'&txtFldSrchHDModel='+encodeURIComponent(strhdModel)+
	    '&txtFldSrchHDAttotTo='+encodeURIComponent(strallotTo);

	var data = assetAjax(param); 
	var result="";

var count=1;
	var doc= new jsPDF('l');
	for ( var tab in data) {	 
	if (data.hasOwnProperty(tab)) {
	var key = tab;
	var value = data[tab];
	    var harwareId  = value["txtFldAsstHDId"] == null ? "":value["txtFldAsstHDId"];
		var harwareName  = value["txtFldAsstHDName"]== null ? "":value["txtFldAsstHDName"];	
		var harwareMake  = value["txtFldAsstHDMake"]== null ? "":value["txtFldAsstHDMake"];
		var harwareModel  = value["txtFldAsstHDModel"]== null ? "":value["txtFldAsstHDModel"];
		var serialNo =value["txtFldAsstHDSerlNo"]== null ? "":value["txtFldAsstHDSerlNo"];
		var macid  = value["txtFldAsstHDMacId"]== null ? "":value["txtFldAsstHDMacId"];		
		var allotedTo =  value["txtFldAsstHDAllotTo"]== null ? "":value["txtFldAsstHDAllotTo"];	
		var operatingSystem = value["txtFldAsstHDOperSys"]== null ? "":value["txtFldAsstHDOperSys"];	
		var operatingSystemver =value["txtFldAsstHDOperSysver"]== null ? "":value["txtFldAsstHDOperSysver"];	
		var processor =value["txtFldAsstHDProssr"]== null ? "":value["txtFldAsstHDProssr"];	
		var processorSpeed = 	value["txtFldAsstHDProssrSpd"]== null ? "":value["txtFldAsstHDProssrSpd"];
		var ram =value["txtFldAsstHDRAM"]== null ? "":value["txtFldAsstHDRAM"];	
		var hdd =value["txtFldAsstHDD"]== null ? "":value["txtFldAsstHDD"];	
		var hddPartitions =value["txtFldAsstHDDPartitions"]== null ? "":value["txtFldAsstHDDPartitions"];	
		var warrantyStatusDescription = value["txtFldAsstHDWarrantyStatusDescription"]== null ? "":value["txtFldAsstHDWarrantyStatusDescription"];	
		var cpuSockets =value["txtFldAsstHDCpuSockets"]== null ? "":value["txtFldAsstHDCpuSockets"];	
		var totCores =	value["txtFldAsstHDTotCores"]== null ? "":value["txtFldAsstHDTotCores"];			
	    var logProcess = 	value["txtFldAsstHDLogProcess"]== null ? "":value["txtFldAsstHDLogProcess"];	
		var locNo = value["txtFldAsstHDLocID"]== null ? "":value["txtFldAsstHDLocID"];			
		var remarks =	value["txtFldAsstHDRmks"]== null ? "":value["txtFldAsstHDRmks"];	
		 var CreatedUsr = 	value["txtFldAsstHDCrtdUser"]== null ? "":value["txtFldAsstHDCrtdUser"];
		 var CreatedDate = 	value["txtFldAsstHDCrtdDate"]== null ? "":value["txtFldAsstHDCrtdDate"];
		 var MdfyUser = 	value["txtFldAsstHDMdfyUser"]== null ? "":value["txtFldAsstHDMdfyUser"];
		 var MdfyDate = 	value["txtFldAsstHDMdfyDate"]== null ? "":value["txtFldAsstHDMdfyDate"];
	    var partNo = 	value["txtFldAsstHDPartNo"]== null ? "":value["txtFldAsstHDPartNo"];			
		var category =	value["txtFldAsstHDCateg"]== null ? "":value["txtFldAsstHDCateg"];					
		var status =value["txtFldAsstHDStatus"]== null ? "":value["txtFldAsstHDStatus"];					
		var purchaseDate =	value["txtFldAsstHDPurchaseDate"]== null ? "":value["txtFldAsstHDPurchaseDate"];					
		var warrantySt = value["txtFldAsstHDWarrantyStartDate"]== null ? "":value["txtFldAsstHDWarrantyStartDate"];		
		var warrantyEd = value["txtFldAsstHDWarrantyEndDate"]== null ? "":value["txtFldAsstHDWarrantyEndDate"];	

		
			

		
		
			
		
		
	 doc.setFont("calibri");
	 doc.setFontType("bold");
	 doc.setTextColor(100);	
	 doc.setFontSize(16);
	 var img = new Image();
	 img.addEventListener('load', function() {
	    
	     doc.addImage(img, 'png', 10, 50);
	 });
	 img.src = 'images/logo_AVALLIS.png';

	   doc.rect(10, 10, 275, 185);
	   doc.text(190,9, 'Avallis Asset Hardware Details');
	   doc.text(190,200,'PageNo-'+(count));
	   doc.setFontSize(20);
	   doc.text(100,20, 'Avallis Asset Details');
	   
	 doc.setFont("calibri");
	 doc.setFontType("normal");
	 doc.setTextColor(100);	
	 doc.setFontSize(15);  
	  
	 doc.setLineWidth(3.5);
	 doc.setDrawColor(1);
	 doc.line(20, 30, 275, 30);
	 doc.setLineWidth(0.3);
	
	   doc.text(20,40, 'HARDWARE ID');
	     doc.text(100,40, harwareId);
	     doc.line(20, 41, 275, 41);
	    
	     doc.text(20,47, 'HARDWARE NAME');
	     doc.text(100,47, harwareName);
	     doc.line(20,48, 275, 48); 
	     
	     doc.text(20,52,'HARDWARE MAKE');
	     doc.text(100,52, harwareMake);
	     doc.line(20,53, 275, 53);
	     
	     doc.text(20,57,'HARDWARE MODEL');
	     doc.text(100,57, harwareModel);
	     doc.line(20,58, 275, 58);
 
	     doc.text(20,62,'SERIAL NO');
	     doc.text(100,62, serialNo);
	     doc.line(20,63, 275, 63);
	     
	     
	     doc.text(20,67,'ALOTTED TO');
	     doc.text(100,67, allotedTo);
	     doc.line(20,68, 275, 68);
	     
	     
	     doc.text(20,72,'OPERATING SYSTEM');
	     doc.text(100,72, operatingSystem);
	     doc.line(20,73, 275, 73);
	     
	     doc.text(20,77,'OPERATING SYSTEM VERSION');
	     doc.text(100,77, operatingSystemver);
	     doc.line(20,78, 275, 78);
	     
	     
	     
	     doc.text(20,82,'PROCESSOR');
	     doc.text(100,82, processor);
	     doc.line(20,83, 275, 83);
	     
	     doc.text(20,87,'PROCESSOR SPEED');
	     doc.text(100,87, processorSpeed);
	     doc.line(20,88, 275, 88);
	     
	     
	     doc.text(20,92,'RAM');
	     doc.text(100,92, ram);
	     doc.line(20,93, 275, 94);
	     
	    
	     doc.text(20,97,'HARD DISK');
	     doc.text(100,97, hdd);
	     doc.line(20,98, 275, 98);
	   
	     doc.text(20,102,'HARDDISK PARTITIONS');
	     doc.text(100,102, hddPartitions);
	     doc.line(20,103, 275, 103);
	     
	     
	     doc.text(20,107,'WARRANTY DESCRIPTION');
	     doc.text(100,107, warrantyStatusDescription);
	     doc.line(20,108, 275, 108);
	     
	     doc.text(20,112,'CPU SOCKETS');
	     doc.text(100,112, cpuSockets);
	     doc.line(20,113, 275, 113);
	     
	     
	     doc.text(20,117,'TOTAL CORES');
	     doc.text(100,117, totCores);
	     doc.line(20,118, 275, 118);
	     
	     doc.text(20,122,'LOGICAL PROCESSORS');
	     doc.text(100,122, logProcess);
	     doc.line(20,123, 275, 123);
	     
	     doc.text(20,127,'LOCATION NO');
	     doc.text(100,127, locNo);
	     doc.line(20,128, 275, 128);
	     
	     doc.text(20,132,'REMARKS-');
	     doc.text(100,132, remarks);
	     doc.line(20,133, 275, 133);
	     
	     doc.text(20,137,'PART NO-');
	     doc.text(100,137, partNo);
	     doc.line(20,138, 275, 138);
	     
	     doc.text(20,142,'CATEGORY');
	     doc.text(100,142, category);
	     doc.line(20,143, 275, 143);
	     
	     doc.text(20,148,'STATUS-');
	     doc.text(100,148, status);
	     doc.line(20,149, 275, 149);
	     
	     
	     doc.text(20,153,'PURCHASE DATE-');
	     doc.text(100,153, purchaseDate);
	     doc.line(20,154, 275, 154);
	     
	     
	     doc.text(20,159,'WARRANTY START DATE-');
	     doc.text(100,159, warrantySt);
	     doc.line(20,160, 275, 160);
	     
	     
	     doc.text(20,165,'WARRANTY END DATE-');
	     doc.text(100,165, warrantyEd);
	     doc.line(20,166, 275, 166);
	     
	     
	     doc.text(20,171,'CREATED USER');
	     doc.text(100,171, CreatedUsr);
	     doc.line(20,172, 275, 172);
	     
	     doc.text(20,177,'CREATED DATE');
	     doc.text(100,177, CreatedDate);
	     doc.line(20,178, 275, 178);
	     
	     doc.text(20,183,'MODIFIED USER');
	     doc.text(100,184, MdfyUser);
	     doc.line(20,183, 275, 183);
	     
	     doc.text(20,189,'MODIFIED DATE');
	     doc.text(100,190, MdfyDate);
	     doc.line(20,190, 275, 190);
	     
	   doc.addPage();
		
	}
	count++;
	}
	
		
	doc.save('AssetHardware.pdf');
	hideLoader(); 
} 



function hideDatepickerIt(elm)
{

	 $(elm).datepicker( "hide" );  
	  
	  
} 
  function showDatepickerIt(elm)
 {
  $(elm).datepicker(); 
	 
 }
  