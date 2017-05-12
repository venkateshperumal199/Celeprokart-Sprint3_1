package com.junittestcases;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.mockito.Mockito;

import com.celeprokart.DAO.AddCharityDAO;
import com.celeprokart.DAO.ConnectionProvider;
import com.celeprokart.bean.AddCharityBean;

public class UpdateCharityFalse {

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
		
		AddCharityDAO dao = new AddCharityDAO(connectionProvider);
		
		dao.updateCharity(null, null, null, null, null, null);
		
		AddCharityBean bean = dao.searchCharity("Charity1");

//		assertEquals(bean.getPhoneNo(), 9803392688L);
		assertEquals(bean.getEmailID(), null);
//		assertEquals(bean.getZipcode(), 28262L);
	
		
		
	}

}
