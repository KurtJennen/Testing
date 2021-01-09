package chapter00;

public class Quest {
	
	private boolean completed;
	private int distance;
	private char letter;
	private String name;

	public void embark() throws QuestException {
		System.out.println("Embarking on a quest");
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public int getDistance() {
		return distance;
	}

	public char getLetter() {
		return letter;
	}
	
	public String getName() {
		return name;
	}
	
	public Object getQuestProof() {
		return "Proof.";
	}
}
