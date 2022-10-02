package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.utility.DbUtil;

public class Admindaoimpl implements Admin{

	
	@Override
	public String facultyLogin(String username,String password) {

		String message="not matched";
		
   try(Connection conn=DbUtil.provideConnection()){
	  //System.out.println(conn);
	   PreparedStatement ps=conn.prepareStatement("select * from faculty where username=? and password=? ");
	   
	   ps.setString(1,username);
	   ps.setString(2,password);
	   
	   ResultSet rs=ps.executeQuery();
	   
	   if(rs.next()) {
		   message="login Successful";
	   }
	   
   }catch(SQLException se) {
	   se.printStackTrace();
   }
		
		
		return message;
	}

	@Override
	public String adminstratorLogin(String username,String password) {
		// TODO Auto-generated method stub

		String message="not matched";
		
   try(Connection conn=DbUtil.provideConnection()){
	  //System.out.println(conn);
	   PreparedStatement ps=conn.prepareStatement("select * from admin where username=? and password=? ");
	   
	   ps.setString(1,username);
	   ps.setString(2,password);
	   
	   ResultSet rs=ps.executeQuery();
	   
	   if(rs.next()) {
		   message="login Successful";
	   }
	   
   }catch(SQLException se) {
	   se.printStackTrace();
   }
		
		
		return message;
	}

}
