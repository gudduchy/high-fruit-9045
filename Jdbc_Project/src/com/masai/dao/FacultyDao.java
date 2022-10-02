package com.masai.dao;

import java.util.List;

import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.exception.CoursePlanException;
import com.masai.exception.FacultyException;

public interface FacultyDao {

	public List<CoursePlan> viewCoursePlan() throws CoursePlanException;
	
	public String updatepassword(String  userName,String password) throws FacultyException;
}
