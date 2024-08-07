package hsbcMock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import utils.MyConverter;
import utils.MyPrinter;

public class FrequencySort
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/sort-array-by-increasing-frequency/
		int[][] numsls = { { 1, 1, 2, 2, 2, 3 }, { 2, 3, 1, 3, 2 }, { -1, 1, -6, 4, 5, -6, 1, 4, 1 } };
		for (int i = 0; i < numsls.length; i++)
		{
			MyPrinter.printPrimitiveInt(frequencySort(numsls[i]));
		}
	}
	
	public static int[] frequencySort(int[] nums)
	{
		int n = nums.length;
		HashMap<Integer, Integer> table = new HashMap<>();
		for (int i : nums)
		{
			table.put(i, table.getOrDefault(i, 0) + 1);
		}
		List<Integer> ls = new ArrayList<>();
		for (int num : nums)
		{
			ls.add(num);
		}
		Collections.sort(ls, (a, b) -> {
			int cnt_a = table.get(a);
			int cnt_b = table.get(b);
			return (cnt_a != cnt_b) ? cnt_a - cnt_b : b - a;
		});
		int[] out = MyConverter.ListIntToPrimitive(ls);
		
		return out;
	}
	
}
