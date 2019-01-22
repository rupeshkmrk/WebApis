package beans.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.dao.DashboardDAO;
import beans.dao.IDashboardDAO;

public class DashboardService implements IDashboardService {

	
	IDashboardDAO dao;
	ClassPathXmlApplicationContext context;
	
	public DashboardService() {
		// TODO Auto-generated constructor stub
		
		context = new ClassPathXmlApplicationContext("dashboard.xml");
		dao = context.getBean(DashboardDAO.class);
		
	}
	
	
	public int getContent()
	{
		return dao.getContent();
	}
	
}
