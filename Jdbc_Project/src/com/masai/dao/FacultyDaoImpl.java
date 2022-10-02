package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.exception.CoursePlanException;
import com.masai.exception.FacultyException;
import com.masai.utility.DbUtil;

public class FacultyDaoImpl implements FacultyDao{

	@Override
	public List<CoursePlan> viewCoursePlan() throws CoursePlanException {
		
		 List<CoursePlan> list=new ArrayList<>();
			
			try(Connection conn=DbUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement("select * from courseplan");
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					
				int pid=rs.getInt("planId");
				
				int bid=rs.getInt("batchid");
				int dn=rs.getInt("dayNumber");
				String t=rs.getString("topic");
				String s=rs.getString("status");
				
				CoursePlan c1=new CoursePlan(pid,bid,dn,t,s);
				list.add(c1);
				
				}
				
				
				
			}catch(Exception se) {
				//se.printStackTrace();
				throw new CoursePlanException(se.getMessage());
			}
			
			if(list.size()==0) {
				throw new CoursePlanException("no result found!!");
			}
			
			
			
			return list;
		}

	@Override
	public String updatepassword(String userName, String password) throws FacultyException {
		String message="user not found";
		
			try(Connection conn=DbUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement("update faculty set password =? where username=?");
				
				ps.setString(1, password);
				ps.setString(2,userName);
				
				int x=ps.executeUpdate();
				
				if(x>0) {
					message="password updated Successfully";
				}else {
					throw new FacultyException("username doesnot match");
				}
				
			}catch(Exception se) {
				
				throw new FacultyException(se.getMessage());
				
			}
				
				
				
				return message;
	}
		
		
	

	
	
}
