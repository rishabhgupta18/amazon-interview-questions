package arrays.and.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {

		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum(new int[] { -2, 0, 0, 2, 2 }));

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums.length == 0)
			return result;

		// Sort the array to reduce
		// Duplicates overhead
		// And ease of calculating 2 sum
		Arrays.sort(nums);

		// Three sum so len - 2
		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1;
			int right = nums.length - 1;
			int target = 0 - nums[i];

			// If ith element is equal to previous element
			// already processed continue
			// Duplicate case
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

				while (left < right) {

					if (nums[left] + nums[right] == target) {
						List<Integer> t = Arrays.asList(nums[i], nums[left], nums[right]);
						result.add(t);
						// increment left until it is different
						while (left < right && nums[left] == nums[left + 1])
							left++;

						// decrement right until it is different
						while (left < right && nums[right] == nums[right - 1])
							right--;

						left++;
						right--;

					} else
					// If total sum is lesser, then we have to try next larger value
					if (nums[left] + nums[right] < target) {
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
