<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       <table>
          <tr>
             <td>
                                       Asset Hardware Details : 
                                  <div id="autoUpdate2" class="ui-widget-content ui-corner-all" style="width: 850px;height: 220px;" >
                                   <table cellpadding="0" cellspacing="0" border="0" width="850px;"  align="center" id="assetHardwareDetlsTable">
                                
                                  <tr>
                                  <td width="20%" align="right">&nbsp;</td>
                                  <td width="30%" align="left">&nbsp;</td>
                                  </tr>
                                  
                                  <tr>
                                  <td width="20%" align="right">&nbsp;</td>
                                  <td width="30%" align="left">&nbsp;</td>
                                  </tr>
                                  
                                    <tr>
                                      <td  width="20%" align="right" >
                                    Hardware Name: 
                                       </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstHDName" name="txtFldAsstHDName" readonly class="editableField" />
                                    </td>
                                    
                                    <td width="20%" align="right"  >
                                       Hardware Make: 
                                       </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldServiceVendrRep" name="txtFldServiceVendrRep" maxlength="150"class="editableField" />
                                    </td>
                                    </tr>
                                    <tr>
                                    <td  width="20%" align="right" >
                                      Hardware Model: 
                                       </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceName" name="txtFldAsstVDServiceName" maxlength="60"onBlur="validateName(this.id)"class="editableField" />
                                    </td>
                                    
                                    <td  width="20%" align="right" >
                                       Serial No: 
                                       </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceAddr1" name="txtFldAsstVDServiceAddr1"  maxlength="60"class="editableField" />
                                    </td>
                                    </tr>
                                    <tr>
                                       <td  width="20%" align="right" >
                                      Alloted To:
                                      </td>
                                      <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceAddr2" name="txtFldAsstVDServiceAddr2"  maxlength="60"class="editableField" />
                                    </td>
                                    
                                    <td  width="20%" align="right" >
                                      Operating System :
                                      </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceAddr3" name="txtFldAsstVDServiceAddr3"  maxlength="60"class="editableField" />
                                    </td>
                                    </tr>
                                    <tr>
                                       <td  width="20%" align="right" >
                                     Processor :
                                      </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceCity" name="txtFldAsstVDServiceCity"  maxlength="60" class="editableField" />
                                    </td>
                                    
                                    <td  width="20%" align="right">
                                      Processor Speed:
                                      </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceCountry" name="txtFldAsstVDServiceCountry" maxlength="60" class="editableField" />
                                    </td>
                                    </tr>
                                    <tr>
                                    <td  width="20%" align="right" >
                                      RAM :
                                      </td>
                                        <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServicePcode" name="txtFldAsstVDServicePcode"  maxlength="20"class="editableField" />
                                    </td>
                                         <td  width="20%" align="right" >
                                     Loc ID:
                                      </td>
                                         <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceFax" name="txtFldAsstVDServiceFax" maxlength="30" class="editableField" />
                                    </td>
                                    
                                    </tr>
                                   
                                    <tr>
                                     <td  width="20%" align="right" >
                                      Remarks :
                                      </td>
                                        <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceEmail" name="txtFldAsstVDServiceEmail" maxlength="60" onBlur="validateEmail(this.id)" class="editableField" />
                                    </td>
                                   
                                    <td  width="20%" align="right" >
                                      Part No :
                                      </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceWebsite" name="txtFldAsstVDServiceWebsite" maxlength="150" class="editableField" />
                                    </td>
                                    </tr>
                                    <tr>
                                   
                                     <td  width="20%" align="right" >
                                      Hardware Category :
                                      </td>
                                        <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceRemarks" name="txtFldAsstVDServiceRemarks"  maxlength="300"class="editableField" />
                                    </td>
                                    <td  width="20%" align="right" >
                                      Hardware Status:
                                      </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceWebsite" name="txtFldAsstVDServiceWebsite" maxlength="150" class="editableField" />
                                    </td>
                                    </tr>
                                    <tr>
                                   
                                     <td  width="20%" align="right" >
                                      Purchase Date:
                                      </td>
                                        <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceRemarks" name="txtFldAsstVDServiceRemarks"  maxlength="300"class="editableField" />
                                    </td>
                                    <td  width="20%" align="right" >
                                      Warranty StartDate:
                                      </td>
                                       <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceWebsite" name="txtFldAsstVDServiceWebsite" maxlength="150" class="editableField" />
                                    </td>
                                    </tr>
                                   <tr>
                                   
                                     <td  width="20%" align="right" >
                                      Warranty EndDate:
                                      </td>
                                        <td width="30%" align="left" style="padding-left: 5px;">
                                       <input type="text" id="txtFldAsstVDServiceRemarks" name="txtFldAsstVDServiceRemarks"  maxlength="300"class="editableField" />
                                    </td>
                                    </tr>
                                    <tbody>
                                     </tbody>
                                   </table>
                            </div>
                               </td>
                               </tr>
                               
                            
                           </table>
</body>
</html>