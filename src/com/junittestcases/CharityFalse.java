package com.junittestcases;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

public class CharityFalse {

	@Test
	public void test() throws SQLException {
	

		AddCharityBean bean = new AddCharityBean();
		AddCharityDAO dao = new AddCharityDAO();
		bean.setName("charity6");
		bean.setAddress("Charlotte NC");
		bean.setEmailID("asumathireddy@gmail.com");
	
		bean.setZipcode(28262);
		
		assertTrue(dao.addCharity(bean));
		
		dao.con.rollback();
		dao.con.close();

		
	}

}
