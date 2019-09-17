package com.asset.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asset.modal.AssetHardware;
import com.asset.modal.AssetSoftware;
import com.asset.modal.AssetVendor;
import com.asset.modal.ServiceTracker;

public class ServiceTrckDb {
 private static final String searchQry = " from com.asset.modal.ServiceTracker sertrck ";
	
	public String servicVectParameter(Vector serviceTrackerVect) {
		// TODO Auto-generated method stub
 
			
//			System.out.println("dbDTO ----->"+dbDTO);
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");		
			Object serviceObj = null;
			
			List assetSwIns = new ArrayList();
			List assetSwUpt = new ArrayList();
			List assetSwDel = new ArrayList();
			int compSize = serviceTrackerVect.size();
			if (compSize > 0) 
			{
				
				assetSwIns = (List) serviceTrackerVect.elementAt(0);
				assetSwUpt = (List) serviceTrackerVect.elementAt(1);
				assetSwDel = (List) serviceTrackerVect.elementAt(2);
			}//end of if 
			
			int insSize = assetSwIns.size();
			 
			
			if (insSize > 0)
			{		  
				ServiceTracker assetSw = new ServiceTracker();
			Iterator itrIns = assetSwIns.iterator();
				while (itrIns.hasNext())
				{
					assetSw = (ServiceTracker) itrIns.next(); 
						serviceObj = assetSw; 
						dbDTO.saveObjs(serviceObj);
				}// End of while(itrIns)
				}//end of if 
			
		   if (assetSwUpt.size() > 0) 
		   {
			   ServiceTracker assetSw = new ServiceTracker();
			Iterator itrIns = assetSwUpt.iterator();
			while (itrIns.hasNext()) 
			 {
				assetSw = (ServiceTracker) itrIns.next(); 
			serviceObj = assetSw;  
			dbDTO.updateObjs(serviceObj);
		    } //End of while(itrIns)
		   }//end of if
			
		 if (assetSwDel.size() > 0) 
		 {
			 ServiceTracker assetSw = new ServiceTracker();
				Iterator itrIns = assetSwDel.iterator();
				while (itrIns.hasNext())
				{
					assetSw = (ServiceTracker) itrIns.next(); 
					serviceObj = assetSw;  
				dbDTO.deleteObjs(serviceObj);
				}//End of while(itrIns)
		}//end of if
			return null;
			
		} //end of servicVectParameter

	public List<AssetHardware> getAssetHardwareList() {
		// TODO Auto-generated method stub
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");		
		List lstAssetHardware = new ArrayList();
 
		String SQL_COUNTRY_QUERY = "SELECT  HW_NAME "
				+ " FROM "
				+ " ASSET_HARDWARE WHERE HW_NAME IS NOT NULL";
		
		lstAssetHardware =  dbDTO.nativeSql(SQL_COUNTRY_QUERY);

	return lstAssetHardware;
	}

	public List<AssetSoftware> getAssetSoftwareList() {
		// TODO Auto-generated method stub
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");		
		List lstAssetSoftware = new ArrayList();
 
		String SQL_COUNTRY_QUERY = "SELECT  SW_NAME "
				+ " FROM "
				+ " ASSET_SOFTWARE WHERE SW_NAME IS NOT NULL";
		
		lstAssetSoftware =  dbDTO.nativeSql(SQL_COUNTRY_QUERY);

	return lstAssetSoftware;
	}

	public List<AssetVendor> getAssetVenorList() {
		// TODO Auto-generated method stub
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");		
		List lstAssetVendor = new ArrayList();
 
		String SQL_COUNTRY_QUERY = "SELECT  VENDOR_NAME "
				+ " FROM "
				+ " ASSET_VENDOR_MASTER WHERE VENDOR_NAME IS NOT NULL";
		
		lstAssetVendor =  dbDTO.nativeSql(SQL_COUNTRY_QUERY);

	return lstAssetVendor;
	}

	public List<ServiceTracker> assetServiceTRDetailsSrchQry(
			DBMethodsImpl dbDTO, String filterQry) {
		// TODO Auto-generated method stub
//		System.out.println(searchQry);
			 String srchQry = "";
				if(filterQry.length() >0)
				{
					srchQry = searchQry +" WHERE "+filterQry; 
				}//end of if
				else
				{
					srchQry = searchQry;
				}//end of else
				 
//				System.out.println(searchQry);
			    return dbDTO.srchObj(srchQry);
					
			}//end of assetServiceTRDetailsSrchQry

	 
	
}
