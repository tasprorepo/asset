package com.asset.preaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetHardware;
import com.asset.utils.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class ApplicationPre extends ActionSupport
{
	

	
	public List getSwCategory()
	{
		List  SwCategList = new ArrayList();
		String strSwCateg = getText("sw.category"); 
    	String[] strArr = CommonUtility.splitSplChars(strSwCateg, "^");
        
    	 int len = strArr.length;
    	 for (int i = 0; i < len; i++)
         {
        	 SwCategList.add(strArr[i]);
         }//end of for 
       
    	 return SwCategList;
    }//end of  List getSwCategory
	
	public List getAttachmntCatgry()
	{
		List  AttachmtCategList = new ArrayList();
		String strAttachmntCateg = getText("at.category"); 
    	String[] strArr = CommonUtility .splitSplChars(strAttachmntCateg, "^");
        
    	 int len = strArr.length;
    	 for (int i = 0; i < len; i++)
         {
    		 AttachmtCategList.add(strArr[i]);
         }//end of for 
       
    	 return AttachmtCategList;
    }//end of  List getAttachmentCategory
	
	public List getlicenseType()
	{
		List  SWlicenseList = new ArrayList();
		String strSwLicense = getText("license.Type"); 
    	String[] strArr = CommonUtility .splitSplChars(strSwLicense, "^"); 
    	 
    	int len = strArr.length;
         for (int i = 0; i < len; i++)
         {
        	 SWlicenseList.add(strArr[i]);
        
         }//end of for 
       return SWlicenseList;
    }// end of List getlicenseType()
	
   public List getSwStatus()
   {
	   List SwStatusList = new ArrayList();
       String strStatus= getText("sw.status"); 
	   String[] strArr = CommonUtility .splitSplChars(strStatus, "^");

	   int len = strArr.length;
       for (int i = 0; i < len; i++) 
       {
    	 SwStatusList.add(strArr[i]);
       }//end of for
     
     return SwStatusList;
   }//end of List getSwStatus()
   
   public List getHwCategory()
	{
		List  HwCategList = new ArrayList();
		String strHwCateg = getText("hw.category"); 
   	String[] strArr = CommonUtility .splitSplChars(strHwCateg, "^");
       
   	 int len = strArr.length;
   	 for (int i = 0; i < len; i++)
        {
       	 HwCategList.add(strArr[i]);
        }//end of for 
      
   	 return HwCategList;
   }
   public List getHwStatus()
   {
	   List HwStatusList = new ArrayList();
       String strStatus= getText("hw.status"); 
	   String[] strArr = CommonUtility .splitSplChars(strStatus, "^");

	   int len = strArr.length;
       for (int i = 0; i < len; i++) 
       {
    	 HwStatusList.add(strArr[i]);
       }//end of for
     
     return HwStatusList;
   }
   public List getVnCountry()
   {
	   List VnCountryList = new ArrayList();
       String strCountry= getText("vn.country"); 
	   String[] strArr = CommonUtility .splitSplChars(strCountry, "^");

	   int len = strArr.length;
       for (int i = 0; i < len; i++) 
       {
    	   VnCountryList.add(strArr[i]);
       }//end of for
     
     return VnCountryList;
   }
}//end of ApplicationPre