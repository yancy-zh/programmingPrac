package JavaTutorial;

public class ThreadDemo
{
	public static void main(String[] args) throws Exception
	{
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++)
			{
				System.out.println("Hi");
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
				}
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++)
			{
				System.out.println("Hello");
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
				}
			}
		});
		t1.start();
		try
		{
			Thread.sleep(10);
		}
		catch (InterruptedException e)
		{
		}
		t2.start();
		t1.join();
		t2.join();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println("Bye");
	}
	
}
