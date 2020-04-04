package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("236"));
	}

	static List<String> letters;

	static {
		letters = new ArrayList<>(10);
		letters.add("");// 0
		letters.add("");// 1
		letters.add("abc");// 2
		letters.add("def");// 3
		letters.add("ghi");// 4
		letters.add("jkl");// 5
		letters.add("mno");// 6
		letters.add("pqrs");// 7
		letters.add("tuv");// 8
		letters.add("wxyz");// 9

	}

	public static List<String> letterCombinations(String digits) {

		int len = digits.length();
		if (len == 0)
			return new ArrayList<>();
		List<String> resp = new ArrayList<>();
		letterCombinations(digits.toCharArray(), 0, resp, new StringBuffer());
		return resp;

	}

	private static void letterCombinations(char[] digit, int index, List<String> resp, StringBuffer b) {

		if (index == digit.length) {
			resp.add(b.toString());
			return;
		}

		char[] ch= letters.get(digit[index] - 48).toCharArray();

		for (Character c : ch) {

			b.append(c);
			letterCombinations(digit, index + 1, resp, b);
			b.deleteCharAt(b.length() - 1);

		}

	}
}
