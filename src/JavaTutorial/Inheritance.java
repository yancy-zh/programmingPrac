package JavaTutorial;

class Calculator
{
	public int add(int a, int b)
	{
		return a + b;
	}
}

class CalcAdv extends Calculator
{
	public int sub(int a, int b)
	{
		return a - b;
	}
}

class CalcVeryAdv extends CalcAdv {
	public float devide(int a, int b)
	{
		try
		{
			return a/b;
		}
		catch (Exception e)
		{
			System.err.println(e);;
			return Float.MAX_VALUE;
		}
	}
}

public class Inheritance
{
	
	public static void main(String[] args)
	{
		CalcAdv calcAdv = new CalcAdv();
		System.out.println(calcAdv.add(5, 4));
		System.out.println(calcAdv.sub(9, 4));
	}
	
}
