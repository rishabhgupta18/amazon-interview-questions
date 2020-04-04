package recursion;

public class WordSearch {

	public static void main(String[] args) {

		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		System.out.println(exist(board, "ABCCED"));
		board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "SEE"));
		board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCB"));
	}

	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					board[i][j] = '#';
					if (solve(board, word, 0 + 1, i, j)) {
						return true;
					}
					board[i][j] = word.charAt(0);
				}
			}
		}
		return false;
	}

	public static boolean solve(char[][] board, String word, int index, int i, int j) {
		if (index >= word.length())
			return true;
		if (i - 1 > -1 && board[i - 1][j] != '#' && board[i - 1][j] == word.charAt(index)) {
			board[i - 1][j] = '#';
			if (solve(board, word, index + 1, i - 1, j))
				return true;
			board[i - 1][j] = word.charAt(index);
		}
		if (i + 1 < board.length && board[i + 1][j] != '#' && board[i + 1][j] == word.charAt(index)) {
			board[i + 1][j] = '#';
			if (solve(board, word, index + 1, i + 1, j))
				return true;
			board[i + 1][j] = word.charAt(index);

		}
		if (j - 1 > -1 && board[i][j - 1] != '#' && board[i][j - 1] == word.charAt(index)) {
			board[i][j - 1] = '#';
			if (solve(board, word, index + 1, i, j - 1))
				return true;
			board[i][j - 1] = word.charAt(index);
		}
		if (j + 1 < board[0].length && board[i][j + 1] != '#' && board[i][j + 1] == word.charAt(index)) {
			board[i][j + 1] = '#';
			if (solve(board, word, index + 1, i, j + 1))
				return true;
			board[i][j + 1] = word.charAt(index);
		}
		return false;
	}
}
