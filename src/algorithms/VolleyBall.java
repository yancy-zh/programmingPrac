package algorithms;

import java.io.*;

public class VolleyBall
{
	private final static int MOD = 1000000007;
	private final static int WIN_SCORE_GAP = 2;
	private final static int MIN_WIN_SCORE = 25;
	private final static int MANDATORY_TIE = 24;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		System.out.print(volleyball(A, B));
	}
	
	public static int volleyball(int A, int B)
	{
		// A is the larger number
		if (A < B)
		{
			int temp = A;
			A = B;
			B = temp;
		}
		
		// Winning team should have at least 25 points
		if (A < MIN_WIN_SCORE)
		{ return 0; }
		
		// If exactly 25 points
		if (A == MIN_WIN_SCORE)
		{
			// They must have won by at least 2
			// If so, get the number of combinations for score
			return (A - B < WIN_SCORE_GAP) ? 0 : nCr(A - 1, B, MOD);
		}
		
		// Otherwise, their score is 26+ and they must have won by exactly 2
		if (A - B != WIN_SCORE_GAP)
		{ return 0; }
		
		// In this case, the team must have reached 24-24 at some point
		// in the game, so get the number of combinations for that
		int numGames = nCr(MANDATORY_TIE, MANDATORY_TIE, MOD);
		
		// From here on out, the max gap in score is 1 since any more
		// and the game is over. This means if one team gets the lead,
		// the other team ties, all the way until losing team gets to
		// score B.
		numGames = (int) ((((long) numGames) * pow(2, B - 24, MOD)) % MOD);
		return numGames;
	}
	
	private static int nCr(int n, int r, int mod)
	{
		// calculate number of combination
		// Swap if n less than r
		if (n < r)
		{
			int temp = n;
			n = r;
			r = temp;
		}
		
		// Return 1 if value too small
		if (n < 1 || r < 1)
		{ return 1; }
		
		// Use Pascal's triangle
		
		int[] row = new int[r];
		for (int i = 0; i < r; row[i++] = 1)
		{
		}
		
		// Get up to row with width r
		for (int i = 2; i < r; ++i)
		{
			for (int j = i - 1; j > 0; --j)
			{
				row[j] = (row[j] + row[j - 1]) % mod;
			}
		}
		
		// sum values in position (r-1)
		--r;
		int sum = row[r];
		for (int i = 0; i < n; ++i)
		{
			for (int j = r; j > 0; --j)
			{
				row[j] = (row[j] + row[j - 1]) % mod;
			}
			sum = (sum + row[r]) % mod;
		}
		
		return sum;
	}
	
	private static int pow(int base, int exponent, int mod)
	{
		if (exponent < 2)
		{ return (exponent < 1) ? 1 : base; }
		long product = pow(base, exponent >> 1, mod);
		product = (product * product) % mod;
		return ((exponent & 1) == 1) ? (int) ((product * base) % mod) : (int) (product);
	}
}
