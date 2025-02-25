package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeInMatrix
{
	public int finalPositionOfSnake(int n, List<String> commands)
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("RIGHT", 1);
		map.put("LEFT", -1);
		map.put("UP", -n);
		map.put("DOWN", n);
		int res = 0;
		for (int i = 0; i < commands.size(); i++)
		{
			String commString = commands.get(i);
			res += map.get(commString);
		}
		return res;
	}
}
