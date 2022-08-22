package algorithms;

import java.util.Scanner;

public class tranverseSquares
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(combination(n, m + n));
		}
		sc.close();
	}
	
	public static int combination(int m, int n)
	{// ÅÅÁÐC(m,n)
		int above = fractorial(n);
		int below = fractorial(n - m) * fractorial(m);
		return above / below;
	}
	
	private static int fractorial(int n)// ½×³Ë
	{
		if (n > 1)
		{ return fractorial(n - 1) * n; }
		return n;
	}
}
