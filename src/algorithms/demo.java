package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class demo
{
	
	public static void main(String[] args)
	{
		ArrayList<Integer> test =new ArrayList<>(List.of(1, 2, 3, 4, 5));
		ArrayList<Integer> out = getNewArray(test);
		for (int i = 0; i < test.size(); i++)
		{
			System.out.println(i + ": " + out.get(i));
		}
	}
	public static ArrayList<Integer> getNewArray(ArrayList<Integer> inArr)
	{
		ArrayList<Integer> outArr = new ArrayList<>();
		for (int i = 0; i < inArr.size(); i++)
		{
			outArr.add(multiplyArray(i, inArr));
		}
		return outArr;
	}
	
	public static int multiplyArray(int i, ArrayList<Integer> arr)
	{
		int prod = 1;
		for (int j = 0; j < arr.size(); j++)
		{
			if(j !=i)
			prod *= arr.get(i);
		}
		return prod;
	}
}
