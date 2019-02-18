package com.qa.persistence.repository;

public interface MatchUpNoteRepository 
{
	//C
	String createMatchupNote(String note);
	//R
	String getAllMatchUpNotes();
	String getAMatchUpNote(int id);
	String getMatchUpNotesForCharacter(String character);
	//U
	String updateMatchUpNote(int id, String matchupNote);
	//D
	String deleteMatchUpNote(int id);
}
