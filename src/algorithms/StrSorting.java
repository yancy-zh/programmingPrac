package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StrSorting
{
	public static void main(String[] args)
	{
		/*
		 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。 数据范围： ，字符串长度满足 输入描述： 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。 输出描述： 数据输出n行，输出结果为按照字典序排列的字符串。 示例1 输入： 9
		 * cap to cat card two too up boat boot 输出： boat boot cap card cat to too two up
		 */
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = Integer.parseInt(str);
		List<String> ls = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
		{
			ls.add(sc.nextLine().trim());
		}
		Comparator<String> comparator = new Comparator<String>()
		{
			@Override
			public int compare(String a, String b)
			{// 定义字典序
				int i = 0;
				while (i < a.length() && i < b.length())
				{
					if (a.charAt(i) != b.charAt(i))
					{ return a.charAt(i) > b.charAt(i) ? 1 : -1; }
					i++;
				}
				// after recursively go through all chars, all chars are same
				if (a.length() == b.length())
				{
					return 0;
				}
				else
				{//length are different, the shorter one goes before
					return a.length() > b.length() ? 1 : -1;
				}
			}
		};
		ls.sort(comparator);
		for (int i = 0; i < ls.size(); i++)
		{
			System.out.println(ls.get(i));
		}
	}
}
