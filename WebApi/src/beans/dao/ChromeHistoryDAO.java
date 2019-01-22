package beans.dao;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sms.model.ChromeHistory;
import com.sms.model.StaticValue;

public class ChromeHistoryDAO {
	
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

	Transaction tx;
	static List<ChromeHistory> db = new ArrayList<>();

	public int insert(List<ChromeHistory> list)
	{
		//Date date = new Date();
		Session session = sf.openSession();
		for(int i = 0;i < list.size();i++)
		{
			try {
				tx = session.beginTransaction();
				ChromeHistory ch = new ChromeHistory();
				//long id = date.getTime();
				/*Calendar calendar = Calendar.getInstance();    
				calendar.set(Calendar.MILLISECOND, 0); // Clear the millis part. Silly API.
				calendar.set(2010, 8, 14, 0, 0, 0); // Note that months are 0-based
				long date = calendar.getTimeInMillis();*/
				//long millis = date.getTime();
				//System.out.println(date);
				System.out.println(StaticValue.count);
				ch.setId(StaticValue.count++ + "");
				//ch.setId(id+"");
				ch.setUrl(list.get(i).getUrl());
				ch.setTitle(list.get(i).getTitle());
				ch.setVisitedTime(list.get(i).getVisitedTime());
				session.save(ch);
				tx.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
		}
		return 1;
		
	}
	
	
	public List<ChromeHistory> getHistory()
	{
		
		Session session = sf.openSession();
		Query<ChromeHistory> historyList = session.createQuery("from ChromeHistory order by visitedTime desc");
		System.out.println(historyList.list().size());
		if(!historyList.list().isEmpty())
			return historyList.list();
		return null;
	}
	
	/*	public int insert(List<ChromeHistory> list)
	{
		
		Session session = sf.openSession();

		for (ChromeHistory chromeHistory : list) {
			tx = session.beginTransaction();
//			list.add(chromeHistory);
			System.out.println("Inside DATA layer");
			System.out.println(chromeHistory.getVisitedTime());
			session.save(chromeHistory);
			tx.commit();
		}
		session.close();
		return 1;
		
	}*/
}
