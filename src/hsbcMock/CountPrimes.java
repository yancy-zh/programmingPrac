package hsbcMock;

import java.util.Arrays;

public class CountPrimes
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/count-primes/solutions/507273/ji-shu-zhi-shu-by-leetcode-solution/
		int n = 10;
		System.out.println(countPrimes(n));
	}
	
	public static int countPrimes(int n)
	{
		int cnt = 0;
		for (int i = 2; i < n; i++)
		{
			if (isPrime(i))
			{
				cnt++;
			}
		}
		return cnt;
	}
	
	private static boolean isPrime(int x)
	{
		/*
		 * 考虑到如果 yyy 是 xxx 的因数，那么 xy\frac{x}{y} y x ​ 也必然是 xxx 的因数，因此我们只要校验 yyy 或者 xy\frac{x}{y} y x ​ 即可。而如果我们每次选择校验两者中的较小数，则不难发现较小数一定落在 [2,x][2,\sqrt{x}][2, x
		 * ​ ] 的区间中，因此我们只需要枚举 [2,x][2,\sqrt{x}][2, x ​ ] 中的所有数即可，这样单次检查的时间复杂度从 O(n)O(n)O(n) 降低至了 O(n)O(\sqrt{n})O( n ​ )。
		 * 
		 * 作者：力扣官方题解 链接：https://leetcode.cn/problems/count-primes/solutions/507273/ji-shu-zhi-shu-by-leetcode-solution/ 来源：力扣（LeetCode）
		 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
		 */
		for (int i = 2; i * i <= x; i++)
		{
			if (x % i == 0)
			{ return false; }
		}
		return true;
	}
	
	public static int method2(int n)
	{
		int cnt = 0;
		int[] table = new int[n];
		Arrays.fill(table, 1);
		for (int i = 2; i <= n; i++)
		{
			if (table[i] == 1)
			{
				cnt++;
				if (i * i < n)
				{
					for (int j = i * i; j < n; j += i)
					{
						table[j] = 0;
					}
				}
			}
		}
		return cnt;
	}
	
}
