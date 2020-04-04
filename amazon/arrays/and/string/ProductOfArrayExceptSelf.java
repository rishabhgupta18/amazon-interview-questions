package arrays.and.string;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
	}

	public static int[] productExceptSelf(int[] nums) {

		if (nums.length == 0)
			return nums;

		int[] output = new int[nums.length];
		output[0] = 1;

		// go from left
		// multiply and store in output array
		for (int i = 1; i < nums.length; i++) {
			output[i] = output[i - 1] * nums[i - 1];
		}

		
		int right = 1;
		//Go from right to 0
		for (int i = nums.length - 1; i >= 0; i--) {

			output[i] = output[i] * right;
			right *= nums[i];

		}

		return output;
	}

}
