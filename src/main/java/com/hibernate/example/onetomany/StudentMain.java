package com.hibernate.example.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class StudentMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		
		Student student = new Student();
		student.setfName("arshad");
		student.setlName("mohammad");
		
		StudentCourse sc = new StudentCourse();
		sc.setcName("Java");
		sc.setcLocation("Dallas");
		
		StudentCourse sc1 = new StudentCourse();
		sc1.setcName("Hibernate");
		StudentCourse sc2 = new StudentCourse();
		sc2.setcName("Angular");
		
		student.getSc().add(sc);
		student.getSc().add(sc1);
		student.getSc().add(sc2);
		
		
		session.save(student);
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		
	}

}

