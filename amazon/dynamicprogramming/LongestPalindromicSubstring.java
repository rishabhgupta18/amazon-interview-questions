package dynamicprogramming;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("bb"));
		System.out.println(longestPalindrome("aba"));
	}

	public static String longestPalindrome(String s) {

		int len = s.length();
		if (len == 0)
			return "";
		boolean[][] subsolution = new boolean[len][len];

		for (int i = 0; i < len; i++)
			subsolution[i][i] = true;

		int level = 2;
		int[] max = new int[2];
		while (level <= len) {

			for (int i = 0; i < len - level + 1; i++) {

				int j = i + level - 1;
				if (s.charAt(i) == s.charAt(j)) {
					boolean isPalindrome = true;
					if (j - i > 1) {
						isPalindrome = subsolution[i + 1][j -1];
					}

					if (isPalindrome) {
						if ((j - i + 1) > (max[1] - max[0] + 1)) {
							max[0] = i;
							max[1] = j;
						}
						subsolution[i][j] = true;
					}
				}
			}
			level++;
		}

		return s.substring(max[0], max[1] + 1);

	}

	private static void print(boolean[][] a) {

		for (boolean[] ar : a) {

			for (boolean arr : ar) {
				System.out.print(arr + "\t");
			}
			System.out.println();
		}
	}

}
