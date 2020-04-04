package sortingandsearching;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
	
	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 2));
		System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
		System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 0));
	}

	public static int findKthLargest(int[] nums, int k) {

		if (nums.length == 0)
			return -1;

		Queue<Integer> minHeap = new PriorityQueue<>(k);

		int i = 0;

		for (; i < k; i++)
			minHeap.add(nums[i]);

		for (; i < nums.length; i++) {

			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}

		}

		return minHeap.peek();
	}

}
