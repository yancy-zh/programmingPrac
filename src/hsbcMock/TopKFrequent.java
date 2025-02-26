package hsbcMock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import utils.MyConverter;

public class TopKFrequent {
	// https://leetcode.cn/problems/top-k-frequent-elements/description/
	public int[] topKFrequent1(int[] nums, int k) {
		// create freq map
		HashMap<Integer, Integer> occMap = new HashMap<>();
		// count the frequency for each num in nums
		for (int i : nums) {
			// occMap[i][0]: num
			// occMap[i][0]: count
			occMap.put(i, occMap.getOrDefault(i, 0) + 1);
		}
		// init a priority queue and override its comparator method
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {

				return a[1] - b[1];
			}
		});
		// implement rules, interate in the occurance map:
		// 1. when the heap top has freq less than k, add the new element
		int m = 0;
		for (Map.Entry<Integer, Integer> entry : occMap.entrySet()) {
			m = queue.size();
			int num = entry.getKey(), count = entry.getValue();
			if (m != k) {
				queue.offer(new int[] { num, count });
			} else {
				int topFreq = queue.peek()[1];
				if (count > topFreq) {
					queue.poll();
					queue.offer(new int[] { num, count });
				}

			}
		}
		int[] ret = new int[k];
		for (int i = 0; i < k; i++) {
			ret[i] = queue.poll()[0];
		}
		return ret;
	}

	public int[] topKFrequent2(int[] nums, int k) {
		// 统计频率
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// 使用最小堆
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		// 维护堆的大小为 k
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		// 提取结果
		List<Integer> result = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			result.add(minHeap.poll().getKey());
		}

		// 反转结果，因为堆中是从小到大排序的
		Collections.reverse(result);
		return MyConverter.ListIntToPrimitive(result);
	}
}
