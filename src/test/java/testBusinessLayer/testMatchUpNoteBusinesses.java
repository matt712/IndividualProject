package testBusinessLayer;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.MatchUpNoteServiceImpl;
import com.qa.persistence.repository.MatchUpNoteRepository;

@RunWith(MockitoJUnitRunner.class)
public class testMatchUpNoteBusinesses {

	private static final String MOCK_DATA_ARRAY = "[{\"noteID\":1,\"vsCharacter\":\"Bob\",\"contents\":\"db4 launch punishable\"}]";
	private static final String MOCK_OBJECT = "{\"noteID\":2,\"vsCharacter\":\"Bryan\",\"contents\":\"Fear the snake edge\"}";
	private static final String MOCK_VALUE = "test_value";
	private static final int MOCK_ID = 1;
	@InjectMocks
	private MatchUpNoteServiceImpl serv;
	@Mock
	private MatchUpNoteRepository repo;
	@Before
	public void setUp() {
		serv.setRepo(repo);
	}
	@Test
	public void testCreateNote() {
		Mockito.when(repo.createMatchupNote(MOCK_OBJECT)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.createMatchupNote(MOCK_OBJECT));
	}
	@Test
	public void testGetAllNotes() {
		Mockito.when(repo.getAllMatchUpNotes()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.getAllMatchupNotes());
	}
	@Test 
	public void testGetANote() {
		Mockito.when(repo.getAMatchUpNote(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.getAMatchupNote(MOCK_ID));
	}
	@Test
	public void testGetMatchupNoteForCharacter() {
		Mockito.when(repo.getMatchUpNotesForCharacter(MOCK_OBJECT)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.getMatchupNotesForCharacter(MOCK_OBJECT));
	}
	@Test
	public void testUpdateNote() {
		Mockito.when(repo.updateMatchUpNote(MOCK_ID, MOCK_OBJECT)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.updateMatchupNote(MOCK_ID, MOCK_OBJECT));
	}
	@Test
	public void testDeleteNote() {
		Mockito.when(repo.deleteMatchUpNote(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.deleteMatchupNote(MOCK_ID));
	}
}
