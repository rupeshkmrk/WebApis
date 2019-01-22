package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/create")
public class CreateTable {

	@GET
	@Path("{table}")
	public String create(@PathParam("table") String table)
	{
		try {
			return createTable(table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
//		return "success";
	}

	public String createTable(String tblName) throws SQLException
	{
		Connection con = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/sms","root","");  
			Statement stmt=con.createStatement();  
			String query = "create table if not exists prn" + tblName + " (col1 varchar(20),col2 varchar(30))";
						System.out.println(query);
			if(stmt.execute(query))
				System.out.println("Table created successfully");
			
			return "success";
		}catch(Exception e){ 
			System.out.println(e);
			return "failed";
		}finally {
			con.close();
		}  


	}

}
