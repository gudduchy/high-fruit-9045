package com.masai.dao;

import java.util.List;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.Faculty;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.FacultyException;

public interface AdminstratorDao {

	public String AddCourse(Course course);

	public String AddFcaulty(Faculty faculty);
		
	public List<Course> viewCourse() throws CourseException;
	
	public String AddBatch(Batch batch);
	
	public List<Batch> viewBatch() throws BatchException;
	
	public List<Faculty> viewFaculty() throws FacultyException;
}
