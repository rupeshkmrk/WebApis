package beans.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_registration")
public class Student {

	@Id
	private String prn;
	private String name;
	private String password;
	private String email;
	private String batch;
	private String course;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getPrn() {
		return prn;
	}
	public void setPrn(String prn) {
		this.prn = prn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Student(String prn, String name, String password, String email, String batch, String course) {
		super();
		this.prn = prn;
		this.name = name;
		this.password = password;
		this.email = email;
		this.batch = batch;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", password=" + password + ", email=" + email + ", batch="
				+ batch + ", course=" + course + "]";
	}
	
	
	
}
