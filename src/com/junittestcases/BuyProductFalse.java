package com.junittestcases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.mockito.Mockito;

import com.celeprokart.DAO.AddCharityDAO;
import com.celeprokart.DAO.ConnectionProvider;
import com.celeprokart.DAO.ProductDAO;
import com.celeprokart.bean.ProductBean;

public class BuyProductFalse {

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

	
		
ProductDAO dao = new ProductDAO(connectionProvider);


		
		dao.buyProduct("2");
		
		ProductBean bean = dao.searchProduct("2");
		
		assertEquals(bean.getProduct_id(), 2);

		
	}

}
