


var selRowArr = [];
var VN_COUNTRY_VAR;
var VN_country_arr=[];
var vendorNameTbl="";
var vendorConTbl=""; 
var baseUrl="";
var avadsid;
function loadVeninit()
{ 
	
	 $("#btnFldAssVdAddDtls").click(function(){
		 navToVendorDtlsTab();
	  });
	 
	 $("#btnFldAssVdDelRow").click(function(){
		 
		 deleteVendor();
	 });
 
	$("#btnFldAssVdconAddRow").click(function(){
		
		addVendorConRow();
	});
	
	$("#btnFldAssVdconEditRow").click(function(){
		
		editVendorConRow();
	});
	
	$("#btnFldAssVdconDelRow").click(function(){
		
		deleteVendorConRow();
	});
	
	$('#successmsgdiv').delay(2000).fadeOut('blind');
	
	
	
//	window.setTimeout(function() {
//	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
//	        $(this).remove(); 
//	    });
//	}, 4000);
	 
	var sid=$("#sid").val();

	if((sid == "NAV_ASSET"))
	{ 
		
		$("#btnSave").css("display","none");
		$("#assetsidemenu #liassethard").css("display","none");
		$("#assetsidemenu #liassetsoft").css("display","none");
		$("#assetsidemenu #liassetservicetrack").css("display","none");
		$("#assetsidemenu #liassetattachment").css("display","none");
		$("#assetsidemenu #liassetrenewal").css("display","none");
		$("#spnAsstVDconAdd").css("display","none");
		$("#spnAsstVDconEdit").css("display","none");
		$("#spnAsstVDconDel").css("display","none");
		$("#assetHeaderLinkLogout").css("display","none");
		$("#liassetvendor").find("a").attr("onclick","");
		$("#sid").val("CLOSE SESSION"); 
		if(avadsid == "null")
		  { 
			window.location = baseUrl + "/sessionExpired.jsp";
		  } 
    }
	

	
	$("#side-menu").find("li a").removeClass("active")
	$("#liassetvendor").find("a").addClass("active");
	
	var vnCountry=VN_COUNTRY_VAR.substr(1,VN_COUNTRY_VAR.length-2);
	var vnCountryplit = vnCountry.split(",");
	
	for(var vnCounrtyfor=0;vnCounrtyfor<vnCountryplit.length;vnCounrtyfor++)
	  {
		VN_country_arr.push(trim(vnCountryplit[vnCounrtyfor]))
	  }
	   vendorNameTbl=$("#assetVendorNamTable").DataTable({ 
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
	    		    fnDrawCallback: function(oSettings) 
	   {
	        if (oSettings._iDisplayLength > oSettings.fnRecordsDisplay()) 
	        {
	            $(oSettings.nTableWrapper).find('.dataTables_paginate').hide(); 
	        } 
	        ctrlOverFlowDataTable('assetVendorNamTable'); 
	    }
	    
	}); 
	
	
	vendorConTbl=$("#assetVendorContTable").DataTable({ 
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
	    		    fnDrawCallback: function(oSettings) 
	    {
	        if (oSettings._iDisplayLength > oSettings.fnRecordsDisplay())
	        {
	            $(oSettings.nTableWrapper).find('.dataTables_paginate').hide(); 
	        } 
	        ctrlOverFlowDataTable('assetVendorNamTable'); 
	    }
	    
	}); 
	showTooltip('btnFldAssVdconAddRow','Add Row');
	showTooltip('btnFldAssVdconEditRow','Edit Row');
	showTooltip('btnFldAssVdconDelRow','Delete Row'); 
	hideLoader();
	
}


function focusTxtFld()
{
	 document.getElementById("txtFldServiceVendrRep").focus();
     $("txtFldServiceVendrRep").focus();
}

function validateName()
{
    var username = $('#txtFldAsstVDServiceName').val();
    
    if(isEmptyFld(username)){
		  showAlert("UserName can't be blank",$('#txtFldAsstVDServiceName'));   
		  return false;  
		  }  
}
 
function ContactKeyPervalidation()
{
	 var username = $('#txtFldAsstVDContKeyPernme').val();
	    
	 if(isEmptyFld(username)){
			  showAlert("KeyPersonName can't be blank",$('#txtFldAsstVDContKeyPernme'));  
		 return false;  
	 }  
}

function validateEmail()
{
    var x = $('#txtFldAsstVDServiceEmail').val();
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if(!isEmptyFld(x))
    {
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) 
       {
        showAlert("Not a valid e-mail address",$('#txtFldAsstVDServiceEmail'));
        $('#txtFldAsstVDServiceEmail').val("");
        return false;
       }
    }
}


function validateWebsite()
{
	
	var re = /^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/;
	
	var url= $('#txtFldAsstVDServiceWebsite').val();
	if(!isEmptyFld(url))
	{
	   if (!re.test(url))
	   { 
	    showAlert("Invalid URL",$('#txtFldAsstVDServiceWebsite')); 
	    $('#txtFldAsstVDServiceWebsite').val("");
	    return false;
	   }	
	}
}
 




function Contactvalidation()
{
var name = $("#txtFldAsstVDCont247").val() ; 

if(isEmptyFld(name))
{
	showAlert("Contact can't be Blank",$('#txtFldAsstVDCont247'));  
	return false;
}
 
}
 
function OfficeNoValidation()
{
   var name = $("#txtFldAsstVDContVendrOffPerNo").val() ;

    if(isEmptyFld(name))
         {
	      showAlert("Office Direct No can't be Blank",$('#txtFldAsstVDContVendrOffPerNo'));  
	      return;
         }
 } 


function myDateFunction() {
	
$(function () {

    $("#txtFldAsstVDStrtDate").datepicker({
        numberOfMonths: 2,
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate() + 1);
            $("#txtTo").datepicker("option", "minDate", dt);
        }
    });
    $("#txtFldAsstVDEndDate").datepicker({
        numberOfMonths: 2,
        onSelect: function (selected) {
            var dt = new Date(selected);
            dt.setDate(dt.getDate() - 1);
            $("#txtFrom").datepicker("option", "maxDate", dt);
        }
    });
});

}


function validateNumber(){

	var tbl     = document.getElementById('assetVendorSerDetlsTable'),
	    tblBody = tbl.tBodies[0],
	    tblLen  = tblBody.rows.length;

	
	
	if(tblLen > 0)
	   {
		
		var numFormat;
		for(var rr=0;rr<tblLen;rr++)
		  {
		       numFormat=tblBody.rows[rr].cells[5].childNodes[0].value;
				
		  }
       }
	
         if(!/^[0-9]+$/. test(numFormat))
	    {
	       showAlert("Please only enter numeric characters for your RenewalAmount! (Allowed input:0-9)")
	    }

}

function today() {

	var date = new Date();
	var dd = date.getDate();
	var month = date.getMonth() + 1;
	var year = date.getFullYear();

	if (dd < 10) {
		dd = '0' + dd;
	}

	if (month < 10) {
		month = '0' + month;
	}

	return dd + '/' + month + '/' + year;

}

function chkNull(value) 
{

	var retVal = '';
	if (value == null || value == '' || value == undefined
			|| value == 'undefined')

		return retVal;

	else
		retVal = value;

	return retVal;
}

function validateVendorDets()
{
	if(!chkModelMandatory($("#txtFldServiceVendrRep"), CONSTANTS_VAR.KEYIN_VD_REP))return;
	if(!chkModelMandatory($("#txtFldAsstVDServiceName"), CONSTANTS_VAR.KEYIN_VD_NAME))return;
	if(!chkModelMandatory($("#txtFldAsstVDServiceEmail"), CONSTANTS_VAR.KEYIN_VD_EMAIL))return;  
	return true;
}

function toolBarSrchFun()
{ 
	if(avadsid == "null")
	{
		window.location = baseUrl + "/sessionExpired.jsp";
	}
	searchVendorRecords();
}

//search vendor details function ......

function searchVendorRecords() 
{  
	showLoader();
	
	
//	if(avadsid == "null")
//	{
//		window.location = baseUrl + "/sessionExpired.jsp";
//	}
	clearRecords('assetVendorNamTable');
	
var vendorName = $('#txtFldSrchVDName').val();
	
	
	
	if(isEmptyFld(vendorName))
	{
		showAlert(CONSTANTS_VAR.SEL_ANYSRCH_CRIT,$('#txtFldSrchVDName'));  
        hideLoader();
		return;
		
	}
	  $("#vendornavdiv").find("ul li").removeClass("active");
	  $("#vendornavdiv").find("ul li[id='li_vd_Search']").addClass("active");
	  $(".tab-content .tab-pane").removeClass("active in");
	  $(".tab-content").find("div[id='Search']").addClass("active in");
	 
	 
	var param = "hActionType=VDSEARCH&txtFldSrchVDName="+encodeURIComponent(vendorName);
	var data = assetAjax(param);
	
	addVendorDetails(data);
	
	setTimeout(() => {
		hideLoader();
	}, 1000)
}






function addVendorDetails(responce)
{

	
	var len = responce.length;
	if (len > 0) {
		for (var asset = 0; asset < len; asset++) {
			var tbl = document.getElementById('assetVendorNamTable'), 
			tblBody = tbl.tBodies[0];
			var row = tblBody.insertRow(asset);

			var cell0 = row.insertCell(0);
			cell0.innerHTML = '<input type="text" name="txtFldAsstVDSlno" style="width:100%;" id="txtFldAsstVDSlno" readonly="readonly" value="'+ (asset + 1)+'" class="readOnlyFieldDHTML" readonly="true" />';
			cell0.childNodes[0].style.textAlign = 'center';
			

			
		     var cell1 = row.insertCell(1);
			cell1.innerHTML = '<input type="checkbox" name="radAsstVDSelect" id="radAsstVDSelect"  class="writableFieldDHTML"  onclick="selectRowFun(this); style="width:100%"/>'+
			'<input type="hidden" id="hSelRow" name="hSelRow" value="'+ asset + '" />';
		    cell1.style.display = 'none';
		    cell1.childNodes[0].style.textAlign = 'center';

			
			
			var cell2 = row.insertCell(2);
			cell2.innerHTML = '<input type="text" name="txtFldAsstVDMode" id="txtFldAsstVDMode" readonly="true" value="'+ CONSTANTS_VAR.QUERY_MODE+ '" class="readOnlyFieldDHTML" readonly="true" />';
			cell2.style.display='none';
			cell2.childNodes[0].style.textAlign = 'center';

			var cell3 = row.insertCell(3);
			cell3.innerHTML = '<img src="styles/images/searchicon.png" align="center" width="30%" id="openvendordetail" title="Click To View Vendor Details"  onclick="viewVendorTblRows(this);showLoader();" />'+'<input type="hidden" name="txtFldAsstVDMastrId" id="txtFldAsstVDMastrId"  value="'+ chkNull(responce[asset]["txtFldAsstVDMastrId"])+ '" />';
			cell3.childNodes[0].style.margin = '0  0 0 32px'; 
			
			var cell4 = row.insertCell(4);
			cell4.innerHTML = '<input type="text" name="txtFldAsstVDRepName" id="txtFldAsstVDRepName" maxlength="30" value="'+ chkNull(responce[asset]["txtFldAsstVDRepName"])+ '" onmouseover="assetTooltip(this);" class="readOnlyFieldDHTML" readonly="true" />';

			var cell5 = row.insertCell(5);
			cell5.innerHTML = '<input type="text" name="txtFldAsstVDName" id="txtFldAsstVDName" value="'+ chkNull(responce[asset]["txtFldAsstVDName"])+ '" maxlength="30" onmouseover="assetTooltip(this);" class="readOnlyFieldDHTML" readonly="true" />';
 
			var cell6 = row.insertCell(6);
			cell6.innerHTML = '<input type="text" name="txtFldAsstVDHp" id="txtFldAsstVDHp"  maxlength="30" value="'+ chkNull(responce[asset]["txtFldAsstVDHp"])+ '" class="readOnlyFieldDHTML" onmouseover="assetTooltip(this);" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDAddr1" id="txtFldAsstVDAddr1" value="'+chkNull(responce[asset]['txtFldAsstVDAddr1'])+'" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDAddr2" id="txtFldAsstVDAddr2" value="'+ chkNull(responce[asset]["txtFldAsstVDAddr2"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDAddr3" id="txtFldAsstVDAddr3" value="'+ chkNull(responce[asset]["txtFldAsstVDAddr3"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDCity" id="txtFldAsstVDCity" value="'+ chkNull(responce[asset]["txtFldAsstVDCity"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly=true" />'+
			'<input type="hidden" name="txtFldAsstVDCountry" id="txtFldAsstVDCountry" value="'+ chkNull(responce[asset]["txtFldAsstVDCountry"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDPcode" id="txtFldAsstVDPcode" value="'+ chkNull(responce[asset]["txtFldAsstVDPcode"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDOffph" id="txtFldAsstVDOffph" value="'+ chkNull(responce[asset]["txtFldAsstVDOffph"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDFax" id="txtFldAsstVDFax" value="'+ chkNull(responce[asset]["txtFldAsstVDFax"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />';
			var cell7 = row.insertCell(7);
			cell7.innerHTML = '<input type="text" name="txtFldAsstVDEmail" id="txtFldAsstVDEmail" value="'+ chkNull(responce[asset]["txtFldAsstVDEmail"])+ '" onmouseover="assetTooltip(this);" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />'+
			'<input type="hidden" name="txtFldAsstVDWebsite" id="txtFldAsstVDWebsite" value="'+ chkNull(responce[asset]["txtFldAsstVDWebsite"])+ '" onmouseover="assetTooltip(this);" maxlength="30" class="readOnlyFieldDHTML" readonly="true" />';
 
			var cell8 = row.insertCell(8);
			cell8.innerHTML = '<input type="text" name="txtFldAsstVDContacts247" id="txtFldAsstVDContacts247" value="'+ chkNull(responce[asset]["txtFldAsstVDContacts247"])+ '" onmouseover="assetTooltip(this);"  maxlength="30" class="readOnlyFieldDHTML" readonly="true" />';
			'<input type="hidden" name="txtFldAsstVDRemarks" id="txtFldAsstVDRemarks"  maxlength="30" value="'+ chkNull(responce[asset]["txtFldAsstVDRemarks"])+ '" onmouseover="assetTooltip(this);" class="readOnlyFieldDHTML" readonly="true" />';
 
			
		  }
	   }
	else
	{
		 showAlert("NO Record Found");
	 }
} 

function toolBarSaveFun() 
{
	assetCUDOpern();
}

function assetCUDOpern()
{
   /* if(!validateVendorDets())
     {
       showAlert(CONSTANTS_VAR.KEYIN_VD_REP);
       
     }*/
	var vendorRep=($('#txtFldServiceVendrRep').val()) ;
	var vendorName=($('#txtFldAsstVDServiceName').val());
	var Email=($('#txtFldAsstVDServiceEmail').val());
    if((vendorRep == '')||(vendorName == '')||(Email== ''))
    {
	validateVendorDets();
    }
    else
    	{
 
	for(var tt =0 ;tt < document.forms.length ; tt++)
	
	var assetVendorForm =document.getElementById("assetForm");
	
	
	var strMastVendorId = document.getElementById("txtFldServiceVendrId").value;
	
	
	if(strMastVendorId == ""){
		$("select").attr("disabled",false);
		assetVendorForm.action = "assetVendorInsert.do";
		assetVendorForm.submit();
		
	}
	else if(strMastVendorId != "") 
	{
		$("select").attr("disabled",false);
		assetVendorForm.action = "assetVendorUpdate.do";
		assetVendorForm.submit();
	}
	
	else
		{
		$("select").attr("disabled",false);
		assetVendorForm.action = "assetVendorDelete.do";
		assetVendorForm.submit();
		
		}
 }
    
}


function addVendorConRow()
{
	$("#assetVendorContTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	var tbl = document.getElementById('assetVendorContTable'),tblBody = tbl.tBodies[0],
	    len = tblBody.rows.length; 
	 
	if(len>0){
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[3].childNodes[0], CONSTANTS_VAR.KEYIN_VD_CONTACT247))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[4].childNodes[0], CONSTANTS_VAR.KEYIN_VD_KEYPERSON_NAME))return;
		if(!chkMandatoryFields(tblBody.rows[len-1].cells[7].childNodes[0], CONSTANTS_VAR.KEYIN_VD_DIRECT_NO))return;
	}

	
	var row = tblBody.insertRow(len);
	
	var cell0 = row.insertCell(0);
	cell0.innerHTML = '<input type="text" name="txtFldAsstVDcontSlno"  style="width:35px;" id="txtFldAsstVDcontSlno" readonly="readonly" value="'+(len+1)+'" class="writableFieldDHTML" />';
	cell0.style.width="6.3%";
	cell0.childNodes[0].style.textAlign = 'center';
	
	var cell1 = row.insertCell(1);
	cell1.innerHTML = '<input type="checkbox" name="radAsstVDContSelect" id="radAsstVDContSelect" class="writableFieldDHTML"  style="width:67px" onclick="selectRowFun(this)" />'+'<input type="hidden" id="hSelRow" name="hSelRow" value="'+len+'">';
	cell1.style.width="7.4%";
	cell1.childNodes[0].style.textAlign = 'center';
	
	var cell2 = row.insertCell(2);
	cell2.innerHTML = '<input type="text" name="txtFldAsstVDContMode" id="txtFldAsstVDContMode" readonly="readonly" value="'+CONSTANTS_VAR.INSERT_MODE+'" class="writableFieldDHTML" />';
	cell2.childNodes[0].style.textAlign = 'center'; 
	cell2.style.width="6.7%";
	
	var cell3 = row.insertCell(3);
	cell3.innerHTML = '<input type="text" name="txtFldAsstVDCont247" id="txtFldAsstVDCont247" value="" maxlength="150"   class="writableFieldDHTML" onmouseover="assetTooltip(this);" />'+
	'<input type="hidden" name="txtFldAsstVDContId" id="txtFldAsstVDContId" value="" maxlength="20" class="writableFieldDHTML" />'+
	'<input type="hidden" name="txtFldAsstVDContVendrId" id="txtFldAsstVDContVendrId" maxlength="20" value="" class="writableFieldDHTML" />';
	cell3.style.width="13.5%";
	
	var cell4 = row.insertCell(4);
	cell4.innerHTML = '<input type="text" name="txtFldAsstVDContKeyPernme" id="txtFldAsstVDContKeyPernme" value="" maxlength="150"    class="writableFieldDHTML" onmouseover="assetTooltip(this);"/>';
	cell4.style.width="16.9%";
	
	var cell5 = row.insertCell(5);
	cell5.innerHTML = '<input type="text" name="txtFldAsstVDContDesgntn" id="txtFldAsstVDContDesgntn" value="" maxlength="150" class="writableFieldDHTML" onmouseover="assetTooltip(this);"/>';
	cell5.style.width="17.1%";
	
	var cell6 = row.insertCell(6);
	cell6.innerHTML = '<input type="text" name="txtFldAsstVDContMoble" id="txtFldAsstVDContMoble" value="" maxlength="20" class="writableFieldDHTML" onmouseover="assetTooltip(this);"/>';
	cell6.style.width="7.6%";
	
	var cell7 = row.insertCell(7);
	cell7.innerHTML = '<input type="text" name="txtFldAsstVDContVendrOffPerNo" id="txtFldAsstVDContVendrOffPerNo" value=""   maxlength="20" class="writableFieldDHTML" onmouseover="assetTooltip(this);"/>';
	cell7.style.width="15.1%";
	
	var cell8 = row.insertCell(8);
	cell8.innerHTML = '<input type="text" name="txtFldAsstVDContRmks" id="txtFldAsstVDContRmks" value="" maxlength="300" class="writableFieldDHTML" onmouseover="assetTooltip(this);"/>';	
	cell3.childNodes[0].focus();           
}

function editVendorConRow()
{
	var tbl     = document.getElementById('assetVendorContTable'),
	    tblBody = tbl.tBodies[0],
	    tblLen  = tblBody.rows.length;
	if(tblLen <= 0)
	{
		showAlert('No Records do to updation!');
		return;
	}
	if(tblLen > 0)
	{
		for(var rr=0;rr<tblLen;rr++)
		{
	           if(tblBody.rows[rr].cells[1].childNodes[0].checked == true && tblBody.rows[rr].cells[2].childNodes[0].value=="Q"){

				tblBody.rows[rr].cells[2].childNodes[0].value="U";
				tblBody.rows[rr].cells[3].childNodes[0].readOnly=false;
				tblBody.rows[rr].cells[4].childNodes[0].readOnly=false;
				tblBody.rows[rr].cells[5].childNodes[0].readOnly=false;
				tblBody.rows[rr].cells[6].childNodes[0].readOnly=false;
				tblBody.rows[rr].cells[7].childNodes[0].readOnly=false;
				tblBody.rows[rr].cells[8].childNodes[0].readOnly=false;
				
			}

			if(tblBody.rows[rr].cells[1].childNodes[0].checked == true && tblBody.rows[rr].cells[2].childNodes[0].value=="I")
			{
				tblBody.rows[rr].cells[1].childNodes[0].checked = false;
			}

		}		
	}

}

function deleteVendor()
{
//   var TxtFldVendorRep = document.getElementById("txtFldServiceVendrRep").value;
//   var TxtFldName = document.getElementById("txtFldAsstVDServiceName").value;
//
//
//	if((TxtFldVendorRep==null)||(TxtFldName==null))
//		{
//		
//		alert("Inset Rows Before Delete Vendor");
//		}
	
//	alert("Are you sure want to Delete Vendor?");
	
//	var delConfrmMsg;
	
	if(confirm("Are you sure want to Delete Vendor details?")==true)
	{
	
	var assetContactForm=document.getElementById("assetVendorContTable");
	var tBody = assetContactForm.tBodies[0];
	var rowCount = tBody.rows.length;
	
//	if(rowCount<1)
//		{
//		showAlert("No Contact Details Exists for Selected Vendor");
//		return;
//		}
	if((rowCount<1)||(rowCount>=1))
		{
		  for(var i=0;i<rowCount;i++)
			  {
			    var row=tBody.rows[i];
			    mode = row.cells[2].childNodes[0].value;
			   
			         if(mode=='I')
				     {
			        	 row.cells[2].childNodes[0].value ='D';
			        	 tBody.deleteRow(i);
					     rowCount--;
					      i--;
				   	  }
			         if((mode== 'Q')||(mode== 'U'))
			         {
			        	 row.cells[2].childNodes[0].value= 'D';
			        	 
			         }
			  }
		
		
		}
	       var assetVendorForm =document.getElementById("assetForm");
		        $("select").attr("disabled",false);
	           assetVendorForm.action = "assetVendorDelete.do";
	           assetVendorForm.submit();
	}
	
		
}


function tableDeleteRow(tableId,autodelete){
	
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
			}
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





function deleteVendorConRow()
{
	tableDeleteRow("assetVendorContTable",false); 
}

function assetAjax(param) {
	
	var response = "";	
	$.ajax({
		url : "AssetDetails",
		data : param,
		dataType : "json",
		type : "POST",
		async : false,
		success : function(data) {response = data;},
		complete : function() {},
		error : function() {}
	});
	return response;

}

 function viewVendorTblRows(id) {
	 
//	 showLoader();
	 var td=id.parentNode;
//	alert(id.parentNode);
	var tr=td.parentNode
	var MastervendorId= tr.cells[3].childNodes[1].value;
//	alert(MastervendorId);
	var param = "hActionType=SUBVDSEARCH&txtFldAsstVDMastrId="+encodeURIComponent(MastervendorId);
//	alert(param);
	var data = assetAjax(param);
	
	populateAssetVendorTbl(data);
	
	setTimeout(() => {
		hideLoader();
		
	}, 800);
	
	navToVendor();
}
 
 function navToVendorDtlsTab(){

		$("#vendornavdiv").find("ul li").removeClass("active");
		$("#vendornavdiv").find("ul li[id='li_vd_Vendor']").addClass("active");
		$(".tab-content .tab-pane").removeClass("active in");
		$(".tab-content").find("div[id='Vendor']").addClass("active in");
		
          focusTxtFld();
          
          if($("#txtFldServiceVendrRep").val().length>0)
          {
		       if(confirm("Are you want to clear existing vendor details?")==true)
			    {
			      clearVendorDtlsFields();
			     }
          }
          else
          {
        	  navToVendorDtlsTab();
        	  
          }
}
 
 
 function clearVendorDtlsFields()
     {
	
       if($("#txtFldServiceVendrRep").val().length>0)
    	  {
    	$("#txtFldServiceVendrRep").val("");
    	  }
       if($("#txtFldAsstVDServiceName").val().length>0)
	      {
	   $("#txtFldAsstVDServiceName").val("");
	      }
       if($("#txtFldAsstVDServiceAddr1").val().length>0)
	      {
	   $("#txtFldAsstVDServiceAddr1").val("");
	      }
       if($("#txtFldAsstVDServiceAddr2").val().length>0)
	      {
	   $("#txtFldAsstVDServiceAddr2").val("");
	      }
       if($("#txtFldAsstVDServiceAddr3").val().length>0)
	     {
	   $("#txtFldAsstVDServiceAddr3").val("");
	     }
       if($("#txtFldAsstVDServiceCity").val().length>0)
	     {
	   $("#txtFldAsstVDServiceCity").val("");
	     }
       if($("#txtFldAsstVDServiceCountry").val().length>0)
	     {
	   $("#txtFldAsstVDServiceCountry").val("");
	      }
       if($("#txtFldAsstVDServicePcode").val().length>0)
	      {
	   $("#txtFldAsstVDServicePcode").val("");
	      }
       if($("#txtFldAsstVDServiceFax").val().length>0)
	      {
	   $("#txtFldAsstVDServiceFax").val("");
	      }
       if($("#txtFldAsstVDServiceEmail").val().length>0)
	      {
	   $("#txtFldAsstVDServiceEmail").val("");
	      }
       
       if($("#txtFldAsstVDServiceWebsite").val().length>0)
	      {
	   $("#txtFldAsstVDServiceWebsite").val("");
	      }
       if($("#txtFldAsstVDServiceRemarks").val().length>0)
	      {
	   $("#txtFldAsstVDServiceRemarks").val("");
	      }
  
       clearVdContTblRecords('assetVendorContTable');
   
     }
 
 function clearVdContTblRecords(tblId)
    {
	    var assetContactForm=document.getElementById("assetVendorContTable");
		var tBody = assetContactForm.tBodies[0];
		var totalRows = tBody.rows.length;
	      if(totalRows>0)
	    	  {
	    	  for(var del=0;del<totalRows;del++)
	    		  {
	    		   tBody.deleteRow(0);
	    		  
	    		  }
	    	  }
	  	
    }
 
 function populateAssetVendorTbl(responce) {
	 
		var retval = responce;
		
		for ( var val in retval) {
			
			var tabdets = retval[val];
			
			for ( var tab in tabdets) {
				
				if (tabdets.hasOwnProperty(tab)) {
					
					var key = tab;
					var value = tabdets[tab];
					        
					if(key == "MASTER_VENDOR_DETAILS"){
						
						for ( var formfield in value) {
							
							if (value.hasOwnProperty(formfield)) {							
								var fieldvalue = value[formfield];	
							document.getElementById(formfield).value=fieldvalue;
							}
						}
					}
					
					if(key == "VENDOR_CONTACT_DETAILS")

				{
						var j=0;
					
					clearRecords('assetVendorContTable');
					
					for ( var ip in value) {
							j = j+1;
							var vvv = value[ip];

							
						
								var tbl = document.getElementById('assetVendorContTable'), 
							tblBody = tbl.tBodies[0];
								var rl = tblBody.rows.length;
							var row = tblBody.insertRow(rl);
								var cell0 = row.insertCell(0);
				
						   cell0.innerHTML = '<input type="text" name="txtFldAsstVDcontSlno"  id="txtFldAsstVDcontSlno" readonly="readonly"  class="readOnlyFieldDHTML"  value="'+ (j)+'" />';
						   cell0.style.width="6.3%";
						   cell0.childNodes[0].style.textAlign = 'center';
						
						   
						   var cell1 = row.insertCell(1);
							cell1.innerHTML = '<input type="checkbox" name="radAsstVDContSelect" id="radAsstVDContSelect" style="width:100%" onclick="selectRowFun(this)" />'+
							'<input type="hidden" id="hSelRow" name="hSelRow" value="" />';
							cell1.style.width="7.4%";
							cell1.childNodes[0].style.textAlign = 'center';
							
							var cell2 = row.insertCell(2);
							cell2.innerHTML = '<input type="text" name="txtFldAsstVDContMode" id="txtFldAsstVDContMode" readonly="readonly" value="'+ CONSTANTS_VAR.QUERY_MODE+ '" class="readOnlyFieldDHTML" readonly="readonly" />';
							cell2.style.width="6.7%";
							cell2.childNodes[0].style.textAlign = 'center';
							
							
							var val="ContactId"+chkNull(vvv['txtFldAsstVDContId'])+"<br><br/>"+
							"VendorId"+chkNull(vvv['txtFldAsstVDContVendrId'])+"<br><br/>"+
							"CreatedUser"+chkNull(vvv['txtFldAsstVDContCrUsrId'])+"<br><br/>"+
							"CreatedDate"+chkNull(vvv['txtFldAsstVDContCrDate'])+"<br><br/>"+
							"ModifiedUser"+chkNull(vvv['txtFldAsstVDContMdfyUsrId'])+"<br><br/>"+
							"ModifiedDate"+chkNull(vvv['txtFldAsstVDContMdfyDate']);
							 
							
							var cell3 = row.insertCell(3);
							cell3.innerHTML = '<input type="text" name="txtFldAsstVDCont247" id="txtFldAsstVDCont247" value="'+ chkNull(vvv["txtFldAsstVDCont247"])+ '"  onmouseover="assetTooltip(this);"  maxlength="150" class="readOnlyFieldDHTML" readonly="readonly" />'+
							'<input type="hidden" name="txtFldAsstVDContId" id="txtFldAsstVDContId"  value="'+ chkNull(vvv["txtFldAsstVDContId"])+ '" maxlength="20" class="readOnlyFieldDHTML" readonly="readonly" />'+
							'<input type="hidden" name="txtFldAsstVDContVendrId" id="txtFldAsstVDContVendrId" maxlength="20" value="'+ chkNull(vvv["txtFldAsstVDContVendrId"])+ '" class="readOnlyFieldDHTML" readonly="readonly" />'+
							'<input type="hidden" name="txtFldAsstVDContCrUsrId" id="txtFldAsstVDContCrUsrId" value="'+ chkNull(vvv["txtFldAsstVDContCrUsrId"])+ '" maxlength="150" class="readOnlyFieldDHTML" readonly="readonly" />'+
							'<input type="hidden" name="txtFldAsstVDContCrDate" id="txtFldAsstVDContCrDate" value="'+ chkNull(vvv["txtFldAsstVDContCrDate"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="readonly" />'+
							'<input type="hidden" name="txtFldAsstVDContMdfyUsrId" id="txtFldAsstVDContMdfyUsrId" value="'+ chkNull(vvv["txtFldAsstVDContMdfyUsrId"])+ '" maxlength="150" class="readOnlyFieldDHTML" readonly="readonly" />'+
							'<input type="hidden" name="txtFldAsstVDContMdfyDate" id="txtFldAsstVDContMdfyDate" value="'+ chkNull(vvv["txtFldAsstVDContMdfyDate"])+ '" maxlength="30" class="readOnlyFieldDHTML" readonly="readonly" />';
							cell3.style.width="13.5%";
							
							var cell4 = row.insertCell(4);
							cell4.innerHTML = '<input type="text" name="txtFldAsstVDContKeyPernme" id="txtFldAsstVDContKeyPernme" value="'+ chkNull(vvv["txtFldAsstVDContKeyPernme"])+ '" onmouseover="assetTooltip(this);" vmaxlength="150" class="readOnlyFieldDHTML" readonly="readonly" />';
							cell4.style.width="16.9%";
							
							var cell5 = row.insertCell(5);
							cell5.innerHTML = '<input type="text" name="txtFldAsstVDContDesgntn" id="txtFldAsstVDContDesgntn" value="'+ chkNull(vvv["txtFldAsstVDContDesgntn"])+ '" onmouseover="assetTooltip(this);" maxlength="150" class="readOnlyFieldDHTML" readonly="readonly" />';
							cell5.style.width="17.1%";
							
							var cell6 = row.insertCell(6);
							cell6.innerHTML = '<input type="text" name="txtFldAsstVDContMoble" id="txtFldAsstVDContMoble" value="'+ chkNull(vvv["txtFldAsstVDContMoble"])+ '" onmouseover="assetTooltip(this);" maxlength="20" class="readOnlyFieldDHTML" readonly="readonly" />';
							cell6.style.width="7.6%";

							var cell7 = row.insertCell(7);
							cell7.innerHTML = '<input type="text" name="txtFldAsstVDContVendrOffPerNo" id="txtFldAsstVDContVendrOffPerNo" value="'+ chkNull(vvv["txtFldAsstVDContVendrOffPerNo"])+ '" onmouseover="assetTooltip(this);" maxlength="20" class="readOnlyFieldDHTML" readonly="readonly" />';
							cell7.style.width="15.1%";
			
							var cell8 = row.insertCell(8);
							cell8.innerHTML = '<input type="text" name="txtFldAsstVDContRmks" id="txtFldAsstVDContRmks" value="'+ chkNull(vvv["txtFldAsstVDContRmks"])+ '" onmouseover="assetTooltip(this);" maxlength="300" class="readOnlyFieldDHTML" readonly="readonly" />';
						
					}
				
					}
				}
				
			}
			
		}
		
	}

 function clearRecords(tblId, typ) {
		var tbl = document.getElementById(tblId), tblBody = tbl.tBodies[0], tblLen = tblBody.rows.length;

		var hdrSelObj = document.getElementById('chkVdbox');
		
		if (typ && typ == 'CLR') {

			if (tblLen <= 0) {
				showAlert(CONSTANTS_VAR.NO_RECORDS);
				return;
			}
		}

		if (tblLen > 0) {

			for (var rmv = 0; rmv < tblLen; rmv++) {
				tblBody.deleteRow(0);
			}
		}
		if (hdrSelObj.checked)
			hdrSelObj.checked = false;

	}

 
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
		}
	}
}




