package demos;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IKM
{
	
	public static void main(String[] args)
	{
		List<Integer> numList = List.of(0, 3, 4, 1, 9, 6, 2, 1, 2);
		List<Integer> newList = numList.stream().sorted(Comparator.reverseOrder()).filter(s -> s % 3 == 0).collect(Collectors.toList());
		System.out.println(newList);
		
	}
	
}
