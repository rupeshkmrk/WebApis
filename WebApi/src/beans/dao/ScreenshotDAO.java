package beans.dao;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.service.Screenshot;

public class ScreenshotDAO {

	
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
	
	public ScreenshotDAO() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void saveImage()
	{
		Session session = sf.openSession();
		File file = new File("F:\\WorkingProject\\001.jpg");
		byte[] imageData = new byte[(int) file.length()];
		try {
		    FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(imageData);
		    fileInputStream.close();
		    Screenshot image = new Screenshot();
		    image.setImageName("test.jpeg");
		    image.setImage(imageData);
		    image.setImageTime("now");
		     
		     session.save(image); //Save the data
		     session.beginTransaction().commit();
		     session.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
