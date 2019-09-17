<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="styles/bs/bs.sidemenu.css" /> 
<script src="scripts/bootstrap.min.js"></script>   

<title></title>
 

</head>

<body> 
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button> 
        </div>
        <div id="navbarCollapse" class="collapse navbar-collapse" style="margin-left: 0px;">
            <div class="navbar-form navbar-left scrollsidebar" id="assetsidemenu">
             <ul class="nav" id="side-menu">
                    <li style="padding: 0px 0 0;" id="liassethard"> 
                        <a class="waves-effect" onclick="selectFunction('ASSETHARD');">
                         <i aria-hidden="true" class="fa fa-desktop"></i> 
                            <span class="hide-menu">Asset Hardware</span>
                        </a>
                    </li>
                      <li style="padding: 10px 0 0;" id="liassetsoft"> 
                         <a onclick="selectFunction('ASSETSOFT');">
                            <span class="sidebar-icon"><i class="fa fa-hdd-o"></i></span>
                            <span class="sidebar-title">Asset Software</span>
                        </a>
                    </li>
                      <li style="padding: 10px 0 0;" id="liassetvendor"> 
                          <a onclick="selectFunction('ASSETVENDOR');">
                            <span class="sidebar-icon"><i class="fa fa-users"></i></span>
                            <span class="sidebar-title">Asset Vendor</span>
                        </a>
                    </li>
                      <li style="padding: 10px 0 0;" id="liassetservicetrack"> 
                       <a onclick="selectFunction('SERVICETRACK');">
                            <span class="sidebar-icon"><i class="fa fa-cogs"></i></span>
                            <span class="sidebar-title">Service Tracking</span>
                        </a>
                    </li>
                      <li style="padding: 10px 0 0;" id="liassetattachment"> 
                        <a onclick="selectFunction('ASSETATTACHMENTS');">
                            <span class="sidebar-icon"><i class="fa fa-paperclip"></i></span>
                            <span class="sidebar-title">Attachments</span>
                        </a>
                    </li>
                      <li style="padding: 10px 0 0;" id="liassetrenewal">  
                      <a onclick="showAlert('Work in progress!');">
                            <span class="sidebar-icon"><i class="fa fa-bell"></i></span>
                            <span class="sidebar-title">Renewal Reminder</span>
                        </a>
                    </li>
                     
                </ul>     
            </div>
        </div>
    </nav>
 
</body>

</html>