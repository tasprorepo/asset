package com.asset.service;

import java.util.List;
import java.util.Vector;

import com.asset.db.AssetHardwareDB;
import com.asset.db.AssetSoftwareDB;
import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetHardware;
import com.asset.modal.AssetSoftware;
public class AssetSoftwareService 
{
   void assetSTware(AssetSoftware assetSoftware)
   {
		
   }//end of assetSTware

    public void assetSTwareSave(Vector assetSoftware)
    {	 
		AssetSoftwareDB imp =  new AssetSoftwareDB();
		
		imp.assetSwVectParameter(assetSoftware);
	}// end of assetSTwareSave
	
	List<AssetSoftware> assetSoftwareDetails(AssetSoftware assetSoftware)
	{
		return null;
	}// end of assetSoftwareDetails
	
	public List<AssetSoftware> assetSoftwareDetailsSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{ 
		AssetSoftwareDB imp =  new AssetSoftwareDB();
		
		return imp.assetSoftwareDetailsSrchQry(dbDTO,srchQry);
	} //end of assetSoftwareDetailsSrchQry
	
	public List<AssetSoftware> assetSoftwareDetailsDeleteQry(String srchQry)
	{ 
		return null;
	}//end of assetSoftwareDetailsDeleteQry
	List<AssetSoftware> assetSoftwareDetails()
	{
		return null;
	}//end of assetSoftwareDetails
	
}//AssetSoftwareService
