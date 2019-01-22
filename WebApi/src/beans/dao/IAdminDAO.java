package beans.dao;

import com.sms.student.AdminLogin;


public interface IAdminDAO {

	String validateAdmin(AdminLogin admin);
	public void checkSession();
}