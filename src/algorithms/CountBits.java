package algorithms;

public class CountBits {
	/*给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
	 * 
	 */
	public int[] countBits(int num) {
		int[] bits = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			bits[i] = countOnes(i);
		}
		return bits;
	}
	
	public int countOnes(int x) {
		int ones = 0;
		while (x > 0) {
			x &= (x-1);
			ones++;
		}
		return ones;
	}
}
