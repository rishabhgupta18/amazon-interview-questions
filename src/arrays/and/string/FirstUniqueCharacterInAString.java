package arrays.and.string;

public class FirstUniqueCharacterInAString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}

	public static int firstUniqChar(String s) {

		if (s.length() == 0)
			return -1;

		int[] ar = new int[126];

		char[] ch = s.toCharArray();

		for (char c : ch)
			ar[c]++;

		for (int i = 0; i < ch.length; i++) {

			if (ar[ch[i]] == 1) {
				return i;
			}
		}
		return -1;
	}
}
