package treesandgraph;

import treesandgraph.Utils.TreeNode;
import static treesandgraph.Utils.getNode;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		System.out.println(maxPathSum(getNode(new int[] { -1,Integer.MIN_VALUE,9,-6,3,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,-2})));
		System.out.println(maxPathSum(getNode(new int[] { -2, 6, Integer.MIN_VALUE, 0, -6 })));
		System.out.println(maxPathSum(getNode(new int[] { 1, 2, 3 })));
		System.out.println(maxPathSum(getNode(new int[] { -10, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 })));
	}

	public static int maxPathSum(TreeNode root) {
		Result result = new Result(Integer.MIN_VALUE);
		int res = maxPathSum(root, result);
		return Math.max(result.val, res);
	}

	// To update and hold the reference in the stack
	static class Result {
		int val;

		public Result(int val) {
			this.val = val;
		}
	}

	private static int maxPathSum(TreeNode node, Result result) {
		if (node == null)
			return 0;

		int left = maxPathSum(node.left, result);
		int right = maxPathSum(node.right, result);

		// check max in root vs root + (Max of left, right)
		int res = Math.max(Math.max(left, right) + node.val, node.val);

		// Also if root + left + right is the max
		// Then this is the result
		result.val = Math.max(Math.max(res, node.val + left + right), result.val);

		return res;
	}
}
