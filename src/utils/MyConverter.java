package utils;

import java.util.List;

public class MyConverter
{
	public static int[] ListIntToPrimitive(List<Integer> list)
	{
		return list.stream().mapToInt(i -> i).toArray();
	}
}
