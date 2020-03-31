package arrays.and.string;

public class ImplementStrStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("mississippi", "issipi"));
		System.out.println(strStr("mississippi", "pi"));
		System.out.println(strStr(
				"abbbbbaabbaabaabbbaaaaab" + "babbbabbbbbaababaabbaabbbbbababaababbbb"
						+ "aaabbbbabaabaaaabbbbabbbaabbba" + "abbaaabaabaaaaaaaa",
				"abbbaababbbabbbabbbb" + "babaaaaaaabaabaabbbbaabab"));

	}

	public static int strStr(String haystack, String needle) {

		char[] nc = needle.toCharArray();
		if (nc.length == 0)
			return 0;

		char[] hc = haystack.toCharArray();
		if (hc.length == 0 || hc.length < nc.length)
			return -1;

		final int I = 96;
		final int PRIME = 3;
		final int modulus = 31;
		// Calcuate the first hash of haystack
		// Calculate the Hash of Needle
		// for needle ll
		// 108 * 3^0 + 108 * 3^1
		int sourceHash = 0;
		int targetHash = 0;
		for (int i = 0; i < nc.length; i++) {
			targetHash += (I - nc[i]) * Math.pow(PRIME, i);
			sourceHash += (I - hc[i]) * Math.pow(PRIME, i);
		}
		if (sourceHash == targetHash) {
			// check equality
			if (haystack.substring(0, nc.length).equals(needle)) {
				return 0;
			}
		}
		int result = -1;
		// Loop untill we find the needle
		for (int i = 1; i < hc.length - nc.length + 1; i++) {

			// since we already computed the hash of n elements
			// We need to substract i-1 and add i+1 hash
			sourceHash -= (I - hc[i - 1]);
			// We need to divide by prime
			// To balance the equation
			sourceHash /= PRIME;
			sourceHash += (I - hc[i + nc.length - 1]) * Math.pow(PRIME, nc.length - 1);

			if (sourceHash == targetHash) {

				// compare value for equality
				if (haystack.substring(i, i + nc.length).equals(needle)) {
					result = i;
					break;
				}

			}

		}

		return result;
	}

}
