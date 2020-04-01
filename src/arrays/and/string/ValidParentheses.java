package arrays.and.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

	public static void main(String[] args) {

		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
	}

	public static boolean isValid(String s) {

		if (s.length() == 0)
			return true;
		char[] c = s.toCharArray();
		Deque<Character> stack = new ArrayDeque<>(c.length);

		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
				stack.push(c[i]);
			} else if(!stack.isEmpty()){
				if (c[i] == ')' && stack.peek() != '(')
					return false;
				else if (c[i] == '}' && stack.peek() != '{')
					return false;
				else if (c[i] == ']' && stack.peek() != '[')
					return false;

				stack.pop();
			}else {
				return false;
			}
		}
		return stack.isEmpty();

	}
}
