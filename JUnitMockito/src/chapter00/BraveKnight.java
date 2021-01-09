package chapter00;

public class BraveKnight implements Knight {

	private Quest quest;
	private boolean motivated;
	private boolean embarkedOnQuest;
	
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}
	
	public void embarkOnQuest() throws QuestException {
		if (motivated) {
			quest.embark();
			embarkedOnQuest = true;
		}
	}

	public void setMotivated(boolean motivated) {
		this.motivated = motivated;		
	}
	
	public boolean isQuestDone() {
		return embarkedOnQuest && quest.isCompleted();
	}
	
	public int getMilesTravelled() {
		return quest.getDistance();
	}
	
	public char tellQuestLetter() {
		return quest.getLetter();
	}
	
	public String tellQuestName() {
		return quest.getName();
	}
	
	public Quest getQuest() {
		return quest;
	}
	
	public Object getQuestProof() {
		return quest.getQuestProof();
	}
}
