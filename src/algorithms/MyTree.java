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
		//�ж�һ�����Ƿ�Ϊƽ�������
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
		 * leetcode 103, ����������0��ʼ��ż���㣨��ʼΪ0��˳�����ʹ�ö��У������㣨��ʼΪ1���������ʹ��ջ
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
		/// ����Ϊ����ʱ������˳�����,����Ϊż��,�������
		while (!queue.isEmpty() || !stack.isEmpty()) {
			boolean isOrder = (level & 1) == 1; // �鿴�������㣨1������ż���㣨0��
			int n = isOrder ? queue.size() : stack.size(); // ��ǰ��Ľڵ������ż�����ö��д洢����������ջ�洢
			List<Integer> sub = new ArrayList<>();
			for (int i = 0; i < n; i++) { // ������ǰ�㲢��ȡ�����²�ڵ�
				if (isOrder) {
					// �Ӷ������ж�ȡ��ǰ�ڵ㣬�����Һ��ӣ������������˳�򣬼���ջ��
					TreeNode curNode = queue.poll();
					sub.add(curNode.val); // ȡ���ڵ��ֵ
					if (curNode.left != null) {
						stack.push(curNode.left);
					}
					if (curNode.right != null) {
						stack.push(curNode.right);
					}
				} else {
					// ��ջ�ж�ȡ��ǰ�ڵ㣬�����Һ��ӣ��������Һ���˳�򣬼�����С�
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
		//�������������� leetcode 96
		/*
		����һ������ n ����ǡ�� n ���ڵ�����ҽڵ�ֵ�� 1 �� n ������ͬ�� ���������� �ж����֣�������������Ķ�����������������
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
