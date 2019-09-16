<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
  .titleCls{
    font-weight: bold;
    font-size: 12pt;
    font-family: Calibri;
  }
  
  a{
  text-decoration: none;
  margin: 0;
  padding: 0;
  }
  
  .assetHeaderLinkCls{
    padding-right: 15px;
    font-size:9pt;
    font-weight: bold;
  }
   label, input { display:block; }
   input.text { margin-bottom:12px; width:95%; padding: .4em; }
   fieldset { padding:0; border:0; margin-top:25px; }
</style>

 <script>
$(function() 
		{ 
	toolbarFun();
});
</script>

</head>
<body> 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="">
      <a class="navbar-brand" href="#" style="margin: -14px;">
      <img src="images/indexs.jpg" width="30%"/></a>   
    </div>  
    <div class="pull-right" style="margin-top: 10px;">
          <img  src="styles/images/searchicon.png"  height="30px"  style="width: 36px;height: 36px;" id="btnSearch" name="btnSearch"  title="Search" onclick="toolBarSrchFun()"/>
             <img  src="styles/images/saveicon.png"  height="32px" style="width: 36px;height: 36px;"  id="btnSave" name="btnSave"  title="Save" onclick="toolBarSaveFun()"/>
      
     <button type="button" class="btn btn-primary assetHeaderLinkCls" id="assetHeaderLinkLogout" name="assetHeaderLinkLogout">
          <span class="fa fa-sign-out"></span> Log out
        </button> </div>
  </div>
</nav>
 

</body>
</html>