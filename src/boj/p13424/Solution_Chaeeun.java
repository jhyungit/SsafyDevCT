package boj.p13424;

// https://www.acmicpc.net/problem/13424
// BOJ 13424 비밀모임
// Time: 468 ms
// Memory: 26,992 kb
// Approach: 다익스트라를 통한 최단거리

import java.util.*;
import java.io.*;

public class Main {
	static class Edge{ 
		// 그래프 저장을 위한 Edge
		int end;
		int weight;
		
		Edge(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	
	static class State implements Comparable<State>{
		// Dijkstra를 위한 상태 class
		// 도착 노드와 현재 도달 가능한 도착 노드까지의 거리
		int end;
		int weight;
		
		State(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(State o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static final int INF = 100_000_000;
	static int N, M, K;	
	static List<Edge>[] graph;
	static int distances[][];
	static PriorityQueue<State> pq = new PriorityQueue<>();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc = 0; tc< T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		
    		// 그래프 저장을 위한 초기화
    		graph = new ArrayList[N+1];
    		for (int i = 1; i <= N; i++) {
    			graph[i] = new ArrayList<>();
			}

            // 그래프 저장
    		for (int e = 0; e < M; e++) {
    			st = new StringTokenizer(br.readLine());
    			int node1 = Integer.parseInt(st.nextToken());
        		int node2 = Integer.parseInt(st.nextToken());
        		int weight = Integer.parseInt(st.nextToken());
        		
        		graph[node1].add(new Edge(node2, weight));
        		graph[node2].add(new Edge(node1, weight));
			}
    		
    		// 다익스트라 결과 저장을 위한 초기화
    		K = Integer.parseInt(br.readLine());
    		distances = new int[K][N+1];
            
    		// 출발지 K개로부터 다익스트라 진행
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < K; j++) {
        		int start = Integer.parseInt(st.nextToken());
        		distances[j] = dijkstra(start);
			}
    		
    		// 구해진 다익스트라 결과값으로부터, 
            // 모든 이의 이동거리 합이 최단이 되는 장소 인덱스 구하기
    		int min = INF;
    		int minIndex = 0;
    		for (int i = 1; i <= N; i++) {
    			int sum = 0;
                // 이동거리의 합 구하기
    			for (int j = 0; j < K; j++) {
            		sum += distances[j][i];
    			}
                // 최단 거리와 최단 거리가 되는 인덱스 업데이트
    			if (sum < min) {
    				min = sum;
    				minIndex = i;
    			}
			}
    		sb.append(minIndex).append('\n');
    	}
    	System.out.println(sb);
    }
    
    static int[] dijkstra(int start) {
    	int [] distance = new int[N+1];
    	boolean [] visited = new boolean[N+1];
    	Arrays.fill(distance, INF);
    	pq.clear();
    	
    	distance[start] = 0;
    	pq.add(new State(start, 0));
    	
    	while(!pq.isEmpty()) {
    		State s = pq.poll();
    		int curr = s.end;

            // outdate된 정보는 건너 뜀
    		if (visited[curr]) continue;
    		
    		for (Edge e: graph[curr]) {
    			int next = e.end;
    			int weight = e.weight;
    			
    			if (distance[curr] + weight < distance[next]) {
    				distance[next] = distance[curr] + weight;
    				pq.add(new State(next, distance[next]));
    			}
    		}
    	}    	
    	return distance;
    }
}
