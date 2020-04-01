package linkedlists;

import linkedlists.Utils.ListNode;
import static linkedlists.Utils.getNode;
import static linkedlists.Utils.print;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		print(reverseKGroup(getNode(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }), 1));
	}

	public static ListNode reverseKGroup(ListNode head, int k) {

		 if(head == null || k == 0 || k==1)
			 return head;
		ListNode cur = head;
		head = null;
		ListNode prevL = null;

		while (cur != null) {

			int i = 0;
			// check k nodes
			ListNode n = cur;
			while (i < k && n != null) {
				i++;
				n = n.next;
			}
			if (i < k)
				break;
			// shift k nodes
			ListNode prev = cur;
			ListNode curr = cur.next;
			ListNode next = curr.next;
			while (next != n) {
				curr.next = prev;
				prev = curr;
				curr = next;
				next = curr.next;
			}
			curr.next = prev;
			if (head == null) {
				head = curr;
			}
			if (prevL != null)
				prevL.next = curr;
			prevL = cur;
			cur.next = n;
			cur = n;

		}

		return head;

	}
}
