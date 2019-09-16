package com.asset.db;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asset.utils.Constants;
 

public class UtilityDB {

	static Logger fplog = Logger.getLogger(UtilityDB.class);
	
	
	
	public static boolean chkValidDB(){
		
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethods dbDTO = (DBMethods) ctx.getBean(Constants.DBDAO_BEAN);
		
		try{
			dbDTO.ChkValidDB(Constants.HQL_CHK_DB);
		}catch(Exception e){
			return false;
		}		
		return true;		
	}
}
