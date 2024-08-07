package algorithms;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvtIPtoInt
{
	
	public static void main(String[] args)
	{
		/*
		 * ���� ԭ��ip��ַ��ÿ�ο��Կ�����һ��0-255����������ÿ�β�ֳ�һ����������ʽ���������Ȼ��������������ת��� һ���������� ������һ��ip��ַΪ10.0.3.193 ÿ������
		 * ���Ӧ�Ķ������� 10 00001010 0 00000000 3 00000011 193 11000001
		 * 
		 * ���������Ϊ��00001010 00000000 00000011 11000001,ת��Ϊ10���������ǣ�167773121������IP��ַת��������־������ˡ�
		 * 
		 * ���ݷ�Χ����֤������ǺϷ��� IP ����
		 * 
		 * ���������� ���� 1 ����IP��ַ 2 ����10�����͵�IP��ַ
		 * 
		 * ��������� ��� 1 ���ת����10���Ƶ�IP��ַ 2 ���ת�����IP��ַ
		 * 
		 * ʾ��1 ���룺 10.0.3.193 167969729 ���� ����� 167773121 10.3.3.193
		 */
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			String ip = scanner.nextLine();
			Pattern delimiterPattern = Pattern.compile("\\.");
			Matcher m1 = delimiterPattern.matcher(ip);
			if (m1.find())
			{
				System.out.println(ipToIntString(ip));
			}
			else
			{
				System.out.println(intToIpString(ip));
			}
			
		}
		scanner.close();
	}
	
	public static String ipToIntString(String ip)
	{
		String[] ipInt = ip.split("\\.");
		StringBuilder binaryString = new StringBuilder("");
		for (int i = 0; i < ipInt.length; i++)
		{
			String val = String.format("%8s", Integer.toBinaryString(Integer.valueOf(ipInt[i]))).replace(' ', '0');
			binaryString.append(val);
		}
		return Long.valueOf(binaryString.toString(), 2).toString();
	}
	
	public static String intToIpString(String ip)
	{
		String binaryStr = Long.toBinaryString(Long.valueOf(ip));
		String[] ipArr = StringDevideBy8.stringDivideBy8(binaryStr);
		StringBuilder sb = new StringBuilder();
		for (String part : ipArr)
		{
			sb.append(Integer.valueOf(part, 2)).append('.');
		}
		return sb.substring(0, sb.length() - 1);
	}
}
