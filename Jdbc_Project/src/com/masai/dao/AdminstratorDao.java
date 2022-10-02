package com.masai.dao;

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

public interface AdminstratorDao {

	public String AddCourse(Course course);

	public String AddFcaulty(Faculty faculty);
		
	public List<Course> viewCourse() throws CourseException;
	
	public String AddBatch(Batch batch);
	
	public List<Batch> viewBatch() throws BatchException;
	
	public List<Faculty> viewFaculty() throws FacultyException;
	
	public String AddCoursePlan(CoursePlan courseplan);
	
	public List<CoursePlan> viewCoursePlan() throws CoursePlanException;
	
	public String UpdateCourse(int courseid,int fee) throws CourseException;
	
	public String Updatefaculty(int facultyId,String mobile) throws FacultyException;
	
	public String UpdateBatch(int batchId,int numberOfStudent) throws BatchException;
	
	public String UpdateCourse_plan(int planId,String Status) throws CoursePlanException;
	
	public String allocateFaculty(int batchId,int facultyid) throws BatchException;
	
	public List<Report> viewReport() throws FacultyException,CourseException,BatchException;
}
