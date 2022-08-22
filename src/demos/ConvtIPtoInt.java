package demos;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvtIPtoInt
{
	
	public static void main(String[] args)
	{
		/*
		 * 描述
原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001

组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。

数据范围：保证输入的是合法的 IP 序列

输入描述：
输入 
1 输入IP地址
2 输入10进制型的IP地址

输出描述：
输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址

示例1
输入：
10.0.3.193
167969729
复制
输出：
167773121
10.3.3.193
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
			}else {
				System.out.println(intToIpString(ip));
			}
			
		}
		scanner.close();
	}
	
	public static String ipToIntString(String ip){
		String[] ipInt = ip.split("\\.");
		StringBuilder binaryString = new StringBuilder("");
		for (int i = 0; i < ipInt.length; i++)
		{
			String val = String.format("%8s",  Integer.toBinaryString(Integer.valueOf(ipInt[i]))).replace(' ', '0');
			binaryString.append(val);
			
		}
		return Long.valueOf(binaryString.toString(), 2).toString();
	}
	
	public static String intToIpString(String ip)
	{
		String binaryStr = Long.toBinaryString(Long.valueOf(ip));
		String[] ipArr = StringDevideBy8.stringDivideBy8(binaryStr);
		StringBuilder sb= new StringBuilder();
		for (String part : ipArr ) {
			sb.append(Integer.valueOf(part, 2)).append('.');
		}
		return sb.substring(0, sb.length()-1);
	}
}
