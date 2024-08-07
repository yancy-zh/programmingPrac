package plusInterviewed;

public class IsSubSequence
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String s = "abc", t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
		s = "axc";
		t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
		
	}
	
	public static boolean isSubsequence(String s, String t)
	{
		int slow = 0, fast = 0;
		int m = s.length(), n = t.length();
		while (slow < m && fast < n)
		{
			if (s.charAt(slow) == t.charAt(fast))
			{
				slow++;
			}
			fast++;
		}
		return slow == m;
	}
}
