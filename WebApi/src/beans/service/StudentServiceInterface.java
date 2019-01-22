package beans.service;

import java.util.List;

import com.sms.student.Login;

public interface StudentServiceInterface {

	int insert(Student student);

//	Student getStudent(int prn);

	Student getStudent(String prn);

	Student validateStudent(Login login);

	String checkPrn(String prn);
	
	List<Student> getAllStudents();
	

	List<Student> getAllStudents(String course);
}

