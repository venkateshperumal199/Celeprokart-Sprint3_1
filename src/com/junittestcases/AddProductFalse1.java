package com.junittestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

public class AddProductFalse1 {

	@Test
	public void test() 
	{
		ProductBean bean = new ProductBean();
		ProductDAO productDAO = new ProductDAO();
		
		try{
			
			bean.setCategory("Sports");
			bean.setCharity("mockCharity");
			bean.setPrice("20");
			bean.setImage("NULL");
			bean.setCelebrity("Roger");
			bean.setSellordonate("SELL");
			
			assertEquals(1, productDAO.addProduct(bean));

			productDAO.con.rollback();
			productDAO.con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
