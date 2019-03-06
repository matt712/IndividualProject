package com.qa.rest;
import java.security.NoSuchAlgorithmException;

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
	public String createUser(String user) throws NoSuchAlgorithmException {
		return serv.createUser(user);
	}
	@Path("/LoginUser")
	@POST
	@Produces({"application/json"})
	public String loginUser(String user) throws NoSuchAlgorithmException {
		return serv.loginUser(user);
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
	@Path("/updateUserPassword/{username}")
	@PUT
	@Produces({ "application/json" })
	public String updateUserPassword(@PathParam("username") String username, String newPassword) throws NoSuchAlgorithmException {
		return serv.updateUserPassword(username, newPassword);
	}
	@Path("/deleteUser/{username}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("username") String username) {
		return serv.deleteUser(username);
	}

}
