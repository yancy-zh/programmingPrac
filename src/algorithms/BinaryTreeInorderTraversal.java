package algorithms;

import java.util.ArrayList;
import java.util.List;
import binaryTree.TreeNode;

public class BinaryTreeInorderTraversal
{
	
	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> visitedNodes = new ArrayList<Integer>();
		inorder(visitedNodes, root);
		return visitedNodes;
	}
	
	public void inorder(List<Integer> nodes, TreeNode root)
	{
		if (root != null)
		{
			inorder(nodes, root.left);
			nodes.add(root.val);
			inorder(nodes, root.right);
		}
	}
}
