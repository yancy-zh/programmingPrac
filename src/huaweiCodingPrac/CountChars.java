package huaweiCodingPrac;

import java.util.HashSet;
import java.util.Scanner;


public class CountChars
{
		public static void main(String[] args) throws InterruptedException
	{
		CountChars sChars = new CountChars();
		sChars.solv();
	}
	
	public void solv()
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			String word = scanner.next(); 
			HashSet<Character> charSet = new HashSet<Character>();
			for (int i = 0; i < word.length(); i++)
			{
				Character ch = word.charAt(i);
				charSet.add(ch);
				
			}
			System.out.println(charSet.size());
		}
	}
}
