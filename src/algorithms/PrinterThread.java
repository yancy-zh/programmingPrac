package algorithms;

public class PrinterThread {
	/*
	 * 我们提供了一个类�?

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
三个不同的线�? A、B、C 将会共用�?个 Foo 实例�?

�?个将会调�? first() 方法
�?个将会调用 second() 方法
还有�?个将会调�? third() 方法
请设计修改程序，以确�? second() 方法�? first() 方法之后被执行，third() 方法�? second() 方法之后被执行�??

来源：力扣（LeetCode�?
链接：https://leetcode-cn.com/problems/print-in-order
著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
			Foo testFoo = new Foo();
		// standard output
		testFoo.first(new printFirst());
		testFoo.second(new printSecond());
		testFoo.third(new printThird());
	*/
	private volatile int flag = 1;
	private final Object obj= new Object();
	
    public PrinterThread() {

    }
 
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (obj) {
			while (flag != 1) obj.wait();
			// printFirst.run() outputs "first". Do not change or remove this line.
			printFirst.run();
			flag = 2;
			obj.notifyAll();
		}
    }
    
    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (obj) {
        	while (flag!=2) obj.wait();
        	// printSecond.run() outputs "second". Do not change or remove this line.
        	printSecond.run();
        	flag = 3;
			obj.notifyAll();
		}
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (obj) {
        	while (flag != 3) obj.wait();
        	// printThird.run() outputs "third". Do not change or remove this line.
        	printThird.run();
		}
    }
}
