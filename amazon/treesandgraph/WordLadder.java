package treesandgraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	static class Node {
		String data;
		int level;

		public Node(String data, int level) {
			this.data = data;
			this.level = level;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", level=" + level + "]";
		}
		
		
	}

	public static void main(String[] args) {
		System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "dig", "lot", "log", "cog")));
		System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "dig", "lot", "log")));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		if(beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0)
			return 0;
		
		int len = beginWord.length();

		Map<String, List<String>> regexVsWordList = new HashMap<>();

		for (String word : wordList) {
			// dog, dig
			for (int i = 0; i < len; i++) {
				// for dog -> *og, d*g, do*
				String regex = word.substring(0, i) + "*" + word.substring(i + 1, len);
				List<String> matchedWords = regexVsWordList.getOrDefault(regex, new LinkedList<>());
				matchedWords.add(word);
				regexVsWordList.put(regex, matchedWords);
			}

		}
//		hit - *it, h*t, hi*
		Set<String> visited = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(beginWord, 1));
		visited.add(beginWord);
		while (!q.isEmpty()) {

			Node n = q.poll();
			String word = n.data;
			int level = n.level;
			// dog, dig
			for (int i = 0; i < len; i++) {
				// for dog -> *og, d*g, do*
				String regex = word.substring(0, i) + "*" + word.substring(i + 1, len);
				List<String> matchedWords = regexVsWordList.getOrDefault(regex, new LinkedList<>());
				for (String matchedWord : matchedWords) {

					if (matchedWord.equals(endWord)) {
						return level + 1;
					}
					if (!visited.contains(matchedWord)) {
						q.add(new Node(matchedWord, level + 1));
						visited.add(matchedWord);
					}

				}
			}

		}
		return 0;
	}

}
