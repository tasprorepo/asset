package com.asset.preaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.springframework.web.context.WebApplicationContext;

import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetHardware;
import com.asset.modal.AssetSoftware;
import com.asset.modal.AssetVendor;
import com.asset.service.ServTrService;
import com.opensymphony.xwork2.ActionContext;

public class ServiceTrackingPre extends ApplicationPre{

private static final long serialVersionUID = 1L;

	public String execute()
	{
		
		ActionContext ctx = ActionContext.getContext();
   	    HttpServletRequest req = (HttpServletRequest) ctx
			.get(ServletActionContext.HTTP_REQUEST);
	    SessionMap sess = (SessionMap)ctx.get(ServletActionContext.SESSION);
 	    ServTrService srtrckserv = new ServTrService();
 
	    List<AssetHardware> assetHardwarelist = srtrckserv.getAssetHardwareList();  
	    sess.put("HARDWARE_LIST",assetHardwarelist);
		
	    List<AssetSoftware> assetSoftwarelist = srtrckserv.getAssetSoftwareList();  
	    sess.put("SOFTWARE_LIST",assetSoftwarelist);
		
	    List<AssetVendor> assetVendorlist = srtrckserv.getAssetVendorList();  
	    sess.put("VENDOR_LIST",assetVendorlist);
		 
		return "success";
	}//end of execute

	
}
