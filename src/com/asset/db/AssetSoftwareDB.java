package com.asset.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asset.modal.AssetSoftware;

public class AssetSoftwareDB   //implements AssetSoftwareDao 
{

	private static final String searchQry = " from com.asset.modal.AssetSoftware assetHW ";
	private static final String SQLMAX_QRY_ = "select MAX(SW_ID) from ASSET_SOFTWARE assetHW ";
	
	public String assetSwVectParameter(Vector assetSwVect)
	
	{ 
		
		WebApplicationContext context = WebApplicationContextUtils
		.getRequiredWebApplicationContext(ServletActionContext
				.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
		 
		
			
		Object assetSoftwareObj = null;
		
		List assetSwIns = new ArrayList();
		List assetSwUpt = new ArrayList();
		List assetSwDel = new ArrayList();
		int compSize = assetSwVect.size();
		if (compSize > 0) 
		{
			
			assetSwIns = (List) assetSwVect.elementAt(0);
			assetSwUpt = (List) assetSwVect.elementAt(1);
			assetSwDel = (List) assetSwVect.elementAt(2);
		}//end of if 
		
		int insSize = assetSwIns.size();
		 
		
		if (insSize > 0)
		{		  
			AssetSoftware assetSw = new AssetSoftware();
		Iterator itrIns = assetSwIns.iterator();
			while (itrIns.hasNext())
			{
				assetSw = (AssetSoftware) itrIns.next(); 
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
					
					String nextId_str = "ASW"+String.format("%09d", Integer.parseInt(lastMaxId));  
					assetSw.setTxtFldAsstSWId(nextId_str); 
					assetSoftwareObj = assetSw; 
					dbDTO.saveObjs(assetSoftwareObj);
			}// End of while(itrIns)
			}//end of if 
		
	   if (assetSwUpt.size() > 0) 
	   {
		AssetSoftware assetSw = new AssetSoftware();
		Iterator itrIns = assetSwUpt.iterator();
		while (itrIns.hasNext()) 
		 {
		assetSw = (AssetSoftware) itrIns.next(); 
		assetSoftwareObj = assetSw; 
		dbDTO.updateObjs(assetSoftwareObj);
	    } //End of while(itrIns)
	   }//end of if
		
	 if (assetSwDel.size() > 0) 
	 {
			AssetSoftware assetSw = new AssetSoftware();
			Iterator itrIns = assetSwDel.iterator();
			while (itrIns.hasNext())
			{
				assetSw = (AssetSoftware) itrIns.next(); 
				assetSoftwareObj = assetSw; 

			dbDTO.deleteObjs(assetSoftwareObj);
			}//End of while(itrIns)
	}//end of if
		return null;
		
	} //end of assetSwVectParameter
	
	
	@SuppressWarnings("unchecked")
    public List<AssetSoftware> assetSoftwareDetailsSrchQry(DBMethodsImpl dbDTO  , String filterQry) 
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
		
		AssetSoftware assetSw = new AssetSoftware(); 

	    return dbDTO.srchObj(srchQry);
			
	}//end of assetSoftwareDetailsSrchQry
		
}//end of AssetSoftwareDB
