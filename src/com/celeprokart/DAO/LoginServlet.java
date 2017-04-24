package com.celeprokart.DAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.celeprokart.bean.CustomerBean;
import com.celeprokart.bean.SignUpCelebrityBean;
import com.celeprokart.bean.LoginBean;
import com.celeprokart.bean.AdminBean;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		HttpSession session=req.getSession();
//		LoginBean bean = new LoginBean();
//		AdminBean beanAdmin = new AdminBean();
//		SignUpCelebrityBean beanCelebrity;
//		CustomerBean beanCustomer;
//		bean.setEmail(req.getParameter("email"));
//		bean.setPass(req.getParameter("pass"));
//		
//		LoginDao loginDao = new LoginDao();
//		
//	beanAdmin = loginDao.validate(bean);
//	beanCelebrity = loginDao.validateCeleb(bean);
//	beanCustomer = loginDao.validateCust(bean);
//	
//	if(beanAdmin != null)
//		{
//			session.setAttribute("Login", bean);
//			req.getRequestDispatcher("adminHomeProcess.jsp").forward(req, resp);
//		}
//		else if(beanCelebrity != null)
//		{
//			session.setAttribute("Celebrity", beanCelebrity);
//			req.getRequestDispatcher("celebrityhomepage.jsp").forward(req, resp);
//			
//		}
//		else if(beanCustomer !=null)
//		{
//			session.setAttribute("Customer", beanCustomer);
//			req.getRequestDispatcher("customerHomePage.jsp").forward(req, resp);
//		}		
//		else{
//			System.out.println("Invalid credentails");
//		}
	}	
	
}
