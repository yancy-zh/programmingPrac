package algorithms;

import java.util.Scanner;

public class CvtStrings
{
	/*
	 * 字符串转换： 将输入的字符串（字符串仅包含小写字母’a’到’z’），按照如下规则，循环转换后输出：a->b,b->c,….y->z,z->a;若输入的字符串连续出现两个字母相同时，后一个字母连续转换2次。例如：aa转换成bc，zz转换为ab；当连续相同字母超过两个时，第三个出现的字母按第一次出现.
	 *e.g.
	 *
	 *in: abc
out: bcd

in: abbc
out: bcdd

in: abbbc
out: bcdcd

	 * ———————————————— 版权声明：本文为CSDN博主「碧海凌云」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/u012260238/article/details/48804765
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			String inStr = scanner.next();
			StringBuilder stringBuilder = new StringBuilder();
			boolean flag = false;
			stringBuilder.append(cvtPrinciple(inStr.charAt(0), 1));
			for (int i = 1; i < inStr.length(); i++)
			{
				if (inStr.charAt(i) == inStr.charAt(i - 1) && !flag)
				{
					stringBuilder.append(cvtPrinciple(inStr.charAt(i), 2));
					flag = true;
				}
				else
				{
					stringBuilder.append(cvtPrinciple(inStr.charAt(i), 1));
					flag = false;
				}
			}
			System.out.println(stringBuilder.toString());
		}
	}
	
	static String cvtPrinciple(Character ch, int shift)
	{
		return Character.toString((ch - 'a' + shift) % 26 + 'a');
	}
	
	
}
