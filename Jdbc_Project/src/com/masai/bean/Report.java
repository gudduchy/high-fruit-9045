package com.masai.bean;

public class Report {

	private String facultyName;
	private int batchId;
	private int courseId;
	private int NumberOfStudent;
	private String duration;
	private int planId;
	private int dayNumber;
	private String topic;
	private String status;
	
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getNumberOfStudent() {
		return NumberOfStudent;
	}
	public void setNumberOfStudent(int numberOfStudent) {
		NumberOfStudent = numberOfStudent;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Report(String facultyName, int batchId, int courseId, int numberOfStudent, String duration, int planId,
			int dayNumber, String topic, String status) {
		super();
		this.facultyName = facultyName;
		this.batchId = batchId;
		this.courseId = courseId;
		NumberOfStudent = numberOfStudent;
		this.duration = duration;
		this.planId = planId;
		this.dayNumber = dayNumber;
		this.topic = topic;
		this.status = status;
	}
	
	public Report() {
		
	}
	@Override
	public String toString() {
		return "Report [facultyName=" + facultyName + ", batchId=" + batchId + ", courseId=" + courseId
				+ ", NumberOfStudent=" + NumberOfStudent + ", duration=" + duration + ", planId=" + planId
				+ ", dayNumber=" + dayNumber + ", topic=" + topic + ", status=" + status + "]";
	}
	
	
}
