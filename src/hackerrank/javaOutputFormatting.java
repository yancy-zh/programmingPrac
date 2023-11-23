package hackerrank;

import java.util.Scanner;

public class javaOutputFormatting
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("================================");
		for (int i = 0; i < 3; i++)
		{
			String s1 = sc.next();
			int x = sc.nextInt();
			// format the string
			int len = s1.length();
			if (len < 15)
			{
				int NTrailingSpace = 15 - len;
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append(s1);
				for (int j = 0; j < NTrailingSpace; j++)
				{
					sBuilder.append(' ');
				}
				// format the num
				int q = x / 10;
				if (q == 0)
				{
					sBuilder.append("00");
					sBuilder.append(String.valueOf(x));
				}
				else if (q >= 1 && q <= 9)
				{
					sBuilder.append("0");
					sBuilder.append(String.valueOf(x));
				}
				else
				{
					sBuilder.append(String.valueOf(x));
				}
				System.out.println(sBuilder.toString());
			}
			else
			{
				System.err.println("len of str exceeded 15 chars");
			}
		}
		System.out.println("================================");
		
	}
}
