package chapter07.newoperator.injection.constructor;

import chapter07.newoperator.MyCollaborator;

public class MySut {
	
	@SuppressWarnings("unused")
	private final MyCollaborator collab;
	
	public MySut(MyCollaborator collab) {
		this.collab = collab;
	}
	
	public void myMethod() {
		
	}

}
