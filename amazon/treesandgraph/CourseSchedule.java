package treesandgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

	public static void main(String[] args) {
		System.out.println(canFinish(4, new int[][] { { 1, 0 }, { 0, 3 }, { 2, 3 }, { 0, 2 } }));
		System.out.println(canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}

	static class Node {
		int data;
		int indegrees;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", indegrees=" + indegrees + "]";
		}
		
		
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0)
			return true;
		List<Node> courses = new ArrayList<>(numCourses);
		for (int i = 0; i < numCourses; i++)
			courses.add(new Node(i));
		Map<Integer, Set<Node>> graph = getDependenciesGraph(numCourses, prerequisites, courses);
		Queue<Node> q = new LinkedList<>();
		int processed = 0;
		for (Node c : courses) {
			if (c.indegrees == 0) {
				q.add(c);
			}
		}
		while (!q.isEmpty()) {
			Node c = q.poll();
			Set<Node> outDegress = graph.get(c.data);
			if(outDegress != null) {
				for (Node n : outDegress) {
					n.indegrees--;
					if (n.indegrees == 0)
						q.add(n);

				}
			}
				
			processed++;
		}

		return processed == numCourses;
	}

	private static Map<Integer, Set<Node>> getDependenciesGraph(int numCourses, int[][] prerequisites,
			List<Node> courses) {

		// Node vs Outdegrees
		Map<Integer, Set<Node>> courseVsDependencies = new HashMap<>();

		for (int[] p : prerequisites) {

			if (p.length != 0) {
				Node t1 = courses.get(p[0]);
				t1.indegrees++;
				Node t2 = courses.get(p[1]);
				Set<Node> dep = courseVsDependencies.getOrDefault(p[1], new HashSet<>());
				dep.add(t1);
				courseVsDependencies.put(p[1], dep);
			}

		}

		return courseVsDependencies;
	}
}
