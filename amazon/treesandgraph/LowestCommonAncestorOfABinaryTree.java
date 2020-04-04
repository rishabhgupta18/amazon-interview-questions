package treesandgraph;

import treesandgraph.Utils.TreeNode;
import static treesandgraph.Utils.getNode;

public class LowestCommonAncestorOfABinaryTree {

	public static void main(String[] args) {

		TreeNode t = getNode(new int[] { 3, 5, 1, 6, 2, 0, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, 4 });
		System.out.println(lowestCommonAncestor(t, new TreeNode(5), new TreeNode(8)).val);
		System.out.println(lowestCommonAncestor(t, new TreeNode(5), new TreeNode(4)).val);
	}

	static class Result {
		TreeNode lca;

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = new Result();
		lowestCommonAncestor(root, p, q, r);
		return r.lca;

	}

	private static boolean lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q, Result r) {

		if (node == null)
			return false;

		int left = lowestCommonAncestor(node.left, p, q, r) ? 1 : 0;
		int right = lowestCommonAncestor(node.right, p, q, r) ? 1 : 0;

		int mid = (node.val == p.val || node.val == q.val) ? 1 : 0;

		if (mid + left + right == 2) {
			r.lca = node;
		}
		return (mid + left + right) > 0;
	}

}
