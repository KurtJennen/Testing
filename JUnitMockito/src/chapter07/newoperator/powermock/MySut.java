package chapter07.newoperator.powermock;

import chapter07.newoperator.MyCollaborator;

public class MySut {

	public boolean myMethod() {
		MyCollaborator collaborator = new MyCollaborator();
		if (collaborator.someMethod()) {
			return true;
		} else {
			return false;
		}
	}
	
}
