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
@Table(name = "ASSET_ATTACHMENTS")
public class AssetAttachmnt implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name="ATTACHMNT_ID")
	private String txtFldAsstAttachmntId;
	
	@Column(name="ATTACHMNT_CATGRY")
	private String txtFldAsstAttachmntCatgry;
	
	@Column(name="DOC_TYPE")
	private String txtFldAsstDocumntType;
	
	@Column(name="FILE_NAME")
	private String txtFldAsstAttachFileName;
	
	@Column(name="DOC_TITLE")
	private String txtFldAsstAttachDocTitle;
	
	@Column(name="REMARKS")
	private String txtFldAsstAttachmentRemarks;
	
	@Column(name="DOCUMENTS")
	private String txtFldAsstAttachDocuments;
	
	@Column(name="ATTACHMNT_DATE")
	private Date  txtFldAsstAttachmntDate;
	
	@Column(name="FILE_TYPE")
	private String txtFldAsstAttachmntFileType;
	
	@Column(name="CREATED_BY")
	private String txtFldAsstAttachmntCrtdBy;
	
	@Column(name="CREATED_DATE")
	private Date txtFldAsstAttachmntCrtdDate;
	
	@Column(name="MODIFIED_BY")
	private String txtFldAsstAttachmntModifdBy;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldAsstAttachmntModfdDate;
	
	
	
	public AssetAttachmnt()
	{
		
	}//end of empty constructor
	
	
	public AssetAttachmnt(String txtFldAsstAttachmntId, String txtFldAsstAttachmntCatgry,String txtFldAsstDocumntType,String txtFldAsstAttachFileName,String txtFldAsstAttachDocTitle,
		String txtFldAsstAttachmentRemarks,String txtFldAsstAttachDocuments, Date txtFldAsstAttachmntDate ,String txtFldAsstAttachmntFileType,String txtFldAsstAttachmntCrtdBy,Date txtFldAsstAttachmntCrtdDate,
                         String txtFldAsstAttachmntModifdBy,Date txtFldAsstAttachmntModfdDate
                         )
	{
		this.txtFldAsstAttachmntId = txtFldAsstAttachmntId;
		this.txtFldAsstAttachmntCatgry = txtFldAsstAttachmntCatgry;
		this.txtFldAsstDocumntType = txtFldAsstDocumntType;
		this.txtFldAsstAttachFileName = txtFldAsstAttachFileName;
		this.txtFldAsstAttachDocTitle = txtFldAsstAttachDocTitle;
		this.txtFldAsstAttachmentRemarks = txtFldAsstAttachmentRemarks;
		this.txtFldAsstAttachmntDate = txtFldAsstAttachmntDate;
		this.txtFldAsstAttachmntFileType = txtFldAsstAttachmntFileType;
		this.txtFldAsstAttachmntCrtdBy = txtFldAsstAttachmntCrtdBy;
		this.txtFldAsstAttachmntCrtdDate = txtFldAsstAttachmntCrtdDate;
		this.txtFldAsstAttachmntModifdBy = txtFldAsstAttachmntModifdBy;
		this.txtFldAsstAttachmntModfdDate = txtFldAsstAttachmntModfdDate;
		
		
	}//end of constructor
	
	public String getTxtFldAsstAttachmntId()
	{
		return this.txtFldAsstAttachmntId;
	}//end of getTxtFldAsstAttachmntCatgry
	
	public void setTxtFldAsstAttachmntId(String txtFldAsstAttachmntId)
	{
		this.txtFldAsstAttachmntId = txtFldAsstAttachmntId;
	}//end of setTxtFldAsstAttachmntCatgry
	
	
	public String getTxtFldAsstAttachmntCatgry()
	{
		return this.txtFldAsstAttachmntCatgry;
	}//end of getTxtFldAsstAttachmntCatgry
	
	public void setTxtFldAsstAttachmntCatgry(String txtFldAsstAttachmntCatgry)
	{
		this.txtFldAsstAttachmntCatgry = txtFldAsstAttachmntCatgry;
	}//end of setTxtFldAsstAttachmntCatgry
	
	
	public String getTxtFldAsstDocumntType()
	{
		return this.txtFldAsstDocumntType;
	}//end of getTxtFldAsstDocumntType
	
	public void setTxtFldAsstDocumntType(String txtFldAsstDocumntType)
	{
		this.txtFldAsstDocumntType = txtFldAsstDocumntType;
	}//end of setTxtFldAsstDocumntType
	
	public String getTxtFldAsstAttachFileName()
	{
		return this.txtFldAsstAttachFileName;
	}//end of getTxtFldAsstDocumntType
	
	public void setTxtFldAsstAttachFileName(String txtFldAsstAttachFileName)
	{
		this.txtFldAsstAttachFileName = txtFldAsstAttachFileName;
	}//end of setTxtFldAsstDocumntType
	
	public String getTxtFldAsstAttachDocTitle()
	{
		return this.txtFldAsstAttachDocTitle;
	}//end of getTxtFldAsstHDName
	
	public void setTxtFldAsstAttachDocTitle(String txtFldAsstAttachDocTitle)
	{
		this.txtFldAsstAttachDocTitle = txtFldAsstAttachDocTitle;
	}//end of setTxtFldAsstHDName
	
	public String getTxtFldAsstAttachmentRemarks()
	{
		return this.txtFldAsstAttachmentRemarks;
	}//end of getTxtFldAsstHDName
	
	public void setTxtFldAsstAttachmentRemarks(String txtFldAsstAttachmentRemarks)
	{
		this.txtFldAsstAttachmentRemarks = txtFldAsstAttachmentRemarks;
	}//end of setTxtFldAsstHDName
	
	public Date getTxtFldAsstAttachmntDate()
	{
		return this.txtFldAsstAttachmntDate;
	}//end of getTxtFldAsstHDMake
	
	public void setTxtFldAsstAttachmntDate(Date txtFldAsstAttachmntDate)
	{
		this.txtFldAsstAttachmntDate = txtFldAsstAttachmntDate;
	}//end of setTxtFldAsstHDMake
	
	public String getTxtFldAsstAttachmntFileType()
	{
		return this.txtFldAsstAttachmntFileType;
	}//end of getTxtFldAsstHDModel
	
	public void setTxtFldAsstAttachmntFileType(String txtFldAsstAttachmntFileType)
	{
		this.txtFldAsstAttachmntFileType = txtFldAsstAttachmntFileType;
	}//end of setTxtFldAsstHDModel
	
	public String getTxtFldAsstAttachmntCrtdBy()
	{
		return this.txtFldAsstAttachmntCrtdBy;
	}//end of getTxtFldAsstHDSerlNo
	
	public void setTxtFldAsstAttachmntCrtdBy(String txtFldAsstAttachmntCrtdBy)
	{
		this.txtFldAsstAttachmntCrtdBy = txtFldAsstAttachmntCrtdBy;
	}//end of setTxtFldAsstHDSerlNo
	
	public Date getTxtFldAsstAttachmntCrtdDate()
	{
		return this.txtFldAsstAttachmntCrtdDate;
	}//end of getTxtFldAsstHDAllotTo
	
	public void setTxtFldAsstAttachmntCrtdDate(Date txtFldAsstAttachmntCrtdDate)
	{
		this.txtFldAsstAttachmntCrtdDate = txtFldAsstAttachmntCrtdDate;
	}//end of setTxtFldAsstHDAllotTo
	
	
	public String getTxtFldAsstAttachmntModifdBy()
	{
		return this.txtFldAsstAttachmntModifdBy;
	}//end of getTxtFldAsstHDOperSys
	
	public void setTxtFldAsstAttachmntModifdBy(String txtFldAsstAttachmntModifdBy)
	{
		this.txtFldAsstAttachmntModifdBy = txtFldAsstAttachmntModifdBy;
	}//end of setTxtFldAsstHDOperSys
	
	public Date getTxtFldAsstAttachmntModfdDate()
	{
		return this.txtFldAsstAttachmntModfdDate;
	}//end of getTxtFldAsstHDProssr
	
	public void setTxtFldAsstAttachmntModfdDate(Date txtFldAsstAttachmntModfdDate)
	{
		this.txtFldAsstAttachmntModfdDate = txtFldAsstAttachmntModfdDate;
	}//end of setTxtFldAsstHDProssr
	
	
	
}//end of AssetHardware
