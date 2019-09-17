package com.asset.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtility 
{

	public static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat dbFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
	
	public static Date convertStringToDate(String strToConvert)
	{
		Date date = null; 
		
		if(strToConvert != null && !strToConvert.isEmpty())
		{			
				try
				{
					date = format.parse(strToConvert);
				}//end of try
				catch (ParseException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//end of catch
				   
		}//end of if 
		   
		   return date;
		   
   }//end of convertStringToDate
	
	public static String convertDateToString(Date strToConvert)
	{
		if(strToConvert != null){
	    return   format.format(strToConvert).toString();
		}else
			return "";
	
	}//end of convertStringToDate
	
	public static java.sql.Timestamp getTimestampDate(String strToConvert)
	{
		java.util.Date today = new java.util.Date();
		try 
		{
			return new java.sql.Timestamp(dbFormat.parse(strToConvert).getTime());
		}//end of try 
		catch (ParseException e) 
		{
			e.printStackTrace();
			return new java.sql.Timestamp(today.getTime());
		}//end of catch
		
		
	}//end of getTimestampDate
	
	

	 public static String[] splitSplChars(String str,String splChar)
	 {
		  StringTokenizer strtoken = new StringTokenizer(str, splChar); 
		  String[] strArr = new String[strtoken.countTokens()];
		 
		  try
		  {
			  int count=0;
			  while(strtoken.hasMoreTokens())
			  {	
				  String test = (String)strtoken.nextToken(); 
				  strArr[count] =test; 
				  count++;
			  }	//end of while		
			  
			  
			  for(String ss : strArr )
			  { 
			  }//end of for
			  
		  }//end of try
		  catch(Exception ex)
		  {
			  ex.printStackTrace();	  
		  }//end of catch	  
		  
		  return  strArr;
    }//end of splitSplChars
	
	 
	 
	 public static boolean  isValidUser(HttpServletRequest requestObj) {
	        HttpSession UTSession = requestObj.getSession(false);
//	        UTSession.invalidate();
	      
	        if(checkNullVal(UTSession)){ 
		            return false; 
	        }else{
	        	return true;
	        }
	    } //end isValidUser()
	 
	 
	  public static boolean checkNullVal(Object obj) {
	    if (obj == null) {
	           return true;
	       } else {
	            return false;
	       }
	   } //end checkNullVal
	  
}//end of CommonUtility



