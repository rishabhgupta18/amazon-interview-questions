package linkedlists;

public class CopyListWithRandomPointer {
	public static void main(String[] args) {
		print(copyRandomList(getNode(new int[][] { { 7, -1 }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } })));
//		7,null],[13,0],[11,4],[10,2],[1,0]
	}

	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static Node copyRandomList(Node head) {

		if (head == null)
			return head;

		Node cur = head;

		// create a new ith node
		// add it to i+1 position
		while (cur != null) {
			Node n = new Node(cur.val);
			n.next = cur.next;
			cur.next = n;
			cur = n.next;
		}

		// assign the random pointer
		cur = head;
		while (cur != null) {
			cur.next.random = cur.random == null ? null : cur.random.next;
			cur = cur.next.next;
		}

		// separate the lists
		cur = head;
		Node result = cur.next;
		Node rcur = result;
		do {
			cur.next = cur.next.next;
			rcur.next = rcur.next == null ? null : rcur.next.next;

			cur = cur.next;
			rcur = rcur.next;

		} while (cur != null);

		return result;
	}

	public static void print(Node n) {
		Node cu = n;
		System.out.println("normal pointer");
		while (cu != null) {
			System.out.print(cu.val + "->");
			cu = cu.next;
		}
		System.out.print("null\n");

		cu = n;
		System.out.println("Random pointer");
		while (cu != null) {
			System.out.print((cu.random != null ? cu.random.val : "null") + "->");
			cu = cu.next;
		}
		System.out.print("null\n");
	}

	public static Node getNode(int[][] ar) {
		Node root = null, curr = null;

		for (int[] a : ar) {
			Node n = new Node(a[0]);
			if (root == null) {
				root = n;
			} else {
				curr.next = n;
			}
			curr = n;
		}

		curr = root;
		int index = 0;
		while (curr != null) {

			int random = ar[index++][1];
			if (random == -1) {
				curr.random = null;
				curr = curr.next;
				continue;
			}
			int k = 0;
			Node it = root;

			while (k != random) {
				it = it.next;
				k++;
			}
			curr.random = it;
			curr = curr.next;

		}

		return root;
	}
}
