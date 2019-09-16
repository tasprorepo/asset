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

import com.asset.modal.AssetSoftware;
import com.asset.modal.ServiceTracker;
import com.asset.service.AssetSoftwareService;
import com.asset.service.ServTrService; 
import com.asset.utils.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceTrackeDispatchAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;
	
	public String ServiceTrackerCUDOpern()
	{
//	    System.out.println("ServiceTrackerCUD Opern");
	
		HttpServletRequest request = ServletActionContext.getRequest();
		ServTrService servtr = new ServTrService();
		Vector serviceTrackerVect = getServiceTrackDetails(request);
	    servtr.servTRSave(serviceTrackerVect);

		return SUCCESS;
    } //end of ServiceTrackerCUDOperation
	
	public Vector getServiceTrackDetails(HttpServletRequest request)
	{
//		System.out.println("Condition4");
		 
		    List assetSwIns = new ArrayList(); 
		    List assetSwUpt = new ArrayList();
		    List assetSwDel = new ArrayList();
		    Vector servTRVect = new Vector();
		    

		    HttpSession session=request.getSession();
			HttpServletResponse response = ServletActionContext.getResponse();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		 	Date date = new Date();
		 	String CrtdDate =dateFormat.format(date);
		 	String MdfyDate =dateFormat.format(date);
			Date AsstSTCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
			Date AsstSTMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
			 String struserName=(String)session.getAttribute("uname");
		     String myPass=(String)session.getAttribute("upass");
		     
		    try
		    {
		    	String[] mode = request.getParameterValues("txtFldSrcTrMode"); 
		    	String[] txtFldServiceId = request.getParameterValues("txtFldServiceId");
				String[] txtFldHDID = request.getParameterValues("txtFldHDName");
				String[] txtFldSWID = request.getParameterValues("txtFldSWName");
				String[] txtFldVDID = request.getParameterValues("txtFldVDName");
				String[] txtFldServiceRequest = request.getParameterValues("txtFldServiceRequest");
				String[] txtFldServiceDate = request.getParameterValues("txtFldServiceDate");
				String[] txtFldRemarks = request.getParameterValues("txtFldRemarks");
//				String[] txtFldServiceCrtdUser= request.getParameterValues("txtFldServiceCrtdUser");
//				String[] txtFldServiceCrtdDate= request.getParameterValues("txtFldServiceCrtdDate");
//		        String[] txtFldServiceMdfyUser = request.getParameterValues("txtFldServiceMdfyUser");
//				String[] txtFldServicedMdfyDate = request.getParameterValues("txtFldServicedMdfyDate");
				
			 
			     String row=request.getParameter("asset");
				 int y = Integer.parseInt(row); 
				 
//			     System.out.println("Selected ROws########################## ");
//			     System.out.println("Selected ROws #########################");
//		         System.out.println("Selected ROws "+row);
			     
		         for(int eh=0;eh<y;eh++)
		         {
			        	String strSrvTrMode = mode[eh];  
			        	  
			        	String strSrvTrId = txtFldServiceId[eh]; 
			        	 
			        	String strSrvTrHDID = txtFldHDID[eh]; 
			        	
			        	String strSrvTrSWID = txtFldSWID[eh]; 
			        	
			        	String strSrvTrVDID  = txtFldVDID[eh]; 
			        	
			        	String strSrvReq = txtFldServiceRequest[eh]; 
			        	 
			        	String strSrvDate  = txtFldServiceDate[eh]; 
			        	 
			        	String strSrvTrRmks  = txtFldRemarks [eh];  
			     
			     if (strSrvTrMode.equalsIgnoreCase(com.asset.utils.Constants.INSERT_MODE))  
			      {
			    	 assetSwIns.add( new ServiceTracker(strSrvTrId,strSrvTrHDID,strSrvTrSWID,strSrvTrVDID,strSrvReq,CommonUtility.convertStringToDate(strSrvDate),strSrvTrRmks,struserName,AsstSTCrtdDate,null,null));

		          }//end of if
			     
		         if (strSrvTrMode.equalsIgnoreCase(com.asset.utils.Constants.UPDATE_MODE))
		          { 
		            	assetSwUpt.add(new ServiceTracker(strSrvTrId,strSrvTrHDID,strSrvTrSWID,strSrvTrVDID,strSrvReq,CommonUtility.convertStringToDate(strSrvDate),strSrvTrRmks,struserName,AsstSTCrtdDate,struserName,AsstSTMdfyDate));
//		            	System.out.println("strServiceIds----->"+strSrvTrHDID);
//		            	System.out.println("assetSwUpt.size()----->"+assetSwUpt.size());
//		            	System.out.println("strServTrMode------>"+strSrvTrMode);
		          }//end of if
		         
		         if (strSrvTrMode.equalsIgnoreCase(com.asset.utils.Constants.DELETE_MODE)) 
		          {
//		            	System.out.println("strservTrMode----->"+strSrvTrMode);
		            	assetSwDel.add(new ServiceTracker(strSrvTrId,strSrvTrHDID,strSrvTrSWID,strSrvTrVDID,strSrvReq,CommonUtility.convertStringToDate(strSrvDate),strSrvTrRmks,struserName,AsstSTCrtdDate,struserName,AsstSTMdfyDate));
		            }//end of if
		         
			     }//end of for
		         
//		         System.out.println(assetSwIns);
		         
			     servTRVect.add(assetSwIns);
			     servTRVect.add(assetSwUpt);
			     servTRVect.add(assetSwDel);
			     
//			     System.out.println(servTRVect);
			        
		    }//end of try
		    
		    catch (Exception e)
		    {
		    	
		    }//end of catch
		    
		    return servTRVect;
		} // End of getServiceTrackDetails
		
}// end of AssetSoftwareDispatchAction

