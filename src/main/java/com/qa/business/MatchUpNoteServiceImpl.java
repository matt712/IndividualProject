package com.qa.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import com.qa.persistence.domain.MatchUpNote;
import com.qa.persistence.repository.MatchUpNoteRepository;
import com.qa.util.JSONUtil;

public class MatchUpNoteServiceImpl implements MatchUpNoteService{

	@Inject
	private MatchUpNoteRepository repo;
	private JSONUtil util;
	public String createMatchupNote(String note) {
		util = new JSONUtil();
		MatchUpNote newChar = util.getObjectForJSON(note, MatchUpNote.class);
		newChar.setVsCharacter(newChar.getVsCharacter().toLowerCase());
		note = util.getJSONForObject(newChar);
		return repo.createMatchupNote(note);
	}
	public String getAMatchupNote(int id) {
		return repo.getAMatchUpNote(id);
	}
	public String getMatchupNotesForCharacter(String vsCharacter) {
		return repo.getMatchUpNotesForCharacter(vsCharacter);
	}
	public String getAllMatchupNotes() {
		return repo.getAllMatchUpNotes();
	}
	public String updateMatchupNote(int id, String newContents) {
		return repo.updateMatchUpNote(id, newContents);
	}
	public String deleteMatchupNote(int id) {
		return repo.deleteMatchUpNote(id);
	}

	public void setRepo(MatchUpNoteRepository repo2) {
		this.repo = repo2;
	}
	public String getUsersNotes(String user) {
		return repo.getAllUsersNotes(user);
	}
	public String getUsersNoteForCharacter(String user, String vsCharacter) {
		vsCharacter = vsCharacter.toLowerCase();
		return repo.getUsersNotesForChar(user, vsCharacter);
	}
}
