package sortingandsearching;

import java.util.Arrays;

public class MeetingRoomsII {

	public static void main(String[] args) {
		System.out.println(minMeetingRooms(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
	}

	public static int minMeetingRooms(int[][] intervals) {

		if (intervals.length == 0 || intervals[0].length == 0)
			return 0;

		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);

		int max = -1;
		int curOpen = 0;

		int sI = 0, sJ = 0;

		while (sI < start.length) {

			if (start[sI] < end[sJ]) {
				sI++;
				curOpen++;
				max = Math.max(curOpen, max);
			} else {
				sJ++;
				curOpen--;
			}

		}
		return max;

	}
}
