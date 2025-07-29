package utils;

import java.util.List;

public class MyConverter {
	public int[] ListIntToPrimitive(List<Integer> list) {
		return list.stream().mapToInt(i -> i).toArray();
	}
}
