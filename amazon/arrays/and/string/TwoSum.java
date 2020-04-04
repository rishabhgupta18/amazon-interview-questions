package arrays.and.string;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] result = twoSum(new int[] { 2, 7, 11, 15 }, 9);
		for (int r : result) {
			System.out.print(r + " ");
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		//map to store the integer with index
		//In case we find any match, we need to return the index
		Map<Integer, Integer> integerVsIndex = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int val = target - nums[i];
			//Check if value exists in map
			//Then we found the pair
			if (integerVsIndex.containsKey(val)) {
				result[0] = integerVsIndex.get(val);
				result[1] = i;
				break;
			}
			//Insert in map the value in num along with index
			integerVsIndex.put(nums[i], i);
		}

		return result;
	}

}
