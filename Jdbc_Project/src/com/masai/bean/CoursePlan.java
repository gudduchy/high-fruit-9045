package com.masai.bean;

public class CoursePlan {

	private int planId;
	private int batchId;
	private int DaysNumber;
	private String Topic;
	private String Status;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getDaysNumber() {
		return DaysNumber;
	}
	public void setDaysNumber(int daysNumber) {
		DaysNumber = daysNumber;
	}
	public String getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic = topic;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public CoursePlan(int planId, int batchId, int daysNumber, String topic, String status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		DaysNumber = daysNumber;
		Topic = topic;
		Status = status;
	}
	
	public CoursePlan() {
		
	}
	
	@Override
	public String toString() {
		return "CoursePlan [planId=" + planId + ", batchId=" + batchId + ", DaysNumber=" + DaysNumber + ", Topic="
				+ Topic + ", Status=" + Status + "]";
	}
	
	
}
