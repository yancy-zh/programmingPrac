package algorithms;
import java.util.*;

public class TreePrinter {
    public static int[][] printTree(TreeNode root) {
        // print the tree in layer zig zag order ¾â³ÝÐÎ²ãÐò±éÀú ¶þ²æÊ÷ leetcode 103
    	/*
    	 * 		BuildTreeFromPreAndInOder buildTreeSol = new BuildTreeFromPreAndInOder();
		int[] preorder = {3,9,20,15,7},	inorder = {9,3,15,20,7};
		TreeNode treeNode = buildTreeSol.buildTree(preorder, inorder);
		int[][] res = TreePrinter.printTree(treeNode);
    	 */
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		// store values to print
        ArrayList<Integer> temp = new ArrayList<Integer>();
		// store tree nodes
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		// add node to queue
        queue.offer(root);
		// store current node
        TreeNode node = null;
        TreeNode last = root;
        TreeNode nlast = last;
        if(root == null)
            return null;
        while(!queue.isEmpty()){
			//remove node
            node = queue.poll();
            temp.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
                nlast = node.left;
            }
             if(node.right!=null){
                queue.offer(node.right);
                nlast = node.right;
            }
            if(node == last){
                res.add(temp);
                temp = new ArrayList<Integer>();
                last = nlast;
            }
        }
        int[][] result = new int[res.size()][];
        for(int i=0;i<res.size();i++){
            result[i] = new int[res.get(i).size()];
            for(int j=0;j<result[i].length;j++){
                result[i][j] = res.get(i).get(j);
            }
        }
        return result;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			int n = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(level);
		}
		return res;
	}
}