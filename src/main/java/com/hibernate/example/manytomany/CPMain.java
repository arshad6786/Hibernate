package com.hibernate.example.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class CPMain {
	
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project project = new Project();
		project.setpName("HarleyDavidson");
		project.setPtype("motorbike");
		
		Client client = new Client();
		client.setcName("Harley");
		client.setcLocation("california");
		client.getProjects().add(project);
		
		
		session.save(client);
		session.save(project);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		
	}
}
