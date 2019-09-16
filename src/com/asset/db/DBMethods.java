package com.asset.db;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public interface DBMethods 
{
	
	public void saveObjs(Object obj);
	public void updateObjs(Object obj);
	public List srchObj(String filterQry) ;
	public void deleteObjs(Object obj) ;
	public List nativeSql(String  qryobj) ;
	public void attachSql(String qryobj);	
	public ResultSet downloadBFILE(String srchQuery); 
	public Date ChkValidDB(String qryObj);
}//end of DBMethods
