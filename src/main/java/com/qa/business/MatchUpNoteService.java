package com.qa.business;

import com.qa.persistence.repository.MatchUpNoteRepository;

public interface MatchUpNoteService {
	//C
	String createMatchupNote(String note);
	//R
	String getAMatchupNote(int id);
	String getMatchupNotesForCharacter(String vsCharacter);
	String getAllMatchupNotes();
	String getUsersNotes(String user);
	String getUsersNoteForCharacter(String user, String vsCharacter);
	//U
	String updateMatchupNote(int id, String newContents);
	//D
	String deleteMatchupNote(int id);
	//Set method
	void setRepo(MatchUpNoteRepository repo);
}
