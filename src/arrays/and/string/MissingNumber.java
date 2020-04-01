package arrays.and.string;

public class MissingNumber {
	
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
		System.out.println(missingNumber(new int[] {3,0,1}));
	}

	public static int missingNumber(int[] nums) {

		int n = nums.length;
		int sum = 0;
		int totalSum = 0;

		// sum of n numbers
		// Sum in nums
		for (int i = 1; i <= n; i++) {
			totalSum += i;
			sum += nums[i - 1];

		}

		return totalSum - sum;
	}
}
