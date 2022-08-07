package javaTutorial;
class A {
	A()
	{
		System.out.println("in A");
	}
	A(int i){
		System.out.println("in A int");
	}
}

class B extends A {
	B()
	{
		System.out.println("in B");
	}
	B(int i){
		System.out.println("in B int");
	}
}
public class SuperKeywordDemo
{
	
	public static void main(String[] args)
	{
		A b = new B(5);
	}
	
}
