package com.asset.preaction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class AssetAttachmentsPre extends ApplicationPre{
	private static final long serialVersionUID = 1L;
    
	public String execute()
	{
		ActionContext ctx = ActionContext.getContext();
   	    HttpServletRequest req = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
	     
   	    SessionMap sess = (SessionMap)ctx.get(ServletActionContext.SESSION);
   	    sess.put("ATTACHMNT_CATGRY",getAttachmntCatgry()); 
		return "success";
	}//end of execute


}
