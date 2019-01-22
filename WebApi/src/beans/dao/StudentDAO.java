package beans.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sms.student.Login;

import beans.service.Student;

public class StudentDAO implements StudentDAOInterface {

	private SessionFactory sf ;
	
	
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void checkSession()
	{
		System.out.println(sf != null ?"worked":"session factory is null");
	}
	/* (non-Javadoc)
	 * @see beans.dao.StudentDAOInterface#add(beans.service.Student)
	 */
	@Override
	public int add(Student student) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			System.out.println("Inside insert try");
			session.save(student);
			System.out.println("Before commit" + student.getEmail() + " " + student.getName() + " " + student.getPassword() + " "+ student.getPrn());
			tx.commit();
			System.out.println("after commit");
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			System.out.println("Inside Catch block of add");
			return 0;
			
		} finally {
			session.close();
		}
	}

	/* (non-Javadoc)
	 * @see beans.dao.StudentDAOInterface#getStudent(int)
	 */
	@Override
	public Student getStudent(String prn) {
		// TODO Auto-generated method stub
		

		Session session = sf.openSession();
		Query<Student> student = session.createQuery("from Student where prn = " + prn);
		
		
		return student.getSingleResult();
	}

	@Override
	public Student validateStudent(Login login) {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		System.out.println("PRN " + login.getPrn());
		System.out.println("Password " + login.getPassword() );
		
		try {
			Query<Student> student = session.createQuery("from Student where prn = '" + login.getPrn() + "'and password = '" + login.getPassword()+"'");
			return student.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
//			e.printStackTrace();
		}
	}

	@Override
	public String checkPrn(String prn) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		
		try {
			System.out.println("Inside check Prn method" + prn);
			Query<Student> prnNo = session.createQuery("from Student where prn = " + prn);
			
			return prnNo.getSingleResult().getPrn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}finally {
		}
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		Session session= sf.openSession();
		Query<Student> students = session.createQuery("from Student");
		return students.list();
//		return null;
	}
	

	@Override
	public List<Student> getAllStudents(String course) {
		// TODO Auto-generated method stub
		
		Session session= sf.openSession();
		Query<Student> students = session.createQuery("from Student where course = '" + course + "'");
		return students.list();
//		return null;
	}
	@Override
	public int countStudents() {
		// TODO Auto-generated method stub
		List<Student> st = getAllStudents();
		return st.size();
	}
	
	
	
	
	
	


	
}
