package arrays.and.string;

public class TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 5,2,1,2,1,5}));
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap(new int[] { 4, 2, 3 }));
	}

	public static int trap(int[] height) {

		int result = 0;
		if (height.length == 0)
			return result;

		// traverse from both sidee
		int left = 0, right = height.length - 1;
		int leftMax = 0, rightMax = height.length - 1;
		while (left < right) {

			if (height[left] < height[right]) {

				if (height[left] < height[leftMax]) {
					result += height[leftMax] - height[left];
				} else {
					leftMax = left;
				}
				left++;

			} else {

				if (height[right] < height[rightMax]) {
					result += height[rightMax] - height[right];
				} else {
					rightMax = right;
				}
				right--;

			}

		}
		return result;
	}

}
