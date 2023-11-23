package algorithms;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import binaryTree.TreeNode;

public class PathSum2
{
/*
 * 113. Path Sum II
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
Input: root = [1,2,3], targetSum = 5
Output: []
Input: root = [1,2], targetSum = 0
Output: []
 */
	List<List<Integer>> ret = new LinkedList<List<Integer>>();
	Deque<Integer> deque = new LinkedList<Integer>();
	
	public List<List<Integer>> pathSum(TreeNode root, int targetSum)
	{
		dfs(root, targetSum);
		return ret;
		
	}
	
	private void dfs(TreeNode root, int targetSum)
	{
		if (root == null)
		{ return; }
		deque.offerLast(root.val);
		targetSum -= root.val;
		if (root.left == null && root.right == null && targetSum == 0)
		{
			ret.add(new LinkedList<Integer>(deque));
		}
		dfs(root.left, targetSum);
		dfs(root.right, targetSum);
		deque.pollLast();
	}
}
