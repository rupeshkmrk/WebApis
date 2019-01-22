package beans.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sms.model.DashboardDetails;

import beans.service.Student;

public class DashboardDAO implements IDashboardDAO {

	
	private SessionFactory sf;
	@Override
	public int getContent() {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query<Student> list = session.createQuery("from Student");
		return list.list().size();
		
	}
	
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

	
	
}
