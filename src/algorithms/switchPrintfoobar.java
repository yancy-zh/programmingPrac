package algorithms;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FooBar
{
	private int n;
	
	FooBar(int n)
	{
		this.n = n;
	}
	
	public void foo()
	{
		System.out.println("foo");
	}
	
	public void bar()
	{
		System.out.println("bar");
	}
}

public class switchPrintfoobar
{
	private int n;
	private BlockingQueue<Integer> bar = new LinkedBlockingQueue<>(1);
	private BlockingQueue<Integer> foo = new LinkedBlockingQueue<>(1);
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}
	
}
