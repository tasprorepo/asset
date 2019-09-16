package com.asset.dispatch;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;



//import com.ASSET.bean.AssetSoftwareBean;
import com.asset.modal.AssetHardware;
import com.asset.modal.AssetSoftware;
import com.asset.service.AssetHardwareService;
import com.asset.service.AssetSoftwareService;
import com.asset.utils.CommonUtility;
import com.asset.utils.Constants; 
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class AssetSoftwareDispatchAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;
	
	public String assetSoftwareCUDOpern()
	{ 
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(!CommonUtility.isValidUser(request)){
 			return Constants.SESSION_EXPIRED;
		}
				
//		if(!com.asset.db.UtilityDB.chkValidDB()){
//   			return Constants.INVALID_DB;
//   		}	
//		
//		if (!TokenHelper.validToken()) {			
//            return Constants.INVALID_TOKEN;
//        } 
		
		
		AssetSoftwareService swserv = new AssetSoftwareService();
		Vector assetSoftwareVect = getAssetSwDetails(request);
	    swserv.assetSTwareSave(assetSoftwareVect);
	    addActionMessage("Data has saved Succesfully" );	
		return SUCCESS;
    } //end of assetSoftwareCUDOpern
	
	public Vector getAssetSwDetails(HttpServletRequest request)
	{ 
		 
		    List assetSwIns = new ArrayList(); 
		    List assetSwUpt = new ArrayList();
		    List assetSwDel = new ArrayList();
		    Vector assetSwVect = new Vector();
		   
		    HttpSession session=request.getSession();
			HttpServletResponse response = ServletActionContext.getResponse();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		 	Date date = new Date();
		 	String CrtdDate =dateFormat.format(date);
		 	String MdfyDate =dateFormat.format(date);
			Date AsstVDCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
			Date AsstVDMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
			 String myName=(String)session.getAttribute("uname");
		     String myPass=(String)session.getAttribute("upass");
			
		    
		    try
		    {
		    	
		    	String[] mode = request.getParameterValues("txtFldAsstSWMode");
		    
				String[] txtFldAsstSWIds = request.getParameterValues("txtFldAsstSWId");
				String[] txtFldAsstSWNames = request.getParameterValues("txtFldAsstSWName");
				String[] txtFldAsstSWCategs = request.getParameterValues("txtFldAsstSWCateg");
				String[] txtFldAsstSWLicenseTypes = request.getParameterValues("txtFldAsstSWLicenseType");
				String[] txtFldAsstSWLicenseKeys = request.getParameterValues("txtFldAsstSWLicenseKey");
				String[] txtFldAsstSWStatuss = request.getParameterValues("txtFldAsstSWStatus");
				String[] txtFldAsstSWRmkss= request.getParameterValues("txtFldAsstSWRmks"); 
 
			     String row=request.getParameter("asset");
				 int totalRowLength = Integer.parseInt(row);
				  
		         for(int eh=0;eh<totalRowLength;eh++)
		         {
			        	String strAsstMode = mode[eh];
			        	String strAsstSWIds = txtFldAsstSWIds[eh];
			        	String strAsstSWNames = txtFldAsstSWNames[eh];
			        	String strAsstSWCategs = txtFldAsstSWCategs[eh];
			        	String strAsstSWLicenseTypes = txtFldAsstSWLicenseTypes[eh];
			        	String strAsstSWLicenseKeys = txtFldAsstSWLicenseKeys[eh];
			        	String strAsstSWStatuss  = txtFldAsstSWStatuss [eh];
			        	String strAsstSWRmkss= txtFldAsstSWRmkss[eh];
			        	String strAsstSWCrtdUsers = myName;
			        	String strAsstSWCrtdDates=CrtdDate;
			         	String strAsstSWMdfyUsers = myName;
			        	String strAsstSWMdfyDates= MdfyDate;
			      
			     
			     
			     if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.INSERT_MODE)) 
			      {
			    	 assetSwIns.add( new AssetSoftware(strAsstSWIds, strAsstSWNames, strAsstSWCategs, strAsstSWLicenseTypes, strAsstSWLicenseKeys, strAsstSWStatuss, strAsstSWRmkss,strAsstSWCrtdUsers,CommonUtility.convertStringToDate(strAsstSWCrtdDates),null,null));
		          }//end of if
			     
		         if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.UPDATE_MODE))
		          { 
		            	assetSwUpt.add(new AssetSoftware(strAsstSWIds, strAsstSWNames, strAsstSWCategs, strAsstSWLicenseTypes, strAsstSWLicenseKeys, strAsstSWStatuss, strAsstSWRmkss,strAsstSWCrtdUsers,CommonUtility.convertStringToDate(strAsstSWCrtdDates),strAsstSWMdfyUsers,CommonUtility.convertStringToDate(strAsstSWMdfyDates)));
		            	 
		          }//end of if
		         
		         if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.DELETE_MODE)) 
		          {
		            	 
		            	assetSwDel.add(new AssetSoftware(strAsstSWIds, strAsstSWNames, strAsstSWCategs, strAsstSWLicenseTypes, strAsstSWLicenseKeys, strAsstSWStatuss, strAsstSWRmkss,strAsstSWCrtdUsers,CommonUtility.convertStringToDate(strAsstSWCrtdDates),strAsstSWMdfyUsers,CommonUtility.convertStringToDate(strAsstSWMdfyDates)));
		          }//end of if
		         
			     }//end of for
		          
			     assetSwVect.add(assetSwIns);
			     assetSwVect.add(assetSwUpt);
			     assetSwVect.add(assetSwDel);
			      
			        
		    }//end of try
		    
		    catch (Exception e)
		    {
		    	
		    }//end of catch
		    
		    return assetSwVect;
		} // End of getAssetSwDetails
		
}// end of AssetSoftwareDispatchAction

