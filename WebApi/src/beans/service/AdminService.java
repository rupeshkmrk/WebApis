package beans.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.student.AdminLogin;

import beans.dao.AdminDAO;
import beans.dao.IAdminDAO;

public class AdminService implements IAdmin {

	
	IAdminDAO adminDAO;

	ClassPathXmlApplicationContext context ;

	public AdminService() {
		// TODO Auto-generated constructor stub
		//adminDAO = new AdminDAO();
		System.out.println("AdminDAO constructor called");
		context = new ClassPathXmlApplicationContext("admin.xml");
		adminDAO = context.getBean(AdminDAO.class);
		adminDAO.checkSession();
	}
	
	/* (non-Javadoc)
	 * @see beans.service.IAdmin#validateAdmin(beans.service.Admin)
	 */
	
	
	@Override
	public String validateAdmin(AdminLogin admin)
	{
		
		return adminDAO.validateAdmin(admin);
	}
	
}
