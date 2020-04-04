package treesandgraph;

import static treesandgraph.Utils.*;
import treesandgraph.Utils.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		System.out.println(isValidBST(getNode(new int[] { 5, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 6 })));
		System.out.println(isValidBST(getNode(new int[] { 2, 1, 3 })));
	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
	}

	private static boolean isValidBST(TreeNode node, int min, int max, boolean isValid) {

		if (node == null)
			return true;

		if (node.val < min || node.val > max || node.val == Integer.MIN_VALUE && node.left != null
				|| node.val == Integer.MAX_VALUE && node.right != null)
			return isValid = false;

		isValid = isValidBST(node.left, min, node.val - 1, isValid);
		if (!isValid)
			return isValid;

		return isValidBST(node.right, node.val + 1, max, isValid);
	}
}
