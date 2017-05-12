package com.celeprokart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.celeprokart.bean.*;

public class ProductDAO {
	int count;
	public Connection con;
	public ConnectionProvider connectionProvider = new ConnectionProvider();
	
	public ProductDAO(ConnectionProvider connectionProvider) {
		super();
		this.connectionProvider = connectionProvider;
	}

	public ProductDAO() {
		super();
	}

	public int addProduct(ProductBean bean)
	{
		int rs=0;
		try{ 
			con=connectionProvider.getCon();
			if(con!=null)
				System.out.println("connected");

		String query = "INSERT INTO products ("
			    + " category,"
			    + " sellordonate,"
			    + " charity,"
			    + " product_name,"
			    + " image,"
			    + " price,"
			    + " celebrityname,"
			    + " flag,"
			    + " celebName ) VALUES ("
			    + "?, ?, ?, ?, ?, ?, ?, ?, ?)";
		              
		PreparedStatement ps=con.prepareStatement(query);
		
		System.out.println(bean.getProduct_name());
		if(bean.getCategory() != null)
		{
				ps.setString(1, bean.getCategory());
				System.out.println("Value of rs" + rs);
		}
		if(bean.getSellordonate() != null)
		{
				ps.setString(2, bean.getSellordonate());
				System.out.println("Value of rs" + rs);
		}
		if(bean.getCharity() != null)
		{
				ps.setString(3, bean.getCharity());
				System.out.println("Value of rs" + rs);
		}
		if(bean.getImage()!= null)
		{
				ps.setString(5, bean.getImage());
				System.out.println("Value of rs" + rs);
		}
		if(bean.getProduct_name()!= null)
		{
				ps.setString(4, bean.getProduct_name());
				System.out.println("Value of rs" + rs);
		}
		if(bean.getPrice() != null)
		{	
				ps.setString(6, bean.getPrice());
				System.out.println("Value of rs" + rs);
		}
		if(bean.getCelebrity() != null)
		{
				ps.setString(7, bean.getCelebrity());
				System.out.println("Value of rs" + rs);
		}
		
		ps.setString(8, "N");
		
		if(bean.getCelebrity() != null)
		{
				ps.setString(9, bean.getCelebName());
				System.out.println("Value of rs" + rs);
		}
		
		rs=ps.executeUpdate(); 
		
		}catch(Exception e){}  
		  
		return rs;  
	}

	public boolean buyProduct(String id)
	{
		
		boolean status = false;
		int i = Integer.parseInt(id);
		try{ 
			con = connectionProvider.getCon();
			if(con!=null)
				System.out.println("connected");

		String query = "delete from products where product_id = ?";
		              
		PreparedStatement ps=con.prepareStatement(query);
			if(i != 0)
			{
				ps.setInt(1, i);
			}
		int x=ps.executeUpdate();
		
		if(x != 0)
		{
			status = true;
		}
		
		ps.close();	
			
		}catch(Exception e){}  
		  
		return status;  
	}
	
	public int updateProduct(ProductBean bean)
	{

		int rs=0;
		try{ 
			con = connectionProvider.getCon();
			if(con!=null)
				System.out.println("connected");

		String query = "UPDATE products SET price = ?, flag = ? where product_name = ?";
		              
		PreparedStatement ps=con.prepareStatement(query);

		if(bean.getPrice() != null)
			ps.setString(1, bean.getPrice());
		
			ps.setString(2, "Y");
		
		if(bean.getProduct_name() != null)
			ps.setString(3, bean.getProduct_name());
		rs=ps.executeUpdate(); 
		ps.close();	
		
		}catch(Exception e){}  
		  
		return rs;  
	}

	public ProductBean searchProduct(String product_id)
	{
		ProductBean bean=new ProductBean();
		
		int id = Integer.parseInt(product_id);
		
		try{  	
			bean = new ProductBean();
			con = connectionProvider.getCon();
			
			PreparedStatement ps=con.prepareStatement(  
			    "select * from Products where Product_id=?"); 		  
			ps.setInt(1,id);  
			      
			ResultSet rs=ps.executeQuery();  
			
			while(rs.next())
			{
				bean.setProduct_id(id);
				bean.setCategory(rs.getString("category"));
				bean.setCelebrity(rs.getString("celebrityname"));
				bean.setCharity(rs.getString("charity"));
				bean.setImage(rs.getString("image"));
				bean.setProduct_name(rs.getString("product_name"));
				bean.setPrice(rs.getString("price"));
				bean.setFlag(rs.getString("flag"));
				
			}
			
			System.out.println("ID is "+rs.getInt("id"));
	
			}catch(Exception e){}  		
		
		return bean;
	}
	
	
public static void sendEmail(String toAddress,String subject, String message) throws AddressException,
	MessagingException {
	
String host  = "smtp.gmail.com";
String port  = "587";
String userName = "anushareddy.amula@gmail.com";
String password = "Hanuman@29";

// sets SMTP server properties
Properties properties = new Properties();
properties.put("mail.smtp.host", host);
properties.put("mail.smtp.port", port);
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");

// creates a new session with an authenticator
Authenticator auth = new Authenticator() {
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName, password);
	}
};

Session session = Session.getInstance(properties, auth);

// creates a new e-mail message
Message msg = new MimeMessage(session);

msg.setFrom(new InternetAddress(userName));
InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
msg.setRecipients(Message.RecipientType.TO, toAddresses);
msg.setSubject(subject);
msg.setSentDate(new Date());
msg.setText(message);

// sends the e-mail
Transport.send(msg);

}

}