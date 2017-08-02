package com.hibernate.example.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class EmployeeMain {
	
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		
		
		session.beginTransaction();
		
		
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("Alex");
		EmployeeAddress ea = new EmployeeAddress();
		ea.setCity("lewisville");
		ea.setState("TX");
		
		employee.setEmployeeAddress(ea);
		ea.setEmp(employee);
		
		
//		Employee e = (Employee) session.get(Employee.class, 1L);
//		System.out.println(e.getEmployeeAddress());
//		System.out.println(e.getEmployeeAddress());
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		sf.close();
		

		System.out.println("Done");
	}
	

}
