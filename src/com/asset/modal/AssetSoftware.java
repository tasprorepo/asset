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
@Table(name = "ASSET_SOFTWARE")//AssetSoftware Table name changed and assign Fields
public class AssetSoftware implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SW_ID")
	private String txtFldAsstSWId;
	
	@Column(name="SW_NAME")
	private String txtFldAsstSWName;
	
	@Column(name="SW_CATEG")
	private String txtFldAsstSWCateg;
	
	@Column(name="SW_LICENSETYPE")
	private String txtFldAsstSWLicenseType;
	
	@Column(name="SW_LICENSEKEY")
	private String txtFldAsstSWLicenseKey;
	
	@Column(name="SW_STATUS")
	private String txtFldAsstSWStatus;
	
	@Column(name="SW_REMARKS")
	private String txtFldAsstSWRmks;
	
	@Column(name="CREATED_BY")
	private String txtFldAsstSWCrtdUser;
	
	@Column(name="CREATED_DATE")
	private Date txtFldAsstSWCrtdDate;
	
	@Column(name="MODIFIED_BY")
	private String txtFldAsstSWMdfyUser;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldAsstSWMdfyDate;
		
	public AssetSoftware()
	{
		
	}//end of empty AssetSoftware constructor
	
	public AssetSoftware(String txtFldAsstSWId,String txtFldAsstSWName,String txtFldAsstSWCateg,
                         String txtFldAsstSWLicenseType,String txtFldAsstSWLicenseKey,String txtFldAsstSWStatus,
                         String txtFldAsstSWRmks,String txtFldAsstSWCrtdUser,Date txtFldAsstSWCrtdDate,
                         String txtFldAsstSWMdfyUser,Date txtFldAsstSWMdfyDate)
	   {
		
		this.txtFldAsstSWId = txtFldAsstSWId;
		this.txtFldAsstSWName = txtFldAsstSWName;
		this.txtFldAsstSWCateg = txtFldAsstSWCateg;
		this.txtFldAsstSWLicenseType = txtFldAsstSWLicenseType;
		this.txtFldAsstSWLicenseKey = txtFldAsstSWLicenseKey;
		this.txtFldAsstSWStatus = txtFldAsstSWStatus;
		this.txtFldAsstSWRmks = txtFldAsstSWRmks;
		this.txtFldAsstSWCrtdUser = txtFldAsstSWCrtdUser;
		this.txtFldAsstSWCrtdDate = txtFldAsstSWCrtdDate;
		this.txtFldAsstSWMdfyUser = txtFldAsstSWMdfyUser;
		this.txtFldAsstSWMdfyDate = txtFldAsstSWMdfyDate;
		
	  }//end of AssetSoftware constructor with arguments
	
	public String getTxtFldAsstSWId()
	{
		return this.txtFldAsstSWId;
	}//end of getTxtFldAsstSWId
	
	public void setTxtFldAsstSWId(String txtFldAsstSWId)
	{
		this.txtFldAsstSWId = txtFldAsstSWId;
	}//end of setTxtFldAsstSWId
	
	public String getTxtFldAsstSWName()
	{
		return this.txtFldAsstSWName;
	}//end of getTxtFldAsstSWAssdName
	
	public void setTxtFldAsstSWName(String txtFldAsstSWName)
	{
		this.txtFldAsstSWName = txtFldAsstSWName;
	}//end of setTxtFldAsstSWAssdName
	
	public String getTxtFldAsstSWCateg()
	{
		return this.txtFldAsstSWCateg;
	}//end of getTxtFldAsstSWName
	
	public void setTxtFldAsstSWCateg(String txtFldAsstSWCateg)
	{
		this.txtFldAsstSWCateg = txtFldAsstSWCateg;
	}//end of setTxtFldAsstSWName
	
	public String getTxtFldAsstSWLicenseType()
	{
		return this.txtFldAsstSWLicenseType;
	}//end of getTxtFldAsstSWLicenseType
	
	public void setTxtFldAsstSWLicenseType(String txtFldAsstSWLicenseType)
	{
		this.txtFldAsstSWLicenseType = txtFldAsstSWLicenseType;
	}//end of setTxtFldAsstSWLicenseType
	
	public String getTxtFldAsstSWLicenseKey()
	{
		return this.txtFldAsstSWLicenseKey;
	}//end of getTxtFldAsstSWMSOffice
	
	public void setTxtFldAsstSWLicenseKey(String txtFldAsstSWLicenseKey)
	{
		this.txtFldAsstSWLicenseKey = txtFldAsstSWLicenseKey;
	}//end of setTxtFldAsstSWMSOffice
	
	public String getTxtFldAsstSWStatus()
	{
		return this.txtFldAsstSWStatus;
	}//end of getTxtFldAsstHDProssr
	
	public void setTxtFldAsstSWStatus(String txtFldAsstSWStatus)
	{
		this.txtFldAsstSWStatus = txtFldAsstSWStatus;
	}//end of setTxtFldAsstHDProssr
	
	public String getTxtFldAsstSWRmks()
	{
		return this.txtFldAsstSWRmks;
	}//end of getTxtFldAsstHDRmks
	
	public void setTxtFldAsstSWRmks(String txtFldAsstSWRmks)
	{
		this.txtFldAsstSWRmks = txtFldAsstSWRmks;
	}//end of setTxtFldAsstHDRmks
	
	public String getTxtFldAsstSWCrtdUser()
	{
		return this.txtFldAsstSWCrtdUser;
	}//end of getTxtFldAsstHDCrtdUser
	
	public void setTxtFldAsstSWCrtdUser(String txtFldAsstSWCrtdUser)
	{
		 this.txtFldAsstSWCrtdUser = txtFldAsstSWCrtdUser;
	}//end of setTxtFldAsstHDCrtdUser
	
	public Date getTxtFldAsstSWCrtdDate()
	{
		return this.txtFldAsstSWCrtdDate;
	}//end of getTxtFldAsstHDCrtdDate
	
	public void setTxtFldAsstSWCrtdDate(Date txtFldAsstSWCrtdDate){
		this.txtFldAsstSWCrtdDate = txtFldAsstSWCrtdDate;
	}//end of setTxtFldAsstHDCrtdDate
	
	public String getTxtFldAsstSWMdfyUser()
	{
		return this.txtFldAsstSWMdfyUser;
	}//end of getTxtFldAsstHDMdfyUser
	
	public void setTxtFldAsstSWMdfyUser(String txtFldAsstSWMdfyUser)
	{
		this.txtFldAsstSWMdfyUser = txtFldAsstSWMdfyUser;
	}//end of setTxtFldAsstHDMdfyUser
	
	public Date getTxtFldAsstSWMdfyDate()
	{
		return this.txtFldAsstSWMdfyDate;
	}//end of getTxtFldAsstHDMdfyDate
	
	public void setTxtFldAsstSWMdfyDate(Date txtFldAsstSWMdfyDate)
	{
		this.txtFldAsstSWMdfyDate = txtFldAsstSWMdfyDate;
	}//end of setTxtFldAsstHDMdfyDate
	
}//end of AssetSoftware
