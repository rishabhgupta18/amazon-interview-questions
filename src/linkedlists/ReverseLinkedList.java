package linkedlists;

import linkedlists.Utils.ListNode;
import static linkedlists.Utils.print;
import static linkedlists.Utils.getNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		print(reverseList(getNode(new int[] { 1, 2, 3, 4, 5 })));
	}

	public static ListNode reverseList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode n = head;
		ListNode nNext = n.next;
		n.next = null;
		while (nNext != null) {
			ListNode nNextNext = nNext.next;
			nNext.next = n;
			n = nNext;
			nNext = nNextNext;
		}

		return n;

	}
}
