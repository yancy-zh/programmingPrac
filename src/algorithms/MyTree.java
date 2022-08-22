package algorithms;

import java.util.List;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import algorithms.MyTree.TreeNode;

import java.lang.Math;
import static java.util.Arrays.*;

public class MyTree {
	static class TreeNode {
		/**
		 * Definition for a binary tree node.
		 */
		int val;
		TreeNode left;
		TreeNode right;

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.equals("None"))
			System.out.println("True");
		else {
			String[] arr = s.split(",");
			TreeNode root = createTree(arr, 0);
//            System.out.println("Tree created");
//            System.out.println(validateSearchTree(root)?"True":"False");
			System.out.println(isBalanceTree(root) ? "True" : "False");
		}
	}

	public static boolean validateSearchTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (root.left.val < root.val && root.right.val > root.val) {
			if (validateSearchTree(root.left) && validateSearchTree(root.right)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	private static boolean isBalanceTree(TreeNode root) {
		//判断一棵树是否为平衡二叉树
		if (root == null) {
			return true;
		} else {
			if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanceTree(root.right)
					&& isBalanceTree(root.left)) {
				return true;
			} else {
				return false;
			}
		}
	}

	private static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int hl = getHeight(root.left);
			int hr = getHeight(root.right);
			return hl > hr ? hl + 1 : hr + 1;
		}
	}

	public static TreeNode createTree(String[] arr, int i) {
		// i is the index in the array of strings. for each number in the array, a tree
		// node is created
		if (i > arr.length - 1)
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
		root.left = createTree(arr, 2 * i + 1);
		root.right = createTree(arr, 2 * i + 2);
		return root;
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		/*
		 * leetcode 103, 层数计数由0开始，偶数层（开始为0）顺序遍历使用队列，奇数层（开始为1）逆序遍历使用栈
		 * 		TreeNode rootTreeNode = new TreeNode(3);
		rootTreeNode.left = new TreeNode(9);
		rootTreeNode.right = new TreeNode(20);
		rootTreeNode.left.left = new TreeNode(16);
		rootTreeNode.left.right = new TreeNode(8);
		rootTreeNode.right.left = new TreeNode(15);
		rootTreeNode.right.right = new TreeNode(7);
		System.out.println(myTree.zigzagLevelOrder(rootTreeNode));
		 */
		List<List<Integer>> ret = new java.util.ArrayList<>();
		if (root == null) {
			return ret;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		queue.add(root);
		int level = 1;
		/// 层数为奇数时，正常顺序遍历,层数为偶数,倒序遍历
		while (!queue.isEmpty() || !stack.isEmpty()) {
			boolean isOrder = (level & 1) == 1; // 查看是奇数层（1）还是偶数层（0）
			int n = isOrder ? queue.size() : stack.size(); // 当前层的节点个数，偶数层用队列存储，奇数层用栈存储
			List<Integer> sub = new ArrayList<>();
			for (int i = 0; i < n; i++) { // 遍历当前层并读取出其下层节点
				if (isOrder) {
					// 从队列中中读取当前节点，其左右孩子，按照先左后右顺序，加入栈。
					TreeNode curNode = queue.poll();
					sub.add(curNode.val); // 取出节点的值
					if (curNode.left != null) {
						stack.push(curNode.left);
					}
					if (curNode.right != null) {
						stack.push(curNode.right);
					}
				} else {
					// 从栈中读取当前节点，其左右孩子，按照先右后左顺序，加入队列。
					TreeNode curNode = stack.poll();
					sub.add(curNode.val);
					if (curNode.right != null) {
						queue.addFirst(curNode.right);
					}
					if (curNode.left != null) {
						queue.addFirst(curNode.left);
					}
				}
			}
			level++;
			ret.add(sub);
		}
		return ret;
	}

	public int numTrees(int n) {
		//二叉搜索树个数 leetcode 96
		/*
		给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
		*/
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n+1; i++) {
			for (int j = 1; j < i+1; j++) {
				dp[i] += dp[j-1] *dp[i-j];
				
			}
		}
		return dp[n];
	}
	
	// inorder tranverse 
	public List<Integer> inorderTraversal(algorithms.TreeNode root){
		/*		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		MyTree myTree = new MyTree();
		List<Integer> res = myTree.inorderTranversal(root);
		*/
		List<Integer> res = new ArrayList<>();
		inOrder(root, res);
		return res;
	}
	
	public void inOrder(algorithms.TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}
	
}
