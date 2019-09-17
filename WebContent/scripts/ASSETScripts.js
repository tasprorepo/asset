/**
 * This is the common script for the ASSET application
 */

// ***************** GLOBAL VARIABLES *****************

  var bldGrp = '';
  var gendrVal = '';
  var themeID = '';
  var HOSP_CNTRLLS=
  {
		  HOSP_FIELDS : ['txtFldASSETHospName','txtFldASSETHospCode','txtFldASSETHospAddr1','txtFldASSETHospCity',
			             'txtFldASSETHospAddr2','txtFldASSETHospState','txtFldASSETHospAddr3','txtFldASSETHospCntry',
			             'txtFldASSETHospRmks']
  };
  
// *****************  END OF GLOBAL VARIABLES ***************** 

  function showLoader(){
	    $(".loading").show();
	     $("footer").css("display","none");
	     
  }
  function hideLoader(){
	    $(".loading").hide();
	    $("footer").css("display","inline-block"); 
	       
	}//end of hideLoader
  function showAlert(content,fldtofocus) {  
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
				  
				  if(content == CONSTANTS_VAR.KEYIN_VD_REP  || 
						  content == CONSTANTS_VAR.KEYIN_VD_NAME  || 
						  content == CONSTANTS_VAR.KEYIN_VD_EMAIL ){
					  navToVendor();
				  }
				  $('#alertmsglogdiv').modal('hide'); 
				  if(fldtofocus)fldtofocus.focus(); 
			}); 
		});   
	   
	}  

  function navToVendor(){

		$("#vendornavdiv").find("ul li").removeClass("active");
		$("#vendornavdiv").find("ul li[id='li_vd_Vendor']").addClass("active");
		$(".tab-content .tab-pane").removeClass("active in");
		$(".tab-content").find("div[id='Vendor']").addClass("active in");
	}
  

  function showTooltip(id,strTooltipContent){
  	
  	 $("#"+id).qtip({
  	 		content: {text : strTooltipContent},
//  	         show: 'keypress',
//  	         hide: 'keypress',        
  	         style: {
  	             classes: 'qtip-grey qtip-rounded qtip-shadow'
  	         }, position: {
  	             my: 'top left',   
  	             at: 'bottom left', 
  	             viewport: $(window),
  	             target: $("#"+id)  
  	         }  
  	     });
  	
  }
  

  function ImgTooltip(obj){ 
	  	var objval = $(obj).attr("title");   
	  	 
	  		$(obj).isDisabled = true;
	  	      $(obj).qtip({ 
	  	         content: {
	  	        	 text:$(obj).val(),
	  	               title: { 
	  	                  button: false
	  	               }  
	  	         }, 
	  	         show: {solo: true, ready: false, when: 'mouseover'},
	  	         hide: { when: 'mouseout', fixed: true },
	  	         style: {
	  	                classes: 'qtip-grey qtip-rounded qtip-shadow'
	  	            },
	  	            position: {
	  	                my: 'top left',   
	  	                at: 'bottom left', 
	  	                viewport: $(window),
	  	                target: $(obj)  
	  	            }    
	  	      });
	  	      
	  	      
	  	      if(!(objval == "")){ 
	  	    	  	$(obj).qtip('show'); 
	  	      }else
	  	      {
	  	    		$(obj).qtip('disable'); 
	  	      }	 
	  	 
	  	 
	  }
  
  function assetTooltip(obj){ 
  	var objval = $(obj).val();   
  	 
  		$(obj).isDisabled = true;
  	      $(obj).qtip({ 
  	         content: {
  	        	 text:$(obj).val(),
  	               title: { 
  	                  button: false
  	               }  
  	         }, 
  	         show: {solo: true, ready: false, when: 'mouseover'},
  	         hide: { when: 'mouseout', fixed: true },
  	         style: {
  	                classes: 'qtip-grey qtip-rounded qtip-shadow'
  	            },
  	            position: {
  	                my: 'top left',   
  	                at: 'bottom left', 
  	                viewport: $(window),
  	                target: $(obj)  
  	            }    
  	      });
  	      
  	      
  	      if(!(objval == "")){ 
  	    	  	$(obj).qtip('show'); 
  	      }else{
  	    		$(obj).qtip('disable'); 
  	      }	 
  	 
  	 
  }
  
  function removeInfoError(tblid){ 
		 $("#"+tblid+"_info").hide(); 
	}
	function showInfoError(tblid){
		 
		 $("#"+tblid+"_info").show(); 
	}


  function ctrlOverFlowDataTable(tblid){
		 
		$("#"+tblid+"_wrapper").css("width","98%");
		$("#"+tblid+"_wrapper").find(".dataTables_scrollBody").css("width","101.6%");
		$("#"+tblid+"_wrapper").find(".dataTables_scrollBody").css("overflow","scroll"); 
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
  
  function isValidObject(objToTest) 
  {
  	
    if (objToTest == null || objToTest == undefined) 
    { 
      return false;
    }

   return true;
  }//end isValidObject

  
  
	function reorderTableRows(tblName,reorderflg) {
		
		if(reorderflg){
		
			var tblObj = document.getElementById(tblName);
			var rowLen = tblObj.tBodies[0].rows.length;	
			var tBodyObj = tblObj.tBodies[0];
			
			for(var i=0;i<rowLen;i++)
			{
				
		         var lclIndex = i+1;
		         if(tBodyObj.rows[i].cells[0].firstChild)
		        	 tBodyObj.rows[i].cells[0].firstChild.value =lclIndex;        	
		        
			} 	
		}
	}//end incrIndex
	
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
				
		setTimeout(function(){
				hideLoader(); //hides loader
				  },500);
				
			},error        : function(){
				
			}
		});
		return response;
	}//end of assetAjax

	function selectRowFun(chkObj)
	{
	//	alert("test");
		if(chkObj.checked)
		{
			selRowArr.push(chkObj.parentNode.childNodes[1].value) ; 
		}//end of id
		
	}//end of selectRowFun


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
		
		
		 showInfoError(tblId);
		//if(hdrSelObj.checked)hdrSelObj.checked = false;
	}//end of clearRecords


  function validateDate(elmid){
  	var input = trim($(elmid).val()); 
  	var pattern =/^([0-9]{2})\/([0-9]{2})\/([0-9]{4})$/; 
  	if(!isEmptyFld(input)){
	  	if(pattern.test(input)==false){
	  		showAlert("Invalid Date Format",$(elmid));
	  		$(elmid).val(""); 
	  		return false;  
	  	}
  	}
  	
  } 
function submitFun()
{
	document.forms[0].submit();
	window.open("hello","ASSET","width=500,height=300,left=400,top=240");
}//end of submitFun

function isEmpty(elem)
{
	if(elem.value == '' && elem.value.length <= 0){  return true;}
	else return false;
}//end of isEmpty

function setTheme(themeVal)
{
	  var i,a,selVal = '';
	  if(themeVal)
	     {
		  selVal = themeVal;
	     }
	  
	  for(i=0;(a = document.getElementsByTagName('link')[i]);i++)
	  {
	  if(a.getAttribute('rel').indexOf('style') != -1 && a.getAttribute('title'))
	     {
	       a.disabled = true;
	       if(a.getAttribute('title') == selVal)a.disabled = false;
	     }//end of if
	
	  }//end of for
	  
}//end of setTheme

/**
 * This method is used to disable all the events in the 
 * screen and mainly used before login into the system
 * @param none
 */
function assetOnloadFun()
{
	//disableAll();
	var layoutHght = document.getElementById('layoutSkeleton');
	layoutHght.style.height =  parseInt(getHeight())-110+'px';
	hideLoader();
	
}//end of assetOnloadFun

function selectFunction(screen)
{
	//alert("TEstr")
	var assetForm = '';
	for(var scr in ASSET_SCREENS)
	{
	
		if(scr == screen)
		{
			//alert(screen)
			var value = ASSET_SCREENS[scr].split('^'),
			    header = value[0],
			    dets = value[1];
			$('#sideMenuAboutHeader').html(header);
			$('#sideMenuAboutDets').html(dets);
 
			
			assetForm = document.getElementById('assetForm');
		 if(screen == 'ASSETHARD')
		 {
				assetForm.action = 'AssetHardPre.do';
				assetForm.submit();
				
	     }//end of if 
		 if(screen == 'ASSETSOFT')
		 {
				assetForm.action = 'AssetSoftPre.do';
				assetForm.submit();
		 }//end of else if
		if(screen == 'ASSETVENDOR')
			{ 
			assetForm.action = 'AssetVenPre.do';
				assetForm.submit();
		}
		if(screen == 'SERVICETRACK')
		{ 
			assetForm.action = 'ServiceTrackPre.do';
			assetForm.submit();
		}
	
		if(screen == 'RENEWALREMAIND')
		{ 
			assetForm.action = 'RenewalRemaindPre.do';
			assetForm.submit();
		}
		//alert("screen"+screen)
		if(screen == 'ASSETATTACHMENTS')
		{ 
			//alert("ASSETATTACHMENTS");
			assetForm.action = 'AssetAttachmentsPre.do';
			assetForm.submit();
		}
	
		}//end of if	
	}//end of for
}//end of selectFunction


function disableAll()
{
	$('.assetToolBarBtnCls').each(function()
			{
		$(this).prop({disabled:true});
	});
	
	$('.assetSideMenuListCls').each(function()
			{
		if($(this).hasClass('assetSideMenuListCls'))
		{
			$(this).addClass('ui-state-disabled').prop('onclick',null);
		}
	});
	
	
}//end of disableAll

function enableAll()
{
	
	$('.assetToolBarBtnCls').each(function()
			{
		if($(this).is(':disabled'))$(this).prop({disabled:false});
	});
	
	$('.assetSideMenuListCls').each(function()
			{
		if($(this).hasClass('assetSideMenuListCls'))
		{
			if($(this).hasClass('ui-state-disabled'))$(this).on('click').removeClass('ui-state-disabled');
		}
	});
	
	
}//end of enableAll




function assignTheme(imgObj)
{
	var themeVal = '';
	
	document.getElementById('hTxtFldASSETThemes').value = '';
	if(imgObj)
		themeVal = imgObj.alt;
	
	document.getElementById('hTxtFldASSETThemes').value = themeVal;
	setTheme(themeVal);
	
}//end of assignTheme


function setBldGrp(bldGrpVal,selObj)
{
	
	var bldGrp = bldGrpVal;
	var bldTyps = bldGrp.split('^');
	
	selObj.options[0] = new Option('--Select--','');
	
	for(var bld=0;bld<bldTyps.length;bld++)
	{
		var bldList = bldTyps[bld].split('=');
		selObj.options[selObj.options.length] = new Option(bldList[1],bldList[0]);
	}//end of for
	
}//end of setBldGrp()

function setGender(gendrVal,selObj)
{
	var gendr = gendrVal;
	var gendrTyps = gendr.split('^');
	
	selObj.options[0] = new Option('--Select--','');
	
	for(var gen=0;gen<gendrTyps.length;gen++)
	{
		var genList = gendrTyps[gen].split('=');
		selObj.options[selObj.options.length] = new Option(genList[1],genList[0]);
	}//end of for
	
}//end of setBldGrp()




function getHeight()
{
	  
	  if (self.innerHeight) 
	  {
		    return self.innerHeight;
	  }

		  if (document.documentElement && document.documentElement.clientHeight) 
		  {
		    return document.documentElement.clientHeight;
		  }

		  if (document.body) 
		  {
		    return document.body.clientHeight;
		  }
		  
}//end of getHeight