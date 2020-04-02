package treesandgraph;

import static treesandgraph.Utils.*;

import treesandgraph.Utils.TreeNode;

public class SymmetricTree {

	public static void main(String[] args) {
		System.out.println(isSymmetric(getNode(new int[] { 1, 2, 2, 3, 4, 4, 3 })));
		System.out.println(isSymmetric(getNode(new int[] { 1, 2, 2, Integer.MIN_VALUE, 3, Integer.MIN_VALUE, 3 })));
		System.out.println(isSymmetric(getNode(new int[] {})));

	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetric(root.left, root.right, true);
	}

	private static boolean isSymmetric(TreeNode leftTreeNode, TreeNode rightTreeNode, boolean isSymmetric) {

		if (leftTreeNode == null && rightTreeNode == null)
			return true;

		if ((leftTreeNode == null && rightTreeNode != null) || rightTreeNode == null && leftTreeNode != null)
			return false;

		if (leftTreeNode.val != rightTreeNode.val)
			return false;
		isSymmetric = isSymmetric(leftTreeNode.left, rightTreeNode.right, isSymmetric);
		if (!isSymmetric)
			return false;
		return isSymmetric(leftTreeNode.right, rightTreeNode.left, isSymmetric);

	}

}
