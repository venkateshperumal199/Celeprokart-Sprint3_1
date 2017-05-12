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

public class ForgotPasswordDAO 
{
	public Connection con;
	public ConnectionProvider connectionProvider = new ConnectionProvider();
	PreparedStatement ps;
	ResultSet rs;
	String to=null;
	public boolean forgotPassword(String name)
	{
		boolean status=false;  
		String password = null;
		try{  
		con=connectionProvider.getCon(); 
		System.out.println("Connected");
		              
		ps=con.prepareStatement(  
		    "select * from Celebrity where email_id=?"); 		  
		ps.setString(1, name); 
		System.out.println(name);
	               
		rs=ps.executeQuery(); 		
		while (rs.next()) 
		{
			password = rs.getString("password");
		}
		to = name;
		if(password != null)
		{
			sendEmail(to, "Password", "Your password is"+password);
			return true;
			
		}
		
		else
		{
			ps=con.prepareStatement(  
				    "select * from Customer where email_id=?"); 		  
				ps.setString(1, name); 
				System.out.println(name);
			               
				rs=ps.executeQuery(); 		
				while (rs.next()) 
				{
					password = rs.getString("password");
				}
				to = name;
				
				if(password != null)
				{
					sendEmail(to, "Password", "Your password is"+password);
					return true;
				}
				else
				{
					System.out.println("null");
					return status;
				}
		}
		
		}catch(Exception e){}  
		  
		return status;  
		  
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
