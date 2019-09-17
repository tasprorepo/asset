package com.asset.service;

import java.util.List;

import com.asset.db.*;
import com.asset.modal.AssetLogin;
import com.asset.modal.AssetSoftware;

public class LoginService
{
    public List<AssetLogin> assetLoginDetailsSrchQry( String srchQry) 
    { 
		LoginDB imp =  new LoginDB();
		
		return imp.assetLoginDetailsSrchQry(srchQry);
	}//end of assetLoginDetailsSrchQry
    
}//end of LoginSerive
