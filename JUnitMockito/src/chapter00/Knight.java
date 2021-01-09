package chapter00;

public interface Knight {
	public void embarkOnQuest() throws QuestException;
	public void setMotivated(boolean motivated);
	public boolean isQuestDone();
	public int getMilesTravelled();
	public char tellQuestLetter();
	public String tellQuestName();
	public Quest getQuest();
	public Object getQuestProof();
}
