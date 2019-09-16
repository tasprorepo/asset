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
@Table(name = "ASSET_HARDWARE")
public class AssetHardware implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="HW_ID")
	private String txtFldAsstHDId;
	
//	@Column(name="ASSET_ID")
//	private String txtFldAsstHDAssdName;

	@Column(name="HW_NAME")
	private String txtFldAsstHDName;
	
	@Column(name="MAKE")
	private String txtFldAsstHDMake;
	
	@Column(name="MODEL")
	private String txtFldAsstHDModel;
	
	@Column(name="SERIAL_NO")
	private String txtFldAsstHDSerlNo;
	
	@Column(name="MAC_ID")
	private String txtFldAsstHDMACId;
	
	@Column(name="ALLOTED_TO")
	private String txtFldAsstHDAllotTo;
	
	@Column(name="OS")
	private String txtFldAsstHDOperSys;
	
	@Column(name="OS_VERSION")
	private String txtFldAsstHDOperSysver;
	
	@Column(name="PROCESSOR")
	private String txtFldAsstHDProssr;
	
	@Column(name="PROCESSOR_SPEED")
	private String txtFldAsstHDProssrSpd;
	
	@Column(name="RAM")
	private String txtFldAsstHDRAM;
	
	@Column(name="HDD")
	private String txtFldAsstHDD;
	
	@Column(name="HDD_PARTITIONS")
	private String txtFldAsstHDDPartitions;
	
	@Column(name="LOC_ID")
	private String txtFldAsstHDLocID;
	
	@Column(name="REMARKS")
	private String txtFldAsstHDRmks;
	
	@Column(name="CREATED_BY")
	private String txtFldAsstHDCrtdUser;
	
	@Column(name="CREATED_DATE")
	private Date txtFldAsstHDCrtdDate;
	
	@Column(name="MODIFIED_BY")
	private String txtFldAsstHDMdfyUser;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldAsstHDMdfyDate;
	
	@Column(name="PART_NO")
	private String txtFldAsstHDPartNo;
	
	@Column(name="HW_CATEG")
	private String txtFldAsstHDCateg;
	
	@Column(name="HW_STATUS")
	private String txtFldAsstHDStatus;
	
	
	@Column(name="HW_PURDATE")
	private Date txtFldAsstHDPurchaseDate;
	
	@Column(name="HW_WARTYSTARTDATE")
	private Date txtFldAsstHDWarrantyStartDate;
	
	@Column(name="HW_WARTYENDDATE")
	private Date txtFldAsstHDWarrantyEndDate;
	
	@Column(name="PREV_USER")
	private String txtFldAsstHDPrevUsr;
	
	@Column(name="HW_WARRANTY_STATUS")
	private String txtFldAsstHDWarrantyStatus;
	
	@Column(name="HW_STATUS_DESCRIPTION")
	private String txtFldAsstHDWarrantyStatusDescription;
	
	@Column(name="HW_REPLACE_DUE")
	private String txtFldAsstHDReplaceDue;
	
	@Column(name="CPU_SOCKETS")
	private String txtFldAsstHDCpuSockets;
	
	@Column(name="TOTAL_CORES")
	private String txtFldAsstHDTotCores;
	
	@Column(name="LOGICAL_PROCESSORS")
	private String txtFldAsstHDLogProcess;
	
	@Column(name="HW_SERVCATG")
	private String txtFldAsstHDServCatg;
	
	@Column(name="HW_IPNO")
	private String txtFldAsstHDIPNo;
	
	public AssetHardware()
	{
		
	}//end of empty constructor
	
	
	public AssetHardware(String txtFldAsstHDId,
						 String txtFldAsstHDName,
                         String txtFldAsstHDMake,
                         String txtFldAsstHDModel,
                         String txtFldAsstHDSerlNo,
                         String txtFldAsstHDMACId,
                         String txtFldAsstHDAllotTo,
                         String txtFldAsstHDOperSys,
                         String txtFldAsstHDOperSysver,
                         String txtFldAsstHDProssr,
                         String txtFldAsstHDProssrSpd,
                         String txtFldAsstHDRAM,
                         String txtFldAsstHDD,
                         String txtFldAsstHDDPartitions,
                         String txtFldAsstHDLocID,
                         String txtFldAsstHDRmks,
                         String txtFldAsstHDCrtdUser,
                         Date txtFldAsstHDCrtdDate,
                         String txtFldAsstHDMdfyUser,
                         Date txtFldAsstHDMdfyDate,
                         String txtFldAsstHDPartNo,
                         String txtFldAsstHDCateg,
                         String txtFldAsstHDStatus,
                         Date txtFldAsstHDPurchaseDate,
                         Date txtFldAsstHDWarrantyStartDate,
                         Date txtFldAsstHDWarrantyEndDate,
                         String txtFldAsstHDWarrantyStatusDescription,
                         String txtFldAsstHDCpuSockets,
                         String txtFldAsstHDTotCores,
                         String txtFldAsstHDLogProcess,
                         String txtFldAsstHDServCatg,
                         String txtFldAsstHDIPNo)
	{
		
		this.txtFldAsstHDId = txtFldAsstHDId;
//		this.txtFldAsstHDAssdName = txtFldAsstHDAssdName;
		this.txtFldAsstHDName = txtFldAsstHDName;
		this.txtFldAsstHDMake = txtFldAsstHDMake;
		this.txtFldAsstHDModel = txtFldAsstHDModel;
		this.txtFldAsstHDSerlNo = txtFldAsstHDSerlNo;
		this.txtFldAsstHDMACId = txtFldAsstHDMACId;
		this.txtFldAsstHDAllotTo = txtFldAsstHDAllotTo;
		this.txtFldAsstHDOperSys = txtFldAsstHDOperSys;
		this.txtFldAsstHDOperSysver = txtFldAsstHDOperSysver;
		this.txtFldAsstHDProssr = txtFldAsstHDProssr;
		this.txtFldAsstHDProssrSpd = txtFldAsstHDProssrSpd;
		this.txtFldAsstHDRAM = txtFldAsstHDRAM;
		this.txtFldAsstHDD = txtFldAsstHDD;
		this.txtFldAsstHDDPartitions= txtFldAsstHDDPartitions;
		this.txtFldAsstHDLocID = txtFldAsstHDLocID;
		this.txtFldAsstHDRmks = txtFldAsstHDRmks;
		this.txtFldAsstHDCrtdUser = txtFldAsstHDCrtdUser;
		this.txtFldAsstHDCrtdDate = txtFldAsstHDCrtdDate;
		this.txtFldAsstHDMdfyUser = txtFldAsstHDMdfyUser;
		this.txtFldAsstHDMdfyDate = txtFldAsstHDMdfyDate;
		this.txtFldAsstHDPartNo = txtFldAsstHDPartNo;
		this.txtFldAsstHDCateg = txtFldAsstHDCateg;
		this.txtFldAsstHDStatus = txtFldAsstHDStatus;
		this.txtFldAsstHDPurchaseDate = txtFldAsstHDPurchaseDate;
		this.txtFldAsstHDWarrantyStartDate = txtFldAsstHDWarrantyStartDate;
		this.txtFldAsstHDWarrantyEndDate = txtFldAsstHDWarrantyEndDate;
	
		this.txtFldAsstHDWarrantyStatusDescription = txtFldAsstHDWarrantyStatusDescription;
		this.txtFldAsstHDCpuSockets = txtFldAsstHDCpuSockets;
		this.txtFldAsstHDTotCores = txtFldAsstHDTotCores;
		this.txtFldAsstHDLogProcess = txtFldAsstHDLogProcess;
		this.txtFldAsstHDServCatg = txtFldAsstHDServCatg;
		this.txtFldAsstHDIPNo = txtFldAsstHDIPNo;
		
	}//end of constructor
	
	public String getTxtFldAsstHDId()
	{
		return this.txtFldAsstHDId;
	}//end of getTxtFldAsstHDId
	
	public void setTxtFldAsstHDId(String txtFldAsstHDId)
	{
		this.txtFldAsstHDId = txtFldAsstHDId;
	}//end of setTxtFldAsstHDId
	
	
//	public String getTxtFldAsstHDAssdName()
//	{
//		return this.txtFldAsstHDAssdName;
//	}//end of getTxtFldAsstHDAssdName

//	public void setTxtFldAsstHDAssdName(String txtFldAsstHDAssdName)
//	{
//		this.txtFldAsstHDAssdName = txtFldAsstHDAssdName;
//	}//end of setTxtFldAsstHDAssdName
	
	public String getTxtFldAsstHDName()
	{
		return this.txtFldAsstHDName;
	}//end of getTxtFldAsstHDName
	
	public void setTxtFldAsstHDName(String txtFldAsstHDName)
	{
		this.txtFldAsstHDName = txtFldAsstHDName;
	}//end of setTxtFldAsstHDName
	
	public String getTxtFldAsstHDMake()
	{
		return this.txtFldAsstHDMake;
	}//end of getTxtFldAsstHDMake
	
	public void setTxtFldAsstHDMake(String txtFldAsstHDMake)
	{
		this.txtFldAsstHDMake = txtFldAsstHDMake;
	}//end of setTxtFldAsstHDMake
	
	public String getTxtFldAsstHDModel()
	{
		return this.txtFldAsstHDModel;
	}//end of getTxtFldAsstHDModel
	
	public void setTxtFldAsstHDModel(String txtFldAsstHDModel)
	{
		this.txtFldAsstHDModel = txtFldAsstHDModel;
	}//end of setTxtFldAsstHDModel
	
	public String getTxtFldAsstHDSerlNo()
	{
		return this.txtFldAsstHDSerlNo;
	}//end of getTxtFldAsstHDSerlNo
	
	public void setTxtFldAsstHDSerlNo(String txtFldAsstHDSerlNo)
	{
		this.txtFldAsstHDSerlNo = txtFldAsstHDSerlNo;
	}//end of setTxtFldAsstHDSerlNo
	
	public String getTxtFldAsstHDMACId()
	{
		return this.txtFldAsstHDMACId;
	}//end of getTxtFldAsstHDMACId
	
	public void setTxtFldAsstHDMACId(String txtFldAsstHDMACId)
	{
		this.txtFldAsstHDMACId = txtFldAsstHDMACId;
	}//end of setTxtFldAsstHDMACId
	
	public String getTxtFldAsstHDAllotTo()
	{
		return this.txtFldAsstHDAllotTo;
	}//end of getTxtFldAsstHDAllotTo
	
	public void setTxtFldAsstHDAllotTo(String txtFldAsstHDAllotTo)
	{
		this.txtFldAsstHDAllotTo = txtFldAsstHDAllotTo;
	}//end of setTxtFldAsstHDAllotTo
	
	
	public String getTxtFldAsstHDOperSys()
	{
		return this.txtFldAsstHDOperSys;
	}//end of getTxtFldAsstHDOperSys
	
	public void setTxtFldAsstHDOperSys(String txtFldAsstHDOperSys)
	{
		this.txtFldAsstHDOperSys = txtFldAsstHDOperSys;
	}//end of setTxtFldAsstHDOperSys
	
	public String getTxtFldAsstHDOperSysver()
	{
		return this.txtFldAsstHDOperSysver;
	}//end of getTxtFldAsstHDOperSys
	
	public void setTxtFldAsstHDOperSysver(String txtFldAsstHDOperSysver)
	{
		this.txtFldAsstHDOperSysver = txtFldAsstHDOperSysver;
	}//end of setTxtFldAsstHDOperSys
	
	public String getTxtFldAsstHDProssr()
	{
		return this.txtFldAsstHDProssr;
	}//end of getTxtFldAsstHDProssr
	
	public void setTxtFldAsstHDProssr(String txtFldAsstHDProssr)
	{
		this.txtFldAsstHDProssr = txtFldAsstHDProssr;
	}//end of setTxtFldAsstHDProssr
	
	public String getTxtFldAsstHDProssrSpd()
	{
		return this.txtFldAsstHDProssrSpd;
	}//end of getTxtFldAsstHDProssrSpd
	
	public void setTxtFldAsstHDProssrSpd(String txtFldAsstHDProssrSpd)
	{
		this.txtFldAsstHDProssrSpd = txtFldAsstHDProssrSpd;
	}//end of setTxtFldAsstHDProssrSpd
	
	public String getTxtFldAsstHDRAM()
	{
		return this.txtFldAsstHDRAM;
	}//end of getTxtFldAsstHDRAM
	
	public void setTxtFldAsstHDRAM(String txtFldAsstHDRAM)
	{
		this.txtFldAsstHDRAM = txtFldAsstHDRAM;
	}//end of setTxtFldAsstHDRAM
	
	public String getTxtFldAsstHDD()
	{
		return this.txtFldAsstHDD;
	}//end of getTxtFldAsstHDD
	
	public void setTxtFldAsstHDD(String txtFldAsstHDD)
	{
		this.txtFldAsstHDD = txtFldAsstHDD;
	}//end of setTxtFldAsstHDD
	
	public String getTxtFldAsstHDDPartitions()
	{
		return this.txtFldAsstHDDPartitions;
	}//end of getTxtFldAsstHDDPartitions
	
	public void setTxtFldAsstHDDPartitions(String txtFldAsstHDDPartitions)
	{
		this.txtFldAsstHDDPartitions = txtFldAsstHDDPartitions;
	}//end of setTxtFldAsstHDDPartitions
	
	public String getTxtFldAsstHDLocID()
	{
		return this.txtFldAsstHDLocID;
	}//end of getTxtFldAsstHDLocID
	
	public void setTxtFldAsstHDLocID(String txtFldAsstHDLocID)
	{
		this.txtFldAsstHDLocID = txtFldAsstHDLocID;
	}//end of setTxtFldAsstHDLocID
	
	public String getTxtFldAsstHDRmks()
	{
		return this.txtFldAsstHDRmks;
	}//end of getTxtFldAsstHDRmks
	
	public void setTxtFldAsstHDRmks(String txtFldAsstHDRmks)
	{
		this.txtFldAsstHDRmks = txtFldAsstHDRmks;
	}//end of setTxtFldAsstHDRmks
	
	public String getTxtFldAsstHDCrtdUser()
	{
		return this.txtFldAsstHDCrtdUser;
	}//end of getTxtFldAsstHDCrtdUser

	public void setTxtFldAsstHDCrtdUser(String txtFldAsstHDCrtdUser)
	{
		 this.txtFldAsstHDCrtdUser = txtFldAsstHDCrtdUser;
	}//end of setTxtFldAsstHDCrtdUser
	
	public Date getTxtFldAsstHDCrtdDate()
	{
		return this.txtFldAsstHDCrtdDate;
	}//end of getTxtFldAsstHDCrtdDate
	
	public void setTxtFldAsstHDCrtdDate(Date txtFldAsstHDCrtdDate)
	{
		this.txtFldAsstHDCrtdDate = txtFldAsstHDCrtdDate;
	}//end of setTxtFldAsstHDCrtdDate
	
	public String getTxtFldAsstHDMdfyUser()
	{
		return this.txtFldAsstHDMdfyUser;
	}//end of getTxtFldAsstHDMdfyUser
	
	public void setTxtFldAsstHDMdfyUser(String txtFldAsstHDMdfyUser)
	{
		this.txtFldAsstHDMdfyUser = txtFldAsstHDMdfyUser;
	}//end of setTxtFldAsstHDMdfyUser
	
	public Date getTxtFldAsstHDMdfyDate()
	{
		return this.txtFldAsstHDMdfyDate;
	}//end of getTxtFldAsstHDMdfyDate
	
	public void setTxtFldAsstHDMdfyDate(Date txtFldAsstHDMdfyDate)
	{
		this.txtFldAsstHDMdfyDate = txtFldAsstHDMdfyDate;
	}//end of setTxtFldAsstHDMdfyDate
	
	public String getTxtFldAsstHDPartNo()
	{
		return this.txtFldAsstHDPartNo;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDPartNo(String txtFldAsstHDPartNo)
	{
		this.txtFldAsstHDPartNo = txtFldAsstHDPartNo;
	}//end of setTxtFldAsstHDPartNo
	
	public String getTxtFldAsstHDCateg()
	{
		return this.txtFldAsstHDCateg;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDCateg(String txtFldAsstHDCateg)
	{
		this.txtFldAsstHDCateg = txtFldAsstHDCateg;
	}
	
	public String getTxtFldAsstHDStatus()
	{
		return this.txtFldAsstHDStatus;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDStatus(String txtFldAsstHDStatus)
	{
		this.txtFldAsstHDStatus = txtFldAsstHDStatus;
	}
	public Date getTxtFldAsstHDPurchaseDate()
	{
		return this.txtFldAsstHDPurchaseDate;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDPurchaseDate(Date txtFldAsstHDPurchaseDate)
	{
		this.txtFldAsstHDPurchaseDate = txtFldAsstHDPurchaseDate;
	}
	public Date getTxtFldAsstHDWarrantyStartDate()
	{
		return this.txtFldAsstHDWarrantyStartDate;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDWarrantyStartDate(Date txtFldAsstHDWarrantyStartDate)
	{
		this.txtFldAsstHDWarrantyStartDate = txtFldAsstHDWarrantyStartDate;
	}
	public Date getTxtFldAsstHDWarrantyEndDate()
	{
		return this.txtFldAsstHDWarrantyEndDate;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDWarrantyEndDate(Date txtFldAsstHDWarrantyEndDate)
	{
		this.txtFldAsstHDWarrantyEndDate = txtFldAsstHDWarrantyEndDate;
	}
	
	
	public String getTxtFldAsstHDWarrantyStatusDescription()
	{
		return this.txtFldAsstHDWarrantyStatusDescription;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDWarrantyStatusDescription(String txtFldAsstHDWarrantyStatusDescription)
	{
		this.txtFldAsstHDWarrantyStatusDescription = txtFldAsstHDWarrantyStatusDescription;
	}
	public String getTxtFldAsstHDCpuSockets()
	{
		return this.txtFldAsstHDCpuSockets;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDCpuSockets(String txtFldAsstHDCpuSockets)
	{
		this.txtFldAsstHDCpuSockets = txtFldAsstHDCpuSockets;
	}
	public String getTxtFldAsstHDTotCores()
	{
		return this.txtFldAsstHDTotCores;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDTotCores(String txtFldAsstHDTotCores)
	{
		this.txtFldAsstHDTotCores = txtFldAsstHDTotCores;
	}
	public String getTxtFldAsstHDLogProcess()
	{
		return this.txtFldAsstHDLogProcess;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDLogProcess(String txtFldAsstHDLogProcess)
	{
		this.txtFldAsstHDLogProcess = txtFldAsstHDLogProcess;
	}
	public String getTxtFldAsstHDServCatg()
	{
		return this.txtFldAsstHDServCatg;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDServCatg(String txtFldAsstHDServCatg)
	{
		this.txtFldAsstHDServCatg = txtFldAsstHDServCatg;
	}
	public String getTxtFldAsstHDIPNo()
	{
		return this.txtFldAsstHDIPNo;
	}//end of getTxtFldAsstHDPartNo
	
	public void setTxtFldAsstHDIPNo(String txtFldAsstHDIPNo)
	{
		this.txtFldAsstHDIPNo = txtFldAsstHDIPNo;
	}
}//end of AssetHardware
