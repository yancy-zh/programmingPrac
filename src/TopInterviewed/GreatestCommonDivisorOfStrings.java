package TopInterviewed;

public class GreatestCommonDivisorOfStrings
{
	
	public static void main(String[] args)
	{
		// 1071. Greatest Common Divisor of Strings
		
	}
	
	public String gcdOfStrings(String str1, String str2)
	{
		if (!str1.concat(str2).equals(str2.concat(str1)))
		{
			return "";
		}
		else
		{
			return str1.substring(0, gcd(str1.length(), str2.length()));
		}
	}
	
	public int gcd(int len1, int len2)
	{
		int remainder = len1;
		while (remainder != 0)
		{
			len1 = len2;
			len2 = remainder;
			remainder = len1 % len2;
		}
		return len2;
	}
}
