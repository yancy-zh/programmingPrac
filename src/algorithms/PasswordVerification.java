package algorithms;

import java.sql.PseudoColumnUsage;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordVerification
{
	/*
	 * ���� ����Ҫ��:
	 * 
	 * 1.���ȳ���8λ
	 * 
	 * 2.������Сд��ĸ.����.��������,����������������
	 * 
	 * 3.�����г��ȴ���2�İ�������Ԫ�ص��Ӵ��ظ� ��ע���������Ų����ո���У�
	 * 
	 * ���ݷ�Χ��������ַ����������� 1 \le n \le 100 \1��n��100 ���������� һ���ַ�����
	 * 
	 * ��������� �������Ҫ�������OK���������NG
	 * 
	 * ʾ��1 ���룺 021Abc9000 021Abc9Abc1 021ABC9000 021$bc9000 ����� OK NG NG OK
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
