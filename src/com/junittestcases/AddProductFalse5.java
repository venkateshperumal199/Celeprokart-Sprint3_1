package com.junittestcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.celeprokart.bean.*;
import com.celeprokart.DAO.*;

public class AddProductFalse5 {

	@Test
	public void test() {
		ProductBean bean = new ProductBean();
		ProductDAO productDAO = new ProductDAO();
		try{
			
			bean.setProduct_name("Product25");
			bean.setCategory("Sports");
			bean.setCharity("mockCharity");
			bean.setPrice("20");
			
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
