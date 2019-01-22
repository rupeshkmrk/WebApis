package com.sms.student;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.sms.model.ChromeHistory;

import beans.service.ChromeHistoryService;

@Path("/url")
public class UrlLogger {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(List<ChromeHistory> list)
	{
		ChromeHistoryService cs = new ChromeHistoryService();
		int i = cs.insert(list);
		if(i>0)
		{
			return "success";
			
		}
		return "failed";
	}
	
}
