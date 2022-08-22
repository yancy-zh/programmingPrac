package demos;

public class CountBits {
	/*����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
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
