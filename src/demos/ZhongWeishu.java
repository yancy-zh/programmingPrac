package demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ZhongWeishu
{
	/* 求中位数
	
	//int[] nums = {10,11,21,19,21,17,21,16,21,18,15};
	//int[] nums = {2,1,5,4,3,3,9,2,7,4,6,2,15,4,2,4};
	int[] nums = {5,1,5,3,5,2,5,5,7,6,7,3,7,11,7,55,7,9,98,9,17,9,15,9,9,1,39};
	ZhongWeishu solv = new ZhongWeishu();
	System.out.println(solv.zhongWeishu(nums));
	*/
	public static int zhongWeishu(int[] inputArray)
	{
		// the map with the frequencies
		Map<Integer, Integer> freqMap = new HashMap<>();
		// the entry with the largest frequency
		
		for (int it : inputArray)
		{
			// update the freqMap with the new occurrence
			if (!freqMap.containsKey(it))
			{
				freqMap.put(it, 1);
			}
			else
			{
				int counter = freqMap.get(it);
				freqMap.put(it, ++counter);
			}
		}
		// newValSet stores the pair of integer and its frequencies, while the integers are those occur most frequently.
		Set<Map.Entry<Integer, Integer>> maxEntrySet = new HashSet<>();
		// initialize a maxEntry set
		Map.Entry<Integer, Integer> maxEntry = null;
		// loop in the array and find the maximum freq
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet())
		{
			// Max value is not null, then put it a new value. if the max value is smaller than the current largest frequency, update the max value.
			if (maxEntry == null )
			{
				maxEntry = entry;
			} else if (entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
				maxEntrySet.clear();
				maxEntrySet.add(maxEntry);
			} else if (entry.getValue().compareTo(maxEntry.getValue()) == 0) {
				maxEntrySet.add(entry);
			}
		}
		// 求中位数
		List<Map.Entry<Integer, Integer>> newArray = new ArrayList<>(maxEntrySet);
		Collections.sort(newArray, new Comparator<Map.Entry<Integer, Integer>>()
		{
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
			{
				if (o1.getKey() == o2.getKey())
				{
					return 0;
				}
				return (o1.getKey() - o2.getKey() < 0? -1:1);
			}
		});
		int size = newArray.size();
		if (size % 2 == 0)
		{
			return (newArray.get(size / 2 - 1).getKey() + newArray.get(size / 2).getKey()) / 2;
		}
		else
		{
			return newArray.get(size / 2).getKey();
		}
	}
}
