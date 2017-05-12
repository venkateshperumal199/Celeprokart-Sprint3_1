package com.junittestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

public class SetPriceFalse {

	@Test
	public void test() {
		
		ProductBean bean = new ProductBean();
		try{
			
			bean.setProduct_name("Product1");
			assertEquals(1, ProductDAO.updateProduct(bean));

			ProductDAO.con.rollback();
			ProductDAO.con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		
	}

}
