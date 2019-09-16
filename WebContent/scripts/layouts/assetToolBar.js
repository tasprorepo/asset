/**
 * This file contains the functionalities related to the 
 * Tool bar buttons in the ASSET Application
 * @author Johnson K I
 * @created on 22/06/2015
 */



// ******************************************** //
// ******************************************** //
//  TOOL BAR BUTTONS CONFIGURATION STARTS HERE  //
// ******************************************** //
// ******************************************** //

function toolbarFun(){
	
	$( "#assetToolBarBtnSrch" ).button({
	     icons: {
	     primary: "ui-icon-search"
	     }
	   }).click(function(){
		   toolBarSrchFun();
	   });
	
  $( "#assetToolBarBtnAdd" ).button({
    icons: {
    primary: "ui-icon-circle-plus"
    }
  }).click(function(){
	   toolBarAddFun();
  });
  
  
  $( "#assetToolBarBtnEdit" ).button({
	     icons: {
	     primary: "ui-icon-pencil"
	     }
	   }).click(function(){
		   toolBarEditFun();
	   });
  
  $( "#assetToolBarBtnSave" ).button({
	     icons: {
	     primary: "ui-icon-disk"
	     }
	   }).click(function(){
		   toolBarSaveFun();
	   });
  
  $( "#assetToolBarBtnCancl" ).button({
	     icons: {
	     primary: "ui-icon-circle-close"
	     }
	   }).click(function(){
		   toolBarCancelFun();
	   });
  
  $( "#assetToolBarBtnDel" ).button({
	     icons: {
	     primary: "ui-icon-trash"
	     }
	   }).click(function(){
		   toolBarDelFun();
	   });
  
  $( "#assetToolBarBtnRefresh" ).button({
	     icons: {
	     primary: "ui-icon-refresh"
	     }
	   }).click(function(){
		   toolBarAddRefreshFun();
	   });
  
  $( "#assetToolBarBtnPrnt" ).button({
	     icons: {
	     primary: "ui-icon-print"
	     }
	   }).click(function(){
		   toolBarPrntFun();
	   });
  $( "#assetToolBarBtnContact" ).button({
	     icons: {
	     primary: "ui-icon-print"
	     }
	   }).click(function(){
		   toolBarContactFun();
	   });
  
  
  	showTooltip('btnSearch','Search Details');
	showTooltip('btnSave','Save Records'); 
	showTooltip('assetHeaderLinkLogout','Logout'); 
	
}//end of toolbarFun
   
   // TOOL BAR BUTTONS CONFIGURATION ENDS HERE 

