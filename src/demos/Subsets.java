package demos;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	/*����һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����

�⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��*/
	List<Integer> t = new ArrayList<Integer>(); //һ���Ӽ�
	List<List<Integer>> ans = new ArrayList<List<Integer>>(); //�洢�����⼯�������������Ӽ��ļ���
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
    	t.add(nums[cur]); //�����һ��
    	dfs(cur + 1, nums); //������ſ�ʼ����������ȱ���
    	t.remove(t.size()-1);//���Ӽ�������ȥ�����һ��
    	dfs(cur + 1, nums); //
    }
}
