package com.celeprokart.DAO;

import java.sql.*;

public class ConnectionProvider {

	Connection con=null; 
	public ConnectionProvider()
	{  
	
	}
	public Connection getCon() {
		try
		{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SSDI","SSDI_29");  
		}
	catch(Exception e){
	}
		
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
}