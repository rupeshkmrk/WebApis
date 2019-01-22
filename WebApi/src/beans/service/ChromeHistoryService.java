package beans.service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sms.model.ChromeHistory;
import com.sms.utils.SortUrls;

import beans.dao.ChromeHistoryDAO;

public class ChromeHistoryService {

	ChromeHistoryDAO dao;
	ClassPathXmlApplicationContext context ;
	public ChromeHistoryService() {
		// TODO Auto-generated constructor stub

		context = new ClassPathXmlApplicationContext("history.xml");

		dao = context.getBean(ChromeHistoryDAO.class);
		dao.checkSession();
	}

	public int insert(List<ChromeHistory> list)
	{
		return dao.insert(list);
	}

	
	public List<ChromeHistory> getHistory(String user)
	{
		List<ChromeHistory> history = dao.getHistory();
		List<ChromeHistory> histList = new ArrayList<>();
		for(ChromeHistory hist : history)
		{
			System.out.println(hist.getUser());
			try {

				if(hist.getUser().equals(user))
					histList.add(hist);
			}catch(NullPointerException ex)
			{
				
			}
				
		}
		return histList;
	}
	
	public Map<String,Integer> getUrls()
	{
		HashMap<String, Integer> hm = new HashMap<>();
		List<ChromeHistory> allUrls = dao.getHistory();
		System.out.println("All Url Size " + allUrls.size());

		try {
			for (ChromeHistory chromeHistory : allUrls) {

				String domain = "";

				System.out.println(chromeHistory.getUrl());
				domain = GetUrl.getDomainName(chromeHistory.getUrl());


				if(!hm.containsKey(domain))
				{
					hm.put(domain, 1);
				}
				else
				{
					int value = hm.get(domain);
					hm.put(domain, value + 1);
				}

				System.out.println("HashMap " + hm);
				
				//				System.out.println(sortedUrls);
			} 
		}catch (Exception e) {
			// TODO: handle exception
		}

		Map<String, Integer> sortedUrls = SortUrls.sortByComparator(hm, SortUrls.DESC);

		/*List<HashMap<String, Integer>> list = new ArrayList<>();
		
		for(Map.Entry<String, Integer> key : sortedUrls.entrySet())
		{
			list.add(new HashMap().put(key.getKey(),key.getValue()));
		}*/
		System.out.println("Sorted URLS " + sortedUrls);
		return sortedUrls;


	
	}
}
