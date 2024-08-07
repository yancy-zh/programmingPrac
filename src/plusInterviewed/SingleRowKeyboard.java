package plusInterviewed;

public class SingleRowKeyboard
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/single-row-keyboard/description/?envType=study-plan-v2&envId=premium-algo-100
		String keyboard = "abcdefghijklmnopqrstuvwxyz";
		String word = "cba";
		System.out.println(calculateTime(keyboard, word));
		keyboard = "pqrstuvwxyzabcdefghijklmno";
		word = "leetcode";
		System.out.println(calculateTime(keyboard, word));
	}
	
	public static int calculateTime(String keyboard, String word)
	{
		int time = 0;
		int[] keysArr = new int[26];
		for (int i = 0; i < keyboard.length(); i++)
		{
			keysArr[keyboard.charAt(i) - 'a'] = i;
		}
		int prev = 0;
		int idx = 0;
		for (char ch : word.toCharArray())
		{
			time += Math.abs(keysArr[ch - 'a'] - prev);
			prev = keysArr[ch - 'a'];
		}
		return time;
	}
}
