package com.junittestcases;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

import java.sql.*;

public class AddProductTrue {

	@Test
	public void test() throws SQLException
	{
		ProductBean bean = new ProductBean();
		ProductDAO productDAO = new ProductDAO();
		try{
			
			bean.setProduct_name("Product25");
			bean.setCategory("Sports");
			bean.setCharity("mockCharity");
			bean.setPrice("20");
			bean.setImage("NULL");
			bean.setCelebrity("Roger");
			bean.setSellordonate("SELL");
			
			productDAO.addProduct(bean);

			productDAO.con.rollback();
			productDAO.con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
