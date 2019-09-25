<<<<<<< HEAD
package com.asset.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ASSET_SERVICE_TRACK")//ServiceTracking Table name changed and assign Fields
public class ServiceTracker implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SERV_TRACK_ID")
	private String txtFldServiceId;
	
	@Column(name="HARDWARE_ID")
	private String txtFldHDID;
	
	@Column(name="SOFTWARE_ID")
	private String txtFldSWID;
	
	@Column(name="VENDOR_ID")
	private String txtFldVDID;
	
	@Column(name="SERV_REQUEST")
	private String txtFldServiceRequest;
	
	@Column(name="SERV_REQ_DATE")
	private Date txtFldServiceDate;
	
	@Column(name="REMARKS")
	private String txtFldRemarks;
	
	@Column(name="CREATED_BY")
	private String txtFldServiceCrtdUser;
	
	@Column(name="CREATED_DATE")
	private Date txtFldServiceCrtdDate;
	
	@Column(name="MODIFIED_BY")
	private String txtFldServiceMdfyUser;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldServicedMdfyDate;
	

	
	public ServiceTracker(String txtFldServiceId, String txtFldHDID, String txtFldSWID, 
			String txtFldVDID, String txtFldServiceRequest, Date txtFldServiceDate,
			String txtFldRemarks, String txtFldServiceCrtdUser, Date txtFldServiceCrtdDate,
			String txtFldServiceMdfyUser, Date txtFldServicedMdfyDate) {
		
		// TODO Auto-generated constructor stub
		this.txtFldServiceId = txtFldServiceId;
		this.txtFldHDID = txtFldHDID;
		this.txtFldSWID = txtFldSWID;
		this.txtFldVDID = txtFldVDID;
		this.txtFldServiceRequest = txtFldServiceRequest;
		this.txtFldServiceDate = txtFldServiceDate;
		this.txtFldRemarks = txtFldRemarks;
		this.txtFldServiceCrtdUser = txtFldServiceCrtdUser;
		this.txtFldServiceCrtdDate = txtFldServiceCrtdDate;
		this.txtFldServiceMdfyUser = txtFldServiceMdfyUser;
		this.txtFldServicedMdfyDate = txtFldServicedMdfyDate;
		
	}//end of ServiceTracker constructor


	public ServiceTracker() {
		// TODO Auto-generated constructor stub
	}// end of the Service Tracker constructor


	//getter & setter methods
	public String getTxtFldServiceId() {
		return txtFldServiceId;
	}//end of getTxtFldServiceId



	public void setTxtFldServiceId(String txtFldServiceId) {
		this.txtFldServiceId = txtFldServiceId;
	}//end of settxtFldServiceId



	public String getTxtFldHDID() {
		return txtFldHDID;
	}//end of getTxtFldHDID



	public void setTxtFldHDID(String txtFldHDID) {
		this.txtFldHDID = txtFldHDID;
	}//end of setTxtFldHDID



	public String getTxtFldSWID() {
		return txtFldSWID;
	}//end of getTxtFldSWID



	public void setTxtFldSWID(String txtFldSWID) {
		this.txtFldSWID = txtFldSWID;
	}//end of setTxtFldSWID



	public String getTxtFldVDID() {
		return txtFldVDID;
	}//end of getTxtFldVDID



	public void setTxtFldVDID(String txtFldVDID) {
		this.txtFldVDID = txtFldVDID;
	}//end of setTxtFldVDID



	public String getTxtFldServiceRequest() {
		return txtFldServiceRequest;
	}//end of getTxtFldServiceRequest



	public void setTxtFldServiceRequest(String txtFldServiceRequest) {
		this.txtFldServiceRequest = txtFldServiceRequest;
	}//end of setTxtFldServiceRequest



	public Date getTxtFldServiceDate() {
		return txtFldServiceDate;
	}//end of getTxtFldServiceDate



	public void setTxtFldServiceDate(Date txtFldServiceDate) {
		this.txtFldServiceDate = txtFldServiceDate;
	}//end of setTxtFldServiceDate



	public String getTxtFldRemarks() {
		return txtFldRemarks;
	}//end of getTxtFldRemarks



	public void setTxtFldRemarks(String txtFldRemarks) {
		this.txtFldRemarks = txtFldRemarks;
	}//end of setTxtFldRemarks



	public String getTxtFldServiceCrtdUser() {
		return txtFldServiceCrtdUser;
	}//end of getTxtFldServiceCrtdUser



	public void setTxtFldServiceCrtdUser(String txtFldServiceCrtdUser) {
		this.txtFldServiceCrtdUser = txtFldServiceCrtdUser;
	}//end of setTxtFldServiceCrtdUser



	public Date getTxtFldServiceCrtdDate() {
		return txtFldServiceCrtdDate;
	}//end of getTxtFldServiceCrtdDate



	public void setTxtFldServiceCrtdDate(Date txtFldServiceCrtdDate) {
		this.txtFldServiceCrtdDate = txtFldServiceCrtdDate;
	}//end of setTxtFldServiceCrtdDate



	public String getTxtFldServiceMdfyUser() {
		return txtFldServiceMdfyUser;
	}//end of getTxtFldServiceMdfyUser



	public void setTxtFldServiceMdfyUser(String txtFldServiceMdfyUser) {
		this.txtFldServiceMdfyUser = txtFldServiceMdfyUser;
	}//end of setTxtFldServiceMdfyUser



	public Date getTxtFldServicedMdfyDate() {
		return txtFldServicedMdfyDate;
	}//end of getTxtFldServiceMdfyDate



	public void setTxtFldServicedMdfyDate(Date txtFldServicedMdfyDate) {
		this.txtFldServicedMdfyDate = txtFldServicedMdfyDate;
	}//end of setTxtFldServiceMdfyDate



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
=======
package com.asset.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ASSET_SERVICE_TRACK")//ServiceTracking Table name changed and assign Fields
public class ServiceTracker implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SERV_TRACK_ID")
	private String txtFldServiceId;
	
	@Column(name="HARDWARE_ID")
	private String txtFldHDID;
	
	@Column(name="SOFTWARE_ID")
	private String txtFldSWID;
	
	@Column(name="VENDOR_ID")
	private String txtFldVDID;
	
	@Column(name="SERV_REQUEST")
	private String txtFldServiceRequest;
	
	@Column(name="SERV_REQ_DATE")
	private Date txtFldServiceDate;
	
	@Column(name="REMARKS")
	private String txtFldRemarks;
	
	@Column(name="CREATED_BY")
	private String txtFldServiceCrtdUser;
	
	@Column(name="CREATED_DATE")
	private Date txtFldServiceCrtdDate;
	
	@Column(name="MODIFIED_BY")
	private String txtFldServiceMdfyUser;
	
	@Column(name="MODIFIED_DATE")
	private Date txtFldServicedMdfyDate;
	

	
	public ServiceTracker(String txtFldServiceId, String txtFldHDID, String txtFldSWID, 
			String txtFldVDID, String txtFldServiceRequest, Date txtFldServiceDate,
			String txtFldRemarks, String txtFldServiceCrtdUser, Date txtFldServiceCrtdDate,
			String txtFldServiceMdfyUser, Date txtFldServicedMdfyDate) {
		
		// TODO Auto-generated constructor stub
		this.txtFldServiceId = txtFldServiceId;
		this.txtFldHDID = txtFldHDID;
		this.txtFldSWID = txtFldSWID;
		this.txtFldVDID = txtFldVDID;
		this.txtFldServiceRequest = txtFldServiceRequest;
		this.txtFldServiceDate = txtFldServiceDate;
		this.txtFldRemarks = txtFldRemarks;
		this.txtFldServiceCrtdUser = txtFldServiceCrtdUser;
		this.txtFldServiceCrtdDate = txtFldServiceCrtdDate;
		this.txtFldServiceMdfyUser = txtFldServiceMdfyUser;
		this.txtFldServicedMdfyDate = txtFldServicedMdfyDate;
		
	}//end of ServiceTracker constructor


	public ServiceTracker() {
		// TODO Auto-generated constructor stub
	}// end of the Service Tracker constructor


	//getter & setter methods
	public String getTxtFldServiceId() {
		return txtFldServiceId;
	}//end of getTxtFldServiceId



	public void setTxtFldServiceId(String txtFldServiceId) {
		this.txtFldServiceId = txtFldServiceId;
	}//end of settxtFldServiceId



	public String getTxtFldHDID() {
		return txtFldHDID;
	}//end of getTxtFldHDID



	public void setTxtFldHDID(String txtFldHDID) {
		this.txtFldHDID = txtFldHDID;
	}//end of setTxtFldHDID



	public String getTxtFldSWID() {
		return txtFldSWID;
	}//end of getTxtFldSWID



	public void setTxtFldSWID(String txtFldSWID) {
		this.txtFldSWID = txtFldSWID;
	}//end of setTxtFldSWID



	public String getTxtFldVDID() {
		return txtFldVDID;
	}//end of getTxtFldVDID



	public void setTxtFldVDID(String txtFldVDID) {
		this.txtFldVDID = txtFldVDID;
	}//end of setTxtFldVDID



	public String getTxtFldServiceRequest() {
		return txtFldServiceRequest;
	}//end of getTxtFldServiceRequest



	public void setTxtFldServiceRequest(String txtFldServiceRequest) {
		this.txtFldServiceRequest = txtFldServiceRequest;
	}//end of setTxtFldServiceRequest



	public Date getTxtFldServiceDate() {
		return txtFldServiceDate;
	}//end of getTxtFldServiceDate



	public void setTxtFldServiceDate(Date txtFldServiceDate) {
		this.txtFldServiceDate = txtFldServiceDate;
	}//end of setTxtFldServiceDate



	public String getTxtFldRemarks() {
		return txtFldRemarks;
	}//end of getTxtFldRemarks



	public void setTxtFldRemarks(String txtFldRemarks) {
		this.txtFldRemarks = txtFldRemarks;
	}//end of setTxtFldRemarks



	public String getTxtFldServiceCrtdUser() {
		return txtFldServiceCrtdUser;
	}//end of getTxtFldServiceCrtdUser



	public void setTxtFldServiceCrtdUser(String txtFldServiceCrtdUser) {
		this.txtFldServiceCrtdUser = txtFldServiceCrtdUser;
	}//end of setTxtFldServiceCrtdUser



	public Date getTxtFldServiceCrtdDate() {
		return txtFldServiceCrtdDate;
	}//end of getTxtFldServiceCrtdDate



	public void setTxtFldServiceCrtdDate(Date txtFldServiceCrtdDate) {
		this.txtFldServiceCrtdDate = txtFldServiceCrtdDate;
	}//end of setTxtFldServiceCrtdDate



	public String getTxtFldServiceMdfyUser() {
		return txtFldServiceMdfyUser;
	}//end of getTxtFldServiceMdfyUser



	public void setTxtFldServiceMdfyUser(String txtFldServiceMdfyUser) {
		this.txtFldServiceMdfyUser = txtFldServiceMdfyUser;
	}//end of setTxtFldServiceMdfyUser



	public Date getTxtFldServicedMdfyDate() {
		return txtFldServicedMdfyDate;
	}//end of getTxtFldServiceMdfyDate



	public void setTxtFldServicedMdfyDate(Date txtFldServicedMdfyDate) {
		this.txtFldServicedMdfyDate = txtFldServicedMdfyDate;
	}//end of setTxtFldServiceMdfyDate



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
>>>>>>> 17092019
