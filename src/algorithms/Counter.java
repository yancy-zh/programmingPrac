package algorithms;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter implements Runnable{
	//实现一个计数器
	private static int counter = 0;
	private final int limit = 1000;
	private static final int threadPoolSize = 2;
	private static final Object lock = new Object();
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
		for (int i = 0; i < threadPoolSize; i++) {
			executorService.submit(new Counter());
		}
		executorService.shutdown();
	}
	
	@Override
	public void run() {
		while (counter < limit) {
			increaseCounter();
		}
	}
	
	private void increaseCounter() {
		System.out.println(Thread.currentThread().getName()+ ":" + counter);
		counter++;
	}
}
