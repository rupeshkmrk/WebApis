package com.sms.student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sms.model.ChromeHistory;
import com.sms.model.DashboardDetails;

import beans.service.AdminService;
import beans.service.ChromeHistoryService;
import beans.service.IAdmin;
import beans.service.ScreenshotService;
import beans.service.StudentService;
import beans.service.StudentServiceInterface;

@Path("/admin")
public class Admin {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{course}")
	public List<beans.service.Student> getDACStudents(@PathParam("course") String course)
	{
		
		StudentServiceInterface si = new StudentService();
		List<beans.service.Student> student = si.getAllStudents(course);
		System.out.println(student);
		
		return student;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dashboard")
	public DashboardDetails test()
	{
		Student st =new Student();
		int dac = 0;
		int ditiss = 0;
		List<beans.service.Student> studentList = st.getStudents();
		for (beans.service.Student student : studentList) {
			if(student.getCourse().equals("PG-DAC"))
				dac++;
			else
				ditiss++;
		}
		String online = "";
		DashboardDetails dashboard = new DashboardDetails(st.getStudents().size()+"", dac+"", ditiss+"", online);
		return dashboard;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/urls/{prn}")
	public List<ChromeHistory> getUrls(@PathParam("prn") String prn)
	{
		ChromeHistoryService cs = new ChromeHistoryService();
		
		 return cs.getHistory(prn);
		//Map<String,Integer> map = cs.getUrls();
		
		/*Map<String, Integer> topMap = new HashMap<>();
		
		 Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator(); 
         
		 int count = 0;
	        while(itr.hasNext() && count <= 5) 
	        {  
	             Map.Entry<String, Integer> entry = itr.next(); 
	             topMap.put(entry.getKey(), entry.getValue());
	             System.out.println("Key = " + entry.getKey() +  
	                                 ", Value = " + entry.getValue()); 
	             count++;
	        } 
		*/
		/*System.out.println("MAP " + map);
		return map;*/
	}
	
/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/urls")
	public Map<String,Integer> getUrlsByUser()
	{
		ChromeHistoryService cs = new ChromeHistoryService();
		Map<String,Integer> map = cs.getUrls();
		Map<String, Integer> topMap = new HashMap<>();
		
		 Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator(); 
         
		 int count = 0;
	        while(itr.hasNext() && count <= 5) 
	        {  
	             Map.Entry<String, Integer> entry = itr.next(); 
	             topMap.put(entry.getKey(), entry.getValue());
	             System.out.println("Key = " + entry.getKey() +  
	                                 ", Value = " + entry.getValue()); 
	             count++;
	        } 
		
		System.out.println("MAP " + map);
		return map;
	}
	*/
	@POST
	public String calling()
	{
		ScreenshotService ss = new ScreenshotService();
		ss.saveImage();
		return "image saved";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response login(AdminLogin login)
	{
		System.out.println("Method Calling");
		IAdmin si = new AdminService();
		System.out.println("Inside Login");
		String response = si.validateAdmin(login);
		System.out.println(response);
		if(response.equals("success"))
			return Response.status(200).encoding(response).build();
		return Response.status(500).build();
//		return Response.status(500).build();
//		return "called";
	}
}
