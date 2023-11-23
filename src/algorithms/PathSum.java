package algorithms;

import binaryTree.TreeNode;

public class PathSum
{
	
	public boolean hasPathSum(TreeNode root, int targetSum)
	{
		/*
		 * leetcode 112
		 */
		if (root == null)
		{ return false; }
		if (root.left == null && root.right == null)
		{ return root.val == targetSum; }
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}
	
}
