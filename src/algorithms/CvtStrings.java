package algorithms;

import java.util.Scanner;

public class CvtStrings
{
	/*
	 * �ַ���ת���� ��������ַ������ַ���������Сд��ĸ��a������z�������������¹���ѭ��ת���������a->b,b->c,��.y->z,z->a;��������ַ�����������������ĸ��ͬʱ����һ����ĸ����ת��2�Ρ����磺aaת����bc��zzת��Ϊab����������ͬ��ĸ��������ʱ�����������ֵ���ĸ����һ�γ���.
	 *e.g.
	 *
	 *in: abc
out: bcd

in: abbc
out: bcdd

in: abbbc
out: bcdcd

	 * �������������������������������� ��Ȩ����������ΪCSDN�������̺����ơ���ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ��������� ԭ�����ӣ�https://blog.csdn.net/u012260238/article/details/48804765
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
