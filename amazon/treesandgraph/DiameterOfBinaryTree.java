package treesandgraph;

import treesandgraph.Utils.TreeNode;
import static treesandgraph.Utils.getNode;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		System.out.println(diameterOfBinaryTree(getNode(new int[] { 1, 2, 3, 4, 5 })));
	}

	static class Result {
		int val;
	}

	public static int diameterOfBinaryTree(TreeNode root) {

		if(root == null)
			return 0;
		Result r = new Result();
		diameterOfBinaryTree(root, r);
		return r.val-1;
	}

	private static int diameterOfBinaryTree(TreeNode node, Result r) {

		if (node == null)
			return 0;

		int leftHeight = diameterOfBinaryTree(node.left, r);
		int rightHeight = diameterOfBinaryTree(node.right, r);

		int max_height = leftHeight + rightHeight + 1;

		r.val = Math.max(max_height, r.val);

		return Math.max(leftHeight, rightHeight) + 1;

	}

}
