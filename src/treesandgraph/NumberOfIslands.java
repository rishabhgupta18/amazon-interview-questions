package treesandgraph;

public class NumberOfIslands {

	public static void main(String[] args) {
//		System.out.println(numIslands(
//				new char[][] { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }));
		
		System.out.println(numIslands(
				new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }
				, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
		
		
	}

	public static int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int counter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] != '0') {
					counter++;
					collectAndRemoveIslands(grid, i, j);
				}

			}

		}
		return counter;
	}

	private static void collectAndRemoveIslands(char[][] grid, int i, int j) {

		if (!validate(grid, i, j))
			return;

		grid[i][j] = '0';

		// check left
		if (validate(grid, i, j - 1))
			collectAndRemoveIslands(grid, i, j - 1);

		// check right
		if (validate(grid, i, j + 1))
			collectAndRemoveIslands(grid, i, j + 1);

		// check up
		if (validate(grid, i - 1, j))
			collectAndRemoveIslands(grid, i - 1, j);

		// check down
		if (validate(grid, i + 1, j))
			collectAndRemoveIslands(grid, i + 1, j);


	}

	private static boolean validate(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
			return false;

		if (grid[i][j] == '0')
			return false;
		return true;
	}

}
