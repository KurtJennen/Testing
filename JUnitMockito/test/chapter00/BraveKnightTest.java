package chapter00;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class BraveKnightTest {

	@Test
	public void knightShouldEmbarkOnQuest() throws QuestException {
		Quest mockQuest = mock(Quest.class);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.setMotivated(true);
		knight.embarkOnQuest();
		
		verify(mockQuest, times(1)).embark();
	}
	
	@Test
	public void knightShouldNotEmbarkOnQuest() throws QuestException {
		Quest mockQuest = mock(Quest.class);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		
		verify(mockQuest, times(0)).embark();
	}
	
	@Test
	public void knightQuestNotCompleted() throws QuestException {
		Quest mockQuest = mock(Quest.class);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.setMotivated(true);
		knight.embarkOnQuest();
		boolean status = knight.isQuestDone();
		
		verify(mockQuest, times(1)).embark();
		assertFalse("Should be False (not completed).", status);
	}
	
	@Test
	public void knightQuestCompleted() throws QuestException {
		Quest mockQuest = mock(Quest.class);
		when(mockQuest.isCompleted()).thenReturn(true);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		knight.setMotivated(true);
		knight.embarkOnQuest();
		boolean status = knight.isQuestDone();
		
		verify(mockQuest, times(1)).embark();
		assertTrue("Should be True (completed).", status);
	}
	
	@Test
	public void knightQuestDistance() {
		Quest mockQuest = mock(Quest.class);
		when(mockQuest.getDistance()).thenReturn(100);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		int miles = knight.getMilesTravelled();
		
		assertEquals(100, miles);
	}
	
	@Test
	public void knightQuestLetter() {
		Quest mockQuest = mock(Quest.class);
		when(mockQuest.getLetter()).thenReturn('c');
		
		BraveKnight knight = new BraveKnight(mockQuest);
		char questLetter = knight.tellQuestLetter();
		
		assertEquals('c', questLetter);
	}
	
	@Test
	public void knightQuestName() {
		Quest mockQuest = mock(Quest.class);
		when(mockQuest.getName()).thenReturn("Quest for the Holy Grail");
		
		BraveKnight knight = new BraveKnight(mockQuest);
		String questName = knight.tellQuestName();
		
		assertTrue(("Quest for the Holy Grail").equalsIgnoreCase(questName));
	}
	
	@Test
	public void knightNoQuestName() {
		Quest mockQuest = mock(Quest.class);
		when(mockQuest.getName()).thenReturn(null);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		String questName = knight.tellQuestName();
		
		assertNull(questName);
	}
	
	@Test
	public void knightGetQuest() {
		Quest mockQuest = mock(Quest.class);
		when(mockQuest.getName()).thenReturn(null);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		Quest myQuest = knight.getQuest();
		
		assertEquals(myQuest, mockQuest);
	}
	
	@Test
	public void knightDragonQuest() {
		DragonQuest mockQuest = mock(DragonQuest.class);
		DragonsHead dragonsHead = new DragonsHead("red");
		when(mockQuest.getQuestProof()).thenReturn(dragonsHead);
		
		BraveKnight knight = new BraveKnight(mockQuest);
		Object proof = knight.getQuestProof();
		
		assertNotNull("Object is null", proof);
		assertTrue(proof instanceof DragonsHead);
	}
	
	@Test
	public void knightQuestException() throws QuestException {
		Quest mockQuest = mock(Quest.class);
		boolean success = false;
		QuestException ex = new QuestException("Thrown by Mockito");
		doThrow(ex).when(mockQuest).embark();
		
		try {
			BraveKnight knight = new BraveKnight(mockQuest);
			knight.setMotivated(true);
			knight.embarkOnQuest();
			success= true;
			assertFalse(success);
		} catch (Exception e) {
			assertFalse(success);
			assertTrue(e instanceof QuestException);
			assertEquals(ex.getMessage(), "Thrown by Mockito");
		}
	}
	
	@Test
	public void knightNoQuestException() throws QuestException {
		DragonQuest mockQuest = mock(DragonQuest.class);
		boolean success = false;
		
		try {
			BraveKnight knight = new BraveKnight(mockQuest);
			knight.setMotivated(true);
			knight.embarkOnQuest();
			success= true;
			assertTrue(success);
		} catch (Exception e) {
			assertTrue(success);
		}
	}
	
}
