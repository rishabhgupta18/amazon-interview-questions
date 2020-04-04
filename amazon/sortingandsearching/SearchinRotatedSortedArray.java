package sortingandsearching;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
//		int[] nums = { 0, 1, 2, 4, 5, 6, 7 };
		System.out.println(search(nums, 2));
		System.out.println(search(nums, 3));
		System.out.println(search(nums, 5));
		System.out.println(search(new int[] { 1, 3 }, 3));
		System.out.println(search(new int[] { 5, 1, 3 }, 5));
		System.out.println(search(new int[] { 4, 5, 6, 7, 8, 1, 2, 3 }, 8));
		System.out.println(search(new int[] { 5, 1, 2, 3, 4 }, 1));
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;

		int start = 0, end = nums.length - 1;
		int index = -1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (nums[mid] == target) {
				index = mid;
				break;
			}

			// all elements on the left are lesser
			if (nums[mid] >= nums[start]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {

				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}

		}

		return index;
	}

}
