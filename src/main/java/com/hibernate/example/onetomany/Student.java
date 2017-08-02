package com.hibernate.example.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long StudentId;
	private String fName;
	private String lName;
	
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OrderColumn
	private List<StudentCourse> sc = new ArrayList<>();
	
	
	public Long getStudentId() {
		return StudentId;
	}

	public void setStudentId(Long studentId) {
		StudentId = studentId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Student(){
		
	}
	
	public Student(Long studentId, String fName, String lName) {
		super();
		StudentId = studentId;
		this.fName = fName;
		this.lName = lName;
	}

	public List<StudentCourse> getSc() {
		return sc;
	}

	public void setSc(List<StudentCourse> sc) {
		this.sc = sc;
	}
	
	
	
	
	

}
