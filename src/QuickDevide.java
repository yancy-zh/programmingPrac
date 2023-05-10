public class QuickDevide {

	public static void main(String args[]) {
		int[] arr = { 1, 4, 5, 8, 9, 10 };
		System.out.print(QuickDevide.quickDivide(arr));
	}

	public static int[] quickDivide(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		// 令左边存奇数，右边存偶数
		while (i < j) {
			if (arr[i] % 2 == 0 && arr[j] % 2 == 1) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			while (arr[i] % 2 != 0) {
				i++;
			}
			while (arr[j] % 2 != 1) {
				j--;
			}

		}
		return arr;
	}

}
