package com.whatsapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class WhatsappController implements WhatsappControllerinterface {
	
	private BufferedReader br;
	
	public WhatsappController() {
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	

	public void createProfileController()throws Exception {
		System.out.println("enter your name");
		String name=br.readLine();
		
		System.out.println("enter your password");
		String password=br.readLine();
		
		System.out.println("enter your email");
		String email=br.readLine();
		
		System.out.println("enter your address");
		String address=br.readLine();
		
		//jdbc start
		//step 1 load driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//step 2 create database connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/infosys_db","root","rajesh");
			//step3
			//create query
			//if dynamic query then PreparedStatement
			PreparedStatement ps=con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, address);
			//step 4 execute query
			
			int i=ps.executeUpdate(); //if query is insert, delete, update then you will use executeUpdate() method and if select then executeQuery()
			if(i>0) {
				System.out.println("registration success");
			}
			else {
				System.out.println("registration fail");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void viewProfileController() throws Exception{
		// TODO Auto-generated method stub
		
	}

	public void deleteProfileController() throws Exception{
		// TODO Auto-generated method stub
		
	}

	public void viewAllProfileController() throws Exception{
		// TODO Auto-generated method stub
		
	}

	public void searchProfileController() throws Exception{
		// TODO Auto-generated method stub
		
	}

	public void editProfileController() throws Exception{
		// TODO Auto-generated method stub
		
	}

}
