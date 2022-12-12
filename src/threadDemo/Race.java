package threadDemo;

import java.util.Iterator;

public class Race implements Runnable
{
	private static String winner;
	
	@Override
	public void run()
	{
		// count the number of steps
		for (int i = 0; i <= 100; i++)
		{
			//模拟兔子休息
			if (Thread.currentThread().getName().equals("rabbit") && i%50 ==0)
			{
				try
				{
					Thread.sleep(10);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			boolean flag = gameOver(i);
			if (flag)
			{
				break;
			}
			System.out.println(Thread.currentThread().getName() + "->ran " + i + "steps");
		}
	}
	
	// judge if the race is over
	private boolean gameOver(int steps)
	{
		// 判断是否有胜利者
		if (winner != null)
		{ return true; }
		if (steps >= 100)
		{
			winner = Thread.currentThread().getName();
			System.out.println("winner is " + winner);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Race race = new Race();
		new Thread(race, "rabbit").start();
		new Thread(race, "turtle").start();
		
	}
}
