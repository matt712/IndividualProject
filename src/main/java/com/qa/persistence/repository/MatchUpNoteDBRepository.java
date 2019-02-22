package com.qa.persistence.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.qa.persistence.domain.MatchUpNote;
import com.qa.util.JSONUtil;

public class MatchUpNoteDBRepository implements MatchUpNoteRepository{
	private EntityManager em;
	private JSONUtil util;
	public void setEm(EntityManager em2) {
		this.em = em2;
	}
	public void setUtil(JSONUtil util2) {
		this.util = util2;
	}
	public String createMatchupNote(String note) {
		MatchUpNote aNote = util.getObjectForJSON(note, MatchUpNote.class);
		em.persist(aNote);
		return "\"message\":\"Note has been created\"";
	}
	public String getAllMatchUpNotes() {
		Query query = em.createQuery("Select a FROM MatchUpNote a");
		Collection<MatchUpNote> notes = (Collection<MatchUpNote>) query.getResultList();
		return util.getJSONForObject(notes);
	}
	public String getAMatchUpNote(int id) {
		return util.getJSONForObject(em.find(MatchUpNote.class, id));
	}
	public String getMatchUpNotesForCharacter(String character) {
		Query query = em.createQuery("Select a FROM MatchUpNote a WHERE vsCharacter =" + character);
		Collection<MatchUpNote> notes = (Collection<MatchUpNote>) query.getResultList();
		return util.getJSONForObject(notes);
	}
	public String updateMatchUpNote(int id, String matchupNote) {
		deleteMatchUpNote(id);
		createMatchupNote(matchupNote);
		return "\"message\":\"Note has been updated\"";
	}
	public String deleteMatchUpNote(int id) {
		if(em.contains(em.find(MatchUpNote.class, id))) {
			em.remove(em.find(MatchUpNote.class, id));
		}
		return "\"message\":\"Note has been destroyed\"";
	}
}
