package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.Faculty;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.FacultyException;
import com.masai.utility.DbUtil;

public class AdminstratorDaoImpl implements AdminstratorDao{

	@Override
	public String AddCourse(Course course) {
		
		String message="course not added";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into course values(?,?,?,?)");
			
			ps.setInt(1,course.getCourseId());
			ps.setString(2,course.getCourseName());
			ps.setInt(3,course.getFee());
			ps.setString(4,course.getCourseDescription());
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="course addes successfully!!";
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
		return message;
	}

	
	@Override
	public String AddFcaulty(Faculty faculty) {
		
		String message="not addeed";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?)");
					
			
			ps.setString(1, faculty.getFacultyName());
			ps.setString(2, faculty.getFacultyAddress());
			ps.setString(4, faculty.getEmail());
			ps.setString(3, faculty.getMobile());
			
			ps.setString(5, faculty.getUserName());
			ps.setString(6, faculty.getPassword());
			
			int result=ps.executeUpdate();
			if(result>0) {
				message="record insertd";
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
		return message;
	}


	@Override
	public List<Course> viewCourse() throws CourseException {
		
		List<Course> list=new ArrayList<>();
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from course");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
			int id=rs.getInt("courseid");
			String n=rs.getString("coursename");
			int f=rs.getInt("fee");
			String cd=rs.getString("coursedescription");
			
			Course c1=new Course(id,n,f,cd);
			list.add(c1);
			
			}
			
			
			
		}catch(Exception se) {
			//se.printStackTrace();
			throw new CourseException(se.getMessage());
		}
		
		if(list.size()==0) {
			throw new CourseException("no result found!!");
		}
		
		
		
		return list;
	}


	@Override
	public String AddBatch(Batch batch) {
	String message="not inserted";
	
	try(Connection conn=DbUtil.provideConnection()){
		
		PreparedStatement ps=conn.prepareStatement("insert into batch values(?,?,?,?,?,?)");
		
		ps.setInt(1,batch.getBatchid());
		ps.setInt(2,batch.getCourseId());
		ps.setInt(3,batch.getFacultyId());
		ps.setInt(4,batch.getNumberOfStudent());
		ps.setString(6,batch.getBatchStartDate());
		ps.setString(5,batch.getDuration());
		
		int x=ps.executeUpdate();
		if(x>0) {
			message="batch added successfully!!";
		}
		
	}catch(SQLException se) {
		
		se.printStackTrace();
	}
	
	
	
		return message;
	}


	@Override
	public List<Batch> viewBatch() throws BatchException {
       List<Batch> list=new ArrayList<>();
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from batch");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
			int bid=rs.getInt("batchid");
			int cid=rs.getInt("courseid");
			int fid=rs.getInt("facultyid");
			int nos=rs.getInt("numberOfStudent");
			
			String d=rs.getString("duration");
		
			String bsd=rs.getString("batchStartdate");
			
			Batch c1=new Batch(bid,cid,fid,nos,d,bsd);
			list.add(c1);
			
			}
			
			
			
		}catch(Exception se) {
			//se.printStackTrace();
			throw new BatchException(se.getMessage());
		}
		
		if(list.size()==0) {
			throw new BatchException("no result found!!");
		}
		
		
		
		return list;
	}


	@Override
	public List<Faculty> viewFaculty() throws FacultyException {
		 List<Faculty> list=new ArrayList<>();
			
			try(Connection conn=DbUtil.provideConnection()){
				
				PreparedStatement ps=conn.prepareStatement("select * from faculty");
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					
				int fid=rs.getInt("facultyid");
				String fn=rs.getString("facultyname");
				
				String fad=rs.getString("facultyaddress");
			
				String m=rs.getString("mobile");
				String e=rs.getString("email");
				String un=rs.getString("username");
				String pw=rs.getString("password");
				
				Faculty c1=new Faculty(fid,fn,fad,m,e,un,pw);
				list.add(c1);
				
				}
				
				
				
			}catch(Exception se) {
				//se.printStackTrace();
				throw new FacultyException(se.getMessage());
			}
			
			if(list.size()==0) {
				throw new FacultyException("no result found!!");
			}
			
			
			
			return list;
	}
	
	
}
