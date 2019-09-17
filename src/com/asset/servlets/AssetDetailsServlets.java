package com.asset.servlets;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import oracle.jdbc.OracleResultSet;
import oracle.sql.BFILE;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.asset.modal.AssetHardware;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.asset.db.DBMethodsImpl;
import com.asset.modal.AssetAttachmnt;
import com.asset.modal.AssetSoftware;
import com.asset.modal.AssetVendor;
import com.asset.modal.AssetVendorServices;
import com.asset.modal.AssetVendorContacts;
import com.asset.modal.ServiceTracker;
import com.asset.service.AssetAttachmntService;
import com.asset.service.AssetHardwareService;
import com.asset.service.AssetSoftwareService;
import com.asset.service.AssetVendorService;
import com.asset.service.ServTrService;
import com.asset.utils.CommonUtility;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AssetDetailsServlets
 */

@WebServlet("/AssetDetailsServlets")
public class AssetDetailsServlets extends HttpServlet
{
	 static ResourceBundle resource = ResourceBundle.getBundle("applicationresource");
	static Logger astlog = Logger.getLogger(AssetDetailsServlets.class.getName());
	
	private static final long serialVersionUID = 1L;
    public WebApplicationContext springContext;

	@Override
	public void init(final ServletConfig config) throws ServletException
	{
		super.init(config);
		springContext = WebApplicationContextUtils.
				        getRequiredWebApplicationContext(config.getServletContext());
		final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
	 
		
		beanFactory.autowireBean(this);
	}//end of init
    
	/**
     * @see HttpServlet#HttpServlet()
     */
	
    public AssetDetailsServlets() 
    {
        super();
        // TODO Auto-generated constructor stub
    }//end of AssetDetailsServlets

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request,response);
	}//end of doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		String hActionType = request.getParameter("hActionType");
		final String EMPTY_STRING = ""; 
		final String DOWN_STR = "EXPSEARCH";
		final String DOWN_SW_STR = "EXPSWSEARCH";
		//System.out.println(hActionType);
		
		if(!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(DOWN_STR))
		 {
			//System.out.println("in");
			getAssetHardwareDwnDets(request,response); 
			return;
			
		 }//end of if
		
		if(!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(DOWN_SW_STR))
		 {
			//System.out.println("in");
			getAssetSoftwareDwnDets(request,response); 
			return;
			
		 }//end of if
		PrintWriter printWriter = response.getWriter();
	    
	    final String SRCH_STR = "SEARCH"; 
	    final String SUBHDSEARCH_STR="SUBHDSEARCH";
	    final String SWRCH_STR="SWSEARCH";
	    final String VDSRCH_STR="VDSEARCH";
	    final String SUBVDSEARCH_STR="SUBVDSEARCH";
	    final String SERV_SRCH_STR = "SERV_TRACK_SEARCH"; 
	    final String VDSERV_STR="VDSERVSEARCH";
	    final String DEL_STR = "DELETE";
	    final String SRCH_ATTACH_STR="ATTACHSEARCH";
	    
	    
	    JSONArray result = new JSONArray(); 
	    
		if(!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(SRCH_STR))
		 {
			result = getAssetHardwareSrchDets(request); 
			
		 }//end of if
		
		else if(!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(SWRCH_STR))
		 { 
			result = getAssetSoftwareSrchDets(request); 
		 }
		else if (!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(VDSRCH_STR))
		{ 
			result = getAssetVendorSrchDets(request);
		}
		else if (!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(SUBVDSEARCH_STR))
		{ 
			result = getAssetVendorSubSrchDets(request);
		}
		else if (!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(SUBHDSEARCH_STR))
		{ 
			//System.out.println("before getAssetHardwareSubSrchDets");
			result = getAssetHardwareSubSrchDets(request);
		}
		else if (!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(SRCH_ATTACH_STR))
		{ 
			result = getAssetAttachSrchDets(request);
		}else if(!(hActionType.equalsIgnoreCase(EMPTY_STRING)) && hActionType.equals(SERV_SRCH_STR))
		 {
//			System.out.println(hActionType);
			result = getServiceDetails(request);
			 
//			 System.out.println("service if condition");
			
		 }//end of if

		if(hActionType.equals("PDFVIEWER")){
			result = pdfViewerBase64(request);
		}
		
	printWriter.println(result);
	printWriter.close();
   }//end of doPost
	
	public JSONArray getAssetHardwareSrchDets(HttpServletRequest request)
	{
		JSONArray assetHardwareList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		
		try
		{
			String hardwareName  = (request.getParameter("txtFldSrchHDName") == null ?
					              "":request.getParameter("txtFldSrchHDName"));
			
			String hardwareModel = (request.getParameter("txtFldSrchHDModel") == null ?
					                "":request.getParameter("txtFldSrchHDModel"));
			
			String allotTo       = (request.getParameter("txtFldSrchHDAttotTo") == null ?
					                "":request.getParameter("txtFldSrchHDAttotTo"));
		
			
		
			  if (hardwareName.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(hardwareName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstHDName) LIKE UPPER('"+hardwareName+"')");
			}//end of if
			else
			{
				filterQry.append(hardwareName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstHDName) LIKE UPPER('"+hardwareName+"')");
			}//end of else
			
			
			if (hardwareModel.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(hardwareModel.equalsIgnoreCase(emptyStr)?"":" AND UPPER(nvl(assetHW.txtFldAsstHDModel,'%')) LIKE UPPER('"+hardwareModel+"')");
			}//end of if
			else
			{
				filterQry.append(hardwareModel.equalsIgnoreCase(emptyStr)?"":" UPPER(nvl(assetHW.txtFldAsstHDModel,'%')) LIKE UPPER('"+hardwareModel+"')");
			}//end of else
			
			
			if (allotTo.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(allotTo.equalsIgnoreCase(emptyStr)?"":" AND UPPER(nvl(assetHW.txtFldAsstHDAllotTo,'%')) LIKE UPPER('"+allotTo+"')");
			}
			else
			{
				filterQry.append(allotTo.equalsIgnoreCase(emptyStr)?"":" UPPER(nvl(assetHW.txtFldAsstHDAllotTo,'%')) LIKE UPPER('"+allotTo+"')");
			}//end of else
			
			 
			AssetHardwareService hwserv = new AssetHardwareService();
			DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetHardware> resultList = hwserv.assetHardwareDetailsSrchQry(dbDTO,filterQry.toString());
            
			if(resultList.size() > 0)
			{
				Iterator<AssetHardware> itr = resultList.iterator();
			    while(itr.hasNext())
				  {
//			    	System.out.println("Conn=======");
					  AssetHardware assetHW = (AssetHardware) itr.next();
					  
					 jsonObj.put("txtFldAsstHDId",assetHW.getTxtFldAsstHDId());
					// jsonObj.put("txtFldAsstHDAssdName",assetHW.getTxtFldAsstHDAssdName());
					 jsonObj.put("txtFldAsstHDName",(assetHW.getTxtFldAsstHDName() != null ? assetHW.getTxtFldAsstHDName():""));
					 jsonObj.put("txtFldAsstHDMake",(assetHW.getTxtFldAsstHDMake()!= null ? assetHW.getTxtFldAsstHDMake():""));
					 jsonObj.put("txtFldAsstHDModel",assetHW.getTxtFldAsstHDModel());
					 jsonObj.put("txtFldAsstHDSerlNo",assetHW.getTxtFldAsstHDSerlNo());
					 jsonObj.put("txtFldAsstHDMacId",assetHW.getTxtFldAsstHDMACId());
					 jsonObj.put("txtFldAsstHDAllotTo",assetHW.getTxtFldAsstHDAllotTo());
					 jsonObj.put("txtFldAsstHDOperSys",assetHW.getTxtFldAsstHDOperSys());
					 jsonObj.put("txtFldAsstHDOperSysver",assetHW.getTxtFldAsstHDOperSysver());
					 jsonObj.put("txtFldAsstHDProssr",assetHW.getTxtFldAsstHDProssr());
					 jsonObj.put("txtFldAsstHDProssrSpd",assetHW.getTxtFldAsstHDProssrSpd());
					 jsonObj.put("txtFldAsstHDRAM",assetHW.getTxtFldAsstHDRAM());
					 jsonObj.put("txtFldAsstHDD",assetHW.getTxtFldAsstHDD());
					 jsonObj.put("txtFldAsstHDDPartitions",assetHW.getTxtFldAsstHDDPartitions());
					 jsonObj.put("txtFldAsstHDCateg",assetHW.getTxtFldAsstHDCateg());
					 jsonObj.put("txtFldAsstHDStatus",assetHW.getTxtFldAsstHDStatus());
					 jsonObj.put("txtFldAsstHDWarrantyStatusDescription",assetHW.getTxtFldAsstHDWarrantyStatusDescription());
					 jsonObj.put("txtFldAsstHDCpuSockets",assetHW.getTxtFldAsstHDCpuSockets());
					 jsonObj.put("txtFldAsstHDTotCores",assetHW.getTxtFldAsstHDTotCores());
					 
					 jsonObj.put("txtFldAsstHDLogProcess",assetHW.getTxtFldAsstHDLogProcess());
					 jsonObj.put("txtFldAsstHDServCatg",assetHW.getTxtFldAsstHDServCatg());
					 jsonObj.put("txtFldAsstHDIPNo",assetHW.getTxtFldAsstHDIPNo());
					 jsonObj.put("txtFldAsstHDLocID",assetHW.getTxtFldAsstHDLocID());
					 jsonObj.put("txtFldAsstHDRmks",assetHW.getTxtFldAsstHDRmks());
					 jsonObj.put("txtFldAsstHDCrtdUser",assetHW.getTxtFldAsstHDCrtdUser());
					 jsonObj.put("txtFldAsstHDCrtdDate",(assetHW.getTxtFldAsstHDCrtdDate() != null ? CommonUtility.convertDateToString
							                            (assetHW.getTxtFldAsstHDCrtdDate()) : "" ) );
					 jsonObj.put("txtFldAsstHDMdfyUser",assetHW.getTxtFldAsstHDMdfyUser());
					 jsonObj.put("txtFldAsstHDMdfyDate", (assetHW.getTxtFldAsstHDMdfyDate() != null ? CommonUtility.convertDateToString
							                             (assetHW.getTxtFldAsstHDMdfyDate()) : "" ) );
					 jsonObj.put("txtFldAsstHDPartNo",assetHW.getTxtFldAsstHDPartNo());
					 jsonObj.put("txtFldAsstHDCateg",assetHW.getTxtFldAsstHDCateg());
					 jsonObj.put("txtFldAsstHDStatus",assetHW.getTxtFldAsstHDStatus());
					 jsonObj.put("txtFldAsstHDPurchaseDate",(assetHW.getTxtFldAsstHDPurchaseDate()!= null ? CommonUtility.convertDateToString
	                                                          (assetHW.getTxtFldAsstHDPurchaseDate()) : "" ) );
					 jsonObj.put("txtFldAsstHDWarrantyStartDate",(assetHW.getTxtFldAsstHDWarrantyStartDate()!= null ? CommonUtility.convertDateToString
                             (assetHW.getTxtFldAsstHDWarrantyStartDate()) : "" ));
					 jsonObj.put("txtFldAsstHDWarrantyEndDate",(assetHW.getTxtFldAsstHDWarrantyEndDate()!= null ? CommonUtility.convertDateToString
                             (assetHW.getTxtFldAsstHDWarrantyEndDate()) : "" ));
					 
				 
					 
					 assetHardwareList.add(jsonObj); 
					 
					 
					 //System.out.println("assetHardwareList==>>>"+assetHardwareList);
						
					 
				  }//end of while
			    
			}//end of if
			else
			{ 
				
		    }//end of if else
			  
		}//end of try
		
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
		
	 
    return assetHardwareList;
		
	}//end of getAssetHardwareSrchDets
	
	public void getAssetHardwareDwnDets(HttpServletRequest request,HttpServletResponse response)
	{
		JSONArray assetHardwareExportList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		
		try
		{
			String hardwareName  = (request.getParameter("txtFldSrchHDName") == null ?
					              "":request.getParameter("txtFldSrchHDName"));
			
			String hardwareModel = (request.getParameter("txtFldSrchHDModel") == null ?
					                "":request.getParameter("txtFldSrchHDModel"));
			
			String allotTo       = (request.getParameter("txtFldSrchHDAttotTo") == null ?
					                "":request.getParameter("txtFldSrchHDAttotTo"));
		
			
		
			  if (hardwareName.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(hardwareName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstHDName) LIKE UPPER('"+hardwareName+"')");
			}//end of if
			else
			{
				filterQry.append(hardwareName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstHDName) LIKE UPPER('"+hardwareName+"')");
			}//end of else
			
			
			if (hardwareModel.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(hardwareModel.equalsIgnoreCase(emptyStr)?"":" AND UPPER(nvl(assetHW.txtFldAsstHDModel,'%')) LIKE UPPER('"+hardwareModel+"')");
			}//end of if
			else
			{
				filterQry.append(hardwareModel.equalsIgnoreCase(emptyStr)?"":" UPPER(nvl(assetHW.txtFldAsstHDModel,'%')) LIKE UPPER('"+hardwareModel+"')");
			}//end of else
			
			
			if (allotTo.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(allotTo.equalsIgnoreCase(emptyStr)?"":" AND UPPER(nvl(assetHW.txtFldAsstHDAllotTo,'%')) LIKE UPPER('"+allotTo+"')");
			}
			else
			{
				filterQry.append(allotTo.equalsIgnoreCase(emptyStr)?"":" UPPER(nvl(assetHW.txtFldAsstHDAllotTo,'%')) LIKE UPPER('"+allotTo+"')");
			}//end of else
			
			 
			AssetHardwareService hwserv = new AssetHardwareService();
			DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetHardware> resultList = hwserv.assetHardwareDetailsSrchQry(dbDTO,filterQry.toString());
            
			if(resultList.size() > 0)
			{
				 
				XSSFWorkbook workbook = new XSSFWorkbook();
                  
                  //Create a blank sheet
                  XSSFSheet sheet = workbook.createSheet("Employee Data");
                  
                  Map<String, Object[]> data = new TreeMap<String, Object[]>();
                  
                  data.put("1", new Object[] {"ID", "HARDWARENAME", "HARDWAREMAKE","HARDWAREMODEL","HARDWARE SERIALNO","MAC ID","ALOTTED TO","OPERATING SYSTEM","OPERATING SYSTEM VER","PROCESSOR","PROCESSOR SPEED","RAM","HDD","HDD PARTITIONS","CATEGORY","STATUS","WARRANTY DESCRIPTION","CPU SOCKETS","CORES","LOGICAL PROCESS","LOCATION ID","REMARKS","CREATED USER","CREATED DATE","MODIFIED USER","MODIFIED DATE","PART NO","PURCHASE DATE","WARRANTY START DATE","WARRANTY END DATE"});
                  int count=2;
				Iterator<AssetHardware> itr = resultList.iterator();
			    while(itr.hasNext())
				  {

					  AssetHardware assetHW = (AssetHardware) itr.next();
//					  for(int i=0;i<resultList.size();i++)
//					  {
						  String AsstHDId= assetHW.getTxtFldAsstHDId()!= null ?  assetHW.getTxtFldAsstHDId()  : "";
						  String AsstHDName= assetHW.getTxtFldAsstHDName()!= null ?  assetHW.getTxtFldAsstHDName()  : "";
						  String txtFldAsstHDMake= assetHW.getTxtFldAsstHDMake()!= null ?  assetHW.getTxtFldAsstHDMake()  : "";
						  String txtFldAsstHDModel= assetHW.getTxtFldAsstHDModel()!= null ?  assetHW.getTxtFldAsstHDModel()  : "";
						  String txtFldAsstHDSerlNo= assetHW.getTxtFldAsstHDSerlNo()!= null ?  assetHW.getTxtFldAsstHDSerlNo()  : "";
						  String txtFldAsstHDMacId= assetHW.getTxtFldAsstHDMACId()!= null ?  assetHW.getTxtFldAsstHDMACId()  : "";
						  String txtFldAsstHDAllotTo= assetHW.getTxtFldAsstHDAllotTo()!= null ?  assetHW.getTxtFldAsstHDAllotTo()  : "";
						  String txtFldAsstHDOperSys= assetHW.getTxtFldAsstHDOperSys()!= null ?  assetHW.getTxtFldAsstHDOperSys()  : "";
						  String txtFldAsstHDOperSysver= assetHW.getTxtFldAsstHDOperSysver()!= null ?  assetHW.getTxtFldAsstHDOperSysver()  : "";
						  String txtFldAsstHDProssr= assetHW.getTxtFldAsstHDProssr()!= null ?  assetHW.getTxtFldAsstHDProssr()  : "";
						  String txtFldAsstHDProssrSpd= assetHW.getTxtFldAsstHDProssrSpd()!= null ?  assetHW.getTxtFldAsstHDProssrSpd()  : "";
						  String txtFldAsstHDRAM= assetHW.getTxtFldAsstHDRAM()!= null ?  assetHW.getTxtFldAsstHDRAM()  : "";
						  String txtFldAsstHDD= assetHW.getTxtFldAsstHDD()!= null ?  assetHW.getTxtFldAsstHDD()  : "";
						  String txtFldAsstHDDPartitions= assetHW.getTxtFldAsstHDDPartitions()!= null ?  assetHW.getTxtFldAsstHDDPartitions()  : "";
						  String txtFldAsstHDCateg= assetHW.getTxtFldAsstHDCateg()!= null ?  assetHW.getTxtFldAsstHDCateg()  : "";
						  String txtFldAsstHDStatus= assetHW.getTxtFldAsstHDStatus()!= null ?  assetHW.getTxtFldAsstHDStatus()  : "";
						  String txtFldAsstHDWarrantyStatusDescription =assetHW.getTxtFldAsstHDWarrantyStatusDescription()!= null ?  assetHW.getTxtFldAsstHDWarrantyStatusDescription()  : "";
						  
						  String txtFldAsstHDCpuSockets =assetHW.getTxtFldAsstHDCpuSockets()!= null ?  assetHW.getTxtFldAsstHDCpuSockets()  : "";
						  String txtFldAsstHDTotCores =assetHW.getTxtFldAsstHDTotCores()!= null ?  assetHW.getTxtFldAsstHDTotCores()  : ""; 
						  String txtFldAsstHDLogProcess =assetHW.getTxtFldAsstHDLogProcess()!= null ?  assetHW.getTxtFldAsstHDLogProcess()  : "";
						  String txtFldAsstHDLocID =assetHW.getTxtFldAsstHDLocID()!= null ?  assetHW.getTxtFldAsstHDLocID()  : "";
						  String txtFldAsstHDRmks =assetHW.getTxtFldAsstHDRmks()!= null ?  assetHW.getTxtFldAsstHDRmks()  : "";
						  
						  String txtFldAsstHDCrtdUser =assetHW.getTxtFldAsstHDCrtdUser()!= null ?  assetHW.getTxtFldAsstHDCrtdUser()  : "";
						  String txtFldAsstHDCrtdDate =assetHW.getTxtFldAsstHDCrtdDate()!= null ? CommonUtility.convertDateToString
		                            (assetHW.getTxtFldAsstHDCrtdDate()) : "" ;
						  String txtFldAsstHDMdfyUser =assetHW.getTxtFldAsstHDMdfyUser()!= null ?  assetHW.getTxtFldAsstHDMdfyUser()  : "";
						  String txtFldAsstHDMdfyDate =assetHW.getTxtFldAsstHDMdfyDate()!= null ? CommonUtility.convertDateToString
		                            (assetHW.getTxtFldAsstHDMdfyDate()) : "" ;
						  String txtFldAsstHDPartNo =assetHW.getTxtFldAsstHDPartNo()!= null ?  assetHW.getTxtFldAsstHDPartNo()  : "";
						  String txtFldAsstHDPurchaseDate =assetHW.getTxtFldAsstHDPurchaseDate()!= null ? CommonUtility.convertDateToString
		                            (assetHW.getTxtFldAsstHDPurchaseDate()) : "" ;
						  String txtFldAsstHDWarrantyStartDate =assetHW.getTxtFldAsstHDWarrantyStartDate()!= null ? CommonUtility.convertDateToString
		                            (assetHW.getTxtFldAsstHDWarrantyStartDate()) : "" ;
						  String txtFldAsstHDWarrantyEndDate =assetHW.getTxtFldAsstHDWarrantyEndDate()!= null ? CommonUtility.convertDateToString
		                            (assetHW.getTxtFldAsstHDWarrantyEndDate()) : "" ;
						  

		                            //Blank workbook
		                          
		                              
		                            //This data needs to be written (Object[])
		                           
		                            
		                            data.put(String.valueOf(count), new Object[] {AsstHDId, AsstHDName, txtFldAsstHDMake,txtFldAsstHDModel,txtFldAsstHDSerlNo,txtFldAsstHDMacId,txtFldAsstHDAllotTo,txtFldAsstHDOperSys,txtFldAsstHDOperSysver,txtFldAsstHDProssr,txtFldAsstHDProssrSpd,txtFldAsstHDRAM,txtFldAsstHDD,txtFldAsstHDDPartitions,txtFldAsstHDCateg,txtFldAsstHDStatus,txtFldAsstHDWarrantyStatusDescription,txtFldAsstHDCpuSockets,txtFldAsstHDTotCores,txtFldAsstHDLogProcess,txtFldAsstHDLocID,txtFldAsstHDRmks,txtFldAsstHDCrtdUser,txtFldAsstHDCrtdDate,txtFldAsstHDMdfyUser,txtFldAsstHDMdfyDate,txtFldAsstHDPartNo,txtFldAsstHDPurchaseDate,txtFldAsstHDWarrantyStartDate,txtFldAsstHDWarrantyEndDate});

		                              count++;
		                            //Iterate over data and write to sheet
		                           
				//	  }
					 
	                           
					 
				  }//end of while
			    
			    Set<String> keyset = data.keySet();
                int rownum = 0;
                for (String key : keyset)
                {
                    Row row = sheet.createRow(rownum++);
                    Object [] objArr = data.get(key);
                    int cellnum = 0;
                    for (Object obj : objArr)
                    {
                       Cell cell = row.createCell(cellnum++);
                       if(obj instanceof String)
                            cell.setCellValue((String)obj);
                        else if(obj instanceof Integer)
                            cell.setCellValue((Integer)obj);
                    }
                }
//                try
//                {
                	response.setContentType("application/vnd.ms-excel");
                	response.setHeader("Content-Disposition", "attachment; filename=AssetHardware.xls");
//                	 String strDestFileNameWithPath =resource.getString("asset.ExcelDownload");
                    //Write the workbook in file system
                 //   FileOutputStream out = new FileOutputStream(new File("/home/fpits-3/Downloads/AssetHardware.xlsx"));
//                    FileOutputStream out = new FileOutputStream(new File(strDestFileNameWithPath));
                	
                	ServletOutputStream out=response.getOutputStream();
                	
                    workbook.write(out);
                    out.flush();
                    out.close();
                    
//                    System.out.println("AssetHardware.xlsx written successfully on disk.");
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
			    
			    
			    
			}//end of if
			else
			{ 
				
		    }//end of if else
			  
		}//end of try
		
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
		 
	}//end of getAssetHardwareSrchDets
	
	
	
	public void getAssetSoftwareDwnDets(HttpServletRequest request,HttpServletResponse response)
	{
		JSONArray assetHardwareExportList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		
		try
		{
			String softwareName  = (request.getParameter("txtFldSrchSWName") == null ?
					              "":request.getParameter("txtFldSrchSWName"));
			
			String softwareLicense = (request.getParameter("txtFldSrchSWLicense") == null ?
					                "":request.getParameter("txtFldSrchSWLicense"));
			
			String softwareCateg       = (request.getParameter("txtFldSrchSWCategory") == null ?
					                "":request.getParameter("txtFldSrchSWCategory"));
		
			
		
			  if (softwareName.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(softwareName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstSWName) LIKE UPPER('"+softwareName+"')");
			}//end of if
			else
			{
				filterQry.append(softwareName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstSWName) LIKE UPPER('"+softwareName+"')");
			}//end of else
			
			
			if (softwareLicense.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(softwareLicense.equalsIgnoreCase(emptyStr)?"":" AND UPPER(nvl(assetHW.txtFldAsstSWLicenseType,'%')) LIKE UPPER('"+softwareLicense+"')");
			}//end of if
			else
			{
				filterQry.append(softwareLicense.equalsIgnoreCase(emptyStr)?"":" UPPER(nvl(assetHW.txtFldAsstSWLicenseType,'%')) LIKE UPPER('"+softwareLicense+"')");
			}//end of else
			
			
			if (softwareCateg.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(softwareCateg.equalsIgnoreCase(emptyStr)?"":" AND UPPER(nvl(assetHW.txtFldAsstSWCateg,'%')) LIKE UPPER('"+softwareCateg+"')");
			}
			else
			{
				filterQry.append(softwareCateg.equalsIgnoreCase(emptyStr)?"":" UPPER(nvl(assetHW.txtFldAsstSWCateg,'%')) LIKE UPPER('"+softwareCateg+"')");
			}//end of else
			
			 
			AssetSoftwareService hwserv = new AssetSoftwareService();
			DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetSoftware> resultList = hwserv.assetSoftwareDetailsSrchQry(dbDTO,filterQry.toString());
            
			if(resultList.size() > 0)
			{
				 
				XSSFWorkbook workbook = new XSSFWorkbook();
                  
                  //Create a blank sheet
                  XSSFSheet sheet = workbook.createSheet("Employee Data");
                  
                  Map<String, Object[]> data = new TreeMap<String, Object[]>();
                  
                  data.put("1", new Object[] {"ID", "SOFTWARE NAME", "SOFTWARE CATEGORY","SOFTWARE LICENSE TYPE","SOFTWARE LICENSE KEY","SOFTWARE STATUS","SOFTWARE REMARKS","CREATED USER","CREATED DATE","MODIFIED USER","MODIFIED DATE"});
                  int count=2;
				Iterator<AssetSoftware> itr = resultList.iterator();
			    while(itr.hasNext())
				  {

			    	AssetSoftware assetSW = (AssetSoftware) itr.next();
//					  for(int i=0;i<resultList.size();i++)
//					  {
						  String AsstSWId= assetSW.getTxtFldAsstSWId()!= null ?  assetSW.getTxtFldAsstSWId()  : "";
						  String AsstSWName= assetSW.getTxtFldAsstSWName()!= null ?  assetSW.getTxtFldAsstSWName()  : "";
						  String AsstSWCatg= assetSW.getTxtFldAsstSWCateg()!= null ?  assetSW.getTxtFldAsstSWCateg()  : "";
						  String AsstSWLicenseType= assetSW.getTxtFldAsstSWLicenseType()!= null ?  assetSW.getTxtFldAsstSWLicenseType()  : "";
						  String AsstSWLicenseKey= assetSW.getTxtFldAsstSWLicenseKey()!= null ?  assetSW.getTxtFldAsstSWLicenseKey()  : "";
						  String AsstSWStatus= assetSW.getTxtFldAsstSWStatus()!= null ?  assetSW.getTxtFldAsstSWStatus()  : "";
						  String AsstSWRmks= assetSW.getTxtFldAsstSWRmks()!= null ?  assetSW.getTxtFldAsstSWRmks()  : "";
						  String AsstSWCrtdUser= assetSW.getTxtFldAsstSWCrtdUser()!= null ?  assetSW.getTxtFldAsstSWCrtdUser()  : "";
						  String AsstSWCrtdDate =assetSW.getTxtFldAsstSWCrtdDate()!= null ? CommonUtility.convertDateToString
		                            (assetSW.getTxtFldAsstSWCrtdDate()) : "" ;
		                  String AsstSWMdfyUser= assetSW.getTxtFldAsstSWMdfyUser()!= null ?  assetSW.getTxtFldAsstSWMdfyUser()  : "";		  
		                  String AsstSWMdfyDate =assetSW.getTxtFldAsstSWMdfyDate()!= null ? CommonUtility.convertDateToString
		                            (assetSW.getTxtFldAsstSWMdfyDate()) : "" ;	  
//						  String txtFldAsstHDProssr= assetSW.getTxtFldAsstHDProssr()!= null ?  assetHW.getTxtFldAsstHDProssr()  : "";
//						  String txtFldAsstHDProssrSpd= assetSW.getTxtFldAsstHDProssrSpd()!= null ?  assetHW.getTxtFldAsstHDProssrSpd()  : "";
//						  String txtFldAsstHDRAM= assetSW.getTxtFldAsstHDRAM()!= null ?  assetHW.getTxtFldAsstHDRAM()  : "";
//						  String txtFldAsstHDD= assetSW.getTxtFldAsstHDD()!= null ?  assetHW.getTxtFldAsstHDD()  : "";
//						  String txtFldAsstHDDPartitions= assetSW.getTxtFldAsstHDDPartitions()!= null ?  assetHW.getTxtFldAsstHDDPartitions()  : "";
//						  String txtFldAsstHDCateg= assetSW.getTxtFldAsstHDCateg()!= null ?  assetHW.getTxtFldAsstHDCateg()  : "";
//						  String txtFldAsstHDStatus= assetSW.getTxtFldAsstHDStatus()!= null ?  assetHW.getTxtFldAsstHDStatus()  : "";
//						  String txtFldAsstHDWarrantyStatusDescription =assetSW.getTxtFldAsstHDWarrantyStatusDescription()!= null ?  assetHW.getTxtFldAsstHDWarrantyStatusDescription()  : "";
//						  
//						  String txtFldAsstHDCpuSockets =assetSW.getTxtFldAsstHDCpuSockets()!= null ?  assetHW.getTxtFldAsstHDCpuSockets()  : "";
//						  String txtFldAsstHDTotCores =assetSW.getTxtFldAsstHDTotCores()!= null ?  assetHW.getTxtFldAsstHDTotCores()  : ""; 
//						  String txtFldAsstHDLogProcess =assetSW.getTxtFldAsstHDLogProcess()!= null ?  assetHW.getTxtFldAsstHDLogProcess()  : "";
//						  String txtFldAsstHDLocID =assetSW.getTxtFldAsstHDLocID()!= null ?  assetHW.getTxtFldAsstHDLocID()  : "";
//						  String txtFldAsstHDRmks =assetSW.getTxtFldAsstHDRmks()!= null ?  assetHW.getTxtFldAsstHDRmks()  : "";
////						  
//						  String txtFldAsstHDCrtdUser =assetSW.getTxtFldAsstHDCrtdUser()!= null ?  assetHW.getTxtFldAsstHDCrtdUser()  : "";
//						  String txtFldAsstHDCrtdDate =assetHW.getTxtFldAsstHDCrtdDate()!= null ? CommonUtility.convertDateToString
//		                            (assetHW.getTxtFldAsstHDCrtdDate()) : "" ;
//						  String txtFldAsstHDMdfyUser =assetHW.getTxtFldAsstHDMdfyUser()!= null ?  assetHW.getTxtFldAsstHDMdfyUser()  : "";
//						  String txtFldAsstHDMdfyDate =assetHW.getTxtFldAsstHDMdfyDate()!= null ? CommonUtility.convertDateToString
//		                            (assetHW.getTxtFldAsstHDMdfyDate()) : "" ;
//						  String txtFldAsstHDPartNo =assetHW.getTxtFldAsstHDPartNo()!= null ?  assetHW.getTxtFldAsstHDPartNo()  : "";
//						  String txtFldAsstHDPurchaseDate =assetHW.getTxtFldAsstHDPurchaseDate()!= null ? CommonUtility.convertDateToString
//		                            (assetHW.getTxtFldAsstHDPurchaseDate()) : "" ;
//						  String txtFldAsstHDWarrantyStartDate =assetHW.getTxtFldAsstHDWarrantyStartDate()!= null ? CommonUtility.convertDateToString
//		                            (assetHW.getTxtFldAsstHDWarrantyStartDate()) : "" ;
//						  String txtFldAsstHDWarrantyEndDate =assetHW.getTxtFldAsstHDWarrantyEndDate()!= null ? CommonUtility.convertDateToString
//		                            (assetHW.getTxtFldAsstHDWarrantyEndDate()) : "" ;
						  

		                            //Blank workbook
		                          
		                              
		                            //This data needs to be written (Object[])
		                           
		                            
		                            data.put(String.valueOf(count), new Object[] {AsstSWId, AsstSWName, AsstSWCatg,AsstSWLicenseType,AsstSWLicenseKey,AsstSWStatus,AsstSWRmks,AsstSWCrtdUser,AsstSWCrtdDate,AsstSWMdfyUser});

		                              count++;
		                            //Iterate over data and write to sheet
		                           
				//	  }
					 
	                           
					 
				  }//end of while
			    
			    Set<String> keyset = data.keySet();
                int rownum = 0;
                for (String key : keyset)
                {
                    Row row = sheet.createRow(rownum++);
                    Object [] objArr = data.get(key);
                    int cellnum = 0;
                    for (Object obj : objArr)
                    {
                       Cell cell = row.createCell(cellnum++);
                       if(obj instanceof String)
                            cell.setCellValue((String)obj);
                        else if(obj instanceof Integer)
                            cell.setCellValue((Integer)obj);
                    }
                }
//                try
//                {
                	response.setContentType("application/vnd.ms-excel");
                	response.setHeader("Content-Disposition", "attachment; filename=AssetSoftware.xls");
//                	 String strDestFileNameWithPath =resource.getString("asset.ExcelDownload");
                    //Write the workbook in file system
                 //   FileOutputStream out = new FileOutputStream(new File("/home/fpits-3/Downloads/AssetHardware.xlsx"));
//                    FileOutputStream out = new FileOutputStream(new File(strDestFileNameWithPath));
                	
                	ServletOutputStream out=response.getOutputStream();
                	
                    workbook.write(out);
                    out.flush();
                    out.close();
                    
//                    System.out.println("AssetHardware.xlsx written successfully on disk.");
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
			    
			    
			    
			}//end of if
			else
			{ 
				
		    }//end of if else
			  
		}//end of try
		
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
		 
	}//end of getAssetHardwareSrchDets
	
   public JSONArray getAssetSoftwareSrchDets(HttpServletRequest request)
   {
		JSONArray assetSoftwareList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		try
		{
			
			String softwareName  = (request.getParameter("txtFldSrchSWName") == null ?
					                "":request.getParameter("txtFldSrchSWName"));
			String license = (request.getParameter("txtFldSrchSWLicense") == null ?
                              "":request.getParameter("txtFldSrchSWLicense"));
			String category = (request.getParameter("txtFldSrchSWCategory") == null ?
					           "":request.getParameter("txtFldSrchSWCategory"));
			 
			if (softwareName.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(softwareName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstSWName) LIKE UPPER('"+softwareName+"')");
			}//end of if 
			else
			{
				filterQry.append(softwareName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstSWName) LIKE UPPER('"+softwareName+"')");
			}//end of else
			
			
			if (license.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(license.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstSWLicenseType) LIKE UPPER('"+license+"')");
			}//end of if
			else
			{
				filterQry.append(license.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstSWLicenseType) LIKE UPPER('"+license+"')");
			}//end of else
			
			
			if (category.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(category.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstSWCateg) LIKE UPPER('"+category+"')");
			}//end of if
			else
			{
				filterQry.append(category.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstSWCateg) LIKE UPPER('"+category+"')");
			}//end of else
			
	 		
			AssetSoftwareService swserv = new AssetSoftwareService();
     		DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetSoftware> resultList = swserv.assetSoftwareDetailsSrchQry(dbDTO,filterQry.toString());

	 		if(resultList.size() > 0)
			{
	 			Iterator<AssetSoftware> itr = resultList.iterator();
			    while(itr.hasNext())
			    {  
					 AssetSoftware assetSW = (AssetSoftware) itr.next();
					  
					 jsonObj.put("txtFldAsstSWId",assetSW.getTxtFldAsstSWId());
					 jsonObj.put("txtFldAsstSWName",assetSW.getTxtFldAsstSWName());
					 jsonObj.put("txtFldAsstSWCateg",assetSW.getTxtFldAsstSWCateg());
					 jsonObj.put("txtFldAsstSWLicenseType",assetSW.getTxtFldAsstSWLicenseType());
					 jsonObj.put("txtFldAsstSWLicenseKey",assetSW.getTxtFldAsstSWLicenseKey());
					 jsonObj.put("txtFldAsstSWStatus",assetSW.getTxtFldAsstSWStatus());
					 jsonObj.put("txtFldAsstSWRmks",assetSW.getTxtFldAsstSWRmks());
					  jsonObj.put("txtFldAsstSWCrtdUser",assetSW.getTxtFldAsstSWCrtdUser());
					 jsonObj.put("txtFldAsstSWCrtdDate",(assetSW.getTxtFldAsstSWCrtdDate() != null ? CommonUtility.convertDateToString
							                            (assetSW.getTxtFldAsstSWCrtdDate()) : "" ) );
					 jsonObj.put("txtFldAsstSWMdfyUser",assetSW.getTxtFldAsstSWMdfyUser());
					 jsonObj.put("txtFldAsstSWMdfyDate", (assetSW.getTxtFldAsstSWMdfyDate() != null ? CommonUtility.convertDateToString
							                             (assetSW.getTxtFldAsstSWMdfyDate()) : "" ) );
					 assetSoftwareList.add(jsonObj);
				 
			    }//end of while
			    
			}//end of if
			else
			{ 
			}//end of else
			  
		}//end of try
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
		
		//System.out.println("assetSoftwareList----->"+assetSoftwareList);
	 return assetSoftwareList;
		
	} //end of getAssetSoftwareSrchDets

	
   public JSONArray getAssetVendorSrchDets(HttpServletRequest request)
   { 
	    
		JSONArray assetVendorList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		try
		{
			
			String vendorName  = (request.getParameter("txtFldSrchVDName") == null ?
					                "":request.getParameter("txtFldSrchVDName"));
			   
			
			if (vendorName.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(vendorName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstVDName) LIKE UPPER('"+vendorName+"')");
			}//end of if
			else
			{
				filterQry.append(vendorName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstVDName) LIKE UPPER('"+vendorName+"')");
			}//end of else
			
			
			 
			
			AssetVendorService vdserv = new AssetVendorService();
     		DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
     		
			List<AssetVendor> resultList = vdserv.assetVendorDetailsSrchQry(dbDTO,filterQry.toString());
 
			
			if(resultList.size() > 0)
			{ 
				Iterator<AssetVendor> itr = resultList.iterator();
			    while(itr.hasNext())
			    {  
			    	AssetVendor assetVD = (AssetVendor) itr.next();
					  
					 jsonObj.put("txtFldAsstVDMastrId",assetVD.getTxtFldAsstVDId());
					 jsonObj.put("txtFldAsstVDRepName",assetVD.getTxtFldAsstVDRepName());
					 jsonObj.put("txtFldAsstVDName",assetVD.getTxtFldAsstVDName());
					 jsonObj.put("txtFldAsstVDAddr1",assetVD.gettxtFldAsstVDAddr1());
					 jsonObj.put("txtFldAsstVDAddr2",assetVD.getTxtFldAsstVDAddr2());
					 jsonObj.put("txtFldAsstVDAddr3",assetVD.getTxtFldAsstVDAddr3());
					 jsonObj.put("txtFldAsstVDCity",assetVD.getTxtFldAsstVDCity());
					 jsonObj.put("txtFldAsstVDCountry",assetVD.getTxtFldAsstVDCountry());
					 jsonObj.put("txtFldAsstVDPcode",assetVD.getTxtFldAsstVDPcode());
					 jsonObj.put("txtFldAsstVDOffph",assetVD.getTxtFldAsstVDOffph());
					 jsonObj.put("txtFldAsstVDFax",assetVD.getTxtFldAsstVDFax());
					 jsonObj.put("txtFldAsstVDHp",assetVD.getTxtFldAsstVDHp());
					 jsonObj.put("txtFldAsstVDEmail",assetVD.getTxtFldAsstVDEmail());
					 jsonObj.put("txtFldAsstVDWebsite",assetVD.getTxtFldAsstVDWebsite());
					 jsonObj.put("txtFldAsstVDContacts247",assetVD.getTxtFldAsstVDContacts247());
					  
					 jsonObj.put("txtFldAsstVDRemarks",assetVD.getTxtFldAsstVDRemarks());
					 jsonObj.put("txtFldAsstVDCrtdUserId",assetVD.getTxtFldAsstVDCrtdUserId());
					  
					 jsonObj.put("txtFldAsstVDCrtdDate",(assetVD.getTxtFldAsstVDCrtdDate() != null ? CommonUtility.convertDateToString
							                            (assetVD.getTxtFldAsstVDCrtdDate()) : "" ) );
					 jsonObj.put("txtFldAsstVDMdfyUser",assetVD.getTxtFldAsstVDMdfyUser());
					 jsonObj.put("txtFldAsstVDMdfyDate", (assetVD.getTxtFldAsstVDMdfyDate() != null ? CommonUtility.convertDateToString
							                             (assetVD.getTxtFldAsstVDMdfyDate()) : "" ) );
					 assetVendorList.add(jsonObj);
				 
			    }//end of while
			    
			}//end of if
			else
			{ 
			}//end of else
			  
		}//end of try
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
		 
	 return assetVendorList;
		
	} //end of getAssetVendorSrchDets
   
   public JSONArray getAssetVendorSubSrchDets(HttpServletRequest request)
   { 
	    
		JSONArray allTabList = new JSONArray();
		
		JSONObject jsonObj = new JSONObject();
		JSONObject tabDatajsonObj = new JSONObject();
		
		
		JSONObject vendorServiceDate =  new JSONObject();
		JSONObject vendorContactDate =  new JSONObject();
		
		
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		try
		{
			
			String VendorIdDetails  = (request.getParameter("txtFldAsstVDMastrId") == null ?
					                "":request.getParameter("txtFldAsstVDMastrId"));
			   
			//System.out.println("VendorIdDetails----->"+VendorIdDetails);  
			if (VendorIdDetails.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(VendorIdDetails.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstVDId) LIKE UPPER('"+VendorIdDetails+"')");
			}//end of if
			else
			{
				filterQry.append(VendorIdDetails.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstVDId) LIKE UPPER('"+VendorIdDetails+"')");
			}//end of else
			
			 
			AssetVendorService vdserv = new AssetVendorService();
     		DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetVendor> resultList = vdserv.assetVendorDetailsSubSrchQry(dbDTO,filterQry.toString());
			 
			
			if(resultList.size() > 0)
			{ 
				Iterator<AssetVendor> itr = resultList.iterator();
			    while(itr.hasNext())
			    {  
			    	AssetVendor assetVD = (AssetVendor) itr.next();
					  
					 jsonObj.put("txtFldServiceVendrId",assetVD.getTxtFldAsstVDId());
					 jsonObj.put("txtFldServiceVendrRep",assetVD.getTxtFldAsstVDRepName());
					 jsonObj.put("txtFldAsstVDServiceName",assetVD.getTxtFldAsstVDName());
					 jsonObj.put("txtFldAsstVDServiceAddr1",assetVD.gettxtFldAsstVDAddr1());
					 jsonObj.put("txtFldAsstVDServiceAddr2",assetVD.getTxtFldAsstVDAddr2());
					 jsonObj.put("txtFldAsstVDServiceAddr3",assetVD.getTxtFldAsstVDAddr3());
					 jsonObj.put("txtFldAsstVDServiceCity",assetVD.getTxtFldAsstVDCity());
					 jsonObj.put("txtFldAsstVDServiceCountry",assetVD.getTxtFldAsstVDCountry());
					 jsonObj.put("txtFldAsstVDServicePcode",assetVD.getTxtFldAsstVDPcode()); 
					 jsonObj.put("txtFldAsstVDServiceFax",assetVD.getTxtFldAsstVDFax()); 
					 jsonObj.put("txtFldAsstVDServiceEmail",assetVD.getTxtFldAsstVDEmail());
					 jsonObj.put("txtFldAsstVDServiceWebsite",assetVD.getTxtFldAsstVDWebsite()); 
					 jsonObj.put("txtFldAsstVDServiceRemarks",assetVD.getTxtFldAsstVDRemarks()); 

				 
			    }//end of while
			    
			    
			    tabDatajsonObj.put("MASTER_VENDOR_DETAILS", jsonObj);
			    
			}//end of if
			else
			{
				 
			}//end of else
			  
		}//end of try
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
 
		vendorServiceDate = getAssetVendorServiceSrchDets(request);
		vendorContactDate = getAssetVendorContactSrchDets(request);
		
		allTabList.add(tabDatajsonObj);  
        allTabList.add(vendorServiceDate); 
        allTabList.add(vendorContactDate);
		 
		return allTabList;
	
		
	}// end of getAssetVendorSubSrchDets
  
   public JSONArray getAssetHardwareSubSrchDets(HttpServletRequest request)
   { 
	//	System.out.println("insdie getAssetHardwareSubSrchDets");
		JSONArray allTabList = new JSONArray();
		
		JSONObject jsonObj = new JSONObject();
		JSONObject tabDatajsonObj = new JSONObject();
		
		
		JSONObject vendorServiceDate =  new JSONObject();
		JSONObject vendorContactDate =  new JSONObject();
		
		
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		try
		{
			
			String VendorIdDetails  = (request.getParameter("aa") == null ?
					                "":request.getParameter("aa"));
		//	System.out.println("VendorIdDetails----->"+VendorIdDetails);   
			
		 
				filterQry.append(VendorIdDetails.equalsIgnoreCase(emptyStr)?"":" assetHW.txtFldAsstHDId = '"+VendorIdDetails+"'");
			 
			 
			
			AssetHardwareService hwserv = new AssetHardwareService();
			DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetHardware> resultList = hwserv.assetHardwareDetailsSubSrchQry(dbDTO,filterQry.toString());
			
			
//			AssetVendorService vdserv = new AssetVendorService();
//        	DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
//			List<AssetVendor> resultList = vdserv.assetVendorDetailsSubSrchQry(dbDTO,filterQry.toString());
			 
			
			if(resultList.size() > 0)
			{ 
				Iterator<AssetHardware> itr = resultList.iterator();
			    while(itr.hasNext())
			    {  
			    	AssetHardware assetHW = (AssetHardware) itr.next();
					  
			    	
			    	
//			    	 jsonObj.put("txtFldAsstHDId",setStringValue(assetHW.getTxtFldAsstHDId()));
			    	 //jsonObj.put("txtFldAsstHDName",(assetHW.getTxtFldAsstHDName() != null ? assetHW.getTxtFldAsstHDName():""));
//					 jsonObj.put("txtFldAsstHDAssdName",assetHW.getTxtFldAsstHDAssdName());
					 jsonObj.put("txtFldAsstHDFrmName",setStringValue(assetHW.getTxtFldAsstHDName()));
					 jsonObj.put("txtFldAsstHDFrmMake",setStringValue(assetHW.getTxtFldAsstHDMake()));
					 jsonObj.put("txtFldAsstHDFrmModel",setStringValue(assetHW.getTxtFldAsstHDModel()));
					 jsonObj.put("txtFldAsstHDFrmSerlNo",setStringValue(assetHW.getTxtFldAsstHDSerlNo()));
					 jsonObj.put("txtFldAsstHDFrmMACId",setStringValue(assetHW.getTxtFldAsstHDMACId()));
					 jsonObj.put("txtFldAsstHDFrmProssr",setStringValue(assetHW.getTxtFldAsstHDProssr()));
					 jsonObj.put("txtFldAsstHDFrmAllotTo",setStringValue(assetHW.getTxtFldAsstHDAllotTo()));
					 jsonObj.put("txtFldAsstHDFrmOperSys",setStringValue(assetHW.getTxtFldAsstHDOperSys()));
				
					 jsonObj.put("txtFldAsstHDFrmOperSysver",setStringValue(assetHW.getTxtFldAsstHDOperSysver()));
					
					 jsonObj.put("txtFldAsstHDFrmProssrSpd",setStringValue(assetHW.getTxtFldAsstHDProssrSpd()));
					 jsonObj.put("txtFldAsstHDFrmRAM",setStringValue(assetHW.getTxtFldAsstHDRAM()));
					 jsonObj.put("txtFldAsstHDFrmHDD",setStringValue(assetHW.getTxtFldAsstHDD()));
					 jsonObj.put("txtFldAsstHDFrmHDDPartitions",setStringValue(assetHW.getTxtFldAsstHDDPartitions()));
					 jsonObj.put("txtFldAsstHDFrmWarrantyStatusDescription",setStringValue(assetHW.getTxtFldAsstHDWarrantyStatusDescription()));
					 jsonObj.put("txtFldAsstHDFrmCpuSockets",setStringValue(assetHW.getTxtFldAsstHDCpuSockets()));
					 jsonObj.put("txtFldAsstHDFrmTotCores",setStringValue(assetHW.getTxtFldAsstHDTotCores()));
					 jsonObj.put("txtFldAsstHDFrmLogProcess",setStringValue(assetHW.getTxtFldAsstHDLogProcess()));
					 jsonObj.put("txtFldAsstHDFrmPartNo",setStringValue(assetHW.getTxtFldAsstHDPartNo()));
					 jsonObj.put("txtFldAsstHDFrmCateg",setStringValue(assetHW.getTxtFldAsstHDCateg()));
					 jsonObj.put("txtFldAsstHDFrmStatus",setStringValue(assetHW.getTxtFldAsstHDStatus()));
					 jsonObj.put("txtFldAsstHDFrmLocID",setStringValue(assetHW.getTxtFldAsstHDLocID()));
					 jsonObj.put("txtFldAsstHDFrmRmks",setStringValue(assetHW.getTxtFldAsstHDRmks()));
					 jsonObj.put("txtFldAsstHDFrmServCateg",assetHW.getTxtFldAsstHDServCatg());
					 jsonObj.put("txtFldAsstHDFrmIP",assetHW.getTxtFldAsstHDIPNo());
//					 jsonObj.put("txtFldAsstHDCrtdUser",setStringValue(assetHW.getTxtFldAsstHDCrtdUser()));
//					 jsonObj.put("txtFldAsstHDCrtdDate",(assetHW.getTxtFldAsstHDCrtdDate() != null ? CommonUtility.convertDateToString
//							                            (assetHW.getTxtFldAsstHDCrtdDate()) : "" ) );
//					 jsonObj.put("txtFldAsstHDMdfyUser",assetHW.getTxtFldAsstHDMdfyUser());
//					 jsonObj.put("txtFldAsstHDMdfyDate", (assetHW.getTxtFldAsstHDMdfyDate() != null ? CommonUtility.convertDateToString
//							                             (assetHW.getTxtFldAsstHDMdfyDate()) : "" ) );
//					 
					 jsonObj.put("txtFldAsstHDFrmPurchaseDate",(assetHW.getTxtFldAsstHDPurchaseDate()!= null ? CommonUtility.convertDateToString
	                                                          (assetHW.getTxtFldAsstHDPurchaseDate()) : "" ) );
					 jsonObj.put("txtFldAsstHDFrmWarrantyStartDate",(assetHW.getTxtFldAsstHDWarrantyStartDate()!= null ? CommonUtility.convertDateToString
                            (assetHW.getTxtFldAsstHDWarrantyStartDate()) : "" ));
			
					 jsonObj.put("txtFldAsstHDFrmWarrantyEndDate",(assetHW.getTxtFldAsstHDWarrantyEndDate()!= null ? CommonUtility.convertDateToString
                            (assetHW.getTxtFldAsstHDWarrantyEndDate()) : "" ));
					
					// assetHardwareList.add(jsonObj); 
					 
					 
//					 jsonObj.put("txtFldServiceVendrId",assetHD.getTxtFldAsstVDId());
//					 jsonObj.put("txtFldServiceVendrRep",assetVD.getTxtFldAsstVDRepName());
//					 jsonObj.put("txtFldAsstVDServiceName",assetVD.getTxtFldAsstVDName());
//					 jsonObj.put("txtFldAsstVDServiceAddr1",assetVD.gettxtFldAsstVDAddr1());
//					 jsonObj.put("txtFldAsstVDServiceAddr2",assetVD.getTxtFldAsstVDAddr2());
//					 jsonObj.put("txtFldAsstVDServiceAddr3",assetVD.getTxtFldAsstVDAddr3());
//					 jsonObj.put("txtFldAsstVDServiceCity",assetVD.getTxtFldAsstVDCity());
//					 jsonObj.put("txtFldAsstVDServiceCountry",assetVD.getTxtFldAsstVDCountry());
//					 jsonObj.put("txtFldAsstVDServicePcode",assetVD.getTxtFldAsstVDPcode()); 
//					 jsonObj.put("txtFldAsstVDServiceFax",assetVD.getTxtFldAsstVDFax()); 
//					 jsonObj.put("txtFldAsstVDServiceEmail",assetVD.getTxtFldAsstVDEmail());
//					 jsonObj.put("txtFldAsstVDServiceWebsite",assetVD.getTxtFldAsstVDWebsite()); 
//					 jsonObj.put("txtFldAsstVDServiceRemarks",assetVD.getTxtFldAsstVDRemarks()); 

				 
			    }//end of while
			    
			    tabDatajsonObj.put("MASTER_HARDWARE_DETAILS", jsonObj);
			    
			}//end of if
			else
			{
				 
			}//end of else
			  
		}//end of try
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
 
//		vendorServiceDate = getAssetVendorServiceSrchDets(request);
//		vendorContactDate = getAssetVendorContactSrchDets(request);
		
		allTabList.add(tabDatajsonObj);  
//        allTabList.add(vendorServiceDate); 
//        allTabList.add(vendorContactDate);
		 
		return allTabList;
	
		
	}// end of getAssetVendorSubSrchDets
   
   public JSONObject getAssetVendorServiceSrchDets(HttpServletRequest request)
   {
	    
	    
		JSONObject assetVendorList = new JSONObject();
		JSONObject tabDatajsonObj = new JSONObject();
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		try
		{
			String VendorIdDetails  = (request.getParameter("txtFldAsstVDMastrId") == null ?
					                "":request.getParameter("txtFldAsstVDMastrId"));
			   
			if (VendorIdDetails.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(VendorIdDetails.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstVDVendrId) LIKE UPPER('"+VendorIdDetails+"')");
			}//end of if
			else
			{
				filterQry.append(VendorIdDetails.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstVDVendrId) LIKE UPPER('"+VendorIdDetails+"')");
			}//end of else
			
			
			 
			AssetVendorService vdserv = new AssetVendorService();
     		DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetVendorServices> resultList = vdserv.assetVendorServiceDetailsSrchQry(dbDTO,filterQry.toString());
 
			
			if(resultList.size() >0)
			{ 
				Iterator<AssetVendorServices> itr = resultList.iterator();
			    while(itr.hasNext())
			    {  
			    	AssetVendorServices assetVD = (AssetVendorServices) itr.next();
					  
					 jsonObj.put("txtFldAsstVDSerId",assetVD.getTxtFldAsstVDSerId());
					 jsonObj.put("txtFldAsstVDServenId",assetVD.getTxtFldAsstVDVendrId());
					 jsonObj.put("txtFldAsstVDAssetId",assetVD.getTxtFldAsstVDAssetId());
					 jsonObj.put("txtFldAsstVDSerTyp",assetVD.getTxtFldAsstVDSerTyp());
					 jsonObj.put("txtFldAsstVDRenwlAmt",assetVD.getTxtFldAsstVDRenwlAmt());
					 jsonObj.put("txtFldAsstVDPrdtDescp",assetVD.getTxtFldAsstVDPrdtDescp());
					 jsonObj.put("txtFldAsstVDPurhDate",assetVD.getTxtFldAsstVDPurhDate() != null ? CommonUtility.convertDateToString
                             (assetVD.getTxtFldAsstVDPurhDate()) : "");
					 jsonObj.put("txtFldAsstVDStrtDate",assetVD.getTxtFldAsstVDStrtDate()!= null ? CommonUtility.convertDateToString
                             (assetVD.getTxtFldAsstVDStrtDate()) : "");
					 jsonObj.put("txtFldAsstVDEndDate",assetVD.getTxtFldAsstVDEndDate()!= null ? CommonUtility.convertDateToString
                             (assetVD.getTxtFldAsstVDEndDate()) : "");
					 jsonObj.put("txtFldAsstVDVldPeriod",assetVD.getTxtFldAsstVDVldPeriod());
					 jsonObj.put("txtFldAsstVDRmks",assetVD.getTxtFldAsstVDRmks());
					 jsonObj.put("txtFldAsstVDServStatus",assetVD.getTxtFldAsstVDServStatus());
					 jsonObj.put("txtFldAsstVDStatus",assetVD.getTxtFldAsstVDStatus());
					 jsonObj.put("txtFldAsstVDProduct",assetVD.getTxtFldAsstVDProduct());
					 jsonObj.put("txtFldAsstVDSubProduct",assetVD.getTxtFldAsstVDSubProduct());
					 jsonObj.put("txtFldAsstVDCrUsrId",assetVD.getTxtFldAsstVDCrUsrId());
					 jsonObj.put("txtFldAsstVDCrDate",(assetVD.getTxtFldAsstVDCrDate() != null ? CommonUtility.convertDateToString
	                                                    (assetVD.getTxtFldAsstVDCrDate()) : "" ) );
					 jsonObj.put("txtFldAsstVDMdfyUser",assetVD.getTxtFldAsstVDMdfyUser());
					 jsonObj.put("txtFldAsstVDMdfyDate",(assetVD.getTxtFldAsstVDMdfyDate() != null ? CommonUtility.convertDateToString
							                            (assetVD.getTxtFldAsstVDMdfyDate()) : "" ) );
					 
					 
					 jsonArray.add(jsonObj);
					  
				 
			    }//end of while
			    
			}//end of if
			else
			{ 
				
			}//end of else
			
			
			
			tabDatajsonObj.put("VENDOR_SERVICES_DETAILS", jsonArray); 

		}//end of try
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
	 
	 return tabDatajsonObj;
		
	} // end of getAssetVendorServiceSrchDets
   
   public JSONObject getAssetVendorContactSrchDets(HttpServletRequest request)
   {
	    
		JSONObject assetVendorList = new JSONObject();
		JSONObject tabDatajsonObj = new JSONObject();
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
        StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		try
		{
			

			String VendorIdDetails  = (request.getParameter("txtFldAsstVDMastrId") == null ?
					                "":request.getParameter("txtFldAsstVDMastrId"));
			   
			
			if (VendorIdDetails.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(VendorIdDetails.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstVDVendrId) LIKE UPPER('"+VendorIdDetails+"')");
			}//end of if
			else
			{
				filterQry.append(VendorIdDetails.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstVDVendrId) LIKE UPPER('"+VendorIdDetails+"')");
			}//end of else
			
			
			 
			
			AssetVendorService vdserv = new AssetVendorService();
     		DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetVendorContacts> resultList = vdserv.assetVendorContactsDetailsSrchQry(dbDTO,filterQry.toString());
 
			
			if(resultList.size() >0)
			{ 
				Iterator<AssetVendorContacts> itr = resultList.iterator();
			    while(itr.hasNext())
			    {  
			    	AssetVendorContacts assetVD = (AssetVendorContacts) itr.next();
					  
					 jsonObj.put("txtFldAsstVDContId",assetVD.getTxtFldAsstVDContId());
					 jsonObj.put("txtFldAsstVDContVendrId",assetVD.getTxtFldAsstVDVendrId());
					 jsonObj.put("txtFldAsstVDCont247",assetVD.getTxtFldAsstVDCont247());
					 jsonObj.put("txtFldAsstVDContKeyPernme",assetVD.getTxtFldAsstVDKeyPernme());
					 jsonObj.put("txtFldAsstVDContDesgntn",assetVD.getTxtFldAsstVDDesgntn());
					 jsonObj.put("txtFldAsstVDContMoble",assetVD.getTxtFldAsstVDMoble());
					 jsonObj.put("txtFldAsstVDContVendrOffPerNo",assetVD.getTxtFldAsstVDVendrOffPerNo());
					 jsonObj.put("txtFldAsstVDContRmks",assetVD.getTxtFldAsstVDRmks());
					 jsonObj.put("txtFldAsstVDContCrUsrId",assetVD.getTxtFldAsstVDCrUsrId());
					 
					 jsonObj.put("txtFldAsstVDContCrDate",(assetVD.getTxtFldAsstVDCrDate() != null ? CommonUtility.convertDateToString
                             (assetVD.getTxtFldAsstVDCrDate()) : "" ) );
					 jsonObj.put("txtFldAsstVDContMdfyUsrId",assetVD.getTxtFldAsstVDMdfyUsrId());
					 jsonObj.put("txtFldAsstVDContMdfyDate",(assetVD.getTxtFldAsstVDMdfyDate() != null ? CommonUtility.convertDateToString
	                            (assetVD.getTxtFldAsstVDMdfyDate()) : "" ) );


				 
					 
					 jsonArray.add(jsonObj);
					  
			    }//end of while
			    
			}//end of if
			else
			{ 
				
			}//end of else
			
			tabDatajsonObj.put("VENDOR_CONTACT_DETAILS", jsonArray); 
           }//end of try
		
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
	 
	 return tabDatajsonObj;
		
	} // end of getAssetVendorContactSrchDets
   public JSONArray getAssetAttachSrchDets(HttpServletRequest request)
	{
		JSONArray assetAttachList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
       StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		String strDate ="";
		 
		try
		{
			String AtmntDate  = (request.getParameter("txtFldAttachmntDate") == null ?
					              "":request.getParameter("txtFldAttachmntDate"));
			
			if (AtmntDate=="") {
				//System.out.println("AtmntDate=="+AtmntDate);
			}
			else {
				//sDate1=AtmntDate;  
			    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(AtmntDate);  
			   // System.out.println("date1"+"--"+date1);  
				//Date date = Calendar.getInstance().getTime();  
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");  
				 strDate = dateFormat.format(date1); 
				 AtmntDate = strDate;
				  //System.out.println("strDate"+"--"+strDate); 
			}
		
			
			String AtmntCatgy = (request.getParameter("txtFldAttachmntCatgry") == null ?
					                "":request.getParameter("txtFldAttachmntCatgry"));
			
			String AtmntDocType       = (request.getParameter("txtFldDocType") == null ?
					                "":request.getParameter("txtFldDocType"));
			// System.out.println("AtmntDate--"+AtmntDate);
			
			if (AtmntDate.trim().length()>0)
			if(filterQry.length() >0)
			{
				
				filterQry.append(AtmntDate.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstAttachmntDate) LIKE UPPER('"+AtmntDate+"')");
			}//end of if
			else
			{
				
				filterQry.append(AtmntDate.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstAttachmntDate) LIKE UPPER('"+AtmntDate+"')");
			}//end of else
			
			
			if (AtmntCatgy.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(AtmntCatgy.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstAttachmntCatgry) LIKE UPPER('"+AtmntCatgy+"')");
			}//end of if
			else
			{
				filterQry.append(AtmntCatgy.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstAttachmntCatgry) LIKE UPPER('"+AtmntCatgy+"')");
			}//end of else
			
			
			if (AtmntDocType.trim().length()>0)
			if(filterQry.length() >0)
			{
				filterQry.append(AtmntDocType.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldAsstAttachDocTitle) LIKE UPPER('"+AtmntDocType+"')");
			}
			else
			{
				filterQry.append(AtmntDocType.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldAsstAttachDocTitle) LIKE UPPER('"+AtmntDocType+"')");
			}//end of else
			
			 
			AssetAttachmntService attachserv = new AssetAttachmntService();
			DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
			List<AssetAttachmnt> resultList = attachserv.assetAttachmentDetailsSrchQry(dbDTO,filterQry.toString());
           
			if(resultList.size() > 0)
			{
				Iterator<AssetAttachmnt> itr = resultList.iterator();
			    while(itr.hasNext())
				  {
			    	AssetAttachmnt assetAttachmnt = (AssetAttachmnt) itr.next();
			        	jsonObj.put("txtFldAsstAttachmntId",assetAttachmnt.getTxtFldAsstAttachmntId());
					 jsonObj.put("txtFldAsstAttachmntCatgry",assetAttachmnt.getTxtFldAsstAttachmntCatgry()); 
					 jsonObj.put("txtFldAsstDocumntType",assetAttachmnt.getTxtFldAsstDocumntType());
					 jsonObj.put("txtFldAsstAttachDocTitle",assetAttachmnt.getTxtFldAsstAttachDocTitle());
					 jsonObj.put("txtFldAsstAttachFileName",assetAttachmnt.getTxtFldAsstAttachFileName());
					 jsonObj.put("txtFldAsstAttachmentRemarks",assetAttachmnt.getTxtFldAsstAttachmentRemarks());
					 
					 jsonObj.put("txtFldAsstAttachmntDate",(assetAttachmnt.getTxtFldAsstAttachmntDate()!= null ? CommonUtility.convertDateToString
	                            (assetAttachmnt.getTxtFldAsstAttachmntDate()) : "" ) );
					 jsonObj.put("txtFldAsstAttachmntFileType",assetAttachmnt.getTxtFldAsstAttachmntFileType()); 
					 jsonObj.put("txtFldAsstAttachmntCrtdBy",assetAttachmnt.getTxtFldAsstAttachmntCrtdBy());
					 jsonObj.put("txtFldAsstAttachmntCrtdDate",(assetAttachmnt.getTxtFldAsstAttachmntCrtdDate() != null ? CommonUtility.convertDateToString
							                            (assetAttachmnt.getTxtFldAsstAttachmntCrtdDate()) : "" ) );
					 jsonObj.put("txtFldAsstAttachmntModifdBy",assetAttachmnt.getTxtFldAsstAttachmntModifdBy());
					 jsonObj.put("txtFldAsstAttachmntModfdDate", (assetAttachmnt.getTxtFldAsstAttachmntModfdDate() != null ? CommonUtility.convertDateToString
							                             (assetAttachmnt.getTxtFldAsstAttachmntModfdDate()) : "" ) );
					
					 assetAttachList.add(jsonObj); 
				  }//end of while
			    
			}//end of if
			else
			{ 
		    }//end of if else
			  
		}//end of try
		
		catch(Exception exp)
		{
			exp.printStackTrace();
		}//end of catch
		 
   return assetAttachList;
		
	}//end of getAssetHardwareSrchDets
	
   

	private JSONArray getServiceDetails(HttpServletRequest request) {
		// TODO Auto-generated method stub
		JSONArray servDetList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
       StringBuffer filterQry = new StringBuffer();
		String emptyStr = "";
		try{
			String HardwareName  = (request.getParameter("txtFldSrchHWName") == null ?
					                "":request.getParameter("txtFldSrchHWName"));
			String SoftwareName = (request.getParameter("txtFldSrchSWName") == null ?
                             "":request.getParameter("txtFldSrchSWName"));
			String VendorName = (request.getParameter("txtFldSrchVDName") == null ?
					           "":request.getParameter("txtFldSrchVDName"));
			  
//			System.out.println("Hardware Name----->"+HardwareName);
//			System.out.println("Software Name----->"+SoftwareName);
//			System.out.println("Vendor Name----->"+VendorName);
			
			if (HardwareName.trim().length()>0)
				if(filterQry.length() >0)
				{
					filterQry.append(HardwareName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldHDID) LIKE UPPER('"+HardwareName+"')");
				}//end of if
				else
				{
					filterQry.append(HardwareName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldHDID) LIKE UPPER('"+HardwareName+"')");
				}//end of else
				
			if (SoftwareName.trim().length()>0)
				if(filterQry.length() >0)
				{
					filterQry.append(SoftwareName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldSWID) LIKE UPPER('"+SoftwareName+"')");
				}//end of if
				else
				{
					filterQry.append(SoftwareName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldSWID) LIKE UPPER('"+SoftwareName+"')");
				}//end of else
			
			if (VendorName.trim().length()>0)
				if(filterQry.length() >0)
				{
					filterQry.append(VendorName.equalsIgnoreCase(emptyStr)?"":" AND UPPER(assetHW.txtFldVDID) LIKE UPPER('"+VendorName+"')");
				}//end of if
				else
				{
					filterQry.append(VendorName.equalsIgnoreCase(emptyStr)?"":" UPPER(assetHW.txtFldVDID) LIKE UPPER('"+VendorName+"')");
				}//end of else
				
//			System.out.println(filterQry.toString());
		
			ServTrService srvserv = new ServTrService();
		DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
		List<ServiceTracker> resultList = srvserv.assetServTRSrchQry(dbDTO,filterQry.toString());
 
		
		if(resultList.size() > 0)
		{
//			System.out.println("if condition resultList");
			Iterator<ServiceTracker> itr = resultList.iterator();
		    while(itr.hasNext())
		    {  
				 ServiceTracker assetSTR = (ServiceTracker) itr.next();
				  
				 jsonObj.put("txtFldServiceId",assetSTR.getTxtFldServiceId());
				 jsonObj.put("txtFldHDID",assetSTR.getTxtFldHDID());
				 jsonObj.put("txtFldSWID",assetSTR.getTxtFldSWID());
				 jsonObj.put("txtFldVDID",assetSTR.getTxtFldVDID());
				 jsonObj.put("txtFldServiceRequest",assetSTR.getTxtFldServiceRequest());
				 jsonObj.put("txtFldServiceDate",(assetSTR.getTxtFldServiceDate() != null ? CommonUtility.convertDateToString
                        (assetSTR.getTxtFldServiceDate()) : "" ) );
                jsonObj.put("txtFldRemarks",assetSTR.getTxtFldRemarks());
				 jsonObj.put("txtFldServiceCrtdUser",assetSTR.getTxtFldServiceCrtdUser());
				 jsonObj.put("txtFldServiceCrtdDate",(assetSTR.getTxtFldServiceCrtdDate() != null ? CommonUtility.convertDateToString
						                            (assetSTR.getTxtFldServiceCrtdDate()) : "" ) );
				 jsonObj.put("txtFldServiceMdfyUser",assetSTR.getTxtFldServiceMdfyUser());
				 jsonObj.put("txtFldServicedMdfyDate", (assetSTR.getTxtFldServicedMdfyDate() != null ? CommonUtility.convertDateToString
						                             (assetSTR.getTxtFldServicedMdfyDate()) : "" ) );
				 servDetList.add(jsonObj);
			 
		    }//end of while
		    
		}//end of if
		else
		{ 
			jsonObj.put("NO_RECORDS_FOUND", "No Record(s) Found!");
			servDetList.add(jsonObj);
		}//end of else
		  
	}//end of try
	catch(Exception e)
	{
		e.printStackTrace();
	}//end of catch
	
	 
return servDetList;
	
} //end of getServiceTrackerSrchDets
	public static String setStringValue(String str) {
	    
		String strRtrnVal=""; 
		
		if(str != null && !str.isEmpty())
			strRtrnVal=str;       
	    
		return strRtrnVal;
	}
   
	
	private JSONArray pdfViewerBase64(HttpServletRequest request){
		JSONArray retrnAry=new JSONArray();
		
		JSONObject jsnObj=new JSONObject();
		
//		File file=new File("/home/kaviyarasu/Downloads/fna v3.9 - simplified(updated).pdf");
		
//		Start
		AssetAttachmntService attachmntServ = new AssetAttachmntService();
	    
		try {
		
    	ResultSet attachmentList =null;
    	String returnString = "";
    	
    	
//    	ActionContext ctx = ActionContext.getContext();
//		HttpServletRequest fpmsrequest = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
//		HttpServletResponse fpmsresonse = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
//		HttpSession ebsess = fpmsrequest.getSession(false);
    	ServletContext ctx = getServletContext();
    	
    	WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
		DBMethodsImpl dbDTO = (DBMethodsImpl) context.getBean("dbmethodbean");
    	
//    	DBMethodsImpl dbDTO = (DBMethodsImpl) springContext.getBean("dbmethodbean");
    	
		String strAdvId = "";
		
		String strDocId = request.getParameter("txtFldAttachDocId");
		
		AssetAttachmntService attachServ = new AssetAttachmntService();
		attachmentList = attachServ.searchassetAttachmentByIds(dbDTO, strDocId,context); 
		
        String attachFileName = null;
        String attachFileSize = null;
        String attachFileType = null;
        String downFileName = null;
        //Blob attachDoc = null;
        BFILE attachDoc = null;
        String filename = "";
//        String strBase64="";
        
		while (attachmentList.next()) { 
			
			attachDoc= ((OracleResultSet )attachmentList).getBFILE(1); 
		    attachFileName =  attachmentList.getString(2); 
			attachFileType = attachmentList.getString(3); 
			
			
		} // End of while(attachItr)
		
		
	
		 
		if(attachDoc.fileExists()){
			
			String strDestDirWithPath =resource.getString("asset.attachloc");
			
             
            
            	FileInputStream inputStream = null;
            	 
            	 downFileName=attachDoc.getName();
//            	 filename = getBFILEDirPath()+attachDoc.getName();
            	 filename = strDestDirWithPath+attachDoc.getName();
            
                inputStream = new FileInputStream(filename);
                
                String strBase64=convertToBase64(inputStream);
               
                jsnObj.put("BASE64",strBase64);
             
		}else{
			System.out.println("filenotfound Condition");
			 jsnObj.put("FILE_NOT_FOUND","FILE_NOT_FOUND"); 
		}
		
		} catch (Exception e) {
       	 e.printStackTrace();
       	 jsnObj.put("FILE_NOT_FOUND","FILE_NOT_FOUND"); 
        } 
//		end
		
		retrnAry.add(jsnObj);
		
		return retrnAry;
	}

	public static String convertToBase64(FileInputStream fin){

		 String base64Code="";	
		 	
		 try{
		 	
		 	byte[] filedata = null;
		 	
//		 	FileInputStream fin=new FileInputStream(file);
		 	
		 	filedata = fpmsReadInputStream(fin);
		 	
		 	base64Code =/*Base64.encodeBase64String(filedata);*/new String(Base64.encodeBase64(filedata));
		 	
		 }catch(Exception e){
		 	e.printStackTrace();
		 }
		 	
		 return base64Code;
	}		

	public static byte[] fpmsReadInputStream(FileInputStream inputStream) throws IOException {
	   int bufSize = 1024 * 1024;
	   byte[] content;

	   List<byte[]> parts = new LinkedList();
	   InputStream in = new BufferedInputStream(inputStream);

	   byte[] readBuffer = new byte[bufSize];
	   byte[] part = null;
	   int bytesRead = 0;

	   // read everyting into a list of byte arrays
	   while ((bytesRead = in.read(readBuffer, 0, bufSize)) != -1) {
	       part = new byte[bytesRead];
	       System.arraycopy(readBuffer, 0, part, 0, bytesRead);
	       parts.add(part);
	   } // End of while(bytesRead)

	   // calculate the total size
	   int totalSize = 0;
	   for (byte[] partBuffer : parts) {
	       totalSize += partBuffer.length;
	   }

	   // allocate the array
	   content = new byte[totalSize];
	   int offset = 0;
	   for (byte[] partBuffer : parts) {
		   System.arraycopy(partBuffer, 0, content, offset, partBuffer.length);
	       offset += partBuffer.length;
	   }// End of for(partBuffer)

	   return content;
	} // End of fpmsReadInputStream()	

}//end of AssetDetailsServlets
