package com.asset.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asset.modal.AssetSoftware;
import com.asset.modal.AssetVendor;
import com.asset.modal.AssetVendorServices;
import com.asset.modal.AssetVendorContacts;
import com.opensymphony.xwork2.ActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AssetVendorDB   
{

	private static final String SQLMAX_QRY_ = "select MAX(VENDOR_ID) from ASSET_VENDOR_MASTER assetHW ";
	private static final String SQLMAX_QRY_SER = "select MAX(SERVICE_ID) from ASSET_VENDOR_SERVICE assetHW ";
	private static final String SQLMAX_QRY_CONT = "select MAX(CONTACT_ID) from ASSET_VENDOR_CONTACTS assetHW ";
	private static final String searchQry =  " from com.asset.modal.AssetVendor assetHW ";
	private static final String searchQryVD= " from com.asset.modal.AssetVendorServices assetHW ";
	private static final String searchQryVC= " from com.asset.modal.AssetVendorContacts assetHW ";
	
	
	
	public String saveMasterVendorDets(AssetVendor vendorobj){
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
				
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
				
				String maxid="";				
				List maxList = dbDTO.nativeSql(SQLMAX_QRY_);	 			
				Iterator it = maxList.iterator();
				int count=0;
				String autogenVenVal="";
				String lastMaxId = "";
				int nextId=0;
				
				while(it.hasNext()){
					lastMaxId = (String)it.next();				
				}	//end of while		
				 
				if(lastMaxId == null){
					lastMaxId = "1";
				}//end of if
				else{					
					 String sub = lastMaxId.substring(1,3); 
					 String intpart = lastMaxId.substring(3);
					 nextId = Integer.parseInt(intpart); 
					 lastMaxId = String.valueOf(nextId+1);
					
				}//end of else
				 
				String nextId_str = "VEN"+String.format("%09d", Integer.parseInt(lastMaxId)); 
				vendorobj.setTxtFldAsstVDId(nextId_str);
				

              dbDTO.saveObjs(vendorobj);
              
              return vendorobj.getTxtFldAsstVDId();
	
	} //end of saveMasterVendorDets method 

	
	
	public void updateMasterVendorDets(AssetVendor vendorobj){
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
				DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
					
                dbDTO.updateObjs(vendorobj);
                
     		
	}//end of updateMasterVendorDets method 
	
	
	public void deleteMasterVendorDets(AssetVendor vendorobj){
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());
				DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
					
                dbDTO.deleteObjs(vendorobj);
     		
	}//end of updateMasterVendorDets method 
	
	
	
	
	public String assetVdVectParameter(Vector assetVendorVect,String strVendId)
	
	{ 
		WebApplicationContext context = WebApplicationContextUtils
		.getRequiredWebApplicationContext(ServletActionContext
				.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
		 
		
		Object assetVendorObj = null; 
		List assetVdIns = new ArrayList();
		List assetVdUpt = new ArrayList();
		List assetVdDel = new ArrayList();
		int compSize = assetVendorVect.size();
		if (compSize > 0) 
		{
			
			assetVdIns = (List) assetVendorVect.elementAt(0);
			assetVdUpt = (List) assetVendorVect.elementAt(1);
			assetVdDel = (List) assetVendorVect.elementAt(2);
		}//end of if 
		
		int insSize = assetVdIns.size(); 
		
		if (insSize > 0)
		{		 
			 
			AssetVendorServices assetVd = new AssetVendorServices(); 
		Iterator itrIns = assetVdIns.iterator();
		while (itrIns.hasNext())
			{
				assetVd = (AssetVendorServices) itrIns.next(); 
			        String maxid="";				
					List maxList = dbDTO.nativeSql(SQLMAX_QRY_SER);		 	
					Iterator it = maxList.iterator();
					int count=0;
					String autogenVenVal="";
					String lastMaxId = "";
					int nextId=0;
					while(it.hasNext()){
						lastMaxId = (String)it.next();				
					}	//end of while it		 
					
					if(lastMaxId == null){
						lastMaxId = "1";
					}//end of if
					else{					
						 String sub = lastMaxId.substring(1,3); 
						 String intpart = lastMaxId.substring(3);
						 nextId = Integer.parseInt(intpart); 
						 lastMaxId = String.valueOf(nextId+1);
						
					}//end of else
					 
					String nextId_str = "SER"+String.format("%017d", Integer.parseInt(lastMaxId));
					  
			        assetVd.setTxtFldAsstVDSerId(nextId_str);
			        assetVd.setTxtFldAsstVDVendrId(strVendId);
			        assetVendorObj = assetVd;
					 
					
					dbDTO.saveObjs(assetVendorObj);
				 
			 	}// End of while(itrIns)
		
			}//end of if 
		
	   if (assetVdUpt.size() > 0) 
	   {
		   AssetVendorServices assetVd = new AssetVendorServices();
		Iterator itrIns = assetVdUpt.iterator();
		while (itrIns.hasNext()) 
		 {
			assetVd = (AssetVendorServices) itrIns.next();
		 
			assetVendorObj = assetVd;
		 
		dbDTO.updateObjs(assetVendorObj);
	    } //End of while(itrIns)
	   }//end of if
		
	 if (assetVdDel.size() > 0) 
	 {
		 AssetVendorServices assetVd = new AssetVendorServices();
			Iterator itrIns = assetVdDel.iterator();
			while (itrIns.hasNext())
			{
				assetVd = (AssetVendorServices) itrIns.next();
			 
				assetVendorObj = assetVd;
		 
			dbDTO.deleteObjs(assetVendorObj);
			}//End of while(itrIns)
	}//end of if
	return null;
		
	} //end of assetVdVectParameter
	
public String assetVdVectParameter1(Vector assetVendorVect,String strVendId)
	
	{
	 
		
		WebApplicationContext context = WebApplicationContextUtils
		.getRequiredWebApplicationContext(ServletActionContext
				.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
		
		 
		Object assetVendorObj = null;
	 
		List assetVdIns = new ArrayList();
		List assetVdUpt = new ArrayList();
		List assetVdDel = new ArrayList();
		int compSize = assetVendorVect.size();
		if (compSize > 0) 
		{
			
			assetVdIns = (List) assetVendorVect.elementAt(0);
			assetVdUpt = (List) assetVendorVect.elementAt(1);
			assetVdDel = (List) assetVendorVect.elementAt(2);
		}//end of if 
		
		int insSize = assetVdIns.size();
	 
		if (insSize > 0)
		{		 
		 
			AssetVendorContacts assetVdCont =new AssetVendorContacts();
		Iterator itrIns = assetVdIns.iterator();
		while (itrIns.hasNext())
			{
			assetVdCont = (AssetVendorContacts) itrIns.next();
			         
			        String maxid="";				
					List maxList = dbDTO.nativeSql(SQLMAX_QRY_CONT);				
				 
					Iterator it = maxList.iterator();
					int count=0;
					String autogenVenVal="";
					String lastMaxId = "";
					int nextId=0;
					while(it.hasNext()){
						lastMaxId = (String)it.next();				
					}	//end of while it		
				 	
					if(lastMaxId == null){
						lastMaxId = "1";
					}else{					
						 String sub = lastMaxId.substring(1,4);
					 
						 String intpart = lastMaxId.substring(4);
						 nextId = Integer.parseInt(intpart); 
						 lastMaxId = String.valueOf(nextId+1);
						
					}//end of else
				 	String nextId_str = "CONT"+String.format("%016d", Integer.parseInt(lastMaxId)); 
					assetVdCont.settxtFldAsstVDContId(nextId_str);
					assetVdCont.setTxtFldAsstVDVendrId(strVendId);
			        
			        assetVendorObj = assetVdCont;
					 
					dbDTO.saveObjs(assetVendorObj);
				 
			}// End of while(itrIns)
			}//end of if 
		
	   if (assetVdUpt.size() > 0) 
	   {
		   AssetVendorContacts assetVd = new AssetVendorContacts();
		Iterator itrIns = assetVdUpt.iterator();
		while (itrIns.hasNext()) 
		 {
			assetVd = (AssetVendorContacts) itrIns.next();
		 
			assetVendorObj = assetVd;
	 
		dbDTO.updateObjs(assetVendorObj);
	    } //End of while(itrIns)
	   }//end of if
		
		 if (assetVdDel.size() > 0) 
		 {
			 AssetVendorContacts assetVd = new AssetVendorContacts();
				Iterator itrIns = assetVdDel.iterator();
				while (itrIns.hasNext())
				{
					assetVd = (AssetVendorContacts) itrIns.next();
				 
					assetVendorObj = assetVd;
			 
				dbDTO.deleteObjs(assetVendorObj);
				}//End of while(itrIns)
		}//end of if
		
	   return null;
		
	} //end of assetVdVectParameter1 method
	
	
	@SuppressWarnings("unchecked")
    public List<AssetVendor> assetVendorDetailsSrchQry(DBMethodsImpl dbDTO  , String filterQry) 
     {

     	
	 String srchQry = "";
		if(filterQry.length() >0)
		{
			srchQry = searchQry +" WHERE "+filterQry;
	 
		}//end of if
		else
		{  
			srchQry = searchQry;
		}//end of else
		
		AssetVendor assetVd = new AssetVendor();
	 
	    return dbDTO.srchObj(srchQry);
			
	}//end of assetSoftwareDetailsSrchQry
	
	@SuppressWarnings("unchecked")
    public List<AssetVendorServices> assetVendorServiceDetailsSrchQry(DBMethodsImpl dbDTO  , String filterQry) 
     {

     	
	 String srchQry = "";
		
			srchQry = searchQryVD +" WHERE "+filterQry;
		 
		AssetVendorServices assetVd = new AssetVendorServices();
		  return dbDTO.srchObj(srchQry);
			
	}//end of assetVendorServiceDetailsSrchQry
		
	@SuppressWarnings("unchecked")
    public List<AssetVendorContacts> assetVendorContactsDetailsSrchQry(DBMethodsImpl dbDTO  , String filterQry) 
     {
 
	 String srchQry = "";
		
			srchQry = searchQryVC +" WHERE "+filterQry;
		 	AssetVendorContacts assetVd = new AssetVendorContacts();
		 
	    return dbDTO.srchObj(srchQry);
			
	}//end of assetVendorContactsDetailsSrchQry
}//end of AssetVendorDB
