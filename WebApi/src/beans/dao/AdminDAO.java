package beans.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.sms.student.AdminLogin;

import beans.service.Admin;
import beans.service.Student;

public class AdminDAO implements IAdminDAO {

	private SessionFactory sf;
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
	 * @see beans.dao.IAdminDAO#validateAdmin(beans.service.Admin)
	 */
	@Override
	public String validateAdmin(AdminLogin admin)
	{
		Session session = sf.openSession();
		System.out.println(admin.getUsername());
		System.out.println(admin.getPassword());
		Query<Admin> student = session.createQuery("from Admin where username = '" + admin.getUsername() + "' and password = '" + admin.getPassword()+"'");
//		System.out.println(student.getFirstResult());
		if(!student.list().isEmpty())
			return "success";
		return "failed";
	
		
	}
}
