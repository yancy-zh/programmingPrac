package plusInterviewed;

public class ShortestWayToFormString
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String source = "abc";
		String target = "abcbc";
		System.out.println(shortestWay(source, target));
		source = "abc";
		target = "acdbc";
		System.out.println(shortestWay(source, target));
		source = "xyz";
		target = "xzyxz";
		System.out.println(shortestWay(source, target));
	}
	
	public static int shortestWay(String source, String target)
	{
		// 标记源的所有字符的布尔数组
		boolean[] sourceChars = new boolean[26];
		for (char ch : source.toCharArray())
		{
			sourceChars[ch - 'a'] = true;
		}
		// 检查源文件中是否存在目标文件的所有字符
		// 布尔数组有target中不存在的字符，说明source无法串联组成target，返回 -1
		for (char e : target.toCharArray())
		{
			if (!sourceChars[e - 'a'])
			{ return -1; }
		}
		int count = 1;
		String concatenatedSource = source;
		while (!IsSubSequence.isSubsequence(target, concatenatedSource))
		{
			concatenatedSource += source;
			count++;
		}
		return count;
	}
}
