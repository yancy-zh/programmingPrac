package plusInterviewed;

public  class ArmstrongNum {

	public static void main(String[] args) {
		// https://leetcode.cn/problems/armstrong-number/description/?envType=study-plan-v2&envId=premium-algo-100
		int n = 153;
		System.out.println(ArmstrongNum.isArmstrong(n));
		int n2 = 123;
		System.out.println(ArmstrongNum.isArmstrong(n2));
	}

	public static boolean isArmstrong(int n) {
		/*
		 * 1134. Armstrong Number ¼òµ¥ Given an integer n, return true if and only if it
		 * is an Armstrong number. The k-digit number n is an Armstrong number if and
		 * only if the kth power of each digit sums to n.
		 * 
		 * Example 1: Input: n = 153 Output: true Explanation: 153 is a 3-digit number,
		 * and 153 = 13 + 53 + 33. Example 2: Input: n = 123 Output: false Explanation:
		 * 123 is a 3-digit number, and 123 != 13 + 23 + 33 = 36.
		 * 
		 * Constraints: 1 <= n <= 10^8
		 */
		char[] arr = String.valueOf(n).toCharArray();
		int k = arr.length;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			int digit = arr[i] -'0';
			sum += Math.pow(digit, k);
		}
		return sum == n;
	}
}
