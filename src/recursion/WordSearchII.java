package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		System.out.println(findWords(board, new String[] { "oath", "pea", "eat", "rain" }));
	}

	static class Node {

		char data;
		Map<Character, Node> childs;
		String word;

		public Node(char data) {
			this.data = data;
			this.childs = new HashMap<>(26);
		}

		@Override
		public String toString() {
			return "{" + data + "}";
		}

	}

	public static List<String> findWords(char[][] board, String[] words) {
		Node root = buildTrie(words);
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				searchWord(board, i, j, root, res);

		return res;
	}

	private static void searchWord(char[][] board, int i, int j, Node root, List<String> res) {

		char ch = board[i][j];

		if (ch == '#' || !root.childs.containsKey(ch))
			return;

		Node t = root.childs.get(ch);
		if (t.word != null) {
			res.add(t.word);
			t.word = null;
		}

		board[i][j] = '#';

		if (i > 0) {
			searchWord(board, i - 1, j, t, res);
		}

		if (j > 0) {
			searchWord(board, i, j - 1, t, res);
		}

		if (i < board.length - 1) {
			searchWord(board, i + 1, j, t, res);
		}

		if (j < board[0].length - 1) {
			searchWord(board, i, j + 1, t, res);
		}

		board[i][j] = ch;
	}

	private static Node buildTrie(String[] words) {

		Node root = new Node('\0');

		for (String word : words) {
			Node cur = root;
			for (char c : word.toCharArray()) {
				Node t = cur.childs.get(c);
				if (t == null) {
					t = new Node(c);
					cur.childs.put(c, t);
				}
				cur = t;
			}
			cur.word = word;
		}
		return root;
	}

}
