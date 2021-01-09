package chapter06.assume;

import static org.junit.Assume.assumeTrue;

import org.junit.Test;

public class AssumeTest {

	@Test
	public void shouldRunOnlyOnWindows() {
		assumeTrue(thisIsAWindowsMachine());
		System.out.println("running on Windows");
	}
	
	private boolean thisIsAWindowsMachine() {
		return System.getProperty("os.name").startsWith("Windows");
	}
	
	public void shouldRunOnlyOnLinux() {
		assumeTrue(thisIsALinuxMachine());
		System.out.println("running on Linux");
	}
	
	private boolean thisIsALinuxMachine() {
		return System.getProperty("os.name").startsWith("Linux");
	}
	
}
