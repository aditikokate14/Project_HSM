package com.hospital;

  public class User {         
      private int id;         
      private String name;    
      private String email;   
      private Long mobile;  
      private String hospital;
	  public User() {
		super();
		// TODO Auto-generated constructor stub
	  }
	  public User(int id, String name, String email, Long mobile, String hospital) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.hospital = hospital;
	  }
	  public int getId() {
		  return id;
	  }
	  public void setId(int id) {
		  this.id = id;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public String getEmail() {
		  return email;
	  }
	  public void setEmail(String email) {
		  this.email = email;
	  }
	  public Long getMobile() {
		  return mobile;
	  }
	  public void setMobile(Long mobile) {
		  this.mobile = mobile;
	  }
	  public String getHospital() {
		  return hospital;
	  }
	  public void setHospital(String hospital) {
		  this.hospital = hospital;
	  }
	  @Override
	  public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", hospital="
				+ hospital + "]";
	  }
      
  }
                              










































