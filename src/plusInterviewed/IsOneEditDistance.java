package plusInterviewed;

public class IsOneEditDistance
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/one-edit-distance/description/?envType=study-plan-v2&envId=premium-algo-100
		String s = "ab", t = "acb";
		System.out.println(isOneEditDistance(s, t));
		s = "";
		t = "";
		System.out.println(isOneEditDistance(s, t));
		
	}
	
	public static boolean isOneEditDistance(String s, String t)
	{
		int ns = s.length(), nt = t.length();
		// 确保 s 比 t 短。
		if (ns > nt) return isOneEditDistance(t, s);
		// 如果长度差异大于1，则字符串不是一个编辑距离。
		if (nt - ns > 1) return false;
		if (nt == ns)
		{
			for (int i = 0; i < ns; i++)
			{
				if (s.charAt(i) != t.charAt(i))
				{ return s.substring(i + 1).equals(t.substring(i + 1)); }
			}
		}
		else
		{
			for (int i = 0; i < ns; i++)
			{
				if (s.charAt(i) != t.charAt(i))
				{ return s.substring(i).equals(t.substring(i + 1)); }
			}
		}
		return ns + 1 == nt;
	}
}
