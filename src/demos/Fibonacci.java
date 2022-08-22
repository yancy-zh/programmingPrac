package demos;

import java.util.ArrayList;
import java.util.Iterator;

public class Fibonacci
{
	public Integer main(String[] args) {
		ArrayList<Integer> arr = null;
		arr.add(23);
		arr.add(43);
		//starting with the 3rd number
		for (int i = 2; i <= 30; i++)
		{
			arr.add(i, arr.get(i-1) + arr.get(i-2));
		}
		return arr.get(arr.size()-1);
	}
}
