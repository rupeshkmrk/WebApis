package beans.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.dao.ScreenshotDAO;

public class ScreenshotService {

	
	ScreenshotDAO adminDAO ;
	ClassPathXmlApplicationContext context;
	public ScreenshotService() {
		// TODO Auto-generated constructor stub
		adminDAO = new ScreenshotDAO();
		System.out.println("AdminDAO constructor called");
		context = new ClassPathXmlApplicationContext("screenshot.xml");
		adminDAO = context.getBean(ScreenshotDAO.class);
		adminDAO.checkSession();
	}
	
	public void saveImage()
	{
		adminDAO.saveImage();
	}
}
