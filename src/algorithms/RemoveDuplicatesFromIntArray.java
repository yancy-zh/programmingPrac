package algorithms;

public class RemoveDuplicatesFromIntArray {
    public int removeDuplicates(int[] nums) {
    	/*int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    	 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）26. 删除有序数组中的重复项
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    	 */
    	if (nums.length == 0) {
			return 0;
		}
    	int slowIndex = 0;
    	for (int fastIndex = 0; fastIndex < nums.length -1; fastIndex++) {
    		if (nums[fastIndex] != nums[fastIndex + 1]) {
    			// 发现和后一个不相同
    			nums[++slowIndex] = nums[fastIndex + 1];
			}
    	}
    	return slowIndex + 1; //slowIndex是序号 长度则需加1
    }
}
