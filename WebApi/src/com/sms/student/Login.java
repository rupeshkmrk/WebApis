package com.sms.student;

public class Login {

	private String prn;
	private String password;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	public Login(String prn, String password) {
		this.prn = prn;
		this.password = password;
	}
	


	public String getPrn() {
		return prn;
	}


	public void setPrn(String prn) {
		this.prn = prn;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
