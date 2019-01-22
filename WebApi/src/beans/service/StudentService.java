package beans.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.student.Login;

import beans.dao.StudentDAO;
import beans.dao.StudentDAOInterface;

public class StudentService implements StudentServiceInterface {


	ClassPathXmlApplicationContext context ;
	
	StudentDAOInterface std ;
	public StudentService() {
		std = new StudentDAO();
		context = new ClassPathXmlApplicationContext("student.xml");
		std = context.getBean(StudentDAO.class);
		std.checkSession();
		// TODO Auto-generated constructor stub
	}
	
	
	/* (non-Javadoc)
	 * @see beans.service.StudentServiceInterface#insert(beans.service.Student)
	 */
	@Override
	public int insert(Student student)
	{
		return std.add(student);
	}
	
	/* (non-Javadoc)
	 * @see beans.service.StudentServiceInterface#getStudent(int)
	 */
	@Override
	public Student getStudent(String prn)
	{
		Student student = std.getStudent(prn);
		return student;
		
	}


	@Override
	public Student validateStudent(Login login) {
		// TODO Auto-generated method stub
		return std.validateStudent(login);
	}


	@Override
	public String checkPrn(String prn) {
		// TODO Auto-generated method stub
		System.out.println("Prn in service layer " + prn);
		String outPrn = std.checkPrn(prn);
		
		return outPrn;
	}


	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return std.getAllStudents();
//		return null;
	}
	
	@Override
	public List<Student> getAllStudents(String course)
	{
		return std.getAllStudents(course);
	}
}
