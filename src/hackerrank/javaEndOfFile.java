package hackerrank;

import java.io.EOFException;
import java.util.Scanner;

public class javaEndOfFile
{
	public static void main(String[] args) throws EOFException
	{
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (sc.hasNext())
		{
			i += 1;
			String content = sc.nextLine();
			System.out.println(String.format("%d %s", i, content));
		}
		sc.close();
	}
}
