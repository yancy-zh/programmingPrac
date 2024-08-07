package plusInterviewed;

public class PerformStringShifts
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/perform-string-shifts/solutions/2425813/zhuan-hua-wei-yi-bu-you-yi-jie-qu-zi-fu-nkxcv/?envType=study-plan-v2&envId=premium-algo-100
		String s = "abc";
		int[][] shift = { { 0, 1 }, { 1, 2 } };
		System.out.println(stringShift(s, shift));
		s = "abcdefg";
		int[][] shift1 = { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } };
		System.out.println(stringShift(s, shift1));
		s = "joiazl";
		int[][] shift2 = { { 1, 1 }, { 1, 6 }, { 0, 1 }, { 1, 3 }, { 1, 0 }, { 0, 3 } };
		System.out.println(stringShift(s, shift2));
		s = "wpdhhcj";
		int[][] shift3 = { { 0, 7 }, { 1, 7 }, { 1, 0 }, { 1, 3 }, { 0, 3 }, { 0, 6 }, { 1, 2 } };
		System.out.println(stringShift(s, shift3));
		
	}
	
	public static String stringShift(String s, int[][] shift)
	{
		String out = s;
		int offset = 0;
		int n = shift.length;
		int m = s.length();
		for (int i = 0; i < n; i++)
		{
			if (shift[i][0] == 0)
			{
				offset -= shift[i][1];
			}
			else
			{
				offset += shift[i][1];
			}
		}
		offset = offset % m;
		if (offset > 0)// shift right
		{
			out = s.substring(m - Math.abs(offset)) + s.substring(0, m - Math.abs(offset));
		}
		else if (offset < 0)// shift left
		{
			
			out = s.substring(Math.abs(offset), m) + s.substring(0, Math.abs(offset));
		}
		return out;
	}
}
