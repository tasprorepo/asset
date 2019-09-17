package com.asset.service;

import java.util.List;
import java.util.Vector;

import com.asset.db.AssetHardwareDB;
import com.asset.db.AssetSoftwareDB;
import com.asset.db.AssetVendorDB;
import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetHardware;
import com.asset.modal.AssetSoftware;
import com.asset.modal.AssetVendor;
import com.asset.modal.AssetVendorServices;
import com.asset.modal.AssetVendorContacts;
public class AssetVendorService 
{
   void assetVDdar(AssetVendor assetVendor)
   {
		
   }//end of assetVDdar
   public void assetVDwareSave( AssetVendor obj,Vector assetVdContVect)
   {	
		
		AssetVendorDB imp =  new AssetVendorDB();
		
		String strVendId = imp.saveMasterVendorDets(obj);		 
//	   imp.assetVdVectParameter(assetVendorVect,strVendId);
       imp.assetVdVectParameter1(assetVdContVect,strVendId);
	}//end of assetVDwareSave
    
   public void assetVendorUpdate( AssetVendor obj,Vector assetVdContVect)
   {	
		AssetVendorDB imp =  new AssetVendorDB();
		
		imp.updateMasterVendorDets(obj);		
//		imp.assetVdVectParameter(assetVendorVect,obj.getTxtFldAsstVDId());
        imp.assetVdVectParameter1(assetVdContVect,obj.getTxtFldAsstVDId());
	}//end of assetVDwareUpdate
   

   // Poovathi add assetVendorDelete Service Method
   
//   public void assetVendorDelete( AssetVendor obj,Vector assetVdContVect)
   
   
   
   public void assetVendorDelete( Vector assetVdContVect,AssetVendor obj)
   {	
		AssetVendorDB imp =  new AssetVendorDB();        
		imp.assetVdVectParameter1(assetVdContVect,obj.getTxtFldAsstVDId());
		imp.deleteMasterVendorDets(obj);		
//		imp.assetVdVectParameter(assetVendorVect,obj.getTxtFldAsstVDId());
        
	}
   
   
   
   
	List<AssetVendor> assetVendorDetails(AssetVendor assetVendor)
	{
		return null;
	}// end of assetVendorDetails
	
	public List<AssetVendor> assetVendorDetailsSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{ 
		AssetVendorDB imp =  new AssetVendorDB();
		
		return imp.assetVendorDetailsSrchQry(dbDTO,srchQry);
	} //end of assetSoftwareDetailsSrchQry
	
	public List<AssetVendor> assetVendorDetailsSubSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{ 
		AssetVendorDB imp =  new AssetVendorDB();
		
		return imp.assetVendorDetailsSrchQry(dbDTO,srchQry);
	}// end of assetVendorDetailsSubSrchQry
	
	public List<AssetVendorServices> assetVendorServiceDetailsSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{ 
		AssetVendorDB imp =  new AssetVendorDB();
		
		return imp.assetVendorServiceDetailsSrchQry(dbDTO,srchQry);
	}// end of assetVendorServiceDetailsSrchQry
	
	public List<AssetVendorContacts> assetVendorContactsDetailsSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{ 
		AssetVendorDB imp =  new AssetVendorDB();
		
		return imp.assetVendorContactsDetailsSrchQry(dbDTO,srchQry);
	}// end of assetVendorContactsDetailsSrchQry
	
	List<AssetVendor> assetVendorDetails()
	{
		return null;
	}//end of assetVendorDetails
	
}//AssetVendorService
