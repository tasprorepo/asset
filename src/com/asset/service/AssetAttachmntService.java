package com.asset.service;

import java.util.List;
import java.util.Vector;

import org.springframework.web.context.WebApplicationContext;

import com.asset.db.AssetAttachmntDB;
import com.asset.db.AssetHardwareDB;
import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetAttachmnt;
//import com.mysql.jdbc.ResultSet;


public class AssetAttachmntService {
	public void assetAttachmntSave(Vector assetAttachments)
	{ 
		AssetAttachmntDB imp =  new AssetAttachmntDB();
		imp.assetAttachmntVectParameter(assetAttachments);
	}//end of assetHDwareSave

	public List<AssetAttachmnt> assetAttachmentDetailsSrchQry(DBMethodsImpl dbDTO,String srchQry)
	{ 
		AssetAttachmntDB imp =  new AssetAttachmntDB();
		return imp.assetAttachmentDetailsSrchQry(dbDTO,srchQry);
	}//end of assetHardwareDetailsSrchQry
	public java.sql.ResultSet searchAttachmentById(DBMethodsImpl dto,String strAtchId)
	{ 
		AssetAttachmntDB imp =  new AssetAttachmntDB();

		return imp.searchassetAttachmentById(dto,strAtchId);
		
	}
	
	public java.sql.ResultSet searchassetAttachmentByIds(DBMethodsImpl dto,String strAtchId,WebApplicationContext context)
	{ 
		AssetAttachmntDB imp =  new AssetAttachmntDB();

		return imp.searchassetAttachmentByIds(dto,strAtchId,context);
		
	}
}
