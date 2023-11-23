package hackerrank;

import java.util.Scanner;

public class JavaStaticInitializerBlock
{
	static int b;
	static int h;
	static boolean flag = true;
	static
	{
		Scanner sc = new Scanner(System.in);
		b = sc.nextInt();
		h = sc.nextInt();
		try
		{
			if (b < 1 || h < 1)
			{
				flag = false;
				throw new Exception("Breadth and height must be positive");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			sc.close();
		}
	}
	
	public static void main(String[] args)
	{
		if (flag)
		{
			System.out.println(b * h);
		}
	}
	
}
