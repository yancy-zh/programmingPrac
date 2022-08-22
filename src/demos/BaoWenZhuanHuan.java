package demos;

import java.util.ArrayList;
import java.util.Iterator;
// ±¨ÎÄ×ª»»
/*
 * 		String input = "A B 1 2";
		BaoWenZhuanHuan solv = new BaoWenZhuanHuan();
		solv.baoWenZhuanHuan(input);
 */
public class BaoWenZhuanHuan
{
	public void baoWenZhuanHuan(String inputCode)
	{
		String[] strs = inputCode.split(" ");
		ArrayList<String> list = new ArrayList<>();
		for (String s : strs)
		{
			if (s.equalsIgnoreCase("A"))
			{
				list.add("12");
				list.add("34");
			}
			else if (s.equalsIgnoreCase("B"))
			{
				list.add("AB");
				list.add("CD");
			}
			else
			{
				list.add(s);
			}
		}
		printStrList(list, strs.length);
	}
	
	public static void printStrList(ArrayList<String> list, int size)
	{
		Iterator<String> iterator = list.iterator();
		StringBuilder builder = new StringBuilder(String.valueOf(size+1));
		while (iterator.hasNext())
		{
			builder.append(" ");
			builder.append(iterator.next());
		}
		System.out.println(builder.toString());
	}
}
