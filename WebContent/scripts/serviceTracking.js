/**
 * This script file is used to add Asset Hardware related functions in it
 * @author 
 */

// **************************************
//              CONSTANTS
//***************************************

 
var selRowArr = [];

var SW_CATEGORY_VAR;
var LICENSE_TYPE_VAR;
var SW_STATUS_VAR;
var HW_NAME_LIST;
var SW_NAME_LIST;
var VENDOR_NAME_LIST;
var servtrachtbl="";
// TOOL BAR FUNCTIONS

function toolBarSrchFun()
{ 
	searchRecords();
}//end of toolBarSrchFun

function toolBarAddFun()
{
	alert('Yet to Implement!');
}//end of toolBarAddFun

function toolBarEditFun()
{
	alert('Yet to Implement!');
}//end of toolBarEditFun

function toolBarSaveFun()
{
	assetCUDOpern();
}//end of toolBarSaveFun

function toolBarCancelFun()
{
	alert('Yet to Implement!');
}//end of toolBarCancelFun

function toolBarDelFun()
{
	alert('Yet to Implement!');
}//end of toolBarDelFun

function toolBarAddRefreshFun()
{
	window.location.reload();
}//end of toolBarAddRefreshFun

function toolBarPrntFun()
{
	alert('PRINT SOFTWARE DETAILS');
	 window.print();
}//end of toolBarPrntFun

// END OF TOOL BAR FUNCTIONS

//var  sw_categ_arr=[];
//var license_type_arr=[];
//var sw_status_arr=[];
var hw_name_arr=[];
var sw_name_arr=[];
var vd_name_arr=[];

function loadStinit()
{
	$('#successmsgdiv').delay(2000).fadeOut('blind');
	$("#side-menu").find("li a").removeClass("active")
	$("#liassetservicetrack").find("a").addClass("active");
 	 
	
	var hwnamelist=HW_NAME_LIST.substr(1,HW_NAME_LIST.length-2);
	var hwnamelistsplit = hwnamelist.split(",");
	
	for(var hwstsfor=0;hwstsfor<hwnamelistsplit.length;hwstsfor++)
	{
		hw_name_arr.push(trim(hwnamelistsplit[hwstsfor])); 
	}//end of for 
	
	
	var swnamelist=SW_NAME_LIST.substr(1,SW_NAME_LIST.length-2);
	var swnamelistsplit = swnamelist.split(",");
	
	for(var swstsfor=0;swstsfor<swnamelistsplit.length;swstsfor++)
	{
		sw_name_arr.push(trim(swnamelistsplit[swstsfor])); 
	}//end of for 
	
	
	var vdnamelist=VENDOR_NAME_LIST.substr(1,VENDOR_NAME_LIST.length-2);
	var vdnamelistsplit = vdnamelist.split(",");
	
	for(var vdstsfor=0;vdstsfor<vdnamelistsplit.length;vdstsfor++)
	{
		vd_name_arr.push(trim(vdnamelistsplit[vdstsfor])); 
	}//end of for 

	servtrachtbl=$("#serviceTrackingTable").DataTable({ 
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
	        ctrlOverFlowDataTable('serviceTrackingTable'); 
	    }
	    //data: data
	}); 
	
 	showTooltip('btnFldSrvcTrAddRow','Add Row');
	showTooltip('btnFldSrvcTrEditRow','Edit Row');
	showTooltip('btnFldSrvcTrDelRow','Delete Row'); 
	hideLoader();
	
}//end of loadinit


//*************************************
// ASSET SOFTWARE RELATED FUNCTIONS
//*************************************

function srvcaddRow()
{
	
	$("#serviceTrackingTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	var tbl = document.getElementById('serviceTrackingTable'),tblBody = tbl.tBodies[0],
	    len = tblBody.rows.length;
	if(len>0)
	{
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[3].childNodes[0], CONSTANTS_VAR.KEYIN_HD_NAME ))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_SW_NAME))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[5].childNodes[0], CONSTANTS_VAR.KEYIN_VD_NAME))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[6].childNodes[0], CONSTANTS_VAR.KEYIN_SERVC_REQ))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[7].childNodes[0], CONSTANTS_VAR.KEYIN_SERVC_DATE))return;
		
	}//end of if
	
	var row = tblBody.insertRow(len);
	var cell0 = row.insertCell(0);
	cell0.innerHTML = '<input type="text" name="txtFldSrcTrSlno"  style="width:100%;" id="txtFldSrcTrSlno" readonly="readonly" value="'+(len+1)+'" class="writableFieldDHTML" />';
	cell0.childNodes[0].style.textAlign = 'center';
	
	var cell1 = row.insertCell(1);
	cell1.innerHTML = '<input type="checkbox" name="radSrcTrSelect" id="radSrcTrSelect" style="width:100%;" class="writableFieldDHTML" onclick="selectRowFun(this)" />'+'<input type="hidden" id="hSelRow" name="hSelRow" value="'+len+'">'+'<input type="hidden" id="txtFldServiceId" name="txtFldServiceId">';
	cell1.childNodes[0].style.textAlign = 'center';
	
	
	var cell2 = row.insertCell(2);
	cell2.innerHTML = '<input type="text" name="txtFldSrcTrMode" id="txtFldSrcTrMode" style="width:100%;" readonly="readonly" value="'+CONSTANTS_VAR.INSERT_MODE+'" class="writableFieldDHTML" />';
	cell2.childNodes[0].style.textAlign = 'center';
	
	var cell3 = row.insertCell(3);
	cell3.innerHTML = '<select type="text" name="txtFldHDName" id="txtFldHDName" style="width:100%"> </select>';
	var cnt=0;
	cell3.childNodes[0].options[cnt]=  new Option("--------select--------","");
	for(var st=0;st<hw_name_arr.length;st++)
	{ 
		//showAlert("st"+st);
		cnt=cell3.childNodes[0].options.length;
		cell3.childNodes[0].options[cnt++]=  new Option(hw_name_arr[st],hw_name_arr[st]);
		
	}//end of for
	
	
	
	var cell4 = row.insertCell(4);
	cell4.innerHTML = '<select type="text" name="txtFldSWName" id="txtFldSWName" style="width:100%"> </select>';
	var cnt=0;
	cell4.childNodes[0].options[cnt]=  new Option("--------select--------","");
	for(var st=0;st<sw_name_arr.length;st++)
	{  
		cnt=cell4.childNodes[0].options.length;
		cell4.childNodes[0].options[cnt++]=  new Option(sw_name_arr[st],sw_name_arr[st]);
		
	}//end of for
	
	
	
	var cell5 = row.insertCell(5);
	cell5.innerHTML ='<select name="txtFldVDName" id="txtFldVDName" style="width:100%"> </select>';
	var cnt=0;
	cell5.childNodes[0].options[cnt]=  new Option("--------select--------","");
	for(var st=0;st<vd_name_arr.length;st++)
	{  
		cnt=cell5.childNodes[0].options.length;
		cell5.childNodes[0].options[cnt++]=  new Option(vd_name_arr[st],vd_name_arr[st]);
		
	}//end of for
	
	var cell6 = row.insertCell(6);
	cell6.innerHTML ='<input type="text" name="txtFldServiceRequest" id="txtFldServiceRequest" style="width:100%;"  class="writableFieldDHTML"/>';
	
	
	var cell7 = row.insertCell(7);
	cell7.innerHTML ='<input type="text" name="txtFldServiceDate id="txtFldServiceDate" style="width:100%;"  class="writableFieldDHTML"/>';
	
	var cell8 = row.insertCell(8);
	cell8.innerHTML ='<input type="text" name="txtFldRemarks" id="txtFldRemarks" style="width:100%;"  class="writableFieldDHTML"/>';
	
	var cell9 = row.insertCell(9);
	cell9.innerHTML = '<input type="text" name="txtFldServiceCrtdUser" id="txtFldServiceCrtdUser" style="width:100%;"  class="writableFieldDHTML" />';
	
	var cell10 = row.insertCell(10);
	cell10.innerHTML = '<input type="text" name="txtFldServiceCrtdDate" id="txtFldServiceCrtdDate" style="width:100%;" class="writableFieldDHTML" />'; 
	
	var cell11 = row.insertCell(11);
	cell11.innerHTML = '<input type="text" name="txtFldServiceMdfyUser" id="txtFldServiceMdfyUser" style="width:100%;" class="writableFieldDHTML"  />';
	
	var cell12 = row.insertCell(12);
	cell12.innerHTML = '<input type="text" name="txtFldServicedMdfyDate" id="txtFldServicedMdfyDate" style="width:100%;" class="writableFieldDHTML"  />';
	
	cell3.childNodes[0].focus();
}//end of srvcaddRow row

function populateSelect(target, min, max)
{
        var min  ,  max  ;
        select = document.getElementById(target);
        for (var i = min; i<=max; i++)
        {
            var opt = document.createElement('option');
            opt.value = i;
            opt.innerHTML = i;
            select.appendChild(opt);
        }
}


function srvcdeleteRow()
{
	tableDeleteRow("serviceTrackingTable",false);  
 
}//end of deleteRow

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
	
	var tbl = document.getElementById('serviceTrackingTable'),tblBody = tbl.tBodies[0],
    len = tblBody.rows.length;
	document.getElementById('hActionType').value = 'ASEET_CUD';
	
    if(len <= 0)
    {
	alert(CONSTANTS_VAR.ADDROW_BFR_SMT);
	return;
    }

    if(len>0)
    {
    	if(!chkMandatoryFields(tblBody.rows[len-1].cells[3].childNodes[0], CONSTANTS_VAR.KEYIN_HD_NAME ))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_SW_NAME))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[5].childNodes[0], CONSTANTS_VAR.KEYIN_VD_NAME))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[6].childNodes[0], CONSTANTS_VAR.KEYIN_SERVC_REQ))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[7].childNodes[0], CONSTANTS_VAR.KEYIN_SERVC_DATE))return;
    }//end of if
	
	document.forms[0].action = 'register';
	document.forms[0].submit();
	
}//end of submitForm


function searchRecords()
{
	clearRecords('serviceTrackingTable');
	
	var hardwareName = $('#txtFldSrchHWName').val();
	var softwareName = $('#txtFldSrchSWName').val();
	var vendorName = $('#txtFldSrchVDName').val();
	  
	if( isEmptyFld(hardwareName) && isEmptyFld(softwareName)  && isEmptyFld(vendorName) ){
		showAlert(CONSTANTS_VAR.SEL_ANYSRCH_CRIT,$('#txtFldSrchHWName'));  
		return;
	}//end of if
	 	   
			var param = 'hActionType=SERV_TRACK_SEARCH'+ 
				        '&txtFldSrchHWName='+encodeURIComponent(hardwareName)+
			            '&txtFldSrchSWName='+encodeURIComponent(softwareName)+
			            '&txtFldSrchVDName='+encodeURIComponent(vendorName);
		   
			var data = assetAjax(param);//assetAjax function call
			populateAssetTbl(data);// populateAssetTbl function call
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


function populateAssetTbl(responce)
{
		var len = responce.length;
		 if(len >0){
			 for(var asset=0;asset<len;asset++)
			 {
			    var tbl = document.getElementById('serviceTrackingTable'),tblBody = tbl.tBodies[0];
		    	var row = tblBody.insertRow(asset);
   		    	    
		    	    
		    	    var cell0 = row.insertCell(0);
		    		cell0.innerHTML = '<input type="text" name="txtFldSrcTrSlno"  style="width:100%;" id="txtFldSrcTrSlno" readonly="readonly" value="'+(asset+1)+'" class="writableFieldDHTML" />';
		    		cell0.childNodes[0].style.textAlign = 'center';
		    		
		    		var cell1 = row.insertCell(1);
		    		cell1.innerHTML = '<input type="checkbox" name="radSrcTrSelect" id="radSrcTrSelect" style="width:100%;" class="writableFieldDHTML" onclick="selectRowFun(this)" />'+'<input type="hidden" id="hSelRow" name="hSelRow" value="'+len+'">';
		    		cell1.childNodes[0].style.textAlign = 'center';
		    		
		    		
		    		var cell2 = row.insertCell(2);
		    		cell2.innerHTML = '<input type="text" name="txtFldSrcTrMode" id="txtFldSrcTrMode" style="width:100%;" readonly="readonly" value="'+CONSTANTS_VAR.INSERT_MODE+'" class="writableFieldDHTML" />';
		    		cell2.childNodes[0].style.textAlign = 'center';
		    		
		    		var cell3 = row.insertCell(3);
		    		cell3.innerHTML = '<select type="text" name="txtFldHDName" id="txtFldHDName" style="width:100%"> </select>';
		    		var cnt=0;
		    		cell3.childNodes[0].options[cnt]=  new Option("--------select--------","");
		    		for(var st=0;st<hw_name_arr.length;st++)
		    		{ 
		    			//showAlert("st"+st);
		    			cnt=cell3.childNodes[0].options.length;
		    			cell3.childNodes[0].options[cnt++]=  new Option(hw_name_arr[st],hw_name_arr[st]);
		    			
		    		}//end of for
//		    		cell17.childNodes[0].value=chkNull(responce[asset]['txtFldAsstHDCateg']);
		    		 
		    		var cell4 = row.insertCell(4);
		    		cell4.innerHTML = '<select type="text" name="txtFldSWName" id="txtFldSWName" style="width:100%"> </select>';
		    		var cnt=0;
		    		cell4.childNodes[0].options[cnt]=  new Option("--------select--------","");
		    		for(var st=0;st<sw_name_arr.length;st++)
		    		{ 
		    			//showAlert("st"+st);
		    			cnt=cell4.childNodes[0].options.length;
		    			cell4.childNodes[0].options[cnt++]=  new Option(sw_name_arr[st],sw_name_arr[st]);
		    			
		    		}//end of for
		    		
		    		var cell5 = row.insertCell(5);
		    		cell5.innerHTML ='<select name="txtFldVDName" id="txtFldVDName" style="width:100%"> </select>';
		    		var cnt=0;
		    		cell5.childNodes[0].options[cnt]=  new Option("--------select--------","");
		    		for(var st=0;st<vd_name_arr.length;st++)
		    		{ 
		    			//showAlert("st"+st);
		    			cnt=cell5.childNodes[0].options.length;
		    			cell5.childNodes[0].options[cnt++]=  new Option(vd_name_arr[st],vd_name_arr[st]);
		    			
		    		}//end of for
		    		var cell6 = row.insertCell(6);
		    		cell6.innerHTML ='<input type="text" name="txtFldServiceRequest" id="txtFldServiceRequest" style="width:100%;"  class="writableFieldDHTML"/>';
		    		
		    		var cell7 = row.insertCell(7);
		    		cell7.innerHTML ='<input type="text" name="txtFldServiceDate" id="txtFldServiceDate"  style="width:100%;" class="writableFieldDHTML"  /> ';
		    		
		    		var cell8 = row.insertCell(8);
		    		cell8.innerHTML ='<input type="text" name="txtFldRemarks" id="txtFldRemarks"  style="width:100%;" class="writableFieldDHTML"  /> ';
					
		    		var cell9 = row.insertCell(9);
		    		cell9.innerHTML = '<input type="text" name="txtFldServiceCrtdUser" id="txtFldServiceCrtdUser" style="width:100%;"  class="writableFieldDHTML" />';
		    		
		    		var cell10 = row.insertCell(10);
		    		cell10.innerHTML = '<input type="text" name="txtFldServiceCrtdDate" id="txtFldServiceCrtdDate" style="width:100%;" class="writableFieldDHTML" />'; 
		    		
		    		var cell11 = row.insertCell(11);
		    		cell11.innerHTML = '<input type="text" name="txtFldServiceMdfyUser" id="txtFldServiceMdfyUser" style="width:100%;" class="writableFieldDHTML"  />';
		    		
		    		var cell12 = row.insertCell(12);
		    		cell12.innerHTML = '<input type="text" name="txtFldServicedMdfyDate" id="txtFldServicedMdfyDate" style="width:100%;" class="writableFieldDHTML"  />';
		    		
		    		
					
			 }//end of for{asset}
		}//end of if
}//end of populateAssetTbl

function clearRecords(tblId,typ)
{
	var tbl = document.getElementById(tblId),
	    tblBody = tbl.tBodies[0],
	    tblLen = tblBody.rows.length;
	
	var hdrSelObj = document.getElementById('chkSwbox');
	
	if(typ && typ == 'CLR')
	{
		if(tblLen <=0)
		{
			alert(CONSTANTS_VAR.NO_RECORDS);
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
	
	if(hdrSelObj.checked)hdrSelObj.checked = false;
}//end of clearRecords



function selectRowFun(chkObj)
{
	
	if(chkObj.checked)
	{
		selRowArr.push(chkObj.parentNode.childNodes[1].value) ;
	}//end of id
	
}//end of selectRowFun

function srvceditRow()
{
	var tbl     = document.getElementById('serviceTrackingTable'),
	    tblBody = tbl.tBodies[0],
	    tblLen  = tblBody.rows.length;
	
	if(tblLen <= 0)
	{
		alert('No Records do to updation!');
		return;
	}//end of if
	
	if(tblLen > 0)
	{
		if(selRowArr.length >0)
		{
			
			for(var sel=0;sel<selRowArr.length;sel++)
			{
				var selRow = selRowArr[sel];
				enableOrDisableRow(selRow,CONSTANTS_VAR.ENABLE);
			}//end of for
			selRowArr = [];
		}//end of if
		else
		{
			alert('Select the rows to do updation!');
			return;
		}//end of else
		
	}//end of if
	
}//end of srvceditRow()


function enableOrDisableRow(row,type)
{
	var srcSlno        = document.getElementsByName('txtFldSrcTrSlno');
	var srcChk         = document.getElementsByName('radSrcTrSelect');
	var srcMode        = document.getElementsByName("txtFldSrcTrMode");
	
	var srcHDName      = document.getElementsByName("txtFldHDName");
	var srcSDName      = document.getElementsByName("txtFldSWName");
    var srcVDName      = document.getElementsByName("txtFldVDName");
    var srcReq         = document.getElementsByName("txtFldServiceRequest");
	var srcRmks        = document.getElementsByName("txtFldRemarks");
	
   
	if(srcMode[row].value == CONSTANTS_VAR.QUERY_MODE && type == CONSTANTS_VAR.ENABLE ){
		srcSlno[row].className='writableFieldDHTML';
		srcMode[row].className='writableFieldDHTML';
		srcMode[row].value = CONSTANTS_VAR.UPDATE_MODE;
		srcHDName[row].className='writableFieldDHTML';
		srcHDName[row].readOnly=false;
		        
				srcSDName[row].className='writableFieldDHTML'; 
				srcSDName[row].readOnly=false;
		        
				srcVDName[row].className='writableFieldDHTML';
				srcVDName[row].readOnly=false;
		        
				srcReq[row].className='writableFieldDHTML';
				srcReq[row].readOnly=false;
		        
		        srcRmks[row].className='writableFieldDHTML';
		        srcRmks[row].readOnly=false;
		
       if(srcChk[row].checked) srcChk[row].checked = false;
        
	}//end of if
	else if(type == CONSTANTS_VAR.DISABLE)
	{
		srcSlno[row].className='readOnlyFieldDHTML';
		
		srcMode[row].className='readOnlyFieldDHTML';
		srcMode[row].value = CONSTANTS_VAR.UPDATE_MODE;

		
		srcHDName[row].className='writableFieldDHTML';
		srcHDName[row].readOnly=true;
        
		srcSDName[row].className='writableFieldDHTML'; 
		srcSDName[row].readOnly=true;
        
		srcVDName[row].className='writableFieldDHTML';
		srcVDName[row].readOnly=true;
        
		srcReq[row].className='writableFieldDHTML';
		srcReq[row].readOnly=true;
        
        srcRmks[row].className='writableFieldDHTML';
        srcRmks[row].readOnly=true;
		
		
    }//end of elseif
	
	if(srcMode[row].value == CONSTANTS_VAR.UPDATE_MODE)
	{
		srcMode[row].checked = false;
	}//end of if
		
}//end of enableOrDisableRow

function today()
{
	
	var date = new Date();
	var dd = date.getDate();
	var month = date.getMonth()+1;
	var year = date.getFullYear();
	
	if(dd < 10){
		dd = '0'+dd;
	}
	
	if(month < 10){
		month = '0'+month;
	}
	 
	return dd+'/'+month+'/'+year;
	
}//end of today



function chkNull(value){
	
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
	var tbl = document.getElementById('serviceTrackingTable');
	var tblBody = tbl.tBodies[0],tblLen = tblBody.rows.length;
	
	if(radObj.checked)
	{
		if(tblLen ==0)
		{
			alert('No rows to select!');
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
		
	}//end of if 
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
	var ServForm = document.assetForm;
	var tbl = document.getElementById('serviceTrackingTable');
	var tblBody = tbl.tBodies[0];
	tblLen = tblBody.rows.length;
	
	assetForm.asset.value=tblLen;
	var flag=false;
	if(tblLen==0)
	{
	 alert("No Rows"+tblLen);
	}
	
	if(tblLen>0)
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
		ServForm.action = 'ServTRCUDOpern.do';
		ServForm.submit();
		}//end ofif
	
}//end of assetCUDOpern


