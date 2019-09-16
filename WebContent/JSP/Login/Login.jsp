<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="s" uri="/struts-tags" %> 
<link rel="stylesheet" href="styles/bootstrap.min.css" type="text/css"> 
  <script type="text/javascript" src="scripts/jquery.min.js"></script>
  <script type="text/javascript" src="scripts/bootstrap.min.js"></script>
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
	//alert("testloginfun");
	var username=document.Loginvalidation.username.value;  
	var userpassword=document.Loginvalidation.password.value;  
	 
	if (username==null || username==""){  
		  alert("UserName can't be blank");  
		  focusUserFunction();
		  return false;  
		}else if(userpassword==null||userpassword==""){  
		  alert("Password can't be blank");  
		  focusUserPwdFunction();
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

<form name ="Loginvalidation"  method="post">
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
     
       <s:actionmessage />
  
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block">
            <div class="form-group">
              <input type="text" id="usernametxtid" class="form-control input-lg" name ="username" placeholder="User Id">
            </div>
            <div class="form-group">
              <input type="password" id="passwordtxtid" class="form-control input-lg" name="password" placeholder="Password">
            </div>
            <div class="form-group">
            <table>
            
            <tr>
           
            <!-- <input type="button"  class="btn btn-primary btn-lg btn-block" onclick="validateform()"value="Sign-In"> -->
           <td  height="5">&nbsp;</td> 
          <td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
           <td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
           <td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
           <td> <input type="button" class="btn"   onclick="validateform()" value="Sign-In"> </td>
           <td  width="25">&nbsp;</td> 
            <td >  <button class="btn" data-dismiss="modal"   aria-hidden="true" onclick="resetFunction()">Reset</button></td>
           
            </tr>
            
            </table>
          
              
            </div>
          </form>
      </div>
     <!--  <div class="modal-footer">
          <div class="col-md-12">
          <button class="btn" data-dismiss="modal" aria-hidden="true" onclick="resetFunction()">Reset</button>
		  </div>	
      </div> -->
  </div>
  </div>
</div>
	</td>
	<%-- 	<td>
		 <div id="assetToolBar" style='background-color:#ccc;height: 100%;width: 100%' class="ui-widget-content ui-corner-all" >
			<table align="center" >
			
			<tr>
			<td height="100%">&nbsp;</td>
			</tr>
			
			
			<tr>
					<td style="font-family:calibri;" > User Id:</td>
					<td><input  type="text" id="usernametxtid" class="editableField" name ="username"/></td>
				</tr>
				<tr >
					<td style="font-family:calibri;" > Password:</td>
					<td><input type="password" id="passwordtxtid" class="editableField" name="password"/></td>
				</tr>
				<tr>
     						<td  style="font-family:calibri;" > 
     							<div id="buttons">
     					  	    	<input type="button" id="btnSubmt" value="Submit" class="assetToolBarBtnCls"onclick="validateform()"/>&nbsp;
									<input type="reset" id="btnReset" value="Reset" class="assetToolBarBtnCls" onclick="resetFunction()"/> 
								</div>
     						</td>
     					</tr>
				</table>
			</div>
		</td> --%>
	</tr>
</table>

</form>
</body>
</html>


