package com.sms.student;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sms.model.DashboardDetails;

import beans.service.StudentService;
import beans.service.StudentServiceInterface;

@Path("/student")
public class Student {

	
/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dashboard")
	public DashboardDetails test()
	{
		int dac = 0;
		int ditiss = 0;
		List<beans.service.Student> studentList = getStudents();
		for (beans.service.Student student : studentList) {
			if(student.getCourse().equals("PG-DAC"))
				dac++;
			else
				ditiss++;
		}
		String online = "";
		DashboardDetails dashboard = new DashboardDetails(getStudents().size()+"", dac+"", ditiss+"", online);
		return dashboard;
	}*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{prn}")
	public beans.service.Student getStudent(@PathParam("prn") String prn)
	{
//		return "get called" + prn;
		System.out.println("get Called");
		StudentServiceInterface si = new StudentService();
		beans.service.Student st = si.getStudent(prn);
		return st;
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<beans.service.Student> getStudents()
	{
		
		StudentServiceInterface si = new StudentService();
		List<beans.service.Student> student = si.getAllStudents();
		System.out.println(student);
		return student;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	@Path("/login")
	public Response login(Login login)
	{
		StudentServiceInterface si = new StudentService();
		System.out.println("Inside Login");
		beans.service.Student student = si.validateStudent(login);
		if(student != null)
			return Response.status(200).entity(student).build();
		
		return Response.status(500).build();
//		return "called";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/register")
	public Response createStudent(beans.service.Student student)
	{
		System.out.println("Create Student Called");
		StudentServiceInterface si = new StudentService();
		int i = si.insert(student);

		System.out.println("Rows Affected " + i);
		if(i > 0)
		{
			System.out.println("Rows Affected " + i);
			System.out.println(Response.status(200).entity(student).build() + " Status ");
			return Response.status(200).entity(student).build();
		}
		else
			return null;
	
	}

	@PUT
	@Path("/put")
	public String updateStudent()
	{
		/* to be implemented*/
		return "Update is to be implemented";
	}
	
	@DELETE
	@Path("/delete")
	public String deleteStudent()
	{
		return "Delete is to be implemented";
	}
	
}
