package chapter1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextTx.xml");
		
		FooService fooService = (FooService)context.getBean("fooService");

		System.out.println(fooService);
		fooService.getFoo(null);
	}

}
