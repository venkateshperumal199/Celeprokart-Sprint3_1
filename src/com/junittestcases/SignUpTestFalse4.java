package com.junittestcases;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

public class SignUpTestFalse4 {

	@Test
	public void test() throws SQLException {
	
		SignUpCelebrityDao signUpDao = new SignUpCelebrityDao();
		SignUpCelebrityBean bean = new SignUpCelebrityBean();
		try {
			//con.setAutoCommit(false);
			//Provider.CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521:ssdi";
			
			long phoneNo = 9803392688L;
			bean.setName("Tom");
			bean.setEmailID("asumathireddy@gmail.com");
			bean.setAddress("Charlotte, NC");


			bean.setPhoneNo(phoneNo);
			bean.setPassword("Venkatesh29");
			bean.setFlag("N");
			assertTrue(signUpDao.addCelebrity(bean));
		}finally
		{
			signUpDao.con.rollback();
			signUpDao.con.close();
		}

		
	}

}
