package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import utils.MyPrinter;

public class KSmallestPairs
{
	
	public static void main(String[] args)
	{
		/*
		 * 373. Find K Pairs with Smallest Sums 中等 You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k. Define a
		 * pair (u, v) which consists of one element from the first array and one element from the second array. Return the k pairs (u1, v1), (u2, v2), ...,
		 * (uk, vk) with the smallest sums. Example 1: Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3 Output: [[1,2],[1,4],[1,6]] Explanation: The first 3
		 * pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6] Example 2: Input: nums1 = [1,1,2], nums2 = [1,2,3], k
		 * = 2 Output: [[1,1],[1,1]] Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
		 * Constraints: 1 <= nums1.length, nums2.length <= 105 -109 <= nums1[i], nums2[i] <= 109 nums1 and nums2 both are sorted in non-decreasing order. 1 <= k
		 * <= 104 k <= nums1.length * nums2.length
		 */
		int[] nums1 = { 1, 7, 11 }; // 1, 7, 11
		int[] nums2 = { 2, 4, 6 }; // 2, 4, 6
		int k = 3;
		useCase(nums1, nums2, k);
		int[] nums1_1 = { 1, 2, 4, 5, 6 }; // 1, 7, 11
		int[] nums2_1 = { 3, 5, 7, 9 }; // 2, 4, 6
		int k_1 = 3;
		useCase(nums1_1, nums2_1, k_1);
		
	}
	
	public static void useCase(int[] nums1, int[] nums2, int k)
	{
		System.out.println("use case starts...");
		KSmallestPairs sol = new KSmallestPairs();
		MyPrinter p = new MyPrinter();
		List<List<Integer>> res = sol.kSmallestPairs(nums1, nums2, k);
		for (int i = 0; i < res.size(); i++)
		{
			p.printList(res.get(i));
		}
	}
	
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
	{
		List<ArrayList<Integer>> Out = new ArrayList<ArrayList<Integer>>();
		PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> {
			return nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]]);
		});
		List<List<Integer>> ans = new ArrayList<>();
		int m = nums1.length;
		int n = nums2.length;
		for (int i = 0; i < Math.min(m, k); i++)
		{
			pq.offer(new int[] { i, 0 });
		}
		while (k-- > 0 && !pq.isEmpty())
		{
			int[] idxPair = pq.poll();
			List<Integer> numPair = new ArrayList<>();
			numPair.add(nums1[idxPair[0]]);
			numPair.add(nums2[idxPair[1]]);
			ans.add(numPair);
			if (idxPair[1] + 1 < n)
			{
				pq.offer(new int[] { idxPair[0], idxPair[1] + 1 });
			}
		}
		return ans;
	}
}
