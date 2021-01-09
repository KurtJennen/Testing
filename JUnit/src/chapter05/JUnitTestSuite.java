package chapter05;

import junit.framework.TestResult;
import junit.framework.TestSuite;


public class JUnitTestSuite {

		public static void main(String[] args) {
			TestSuite suite = new TestSuite(TestJUnit1.class, TestJUnit2.class, TestJUnit3.class);
			TestResult result = new TestResult();
			suite.run(result);
			System.out.println("Number of testcases = " + result.runCount());
		}
	
}
