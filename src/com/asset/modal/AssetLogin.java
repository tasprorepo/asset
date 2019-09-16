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
@Table(name = "ASSET_LOGIN")

public class AssetLogin implements Serializable 
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="USER_NAME")
	private String userID;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	public AssetLogin()
	{
		
	}//end of AssetLogin constructor with no argument
	
	public AssetLogin(String userCode,String userID,String password,String accessCode,
			          String createdBy,Date createdDate,String modifiedBy,Date modifiedDate)
	{
		this.userID = userID;
		this.password = password;
	}//end of AssetLogin constructor with arguments
	
	public String getUserID()
	{
		return this.userID;
	}//end of getUserID
	
	public void setUserID(String userID)
	{
		 this.userID = userID;
	}//end of setUserID
	
	public String getPassword()
	{
		return this.password;
	}//end of getPassowrd
	
	public void setPassword(String password)
	{
		 this.password = password;
	}//end of setPassowrd
	
}//end of AssetLogin
