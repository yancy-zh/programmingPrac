package JavaTutorial;

class Counter
{
	int count;
	
	public Counter(int countInit)
	{
		count = countInit;
	}
	
	public synchronized void increment()
	{
		count++;
	}
}

public class SyncDemo
{
	
	public static void main(String[] args) throws InterruptedException
	{
		Counter counter = new Counter(0);
		Thread t1 = new Thread(()->{
			for (int i = 0; i < 1000; i++)
			{
				counter.increment();
			}
		});
		Thread t2 = new Thread(()->{
			for (int i = 0; i < 1000; i++)
			{
				counter.increment();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("the counter is: " + counter.count);
	}
	
}
