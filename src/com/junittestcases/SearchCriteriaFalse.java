package com.junittestcases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.celeprokart.DAO.AdminHomePageDAO;
import com.celeprokart.DAO.ConnectionProvider;
import com.celeprokart.bean.ProductBean;

public class SearchCriteriaFalse {

	@Test
	public void test() 
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
		
		ArrayList<ProductBean> listCelebrities = adminDao.searchCelebrities("anushareddy.2912@gmail.com");
		
		assertEquals(listCelebrities.get(0).getProduct_name(), "Cap");
}

}
