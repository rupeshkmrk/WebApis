package com.sms.student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.service.StudentService;
import beans.service.StudentServiceInterface;

@Path("/forgotpassword")
public class ForgotPassword {

	@GET
	@Path("{prn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam("prn") String prn)
	{
//		return "get called" + prn;
		System.out.println("get Called");
		StudentServiceInterface si = new StudentService();
		beans.service.Student st = si.getStudent(prn);
		if(st != null)
		{
			
			return Response.status(200).entity(st).build();
		}
		return Response.status(200).entity(st).build();
	}
}
