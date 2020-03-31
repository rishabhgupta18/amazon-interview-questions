package arrays.and.string;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public static int maxArea(int[] height) {

		int result = 0;
		if (height.length == 0)
			return result;

		// traverse from both sidee
		int left = 0, right = height.length - 1;
		while (left < right) {

			// If left is smaller than calculate the area using left side
			// if right is smaller than calculate the area using right side
			if (height[left] < height[right]) {
				int areaLen = right - left;
				result = Math.max(areaLen * height[left], result);
				left++;
			} else {
				int areaLen = right - left;
				result = Math.max(areaLen * height[right], result);
				right--;
			}

		}
		return result;
	}
}
