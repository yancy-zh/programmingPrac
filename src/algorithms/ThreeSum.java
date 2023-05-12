package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum
{
	
	public static void main(String[] args)
	{
		
		
	}
	 public static void func4(String arr[])
	    {
	        // Using Arrays.stream.collect() method.
	        ArrayList<String> array_list = (ArrayList<String>)
	                    Arrays.stream(arr)
	                          .collect(Collectors.toList());
	        System.out.print(array_list);
	    }
    public List<List<Integer>> threeSum(int[] nums) {
    	if (nums.length==3)
		{	
    		if (nums[0]+nums[1]+nums[2]==0)
			{
    			List<List<Integer>> res = null;
    			List<Integer> array_List =new ArrayList<Integer>();
    			res.add(array_List);
				return res;
			}
			return new ArrayList<>();
			
		}
    	if (nums.length==0)
		{
			return new ArrayList<>();
		}
		return null;
    }
}
