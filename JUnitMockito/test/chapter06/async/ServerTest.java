package chapter06.async;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.jayway.awaitility.Awaitility;

public class ServerTest {
	
	@Test
	public void shouldSaveTasks() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		TaskService taskService = mock(TaskService.class);
		Task task = mock(Task.class);
		Collection<Task> listOfTasks = Arrays.asList(task);
		
		Server server = new Server(executorService, taskService);
		server.serve(listOfTasks);
		
		Thread.sleep(1000);
		
		verify(taskService).handle(task);
	
	}
	
	@Test
	public void shouldSaveTasksUsingTryCatch() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		TaskService taskService = mock(TaskService.class);
		Task task = mock(Task.class);
		Collection<Task> listOfTasks = Arrays.asList(task);
		
		Server server = new Server(executorService, taskService);
		server.serve(listOfTasks);
		
		boolean handleMehodInvoked = false;
		
		for (int i = 0; i < 10; i++) {
			try {
				verify(taskService).handle(task);
				handleMehodInvoked = true;
			} catch (AssertionError ae) {
			}
			Thread.sleep(100);
		}
		
		assertTrue(handleMehodInvoked);
		
	}
	
	@Test
	public void shouldSaveTasksUsingAwaitility() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		TaskService taskService = mock(TaskService.class);
		Task task = mock(Task.class);
		Collection<Task> listOfTasks = Arrays.asList(task);
		
		Server server = new Server(executorService, taskService);
		server.serve(listOfTasks);
		
		Awaitility.await().atMost(1, TimeUnit.SECONDS).with().pollInterval(100, TimeUnit.MILLISECONDS).until(new Callable<Boolean>() {
			
			@Override
			public Boolean call() throws Exception {
				try {
					verify(taskService).handle(task);
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		});
		
	}
	
	@Test
	public void shouldSaveTasksNoWait() throws InterruptedException {
		ExecutorService executorService = new SynchronousExecutorService();
		TaskService taskService = mock(TaskService.class);
		Task task = mock(Task.class);
		Collection<Task> listOfTasks = Arrays.asList(task);
		
		Server server = new Server(executorService, taskService);
		server.serve(listOfTasks);
		
		Thread.sleep(1000);
		
		verify(taskService).handle(task);
	
	}

}
