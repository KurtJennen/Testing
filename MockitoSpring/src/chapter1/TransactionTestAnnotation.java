package chapter1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTestAnnotation {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextTxAnnotation.xml");
		
		FooService fooService = (FooService) context.getBean("fooService");
		System.out.println(fooService);
		fooService.getFoo(null);

	}

}
