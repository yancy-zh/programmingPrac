package demos;

import java.util.Scanner;

public class StringDevideBy8
{
	
	public static void main(String[] args)
	{
		/*
		 * 连续输入字符串，请按长度为8拆分每个输入字符串并进行输出； 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。 （注：本题有多组输入） 输入描述： 连续输入字符串(输入多次,每个字符串长度小于等于100)
		 * 
		 * 输出描述： 依次输出所有分割后的长度为8的新字符串
		 * 
		 * 示例1 输入： abc 123456789 复制 输出： abc00000 12345678 90000000
		 */
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{
			String str = sc.nextLine();
			int len = str.length();
			// check if the str len is dividable by 8
			if (len % 8 != 0)
			{
				int remainder = len % 8;
				int numZeroToPad = 8 - remainder;
				StringBuilder sb = new StringBuilder(str);
				for (int i = 0; i < numZeroToPad; i++)
				{
					sb.append('0');
				}
				str = sb.toString();
			}
			// cut the string by 8
			int numSection = str.length() / 8;
			for (int i = 0; i < numSection; i++)
			{
				System.out.println(str.substring(i * 8, i * 8 + 8));
			}
		}
		
	}
	public static String[] stringDivideBy8(String str)
	{
		int len = str.length();
		// check if the str len is dividable by 8
		if (len % 8 != 0)
		{
			int remainder = len % 8;
			int numZeroToPad = 8 - remainder;
			StringBuilder sb = new StringBuilder(str);
			for (int i = 0; i < numZeroToPad; i++)
			{
				sb.insert(i, "0");
			}
			str = sb.toString();
		}
		// cut the string by 8
		int numSection = str.length() / 8;
		String[] strArr = new String[numSection];
		for (int i = 0; i < numSection; i++)
		{
			strArr[i] = (str.substring(i * 8, i * 8 + 8));
		}
		return strArr;
	}
}
