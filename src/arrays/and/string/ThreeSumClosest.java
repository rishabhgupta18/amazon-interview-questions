package arrays.and.string;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
	}
	
	public static int threeSumClosest(int[] nums, int target) {

		if (nums.length == 0)
			return 0;

		// Sort the array to reduce
		// Duplicates overhead
		// And ease of calculating 2 sum
		Arrays.sort(nums);

		int result = 0;
		int difference = Integer.MAX_VALUE;

		// Three sum so len - 2
		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1;
			int right = nums.length - 1;

			// If ith element is equal to previous element
			// already processed continue
			// Duplicate case
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

				while (left < right) {

					int val = nums[i] + nums[left] + nums[right];
					if (Math.abs(target - val) < difference) {
						difference = Math.abs(target - val);
						result = val;
					}

					// If total sum is lesser, then we have to try next larger value
					if (val < target) {
						left++;
					} else {
						// If total sum is greater, then we have to try next smaller value
						right--;
					}

				}

			}

		}

		return result;
	}

}
