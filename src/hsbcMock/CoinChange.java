package hsbcMock;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// 交叉排序
		// https://leetcode.cn/problems/gaM7Ch/description/?envType=problem-list-v2&envId=5ih5hQff
		int[] coins = new int[] { 1, 2, 5 };
		int k = 11;
		System.out.println(coinChange(coins, k));
	}

	public static int coinChange(int[] coins, int amount) {
		int max = amount + 1; // the biggest possible solution is amount, so plus 1 is bigger than all
								// solutions.
		int[] dp = new int[amount + 1];
		// init dp with the maximum value of possible solution
		Arrays.fill(dp, max);
		// dp[0]=0, because no coins can sum up to amount "0"
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			// i is the current total amount
			for (int j = 0; j < coins.length; j++) {// consider all history solutions, including dp[0]
				if (coins[j] <= i) {// loop in all elements in coins, get the dp memory and get the minimum,
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
