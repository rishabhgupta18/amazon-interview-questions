package linkedlists;

public class Utils {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return ""+val;
		}

	}

	public static void print(ListNode n) {
		ListNode cu = n;

		while (cu != null) {
			System.out.print(cu.val + "->");
			cu = cu.next;
		}
		System.out.print("null\n");
	}

	public static ListNode getNode(int[] ar) {
		ListNode root = null, curr = null;

		for (int a : ar) {
			ListNode n = new ListNode(a);
			if (root == null) {
				root = n;
			} else {
				curr.next = n;
			}
			curr = n;
		}
		return root;
	}
}
