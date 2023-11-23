package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class combinationSumTest
{
	
	 @Test
	void testCombinationSum()
	{
		int[] candidates = new int[] { 2, 3, 6, 7 };
		int target = 7;
		algorithms.CombinationSum cSum = new CombinationSum();
		int[][] tdarr = { { 2, 2, 3 }, { 7 } };
		assertEquals(cSum.combinationSum(candidates, target), tdarr);
	}
	
	@Test
	void testConvt()
	{
		algorithms.CombinationSum cSum = new CombinationSum();
		List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
		listOfList.add(new ArrayList<Integer>(Arrays.asList(2, 2, 3)));
		listOfList.add(new ArrayList<Integer>(Arrays.asList(7)));
		int[][] dst = cSum.twoDListTotwoDint(listOfList);
		System.out.println(dst);
	}
	
}
