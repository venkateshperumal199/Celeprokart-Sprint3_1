package com.celeprokart.DAO;

import java.sql.*;
import com.celeprokart.bean.*;

public class LoginDao {

	public Connection con;
	public ConnectionProvider connectionProvider = new ConnectionProvider();
	
	public  boolean validate(LoginBean bean)
	{  
		boolean status=false;  
		AdminBean adminBean = new AdminBean();
		try{  
			
			con = connectionProvider.getCon();
			
			PreparedStatement ps=con.prepareStatement(  
			    "select * from Admin where USERNAME=? and PASSWORD=?"); 		  
			ps.setString(1,bean.getEmail());  
			ps.setString(2, bean.getPass());               
			ResultSet rs=ps.executeQuery();  
			status=rs.next();
			System.out.println("inside admin bean"+status);
			System.out.println("inside admin bean" + bean.getEmail());
			System.out.println("inside admin bean" + bean.getPass());
			System.out.println("ID is "+rs.getInt("id"));
				adminBean.setAddress(rs.getString("address"));
				adminBean.setPassword(rs.getString("password"));
				adminBean.setPhoneNo(rs.getInt("phoneno"));
				adminBean.setUserName(rs.getString("username"));
				adminBean.setId(rs.getInt("id"));
				bean.setId(adminBean.getId());
				bean.setName(adminBean.getUserName());
				System.out.println("ID is "+rs.getInt("id"));
	
			}catch(Exception e){}  
			  
			return status;  
			  
			}
	public  boolean validateCeleb(LoginBean bean){  
		boolean status=false; 
		SignUpCelebrityBean celebrityBean = new SignUpCelebrityBean();
		try{  
			con = connectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement(  
			    "select * from Celebrity where EMAIL_ID=? and PASSWORD=?"); 		  
			ps.setString(1,bean.getEmail());  
			ps.setString(2, bean.getPass());               
			ResultSet rs=ps.executeQuery();  
			
			while(rs.next())
			{
			celebrityBean.setAddress(rs.getString("address"));
			
			System.out.println("address is " + celebrityBean.getAddress());
			
			celebrityBean.setEmailID(rs.getString("email_ID"));
			
			System.out.println("address is " + celebrityBean.getEmailID());
			celebrityBean.setFlag(rs.getString("flag"));
			
			System.out.println("address is " + celebrityBean.getFlag());
			celebrityBean.setId(rs.getInt("id"));
			
			System.out.println("address is " + celebrityBean.getId());
			celebrityBean.setName(rs.getString("name"));
			
			System.out.println("address is " + celebrityBean.getName());
			celebrityBean.setPassword(rs.getString("password"));
			System.out.println("address is " + celebrityBean.getPassword());
			
			bean.setId(rs.getInt("id"));
			bean.setName(celebrityBean.getName());
			
			System.out.println(status);
			System.out.println(bean.getEmail());
			System.out.println(bean.getPass());
			
			bean.setId(rs.getInt("id"));
			System.out.println("Celebrity logged in is" + bean.getName() + "       ");
			
			status = true;
			
			}
//			bean.setId(rs.getInt("id"));
//			bean.setName(celebrityBean.getName());
//			
//			System.out.println("Celebrity logged in is" + rs.getString("name"));
//			System.out.println("Celebrity logged in is" + rs.getString("email_ID"));

			}catch(Exception e){}  
			  
			return status;  
			  
			}
	public boolean validateCust(LoginBean bean){  
		boolean status=false;
		CustomerBean customerBean = new CustomerBean();
		try{  
			con = connectionProvider.getCon();
			              
			PreparedStatement ps=con.prepareStatement(  
			    "select * from Customer where EMAIL_ID=? and PASSWORD=?"); 		  
			ps.setString(1,bean.getEmail());  
			ps.setString(2, bean.getPass());               
			ResultSet rs=ps.executeQuery();  
			status=rs.next();
			System.out.println(status);
			System.out.println(bean.getEmail());
			System.out.println(bean.getPass());
			
			customerBean.setAddress(rs.getString("address"));
			customerBean.setEmailID(rs.getString("email_ID"));
			customerBean.setId(rs.getInt("id"));
			customerBean.setName(rs.getString("name"));
			customerBean.setPassword(rs.getString("password"));
			customerBean.setPhoneNo(rs.getInt("phone_number"));
			customerBean.setRole(rs.getString("role"));
			customerBean.setZipcode(rs.getInt("zipcode"));
			
			bean.setId(rs.getInt("id"));
			bean.setName(customerBean.getName());
			
			}catch(Exception e){
				
			}  			  
			return status;  	  
	}
}
