package chapter06.async;

import java.util.Collection;
import java.util.concurrent.ExecutorService;


public class Server {
	private final ExecutorService executorService;
	private final TaskService taskService;
	
	public Server(ExecutorService executorService, TaskService taskService) {
		this.executorService = executorService;
		this.taskService = taskService;
	}
	
	public void serve(Collection<Task> tasks) {
		for (Task task : tasks) {
			executorService.submit(new TaskHandler(taskService, task));
		}
	}
	
	private class TaskHandler implements Runnable {
		private final TaskService taskService;
		private final Task task;
		
		public TaskHandler(TaskService taskService, Task task) {
			this.taskService = taskService;
			this.task = task;
		}
		
		public void run() {
			taskService.handle (task);
		}
	}
	
}
