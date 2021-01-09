package chapter06.threadsafe;

public class SystemIdGenerator implements IdGenerator {

	@Override
	public Long nextId() {
		return System.currentTimeMillis();
	}

}
