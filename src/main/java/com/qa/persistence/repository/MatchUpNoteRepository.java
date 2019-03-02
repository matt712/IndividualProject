package com.qa.persistence.repository;

public interface MatchUpNoteRepository 
{
	//C
	String createMatchupNote(String note);
	//R
	String getAllMatchUpNotes();
	String getAMatchUpNote(int id);
	String getMatchUpNotesForCharacter(String character);
	String getAllUsersNotes(String user);
	String getUsersNotesForChar(String user, String vsCharacter);
	//U
	String updateMatchUpNote(int id, String matchupNote);
	//D
	String deleteMatchUpNote(int id);
	
}
