package sortingandsearching;

import java.util.Arrays;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {

		// Sorting Method
		print(kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2));
		print(kClosest(new int[][] { { 1, 3 }, { -2, 2 }, { 2, -2 } }, 2));

		// Using QUick Sort
		print(kClosestUsingQuickSort.kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2));
		print(kClosestUsingQuickSort.kClosest(new int[][] { { 1, 3 }, { -2, 2 }, { 2, -2 } }, 2));

	}

	public static int[][] kClosest(int[][] points, int K) {

		if (points.length == 0 && points[0].length == 0)
			return points;

		Arrays.sort(points, (int[] p1, int[] p2) -> {

			int sq1 = (p1[0] * p1[0]) + (p1[1] * p1[1]);
			int sq2 = (p2[0] * p2[0]) + (p2[1] * p2[1]);
			return sq1 - sq2;
		});

		int[][] result = new int[K][2];

		for (int i = 0; i < K; i++) {
			result[i][0] = points[i][0];
			result[i][1] = points[i][1];
		}
		return result;

	}

	private static void print(int[][] a) {

		for (int[] ar : a) {

			System.out.print("[" + ar[0] + "," + ar[1] + "]");
		}
		System.out.println();
	}

	static class kClosestUsingQuickSort {

		public static int[][] kClosest(int[][] points, int K) {
			if (points.length == 0 && points[0].length == 0)
				return points;

			sort(points, 0, points.length - 1, K);

			int[][] result = new int[K][2];

			for (int i = 0; i < K; i++) {
				result[i][0] = points[i][0];
				result[i][1] = points[i][1];
			}
			return result;
		}

		private static void sort(int[][] points, int start, int end, int k) {

			if (start <= end) {

				int pivot = getPivot(points, start, end, k);

				if (pivot == k) {
					return;
				}

				if (k > pivot) {
					sort(points, pivot + 1, end, k);
				} else {
					sort(points, start, pivot - 1, k);
				}

			}

		}

		private static int getPivot(int[][] points, int start, int end, int k) {

			int index = start;
			int pivot = dist(points, end);

			for (int i = start; i < end; i++) {
				if (dist(points, i) < pivot) {
					int[] tmp = points[index];
					points[index++] = points[i];
					points[i] = tmp;
				}

			}

			int[] tmp = points[index];
			points[index] = points[end];
			points[end] = tmp;
			return index;
		}

		private static int dist(int[][] points, int i) {
			return (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
		}
	}

}
