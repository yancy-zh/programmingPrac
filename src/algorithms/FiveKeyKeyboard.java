package algorithms;

import java.util.Scanner;

public class FiveKeyKeyboard
{
	private static String scr = "";
	private static String chosen = "";
	private static String cutBoard = "";
	
	/*
	 * https://blog.csdn.net/weixin_44219664/article/details/124906192
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		for (int i = 0; i < input.length; i++)
		{
			takeAction(Integer.parseInt(input[i]));
		}
		System.out.println(scr.length());
	}
	
	public static void takeAction(int num)
	{
		if (num == 1) // key is 1, meaning type "a"
		{
			if (chosen.equals(""))
			{
				scr += "a";
			} else {
				chosen = "";
				scr = "a";
			}
			return;
		}
		if (num == 2) // ctrl c
		{
			cutBoard = chosen;
			return;
		}
		if (num == 3) // ctrl x
		{
			cutBoard = chosen;
			chosen = "";
			scr = "";
			return;
		}
		if (num == 4)// ctrl v
		{
			if (chosen.equals("")){
				scr += cutBoard;
				
			}else {
				scr = cutBoard;
				chosen = "";
			}
			return;
		}
		if (num == 5) // ctrl a
		{
			chosen = scr;
		}
	}
}
