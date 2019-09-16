package com.asset.dispatch;

import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.asset.modal.AssetLogin;
import com.asset.modal.AssetVendor;
import com.asset.service.LoginService;
import com.asset.utils.CommonUtility;
import com.asset.utils.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class LoginProcess extends ActionSupport
{

	private static final long serialVersionUID = 1L;

	public String execute() 
	{ 

		boolean status = getAssetLoginSrchDets();

		if (status == true) 
		{
			return "success";
		} //end of if
		else
		{
			addActionMessage("Incorrect User Id / Password  ");
			return "failed";
			
		}//end of else
		
	}//end of execute

	public boolean getAssetLoginSrchDets()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
 
		HttpSession session=request.getSession();
	      
		StringBuffer strBufFilterQry = new StringBuffer();
		List<AssetLogin> resultList = new ArrayList<AssetLogin>();
		
		String strEmptyStr = "";
		
		try 
		{

			String usernam = (request.getParameter("username") == null ? ""
					: request.getParameter("username"));
            String userpass = (request.getParameter("password") == null ? ""
					: request.getParameter("password"));
			 
			session.setAttribute("uname",usernam);
		    session.setAttribute("upass",userpass);
			
			if (strBufFilterQry.length() > 0) 
			{
				strBufFilterQry
						.append(usernam.equalsIgnoreCase(strEmptyStr) ? ""
								: " AND UPPER(assetHW.userID) LIKE UPPER('"
										+ usernam + "')");

			} //end of if
			else 
			{
				strBufFilterQry
						.append(usernam.equalsIgnoreCase(strEmptyStr) ? ""
								: " UPPER(assetHW.userID) LIKE UPPER('"
										+ usernam + "')");
			}//end of else

			if (strBufFilterQry.length() > 0) 
			{
				strBufFilterQry
						.append(userpass.equalsIgnoreCase(strEmptyStr) ? ""
								: " AND UPPER(assetHW.password) LIKE UPPER('"
										+ userpass + "')");
             }//end of if
			else 
			{
				strBufFilterQry
						.append(userpass.equalsIgnoreCase(strEmptyStr) ? ""
								: " UPPER(assetHW.password) LIKE UPPER('"
										+ userpass + "')");
			}//end of else
 
			
			LoginService loginobj = new LoginService();
            resultList = loginobj.assetLoginDetailsSrchQry(strBufFilterQry.toString()); 
		
		}//end of try
		
		catch (Exception exp)
		{
			exp.printStackTrace();
		}//end of catch

	
	if (resultList.size() > 0 && !resultList.equals(null) && !resultList.equals(""))
		
		 
		  
			return true;
	
	else
			return false;

   }//end of getAssetLoginSrchDets

}//end of LoginProcess
