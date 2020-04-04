package sortingandsearching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeInterface {

	public static void main(String[] args) {
		print(merge(new int[][] { { 1, 3 }, { 8, 10 }, { 15, 18 }, { 2, 6 } }));
	}

	public static int[][] merge(int[][] intervals) {

		if (intervals.length == 0 || intervals[0].length == 0)
			return intervals;

		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
		List<int[]> result = new LinkedList<>();
		result.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {

			int[] respLast = result.get(result.size() - 1);
			
			if(respLast[1] < intervals[i][0])
				result.add(intervals[i]);
			else if(respLast[1] < intervals[i][1])
				respLast[1] = intervals[i][1];
		}

		  int[][] res = new int[result.size()][];
	      int index = 0;
	      for(int[] r: result) {
	        res[index++] = r;
	      }
		return result.toArray(new int[result.size()][2]);
	}

	private static void print(int[][] a) {

		for (int[] ar : a) {

			System.out.print("[" + ar[0] + "," + ar[1] + "]");
		}
		System.out.println();
	}

}
