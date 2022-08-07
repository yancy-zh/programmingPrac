package JavaTutorial;

class AA{
	public void show()
	{
		System.out.println("in A");
	}
}

class BB extends AA{
	public void show()
	{
		System.out.println("in B");
	}
}

class C extends AA{
	public void show()
	{
		System.out.println("in C");
	}
}
public class overrideDemo
{
	
	public static void main(String[] args)
	{
		AA obj = new BB();
		obj.show();
		obj = new C();
		obj.show();
	}
	
}
