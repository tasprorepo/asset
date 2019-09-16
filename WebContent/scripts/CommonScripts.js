/**
 * 
 */


//*************************************//
//       COMMON SCRIPT                 //
//*************************************//


function showLogout(content,fldtofocus) {  
	$("#alertimg").html(""); 
	$("#alertmsg").html(content); 
	$('#alertmsglogdiv').modal({
		  backdrop: 'static',
		  keyboard: false,
		  show:true,
		});
	
	$('#alertmsglogdiv').on('shown.bs.modal', function() {  
		  $(this).find(".modal-title").text("Asset System Notification");
		  $(this).find(".modal-footer").find("button:eq(0)").unbind();
		  $(this).find(".modal-footer").find("button:eq(0)").click(function (){  
			  window.location = "/AssetSystem/";
			  $('#alertmsglogdiv').modal('hide'); 
		}); 
	});   
   
}



function showAssetModel(dialogId,dialogTitle){
	 

	$('#'+dialogId).on('shown.bs.modal', function() {  
		  $(this).find(".modal-title").text(dialogTitle);
		  $(this).find(".modal-footer").find("button:eq(0)").unbind();   
		});
		$('#'+dialogId).modal({
		  backdrop: 'static',
		  keyboard: false,
		  show:true
		});

}


function showTooltip(id,strTooltipContent){
	 
	 $("#"+id).qtip({
	 		content: {text : strTooltipContent },
//	         show: 'keypress',
//	         hide: 'keypress',        
	         style: {
	             classes: 'qtip-green qtip-rounded qtip-shadow'
	         }, position: {
	             my: 'top left',   
	             at: 'bottom left', 
	             viewport: $(window),
	             target: $("#"+id)  
	         }  
	     });
}


//function showTooltip(id,strTooltipContent){
//  	
// 	 $("#"+id).qtip({
// 	 		content: {text : strTooltipContent},
//// 	         show: 'keypress',
//// 	         hide: 'keypress',        
// 	         style: {
// 	             classes: 'qtip-grey qtip-rounded qtip-shadow'
// 	         }, position: {
// 	             my: 'top left',   
// 	             at: 'bottom left', 
// 	             viewport: $(window),
// 	             target: $("#"+id)  
// 	         }  
// 	     });
// 	
// }




function trim(stringToTrim)
{
    return stringToTrim.replace(/^\s+|\s+$/g,"");
}//end trim 

function chkMandatoryFields(elem,message)
{
	//alert("chkMandatoryFields");
	if(chkEmpty(elem.value))
	{		
		showAlert(message);
		elem.focus();
		return false;
	}//end of if
	return true;
}//end of chkMandatoryFields

function chkModelMandatory(elem,message)
{ 
	if(chkEmpty(elem.val()))
	{		
		showAlert(message,elem); 
		return false;
	}//end of if
	return true;
}//end of chkMandatoryFields

function chkEmpty(value){
	
	if(value == null  ||  value.length == 0 )
		return true;
	else
		return false;
	
}//end of chkEmpty


function isEmptyFld(value){
	
	if(value == null  ||  value.length == 0  || value == "")
		return true;
	else
		return false;
	
}//end of chkEmpty


function openWeblink(elmid){
	var elm=$(elmid).val();
	if(!isEmpty(elm)){
		$("a#weblink").attr("href","//"+elm);
	}
}
