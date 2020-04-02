package treesandgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import treesandgraph.Utils.TreeNode;
import static treesandgraph.Utils.getNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {

		System.out.println(levelOrder(getNode(new int[] { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 })));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {

		if (root == null)
			return new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sub = new ArrayList<>();

		while (!q.isEmpty()) {

			TreeNode t = q.poll();
			if (t == null) {
				result.add(sub);
				sub = new ArrayList<>();
				if (!q.isEmpty())
					q.add(null);
				continue;
			}
			sub.add(t.val);
			if (t.left != null)
				q.add(t.left);

			if (t.right != null)
				q.add(t.right);

		}

		return result;
	}

}
