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
		 * ���� n ���ַ�������� n ���ַ��������ֵ������С� ���ݷ�Χ�� ���ַ����������� ���������� �����һ��Ϊһ��������n(1��n��1000),����n��Ϊn���ַ���(�ַ������ȡ�100),�ַ�����ֻ���д�Сд��ĸ�� ��������� �������n�У�������Ϊ�����ֵ������е��ַ����� ʾ��1 ���룺 9
		 * cap to cat card two too up boat boot ����� boat boot cap card cat to too two up
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
			{// �����ֵ���
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
