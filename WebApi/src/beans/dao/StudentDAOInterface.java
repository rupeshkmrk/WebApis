package beans.dao;

import java.util.List;

import com.sms.student.Login;

import beans.service.Student;

public interface StudentDAOInterface {

	int add(Student student);

//	Student getStudent(int prn);

	void checkSession();

	Student getStudent(String prn);

	Student validateStudent(Login login);

	String checkPrn(String prn);
	
	List<Student> getAllStudents();
	
	int countStudents();
	

	public List<Student> getAllStudents(String course);
}