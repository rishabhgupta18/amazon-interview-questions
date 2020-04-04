package sortingandsearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
	
	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[] {1,1,1,2,2,3}, 2));
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {

		if (nums.length == 0)
			return new ArrayList<>();

		Map<Integer, Integer> numsVsCount = new HashMap<>(nums.length);

		for (int num : nums)
			numsVsCount.put(num, numsVsCount.getOrDefault(num, 0) + 1);

		Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(nums.length,
				(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> {
					return b.getValue().compareTo(a.getValue());
				});
		q.addAll(numsVsCount.entrySet());
		List<Integer> result = new ArrayList<>(k);
		while (k > 0 && !q.isEmpty()) {
			result.add(q.poll().getKey());
			k--;
		}
		return result;
	}
}
