package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class multiThreading
{
	/*
	 * 2080. 数组去重
给定一个有序数组 nums ，请删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。

解答要求
时间限制：1000ms, 内存限制：64MB
输入
给定一个有序数组

输出
去重后数组长度

样例
输入样例 1 复制

1,1,1,2,2,3
输出样例 1
5
	 */
	int[] toSort;
	public multiThreading(int[] p_toSort)
	{
		this.toSort = p_toSort;
	}
	
	public int uniqueArr(int[] arr)
	{
		Arrays.sort(arr);
		ArrayList<Integer> outArr = new ArrayList<>();
		outArr.add(arr[0]);
		outArr.add(arr[1]);
		for (int i = 2; i < arr.length; i++)
		{
			if (arr[i] == arr[i-1] && arr[i-1] == arr[i-2])
			{
				continue;
			} else 
			{
				outArr.add(arr[i]);
			}
		}
		return outArr.size();
	}
	
	public static void main(String[] args)
	{
		int[] test = {1,1, 1, 1, 2,  2, 2, 3};
		multiThreading multiThreading = new multiThreading(test);
		int res = multiThreading.uniqueArr(test);
		System.out.println(res);
	}
	
}
