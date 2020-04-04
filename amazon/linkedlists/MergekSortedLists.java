package linkedlists;

import java.util.PriorityQueue;
import java.util.Queue;

import linkedlists.Utils.ListNode;
import static linkedlists.Utils.print;
import static linkedlists.Utils.getNode;

public class MergekSortedLists {

	public static void main(String[] args) {

		print(mergeKLists(new ListNode[] { getNode(new int[] { 1, 4, 5 }), getNode(new int[] { 1, 3, 4 }),
				getNode(new int[] { 2, 6 }) }));
		
		print(mergeKListsMergeSort(new ListNode[] { getNode(new int[] { 1, 4, 5 }), getNode(new int[] { 1, 3, 4 }),
				getNode(new int[] { 2, 6 }) }));

	}

	public static ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0)
			return null;

		ListNode result = new ListNode(-1);
		Queue<ListNode> q = new PriorityQueue<>(lists.length, (ListNode l1, ListNode l2) -> {
			if (l1.val < l2.val)
				return -1;
			if (l1.val > l2.val)
				return 1;
			return 0;
		});

		for (ListNode l : lists)
			if (l != null)
				q.add(l);

		ListNode cur = result;
		while (!q.isEmpty()) {
			ListNode n = q.poll();
			cur.next = n;
			cur = cur.next;
			if (n.next != null)
				q.add(n.next);
		}

		return result.next;
	}

	public static ListNode mergeKListsMergeSort(ListNode[] lists) {

		if (lists == null || lists.length == 0)
			return null;

		int t = lists.length;
		while (t > 1) {

			for (int i = 0; i < t / 2; i++) {

				ListNode l1 = lists[i];
				ListNode l2 = lists[t - i - 1];
				ListNode dummy = new ListNode(-1);
				ListNode cur = dummy;

				while (l1 != null || l2 != null) {
					
					if (l2 == null) {
						cur.next = l1;
						cur = cur.next;
						l1 = l1.next;
						continue;
					}

					if (l1 == null) {
						cur.next = l2;
						cur = cur.next;
						l2 = l2.next;
						continue;
					}

					if (l1.val < l2.val) {
						cur.next = l1;
						l1 = l1.next;
					}else {
						cur.next = l2;
						l2 = l2.next;
					}
					cur = cur.next;
				}

				lists[i] = dummy.next;

			}

			t = (t + 1)/ 2 ;
		}

		return lists[0];

	}

}
