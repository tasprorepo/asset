<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>jQuery UI Tabs - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Nunc tincidunt</a></li>
    <li><a href="#tabs-2">Proin dolor</a></li>
    <li><a href="#tabs-3">Aenean lacinia</a></li>
  </ul>
  <div id="tabs-1">
    <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
  
  <table cellpadding="0" cellspacing="0" border="0" width="99%" height="95%" align="center">
                             <tr>
                                <td height="10%" width="90%">
                                 <table cellpadding="0" cellspacing="0" border="0" width="99%" height="99%" align="center">
                                   <tr>
                                     <td width="20%">
                                       <table cellpadding="2" cellspacing="0" border="0" width="99%" height="99%" align="center">
                                         <tr>
                                           <td width="60%">
                                             
                                           </td>
                                           <td width="40%">
                                             </td>
                                         </tr>
                                       </table>
                                     </td>
                                     <td width="30%">&nbsp;</td>
                                     <td width="25%">&nbsp;</td>
                                     <td width="25%">&nbsp;</td>
                                   </tr>
                                 </table>
                               </td>
                              
                             </tr>
                           
                               <tr>
                              
                               <td  id="servicemenuHdrTr">
                                SERVICE DETAILS : 
                                 <div id="autoUpdate2" class="ui-widget-content ui-corner-all" style="overflow: scroll;width: 650px;height: 150px;" >
                                   <table cellpadding="0" cellspacing="0" border="1" width="650px;"  align="center" id="assetVendorSerTable">
                                   <thead>
                         
                                         <tr style="height: 2em">
                                         <th class="assetSubHeader" width="40px">Sl No</th>
                                         <th class="assetSubHeader" width="60px">Select
                                         <span id="spnSelAllRow" style="display: none;">
                                         <input type="checkbox" name="chkHwbox" id="chkHwbox" onclick="selAllRows(this);" />
                                         </span>
                                         </th>
                                         <th class="assetSubHeader" width="40px">Mode</th>
                                         <th class="assetSubHeaderMand" width="100px">Service ID</th>
                                         <th class="assetSubHeaderMand" width="100px">Vendor ID</th>
                                         <th class="assetSubHeaderMand" width="100px">Asset ID</th>
                                         <th class="assetSubHeaderMand" width="160px">Name</th>
                                         <th class="assetSubHeader" width="140px">Service Type</th>
                                         <th class="assetSubHeader" width="100px">Renewal Amount</th>
                                         <th class="assetSubHeader" width="130px">Product Description</th>
                                         <th class="assetSubHeader" width="150px">Purchase Date</th>
                                         <th class="assetSubHeader" width="100px">Start Date</th>
                                         <th class="assetSubHeaderMand" width="130px">End Date</th>
                                         <th class="assetSubHeader" width="100px">Validity Period</th>
                                         <th class="assetSubHeader" width="230px">Remarks</th>
                                         <th class="assetSubHeader" width="230px">Status</th>
                                         <th class="assetSubHeader" width="230px">Product</th>
                                         <th class="assetSubHeader" width="230px">Sub Product</th>
                                         <th class="assetSubHeader" width="100px">Created User ID</th>
                                         <th class="assetSubHeader" width="100px">Created Date Time</th>
                                         <th class="assetSubHeader" width="100px">Modified User ID</th>
                                         <th class="assetSubHeader" width="100px">Modified Date Time</th>
                                       </tr>
                                     </thead>
                                   <tbody>
                                   </tbody>
                                   </table>
                                 </div>
                               </td>
                               
                             </tr>
                             
                             
                             <tr>
                               
                               <td height="5%" width="90%">
                                 &nbsp;
                               </td>
                               
                             </tr>
                           </table>
  
  
  
  </div>
  <div id="tabs-2">
    <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
   <table cellpadding="0" cellspacing="0" border="0" width="99%" height="95%" align="center">
                             <tr>
                                <td height="10%" width="90%">
                                 <table cellpadding="0" cellspacing="0" border="0" width="99%" height="99%" align="center">
                                   <tr>
                                     <td width="20%">
                                       <table cellpadding="2" cellspacing="0" border="0" width="99%" height="99%" align="center">
                                         <tr>
                                           <td width="60%">
                                             
                                           </td>
                                           <td width="40%">
                                             </td>
                                         </tr>
                                       </table>
                                     </td>
                                     <td width="30%">&nbsp;</td>
                                     <td width="25%">&nbsp;</td>
                                     <td width="25%">&nbsp;</td>
                                   </tr>
                                 </table>
                               </td>
                              
                             </tr>
                          <tr>
                             <td  height="85%" width="90%">
                                       VENDOR NAME : 
                                   <div id="autoUpdate1" class="ui-widget-content ui-corner-all" style="overflow: scroll;width: 1020px;height: 250px;" >
                                   <table cellpadding="0" cellspacing="0" border="1" width="2250px;"  align="center" id="assetVendorNamTable">
                                       <thead>
                                         <tr style="height: 2em">
                                         <th class="assetSubHeader" width="40px">Sl No</th>
                                         <th class="assetSubHeader" width="60px">Select
                                         <span id="spnSelAllRow" style="display: none;">
                                         <input type="checkbox" name="chkHwbox" id="chkHwbox" onclick="selAllRows(this);" />
                                         </span>
                                         </th>
                                         <th class="assetSubHeader" width="40px">Mode</th>
                                         <th class="assetSubHeaderMand" width="100px">Vendor ID</th>
                                         <th class="assetSubHeaderMand" width="100px">Vendor Rep</th>
                                         <th class="assetSubHeaderMand" width="160px">Name</th>
                                         <th class="assetSubHeader" width="140px">Address1</th>
                                         <th class="assetSubHeader" width="100px">Address2</th>
                                         <th class="assetSubHeader" width="130px">Address3</th>
                                         <th class="assetSubHeader" width="150px">City</th>
                                         <th class="assetSubHeader" width="100px">Country</th>
                                         <th class="assetSubHeaderMand" width="130px">PhoneCode</th>
                                         <th class="assetSubHeader" width="100px">OfficePhone</th>
                                         <th class="assetSubHeader" width="100px">FAX</th>
                                         <th class="assetSubHeader" width="100px">Vendor HP</th>
                                         <th class="assetSubHeader" width="100px">Email</th>
                                         <th class="assetSubHeader" width="100px">Web site</th>
                                         <th class="assetSubHeader" width="100px">Contacts 24/7</th>
                                         <th class="assetSubHeaderMand" width="160px">Renewal</th>
                                         <th class="assetSubHeader" width="230px">Remarks</th>
                                         <th class="assetSubHeader" width="100px">Created User ID</th>
                                         <th class="assetSubHeader" width="100px">Created Date Time</th>
                                         <th class="assetSubHeader" width="100px">Modified User ID</th>
                                         <th class="assetSubHeader" width="100px">Modified Date Time</th>
                                       </tr>
                                     </thead>
                                     
                                     <tbody>
                                     </tbody>
                                   </table>
                                 </div>
                               </td>
                               </tr>
                               
                             <tr>
                               
                               <td height="5%" width="90%">
                                 &nbsp;
                               </td>
                               
                             </tr>
                           </table>
   
  
  
  </div>
  <div id="tabs-3">
    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
  
  <table cellpadding="0" cellspacing="0" border="0" width="99%" height="95%" align="center">
                             <tr>
                               
                               <td height="10%" width="90%">
                                 <table cellpadding="0" cellspacing="0" border="0" width="99%" height="99%" align="center">
                                   <tr>
                                     <td width="20%">
                                       <table cellpadding="2" cellspacing="0" border="0" width="99%" height="99%" align="center">
                                         <tr>
                                           <td width="60%">
                                             
                                           </td>
                                           <td width="40%">
                                             </td>
                                         </tr>
                                       </table>
                                     </td>
                                     <td width="30%">&nbsp;</td>
                                     <td width="25%">&nbsp;</td>
                                     <td width="25%">&nbsp;</td>
                                   </tr>
                                 </table>
                               </td>
                              
                             </tr>
                           
  
  <tr>
                               <td  id="contactmenuHdrTr" >
                                  CONTACT DETAILS : 
                                 <div id="autoUpdate3" class="ui-widget-content ui-corner-all" style="overflow: scroll;width: 650px;height: 150px;" >
                                   <table cellpadding="0" cellspacing="0" border="1" width="650px;"  align="center" id="assetVendorContTable">
                                    <thead>
                                         <tr style="height: 2em">
                                         <th class="assetSubHeader" width="40px">Sl No</th>
                                         <th class="assetSubHeader" width="60px">Select
                                         <span id="spnSelAllRow" style="display: none;">
                                         <input type="checkbox" name="chkHwbox" id="chkHwbox" onclick="selAllRows(this);" />
                                         </span>
                                         </th>
                                         <th class="assetSubHeader" width="40px">Mode</th>
                                         <th class="assetSubHeaderMand" width="100px">Contact ID</th>
                                         <th class="assetSubHeaderMand" width="100px">Vendor ID</th>
                                         <th class="assetSubHeaderMand" width="100px">Contacts 24/7</th>
                                         <th class="assetSubHeaderMand" width="160px">Key Person Name</th>
                                         <th class="assetSubHeader" width="140px">Designation Name</th>
                                         <th class="assetSubHeader" width="100px">Mobile </th>
                                         <th class="assetSubHeader" width="130px">Office Direct No</th>
                                         <th class="assetSubHeader" width="150px">Remarks</th>
                                         <th class="assetSubHeader" width="100px">Created User ID</th>
                                         <th class="assetSubHeader" width="100px">Created Date Time</th>
                                         <th class="assetSubHeader" width="100px">Modified User ID</th>
                                         <th class="assetSubHeader" width="100px">Modified Date Time</th>
                                       </tr>
                                     </thead>
                                   <tbody>
                                   </tbody>
                                     <tbody>
                                     </tbody>
                                   </table>
                                 </div>
                               </td>
                               
                             </tr>
                             
                              <tr>
                               
                               <td height="5%" width="90%">
                                 &nbsp;
                               </td>
                               
                             </tr>
                           </table>
     
  
  
  </div>
</div>
 
 
</body>
</html>