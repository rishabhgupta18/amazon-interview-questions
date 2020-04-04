package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
		System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		Trie t = new Trie();
		t.addAll(wordDict);
		return t.canSplit(s);

	}

	static class Trie {

		static class Node {
			char c;
			Map<Character, Node> childs;
			boolean isEnd;

			public Node(char c) {
				this.c = c;
				this.childs = new HashMap<>(26);
			}

		}

		Node root;

		public Trie() {
			root = new Node('\0');
		}

		public void addAll(List<String> s) {

			for (String _s : s)
				add(_s);
		}

		public void add(String s) {

			Node cur = root;

			for (char c : s.toCharArray()) {

				Node t = cur.childs.get(c);
				if (t == null) {
					t = new Node(c);
					cur.childs.put(c, t);
				}

				cur = t;

			}
			cur.isEnd = true;
		}

		// returns all matching sequence from begin index
		// for a string - catsanddog and beginIndex = 0
		// returns [cat, cats]
		public Set<String> subSequence(char[] c, int beginIndex) {

			Set<String> words = new HashSet<>(c.length);
			StringBuffer b = new StringBuffer();
			Node current = root;

			for (int i = beginIndex; i < c.length; i++) {
				Node n = current.childs.get(c[i]);
				if (n == null)
					break;
				b.append(n.c);
				if (n.isEnd) {
					words.add(b.toString());
				}
				current = n;
			}
			return words;
		}

		public boolean canSplit(String s) {
			// if false, we iterate
			// if true, means we already visited and no solution found
			boolean[] isVisited = new boolean[s.length()];
			return split(s.toCharArray(), 0, isVisited);
		}

		// O(n2) in worst case
		private boolean split(char[] ch, int i, boolean[] isVisited) {

			if (ch.length == 0 || i >= ch.length) {
				if (i == ch.length) {
					return true;
				}

				return false;
			}
			if (isVisited[i])
				return false;

			Set<String> words = subSequence(ch, i);
			for (String s : words) {
				boolean found = split(ch, i + s.length(), isVisited);
				if (found)
					return true;
				isVisited[i] = true;
			}
			return false;
		}

	}

}
