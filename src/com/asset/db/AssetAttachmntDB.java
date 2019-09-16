package com.asset.db;
 
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List;
import java.util.Vector;
  

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asset.modal.AssetAttachmnt; 

public class AssetAttachmntDB {

	private static final String searchQry = "from com.asset.modal.AssetAttachmnt assetHW ";
	private static final String SQLMAX_QRY_ = "select MAX(ATTACHMNT_ID) from AssetAttachmnt assetHW "; 
	
	
public String AssetAttachmntQry(String Qry)
{
	return Qry;
	
}
	public void assetAttachmntVectParameter(Vector assetAttachmntVect)
	{ 
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");	
		
		Object assetAttachmntObj = null;
		List<String> attachIns = new ArrayList<String>(0);
		List<String> attachUpd = new ArrayList<String>(1);
		List<String> attachDel = new ArrayList<String>(2);
		
		List assetAttachmntIns = new ArrayList();
		List assetAttachmntUpt = new ArrayList();
		List assetAttachmntDel = new ArrayList();
		
		int compSize = assetAttachmntVect.size();
		if (compSize > 0)
		{ 
			attachIns = (List) assetAttachmntVect.elementAt(0); 
			attachUpd = (List) assetAttachmntVect.elementAt(1);
			attachDel = (List) assetAttachmntVect.elementAt(2);
		}//end of if 
		
		 
		int insSize = attachIns.size(); 
		if (insSize > 0) 
		{		 

			for (String insqry : attachIns) { 
				dbDTO.attachSql(insqry);
			}
 
		}//end of if 
		
		int updSize = attachUpd.size();
		 
		if (updSize > 0) 
		{		 
			for (String updqry : attachUpd) { 
				dbDTO.attachSql(updqry);
			}
		}
		 
	   
		int delSize = attachDel.size(); 
		if (delSize > 0) 
		{		  
			for (String delqry : attachDel) { 
				dbDTO.attachSql(delqry);
			}
		}
	}
		 

	public List<AssetAttachmnt> assetAttachmentDetailsSrchQry(DBMethodsImpl dbDTO  , String filterQry) 
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
		 
        return dbDTO.srchObj(srchQry);
		
	}//end of assetHardwareDetailsSrchQry
	private static final String HQL_FIND_ADVATTACH_BY_ID = "select attch.DOCUMENTS, attch.DOC_TITLE,   attch.FILE_TYPE "
			+ " from ASSET_ATTACHMENTS attch ";
	
	public ResultSet searchassetAttachmentById(DBMethodsImpl dto, String strAtchId) throws HibernateException {
		ResultSet attachDocList = null;
		try { 
			attachDocList = dto.downloadBFILE(HQL_FIND_ADVATTACH_BY_ID	 + " where ATTACHMNT_ID='"+strAtchId+"'");
			
		} catch (Exception he) {
			he.printStackTrace();
		}
		return attachDocList;
	} // End of searchAttachmentById
	
	public ResultSet searchassetAttachmentByIds(DBMethodsImpl dto, String strAtchId,WebApplicationContext context) throws HibernateException {
		ResultSet attachDocList = null;
		try { 
			attachDocList = dto.downloadBFILEServ(HQL_FIND_ADVATTACH_BY_ID	 + " where ATTACHMNT_ID='"+strAtchId+"'",context);
			
		} catch (Exception he) {
			he.printStackTrace();
		}
		return attachDocList;
	}
}
