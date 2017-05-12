package com.junittestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

public class SetPriceTrue {

	@Test
	public void test() {
		ProductBean bean = new ProductBean();
		ProductDAO productDAO = new ProductDAO();
		try{
			
			
			bean.setPrice("80");
			bean.setProduct_name("Product1");
			assertEquals(0, productDAO.updateProduct(bean));

			productDAO.con.rollback();
			productDAO.con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
