package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.MatchUpNoteRepository;

public class MatchUpNoteServiceImpl implements MatchUpNoteService{

	@Inject
	private MatchUpNoteRepository repo;
	public String createMatchupNote(String note) {
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
	public String updateMatchupNote(int id, String note) {
		return repo.updateMatchUpNote(id, note);
	}
	public String deleteMatchupNote(int id) {
		return repo.deleteMatchUpNote(id);
	}

	public void setRepo(MatchUpNoteRepository repo2) {
		this.repo = repo2;
	}

}
