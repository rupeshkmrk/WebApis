package com.sms.student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.service.DashboardService;
import beans.service.IDashboardService;


@Path("/dashboard")
public class Dashboard {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.TEXT_PLAIN)
//	@Path("{data}")
	public String get()
	{
		IDashboardService dashboardService = new DashboardService();
		int i = dashboardService.getContent();
		return i + "";
	}
	
	

}
