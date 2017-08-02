package com.hibernate.example.manytomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long ClientID;
	private String cName;
	private String cLocation;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade =
			{  CascadeType.DETACH,
	                CascadeType.MERGE,
	                CascadeType.REFRESH,
	                CascadeType.PERSIST
	        },targetEntity=Project.class)
	
	@JoinTable( name = "Client_Project", joinColumns = {
			@JoinColumn(name = "ClientId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ProjectId", nullable = false) })
	
	
	private List<Project> projects = new ArrayList<>();
	
	public Client(){
		
	}

	public Client(String cName, String cLocation) {
		super();
		this.cName = cName;
		this.cLocation = cLocation;
	}

	public Long getClientID() {
		return ClientID;
	}

	public void setClientID(Long clientID) {
		ClientID = clientID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

}
