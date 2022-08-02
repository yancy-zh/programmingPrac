package algorithms;

import java.util.Scanner;


public class DivideBy8
{
	public void divideBy8()
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{
			String inStr = (String) sc.next();
			int len = inStr.length();
			if (len % 8 != 0)
			{
				int remainderLen = len % 8;
				int zerosToPad = 8 - remainderLen;
				StringBuilder sb = new StringBuilder(inStr);
				for (int i = 0; i < zerosToPad; i++)
				{
					sb.append('0');
				}
				String newStr = sb.toString();
				int numOfSec = newStr.length()/8;
				String[] res= new String[numOfSec]; 
				// Divide into array of strings
				for (int i = 0; i < numOfSec; i++)
				{
					res[i] = newStr.substring(i*8, i*8+8);
					System.out.println(res[i]);
				}
				
			}
		}
	}
	
}
