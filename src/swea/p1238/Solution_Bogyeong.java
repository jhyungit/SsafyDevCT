package swea.p1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_Bogyeong {
	
	static int T = 10;
	static HashMap<Integer, HashSet<Integer>> adjMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		adjMap = new HashMap<Integer, HashSet<Integer>>();
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) / 2;
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			adjMap.clear();
			for (int i = 0; i < n; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (!adjMap.containsKey(from)) {
					adjMap.put(from, new HashSet<>());
				}
				adjMap.get(from).add(to);
			}
			
			sb.append("#").append(t).append(" ").append(findLast(start)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int findLast(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		Queue<Integer> tmp = new ArrayDeque<>();
		
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		visited.put(start, true);
		
		int last = start;
		while (!q.isEmpty()) {
			tmp.clear();
			int curLast = Integer.MIN_VALUE;
			while (!q.isEmpty()) {
				int cur = q.poll();
				if (!adjMap.containsKey(cur)) continue;
				for (Integer to : adjMap.get(cur)) {
					if (visited.getOrDefault(to, false)) continue;
					tmp.offer(to);
					visited.put(to, true);
					if (curLast < to) {
						curLast = to;
					}
				}
			}
			if (curLast == Integer.MIN_VALUE) break;
			last = curLast;
			Queue<Integer> t = tmp;
			tmp = q;
			q = t;
		}
		return last;
	}

}
