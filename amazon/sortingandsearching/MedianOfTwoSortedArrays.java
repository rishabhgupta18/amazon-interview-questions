package sortingandsearching;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] {}));
		System.out.println(findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length > nums2.length)
			return findMedianSortedArrays(nums2, nums1);

		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;

		while (low <= high) {

			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int nums1Left = partitionX <= 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int nums1Right = partitionX >= x ? Integer.MAX_VALUE : nums1[partitionX];

			int nums2Left = partitionY <= 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int nums2Right = partitionY >= y ? Integer.MAX_VALUE : nums2[partitionY];

			if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
				// found the match
				if ((x + y) % 2 == 0) {
					return (double) (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2;
				} else {
					return (double) Math.max(nums1Left, nums2Left);
				}

			} else if (nums1Left > nums2Right) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}

		}
		return -1;
	}

}
