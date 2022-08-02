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
		 // ״̬���Աȵ������ַ�������ʼ����ֹ����λ��
        // ����: �ַ���s��i��j�ַ���ɵ��Ӵ��Ƿ�Ϊ�����Ӵ�
		boolean[][] dp = new boolean[len][len];
		int res = 0;
		// i = 0 �ĳ�ʼ���
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
					// ״̬ת��
					dp[i][j]=true;
					// ���ϸ��������Ĵ�����
					res= Math.max(res, j-i+1);
				}
			}
		}
		return res;
	}
}
