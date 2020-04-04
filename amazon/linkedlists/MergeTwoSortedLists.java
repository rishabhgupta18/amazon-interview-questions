package linkedlists;

import linkedlists.Utils.ListNode;
import static linkedlists.Utils.getNode;
import static linkedlists.Utils.print;

public class MergeTwoSortedLists {
	
	public static void main(String[] args) {
		print(mergeTwoLists(getNode(new int[] {1,2,4}), getNode(new int[] {1,3,4})));
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode dummyNode = new ListNode(0);

		ListNode p = l1, q = l2, curr = dummyNode;

		while (p != null || q != null) {
			ListNode ele = null;
			if (p == null) {
				ele = new ListNode(q.val);
				q = q.next;
			} else if (q == null) {
				ele = new ListNode(p.val);
				p = p.next;
			} else if (p.val < q.val) {
				ele = new ListNode(p.val);
				p = p.next;
			} else {
				ele = new ListNode(q.val);
				q = q.next;
			}
			curr.next = ele;
			curr = curr.next;
		}

		return dummyNode.next;

	}
}
