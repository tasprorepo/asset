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
@Table(name = "ASSET_VENDOR_CONTACTS")
public class AssetVendorContacts implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CONTACT_ID")
	private String txtFldAsstVDContId;
	
	@Column(name="VENDOR_ID")
	private String txtFldAsstVDVendrId;
	
	@Column(name="CONTACTS_247")
	private String txtFldAsstVDCont247;
	
	@Column(name="KEYPERSON_NAME")
	private String txtFldAsstVDKeyPernme;
	
	@Column(name="DESIGNATION")
	private String txtFldAsstVDDesgntn;
	
	@Column(name="MOBILE")
	private String txtFldAsstVDMoble;
	
	@Column(name="VENDOR_OFF_PERSNO")
	private String txtFldAsstVDVendrOffPerNo;
	
	@Column(name="REMARKS")
	private String txtFldAsstVDRmks;
	
	@Column(name="CREATED_BY")
	private String txtFldAsstVDCrUsrId;
	
	@Column(name="CREATED_DATE")
	private Date txtFldAsstVDCrDate;
	
	@Column(name="MODIFIED_BY")
	private String txtFldAsstVDMdfyUsrId;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldAsstVDMdfyDate;
	
	public AssetVendorContacts()
	{
		
	}//end of empty AssetVendor constructor
	
	public AssetVendorContacts(String txtFldAsstVDContId,String txtFldAsstVDVendrId,String txtFldAsstVDCont247,
                         String txtFldAsstVDKeyPernme,String txtFldAsstVDDesgntn,String txtFldAsstVDMoble,
                         String txtFldAsstVDVendrOffPerNo,String txtFldAsstVDRmks,String txtFldAsstVDCrUsrId,
                         Date txtFldAsstVDCrDate,String txtFldAsstVDMdfyUsrId,Date txtFldAsstVDMdfyDate)
	   {
		
		this.txtFldAsstVDContId = txtFldAsstVDContId;
		this.txtFldAsstVDVendrId = txtFldAsstVDVendrId;
		this.txtFldAsstVDCont247 = txtFldAsstVDCont247;
		this.txtFldAsstVDKeyPernme = txtFldAsstVDKeyPernme;
		this.txtFldAsstVDDesgntn = txtFldAsstVDDesgntn;
		this.txtFldAsstVDMoble = txtFldAsstVDMoble;
		this.txtFldAsstVDVendrOffPerNo = txtFldAsstVDVendrOffPerNo;
		this.txtFldAsstVDRmks = txtFldAsstVDRmks;
		this.txtFldAsstVDCrUsrId = txtFldAsstVDCrUsrId;
		this.txtFldAsstVDCrDate = txtFldAsstVDCrDate;
		this.txtFldAsstVDMdfyUsrId = txtFldAsstVDMdfyUsrId;
		this.txtFldAsstVDMdfyDate  = txtFldAsstVDMdfyDate;
		
	  }//end of AssetVendor constructor with arguments
	
	public String getTxtFldAsstVDContId()
	{
		return this.txtFldAsstVDContId;
	}//end of getTxtFldAsstVDContId
	
	public void settxtFldAsstVDContId(String txtFldAsstVDContId)
	{
		this.txtFldAsstVDContId = txtFldAsstVDContId;
	}//end of settxtFldAsstVDContId
	
	public String getTxtFldAsstVDVendrId()
	{
		return this.txtFldAsstVDVendrId;
	}//end of getTxtFldAsstVDVendrId
	
	public void setTxtFldAsstVDVendrId(String txtFldAsstVDVendrId)
	{
		this.txtFldAsstVDVendrId = txtFldAsstVDVendrId;
	}//end of setTxtFldAsstVDVendrId
	
	public String getTxtFldAsstVDCont247()
	{
		return this.txtFldAsstVDCont247;
	}//end of getTxtFldAsstVDCont247
	
	public void setTxtFldAsstVDCont247(String txtFldAsstVDCont247)
	{
		this.txtFldAsstVDCont247 = txtFldAsstVDCont247;
	}//end of setTxtFldAsstVDCont247
	
	public String getTxtFldAsstVDKeyPernme()
	{
		return this.txtFldAsstVDKeyPernme;
	}//end of getTxtFldAsstVDKeyPernme
	
	public void setTxtFldAsstVDKeyPernme(String txtFldAsstVDKeyPernme)
	{
		this.txtFldAsstVDKeyPernme = txtFldAsstVDKeyPernme;
	}//end of setTxtFldAsstVDKeyPernme
	
	public String getTxtFldAsstVDDesgntn()
	{
		return this.txtFldAsstVDDesgntn;
	}//end of getTxtFldAsstVDDesgntn
	
	public void setTxtFldAsstVDDesgntn(String txtFldAsstVDDesgntn)
	{
		this.txtFldAsstVDDesgntn = txtFldAsstVDDesgntn;
	}//end of setTxtFldAsstVDDesgntn
	
	
	public String getTxtFldAsstVDMoble()
	{
		return this.txtFldAsstVDMoble;
	}//end of getTxtFldAsstVDMoble
	
	public void setTxtFldAsstVDMoble(String txtFldAsstVDMoble)
	{
		this.txtFldAsstVDMoble = txtFldAsstVDMoble;
	}//end of setTxtFldAsstVDMoble
	
	public String getTxtFldAsstVDVendrOffPerNo()
	{
		return this.txtFldAsstVDVendrOffPerNo;
	}//end of getTxtFldAsstVDVendrOffPerNo
	
	public void setTxtFldAsstVDVendrOffPerNo(String txtFldAsstVDVendrOffPerNo)
	{
		this.txtFldAsstVDVendrOffPerNo = txtFldAsstVDVendrOffPerNo;
	}//end of setTxtFldAsstVDVendrOffPerNo
	
	public String getTxtFldAsstVDRmks()
	{
		return this.txtFldAsstVDRmks;
	}//end of getTxtFldAsstVDRmks
	
	public void setTxtFldAsstVDRmks(String txtFldAsstVDRmks)
	{
		this.txtFldAsstVDRmks = txtFldAsstVDRmks;
	}//end of setTxtFldAsstVDRmks
	
	public String getTxtFldAsstVDCrUsrId()
	{
		return this.txtFldAsstVDCrUsrId;
	}//end of getTxtFldAsstVDCrUsrId
	
	public void setTxtFldAsstVDCrUsrId(String txtFldAsstVDCrUsrId)
	{
		this.txtFldAsstVDCrUsrId = txtFldAsstVDCrUsrId;
	}//end of setTxtFldAsstVDCrUsrId
	
	public Date getTxtFldAsstVDCrDate()
	{
		return this.txtFldAsstVDCrDate;
	}//end of getTxtFldAsstVDCrDate
	
	public void setTxtFldAsstVDCrDate(Date txtFldAsstVDCrDate)
	{
		this.txtFldAsstVDCrDate = txtFldAsstVDCrDate;
	}//end of setTxtFldAsstVDCrDate
	
	public String getTxtFldAsstVDMdfyUsrId()
	{
		return this.txtFldAsstVDMdfyUsrId;
	}//end of getTxtFldAsstVDMdfyUsrId
	
	public void setTxtFldAsstVDMdfyUsrId(String txtFldAsstVDMdfyUsrId)
	{
		this.txtFldAsstVDMdfyUsrId = txtFldAsstVDMdfyUsrId;
	}//end of setTxtFldAsstVDMdfyUsrId
	
	public Date getTxtFldAsstVDMdfyDate()
	{
		return this.txtFldAsstVDMdfyDate;
	}//end of getTxtFldAsstVDMdfyDate
	
	public void setTxtFldAsstVDMdfyDate(Date txtFldAsstVDMdfyDate)
	{
		this.txtFldAsstVDMdfyDate = txtFldAsstVDMdfyDate;
	}//end of setTxtFldAsstVDMdfyDate
	
	
	
}//end of AssetVendorContacts
