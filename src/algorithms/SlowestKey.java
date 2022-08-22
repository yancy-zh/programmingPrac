package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SlowestKey
{
	
	public static void main(String[] args)
	{
		List<List<Integer>> keyTimes = new ArrayList<>(3);
		keyTimes.add(Arrays.asList(0, 2));
		keyTimes.add(Arrays.asList(1, 3));
		keyTimes.add(Arrays.asList(0, 7));
		System.out.println(slowestKey(keyTimes));
	}
	
	public static char slowestKey(List<List<Integer>> keyTimes)
	{
		// key is the key pressed, val is the time it is pressed
		HashMap<Character, Integer> durationMap = new HashMap<>();
		durationMap.put(asciiToChar(keyTimes.get(0).get(0)), keyTimes.get(0).get(1)); // initialize the value
		// find the keypress duration
		for (int i = 1; i < keyTimes.size(); i++)
		{
			int currDuration = keyTimes.get(i).get(1) - keyTimes.get(i - 1).get(1);
			char currKey = asciiToChar(keyTimes.get(i).get(0));
			durationMap.put(currKey, Math.max(durationMap.getOrDefault(currKey, 0), currDuration));
		}
		char slowestKey = ' ';
		int longestDuration = 0;
		// iterate the map to find the sloweset key
		for (Map.Entry mapElement : durationMap.entrySet())
		{
			int duration = (int) mapElement.getValue();
			char key = (char) mapElement.getKey();
			if (duration > longestDuration)
			{
				longestDuration = duration;
				slowestKey = key;
			}
			else if (duration == longestDuration && key > slowestKey)
			{
				// TODO: unsure if needed
				slowestKey = key;
			}
		}
		return slowestKey;
		
	}
	
	public static Character asciiToChar(int asc)
	{
		return (char) (asc + 'a');
	}
}
