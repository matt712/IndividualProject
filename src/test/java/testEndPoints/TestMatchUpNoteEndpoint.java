package testEndPoints;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.MatchUpNoteService;
import com.qa.rest.MatchUpNoteEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class TestMatchUpNoteEndpoint {
	
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	private static final int MOCK_ID = 1;
	@InjectMocks
	private MatchUpNoteEndpoint endy;
	@Mock
	private MatchUpNoteService serv;
	@Before
	public void setUp() {
		endy.setService(serv);
	}
	@Test
	public void testCreateNote() {
		Mockito.when(serv.createMatchupNote(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.createMatchUpNote(MOCK_VALUE));
	}
	@Test
	public void testGetANote() {
		Mockito.when(serv.getAMatchupNote(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.getAMatchupNote(MOCK_ID));
	}
	@Test
	public void testGetAllNotes() {
		Mockito.when(serv.getAllMatchupNotes()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.getAllMatchupNotes());
	}
	@Test
	public void testGetNotesForMatchup() {
		Mockito.when(serv.getMatchupNotesForCharacter(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.getMatchupNotesForCharacter(MOCK_VALUE));
	}
	@Test
	public void testGetUserNotes() {
		Mockito.when(serv.getUsersNotes(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.getUsersMatchupNotes(MOCK_VALUE2));
	}
	@Test
	public void testGetUsersNotesForMatchup() {
		Mockito.when(serv.getUsersNoteForCharacter(MOCK_VALUE, MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.getUsersNotesForCharacter(MOCK_VALUE, MOCK_VALUE2));
	}
	@Test
	public void testGetUpdateNote() {
		Mockito.when(serv.updateMatchupNote(MOCK_ID, MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endy.updateMatchupNote(MOCK_ID, MOCK_VALUE));
	}
	@Test
	public void testDeleteNote() {
		Mockito.when(serv.deleteMatchupNote(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endy.deleteMatchupNote(MOCK_ID));
	}

}
