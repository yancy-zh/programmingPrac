package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class javaLoops1
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bufferedReader.readLine().trim());
		for (int i = 0; i < 10; i++)
		{
			System.out.println(String.format("%d x %d = %d", N, i+1, Math.multiplyExact(N, i+1)));
		}
		bufferedReader.close();
	}
}
