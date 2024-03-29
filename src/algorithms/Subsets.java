package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	/*给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。*/
	List<Integer> t = new ArrayList<Integer>(); //一个子集
	List<List<Integer>> ans = new ArrayList<List<Integer>>(); //存储整个解集，即包含所有子集的集合
    public List<List<Integer>> subsets(int[] nums){
    	dfs(0, nums);
    	return ans;
    }
    
    public void dfs(int cur, int[] nums){
    	// cur stands for the index to cut, nums is the integer array
    	if (cur == nums.length) {
			ans.add(new ArrayList<Integer>(t));
			return;
		}
    	t.add(nums[cur]); //加入第一个
    	dfs(cur + 1, nums); //余下序号开始的数进行深度遍历
    	t.remove(t.size()-1);//从子集数组中去掉最后一个
    	dfs(cur + 1, nums); //
    }
}
