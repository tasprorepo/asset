package com.asset.modal;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSET_VENDOR_SERVICE")//ASSET_VENDOR_SERVICE Table name 
public class AssetVendorServices implements Serializable
{

	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="SERVICE_ID")
	private String txtFldAsstVDSerId;
	
	@Column(name="VENDOR_ID")
	private String txtFldAsstVDVendrId;
	
	@Column(name="ASSET_ID")
	private String txtFldAsstVDAssetId;
	
	@Column(name="SERVICE_TYPE")
	private String txtFldAsstVDSerTyp;
	
	@Column(name="RENEWAL_AMOUNT")
	private String txtFldAsstVDRenwlAmt;
	
	@Column(name="PRODUCT_DESCRIPTION")
	private String txtFldAsstVDPrdtDescp;
	
	@Column(name="PURCHASE_DATE")
	private Date txtFldAsstVDPurhDate;
	
	@Column(name="STARTDATE")
	private Date txtFldAsstVDStrtDate;
	
	@Column(name="ENDDATE")
	private Date txtFldAsstVDEndDate;
	
	@Column(name="VALIDITY_PERIOD")
	private String txtFldAsstVDVldPeriod;
	
	@Column(name="REMARKS")
	private String txtFldAsstVDRmks;
	
	@Column(name="SERVICE_STATUS")
	private String txtFldAsstVDServStatus;
	    
	@Column(name="STATUS")
	private String txtFldAsstVDStatus;
	    
	@Column(name="PRODUCT")
	private String txtFldAsstVDProduct;
	    
	@Column(name="SUB_PRODUCT")
	private String txtFldAsstVDSubProduct;
	    
	@Column(name="CREATED_BY")
	private String txtFldAsstVDCrUsrId;
	    
	@Column(name="CREATED_DATE")
	private Date txtFldAsstVDCrDate;
	
	
	@Column(name="MODIFIED_BY")
	private String txtFldAsstVDMdfyUser;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldAsstVDMdfyDate;
		
	public AssetVendorServices()
	{
		
	}//end of empty AssetVendor constructor
	
	public AssetVendorServices(String txtFldAsstVDSerId,String txtFldAsstVDVendrId,String txtFldAsstVDAssetId,
                         String txtFldAsstVDSerTyp,String txtFldAsstVDRenwlAmt,String txtFldAsstVDPrdtDescp,
                         Date txtFldAsstVDPurhDate,Date txtFldAsstVDStrtDate,Date txtFldAsstVDEndDate,
                         String txtFldAsstVDVldPeriod,String txtFldAsstVDRmks,String txtFldAsstVDServStatus,String txtFldAsstVDStatus,
                         String txtFldAsstVDProduct,String txtFldAsstVDSubProduct,String txtFldAsstVDCrUsrId,Date txtFldAsstVDCrDate,String txtFldAsstVDMdfyUser,Date txtFldAsstVDMdfyDate)
	   {
		
		this.txtFldAsstVDSerId = txtFldAsstVDSerId;
		this.txtFldAsstVDVendrId = txtFldAsstVDVendrId;
		this.txtFldAsstVDAssetId = txtFldAsstVDAssetId;
		this.txtFldAsstVDSerTyp = txtFldAsstVDSerTyp;
		this.txtFldAsstVDRenwlAmt = txtFldAsstVDRenwlAmt;
		this.txtFldAsstVDPrdtDescp = txtFldAsstVDPrdtDescp;
		this.txtFldAsstVDPurhDate = txtFldAsstVDPurhDate;
		this.txtFldAsstVDStrtDate = txtFldAsstVDStrtDate;
		this.txtFldAsstVDEndDate = txtFldAsstVDEndDate;
		this.txtFldAsstVDVldPeriod = txtFldAsstVDVldPeriod;
		this.txtFldAsstVDRmks = txtFldAsstVDRmks;
		this.txtFldAsstVDServStatus  = txtFldAsstVDServStatus;
		this.txtFldAsstVDStatus = txtFldAsstVDStatus;
		this.txtFldAsstVDProduct = txtFldAsstVDProduct;
		this.txtFldAsstVDSubProduct = txtFldAsstVDSubProduct;
		this.txtFldAsstVDCrUsrId = txtFldAsstVDCrUsrId;
		this.txtFldAsstVDCrDate = txtFldAsstVDCrDate;
		this.txtFldAsstVDMdfyUser = txtFldAsstVDMdfyUser;
		this.txtFldAsstVDMdfyDate = txtFldAsstVDMdfyDate;
		
	  }//end of AssetVendor constructor with arguments
	
	public String getTxtFldAsstVDSerId()
	{
		return this.txtFldAsstVDSerId;
	}//end of getTxtFldAsstVDSerId
	
	public void setTxtFldAsstVDSerId(String txtFldAsstVDSerId)
	{
		this.txtFldAsstVDSerId = txtFldAsstVDSerId;
	}//end of setTxtFldAsstVDSerId
	
	public String getTxtFldAsstVDVendrId()
	{
		return this.txtFldAsstVDVendrId;
	}//end of getTxtFldAsstVDVendrId
	
	public void setTxtFldAsstVDVendrId(String txtFldAsstVDVendrId)
	{
		this.txtFldAsstVDVendrId = txtFldAsstVDVendrId;
	}//end of setTxtFldAsstVDVendrId
	
	public String getTxtFldAsstVDAssetId()
	{
		return this.txtFldAsstVDAssetId;
	}//end of getTxtFldAsstVDAssetId
	
	public void setTxtFldAsstVDAssetId(String txtFldAsstVDAssetId)
	{
		this.txtFldAsstVDAssetId = txtFldAsstVDAssetId;
	}//end of setTxtFldAsstVDAssetId
	
	public String getTxtFldAsstVDSerTyp()
	{
		return this.txtFldAsstVDSerTyp;
	}//end of getTxtFldAsstVDSerTyp
	
	public void setTxtFldAsstVDSerTyp(String txtFldAsstVDSerTyp)
	{
		this.txtFldAsstVDSerTyp = txtFldAsstVDSerTyp;
	}//end of setTxtFldAsstVDSerTyp
	
	public String getTxtFldAsstVDRenwlAmt()
	{
		return this.txtFldAsstVDRenwlAmt;
	}//end of getTxtFldAsstVDRenwlAmt
	
	public void setTxtFldAsstVDRenwlAmt(String txtFldAsstVDRenwlAmt)
	{
		this.txtFldAsstVDRenwlAmt = txtFldAsstVDRenwlAmt;
	}//end of setTxtFldAsstVDRenwlAmt
	
	public String getTxtFldAsstVDPrdtDescp()
	{
		return this.txtFldAsstVDPrdtDescp;
	}//end of getTxtFldAsstVDPrdtDescp
	
	public void setTxtFldAsstVDPrdtDescp(String txtFldAsstVDPrdtDescp)
	{
		this.txtFldAsstVDPrdtDescp = txtFldAsstVDPrdtDescp;
	}//end of setTxtFldAsstVDPrdtDescp
	
	public Date getTxtFldAsstVDPurhDate()
	{
		return this.txtFldAsstVDPurhDate;
	}//end of getTxtFldAsstVDCity
	
	public void setTxtFldAsstVDPurhDate(Date txtFldAsstVDPurhDate)
	{
		this.txtFldAsstVDPurhDate = txtFldAsstVDPurhDate;
	}//end of setTxtFldAsstVDCity
	
	public Date getTxtFldAsstVDStrtDate()
	{
		return this.txtFldAsstVDStrtDate;
	}//end of getTxtFldAsstVDStrtDate
	
	public void setTxtFldAsstVDStrtDate(Date txtFldAsstVDStrtDate)
	{
		this.txtFldAsstVDStrtDate = txtFldAsstVDStrtDate;
	}//end of setTxtFldAsstVDStrtDate
	
	public Date getTxtFldAsstVDEndDate()
	{
		return this.txtFldAsstVDEndDate;
	}//end of getTxtFldAsstVDPcode
	
	public void setTxtFldAsstVDEndDate(Date txtFldAsstVDEndDate)
	{
		this.txtFldAsstVDEndDate = txtFldAsstVDEndDate;
	}//end of setTxtFldAsstVDPcode
	
	
	public String getTxtFldAsstVDVldPeriod()
	{
		return this.txtFldAsstVDVldPeriod;
	}//end of getTxtFldAsstVDVldPeriod
	
	public void setTxtFldAsstVDVldPeriod(String txtFldAsstVDVldPeriod)
	{
		 this.txtFldAsstVDVldPeriod = txtFldAsstVDVldPeriod;
	}//end of setTxtFldAsstVDVldPeriod
	
	public String getTxtFldAsstVDRmks()
	{
		return this.txtFldAsstVDRmks;
	}//end of getTxtFldAsstVDRmks
	
	public void setTxtFldAsstVDRmks(String txtFldAsstVDRmks)
	{
		 this.txtFldAsstVDRmks = txtFldAsstVDRmks;
	}//end of setTxtFldAsstVDRmks
	
	
	public String getTxtFldAsstVDServStatus()
	{
		return this.txtFldAsstVDServStatus;
	}//end of getTxtFldAsstVDHp
	
	public void setTxtFldAsstVDServStatus(String txtFldAsstVDServStatus)
	{
		 this.txtFldAsstVDServStatus = txtFldAsstVDServStatus;
	}//end of setTxtFldAsstVDHp
	
	public String getTxtFldAsstVDStatus()
	{
		return this.txtFldAsstVDStatus;
	}//end of getTxtFldAsstVDStatus
	
	public void setTxtFldAsstVDStatus(String txtFldAsstVDStatus){
		this.txtFldAsstVDStatus = txtFldAsstVDStatus;
	}//end of setTxtFldAsstVDStatus
	
	public String getTxtFldAsstVDProduct()
	{
		return this.txtFldAsstVDProduct;
	}//end of getTxtFldAsstVDProduct
	
	public void setTxtFldAsstVDProduct(String txtFldAsstVDProduct)
	{
		 this.txtFldAsstVDProduct = txtFldAsstVDProduct;
	}//end of setTxtFldAsstVDProduct
	
	
	
	
	public String getTxtFldAsstVDSubProduct()
	{
		return this.txtFldAsstVDSubProduct;
	}//end of getTxtFldAsstVDSubProduct
	
	public void setTxtFldAsstVDSubProduct(String txtFldAsstVDSubProduct){
		this.txtFldAsstVDSubProduct = txtFldAsstVDSubProduct;
	}//end of setTxtFldAsstVDSubProduct
	
	
	
	
	public String getTxtFldAsstVDCrUsrId()
	{
		return this.txtFldAsstVDCrUsrId;
	}//end of getTxtFldAsstVDCrtdUserId
	
	public void setTxtFldAsstVDCrUsrId(String txtFldAsstVDCrUsrId)
	{
		 this.txtFldAsstVDCrUsrId = txtFldAsstVDCrUsrId;
	}//end of settxtFldAsstVDCrtdUserId
	
	public Date getTxtFldAsstVDCrDate()
	{
		return this.txtFldAsstVDCrDate;
	}//end of getTxtFldAsstVDCrDate
	
	public void setTxtFldAsstVDCrDate(Date txtFldAsstVDCrDate){
		this.txtFldAsstVDCrDate = txtFldAsstVDCrDate;
	}//end of setTxtFldAsstVDCrDate
	
	public String getTxtFldAsstVDMdfyUser()
	{
		return this.txtFldAsstVDMdfyUser;
	}//end of getTxtFldAsstVDMdfyUser
	
	public void setTxtFldAsstVDMdfyUser(String txtFldAsstVDMdfyUser)
	{
		this.txtFldAsstVDMdfyUser = txtFldAsstVDMdfyUser;
	}//end of setTxtFldAsstVDMdfyUser
	
	public Date getTxtFldAsstVDMdfyDate()
	{
		return this.txtFldAsstVDMdfyDate;
	}//end of getTxtFldAsstVDMdfyDate
	
	public void setTxtFldAsstVDMdfyDate(Date txtFldAsstVDMdfyDate)
	{
		this.txtFldAsstVDMdfyDate = txtFldAsstVDMdfyDate;
	}//end of setTxtFldAsstVDMdfyDate
	
}//end of AssetVendorService
