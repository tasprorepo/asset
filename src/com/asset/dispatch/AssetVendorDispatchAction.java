package com.asset.dispatch;
import java.util.ArrayList;
import java.util.Date;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.util.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.asset.modal.AssetHardware;
import com.asset.modal.AssetLogin;
import com.asset.modal.AssetSoftware;
import com.asset.modal.AssetVendor;
import com.asset.modal.AssetVendorServices;
import com.asset.modal.AssetVendorContacts;
import com.asset.service.AssetHardwareService;
import com.asset.service.AssetSoftwareService;
import com.asset.service.AssetVendorService;
import com.asset.service.LoginService;
import com.asset.service.AssetVendorService;
import com.asset.utils.CommonUtility;
import com.asset.utils.Constants;
import com.asset.utils.CommonUtility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class AssetVendorDispatchAction extends ActionSupport implements ModelDriven<AssetVendor>
{

	private static final long serialVersionUID = 1L;
	
	AssetVendor assetVendorObj ;
	
	
	@Override
	public AssetVendor getModel() {
		// TODO Auto-generated method stub
		return assetVendorObj;
	} // End of getAsset
	
	public void prepare() throws Exception 
	{
		assetVendorObj = new AssetVendor();		
	}
	
	HttpServletRequest request = ServletActionContext.getRequest();
	AssetVendorServices vdserv = new AssetVendorServices();
	
	
	
public String assetVendorInsert() {
	 
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest vdrequest = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		
		
		if(!CommonUtility.isValidUser(vdrequest)){
			return Constants.SESSION_EXPIRED;
		}
 				
//		if(!com.asset.db.UtilityDB.chkValidDB()){
//   			return Constants.INVALID_DB;
//   		}	
//		
//		if (!TokenHelper.validToken()) {			
//            return Constants.INVALID_TOKEN;
//        } 
		
		
//		SessionMap fpsess = (SessionMap)ctx.get(ServletActionContext.SESSION);		
//		HttpSession ebsess = vdrequest.getSession(false);//
		
		
//		List<AssetVendor> vendorLst = new ArrayList();
//		List<AssetVendor> vendarServiceList = new ArrayList();
		
//		AssetVendorServices vendorServ = new AssetVendorServices();
		
		try{
			
//			Vector assetVendorVect = getAssetVendorDetails(vdrequest);//
	     	Vector assetVendorContactVect = getAssetVendorContactDetails(vdrequest);
	     	
	     	
//	     	HttpServletRequest request = ServletActionContext.getRequest();
	    	HttpSession session=request.getSession();
//	    	HttpServletResponse response = ServletActionContext.getResponse();
	    	
	    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	     	Date date = new Date();
	     	String CrtdDate =dateFormat.format(date);
//	     	String MdfyDate =dateFormat.format(date);
	    	Date AsstVDCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
//	    	Date AsstVDMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
	    	 String vendorCrtcBy=(String)session.getAttribute("uname");
//	         String myPass=(String)session.getAttribute("upass");
	    	 
			
//			response.setContentType("text/html");  
			assetVendorObj = new AssetVendor();
			 
			assetVendorObj.setTxtFldAsstVDRepName(vdrequest.getParameter("txtFldServiceVendrRep") != null ?vdrequest.getParameter("txtFldServiceVendrRep") : "" );
			assetVendorObj.setTxtFldAsstVDName(vdrequest.getParameter("txtFldAsstVDServiceName") != null ?vdrequest.getParameter("txtFldAsstVDServiceName") : "" );
			assetVendorObj.setTxtFldAsstVDAddr1(vdrequest.getParameter("txtFldAsstVDServiceAddr1") != null ?vdrequest.getParameter("txtFldAsstVDServiceAddr1") : "" );
			assetVendorObj.setTxtFldAsstVDAddr2(vdrequest.getParameter("txtFldAsstVDServiceAddr2") != null ?vdrequest.getParameter("txtFldAsstVDServiceAddr2") : "" );
			assetVendorObj.setTxtFldAsstVDAddr3(vdrequest.getParameter("txtFldAsstVDServiceAddr3") != null ?vdrequest.getParameter("txtFldAsstVDServiceAddr3") : "" );
     		assetVendorObj.setTxtFldAsstVDCity(vdrequest.getParameter("txtFldAsstVDServiceCity") != null ?vdrequest.getParameter("txtFldAsstVDServiceCity") : "" );
			assetVendorObj.setTxtFldAsstVDCountry(vdrequest.getParameter("txtFldAsstVDServiceCountry") != null ?vdrequest.getParameter("txtFldAsstVDServiceCountry") : "" );
			assetVendorObj.setTxtFldAsstVDPcode(vdrequest.getParameter("txtFldAsstVDServicePcode") != null ?vdrequest.getParameter("txtFldAsstVDServicePcode") : "" );
			assetVendorObj.setTxtFldAsstVDFax(vdrequest.getParameter("txtFldAsstVDServiceFax") != null ?vdrequest.getParameter("txtFldAsstVDServiceFax") : "" );
			assetVendorObj.setTxtFldAsstVDEmail(vdrequest.getParameter("txtFldAsstVDServiceEmail") != null ?vdrequest.getParameter("txtFldAsstVDServiceEmail") : "" );
			assetVendorObj.setTxtFldAsstVDWebsite(vdrequest.getParameter("txtFldAsstVDServiceWebsite") != null ?vdrequest.getParameter("txtFldAsstVDServiceWebsite") : "" );
			assetVendorObj.setTxtFldAsstVDRemarks(vdrequest.getParameter("txtFldAsstVDServiceRemarks") != null ?vdrequest.getParameter("txtFldAsstVDServiceRemarks") : "" );
			assetVendorObj.settxtFldAsstVDCrtdUserId(vendorCrtcBy);
			assetVendorObj.setTxtFldAsstVDCrtdDate (AsstVDCrtdDate); 
			AssetVendorService servobj= new AssetVendorService ();  
			servobj.assetVDwareSave(assetVendorObj,assetVendorContactVect);
//			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		addActionMessage("Vendor Details Inserted Successfully!");
		return SUCCESS;
	}//End assetVendorInsert {Insert}
	

public String assetVendorUpdate(){
	 
	ActionContext ctx = ActionContext.getContext();
	HttpServletRequest vdrequest = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
	
//*****************Poovathi Commented Unused Codes******************
	
//	SessionMap fpsess = (SessionMap)ctx.get(ServletActionContext.SESSION);		
//	HttpSession ebsess = vdrequest.getSession(false);
	
	
//	List<AssetVendor> vendorLst = new ArrayList();
//	List<AssetVendor> vendarServiceList = new ArrayList();
	
//	AssetVendorServices vendorServ = new AssetVendorServices();
	
	Vector assetVendorVect = getAssetVendorDetails(vdrequest);
	
	
 Vector assetVendorContactVector = getAssetVendorContactDetails(vdrequest);
	
// 	HttpServletRequest request = ServletActionContext.getRequest();
 	
 	if(!CommonUtility.isValidUser(request)){
		return Constants.SESSION_EXPIRED;
	}
			
//	if(!com.asset.db.UtilityDB.chkValidDB()){
//			return Constants.INVALID_DB;
//		}	
//	
//	if (!TokenHelper.validToken()) {			
//        return Constants.INVALID_TOKEN;
//    } 
	
 	
	HttpSession session=request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 	Date date = new Date();
 	String CrtdDate =dateFormat.format(date);
 	String MdfyDate =dateFormat.format(date);
	Date AsstVDCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
	Date AsstVDMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
	 String asstVDCrtdUser=(String)session.getAttribute("uname");
	 
//     String myPass=(String)session.getAttribute("upass");
	 
//	  response.setContentType("text/html");
      
	String strVendId = vdrequest.getParameter("txtFldServiceVendrId") != null ? vdrequest.getParameter("txtFldServiceVendrId") : "";
       assetVendorObj = new AssetVendor();
	
	assetVendorObj.setTxtFldAsstVDId(strVendId);
	assetVendorObj.setTxtFldAsstVDRepName(vdrequest.getParameter("txtFldServiceVendrRep") != null ? vdrequest.getParameter("txtFldServiceVendrRep") : "");
    assetVendorObj.setTxtFldAsstVDName(vdrequest.getParameter("txtFldAsstVDServiceName") != null ? vdrequest.getParameter("txtFldAsstVDServiceName") : "");
	assetVendorObj.setTxtFldAsstVDAddr1(vdrequest.getParameter("txtFldAsstVDServiceAddr1") != null ? vdrequest.getParameter("txtFldAsstVDServiceAddr1") : "");
	assetVendorObj.setTxtFldAsstVDAddr2(vdrequest.getParameter("txtFldAsstVDServiceAddr2") != null ? vdrequest.getParameter("txtFldAsstVDServiceAddr2") : "");
	assetVendorObj.setTxtFldAsstVDAddr3(vdrequest.getParameter("txtFldAsstVDServiceAddr3") != null ? vdrequest.getParameter("txtFldAsstVDServiceAddr3") : "");
	assetVendorObj.setTxtFldAsstVDCity(vdrequest.getParameter("txtFldAsstVDServiceCity") != null ? vdrequest.getParameter("txtFldAsstVDServiceCity") : "");
	assetVendorObj.setTxtFldAsstVDCountry(vdrequest.getParameter("txtFldAsstVDServiceCountry") != null ? vdrequest.getParameter("txtFldAsstVDServiceCountry") : "");
	assetVendorObj.setTxtFldAsstVDPcode(vdrequest.getParameter("txtFldAsstVDServicePcode") != null ? vdrequest.getParameter("txtFldAsstVDServicePcode") : "");
    assetVendorObj.setTxtFldAsstVDFax(vdrequest.getParameter("txtFldAsstVDServiceFax") != null ? vdrequest.getParameter("txtFldAsstVDServiceFax") : "");
    assetVendorObj.setTxtFldAsstVDEmail(vdrequest.getParameter("txtFldAsstVDServiceEmail") != null ? vdrequest.getParameter("txtFldAsstVDServiceEmail") : "");
	assetVendorObj.setTxtFldAsstVDWebsite(vdrequest.getParameter("txtFldAsstVDServiceWebsite") != null ? vdrequest.getParameter("txtFldAsstVDServiceWebsite") : "");
	assetVendorObj.setTxtFldAsstVDRemarks(vdrequest.getParameter("txtFldAsstVDServiceRemarks") != null ? vdrequest.getParameter("txtFldAsstVDServiceRemarks") : "");
	assetVendorObj.settxtFldAsstVDCrtdUserId(asstVDCrtdUser);
	assetVendorObj.setTxtFldAsstVDCrtdDate (AsstVDCrtdDate);  
	assetVendorObj.setTxtFldAsstVDMdfyUser(asstVDCrtdUser);
	assetVendorObj.setTxtFldAsstVDMdfyDate(AsstVDMdfyDate);
	AssetVendorService assetVendorServObj= new AssetVendorService ();
	assetVendorServObj.assetVendorUpdate(assetVendorObj, assetVendorContactVector);
	
	addActionMessage("Vendor Details Updated Successfully!");
	return SUCCESS;
	
}//end of assetVendorUpdate


// Poovathi add assetVendorDelete Action method in AssetVendorDispatchAction.java

public String assetVendorDelete()
{
	ActionContext ctx = ActionContext.getContext();
	HttpServletRequest vdrequest = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
	Vector assetVendorVect = getAssetVendorDetails(vdrequest);
    Vector assetVendorContactVector = getAssetVendorContactDetails(vdrequest);
    
    if(!CommonUtility.isValidUser(request))
    {
		return Constants.SESSION_EXPIRED;
	}
    HttpSession session=request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 	Date date = new Date();
 	String CrtdDate =dateFormat.format(date);
 	String MdfyDate =dateFormat.format(date);
	Date AsstVDCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
	Date AsstVDMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
	 String asstVDCrtdUser=(String)session.getAttribute("uname");
	 
//     String myPass=(String)session.getAttribute("upass");
	 
//	  response.setContentType("text/html");
      
	String strVendId = vdrequest.getParameter("txtFldServiceVendrId") != null ? vdrequest.getParameter("txtFldServiceVendrId") : "";
       assetVendorObj = new AssetVendor();
	
	assetVendorObj.setTxtFldAsstVDId(strVendId);
	assetVendorObj.setTxtFldAsstVDRepName(vdrequest.getParameter("txtFldServiceVendrRep") != null ? vdrequest.getParameter("txtFldServiceVendrRep") : "");
    assetVendorObj.setTxtFldAsstVDName(vdrequest.getParameter("txtFldAsstVDServiceName") != null ? vdrequest.getParameter("txtFldAsstVDServiceName") : "");
	assetVendorObj.setTxtFldAsstVDAddr1(vdrequest.getParameter("txtFldAsstVDServiceAddr1") != null ? vdrequest.getParameter("txtFldAsstVDServiceAddr1") : "");
	assetVendorObj.setTxtFldAsstVDAddr2(vdrequest.getParameter("txtFldAsstVDServiceAddr2") != null ? vdrequest.getParameter("txtFldAsstVDServiceAddr2") : "");
	assetVendorObj.setTxtFldAsstVDAddr3(vdrequest.getParameter("txtFldAsstVDServiceAddr3") != null ? vdrequest.getParameter("txtFldAsstVDServiceAddr3") : "");
	assetVendorObj.setTxtFldAsstVDCity(vdrequest.getParameter("txtFldAsstVDServiceCity") != null ? vdrequest.getParameter("txtFldAsstVDServiceCity") : "");
	assetVendorObj.setTxtFldAsstVDCountry(vdrequest.getParameter("txtFldAsstVDServiceCountry") != null ? vdrequest.getParameter("txtFldAsstVDServiceCountry") : "");
	assetVendorObj.setTxtFldAsstVDPcode(vdrequest.getParameter("txtFldAsstVDServicePcode") != null ? vdrequest.getParameter("txtFldAsstVDServicePcode") : "");
    assetVendorObj.setTxtFldAsstVDFax(vdrequest.getParameter("txtFldAsstVDServiceFax") != null ? vdrequest.getParameter("txtFldAsstVDServiceFax") : "");
    assetVendorObj.setTxtFldAsstVDEmail(vdrequest.getParameter("txtFldAsstVDServiceEmail") != null ? vdrequest.getParameter("txtFldAsstVDServiceEmail") : "");
	assetVendorObj.setTxtFldAsstVDWebsite(vdrequest.getParameter("txtFldAsstVDServiceWebsite") != null ? vdrequest.getParameter("txtFldAsstVDServiceWebsite") : "");
	assetVendorObj.setTxtFldAsstVDRemarks(vdrequest.getParameter("txtFldAsstVDServiceRemarks") != null ? vdrequest.getParameter("txtFldAsstVDServiceRemarks") : "");
	assetVendorObj.settxtFldAsstVDCrtdUserId(asstVDCrtdUser);
	assetVendorObj.setTxtFldAsstVDCrtdDate (AsstVDCrtdDate);  
	assetVendorObj.setTxtFldAsstVDMdfyUser(asstVDCrtdUser);
	assetVendorObj.setTxtFldAsstVDMdfyDate(AsstVDMdfyDate);
	AssetVendorService assetVendorServObj= new AssetVendorService ();
//	assetVendorServObj.assetVendorDelete(assetVendorObj, assetVendorContactVector);
	assetVendorServObj.assetVendorDelete(assetVendorContactVector, assetVendorObj);
			
	
	addActionMessage("Vendor Details Deleted Successfully!");
	return  SUCCESS;
		
	
}

//********************** END **********************//




	public Vector getAssetVendorDetails(HttpServletRequest request)
	{
		 
		 
		    List assetVdSerIns = new ArrayList(); 
		    List assetVdSerUpt = new ArrayList();
		    List assetVdSerDel = new ArrayList();
		    Vector assetVdSerVect = new Vector();
		    
			HttpSession session=request.getSession();
			HttpServletResponse response = ServletActionContext.getResponse();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 	Date date = new Date();
		 	String CrtdDate =dateFormat.format(date);
		 	String MdfyDate =dateFormat.format(date);
			Date AsstVDCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
			Date AsstVDMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
			 String myName=(String)session.getAttribute("uname");
		     String myPass=(String)session.getAttribute("upass");
			
		    
		    try
		    { 
		    	String[] modes = request.getParameterValues("txtFldAsstVDSerMode") != null ? request.getParameterValues("txtFldAsstVDSerMode") : null;
				String[] txtFldAsstVDSerIds = request.getParameterValues("txtFldAsstVDSerId")!= null ? request.getParameterValues("txtFldAsstVDSerId") : null;
				String[] txtFldAsstVDServenIds = request.getParameterValues("txtFldAsstVDServenId")!= null ? request.getParameterValues("txtFldAsstVDServenId") : null;
				String[] txtFldAsstVDSerAssetIds = request.getParameterValues("txtFldAsstVDAssetId")!= null ? request.getParameterValues("txtFldAsstVDAssetId") : null;
				String[] txtFldAsstVDSerTyps = request.getParameterValues("txtFldAsstVDSerTyp")!= null ? request.getParameterValues("txtFldAsstVDSerTyp") : null;
				String[] txtFldAsstVDSerRenwlAmts = request.getParameterValues("txtFldAsstVDRenwlAmt")!= null ? request.getParameterValues("txtFldAsstVDRenwlAmt") : null;
				String[] txtFldAsstVDSerPrdtDescps = request.getParameterValues("txtFldAsstVDPrdtDescp")!= null ? request.getParameterValues("txtFldAsstVDPrdtDescp") : null;
				String[] txtFldAsstVDSerPurhDates= request.getParameterValues("txtFldAsstVDPurhDate")!= null ? request.getParameterValues("txtFldAsstVDPurhDate") : null;
				String[] txtFldAsstVDSerStrtDates= request.getParameterValues("txtFldAsstVDStrtDate")!= null ? request.getParameterValues("txtFldAsstVDStrtDate") : null;
		        String[] txtFldAsstVDSerEndDates = request.getParameterValues("txtFldAsstVDEndDate")!= null ? request.getParameterValues("txtFldAsstVDEndDate") : null;
				String[] txtFldAsstVDSerVldPeriods = request.getParameterValues("txtFldAsstVDVldPeriod")!= null ? request.getParameterValues("txtFldAsstVDVldPeriod") : null;
				String[] txtFldAsstVDSerRmkss = request.getParameterValues("txtFldAsstVDRmks")!= null ? request.getParameterValues("txtFldAsstVDRmks") : null;
				String[] txtFldAsstVDSerStatuss = request.getParameterValues("txtFldAsstVDServStatus")!= null ? request.getParameterValues("txtFldAsstVDServStatus") : null;
				String[] txtFldAsstVDServStatuss = request.getParameterValues("txtFldAsstVDStatus")!= null ? request.getParameterValues("txtFldAsstVDStatus") : null;
				String[] txtFldAsstVDSerProducts = request.getParameterValues("txtFldAsstVDProduct")!= null ? request.getParameterValues("txtFldAsstVDProduct") : null;     
				String[] txtFldAsstVDSerSubProducts = request.getParameterValues("txtFldAsstVDSubProduct")!= null ? request.getParameterValues("txtFldAsstVDSubProduct") : null; 
			     
				if(modes !=null){
					
					 int totalModes = modes.length;
					 
				 	 for(int eh=0;eh<totalModes;eh++)
		         {
				        	String strAsstMode = modes[eh];
				        	String strAsstVDSerIds =txtFldAsstVDSerIds[eh];
				            String strAsstVDVendrIds=txtFldAsstVDServenIds[eh];
				            String strAsstVDAssetIds= txtFldAsstVDSerAssetIds[eh];
				            String strAsstVDSerTyps=txtFldAsstVDSerTyps[eh];
				            String strAsstVDRenwlAmts=txtFldAsstVDSerRenwlAmts[eh];
				            String strAsstVDPrdtDescps=txtFldAsstVDSerPrdtDescps[eh];
				            String strAsstVDPurhDates=txtFldAsstVDSerPurhDates[eh];
				            String strAsstVDStrtDates=txtFldAsstVDSerStrtDates[eh];
				            String strAsstVDEndDates=txtFldAsstVDSerEndDates[eh];
				            String strAsstVDVldPeriods=txtFldAsstVDSerVldPeriods[eh];
				            String strAsstVDRmkss=txtFldAsstVDSerRmkss[eh];
				            String strAsstVDServStatuss=txtFldAsstVDSerStatuss[eh];
				            String strAsstVDStatuss=txtFldAsstVDServStatuss[eh];
				            String strAsstVDProducts=txtFldAsstVDSerProducts[eh];
				            String strAsstVDSubProducts=txtFldAsstVDSerSubProducts[eh];
				            String strAsstVDCrUsrIds=myName;
				            String strAsstVDCrDates=CrtdDate;
				            String strAsstVDMdfyUsers=myName;
				            String strAsstVDMdfyDates=MdfyDate;
			  System.out.println(CrtdDate);
				     
				     if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.INSERT_MODE)) 
				      { 
				    	 assetVdSerIns.add( new AssetVendorServices(strAsstVDSerIds, strAsstVDVendrIds, strAsstVDAssetIds, strAsstVDSerTyps, strAsstVDRenwlAmts, strAsstVDPrdtDescps,CommonUtility.convertStringToDate( strAsstVDPurhDates),CommonUtility.convertStringToDate(strAsstVDStrtDates),CommonUtility.convertStringToDate(strAsstVDEndDates),strAsstVDVldPeriods,strAsstVDRmkss,strAsstVDServStatuss,strAsstVDStatuss,strAsstVDProducts,strAsstVDSubProducts,strAsstVDCrUsrIds,CommonUtility.convertStringToDate(strAsstVDCrDates),null,null));
		          }//end of if
				     
			         if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.UPDATE_MODE))
			          { 
			        	 assetVdSerUpt.add( new AssetVendorServices(strAsstVDSerIds, strAsstVDVendrIds, strAsstVDAssetIds, strAsstVDSerTyps, strAsstVDRenwlAmts, strAsstVDPrdtDescps,CommonUtility.convertStringToDate( strAsstVDPurhDates),CommonUtility.convertStringToDate(strAsstVDStrtDates),CommonUtility.convertStringToDate(strAsstVDEndDates),strAsstVDVldPeriods,strAsstVDRmkss,strAsstVDServStatuss,strAsstVDStatuss,strAsstVDProducts,strAsstVDSubProducts,strAsstVDCrUsrIds,CommonUtility.convertStringToDate(strAsstVDCrDates),strAsstVDMdfyUsers,CommonUtility.convertStringToDate(strAsstVDMdfyDates)));
				        }//end of if
			         
			         if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.DELETE_MODE)) 
			          {
			            	assetVdSerDel.add( new AssetVendorServices(strAsstVDSerIds, strAsstVDVendrIds, strAsstVDAssetIds, strAsstVDSerTyps, strAsstVDRenwlAmts, strAsstVDPrdtDescps,CommonUtility.convertStringToDate( strAsstVDPurhDates),CommonUtility.convertStringToDate(strAsstVDStrtDates),CommonUtility.convertStringToDate(strAsstVDEndDates),strAsstVDVldPeriods,strAsstVDRmkss,strAsstVDServStatuss,strAsstVDStatuss,strAsstVDProducts,strAsstVDSubProducts,strAsstVDCrUsrIds,CommonUtility.convertStringToDate(strAsstVDCrDates),strAsstVDMdfyUsers,CommonUtility.convertStringToDate(strAsstVDMdfyDates)));
					         }//end of if
			         
				     }//end of for
		         assetVdSerVect.add(assetVdSerIns);
			         assetVdSerVect.add(assetVdSerUpt);
			         assetVdSerVect.add(assetVdSerDel);
				   	
				}
				
			
			        
		    }//end of try
		    
		    catch (Exception e)
		    {
		    	e.printStackTrace();
		    }//end of catch
	    return assetVdSerVect;
		} // End of getAssetVendorDetails
		
	
	public Vector getAssetVendorContactDetails(HttpServletRequest request)
	{
		 
		   List assetVdContIns = new ArrayList(); 
		    List assetVdContUpt = new ArrayList();
		    List aassetVdContDel = new ArrayList();
		    Vector assetVdContVect = new Vector();
		   
		    HttpSession session=request.getSession();
//			HttpServletResponse response = ServletActionContext.getResponse();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		 	Date date = new Date();
		 	String CrtdDate =dateFormat.format(date);
		 	String MdfyDate =dateFormat.format(date);
//			Date txtFldAsstVDContCrDate  = CommonUtility.convertStringToDate(CrtdDate);
//			Date AsstVDMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
			String myName=(String)session.getAttribute("uname");
//		    String myPass=(String)session.getAttribute("upass");
			
		    
		    try
		    { 
			
		    	
		    	String[] modes = request.getParameterValues("txtFldAsstVDContMode") != null ? request.getParameterValues("txtFldAsstVDContMode") : null;
				String[] txtFldAsstVDContIds = request.getParameterValues("txtFldAsstVDContId") != null ? request.getParameterValues("txtFldAsstVDContId") : null;
				String[] txtFldAsstVDVendrIds = request.getParameterValues("txtFldAsstVDContVendrId") != null ? request.getParameterValues("txtFldAsstVDContVendrId") : null;
				String[] txtFldAsstVDCont247s = request.getParameterValues("txtFldAsstVDCont247") != null ? request.getParameterValues("txtFldAsstVDCont247") : null;
				String[] txtFldAsstVDKeyPernmes = request.getParameterValues("txtFldAsstVDContKeyPernme") != null ? request.getParameterValues("txtFldAsstVDContKeyPernme") : null;
				String[] txtFldAsstVDDesgntns = request.getParameterValues("txtFldAsstVDContDesgntn") != null ? request.getParameterValues("txtFldAsstVDContDesgntn") : null;
				String[] txtFldAsstVDMobles = request.getParameterValues("txtFldAsstVDContMoble") != null ? request.getParameterValues("txtFldAsstVDContMoble") : null;
				String[] txtFldAsstVDVendrOffPerNos= request.getParameterValues("txtFldAsstVDContVendrOffPerNo") != null ? request.getParameterValues("txtFldAsstVDContVendrOffPerNo") : null;;
				String[] txtFldAsstVDRmkss= request.getParameterValues("txtFldAsstVDContRmks") != null ? request.getParameterValues("txtFldAsstVDContRmks") : null;
		 	 

					if(modes !=null)
					{
						
						 int totalModes = modes.length;
						 
					 
		         for(int eh=0;eh<totalModes;eh++)
		         {
			        	String strAsstMode = modes[eh];
			        	String strAsstVDContIds = txtFldAsstVDContIds[eh];
			        	String strAsstVDVendrIds = txtFldAsstVDVendrIds[eh];
			        	String strAsstVDCont247s = txtFldAsstVDCont247s[eh];
			        	String strAsstVDKeyPernmes = txtFldAsstVDKeyPernmes[eh];
			        	String strAsstVDDesgntns = txtFldAsstVDDesgntns[eh];
			        	String strAsstVDMobles  = txtFldAsstVDMobles [eh];
			        	String strAsstVDVendrOffPerNos= txtFldAsstVDVendrOffPerNos[eh];
			        	String strAsstVDRmkss = txtFldAsstVDRmkss[eh];
			        	String strAsstVDCrUsrIds= myName;
			         	String strAsstVDCrDates  = CrtdDate;
			        	String strAsstVDMdfyUsrIds= myName;
			        	String strAsstVDMdfyDates =MdfyDate;
			      
			     
	     if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.INSERT_MODE)) 
		      {
		     	 assetVdContIns.add( new AssetVendorContacts(strAsstVDContIds, strAsstVDVendrIds, strAsstVDCont247s, strAsstVDKeyPernmes, strAsstVDDesgntns, strAsstVDMobles, strAsstVDVendrOffPerNos,strAsstVDRmkss,strAsstVDCrUsrIds,CommonUtility.convertStringToDate(strAsstVDCrDates),null,null));
		          }//end of if
			     
		         if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.UPDATE_MODE))
		          { 
		        	 assetVdContUpt.add(new AssetVendorContacts(strAsstVDContIds, strAsstVDVendrIds, strAsstVDCont247s, strAsstVDKeyPernmes, strAsstVDDesgntns, strAsstVDMobles, strAsstVDVendrOffPerNos,strAsstVDRmkss,strAsstVDCrUsrIds,CommonUtility.convertStringToDate(strAsstVDCrDates),strAsstVDMdfyUsrIds,CommonUtility.convertStringToDate(strAsstVDMdfyDates)));
			          }//end of if
		         
		         if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.DELETE_MODE)) 
		          {
		              	aassetVdContDel.add(new AssetVendorContacts(strAsstVDContIds, strAsstVDVendrIds, strAsstVDCont247s, strAsstVDKeyPernmes, strAsstVDDesgntns, strAsstVDMobles, strAsstVDVendrOffPerNos,strAsstVDRmkss,strAsstVDCrUsrIds,CommonUtility.convertStringToDate(strAsstVDCrDates),strAsstVDMdfyUsrIds,CommonUtility.convertStringToDate(strAsstVDMdfyDates)));
				   }//end of if
		         
			     }//end of for
		       
		         assetVdContVect.add(assetVdContIns);
		         assetVdContVect.add(assetVdContUpt);
		         assetVdContVect.add(aassetVdContDel);
			      
					}      
		    }//end of try
		    
		    catch (Exception e)
		    {
		    	e.printStackTrace();
		    	
		    }//end of catch
		    
		    return assetVdContVect;
		}// end of getAssetVendor1Details


	
	
	
	


}// end of AssetVendorDispatchAction

