package algorithms;

import java.util.ArrayList;

public class SortColors {
	public static void main(String[] args) {
		SortColors sortColors = new SortColors();
//		sortColors.sortColors(new int[] {2,0,2,1,1,0});
		sortColors.sortColors(new int[] {2,0,1});
		
	}
	public ArrayList<Integer> sortColors(int[] nums) {
		int[] counters = new int[3];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {// red
				counters[0]++;
			} else if (nums[i] == 1) {
				counters[1]++;
			} else {
				counters[2]++;
			}
		}
		ArrayList<Integer> sorted = new ArrayList<>();
		for (int j = 0; j < counters.length; j++) {
			int colorId = j;
			int thisCount = counters[j];
			for (int k = 0; k < thisCount; k++) {
				sorted.add(colorId);
			}
		}
		return sorted;
	}
}
