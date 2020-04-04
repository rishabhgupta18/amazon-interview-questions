package treesandgraph;

import static treesandgraph.Utils.getNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import treesandgraph.Utils.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		System.out.println(
				zigzagLevelOrder(getNode(new int[] { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 })));
		System.out
				.println(zigzagLevelOrder(getNode(new int[] { 1, 2, 3, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 5 })));
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null)
			return new ArrayList<>();

		LinkedList<TreeNode> s = new LinkedList<>();
		int level = 0;
		int index = 0;
		s.add(root);
		// A delimiter to separate 2 levels
		s.addLast(null);
		// To insert next element
		index += 2;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> sub = new ArrayList<>();

		while (!s.isEmpty()) {

			TreeNode t = s.removeFirst();
			index--;
			if (t == null) {
				result.add(sub);
				sub = new ArrayList<>();
				level++;
				if (!s.isEmpty())
					s.addLast(null);
				index = s.size();
				continue;
			}
			sub.add(t.val);
			if (level % 2 != 0) {
				if (t.right != null)
					s.add(index, t.right);
				if (t.left != null)
					s.add(index, t.left);
			} else {

				if (t.left != null)
					s.add(index, t.left);
				if (t.right != null)
					s.add(index, t.right);

			}

		}

		return result;

	}
}
