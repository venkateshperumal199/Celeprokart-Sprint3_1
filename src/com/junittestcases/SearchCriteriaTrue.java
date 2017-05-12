package com.junittestcases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.celeprokart.DAO.AddCharityDAO;
import com.celeprokart.DAO.AdminHomePageDAO;
import com.celeprokart.DAO.ConnectionProvider;
import com.celeprokart.DAO.SignUpCelebrityDao;
import com.celeprokart.bean.*;

public class SearchCriteriaTrue {

	@Test
	public void test() throws SQLException 
	{
		Connection con = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ssdiMock","SYSTEM","MockDatabase29");  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ConnectionProvider connectionProvider = Mockito.mock(ConnectionProvider.class);	
		Mockito.when(connectionProvider.getCon()).thenReturn(con);
		
		AdminHomePageDAO adminDao = new AdminHomePageDAO();
		
		ArrayList<ProductBean> listCelebrities = adminDao.searchCelebrities("anushareddy.amula@gmail.com");
		
		assertEquals(listCelebrities.get(0).getProduct_name(), "Cap");

	}

}
