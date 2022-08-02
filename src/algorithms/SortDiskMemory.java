package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortDiskMemory {
	/* example input
	 * 3
1T
2T
1024M
4
1G
2G
1G2M
1024M
usage: 
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
        	int n = Integer.parseInt(sc.nextLine());
        	String[] strArr = new String[n];
        	for (int i = 0; i < n; i++) {
        		strArr[i] = sc.nextLine();
        	}
        	SortDiskMemory sol = new SortDiskMemory();
        	String[] sortedMemories = sol.sortDiskMemory(strArr);
        }*/
	HashMap<String, Integer> tagToAmount = new HashMap<>();
	HashMap<String, String> tagToRegex = new HashMap<>();
	String[] tags = {"T", "G", "M"};
	
	public SortDiskMemory() {
		// 换算内存时，以M为单位，"T" 和"G"均换算为M。
		tagToAmount.put("T", 1024*1024); 
		tagToAmount.put("G", 1024);
		tagToAmount.put("M", 1);
		tagToRegex.put("T", "\\d+(T)");
		tagToRegex.put("G", "\\d+(G)");
		tagToRegex.put("M", "\\d+(M)");
	}
	
	public String[] sortDiskMemory(String[] memories) {
		HashMap<Integer, String> hashMap = new HashMap<>();
		List<Integer> sorted = new ArrayList<Integer>();
		for (int i = 0; i < memories.length; i++) {
			int sum = 0;
			for (int j = 0; j < tags.length; j++) {
				//对于一个输入的容量标签，扫描三种标签，其换算得到的容量何值？
				sum += calcAmount(memories[i], tags[j]);
			}
			sorted.add(sum);
			hashMap.put(sum, memories[i]);
		}
		Collections.sort(sorted);
		String[] sortedMemories = new String[sorted.size()];
		for (int i = 0; i < sorted.size(); i++) {
			sortedMemories[i] = hashMap.get(sorted.get(i));
		}
		return sortedMemories;
		
	}
	
	public long calcAmount(String diskMemo, String tag) {
		Pattern TTag = Pattern.compile(tagToRegex.get(tag));
		Matcher matcherT = TTag.matcher(diskMemo);
		if (matcherT.find()) {
			String foundStr = matcherT.group();
			 long temp = Integer.parseInt(foundStr.substring(0, foundStr.length()-1));
			 int scale = tagToAmount.get(tag); 
			 return scale * temp;
		} else {
			return 0;
		}
	}
}
