<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="s" uri="/struts-tags" %>
  <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css">
  <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
 <%-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
  <script type="text/javascript" src="scripts/jquery.min.js"></script>
  <script type="text/javascript" src="scripts/bootstrap.min.js"></script>
   <script type="text/javascript" src="scripts/ASSETConstants.js"></script>
   <script type="text/javascript" src="scripts/CommonScripts.js"></script>
   <script type="text/javascript" src="scripts/ASSETScripts.js"></script>
 <title>Asset Infra Application</title> 

<script>
 //Login Screen Asset Infra 
var browserName=navigator.appName;
if (browserName=="Netscape"){ 
	//window.resizeTo(720,430);
}
else if (browserName=="Microsoft Internet Explorer"){
	//window.resizeTo(720,430); 			  
 }
else if(browserName=="chrome"){
	//window.resizeTo(720,430); 			  
 } 
//window.moveTo(300,200);
window.offscreenBuffering=true;



function validateform(){ 
	var username=document.Loginvalidation.username.value;  
	var userpassword=document.Loginvalidation.password.value;  
	 
	if (isEmptyFld(username)){  
		  showAlert("UserName can't be blank",$("#usernametxtid"));   
		  return false;  
		}else if(isEmptyFld(userpassword)){  
		  showAlert("Password can't be blank",$("#passwordtxtid"));   
		  return false;  
		  
		  }  
	document.Loginvalidation.action="LoginProcess.do";
	document.Loginvalidation.submit();
}

// focus function for UserID Login
function focusFunction() 
	{
	 document.getElementById("usernametxtid").focus();
	 $("usernametxtid").focus();
    }
    
 function resetFunction() {
    document.getElementById("myForm").reset();
}
  
function focusUserFunction() 
{
 document.getElementById("usernametxtid").focus();
 $("usernametxtid").focus();
}

function focusUserPwdFunction() 
{
 document.getElementById("passwordtxtid").focus();
 $("passwordtxtid").focus();
}

	

</script>

<style type="text/css">
   body {
    background-color: #F8F8F8;
}
    table thead tr th {
      background-image: url("../images/gradient.jpg");
      background-repeat: repeat-x;
   }
   .assetToolBarBtnCls{
   padding: 4px;
   background-image: url("../images/gradient.jpg");
   height: 30px;
   width: 60px;
   margin-left: 80px;
display: inline-block;
  }
   .editableField{
  font-family: Calibri;
  font-size: 9pt;
  background-color: white;	
}
.titleCls{
    font-weight: bold;
    font-size: 15pt;
    font-family: Calibri;
  }
  #assetToolBar 
   {
padding: 4px;
display: inline-block;
   }

  
</style>

</head>
<body onload="focusFunction()">

<form name ="Loginvalidation"  autocomplete="off" method="post">
<table align="center" border="0" cellpadding="0" cellspacing="0" height="100%"  >	
	
	 <tr>
		<td height="100%">&nbsp;</td>
	</tr>
	<tr>
			<td height="100%">&nbsp;</td>
			</tr> 
	<tr>
	 
	 
		<td width="50%"  class="titleCls">
		<center>Avallis Asset System</center></td>
	</tr>
	
	<tr>
	<td>
	<!--login modal-->
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
  
      <div class="modal-header">
      <img  align="left" src="images/logo_AVALLIS.png"  height="25%"  width="22%" >
       <h1 class="text-center"><font face ="Calibri"><b>Avallis Asset System</b></font></h1>
        
      </div>
      <div class="modal-body">
     
            <div class="form-group">
              <input type="text" id="usernametxtid" class="form-control input-lg" name ="username" placeholder="User Id">
            </div>
            <div class="form-group">
              <input type="password" id="passwordtxtid" class="form-control input-lg" name="password" placeholder="Password">
            </div>
            <div class="form-group text-center">
            
            <input type="button" class="btn btn-success"   onclick="validateform()" value="Sign-In">
            <button class="btn btn-default" data-dismiss="modal"   aria-hidden="true" onclick="resetFunction()">Reset</button>
            </div>  
      </div>
  </div>
  </div>
</div>
	</td>
	</tr>
</table>

</form>
	<div class="modal fade bs-example-modal-sm"  id="alertmsglogdiv" style="display: none;" 
tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel"></h4>
      </div>
      <div class="modal-body">
      <div id="alertimg" style="display: inline;"></div>
      <div id="alertmsg"  style="text-align: center; display: inline-block;"></div> 
      </div>
       <div class="modal-footer" > 
        <button type="button" class="btn btn-primary" >Ok</button> 
      </div>
      </div>
      </div>
      </div>
</body>
</html>


