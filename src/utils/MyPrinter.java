package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MyPrinter
{
	
	public static void printStrList(ArrayList<String> list)
	{
		Iterator<String> iterator = list.iterator();
		StringBuilder builder = new StringBuilder(String.valueOf(list.size() + 1));
		while (iterator.hasNext())
		{
			builder.append(" ");
			builder.append(iterator.next());
		}
		System.out.println(builder.toString());
	}
	
	public static void printArrayList(ArrayList<?> list)
	{
		Iterator<?> iterator = list.iterator();
		StringBuilder builder = new StringBuilder(String.valueOf(list.size() + 1));
		while (iterator.hasNext())
		{
			builder.append(" ");
			builder.append(iterator.next());
		}
		System.out.println(builder.toString());
	}
	
	public static void printList(List<?> list)
	{
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	public static void printPrimitiveInt(int[] nums)
	{
		System.out.println(Arrays.toString(nums));
	}
	
	public static void printSet(Set<?> set)
	{
		Iterator<?> itr = set.iterator();
		while (itr.hasNext())
		{
			Object object = (Object) itr.next();
			System.out.println(object);
		}
	}
	
	public static void printQueue(PriorityQueue<?> q)
	{
		System.out.println(Arrays.toString(q.toArray()));
	}
	
	public static void printLinkedList(Queue<?> q)
	{
		System.out.println(Arrays.toString(q.toArray()));
	}
	
	public static int[] reversePrimitiveArray(int[] arr)
	{
		int n = arr.length;
		int[] reversedArr = new int[n];
		int j = 0;
		for (int i = n - 1; i >= 0; i--)
		{
			reversedArr[j] = arr[i];
			j++;
		}
		return reversedArr;
	}
	
	public static void printPrimitiveCharArr(char[] arr)
	{
		System.out.println(Arrays.toString(arr));
	}
}
