package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.bean.Report;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.CoursePlanException;
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
				message="course added successfully!!";
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


	@Override
	public String AddCoursePlan(CoursePlan courseplan) {
		
        String message="coursePlan not added";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into courseplan values(?,?,?,?,?)");
			
			ps.setInt(1,courseplan.getPlanId());
			ps.setInt(2,courseplan.getBatchId());
			ps.setInt(3,courseplan.getDaysNumber());
			ps.setString(4,courseplan.getTopic());
			ps.setString(5,courseplan.getStatus());
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="coursePlan addes successfully!!";
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
		return message;
		
	}


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
	public String UpdateCourse(int courseid, int fee) throws CourseException {
		String message="updation failed";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update course set fee =? where courseid=?");
			
			ps.setInt(1, fee);
			ps.setInt(2, courseid);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="updation successful!!";
			}else {
				throw new CourseException("courseid does not match");
			}
			
		}catch(Exception se) {
			//se.printStackTrace();
			throw new CourseException("courseid does not match");
		}
		
		
		
		return message;
	}


	@Override
	public String Updatefaculty(int facultyId, String mobile) throws FacultyException {
        String message="updation failed";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update faculty set mobile =? where facultyid=?");
			
			ps.setString(1, mobile);
			ps.setInt(2, facultyId);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="updation successful!!";
			}else {
				throw new CourseException("facultyId does not match");
			}
			
		}catch(Exception se) {
			//se.printStackTrace();
			throw new FacultyException("facultyId does not match");
		}
		
		
		
		return message;
	}


	@Override
	public String UpdateBatch(int batchId, int numberOfStudent) throws BatchException {
         String message="updation failed";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update batch set numberOfStudent =? where batchid=?");
			
			ps.setInt(1, numberOfStudent);
			ps.setInt(2, batchId);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="updation successful!!";
			}else {
				throw new BatchException("batchId does not match");
			}
			
		}catch(Exception se) {
			//se.printStackTrace();
			throw new BatchException("batchId does not match");
		}
		
		
		
		return message;
	}


	@Override
	public String UpdateCourse_plan(int planId, String Status) throws CoursePlanException {
       String message="updation failed";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update courseplan set status =? where planId=?");
			
			ps.setString(1, Status);
			ps.setInt(2, planId);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="updation successful!!";
			}else {
				throw new CoursePlanException("planId does not match");
			}
			
		}catch(Exception se) {
			//se.printStackTrace();
			throw new CoursePlanException("planId does not match");
		}
		
		
		
		return message;
	}


	@Override
	public String allocateFaculty(int batchId, int facultyid) throws BatchException {
     String message="updation failed";
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update batch set  facultyid =? where batchid=?");
			
			ps.setInt(1, facultyid);
			ps.setInt(2, batchId);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="updation successful!!";
			}else {
				throw new BatchException("Batchid does not match");
			}
			
		}catch(Exception se) {
			//se.printStackTrace();
			throw new BatchException("Batchid does not match");
		}
		
		
		
		return message;
	}


	@Override
	public List<Report> viewReport() throws FacultyException, CourseException, BatchException {
      List<Report> list=new ArrayList<>();
		
		try(Connection conn=DbUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select faculty.facultyname,batch.batchid,batch.courseid,batch.numberOfStudent,batch.duration,courseplan.planId\r\n"
					+ "    ,courseplan.dayNumber,courseplan.topic,courseplan.status from((batch INNER JOIN faculty ON batch.facultyid=faculty.facultyid) \r\n"
					+ "INNER JOIN courseplan ON batch.batchid=courseplan.batchid);");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
		   String fn= rs.getString("facultyname");
		    int bid=rs.getInt("batchid");
		    int cid=rs.getInt("courseid");
		   int nos= rs.getInt("numberOfStudent");
		    String d=rs.getString("duration");
		   int pid= rs.getInt("planId");
		    int dn=rs.getInt("dayNumber");
		    String t=rs.getString("topic");
		    String s=rs.getString("status");
		    
		    
		    Report r1=new Report(fn,bid,cid,nos,d,pid,dn,t,s);
			list.add(r1);
			
			}
			
			
		}
		catch(Exception se) {
			//se.printStackTrace();
			throw new CourseException(se.getMessage());
		}
		
		if(list.size()==0) {
			throw new CourseException("no result found!!");
		}
		
		
		
		return list;
	}
	


	
	
}
