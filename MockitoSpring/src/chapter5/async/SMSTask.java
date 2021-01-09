package chapter5.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class SMSTask {

	@Async
	public Future<Boolean> send(String... string) {
		System.out.println("Selecting SMS format ");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return new AsyncResult<Boolean>(false);
		}
		
		System.out.println("Async SMS send task is complete!!!");
		
		return new AsyncResult<Boolean>(true);
	}

}
