package boj.p13424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_Bogyeng {
	
	static final int INF = 10000000;
	
	static int N, M, K;
	static int[] friends;
	
	static ArrayList<Node>[] adjList;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[N+1];
			for (int i = 1; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Node>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				adjList[a].add(new Node(b, c));
				adjList[b].add(new Node(a, c));
			}
			
			K = Integer.parseInt(br.readLine().trim());
			friends = new int[K];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(findMinNode()).append("\n");
		}
		System.out.println(sb);
	}

	private static int findMinNode() {
		dist = new int[K][N+1];
		for (int i = 0; i < K; i++) {
			Arrays.fill(dist[i], INF);
			dijk(i);
		}
		

		int minValue = Integer.MAX_VALUE;
		int min = 0;
		for (int j = 1; j <= N; j++) {
			int value = 0;
			for (int i = 0; i < K; i++) {
				value += dist[i][j];
			}
			if (minValue > value) {
				minValue = value;
				min = j;
			}
		}
		
		return min;
	}

	private static void dijk(int k) {
		int start = friends[k];
		int[] d = dist[k];
		dist[k][start] = 0;
		
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> Integer.compare(n1.c, n2.c));
		pq.offer(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			
			for (Node node : adjList[n.v]) {
				if (visited[node.v]) continue;
				
				if (d[node.v] > d[n.v] + node.c) {
					d[node.v] = d[n.v] + node.c;
					pq.offer(new Node(node.v, d[node.v]));
				}
			}
			
			visited[n.v] = true;
		}
		
	}

	static class Node {
		int v, c;
		
		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}
