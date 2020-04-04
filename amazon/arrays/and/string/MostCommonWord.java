package arrays.and.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	public static void main(String[] args) {
		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
		System.out.println(mostCommonWord("Bob", new String[] { "" }));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {

		if (paragraph.length() == 0)
			return "";
		// Put all banned words in set to check in O(1)
		Set<String> bannedWords = new HashSet<>(banned.length);
		bannedWords.addAll(Arrays.asList(banned));

		StringBuilder word = new StringBuilder();
		String ans = "";
		int ansFreq = 0;

		Map<String, Integer> count = new HashMap<>();
		char[] ch = paragraph.toCharArray();

		for (char c : ch) {
			// Append character until find a puntuation
			if (Character.isLetter(c)) {
				word.append(c);
			} else if (word.length() > 0) {
				String w = word.toString().toLowerCase();
				if (!bannedWords.contains(w)) {
					count.put(w, count.getOrDefault(w, 0) + 1);
					int freq = count.get(w).intValue();
					// check if this is the maximum
					if (freq > ansFreq) {
						ansFreq = freq;
						ans = w;
					}
				}
				word.setLength(0);
			}

		}
		if (word.length() > 0) {
			String w = word.toString().toLowerCase();
			if (!bannedWords.contains(w)) {
				count.put(w, count.getOrDefault(w, 0) + 1);
				int freq = count.get(w).intValue();
				// check if this is the maximum
				if (freq > ansFreq) {
					ansFreq = freq;
					ans = w;
				}
			}
		}

		return ans;
	}
}
