package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dataSorting
{
	
	public static void main(String[] args)
	{
		/*
		 * HJ25 数据分类处理
		 */
		
		// read the string array
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine())
		{
			if (sc.nextLine() == "") continue;
			// num of elements in R
			int m = sc.nextInt();
			String[] R = new String[m];
			
			for (int i = 0; i < m; i++)
			{
				R[i] = String.valueOf(sc.nextLong());
			}
			System.out.println(R.length);
			// num of elements in I
			int n = sc.nextInt();
			String[] I = new String[n];
			for (int j = 0; j < n; j++)
			{
				I[j] = String.valueOf(sc.nextLong());
			}
			System.out.println(I.length);
		}
		
	}
	
}
