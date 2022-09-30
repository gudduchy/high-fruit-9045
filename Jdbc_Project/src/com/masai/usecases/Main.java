package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.Faculty;
import com.masai.dao.Admin;
import com.masai.dao.Admindaoimpl;
import com.masai.dao.AdminstratorDao;
import com.masai.dao.AdminstratorDaoImpl;
import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.FacultyException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new  Scanner(System.in);
		
		
		System.out.println("welcome to course Monitoring System");
		
		
		
		
		while(true) {
			System.out.println("Enter 1 for administrator");
			System.out.println("Enter 2 for faculty");
			System.out.println("Enter 0 for Exit");
			
			int n1=sc.nextInt();
			
			if(n1==1) {
				System.out.println("enter username");
				String u1=sc.next();
				
				System.out.println("enter password");
				String p1=sc.next();
				
				Admin dao=new Admindaoimpl();
				
				String me=dao.adminstratorLogin(u1, p1);
				
				
				System.out.println(me);
				if(me.equals("login Successful")) {
					
				while(true) {	
					
				System.out.println("welcome Adminstrator");
				
				AdminstratorDao ado=new AdminstratorDaoImpl();
				
					System.out.println("Enter 1 for add course");
					System.out.println("Enter 2 for add faculty");
					System.out.println("Enter 3 for view course");
					System.out.println("Enter 4 for add batch");
					System.out.println("Enter 5 for view Batch");
					System.out.println("Enter 6 for view faculty");
					int a1=sc.nextInt();
					
					if(a1==1) {
						
						System.out.println("Enter courseid");
						int cid=sc.nextInt();
						
						System.out.println("Enter Course name");
						String n=sc.next();
						
						System.out.println("Enter course fee");
						int fee=sc.nextInt();
						
						System.out.println("Enter Course Description");
						String cd=sc.next();
						
						Course c1=new Course(cid,n,fee,cd);
						
						
						String s1=ado.AddCourse(c1);
						
						System.out.println(s1);
					}
					else if(a1==2) {
						
						System.out.println("Enter name");
						String n=sc.next();
						System.out.println("enter address");
						String a=sc.next();
						System.out.println("enter mobile");
						String m=sc.next();
						System.out.println("enter email");
						String e=sc.next();
						System.out.println("enter username");
						String u=sc.next();
						System.out.println("enter password");
						String p=sc.next();
						
						//AdminstratorDao ado1=new AdminstratorDaoImpl();
						Faculty f1=new Faculty();
						
						f1.setFacultyName(n);
						f1.setFacultyAddress(a);
						f1.setMobile(m);
						f1.setEmail(e);
						f1.setUserName(u);
						f1.setPassword(p);
						
						
						
						String result=ado.AddFcaulty(f1);
						
						System.out.println(result);
						
					}
					else if(a1==3) {
						
						try {
							List<Course> l1=ado.viewCourse();
							
							l1.forEach(s->System.out.println(s));
							
						} catch (CourseException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						System.out.println(e.getMessage());
						}
						
						
					}
					else if(a1==4) {
						
						System.out.println("Enter batchId");
						int bid=sc.nextInt();
						
						System.out.println("Enter courseId");
						int cid=sc.nextInt();
						
						System.out.println("Enter facultyId");
						int fid=sc.nextInt();
						
						System.out.println("Enter number of Student");
						int ns1=sc.nextInt();
						
						System.out.println("Enter batch start date");
						String bsd=sc.next();
						
						System.out.println("Enter batch duration");
						String bd=sc.next();
						
						Batch batch=new Batch(bid,cid,fid,ns1,bsd,bd);
						
						String batch_Status=ado.AddBatch(batch);
						System.out.println(batch_Status);
						
					}
					else if(a1==5) {
						try {
							List<Batch> l1=ado.viewBatch();
							
							l1.forEach(s->System.out.println(s));
							
						} catch (BatchException e) {
							
						System.out.println(e.getMessage());
						
						}
					}
					else if(a1==6) {
						try {
							List<Faculty> l1=ado.viewFaculty();
							
							l1.forEach(s->System.out.println(s));
							
						} catch (FacultyException e) {
							
						System.out.println(e.getMessage());
						
						}
					}
					else {
						System.out.println("thank You!!!!");
						break;
					}
					
				}
				   }
				
			}
			else if(n1==2) {
				
				System.out.println("enter username");
				String u1=sc.next();
				System.out.println("enter password");
				String p1=sc.next();
				Admin dao=new Admindaoimpl();
				
				String me=dao.facultyLogin(u1, p1);
				
				System.out.println(me);
				if(me.equals("login Successful")) {
					System.out.println("Enter name");
					String n=sc.next();
					System.out.println("done");
				}
				
				
				
				
				
			}
			else if(n1==0) {
				System.out.println("thank you!!!");
				break;
				
			}
			else {
				System.out.println("thank you!!!");
				break;
			}
		}
	}

}
