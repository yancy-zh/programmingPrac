package plusInterviewed;

import binaryTree.TreeNode;

public class ClosestBinarySearchTreeValue
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/closest-binary-search-tree-value/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * 270. Closest Binary Search Tree Value Given the root of a binary search tree and a target value, return the value in the BST that is closest to the
		 * target. If there are multiple answers, print the smallest.
		 * 
		 * Example 1: Input: root = [4,2,5,1,3], target = 3.714286 Output: 4 Example 2: Input: root = [1], target = 4.428571 Output: 1
		 * 
		 * Constraints: The number of nodes in the tree is in the range [1, 104]. 0 <= Node.val <= 10^9 -10^9 <= target <= 10^9
		 */
		/*
		 * 二分搜索树（Binary Search Tree）的特性，以右上角的元素为根节点： 若它的左子树不为空，左子树上所有节点的值都小于它的根节点 若它的右子树不为空，右子树上所有的节点的值都大于它的根节点 它的左、右子树也都是二分搜索树
		 */
	}
	
	public int closestValue(TreeNode root, double target)
	{
		int l = root.val;
		int r = root.val;
		while (root != null)
		{
			if (root.val > target)
			{
				r = root.val;
				root = root.left;
			}
			else if (root.val < target)
			{
				l = root.val;
				root = root.right;
			}
			else
			{
				return root.val;
			}
		}
		return Math.abs(r - target) < Math.abs(l - target) ? r : l;
	}
}
