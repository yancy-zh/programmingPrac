package binaryTree;

//Definition for a binary tree node.
public class TreeNode {
	/**
	 * Definition for a binary tree node.
	 */
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
	
	TreeNode() {}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}