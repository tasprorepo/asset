package com.asset.service;

import java.util.List;
import java.util.Vector;

import com.asset.db.DBMethodsImpl;
import com.asset.db.ServiceTrckDb;
import com.asset.modal.AssetHardware;
import com.asset.modal.AssetSoftware;
import com.asset.modal.AssetVendor;
import com.asset.modal.ServiceTracker;

public class ServTrService {
	 
	public void servTRSave(Vector serviceTrackerVect) {
		// TODO Auto-generated method stub
//		System.out.println("in service =====>"+serviceTrackerVect);
		ServiceTrckDb imp =  new ServiceTrckDb();
		
		imp.servicVectParameter(serviceTrackerVect);
	}

	public List<AssetHardware> getAssetHardwareList() {
		// TODO Auto-generated method stub
		ServiceTrckDb srtrDb=new ServiceTrckDb(); 
		return srtrDb.getAssetHardwareList();
	}

	public List<AssetSoftware> getAssetSoftwareList() {
		// TODO Auto-generated method stub
		ServiceTrckDb srtrDb=new ServiceTrckDb(); 
		return srtrDb.getAssetSoftwareList();
	}

	public List<AssetVendor> getAssetVendorList() {
		// TODO Auto-generated method stub
		ServiceTrckDb srtrDb=new ServiceTrckDb(); 
		return srtrDb.getAssetVenorList();
	}

	public List<ServiceTracker> assetServTRSrchQry(DBMethodsImpl dbDTO,
			String srchQry) {
		// TODO Auto-generated method stub
		
//		System.out.println("search service");
		ServiceTrckDb imp =  new ServiceTrckDb();
		
		return imp.assetServiceTRDetailsSrchQry(dbDTO,srchQry);
	} //end of assetSoftwareDetailsSrchQry


	
	
	
}
