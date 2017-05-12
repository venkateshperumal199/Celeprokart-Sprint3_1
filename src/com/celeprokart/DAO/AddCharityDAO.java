package com.celeprokart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.celeprokart.bean.*;

public class AddCharityDAO {
	
	public Connection con;
	public ConnectionProvider connectionProvider = new ConnectionProvider();
	
	public AddCharityDAO()
	{
		
	}
	
	public AddCharityDAO(ConnectionProvider connectionProvider) {
		super();
		this.connectionProvider = connectionProvider;
	}

	public AddCharityBean searchCharity(String charity_name)
	{
		AddCharityBean charityBean=null;
		
		try{  	
			charityBean = new AddCharityBean();
			con = connectionProvider.getCon();
			
			PreparedStatement ps=con.prepareStatement(  
			    "select * from Charity where name=?"); 		  
			ps.setString(1,charity_name);  
			      
			ResultSet rs=ps.executeQuery();  
			
			while(rs.next())
			{
				charityBean = new AddCharityBean();				
				charityBean.setId(rs.getInt("id"));
				charityBean.setAddress(rs.getString("address"));
				charityBean.setName(rs.getString("name"));
				charityBean.setEmailID(rs.getString("emailID"));
				charityBean.setZipcode(rs.getInt("zipcode"));
				charityBean.setPhoneNo(rs.getLong("phoneno"));
				
			}
	
			}catch(Exception e){
				
			}  			
		
		return charityBean;
	}
	
	public boolean addCharity(AddCharityBean bean)
	{
		
		boolean status=false;  
		
		try
		{ 
			con=connectionProvider.getCon();
		
			if(con!=null)
				System.out.println("Connected");
		
			String query = "INSERT INTO charity ("
			    + " name,"
			    + " emailID,"
			    + " Address,"
			    + " zipcode,"
			    + " phoneno ) VALUES ("
			    + "?, ?, ?, ?, ?)";
		              
		PreparedStatement ps=con.prepareStatement(query);
		
		if(bean.getName() != null)
		{
			ps.setString(1, bean.getName());
		}
		if(bean.getEmailID() != null)
		{
			ps.setString(2, bean.getEmailID());
		}
		
		if(bean.getAddress() != null)
		{
			ps.setString(3, bean.getAddress());
		}
		if(bean.getZipcode() != 0L)
		{
			ps.setLong(4, bean.getZipcode());
		}
		if(bean.getPhoneNo() != 0L)
		{
			ps.setLong(5, bean.getPhoneNo());
		}
		
		int rs=ps.executeUpdate(); 

		if(rs > 0)
			status=true;
		else
			status = false;		
		
		}catch(Exception e){}  
		  
		return status;  

	}
	public boolean updateCharity(String name, String emailID, String address, String zipcode, String phoneNo, String id)
	{
		boolean status=false;  
		int charityid=Integer.parseInt(id);
		
		System.out.println(name + emailID + address + zipcode + phoneNo + charityid + "inside charity");
		
		try
		{ 
			con=connectionProvider.getCon();

			if(con!=null)
				System.out.println("Connected");
		
			String query = "UPDATE charity SET name = ?, emailID = ?, address = ?, zipcode = ?, phoneno = ? where id = ?";	              
			
			PreparedStatement ps=con.prepareStatement(query);
			
			if(name != null && emailID != null && address != null && zipcode != null && phoneNo != null && charityid != 0)
			{	
				ps.setString(1, name);
				ps.setString(2, emailID);
				ps.setString(3, address);
				ps.setLong(4, Long.parseLong(zipcode));
				ps.setLong(5, Long.parseLong(phoneNo));
				ps.setInt(6, charityid);
			}
		
		int rs=ps.executeUpdate(); 
		
		System.out.println(name + emailID + address + zipcode + phoneNo + charityid);

		if(rs > 0)
			status=true;
		else
			status = false;
				
		}catch(Exception e){}  
		  
		return status;  

	}
}
