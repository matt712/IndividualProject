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

import com.qa.business.MatchUpNoteService;
@Path("/MatchUpNote")
public class MatchUpNoteEndpoint {
	
	private MatchUpNoteService serv;
	public void setService(MatchUpNoteService serv2) {
		this.serv = serv2;
	}
	@Path("/createMatchupNote")
	@POST
	@Produces({ "application/json" })
	public String createMatchUpNote(String note) {
		return serv.createMatchupNote(note);
	}
	@Path("/getMatchupNote/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAMatchupNote(@PathParam("id") int id) {
		return serv.getAMatchupNote(id);
	}
	@Path("/getAllMatchupNotes")
	@GET
	@Produces( "application/json" )
	public String getAllMatchupNotes() {
		return serv.getAllMatchupNotes();
	}
	@Path("/getMatchupNotesForChar/{vsCharacter}")
	@GET
	@Produces({ "application/json" })
	public String getMatchupNotesForCharacter(@PathParam("vsCharacter")String vsCharacter) {
		return serv.getMatchupNotesForCharacter(vsCharacter);
	}
	@Path("/updateMatchupNote/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMatchupNote(@PathParam("id") int id, String note) {
		return serv.updateMatchupNote(id, note);
	}
	@Path("/deleteMatchUpNote/{id}")
	@DELETE
	@Produces({ "application/json" })
	public Object deleteMatchupNote(@PathParam("id") int id) {
		return serv.deleteMatchupNote(id);
	}

}
