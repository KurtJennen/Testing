package chapter07.newoperator.partial;

import chapter07.newoperator.MyCollaborator;

public class MyPartialSut {

	public boolean myMethod() {
		MyCollaborator collaborator = createCollaborator();
		if (collaborator.someMethod()) {
			return true;
		} else {
			return false;
		}
	}

	protected MyCollaborator createCollaborator() {
		return new MyCollaborator();
	}
	
}
