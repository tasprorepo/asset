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

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;




import org.apache.struts2.util.TokenHelper;

import com.asset.modal.AssetHardware;
import com.asset.service.AssetHardwareService;
import com.asset.utils.CommonUtility;
import com.asset.utils.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class AssetHardwareDispatchAction extends ActionSupport 
{
	static Logger fplog = Logger.getLogger(AssetHardwareDispatchAction.class);
	private static final long serialVersionUID = 1L;

	public String assetHardwareCUDOpern()
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
		
		AssetHardwareService hwserv = new AssetHardwareService();
		Vector assetHardwareVect = getAssetHwDetails(request);
	 
		hwserv.assetHDwareSave(assetHardwareVect);
		addActionMessage("Data has saved Succesfully" );	
		return SUCCESS;
     }//end of assetHardwareCUDOpern
	
    public Vector getAssetHwDetails(HttpServletRequest request)
    {
    	
		List assetHwIns = new ArrayList(); 
	    List assetHwUpt = new ArrayList();
	    List assetHwDel = new ArrayList();
	    Vector assetHwVect = new Vector();
	    
	    
	    HttpSession session=request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 	Date date = new Date(); 
	 	String CrtdDate =dateFormat.format(date);
	 	String MdfyDate =dateFormat.format(date); 
		Date AsstVDCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
		Date AsstVDMdfyDate  = CommonUtility.convertStringToDate(MdfyDate);
		 
		 String myName=(String)session.getAttribute("uname");
//		 System.out.println("usere======="+myName);
	     String myPass=(String)session.getAttribute("upass");
		 
	    try
	    { 
	    	
	        String[] mode = request.getParameterValues("txtFldAsstHDMode")!= null ?request.getParameterValues("txtFldAsstHDMode") : null;
			String[] txtFldAsstHDIds =request.getParameterValues("txtFldAsstHDId")!= null ?request.getParameterValues("txtFldAsstHDId") : null ;
			//String[] txtFldAsstHDAssdNames = request.getParameterValues("txtFldAsstHDAssdName")!= null ?request.getParameterValues("txtFldAsstHDAssdName") : null ;
			String[] txtFldAsstHDNames = request.getParameterValues("txtFldAsstHDName")!= null ?request.getParameterValues("txtFldAsstHDName") : null;
		 	
			String[] txtFldAsstHDMakes = request.getParameterValues("txtFldAsstHDMake")!= null ?request.getParameterValues("txtFldAsstHDMake") : null;
			String[] txtFldAsstHDModels = request.getParameterValues("txtFldAsstHDModel")!= null ?request.getParameterValues("txtFldAsstHDModel") : null;
			String[] txtFldAsstHDSerlNos = request.getParameterValues("txtFldAsstHDSerlNo")!= null ?request.getParameterValues("txtFldAsstHDSerlNo") : null;
			String[] txtFldAsstHDMACId = request.getParameterValues("txtFldAsstHDMacId")!= null ?request.getParameterValues("txtFldAsstHDMacId") : null;
			String[] txtFldAsstHDAllotTos = request.getParameterValues("txtFldAsstHDAllotTo")!= null ?request.getParameterValues("txtFldAsstHDAllotTo") : null;
			String[] txtFldAsstHDOperSyss = request.getParameterValues("txtFldAsstHDOperSys")!= null ?request.getParameterValues("txtFldAsstHDOperSys") : null;
			String[] txtFldAsstHDOperSysver = request.getParameterValues("txtFldAsstHDOperSysver")!= null ?request.getParameterValues("txtFldAsstHDOperSysver") : null;
			String[] txtFldAsstHDProssrs = request.getParameterValues("txtFldAsstHDProssr")!= null ?request.getParameterValues("txtFldAsstHDProssr") : null;
			String[] txtFldAsstHDProssrSpds = request.getParameterValues("txtFldAsstHDProssrSpd")!= null ?request.getParameterValues("txtFldAsstHDProssrSpd") : null;
			String[] txtFldAsstHDRAMs = request.getParameterValues("txtFldAsstHDRAM")!= null ?request.getParameterValues("txtFldAsstHDRAM") : null;
			String[] txtFldAsstHDDs = request.getParameterValues("txtFldAsstHDD")!= null ?request.getParameterValues("txtFldAsstHDD") : null;
			String[] txtFldAsstHDPartitions = request.getParameterValues("txtFldAsstHDDPartitions")!= null ?request.getParameterValues("txtFldAsstHDDPartitions") : null;
			//String[] txtFldAsstHDWarrantyStatusDescription = request.getParameterValues("txtFldAsstHDWarrantyStatusDescription")!= null ?request.getParameterValues("txtFldAsstHDWarrantyStatusDescription") : null;
			
			String[] txtFldAsstHDLocIDs = request.getParameterValues("txtFldAsstHDLocID")!= null ?request.getParameterValues("txtFldAsstHDLocID") : null;
			String[] txtFldAsstHDRmkss = request.getParameterValues("txtFldAsstHDRmks")!= null ?request.getParameterValues("txtFldAsstHDRmks") : null;
		    String[] txtFldAsstHDPartNos = request.getParameterValues("txtFldAsstHDPartNo")!= null ?request.getParameterValues("txtFldAsstHDPartNo") : null;
		   
		    String[] txtFldAsstHDCategs = request.getParameterValues("txtFldAsstHDCateg")!= null ?request.getParameterValues("txtFldAsstHDCateg") : null;
		   
		    String[] txtFldAsstHDStatuss = request.getParameterValues("txtFldAsstHDStatus")!= null ?request.getParameterValues("txtFldAsstHDStatus") : null;
			String[] txtFldAsstHDPurchaseDates = request.getParameterValues("txtFldAsstHDPurchaseDate")!= null ?request.getParameterValues("txtFldAsstHDPurchaseDate") : null;
			 String[] txtFldAsstHDWarrantyStartDates = request.getParameterValues("txtFldAsstHDWarrantyStartDate")!= null ?request.getParameterValues("txtFldAsstHDWarrantyStartDate") : null;
			 String[] txtFldAsstHDWarrantyEndDates = request.getParameterValues("txtFldAsstHDWarrantyEndDate")!= null ?request.getParameterValues("txtFldAsstHDWarrantyEndDate") : null;
			 String[] txtFldAsstHDWarrantyStatusDescription = request.getParameterValues("txtFldAsstHDWarrantyStatusDescription")!= null ?request.getParameterValues("txtFldAsstHDWarrantyStatusDescription") : null;
			 String[] txtFldAsstHDCpuSockets = request.getParameterValues("txtFldAsstHDCpuSockets")!= null ?request.getParameterValues("txtFldAsstHDCpuSockets") : null;
			 String[] txtFldAsstHDTotCores = request.getParameterValues("txtFldAsstHDTotCores")!= null ?request.getParameterValues("txtFldAsstHDTotCores") : null;
			 String[] txtFldAsstHDLogProcess = request.getParameterValues("txtFldAsstHDLogProcess")!= null ?request.getParameterValues("txtFldAsstHDLogProcess") : null;
			 String[] txtFldAsstHDServCatg = request.getParameterValues("txtFldAsstHDServCatg")!= null ?request.getParameterValues("txtFldAsstHDServCatg") : null;
			 String[] txtFldAsstHDIPNo = request.getParameterValues("txtFldAsstHDIPNo")!= null ?request.getParameterValues("txtFldAsstHDIPNo") : null;

//			 System.out.println(txtFldAsstHDNames.length);
			 String row=request.getParameter("asset");
			 int y = Integer.parseInt(row); 
		  
		  if(mode != null && mode.length>0){
		     for(int eh=0;eh<y;eh++) 
		     {
		    	
		        	String strAsstMode = mode[eh];
		        	String strAsstHDIds = txtFldAsstHDIds[eh];
//		            String strAsstHDAssdNames = txtFldAsstHDAssdNames[eh]; 
		        	String strAsstHDNames = txtFldAsstHDNames[eh];
		        	String strAsstHDMakes = txtFldAsstHDMakes[eh];
		        	String strAsstHDModels = txtFldAsstHDModels[eh];
		        	String strAsstHDSerlNos = txtFldAsstHDSerlNos[eh];
		        	String strAsstHDSMACId = txtFldAsstHDMACId[eh];
		        	String strAsstHDAllotToss= txtFldAsstHDAllotTos[eh];
		        	String strAsstHDOperSyss = txtFldAsstHDOperSyss[eh];
		        	String strAsstHDperSysver = txtFldAsstHDOperSysver[eh];
		        	String strAsstHDProssrs = txtFldAsstHDProssrs[eh];
		        	String strAsstHDProssrSpds = txtFldAsstHDProssrSpds[eh];
		        	String strAsstHDRAMs = txtFldAsstHDRAMs[eh];
		        	String strAsstHDDs = txtFldAsstHDDs[eh];
		        	String strAsstHDPartitions = txtFldAsstHDPartitions[eh];
		        	String strAsstHDLocIDs = txtFldAsstHDLocIDs[eh];
		        	String strAsstHDRmkss = txtFldAsstHDRmkss[eh];
		        	String strAsstHDCrtdUsers = myName;
		        	String strAsstHDCrtdDates=CrtdDate;
		         	String strAsstHDMdfyUsers = myName;
		        	String strAsstHDMdfyDates= MdfyDate;
		        	String strAsstHDPartNos = txtFldAsstHDPartNos[eh];
		        	String strAsstHDCategs = txtFldAsstHDCategs[eh];
		        	String strAsstHDStatuss = txtFldAsstHDStatuss[eh];
		        	String strAsstHDPurchaseDates = txtFldAsstHDPurchaseDates[eh];
		        	String strAsstHDWarrantyStartDates=txtFldAsstHDWarrantyStartDates[eh];
		        	String strAsstHDWarrantyEndDates =txtFldAsstHDWarrantyEndDates[eh];
		        	String strAsstHDWarrantyStatusDescription =txtFldAsstHDWarrantyStatusDescription[eh];
		        	String strAsstHDCpuSockets =txtFldAsstHDCpuSockets[eh];
		        	String strAsstHDTotCores =txtFldAsstHDTotCores[eh];
		        	String strAsstHDLogProcess =txtFldAsstHDLogProcess[eh];
		        	String strAsstHDServCatg =txtFldAsstHDServCatg[eh];
		        	String strAsstHDIPNo =txtFldAsstHDIPNo[eh];
//		        	System.out.println("strAsstMode====="+strAsstMode);
//		        	System.out.println("strAsstHDIds====="+strAsstHDIds);
//		        	System.out.println("strAsstHDNames==="+strAsstHDNames);
//		        	System.out.println("strAsstHDMakes===="+strAsstHDMakes);
//		        	System.out.println(strAsstHDModels);
//		        	System.out.println(strAsstHDSerlNos);
//		        	System.out.println(strAsstHDSMACId);
//		        	System.out.println(strAsstHDAllotToss);
//		        	System.out.println(strAsstHDOperSyss);
//		        	System.out.println(strAsstHDperSysver);
//		        	System.out.println(strAsstHDProssrs);
//		        	System.out.println(strAsstHDProssrSpds);
//		        	System.out.println(strAsstHDRAMs);
//		        	System.out.println(strAsstHDDs);
//		        	System.out.println(strAsstHDPartitions);
//		        	System.out.println(strAsstHDLocIDs);
//		        	System.out.println(strAsstHDRmkss);
//		        	System.out.println(strAsstHDCrtdUsers);
//		        	System.out.println(strAsstHDCrtdDates);
//		        	System.out.println(strAsstHDMdfyUsers);
//		        	System.out.println(strAsstHDMdfyDates);
//		        	System.out.println(strAsstHDPartNos);
//		        	System.out.println(strAsstHDCategs);
//		        	System.out.println(strAsstHDStatuss);
//		        	System.out.println(strAsstHDPurchaseDates);
//		        	System.out.println(strAsstHDWarrantyStartDates);
//		        	System.out.println(strAsstHDWarrantyEndDates);
//		        	System.out.println(strAsstHDWarrantyStatusDescription);
//		        	System.out.println(strAsstHDCpuSockets);
//		        	System.out.println(strAsstHDTotCores);
//		        	System.out.println(strAsstHDLogProcess);
//		        	System.out.println(strAsstHDIPNo);
//		        	System.out.println("strAsstHDServCatg=========>"+strAsstHDServCatg);
		        	
		        	
		        	
		        if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.INSERT_MODE))
		        {
		    	         assetHwIns.add( new AssetHardware(
		    	         strAsstHDIds,
		    	         strAsstHDNames,
		    			 strAsstHDMakes,
		    			 strAsstHDModels,
		    			 strAsstHDSerlNos,
		    			 strAsstHDSMACId, 
		    			 strAsstHDAllotToss,
		    			 strAsstHDOperSyss,
		    			 strAsstHDperSysver,
		    			 strAsstHDProssrs, 
		    			 strAsstHDProssrSpds,
		    			 strAsstHDRAMs, 
		    			 strAsstHDDs,
		    			 strAsstHDPartitions,
		    			 strAsstHDLocIDs,
		    			 strAsstHDRmkss,
		    			 strAsstHDCrtdUsers,
		    			// CommonUtility.convertStringToDate(strAsstHDCrtdDates),
		    			 new Date(),
		    			 null,
		    			 null,
		    			 strAsstHDPartNos,
		    			 strAsstHDCategs,
		    			 strAsstHDStatuss,
		    			 CommonUtility.convertStringToDate(strAsstHDPurchaseDates),
		    			 CommonUtility.convertStringToDate(strAsstHDWarrantyStartDates),
		    			 CommonUtility.convertStringToDate(strAsstHDWarrantyEndDates),
		    			 strAsstHDWarrantyStatusDescription,
		    			 strAsstHDCpuSockets,
		    			 strAsstHDTotCores,
		    			 strAsstHDLogProcess,
		    			 strAsstHDServCatg,
		    			 strAsstHDIPNo));
		    	         
		    	         
		    	         
	            }//end of if 
		        
	            if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.UPDATE_MODE))
	            {
	            	
	            	assetHwUpt.add(new AssetHardware(
//	            			strAsstHDIds, 
//	            			null,
//	            			strAsstHDNames,
//	            	strAsstHDMakes, 
//	            	strAsstHDModels, 
//	            	strAsstHDSerlNos, 
//	            	strAsstHDAllotToss,
//	            	strAsstHDOperSyss,
//	            	strAsstHDProssrs, 
//	            	strAsstHDProssrSpds,
//	            	strAsstHDRAMs, 
//	            	strAsstHDDs,
//	            	strAsstHDPartitions,
//	            	strAsstHDLocIDs,
//	            	strAsstHDRmkss,
//	            	strAsstHDCrtdUsers,
//	            	CommonUtility.convertStringToDate(strAsstHDCrtdDates),
//	            	strAsstHDMdfyUsers,
//	            	CommonUtility.convertStringToDate(strAsstHDMdfyDates),
//	            	strAsstHDPartNos,
//	            	strAsstHDCategs,
//	            	strAsstHDStatuss,
//	            	CommonUtility.convertStringToDate(strAsstHDPurchaseDates),
//	            	CommonUtility.convertStringToDate(strAsstHDWarrantyStartDates),
//	            	CommonUtility.convertStringToDate(strAsstHDWarrantyEndDates)
	            			strAsstHDIds,
			    	         strAsstHDNames,
			    			 strAsstHDMakes,
			    			 strAsstHDModels,
			    			 strAsstHDSerlNos,
			    			 strAsstHDSMACId, 
			    			 strAsstHDAllotToss,
			    			 strAsstHDOperSyss,
			    			 strAsstHDperSysver,
			    			 strAsstHDProssrs, 
			    			 strAsstHDProssrSpds,
			    			 strAsstHDRAMs, 
			    			 strAsstHDDs,
			    			 strAsstHDPartitions,
			    			 strAsstHDLocIDs,
			    			 strAsstHDRmkss,
			    			 strAsstHDCrtdUsers,
			    			 CommonUtility.convertStringToDate(strAsstHDCrtdDates),
			    			 strAsstHDMdfyUsers,
			    			 new Date(),
			    			 strAsstHDPartNos,
			    			 strAsstHDCategs,
			    			 strAsstHDStatuss,
			    			 CommonUtility.convertStringToDate(strAsstHDPurchaseDates),
			    			 CommonUtility.convertStringToDate(strAsstHDWarrantyStartDates),
			    			 CommonUtility.convertStringToDate(strAsstHDWarrantyEndDates),
			    			 strAsstHDWarrantyStatusDescription,
			    			 strAsstHDCpuSockets,
			    			 strAsstHDTotCores,
			    			 strAsstHDLogProcess,
			    			 strAsstHDServCatg,
			    			 strAsstHDIPNo));
	            	 
	            }//end  of if
	            
	            
	            if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.DELETE_MODE)) 
	             { 
	            	assetHwDel.add(new AssetHardware(
//	            	strAsstHDIds, strAsstHDAssdNames, strAsstHDNames, strAsstHDMakes, 
//	            	strAsstHDModels, strAsstHDSerlNos, strAsstHDAllotToss, strAsstHDOperSyss, strAsstHDProssrs, 
//	           		strAsstHDProssrSpds, strAsstHDRAMs,  strAsstHDDs,strAsstHDPartitions,strAsstHDLocIDs, strAsstHDRmkss,strAsstHDCrtdUsers,
//	       			CommonUtility.convertStringToDate(strAsstHDCrtdDates),strAsstHDMdfyUsers,
//	       			CommonUtility.convertStringToDate(strAsstHDMdfyDates),strAsstHDPartNos,strAsstHDCategs,strAsstHDStatuss,CommonUtility.convertStringToDate(strAsstHDPurchaseDates),CommonUtility.convertStringToDate(strAsstHDWarrantyStartDates),CommonUtility.convertStringToDate(strAsstHDWarrantyEndDates)
	            	strAsstHDIds,
	    	         strAsstHDNames,
	    			 strAsstHDMakes,
	    			 strAsstHDModels,
	    			 strAsstHDSerlNos,
	    			 strAsstHDSMACId, 
	    			 strAsstHDAllotToss,
	    			 strAsstHDOperSyss,
	    			 strAsstHDperSysver,
	    			 strAsstHDProssrs, 
	    			 strAsstHDProssrSpds,
	    			 strAsstHDRAMs, 
	    			 strAsstHDDs,
	    			 strAsstHDPartitions,
	    			 strAsstHDLocIDs,
	    			 strAsstHDRmkss,
	    			 strAsstHDCrtdUsers,
	    			 CommonUtility.convertStringToDate(strAsstHDCrtdDates),
	    			 strAsstHDMdfyUsers,
	    			 new Date(),
	    			 strAsstHDPartNos,
	    			 strAsstHDCategs,
	    			 strAsstHDStatuss,
	    			 CommonUtility.convertStringToDate(strAsstHDPurchaseDates),
	    			 CommonUtility.convertStringToDate(strAsstHDWarrantyStartDates),
	    			 CommonUtility.convertStringToDate(strAsstHDWarrantyEndDates),
	    			 strAsstHDWarrantyStatusDescription,
	    			 strAsstHDCpuSockets,
	    			 strAsstHDTotCores,
	    			 strAsstHDLogProcess,
	    			 strAsstHDServCatg,
	    			 strAsstHDIPNo
	            	));
	             }//end of if
		     
		     }//end of for
			 }
		     assetHwVect.add(assetHwIns);
		     assetHwVect.add(assetHwUpt);
		     assetHwVect.add(assetHwDel);
		      
		   }//end of try
	    catch (Exception e)
	    {
	    	fplog.info("Error in AgentDispathAction.Insert Method-->"+e.getStackTrace());
	    	e.printStackTrace();
	    }//end of catch
	    
	    return assetHwVect;
	} // End of getAdvEmpmntHistDetails
	
}//end of AssetHardwareDispatchAction
