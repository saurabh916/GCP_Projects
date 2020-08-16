package com.springboot.gcplab.gcpmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
    @GeneratedValue
    private Long id;
    private String name;
    private String age;
    private String emailAddress;
    
    public Employee() { }
    
    public Employee(Long id, String name, String age, String emailAddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
    
   
    
}
