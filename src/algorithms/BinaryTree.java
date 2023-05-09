package algorithms;

import java.util.ArrayList;
import java.util.List;

import binaryTree.TreeNode;

public class BinaryTree {

	public static void main(String[] args) {

	}

	public List<Integer> inorderTranversal(TreeNode node) {
		List<Integer> res = new ArrayList<>();
		dfs(node, res);
		return res;

	}

	public void dfs(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		dfs(node.left, res);
		res.add(node.val);
		dfs(node.right, res);

	}
}
