package com.asset.service;

import java.util.List;
import java.util.Vector;

import com.asset.db.AssetHardwareDB;
import com.asset.db.AssetVendorDB;
import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetHardware;
import com.asset.modal.AssetVendor;


public class AssetHardwareService 
{
	public void assetHDwareSave(Vector assetHardware)
	{ 
		AssetHardwareDB imp =  new AssetHardwareDB();
		imp.assetHwVectParameter(assetHardware);
	}//end of assetHDwareSave

	public List<AssetHardware> assetHardwareDetailsSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{
	 
		AssetHardwareDB imp =  new AssetHardwareDB();
		return imp.assetHardwareDetailsSrchQry(dbDTO,srchQry);
	}//end of assetHardwareDetailsSrchQry

	public List<AssetHardware> assetHardwareDetailsSubSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{ 
		AssetHardwareDB imp =  new AssetHardwareDB();
		//System.out.println("assetHardwareDetailsSubSrchQry");   
		return imp.assetHardwareDetailsSubSrchQry(dbDTO,srchQry);
	}// end of assetVendorDetailsSubSrchQry
}//end of AssetHardwareService
