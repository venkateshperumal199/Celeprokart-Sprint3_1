package com.celeprokart.DAO;

import java.sql.Connection;
import com.celeprokart.bean.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminHomePageDAO{
	
	public Connection con;
	public ConnectionProvider connectionProvider = new ConnectionProvider();
	
	public ArrayList<AddCharityBean> listCharity()
	{
		ArrayList<AddCharityBean> listOfCharities=new ArrayList<>();
		try{  
			con=connectionProvider.getCon();  
			              
			PreparedStatement ps=con.prepareStatement("select * from Charity"); 		             
			ResultSet rs=ps.executeQuery(); 
			while (rs.next()) 
			{
				String name = rs.getString("name");
				AddCharityBean bean = new AddCharityBean();
				bean.setName(name);
				bean.setId(rs.getInt("id"));
				
				System.out.println(bean.getId() + "inside charity");
				listOfCharities.add(bean);
			}
			
			}catch(Exception e){
				
				e.printStackTrace();
			}  	
		
		return listOfCharities;	
	}
	
	public AdminHomePageDAO() {
		super();
	}

	public AdminHomePageDAO(ConnectionProvider connectionProvider) {
		super();
		this.connectionProvider = connectionProvider;
	}

	public ArrayList<ProductBean> searchCelebrities(String nameCeleb)
	{
		ArrayList<ProductBean> listProducts=new ArrayList<>();
		try{  
			con=connectionProvider.getCon();  			              
			PreparedStatement ps=con.prepareStatement("select * from Products where celebname = ? and flag = ?"); 
			ps.setString(1, nameCeleb);
			ps.setString(2, "Y");
			ResultSet rs=ps.executeQuery(); 
			while (rs.next()) 
			{
				String name = rs.getString("product_name");
				ProductBean bean = new ProductBean();
				bean.setProduct_name(name);
				bean.setImage(rs.getString("image"));
				bean.setPrice(rs.getString("price"));
				bean.setProduct_id(rs.getInt("product_id"));
				listProducts.add(bean);
			}
			
			}catch(Exception e){
				
				e.printStackTrace();
			}  	
		
		return listProducts;	
	}
	
	public ArrayList<SignUpCelebrityBean> listCelebrities(String loginEmailID)
	{
		ArrayList<SignUpCelebrityBean> listOfCelebrities=new ArrayList<SignUpCelebrityBean>();
		try{  
			con=connectionProvider.getCon();  
			              
			PreparedStatement ps=con.prepareStatement("select * from Celebrity"); 		             
			ResultSet rs=ps.executeQuery(); 
			while (rs.next()) 
			{
				String emailID = rs.getString("email_ID");
				SignUpCelebrityBean bean = new SignUpCelebrityBean();
				if(!(emailID.equalsIgnoreCase(loginEmailID)))
				{
					bean.setEmailID(rs.getString("email_ID"));
					bean.setName(rs.getString("name"));
					bean.setId(rs.getInt("ID"));
					listOfCelebrities.add(bean);
				}
				
				System.out.println("id is" + bean.getId());		
				
			}
			
			}catch(Exception e){
				
				e.printStackTrace();
			}  	
		
		return listOfCelebrities;	
	
	}
	
	public ArrayList<SignUpCelebrityBean> listAdminCelebrities()
	{
		ArrayList<SignUpCelebrityBean> listOfCelebrities=new ArrayList<SignUpCelebrityBean>();
		try{  
			con=connectionProvider.getCon();  
			              
			PreparedStatement ps=con.prepareStatement("select * from Celebrity"); 		             
			ResultSet rs=ps.executeQuery(); 
			while (rs.next()) 
			{
				String emailID = rs.getString("email_ID");
				SignUpCelebrityBean bean = new SignUpCelebrityBean();
					bean.setEmailID(rs.getString("email_ID"));
					bean.setName(rs.getString("name"));
					bean.setId(rs.getInt("ID"));
					listOfCelebrities.add(bean);
				
				System.out.println("id is" + bean.getId());		
				
			}
			
			}catch(Exception e){
				
				e.printStackTrace();
			}  	
		
		return listOfCelebrities;	
	
	}
	
	
	public ArrayList<ProductBean> listVerifiedProducts(String loginEmailID)
	{
		ArrayList<ProductBean> listOfProducts=new ArrayList<>();
		try{  
			con=connectionProvider.getCon();  
			              
			PreparedStatement ps=con.prepareStatement("select * from Products where flag = ?"); 	
			ps.setString(1, "Y");
			
			ResultSet rs=ps.executeQuery(); 
			while (rs.next()) 
			{
				String name = rs.getString("PRODUCT_NAME");
				String celebrity = rs.getString("celebrityname");
				ProductBean bean = new ProductBean();
				if(!(celebrity.equalsIgnoreCase(loginEmailID)))
				{
				bean.setProduct_name(name);
				bean.setCelebrity(celebrity);
				bean.setCharity(rs.getString("charity"));
				bean.setImage(rs.getString("image"));
				bean.setPrice(rs.getString("price"));
				bean.setSellordonate(rs.getString("sellordonate"));
				bean.setCategory(rs.getString("category"));
				bean.setProduct_id(rs.getInt("product_id"));
				bean.setCelebName(rs.getString("celebname"));
				
System.out.println("cleebirty name" + bean.getCelebName());
				
				listOfProducts.add(bean);
				}
			}
			
			}catch(Exception e){
				
				e.printStackTrace();
			}  	
		
		return listOfProducts;	
	
	}

	public ArrayList<ProductBean> listProducts()
	{
		ArrayList<ProductBean> listOfProducts=new ArrayList<>();
		try{  
			con=connectionProvider.getCon();  
			              
			PreparedStatement ps=con.prepareStatement("select * from Products"); 	
			ResultSet rs=ps.executeQuery(); 
			while (rs.next()) 
			{
				String name = rs.getString("PRODUCT_NAME");
				String celebrity = rs.getString("celebrityname");
				ProductBean bean = new ProductBean();
				bean.setProduct_name(name);
				bean.setCelebrity(celebrity);
				bean.setCharity(rs.getString("charity"));
				bean.setImage(rs.getString("image"));
				bean.setPrice(rs.getString("price"));
				bean.setSellordonate(rs.getString("sellordonate"));
				bean.setCategory(rs.getString("category"));
				bean.setProduct_id(rs.getInt("product_id"));
				System.out.println(bean.getProduct_name());				
				listOfProducts.add(bean);
			}
			
			}catch(Exception e){
				
				e.printStackTrace();
			}  	
		
		return listOfProducts;	
	
	}

	
}
