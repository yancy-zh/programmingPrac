package algorithms;

public class mergeSortedArrays
{
	public void merge(int[] arr1, int m, int[] arr2, int n)
	{
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i > -1 && j > -1)
		{
			arr1[k--] = (arr1[i] > arr2[j]) ? arr1[i--] : arr2[j--];
		}
		// n larger than m
		while (j > -1)
			arr1[k--] = arr2[j--];
	}
}
