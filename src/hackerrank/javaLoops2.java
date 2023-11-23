package hackerrank;

import java.util.*;

import java.io.*;

public class javaLoops2
{
	public static void main(String[] argh)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int[] series = generateSeries(a, b, n);
			String spaceSepStrofInts = Arrays.stream(series).mapToObj(String::valueOf).reduce((x, y) -> x.concat(" ").concat(y)).get();
			System.out.println(spaceSepStrofInts);
		}
		in.close();
	}
	
	public static int[] generateSeries(int a, int b, int n)
	{
		int[] out = new int[n];
		for (int i = 0; i < n; i++)
		{
			out[i] += a;
			for (int j = 0; j < i + 1; j++)
			{
				out[i] += b * Math.pow(2, j);
			}
		}
		return out;
	}
}
