package treesandgraph;

import java.util.LinkedList;
import java.util.Queue;

public class Utils {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return ""+val;
		}
		
		

	}

	public static void print(TreeNode t) {
		if (t == null)
			return;
		print(t.left);
		System.out.println(t.val);
		print(t.right);
	}

//	5,1,4,null,null,3,6

	public static TreeNode getNode(int[] ar) {

		TreeNode root = new TreeNode(ar[0]);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		for (int i = 0; i < ar.length / 2; i++) {

			TreeNode n = q.poll();
			n.left = ar[i * 2 + 1] != Integer.MIN_VALUE ? new TreeNode(ar[i * 2 + 1]) : null;
			n.right = ar[i * 2 + 2] != Integer.MIN_VALUE ? new TreeNode(ar[i * 2 + 2]) : null;
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}

		return root;
	}
}
