package testRepositories;

import static org.junit.Assert.*;
import org.junit.Test;

import com.qa.persistence.domain.MatchUpNote;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.MatchUpNoteDBRepository;
import com.qa.persistence.repository.UserDBRepository;
import com.qa.util.JSONUtil;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MatchupNoteRepoDBTest {

	@InjectMocks
	private MatchUpNoteDBRepository repo;
	@Mock
	private EntityManager em;
	@Mock 
	private Query query;
	private JSONUtil util;
	private static final String MOCK_DATA_ARRAY = "[{\"noteID\":1,\"vsCharacter\":\"Bob\",\"contents\":\"db4 launch punishable\",\"username\":\"matt\"}]";
	private static final String MOCK_OBJECT = "{\"noteID\":1,\"vsCharacter\":\"Bob\",\"contents\":\"db4 launch punishable\",\"username\":\"matt\"}";
	private static final int MOCK_ID = 1;
	@Before
	public void setUp() {
		repo.setEm(em);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	@Test
	public void testCreateNote() {
		String reply =repo.createMatchupNote(MOCK_OBJECT);
		assertEquals(reply, "{\"message\":\"Note has been created\"}");
	}
	@Test
	public void testGetAllNotes() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<MatchUpNote> notes = new ArrayList<MatchUpNote>();
		notes.add(util.getObjectForJSON(MOCK_OBJECT, MatchUpNote.class));
		Mockito.when(query.getResultList()).thenReturn(notes);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllMatchUpNotes());
	}
	@Test
	public void testGetANote() {
		Mockito.when(em.find(MatchUpNote.class, 1)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, MatchUpNote.class));
		assertEquals(MOCK_OBJECT, repo.getAMatchUpNote(1));
	}
	@Test
	public void testGetNotesForCharacter() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<MatchUpNote> notes = new ArrayList<MatchUpNote>();
		notes.add(util.getObjectForJSON(MOCK_OBJECT, MatchUpNote.class));
		Mockito.when(query.getResultList()).thenReturn(notes);
		assertEquals(MOCK_DATA_ARRAY, repo.getMatchUpNotesForCharacter("Bob"));
	}
	@Test
	public void testGetUsersNotes() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<MatchUpNote> notes = new ArrayList<MatchUpNote>();
		notes.add(util.getObjectForJSON(MOCK_OBJECT, MatchUpNote.class));
		Mockito.when(query.getResultList()).thenReturn(notes);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllUsersNotes("matt"));
	}
	@Test
	public void testGetUserNotesVsCharacter() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<MatchUpNote> notes = new ArrayList<MatchUpNote>();
		notes.add(util.getObjectForJSON(MOCK_OBJECT, MatchUpNote.class));
		Mockito.when(query.getResultList()).thenReturn(notes);
		assertEquals(MOCK_DATA_ARRAY, repo.getUsersNotesForChar("matt", "Bob"));
	}
	@Test
	public void testUpdateNote() {
		MatchUpNote aNote = util.getObjectForJSON(MOCK_OBJECT, MatchUpNote.class);
		Mockito.when(em.find(MatchUpNote.class, MOCK_ID)).thenReturn(aNote);
		String reply = repo.updateMatchUpNote(1, "watch out for sidesteps");
		assertEquals(reply, "{\"message\":\"Note has been updated\"}");
	}
	@Test
	public void testDeleteNote(){
		String reply = repo.deleteMatchUpNote(1);
		assertEquals(reply, "{\"message\":\"Note has been destroyed\"}");
	}
}
