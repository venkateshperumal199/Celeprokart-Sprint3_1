package com.junittestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

public class SetPriceFalse {

	@Test
	public void test() {
		
		ProductBean bean = new ProductBean();
		ProductDAO productDAO = new ProductDAO();
		try{
			
			bean.setProduct_name("Product1");
			assertEquals(1, productDAO.updateProduct(bean));

			productDAO.con.rollback();
			productDAO.con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		
	}

}
