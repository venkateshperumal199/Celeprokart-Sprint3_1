package com.junittestcases;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.celeprokart.DAO.AddCharityDAO;
import com.celeprokart.bean.AddCharityBean;

public class UpdateCharityTrue  {

	@Test
	public void test() throws SQLException{
		AddCharityBean bean = new AddCharityBean();
		AddCharityDAO dao = new AddCharityDAO();
		bean.setName("charity6");
		bean.setAddress("Charlotte NC");
		bean.setEmailID("asumathireddy@gmail.com");
	
		bean.setZipcode(28262);
		
		assertTrue(AddCharityDAO.addCharity(bean));
		
		AddCharityDAO.con.rollback();
		AddCharityDAO.con.close();

	}

}
