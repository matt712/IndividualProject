package com.qa.rest;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.apache.log4j.Logger;

import com.qa.business.UserService;

@Path("/user")
public class UserEndPoint {
	@Inject
	private UserService serv;
	public void setService(UserService serv2) {
		this.serv = serv2;
	}
	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String createUser(String user) {
		return serv.createUser(user);
	}
	@Path("/getAllUsers")
	@GET
	@Produces("application/json")
	public String getAllUsers() {
		return serv.getAllUsers();
	}
	@Path("/getAUser/{username}")
	@GET
	@Produces({ "application/json" })
	public String getAUser(@PathParam("username") String username) {
		return serv.getAUser(username);
	}
	@Path("/updateUser/{username}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("username") String username, String user) {
		return serv.updateUser(username, user);
	}
	@Path("/deleteUser/{username}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("username") String username) {
		return serv.deleteUser(username);
	}

}
