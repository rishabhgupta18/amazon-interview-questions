package arrays.and.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {

	public static void main(String[] args) {

		System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		if (strs.length == 0)
			return new ArrayList<>();

		// Create a map for key and List of strings
		Map<String, List<String>> anagramsPair = new HashMap<>();

		for (String s : strs) {

			char[] c = s.toCharArray();
			Arrays.sort(c);
			String _s = new String(c);
			List<String> pair = anagramsPair.getOrDefault(_s, new ArrayList<>());
			pair.add(s);
			anagramsPair.put(_s, pair);

		}

		// Our map will contain all anagrams pair
		Set<String> keys = anagramsPair.keySet();
		List<List<String>> result = new ArrayList<>(strs.length);
		for (String k : keys) {
			result.add(anagramsPair.get(k));
		}

		return result;

	}
}
