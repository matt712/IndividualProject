package testDomains;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.persistence.domain.MatchUpNote;

public class MatchUpNoteTest {

	MatchUpNote note1 = new MatchUpNote();
	@Test
	public void testVsCharacter() {
		note1.setVsCharacter("Hwoarang");
		assertEquals("Hwoarang", note1.getVsCharacter());
	}
	@Test
	public void testNoteID()
	{
		note1.setId(1);
		assertEquals(1, note1.getId());
	}
	@Test
	public void testNoteContents()
	{
		note1.setContents("duck backlash");
		assertEquals("duck backlash", note1.getContents());
	}
}
