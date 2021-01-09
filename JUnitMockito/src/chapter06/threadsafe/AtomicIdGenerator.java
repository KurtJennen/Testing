package chapter06.threadsafe;

public class AtomicIdGenerator implements IdGenerator {
	private static Long nextId = System.currentTimeMillis();

	@Override
	public Long nextId() {
		return nextId++;
	}

}
