package chapter1;

public class BaseEntity {
	
	static {
		String x = null;
		x.toString();
	}
	
	public BaseEntity() {
		throw new UnsupportedOperationException();
	}
	
	protected void performAudit(String auditInformation) {
		throw new UnsupportedOperationException();
	}
}
