package com.asset.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asset.modal.AssetHardware;

public class AssetHardwareDB  
{
	private static final String searchQry = "from com.asset.modal.AssetHardware assetHW ";
	private static final String SQLMAX_QRY_ = "select MAX(HW_ID) from ASSET_HARDWARE assetHW ";

	public String assetHwVectParameter(Vector assetHwVect)
	{ 
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");		
		Object assetHardwareObj = null;
		
		List assetHwIns = new ArrayList();
		List assetHwUpt = new ArrayList();
		List assetHwDel = new ArrayList();
		
		int compSize = assetHwVect.size();
		if (compSize > 0)
		{
			assetHwIns = (List) assetHwVect.elementAt(0);
			assetHwUpt = (List) assetHwVect.elementAt(1);
			assetHwDel = (List) assetHwVect.elementAt(2);
		}//end of if 
		
		
		//INSERT CODE
		int insSize = assetHwIns.size(); 
		if (insSize > 0) 
		{		  
			AssetHardware assetHw = new AssetHardware();
			Iterator itrIns = assetHwIns.iterator();
			while (itrIns.hasNext()) 
			{
				assetHw = (AssetHardware) itrIns.next(); 
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
				 
				String nextId_str = "AHW"+String.format("%09d", Integer.parseInt(lastMaxId));
				 
		        
				assetHw.setTxtFldAsstHDId(nextId_str);
								
		        assetHardwareObj = assetHw;
				 
				dbDTO.saveObjs(assetHardwareObj);
			}// End of while(itrIns)
		}//end of if 
		
		
		
		//UPDATE CODE
	   if (assetHwUpt.size() > 0) 
	   {
		AssetHardware assetHw = new AssetHardware();
		Iterator itrIns = assetHwUpt.iterator();
		       while (itrIns.hasNext()) 
		       {
			   assetHw = (AssetHardware) itrIns.next(); 
		       assetHardwareObj = assetHw; 
		       dbDTO.updateObjs(assetHardwareObj);
		       }//End of while
	   }//end of Update
	   
	   
	   
	   //DELETE CODE	
		if (assetHwDel.size() > 0) 
		{
			AssetHardware assetHw = new AssetHardware();
			Iterator itrIns = assetHwDel.iterator();
			while (itrIns.hasNext())
			{
				assetHw = (AssetHardware) itrIns.next(); 
			    assetHardwareObj = assetHw; 
			    dbDTO.deleteObjs(assetHardwareObj);
			}//end of while
		}//end of if
		return null;
	}//end of assetHwVectParameter
	
	@SuppressWarnings("unchecked")

	public List<AssetHardware> assetHardwareDetailsSrchQry(DBMethodsImpl dbDTO  , String filterQry) 
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
		
		AssetHardware assetHw = new AssetHardware(); 
        return dbDTO.srchObj(srchQry);
		
	}//end of assetHardwareDetailsSrchQry
	
	public List<AssetHardware> assetHardwareDetailsSubSrchQry(DBMethodsImpl dbDTO  , String filterQry) 
	{
		//System.out.println("DB");   
		String srchQry = "";
		if(filterQry.length() >0)
		{
			srchQry = searchQry +" WHERE "+filterQry; 
		}//end of if 
		else
		{
			srchQry = searchQry; 
		}//end of else
		
		AssetHardware assetHw = new AssetHardware(); 
        return dbDTO.srchObj(srchQry);
		
	}//end of assetHardwareDetailsSrchQry
		
}//end of AssetHardwareDaoImpl
