package arrays.and.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
		
	}

	static final Map<String, Integer> values;

	static {
		values = new HashMap<>();
		values.put("I", 1);
		values.put("V", 5);
		values.put("X", 10);
		values.put("L", 50);
		values.put("C", 100);
		values.put("D", 500);
		values.put("M", 1000);
		values.put("IV", 4);
		values.put("IX", 9);
		values.put("XL", 40);
		values.put("XC", 90);
		values.put("CD", 400);
		values.put("CM", 900);

	}

	public static int romanToInt(String s) {

		if (s.length() == 0)
			return 0;
		int result = 0;
		int len = s.length();

		for (int i = 0; i < len; ) {
			// We need to get the maximum
			// If it is CM or CD in the String
			// We should get CD or CM instead of C and M
			if (i < len - 1) {
				String ele = s.substring(i, i + 2);
				if (values.containsKey(ele)) {
					result += values.get(ele);
					i+=2;
					continue;
				}

			}

			// If 2 words doesn't exist
			// add the single matching word
			result += values.get(s.substring(i, i + 1));
			i++;
		}

		return result;
	}

}
