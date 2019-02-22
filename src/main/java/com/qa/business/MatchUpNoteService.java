package com.qa.business;

import com.qa.persistence.repository.MatchUpNoteRepository;

public interface MatchUpNoteService {
	//C
	String createMatchupNote(String note);
	//R
	String getAMatchupNote(int id);
	String getMatchupNotesForCharacter(String vsCharacter);
	String getAllMatchupNotes();
	//U
	String updateMatchupNote(int id, String note);
	//D
	String deleteMatchupNote(int id);
	//Set method
	void setRepo(MatchUpNoteRepository repo);
}
