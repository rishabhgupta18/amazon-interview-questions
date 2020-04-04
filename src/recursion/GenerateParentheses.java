package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder("");
        backtrack(res, s,0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder s, int open, int close, int max) {
        int len = s.length();
        if(len == 2*max) {
            res.add(s.toString());
            return;
        }
        if(open < max) {
            backtrack(res, s.append("("), open+1, close, max);
            s.setLength(len);
        }
        if(close < open) {
            backtrack(res, s.append(")"), open, close+1, max);
            s.setLength(len);
        }
    }

}
