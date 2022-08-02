package algorithms;

import java.util.HashSet;
import java.util.List;

public class GemStones
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}
	
	public static int gemstones(List<String> rocks)
	{
		String firstString = rocks.get(0);
		
		HashSet<String> charSet = new HashSet<String>();
		
		for (String c : firstString.split(""))
		{
			charSet.add(c);
		}
		
		int total = 0;
		for (String c : charSet)
		{
			Boolean exists = true;
			for (int i = 1; i < rocks.size(); i++)
			{
				String thisRock = rocks.get(i);
				if (!thisRock.contains(c))
				{
					exists = false;
				}
			}
			
			if (exists) total++;
		}
		return total;
	}
}
