package algorithms;


public class BinarySearch
{
	
	public static void main(String[] args)
	{
		int[] srcArr = {1, 3, 5, 6,  8, 9, 9,16, 16};
		int key = 17;
		System.out.println(binarySearch(srcArr, key));
		System.out.println(binarySearch(srcArr, 0, srcArr.length-1,  key));
	}
	
	public static int binarySearch(int[] srcArr, int start, int end, int key)
	{
//		Arrays.sort(srcArr);
		int mid = (end -start)/2 + start;
		if (srcArr[mid] == key)
		{
			return mid;
		}
		if (start >= end) // reached left-most or right-most part
		{
			return -1; // not found
		} else if (key > srcArr[mid]){// search in the right part
			return binarySearch(srcArr, mid+1, end, key);
		} else if (key < srcArr[mid]) {// search in the left part
			return binarySearch(srcArr, start, mid-1, key);
		}
		return -1;
	}
	
	public static int binarySearch(int srcArr[], int key){
//		Arrays.sort(srcArr);
		int mid = srcArr.length/2;
		if (key == srcArr[mid])
		{
			return mid; 
		}
		
		int start = 0;
		int end = srcArr.length -1 ;
		while (start < end) {
			mid = (end - start)/ 2 + start;
			if (key < srcArr[mid]){
				end = mid -1;
			} else if (key> srcArr[mid]) {
				start = mid + 1;
			} else
			{
				return mid;
			}
		}
		return -1; // not found
	}

}
