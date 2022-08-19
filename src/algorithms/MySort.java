package algorithms;

public class MySort
{
	
	public void quickSort(int arr[], int begin, int end)
	{
		/*
		 * quick sort used in divide-and-conquer principle. It has an average O(n log n) complexity Arr[] = {5, 9, 4, 6, 5, 3} Let's suppose we pick 5 as the
		 * pivot for simplicity We'll first put all elements less than 5 in the first position of the array: {3, 4, 5, 6, 5, 9} We'll then repeat it for the
		 * left sub-array {3,4}, taking 3 as the pivot There are no elements less than 3 We apply quicksort on the sub-array in the right of the pivot, i.e. {4}
		 * This sub-array consists of only one sorted element We continue with the right part of the original array, {6, 5, 9} until we get the final ordered
		 * array
		 */
		if (begin < end)
		{
			int partitionIndex = partition(arr, begin, end);
			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}
	
	private int partition(int arr[], int begin, int end)
	{
		int pivot = arr[end];
		int i = (begin - 1);
		
		for (int j = begin; j < end; j++)
		{
			if (arr[j] <= pivot)
			{
				i++;
				
				int swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}
		
		int swapTemp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = swapTemp;
		
		return i + 1;
	}
	
	public static void insertionSort(int array[])
	{
		/*
		 * Insertion is good for small elements only because it requires more time for sorting large number of elements.
		 */
		int n = array.length;
		for (int j = 1; j < n; j++)
		{
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key))
			{
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}
	
	public static int[] bubbleSort(int[] arr)
	{
		/*
		 * array is traversed from first element to last element. Here, current element is compared with the next element. If current element is greater than
		 * the next element, it is swapped.
		 */
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 1; j < (n - i); j++)
			{
				if (arr[j - 1] > arr[j])
				{
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
