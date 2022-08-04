package JavaTutorial;

class A{
	public void show()
	{
		System.out.println("in A");
	}
}

class B extends A{
	public void show()
	{
		System.out.println("in B");
	}
}

class C extends A{
	public void show()
	{
		System.out.println("in C");
	}
}
public class overrideDemo
{
	
	public static void main(String[] args)
	{
		A obj = new B();
		obj.show();
		obj = new C();
		obj.show();
	}
	
}
