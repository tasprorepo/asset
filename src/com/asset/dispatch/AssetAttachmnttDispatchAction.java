package com.asset.dispatch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleResultSet;
import oracle.sql.BFILE;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.asset.db.AssetAttachmntDB;
import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetAttachmnt;
import com.asset.service.AssetAttachmntService;
import com.asset.utils.CommonUtility;
import com.asset.utils.Constants;
//import com.fpms.DB.UtilityDB;
//import com.fpms.DBIntf.DBIntf;
//import com.fpms.DBService.AgentService;
//import com.fpms.Utility.FPMSConstants;
//import com.fpms.Utility.Utility;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AssetAttachmnttDispatchAction extends ActionSupport 
{
	private static final long serialVersionUID = 1L;
	
	static ResourceBundle resource = ResourceBundle.getBundle("applicationresource");
	private File[] upload;
    private String[] uploadFileName;
    private String[] uploadContentType;
	  
    String strDestDirWithPath =resource.getString("asset.attachloc");
		
  
    static String strAttachId = "";
    public String asstAttachmntCUDOpern()
	{ 
    	 
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(!CommonUtility.isValidUser(request)){
			return Constants.SESSION_EXPIRED;
		}
				
//		if(!com.asset.db.UtilityDB.chkValidDB()){
//   			return Constants.INVALID_DB;
//   		}	
//		
//		if (!TokenHelper.validToken()) {			
//            return Constants.INVALID_TOKEN;
//        } 
		
		AssetAttachmntService attachservice = new AssetAttachmntService();
		Vector assetAttachmntVect = getAssetAttachmntDetails(request); 
		attachservice.assetAttachmntSave(assetAttachmntVect);
		return SUCCESS;
     }
  
    public static boolean nullOrBlank(String str) {
        return ((str == null) || (str.length() == 0));
    }
    
    public static File createPhysicalDir(){
		  
		  StringBuffer mainDirPath = new StringBuffer();
		  String strDestFileNameWithPath =resource.getString("asset.attachloc");
		  String strSplChars = "";
		  File destfile = null;	
		  
		  try{
		  
			 	  destfile = new File(strDestFileNameWithPath);
			 	  if(!destfile.exists()){
			 		  destfile.mkdir();
			 	  }
		  
		
		  }catch(Exception ex){
			 ex.printStackTrace();
		}
		return destfile;
		  
	  }  
    public static String createPhysicalFile(File attachSrcFile,File destBFile){
		  
		  File destfile = destBFile;	
		  String strReturnMsg ="";
				  
		  
		  try{	    		
	    		 
	    	//	System.out.println("destfile=="+destfile);
	    		if(!destfile.getParentFile().exists()){
	    			destfile.getParentFile().mkdirs();
	    		}
	    		
	    		
	    		FileInputStream srcStream = new FileInputStream(attachSrcFile);
	    		FileOutputStream destStream = new FileOutputStream(destfile);
	    		
	    		int len = (int)(long)attachSrcFile.length();             
	    		byte[] buffer = new byte[len];
	    	 

	    		int length;
	    		while ((length = srcStream.read(buffer)) > 0){                
	    		destStream.write(buffer, 0, length);                  
	    		}

	    		 
	    		destfile=null;

	    		srcStream.close();
	    		destStream.close();
	    		
	    	 
		  }catch(Exception ex){
			  
			  ex.printStackTrace();
			  
		 	  
			 		
		  }
		  
		  return strReturnMsg;
		  
	  }
    public static byte[] fpmsReadInputStream(FileInputStream inputStream) throws IOException {
        int bufSize = 1024 * 1024;
        byte[] content;

        List<byte[]> parts = new LinkedList();
        InputStream in = new BufferedInputStream(inputStream);

        byte[] readBuffer = new byte[bufSize];
        byte[] part = null;
        int bytesRead = 0;
 
        while ((bytesRead = in.read(readBuffer, 0, bufSize)) != -1) {
            part = new byte[bytesRead];
            System.arraycopy(readBuffer, 0, part, 0, bytesRead);
            parts.add(part);
        } // End of while(bytesRead)

        
        int totalSize = 0;
        for (byte[] partBuffer : parts) {
            totalSize += partBuffer.length;
        }

       
        content = new byte[totalSize];
        int offset = 0;
        for (byte[] partBuffer : parts) {
     	   System.arraycopy(partBuffer, 0, content, offset, partBuffer.length);
            offset += partBuffer.length;
        }// End of for(partBuffer)

        return content;
    } // End of fpmsReadInputStream()
   
 
    
    
	
    public Vector getAssetAttachmntDetails(HttpServletRequest request)
    {
	 
    	 
		List assetAttachmntIns = new ArrayList(); 
	    List assetAttachmntUpt = new ArrayList();
	    List assetAttachmntDel = new ArrayList();
	    Vector assetAttachmntVect = new Vector();
	    
	    
	    HttpSession session=request.getSession();
	    
		HttpServletResponse response = ServletActionContext.getResponse();
		
		  Date dateCon = Calendar.getInstance().getTime();
 
		     DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		     String today = formatter.format(dateCon); 
		
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 	Date date = new Date(); 
	 	String CrtdDate =dateFormat.format(date);
	 	String MdfyDate =dateFormat.format(date);
	 	String ID="Attach00000000001"; 
		Date AsstAttachCrtdDate  = CommonUtility.convertStringToDate(CrtdDate);
		Date AsstAttachMdfyDate  = CommonUtility.convertStringToDate(MdfyDate); 
		 String myName=(String)session.getAttribute("uname");
	     String myPass=(String)session.getAttribute("upass");
	   
	 	 
	    try
	    { 
	        String[] mode = request.getParameterValues("txtFldAsstAttachmentMode")!= null ?request.getParameterValues("txtFldAsstAttachmentMode") : null;
			String[] txtFldAsstAttachmntIds =request.getParameterValues("txtFldAsstAttachmntId")!= null ?request.getParameterValues("txtFldAsstAttachmntId") : null ;
			String[] txtFldAsstAttachmntCatgrys = request.getParameterValues("txtFldAsstAttachmntCatgry")!= null ?request.getParameterValues("txtFldAsstAttachmntCatgry") : null ;
			String[] txtFldAsstDocumntTypes = request.getParameterValues("txtFldAsstDocumntType")!= null ?request.getParameterValues("txtFldAsstDocumntType") : null;
			String[] txtFldAsstAttachDocTitles = request.getParameterValues("txtFldAsstAttachDocTitle")!= null ?request.getParameterValues("txtFldAsstAttachDocTitle") : null;
			String[] txtFldAsstAttachmentRemarkss = request.getParameterValues("txtFldAsstAttachmentRemarks")!= null ?request.getParameterValues("txtFldAsstAttachmentRemarks") : null;
			String[] txtFldAsstAttachmntDates = request.getParameterValues("txtFldAsstAttachmntDate")!= null ?request.getParameterValues("txtFldAsstAttachmntDate") : null;
			//String[] txtFldAsstAttachmntFileTypes = request.getParameterValues("txtFldAsstAttachmntFileType")!= null ?request.getParameterValues("txtFldAsstAttachmntFileType") : null;
			
			String[] txtFldAsstAttachmntCrtdBys = request.getParameterValues("txtFldAsstAttachmntCrtdBy")!= null ?request.getParameterValues("txtFldAsstAttachmntCrtdBy") : null;
			String[] txtFldAsstAttachmntCrtdDates = request.getParameterValues("txtFldAsstAttachmntCrtdDate")!= null ?request.getParameterValues("txtFldAsstAttachmntCrtdDate") : null;
			String[] txtFldAsstAttachmntModifdBys = request.getParameterValues("txtFldAsstAttachmntModifdBy")!= null ?request.getParameterValues("txtFldAsstAttachmntModifdBy") : null;
			String[] txtFldAsstAttachmntModfdDates = request.getParameterValues("txtFldAsstAttachmntModfdDate")!= null ?request.getParameterValues("txtFldAsstAttachmntModfdDate") : null;
//			System.out.println("Length"+txtFldAsstAttachDocTitles.length);
			 String row=request.getParameter("asset");
			 int y = Integer.parseInt(row); 
		     int uploadedFiles = 0;
		     String orclDirName = resource.getString("asset.oracle.dirname");
//		     System.out.println("orclDirName=="+orclDirName);
		    
		     
		    
//		     System.out.println("strAtmtFileNameext=="+strAtmtFileNameext);
		     for(int eh=0;eh<y;eh++)
		     {
		        	String strAsstMode = mode[eh];
		        	String strAsstAttachmntIds = ID;
		            String strAsstAttachmntCatgrys  = txtFldAsstAttachmntCatgrys[eh]!= null? txtFldAsstAttachmntCatgrys[eh]:"";
		        	String strAsstDocumntTypes = null;
		        	
		        	String strAsstAttachDocTitles = txtFldAsstAttachDocTitles[eh];
//		        	System.out.println("strAsstFileName---"+strAsstFileName);
		        	
		        	String strAsstAttachmentRemarkss = txtFldAsstAttachmentRemarkss[eh]; 
		        	String strAsstAttachmntDates= today;
		        	//String strAsstAttachmntFileTypes = txtFldAsstAttachmntFileTypes[eh];
		        	
		        	String strAsstAttachmntCrtdBys = myName;
		        	String strAsstAttachmntCrtdDates = today;
		        	String strAsstAttachmntModifdBys = myName;
		        	String strAsstAttachmntModfdDates = today;
		        	 
				     
		        if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.INSERT_MODE))
		        {
		        	 String strFileName = getUploadFileName()[uploadedFiles]; 
//				     System.out.println("**************"+getUploadFileName().length);
				     String strAtmtFileNameext = FilenameUtils.getExtension(strFileName);
				     String strAsstFileName =strFileName!=null?strFileName:"";
				     String strAsstAttachmntFileTypes = strAtmtFileNameext;
				     
		        	byte[] filedata = null;
		        	 String retMsg ="";
		        	 
		        	  
		        	 	String strAtmtFileName = getUploadFileName()[uploadedFiles]; 
			    		String strAtmtFileType = getUploadContentType()[uploadedFiles];  
			    		String strBFILEName=strAtmtFileName;
			    		
			    		
			    		 String strDestFileNameWithPath =resource.getString("asset.attachloc");
			    	//	 System.out.println("strDestFileNameWithPath=="+strDestFileNameWithPath);
			    			 
			    		File srcFile=new File(strDestFileNameWithPath+"/"+strAtmtFileName);
			    		//System.out.println("srcFile============="+srcFile);
			    		//File srcFile=new File(strDestFileNameWithPath+strAtmtFileName);
			    		retMsg = createPhysicalFile(getUpload()[uploadedFiles], srcFile); 
			    		
			    		uploadedFiles++;
		        	 
			    		String fileSize=String.valueOf(srcFile.length());
		    		

		    		if(nullOrBlank(retMsg)){
		    			
		    			if(strAtmtFileType.length()>40){
			    			strAtmtFileType = "document/text";
			    		}
			    		 
			    		String ATTCH_INSERT_QRY = "INSERT INTO ASSET_ATTACHMENTS (ATTACHMNT_ID,ATTACHMNT_CATGRY,DOC_TYPE,FILE_NAME,DOC_TITLE,REMARKS,DOCUMENTS,ATTACHMNT_DATE,FILE_TYPE,CREATED_BY,CREATED_DATE,FILESIZE) " +
	    						" VALUES(ASSET_ATTCH_SEQ.NEXTVAL,'"+strAsstAttachmntCatgrys+"','"+strAsstDocumntTypes+"','"+strAsstFileName+"','"+strAsstAttachDocTitles+"','"+strAsstAttachmentRemarkss+"',BFILENAME('"+orclDirName+"','"+strBFILEName+"'),'"+strAsstAttachmntDates+"','"+strAsstAttachmntFileTypes+"','"+strAsstAttachmntCrtdBys+"','"+strAsstAttachmntCrtdDates+"','"+fileSize+"')";
	    		
			    		 
			    		assetAttachmntIns.add(ATTCH_INSERT_QRY);
					    		
			    	 
		    		} 
		    	}//end of if 
		        
//	            if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.UPDATE_MODE))
//	            {
//	            	String strAsstAttachmntId  = txtFldAsstAttachmntIds[eh]!= null? txtFldAsstAttachmntIds[eh]:"";
//		          
//		    	 
//		    			String ATTCH_UPDATE_QRY = "UPDATE ASSET_ATTACHMENTS SET ATTACHMNT_CATGRY='"+strAsstAttachmntCatgrys+"',DOC_TYPE='"+strAsstDocumntTypes+"',DOC_TITLE='"+strAsstAttachDocTitles+"',REMARKS='"+strAsstAttachmentRemarkss+"',ATTACHMNT_DATE='"+strAsstAttachmntDates+"',FILE_TYPE='"+strAsstAttachmntFileTypes+"',CREATED_BY='"+strAsstAttachmntCrtdBys+"',CREATED_DATE='"+strAsstAttachmntCrtdDates+"' " +
//	    						"  WHERE ATTACHMNT_ID='"+strAsstAttachmntId+"' ";
//	    		 
//			    		 assetAttachmntUpt.add(ATTCH_UPDATE_QRY);
//		    		 
//			    	 
//	            }//end  of if
	            
	            
	            if (strAsstMode.equalsIgnoreCase(com.asset.utils.Constants.DELETE_MODE)) 
	             {
	            	String strAsstAttachmntId  = txtFldAsstAttachmntIds[eh]!= null? txtFldAsstAttachmntIds[eh]:"";
			          
			    	 
	    			String ATTCH_DELETE_QRY = " DELETE FROM ASSET_ATTACHMENTS" +
    						"  WHERE ATTACHMNT_ID='"+strAsstAttachmntId+"' ";
    		  
	    			assetAttachmntDel.add(ATTCH_DELETE_QRY);
		    		  
	             }//end of if
		     
		     }//end of for
		    
		     
		     assetAttachmntVect.add(assetAttachmntIns);
		     assetAttachmntVect.add(assetAttachmntUpt);
		     assetAttachmntVect.add(assetAttachmntDel);
//		     
		   }//end of try
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }//end of catch
	    
	    return assetAttachmntVect;
	} // End of getAdvEmpmntHistDetails

    
  public String dwnlodAttachments() throws Exception{ 
	  AssetAttachmntService attachmntServ = new AssetAttachmntService();
     
    	ResultSet attachmentList =null;
    	String returnString = "";
    	
    	ActionContext ctx = ActionContext.getContext();
		HttpServletRequest fpmsrequest = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse fpmsresonse = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		HttpSession ebsess = fpmsrequest.getSession(false);
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");	
		String strAdvId = "";
		
		String strDocId = fpmsrequest.getParameter("txtFldAttachDocId");
//	 System.out.println("strDocId----"+strDocId);
		
		AssetAttachmntService attachServ = new AssetAttachmntService();
		attachmentList = attachServ.searchAttachmentById(dbDTO, strDocId); 
//        System.out.println("attachmentList===="+attachmentList);
        String attachFileName = null;
        String attachFileSize = null;
        String attachFileType = null;
        String downFileName = null;
        //Blob attachDoc = null;
        BFILE attachDoc = null;
        String filename = "";
        
        
		while (attachmentList.next()) { 
			
			attachDoc= ((OracleResultSet )attachmentList).getBFILE(1); 
		    attachFileName =  attachmentList.getString(2); 
			attachFileType = attachmentList.getString(3); 
			
//			 System.out.println("attachDoc===="+attachDoc);
//			 System.out.println("attachFileName===="+attachFileName);
//			 System.out.println("attachFileType===="+attachFileType);
		} // End of while(attachItr)
		
		 System.out.println(attachDoc.getLength());
		
		if(attachDoc.fileExists()){
			System.out.println("fileExists Condition");
             InputStream inputStream = null;
             try {
            	 downFileName=attachDoc.getName();
//            	 filename = getBFILEDirPath()+attachDoc.getName();
            	 filename = strDestDirWithPath+attachDoc.getName();
//            	 System.out.println("strDestDirWithPath-----"+strDestDirWithPath);
            	// System.out.println("filename-----"+filename);
//            	 System.out.println("filename Length===="+filename.length());
//            	 System.out.println("downFileName-----"+downFileName);
             	ServletOutputStream outStream = fpmsresonse.getOutputStream(); 
                 fpmsresonse.setContentType(attachFileType);
                 fpmsresonse.setHeader("Content-disposition","attachment;filename=" +downFileName);
                 fpmsresonse.setHeader("Cache-Control", "max-age=600"); 
                //  inputStream = new FileInputStream("/home/fpits-3/Downloads/AssetHardware (9).pdf");
                inputStream = new FileInputStream(filename);
               //  byte[] buffer = new byte[(int)new File("/home/fpits-3/Downloads/AssetHardware (9).pdf").length()];
                
                byte[] buffer = new byte[(int)new File(filename).length()];
                 int n = 0;
                 while ((n = inputStream.read(buffer)) != -1) {
                     outStream.write(buffer, 0, n); 
                 }
                 
                 inputStream.close();
                 outStream.close();
                 outStream.flush();
               
             } catch (Exception e) {
            	 e.printStackTrace();
             }    
             returnString = SUCCESS;
		}else{
			System.out.println("filenotfound Condition");
        	returnString = "filenotfound";
        }			
       	return returnString;
       
    } // End of downloadFile
    
  public static String getBFILEDirPath(){
	  
	  StringBuffer dirPath = new StringBuffer();
	  
	  try{
		  
		//  ResourceBundle resource =ResourceBundle.getBundle("com.fpms.ApplicationResources"); 
			//	  resource.getString("asset.attachloc");
				  
		  
		
	  
		  dirPath.append(resource.getString("asset.Downloc").toString() + File.separator);
		  //System.out.println("TRUE OR FALSE-->"+resource.getString("attach.bfile.desitMachine.drive").isEmpty());
		  
//		  if(!Utility.nullOrBlank(resource.getString("attach.bfile.desitMachine.drive"))){
//			  dirPath.append(resource.getString("attach.bfile.desitMachine.drive").toString() +File.separator);
//		  }
//		   
//		  dirPath.append(resource.getString("attach.bfile.desitMachine.drive.folder").toString()+File.separator);
//		  
//		  if(strModule.equalsIgnoreCase(FPMSConstants.GLBL_MODULE_CLNT)){
//			  dirPath.append(resource.getString("attach.bfile.attachscreen.clnt").toString()+File.separator);
//		  }
//		  
//		  if(strModule.equalsIgnoreCase(FPMSConstants.GLBL_MODULE_AGNT)){
//			  dirPath.append(resource.getString("attach.bfile.attachscreen.agnt").toString()+File.separator);
//		  }
//		  
//		  if(strModule.equalsIgnoreCase(FPMSConstants.GLBL_MODULE_POLICY)){
//			  dirPath.append(resource.getString("attach.bfile.attachscreen.policy").toString()+File.separator);
//		  }
		  
	  }catch(Exception ex){
	//	  fplog.info("Exception in Directory Path-->"+ex);
	  }
	 // System.out.println("dirPath------"+dirPath.toString());
	  return dirPath.toString();
	 
	  
  }
    
    
	/**
	 * @return the upload
	 */
	public File[] getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadFileName
	 */
	public String[] getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the uploadContentType
	 */
	public String[] getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
    
    

 
}//end of AssetHardwareDispatchAction
