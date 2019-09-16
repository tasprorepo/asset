package com.asset.preaction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AssetHardwarePre extends ApplicationPre
{
	private static final long serialVersionUID = 1L;
    
	public String execute()
	{
		ActionContext ctx = ActionContext.getContext();
   	    HttpServletRequest req = (HttpServletRequest) ctx
			.get(ServletActionContext.HTTP_REQUEST);
	     SessionMap sess = (SessionMap)ctx.get(ServletActionContext.SESSION);

		 sess.put("HW_CATEGORY",getHwCategory());
		 sess.put("HW_STATUS",getHwStatus()); 
		return "success";
	}//end of execute

	
	
}//end of AssetHardwarePre