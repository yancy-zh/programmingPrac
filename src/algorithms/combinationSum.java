package algorithms;

import java.util.ArrayList;
import java.util.List;

public class combinationSum
{
	/*39. Combination Sum
	 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	// backtracking
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> allCombis = new ArrayList<List<Integer>>();
		List<Integer> combi = new ArrayList<Integer>();
		dfs(candidates, target, combi, 0, allCombis);
		return allCombis;
	}
	
	public void dfs(int[] candidates, int currTarget, List<Integer> currCombi, int idx, List<List<Integer>> allCombis)
	{
		if (idx == candidates.length)
		{ return; }
		if (currTarget == 0)
		{
			allCombis.add(new ArrayList<>(currCombi));
			return;
		}
		// skip this num
		dfs(candidates, currTarget, currCombi, idx + 1, allCombis);
		// choose the current num
		if (currTarget - candidates[idx] >= 0)
		{
			currCombi.add(candidates[idx]);
			dfs(candidates, currTarget - candidates[idx], currCombi, idx, allCombis);
			currCombi.remove(currCombi.size() - 1);
		}
		
	}
}
