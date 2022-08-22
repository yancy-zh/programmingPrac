package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Base16Cvt
{
	/*进制转换
	 * 
	 * 描述
写出�?个程序，接受�?个十六进制的数，输出该数值的十进制表示�??

数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n�?2 
31
 �?1 
输入描述�?
输入�?个十六进制的数�?�字符串�?

输出描述�?
输出该数值的十进制字符串。不同组的测试用例用\n隔开�?

示例1
输入�?
0xAA
复制
输出�?
170
	 */
	private static int BASE = 16;
	private static Map<Character, Integer> baseMap = new HashMap<Character, Integer>(){
		{
			put('0', 0);
			put('1', 1);
			put('2', 2);
			put('3', 3);
			put('4', 4);
			put('5', 5);
			put('6', 6);
			put('7', 7);
			put('8', 8);
			put('9', 9);
			put('A', 10);
			put('B', 11);
			put('C', 12);
			put('D', 13);
			put('E', 14);
			put('F', 15);
		}
	};
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		while (sc.hasNext()) {
			String base16Str = sc.next();
			System.out.println(getDecimal(base16Str));
		}
	}
	
	public static int getDecimal(String base16Num)
	{
		String num = base16Num.substring(2);
		int res= 0;
		for (int i = 0; i < num.length(); i++)
		{
			res += baseMap.get(num.charAt(num.length()-1-i)) * Math.pow(BASE, i);
		}
		return res;
	}
}
