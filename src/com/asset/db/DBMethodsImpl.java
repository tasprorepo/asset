package com.asset.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DBMethodsImpl implements DBMethods 
{

	@Autowired
	private SessionFactory sessionFactory;
 
	@SuppressWarnings("unchecked")
	@Override
	public List srchObj(String srchQry)
	{
		Session session = null;
 
		try 
		{
			session = sessionFactory.openSession();
			Query sqlQry = session.createQuery(srchQry); 
			return sqlQry.list();
		} //end of try
		
		catch (HibernateException hibExp) 
		{ 
			hibExp.printStackTrace();
			return null;
		} //end of catch
		
		finally 
		{
			session.flush();
			session.clear();
			session.close();
		}//end of finally
	
	}//end of srchObj


	@Override
	public void saveObjs(Object obj)
	{

		Session session = null;
		try 
		{
        	session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit(); 
		}//end of try 
		
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}//end of catch
		
		finally 
		{
			session.flush();
			session.clear();
			session.close();

		}//end of finally

	}// end of saveObjs

	@Override
	public void updateObjs(Object obj) 
	{

		Session session = null;
		try 
		{
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(obj);
			tx.commit(); 
        } // end of try
		
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}// end of catch
		
		finally 
		{
			session.flush();
			session.clear();
			session.close();
     	}//end of finally

	}//end of updateObjs

	@Override
	public void deleteObjs(Object obj)
	{

		Session session = null;
		try
		{
        	session = sessionFactory.openSession();			
			session.delete(obj); 

		}//end of try 
		
		catch (Exception ex)
		{
			ex.printStackTrace();
		} //end of catch
		
		finally
		{
			session.flush();
			session.clear();
			session.close();
        }//end of finally

	}//end of deleteObjs


	@Override
	public List nativeSql(String qryobj) {
		Session session = null;
		 
		try 
		{
			session = sessionFactory.openSession();
			SQLQuery sqlQry = session.createSQLQuery(qryobj); 
			return sqlQry.list();
		} //end of try
		
		catch (HibernateException hibExp) 
		{ 
			hibExp.printStackTrace();
			return null;
		} //end of catch
		
		finally 
		{
			session.flush();
			session.clear();
			session.close();
		}//end of finally
		
	}
	
	@Override
	public void attachSql(String qryobj) {
		Session session = null;
		 
		try 
		{ 
			session = sessionFactory.openSession(); 
		SQLQuery querry = session.createSQLQuery(qryobj);
		querry.executeUpdate();
		 
		} //end of try
		
		catch (Exception hibExp) 
		{ 
			hibExp.printStackTrace();
			
		} //end of catch
		
		finally 
		{
			session.flush();
			session.clear();
			session.close();
		}//end of finally
		
	}
	

	public String AssetAttachmntQry(String maxCustAttchQry) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public ResultSet downloadBFILEServ(String srchQuery,WebApplicationContext context) { 
		Session session = null;
		ResultSet result = null;
		DriverManagerDataSource dm =null;
		try { 
//			ServletContext ctx = getServletContext();
//			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 dm =(DriverManagerDataSource)context.getBean("dataSource"); 
			Connection conn =  DriverManager.getConnection(dm.getUrl(),dm.getUsername(),dm.getPassword());	
		    Statement stmt = conn.createStatement();
			
			result = stmt.executeQuery(srchQuery); 
		} catch (Exception e) {
			e.printStackTrace();
		 
		} finally {
			//session.close();
		}
		return result;
	} 
	
	
	/** Method used for Checking DB Socket Connection */
	public Date ChkValidDB(String qryObj) {
	//	fplog.info("Inside Valid DB DTO Class Obj " + qryObj);
		Date dateObj = null;
		Session session =  sessionFactory.openSession();
		try {
			Query query = session.createSQLQuery(qryObj.toString());
			dateObj = (Date) query.uniqueResult(); 			
		} catch (Exception e) {
		 
			throw new HibernateException(
					"Error!! Unable to fetch your record(S) !!");
		}finally{
			
			session.clear();
			session.close();
		}
		return dateObj;
	}
	
	@SuppressWarnings("deprecation")
	public ResultSet downloadBFILE(String srchQuery) { 
		Session session = null;
		ResultSet result = null;
		DriverManagerDataSource dm =null;
		try { 
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 dm =(DriverManagerDataSource)context.getBean("dataSource"); 
			Connection conn =  DriverManager.getConnection(dm.getUrl(),dm.getUsername(),dm.getPassword());	
		    Statement stmt = conn.createStatement();
		 
			result = stmt.executeQuery(srchQuery); 
		} catch (Exception e) {
			e.printStackTrace();
		 
		} finally {
			//session.close();
		}
		return result;
	} 
	
}//end of DBMethodsImpl
