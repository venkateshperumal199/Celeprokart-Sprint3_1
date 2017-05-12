package com.celeprokart.DAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.celeprokart.bean.*;

@WebServlet("/setPriceServlet")
public class SetPriceServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String price = req.getParameter("price");
		String product_name = req.getParameter("product_name");
		String id = req.getParameter("id");
		
		System.out.println(id+"inside servlet");
		
		ProductBean bean = new ProductBean();
		ProductDAO productDao = new ProductDAO();
		bean.setPrice(price);
		bean.setProduct_name(product_name);
		
		productDao.updateProduct(bean);
		
		int status=productDao.updateProduct(bean);
		
		System.out.println(status);
		   if(status>0){
			
			   req.setAttribute("Items", "Product added to Celeprokart");
			   req.getRequestDispatcher("adminHomeProcess.jsp").forward(req, resp);
		   }
		
	}
	
}
