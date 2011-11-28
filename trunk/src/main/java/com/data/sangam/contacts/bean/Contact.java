package com.data.sangam.contacts.bean;

public class Contact {
	
	public Contact(String fullName,String emailId){
		this.fullName=fullName;
		this.emailId=emailId;
	}
	
	public Contact(){
		
	}
	private String emailId;
	
	private String fullName;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


}
