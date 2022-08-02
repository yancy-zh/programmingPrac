package algorithms;

import java.sql.PseudoColumnUsage;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordVerification
{
	/*
	 * 描述 密码要求:
	 * 
	 * 1.长度超过8位
	 * 
	 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
	 * 
	 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
	 * 
	 * 数据范围：输入的字符串长度满足 1 \le n \le 100 \1≤n≤100 输入描述： 一组字符串。
	 * 
	 * 输出描述： 如果符合要求输出：OK，否则输出NG
	 * 
	 * 示例1 输入： 021Abc9000 021Abc9Abc1 021ABC9000 021$bc9000 输出： OK NG NG OK
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			String pw = scanner.nextLine();
			if (pw.length() <= 8)
			{
				System.out.println("NG");
				continue;
			}
			if (hasRepeatedStr(pw, 0, 3))
			{
				System.out.println("NG");
				continue;
			}
			if (!hasThreeTypesChars(pw))
			{
				System.out.println("NG");
				continue;
			}
			System.out.println("OK");
			
		}
	}
	
	public static boolean hasRepeatedStr(String pw, int l, int r)
	{
		if (r >= pw.length())
		{ return false; }
		if (pw.substring(r).contains(pw.substring(l, r)))
		{
			return true;
		}
		else
		{
			return hasRepeatedStr(pw, l + 1, r + 1);
		}
	}
	
	public static boolean hasThreeTypesChars(String pw)
	{
		for (char ch : pw.toCharArray())
		{
			Pattern pAlphaUpper = Pattern.compile("[A-Z]");
			Matcher m1 = pAlphaUpper.matcher(pw);
			Pattern pAlphaLower = Pattern.compile("[a-z]");
			Matcher m2 = pAlphaLower.matcher(pw);
			Pattern pDigit = Pattern.compile("[0-9]");
			Matcher m3 = pDigit.matcher(pw);
			Pattern pSign = Pattern.compile("[^a-zA-Z0-9]");
			Matcher m4 = pSign.matcher(pw);
			int score = 0;
			if (m1.find())
			{
				score += 1;
			}
			if (m2.find())
			{
				score += 1;
			}
			if (m3.find())
			{
				score += 1;
			}
			if (m4.find())
			{
				score += 1;
			}
			if (score >= 3)
			{ return true; }
		}
		return false;
	}
}
