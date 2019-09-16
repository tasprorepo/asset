function VendorAddRow(dataset)
{

	 vndrclearFlds();
	 showAssetModel('Vendorfreeformdiv','Asset Vendor Details'); 
	 vndrMethods('Vendorfreeformdiv',dataset,'INS','','');   

}//end of VendorAddRow

function vndrclearFlds()
{
	$("#Vendorfreeformdiv").find("input[type=text]").val("");
		$("#Vendorfreeformdiv").find("select").val("");      
	
}
	


function vndrRdlyflds(mode){
	 
	if(mode == CONSTANTS_VAR.QUERY_MODE){
		 $("#Vendorfreeformdiv :input").prop('disabled', true);  
	}else if((mode == CONSTANTS_VAR.INSERT_MODE) || (mode == CONSTANTS_VAR.UPDATE_MODE) ){
		  $("#Vendorfreeformdiv :input").prop('disabled', false); 
		}
	
	$("#Vendorfreeformdiv").find(".modal-footer").find("button:eq(0)").attr("disabled",false);
	$("#Vendorfreeformdiv").find(".modal-footer").find("button:eq(1)").attr("disabled",false);
}


function vndrEditRow(){


	$("#assetVendorNamTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById('assetVendorNamTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetVendorNamTable").find("input[type=checkbox]:checked").length;
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
				 
				
				vndrclearFlds();
		        vndrRdlyflds(CONSTANTS_VAR.UPDATE_MODE);
		        vndrfilldlgval(editCurRow);
		        
			   	showAssetModel('Vendorfreeformdiv','Asset Hardware Details'); 
				vndrMethods('Vendorfreeformdiv','','QRY/UPD',RowId,table);
				  
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
}// end vndrEdit Row 






function EditRow(){
	//alert("Second Edit");

	$("#assetVendorNamTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById('assetVendorNamTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetVendorNamTable").find("input[type=checkbox]:checked").length;
	
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
				
			
				
		        vndrRdlyflds(CONSTANTS_VAR.UPDATE_MODE);
		        vndrfilldlgval(editCurRow);
		        
			   	showAssetModel('Vendorfreeformdiv','Asset Vendor Details'); 
			   	$('#myModal').off("hidden.bs.modal").on('hidden.bs.modal', function () {
			   	 $(this).find("input:text").val("");
			   	})
				vndrMethods('Vendorfreeformdiv','','QRY/UPD',RowId,table);
				var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
				var data = assetAjax(param);// assetAjax function call
				populateAssetVndrTbl(data);
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
}





function hdwViewRow(){

	$("#assetVendorNamTable tbody").find('tr.odd').each(function(){
        $(this).remove();        
     
    });
	
	
	var table = document.getElementById('assetVendorNamTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetVendorNamTable").find("input[type=checkbox]:checked").length;
	
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
						vndrRdlyflds(mode);
						vndrfilldlgval(editCurRow);
						showAssetModel('Vendorfreeformdiv','Asset Vendor Details'); 
						vndrMethods('Vendorfreeformdiv','','INS/UPD',RowId,table);
//						var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
//						var data = assetAjax(param);// assetAjax function call
//						populateAssetHardwareTbl(data);
				 
			}// I/U Mode
				if( (mode == CONSTANTS_VAR.UPDATE_MODE) ){
					 	
					 var RowId=editCurRow.cells[0].childNodes[0].value;		
					 var id=editCurRow.cells[3].childNodes[1].value;
						editCurRow.cells[2].childNodes[0].value = mode;
						chkbox.checked = false;
						vndrRdlyflds(mode);
						vndrfilldlgval(editCurRow);
						showAssetModel('Vendorfreeformdiv','Asset Vendor Details'); 
						vndrMethods('Vendorfreeformdiv','','INS/UPD',RowId,table);
						var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
						var data = assetAjax(param);// assetAjax function call
						populateAssetVndrTbl(data);
				 
			}// I/U Mode
			
			if(mode == CONSTANTS_VAR.QUERY_MODE){
				 var RowId=editCurRow.cells[0].childNodes[0].value;		
				 var id=editCurRow.cells[3].childNodes[1].value;
				 editCurRow.cells[2].childNodes[0].value = mode;
				 chkbox.checked = false;
				 vndrRdlyflds(mode);
				 vndrfilldlgval(editCurRow);
				 showAssetModel('Vendorfreeformdiv','Asset Vendor Details'); 
				 vndrMethods('Vendorfreeformdiv','','QRY',RowId,table);
				 var param = "hActionType=SUBHDSEARCH&aa="+encodeURIComponent(id);
					var data = assetAjax(param);// assetAjax function call
					populateAssetVndrTbl(data);
				   
			}// Q Mode
			
		}
		}
	
}



function hdwDelRow(){
	//alert("delete");


	
	var table = document.getElementById('assetVendorNamTable');
	var tbody = table.tBodies[0];
	var rowCount = tbody.rows.length;	
	var cellCount = table.rows[0].cells.length;
	var checkedlen=$("#assetVendorNamTable").find("input[type=checkbox]:checked").length;
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
			reorderTableRows('assetVendorNamTable',true);
			editFlag = true;
		}
	 
	}
	if(rowCount<1){
		showInfoError('assetVendorNamTable');
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
				reorderTableRows('assetVendorNamTable',true);
			 
		}
		
		
	}
	
}





function vndrfilldlgval(editCurRow){

	//alert("test");
			
			  $('#Vendorfreeformdiv #txtFldServiceVendrId').val(editCurRow.cells[3].childNodes[1].value);
			  $('#Vendorfreeformdiv #txtFldServiceVendrRep').val(editCurRow.cells[3].childNodes[0].value);
			  $('#Vendorfreeformdiv #txtFldAsstVDServiceName').val(editCurRow.cells[4].childNodes[0].value);
			  $('#Vendorfreeformdiv #txtFldAsstVDServiceAddr1').val(editCurRow.cells[5].childNodes[0].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[6].childNodes[0].value);
		 	  $('#Vendorfreeformdiv #').val(editCurRow.cells[6].childNodes[1].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[0].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[1].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[2].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[3].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[4].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[5].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[6].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[7].value);
			  $('#Vendorfreeformdiv #').val(editCurRow.cells[7].childNodes[8].value);
			  $('#Vendorfreeformdiv #txtFldAsstHDFrmCpuSockets').val(editCurRow.cells[7].childNodes[9].value);
			  $('#Vendorfreeformdiv #txtFldAsstHDFrmTotCores').val(editCurRow.cells[7].childNodes[10].value);
			  $('#Vendorfreeformdiv #txtFldAsstHDFrmLogProcess').val(editCurRow.cells[7].childNodes[11].value);
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






