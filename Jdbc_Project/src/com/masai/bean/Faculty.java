package com.masai.bean;

public class Faculty {

	private int facultyId;
	private String facultyName;
	private String facultyAddress;
	private String mobile;
	private String email;
	private String userName;
	private String password;
	
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyAddress() {
		return facultyAddress;
	}
	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Faculty(int facultyId, String facultyName, String facultyAddress, String mobile, String email,
			String userName, String password) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.facultyAddress = facultyAddress;
		this.mobile = mobile;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	
	public Faculty() {
		
	}
	
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyAddress=" + facultyAddress
				+ ", mobile=" + mobile + ", email=" + email + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
