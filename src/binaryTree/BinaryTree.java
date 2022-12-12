package binaryTree;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BinaryTree
{
	public boolean leafSimilar(TreeNode root1, TreeNode root2)
	{
		List<Integer> leaves1 = new ArrayList<>();
		List<Integer> leaves2 = new ArrayList<>();
		getLeafValues(root1, leaves1);
		getLeafValues(root2, leaves2);
		Stream.of(leaves1).forEach(System.out::println);
		Stream.of(leaves2).forEach(System.out::println);
		return leaves1.equals(leaves2);
	}
	
	public void getLeafValues(TreeNode node, List<Integer> leafValues)
	{
		if (node != null)
		{
			if (node.left == null && node.right == null)
			{
				leafValues.add(node.val);
			}
			getLeafValues(node.left, leafValues);
			getLeafValues(node.right, leafValues);
		}
	}
	
	public int maxDepth(TreeNode root)	{
		if (root == null)
		{ return 0; }
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	
}
