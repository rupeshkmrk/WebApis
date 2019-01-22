package com.sms.student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.service.StudentService;
import beans.service.StudentServiceInterface;

@Path("/checkprn")
public class CheckPrn {


	@GET
	@Path("{prn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkPrn(@PathParam("prn") String prn)
	{
		System.out.println("checkprn called");
		//return "working";
		System.out.println(prn);
		StudentServiceInterface si = new StudentService();
		String out = si.checkPrn(prn);
		System.out.println("output is " + out);
		if(out.equals(prn))
			return Response.status(200).build();
			//return "success";
		else
			return Response.status(500).build();
	
	}
}
