package com.qa.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.MatchUpNote;
import com.qa.util.JSONUtil;

@Default
@Transactional
public class MatchUpNoteDBRepository implements MatchUpNoteRepository{
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	@Inject
	private JSONUtil util;
	public void setEm(EntityManager em2) {
		this.em = em2;
	}
	public void setUtil(JSONUtil util2) {
		this.util = util2;
	}
	@Transactional
	public String createMatchupNote(String note) {
		MatchUpNote aNote = util.getObjectForJSON(note, MatchUpNote.class);
		em.persist(aNote);
		return "{\"message\":\"Note has been created\"}";
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
		Query query = em.createQuery("Select a FROM MatchUpNote a WHERE vsCharacter LIKE '%" + character + "%'");
		Collection<MatchUpNote> notes = (Collection<MatchUpNote>) query.getResultList();
		return util.getJSONForObject(notes);
	}
	public String getAllUsersNotes(String user) {
		Query query = em.createQuery("SELECT a FROM MatchUpNote a WHERE username='" + user + "'");
		Collection<MatchUpNote> notes = (Collection<MatchUpNote>) query.getResultList();
		return util.getJSONForObject(notes);
	}
	public String getUsersNotesForChar(String user, String vsCharacter) {
		Query query = em.createQuery("SELECT a FROM MatchUpNote a WHERE username='" + user + "' AND vsCharacter LIKE '%" + vsCharacter + "%'");
		Collection<MatchUpNote> notes = (Collection<MatchUpNote>) query.getResultList();
		return util.getJSONForObject(notes);
	}
	@Transactional
	public String updateMatchUpNote(int id, String newContents) {
		MatchUpNote thisNote = em.find(MatchUpNote.class, id);
		thisNote.setContents(newContents);
		return "{\"message\":\"Note has been updated\"}";
	}
	@Transactional
	public String deleteMatchUpNote(int id) {
		if(em.contains(em.find(MatchUpNote.class, id))) {
			em.remove(em.find(MatchUpNote.class, id));
		}
		return "{\"message\":\"Note has been destroyed\"}";
	}
}
