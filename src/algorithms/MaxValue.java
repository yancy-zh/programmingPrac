package algorithms;

public class MaxValue
{
	public static int maxArea(int[] heights)
	{
		int left= 0;
		int right = heights.length-1;
		if (heights.length < 2) // space bt left and right boards less than 1
		{
			return 0;
		}
		int maxArea = 0;
		while (left < right) {
			int volume = Math.min(heights[left],heights[right])*(right - left);
			maxArea = Math.max(maxArea, volume);
			if (heights[left] < heights[right]) // 瓶颈在于较低的边 所以往较低边的方向移动
			{
				left++;
			}else {
				right--;
			}
			
		}
		return maxArea;
	}
	public static void main(String[] args)
	{
		int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//		int[] heights = {1, 1};
		System.out.println(maxArea(heights));
	}

}
