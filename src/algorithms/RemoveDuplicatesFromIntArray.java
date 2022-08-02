package algorithms;

public class RemoveDuplicatesFromIntArray {
    public int removeDuplicates(int[] nums) {
    	/*int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    	 * ����һ���������� nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ������ɾ����������³��ȡ�

��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�

��Դ�����ۣ�LeetCode��26. ɾ�����������е��ظ���
���ӣ�https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
    	 */
    	if (nums.length == 0) {
			return 0;
		}
    	int slowIndex = 0;
    	for (int fastIndex = 0; fastIndex < nums.length -1; fastIndex++) {
    		if (nums[fastIndex] != nums[fastIndex + 1]) {
    			// ���ֺͺ�һ������ͬ
    			nums[++slowIndex] = nums[fastIndex + 1];
			}
    	}
    	return slowIndex + 1; //slowIndex����� ���������1
    }
}
