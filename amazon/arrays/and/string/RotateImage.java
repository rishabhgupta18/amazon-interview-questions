package arrays.and.string;

public class RotateImage {

	public static void main(String[] args) {

		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix1);
		print(matrix1);

		int[][] matrix2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(matrix2);
		print(matrix2);

	}

	public static void rotate(int[][] matrix) {

		if (matrix.length == 0 || matrix[0].length == 0)
			return;

		int up, left, down, right;
		int end = matrix.length - 1;

		for (int i = 0; i < matrix.length / 2; i++) {

			// initialize
			left = end;
			up = end;
			down = i;
			right = i;

			while (left > i) {

				// hold the matrix[i][i] in tmp
				int tmp = matrix[i][right];
				// move down to up
				matrix[i][right] = matrix[up][i];
				matrix[up][i] = matrix[end][left];
				matrix[end][left] = matrix[down][end];
				matrix[down][end] = tmp;
				up--;
				left--;
				down++;
				right++;

			}

			end--;

		}

	}

	public static void print(int[][] matrix) {
		for (int[] ar : matrix) {

			for (int a : ar) {
				System.out.print(a + "\t");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}
