package arrays.and.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abccbabb"));
		System.out.println(lengthOfLongestSubstring("tmmzuxt"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int len = s.length();
		if (len == 0)
			return 0;

		int result = 0;
		// To store the next index to start with
		// In case we find a repeating character
		Map<Character, Integer> charVsIndex = new HashMap<>();
		char[] ch = s.toCharArray();
		
		int from = 0 ;
		for (int to = 0; to < len; to++) {
			
			char c = ch[to];
			//check for repeating character
			if(charVsIndex.containsKey(c)) {
				// Get next Index
				int nextIndex = charVsIndex.get(c);
				//check if our 'from' is  already ahead of the index
				from = Math.max(nextIndex, from);
			}
			//Get max result
			result = Math.max(to - from + 1, result);
			//store the next index
			//in case we found a repeating character
			//we can start from here
			charVsIndex.put(c, to+1);
			
		}

		return result;
	}
}
