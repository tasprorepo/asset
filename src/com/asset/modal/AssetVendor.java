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
@Table(name = "ASSET_VENDOR_MASTER")
public class AssetVendor implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VENDOR_ID")
	private String txtFldAsstVDId;
	
	@Column(name="VENDOR_REP")
	private String txtFldAsstVDRepName;
	
	@Column(name="VENDOR_NAME")
	private String txtFldAsstVDName;
	
	@Column(name="VENDOR_ADDR1")
	private String txtFldAsstVDAddr1;
	
	@Column(name="VENDOR_ADDR2")
	private String txtFldAsstVDAddr2;
	
	@Column(name="VENDOR_ADDR3")
	private String txtFldAsstVDAddr3;
	
	@Column(name="VENDOR_CITY")
	private String txtFldAsstVDCity;
	
	@Column(name="VENDOR_COUNTRY")
	private String txtFldAsstVDCountry;
	
	@Column(name="VENDOR_PCODE")
	private String txtFldAsstVDPcode;
	
	@Column(name="VENDOR_OFFPH")
	private String txtFldAsstVDOffph;
	
	@Column(name="VENDOR_FAX")
	private String txtFldAsstVDFax;
	
	@Column(name="VENDOR_HP")
	private String txtFldAsstVDHp;
	    
	@Column(name="VENDOR_EMAIL")
	private String txtFldAsstVDEmail;
	    
	@Column(name="VENDOR_WEBSITE")
	private String txtFldAsstVDWebsite;
	    
	@Column(name="CONTACTS_247")
	private String txtFldAsstVDContacts247;
	    
	@Column(name="REMARKS")
	private String txtFldAsstVDRemarks;
	    
	@Column(name="CREATED_BY")
	private String txtFldAsstVDCrtdUserId;
	
	@Column(name="CREATED_DATE")
	private Date txtFldAsstVDCrtdDate;
	
	@Column(name="MODIFIED_BY")
	private String txtFldAsstVDMdfyUser;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldAsstVDMdfyDate;
		
	public AssetVendor()
	{
		
	}//end of empty AssetVendor constructor
	
	public AssetVendor(String txtFldAsstVDId,String txtFldAsstVDRepName,String txtFldAsstVDName,
                         String txtFldAsstVDAddr1,String txtFldAsstVDAddr2,String txtFldAsstVDAddr3,
                         String txtFldAsstVDCity,String txtFldAsstVDCountry,String txtFldAsstVDPcode,
                         String txtFldAsstVDOffph,String txtFldAsstVDFax,String txtFldAsstVDHp,String txtFldAsstVDEmail,
                         String txtFldAsstVDWebsite,String txtFldAsstVDContacts247,String txtFldAsstVDRemarks,String txtFldAsstVDCrtdUserId,
                         Date txtFldAsstVDCrtdDate,String txtFldAsstVDMdfyUser,Date txtFldAsstVDMdfyDate)
	   {
		
		this.txtFldAsstVDId = txtFldAsstVDId;
		this.txtFldAsstVDRepName = txtFldAsstVDRepName;
		this.txtFldAsstVDName = txtFldAsstVDName;
		this.txtFldAsstVDAddr1 = txtFldAsstVDAddr1;
		this.txtFldAsstVDAddr2 = txtFldAsstVDAddr2;
		this.txtFldAsstVDAddr3 = txtFldAsstVDAddr3;
		this.txtFldAsstVDCity = txtFldAsstVDCity;
		this.txtFldAsstVDCountry = txtFldAsstVDCountry;
		this.txtFldAsstVDPcode = txtFldAsstVDPcode;
		this.txtFldAsstVDOffph = txtFldAsstVDOffph;
		this.txtFldAsstVDFax = txtFldAsstVDFax;
		this.txtFldAsstVDHp  = txtFldAsstVDHp;
		this.txtFldAsstVDEmail = txtFldAsstVDEmail;
		this.txtFldAsstVDWebsite = txtFldAsstVDWebsite;
		this.txtFldAsstVDContacts247 = txtFldAsstVDContacts247;
		this.txtFldAsstVDRemarks = txtFldAsstVDRemarks;
		this.txtFldAsstVDCrtdUserId = txtFldAsstVDCrtdUserId;
		this.txtFldAsstVDCrtdDate = txtFldAsstVDCrtdDate;
		this.txtFldAsstVDMdfyUser = txtFldAsstVDMdfyUser;
		this.txtFldAsstVDMdfyDate = txtFldAsstVDMdfyDate;
	  }//end of AssetVendor constructor with arguments
	
	public String getTxtFldAsstVDId()
	{
		return this.txtFldAsstVDId;
	}//end of getTxtFldAsstVDId
	
	public void setTxtFldAsstVDId(String txtFldAsstVDId)
	{
		this.txtFldAsstVDId = txtFldAsstVDId;
	}//end of setTxtFldAsstVDId
	
	public String getTxtFldAsstVDRepName()
	{
		return this.txtFldAsstVDRepName;
	}//end of getTxtFldAsstVDRepName
	
	public void setTxtFldAsstVDRepName(String txtFldAsstVDRepName)
	{
		this.txtFldAsstVDRepName = txtFldAsstVDRepName;
	}//end of setTxtFldAsstVDRepName
	
	public String getTxtFldAsstVDName()
	{
		return this.txtFldAsstVDName;
	}//end of getTxtFldAsstVDName
	
	public void setTxtFldAsstVDName(String txtFldAsstVDName)
	{
		this.txtFldAsstVDName = txtFldAsstVDName;
	}//end of setTxtFldAsstVDName
	
	public String gettxtFldAsstVDAddr1()
	{
		return this.txtFldAsstVDAddr1;
	}//end of gettxtFldAsstVDAddr1
	
	public void setTxtFldAsstVDAddr1(String txtFldAsstVDAddr1)
	{
		this.txtFldAsstVDAddr1 = txtFldAsstVDAddr1;
	}//end of setTxtFldAsstVDAddr1
	
	public String getTxtFldAsstVDAddr2()
	{
		return this.txtFldAsstVDAddr2;
	}//end of getTxtFldAsstVDAddr2
	
	public void setTxtFldAsstVDAddr2(String txtFldAsstVDAddr2)
	{
		this.txtFldAsstVDAddr2 = txtFldAsstVDAddr2;
	}//end of setTxtFldAsstVDAddr2
	
	public String getTxtFldAsstVDAddr3()
	{
		return this.txtFldAsstVDAddr3;
	}//end of getTxtFldAsstVDAddr3
	
	public void setTxtFldAsstVDAddr3(String txtFldAsstVDAddr3)
	{
		this.txtFldAsstVDAddr3 = txtFldAsstVDAddr3;
	}//end of setTxtFldAsstVDAddr3
	
	public String getTxtFldAsstVDCity()
	{
		return this.txtFldAsstVDCity;
	}//end of getTxtFldAsstVDCity
	
	public void setTxtFldAsstVDCity(String txtFldAsstVDCity)
	{
		this.txtFldAsstVDCity = txtFldAsstVDCity;
	}//end of setTxtFldAsstVDCity
	
	public String getTxtFldAsstVDCountry()
	{
		return this.txtFldAsstVDCountry;
	}//end of getTxtFldAsstVDCity
	
	public void setTxtFldAsstVDCountry(String txtFldAsstVDCountry)
	{
		this.txtFldAsstVDCountry = txtFldAsstVDCountry;
	}//end of setTxtFldAsstVDCity
	
	public String getTxtFldAsstVDPcode()
	{
		return this.txtFldAsstVDPcode;
	}//end of getTxtFldAsstVDPcode
	
	public void setTxtFldAsstVDPcode(String txtFldAsstVDPcode)
	{
		this.txtFldAsstVDPcode = txtFldAsstVDPcode;
	}//end of setTxtFldAsstVDPcode
	
	
	public String getTxtFldAsstVDOffph()
	{
		return this.txtFldAsstVDOffph;
	}//end of getTxtFldAsstVDOffph
	
	public void setTxtFldAsstVDOffph(String txtFldAsstVDOffph)
	{
		 this.txtFldAsstVDOffph = txtFldAsstVDOffph;
	}//end of setTxtFldAsstVDOffph
	
	public String getTxtFldAsstVDFax()
	{
		return this.txtFldAsstVDFax;
	}//end of getTxtFldAsstVDFax
	
	public void setTxtFldAsstVDFax(String txtFldAsstVDFax)
	{
		 this.txtFldAsstVDFax = txtFldAsstVDFax;
	}//end of setTxtFldAsstVDFax
	
	
	public String getTxtFldAsstVDHp()
	{
		return this.txtFldAsstVDHp;
	}//end of getTxtFldAsstVDHp
	
	public void setTxtFldAsstVDHp(String txtFldAsstVDHp)
	{
		 this.txtFldAsstVDHp = txtFldAsstVDHp;
	}//end of setTxtFldAsstVDHp
	
	public String getTxtFldAsstVDEmail()
	{
		return this.txtFldAsstVDEmail;
	}//end of getTxtFldAsstVDEmail
	
	public void setTxtFldAsstVDEmail(String txtFldAsstVDEmail){
		this.txtFldAsstVDEmail = txtFldAsstVDEmail;
	}//end of setTxtFldAsstVDEmail
	
	public String getTxtFldAsstVDWebsite()
	{
		return this.txtFldAsstVDWebsite;
	}//end of getTxtFldAsstVDWebsite
	
	public void setTxtFldAsstVDWebsite(String txtFldAsstVDWebsite)
	{
		 this.txtFldAsstVDWebsite = txtFldAsstVDWebsite;
	}//end of setTxtFldAsstVDWebsite
	
	
	
	
	public String getTxtFldAsstVDContacts247()
	{
		return this.txtFldAsstVDContacts247;
	}//end of getTxtFldAsstVDContacts247
	
	public void setTxtFldAsstVDContacts247(String txtFldAsstVDContacts247){
		this.txtFldAsstVDContacts247 = txtFldAsstVDContacts247;
	}//end of setTxtFldAsstVDContacts247
	
	public String getTxtFldAsstVDRemarks()
	{
		return this.txtFldAsstVDRemarks;
	}//end of getTxtFldAsstVDRemarks
	
	public void setTxtFldAsstVDRemarks(String txtFldAsstVDRemarks)
	{
		 this.txtFldAsstVDRemarks = txtFldAsstVDRemarks;
	}//end of setTxtFldAsstVDRemarks
	
	
	
	public String getTxtFldAsstVDCrtdUserId()
	{
		return this.txtFldAsstVDCrtdUserId;
	}//end of getTxtFldAsstVDCrtdUserId
	
	public void settxtFldAsstVDCrtdUserId(String txtFldAsstVDCrtdUserId)
	{
		 this.txtFldAsstVDCrtdUserId = txtFldAsstVDCrtdUserId;
	}//end of settxtFldAsstVDCrtdUserId
	
	public Date getTxtFldAsstVDCrtdDate()
	{
		return this.txtFldAsstVDCrtdDate;
	}//end of getTxtFldAsstVDCrtdDate
	
	public void setTxtFldAsstVDCrtdDate(Date txtFldAsstVDCrtdDate){
		this.txtFldAsstVDCrtdDate = txtFldAsstVDCrtdDate;
	}//end of setTxtFldAsstVDCrtdDate
	
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
	}//end of getTxtFldAsstHDMdfyDate
	
	public void setTxtFldAsstVDMdfyDate(Date txtFldAsstVDMdfyDate)
	{
		this.txtFldAsstVDMdfyDate = txtFldAsstVDMdfyDate;
	}//end of setTxtFldAsstHDMdfyDate
	
}//end of AssetVendor
