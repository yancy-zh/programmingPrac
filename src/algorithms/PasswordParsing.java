package algorithms;

public class PasswordParsing
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}
	public static int validLen(String s)
	{
		int len = s.length();
		 // 状态：对比的两个字符索引起始和终止索引位置
        // 定义: 字符串s的i到j字符组成的子串是否为回文子串
		boolean[][] dp = new boolean[len][len];
		int res = 0;
		// i = 0 的初始情况
		for (int i = 0; i < len - 1; i++)
		{
			dp[i][i]= true;
		}
		for (int j = 1; j < dp.length; j++)
		{
			for (int i = 0; i < j; i++)
			{
				if (s.charAt(i)==s.charAt(j) && (i<=j-2) || dp[i+1][j-1])
				{
					// 状态转移
					dp[i][j]=true;
					// 不断更新最大回文串长度
					res= Math.max(res, j-i+1);
				}
			}
		}
		return res;
	}
}
