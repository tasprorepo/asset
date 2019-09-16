package com.asset.db;

import java.util.List;
import com.asset.modal.AssetLogin;
import org.apache.struts2.ServletActionContext; 
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class LoginDB 
{  
	
    private static final String HQL_LOGIN_QRY = " from com.asset.modal.AssetLogin assetHW";
 
	public List<AssetLogin> assetLoginDetailsSrchQry( String filterQry) 
	{
		 
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
		
		String srchQry = "";
		
		if(filterQry.length() >0)
		{
			srchQry = HQL_LOGIN_QRY +" WHERE "+filterQry;
			 
		}//end of if 
		else
		{
			srchQry = HQL_LOGIN_QRY;			 
		}//end of else
		
		return dbDTO.srchObj(srchQry);
			
	}//end of assetLoginDetailsSrchQry
	
}//end of LoginDB 
