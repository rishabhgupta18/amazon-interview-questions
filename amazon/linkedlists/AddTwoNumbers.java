package linkedlists;

import linkedlists.Utils.ListNode;
import static linkedlists.Utils.getNode;
import static linkedlists.Utils.print;

public class AddTwoNumbers {

	public static void main(String[] args) {
		print(addTwoNumbers(getNode(new int[] { 2, 4, 3 }), getNode(new int[] { 5, 6, 4 })));
		print(addTwoNumbers(getNode(new int[] { 1 }), getNode(new int[] { 9, 9 })));
		print(addTwoNumbers(getNode(new int[] { 5 }), getNode(new int[] { 5 })));

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;

	}

	

}
