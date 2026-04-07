package boj.p13424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 메모리 : 32852 kb
// 시간 : 362 ms
public class Solution_Songhee {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 이동거리 최소. 양방향
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 방의 개수
			int M = Integer.parseInt(st.nextToken()); // 선의 개수
			int[][] dist = new int[N+1][N+1]; // 방 1부터 시작
			
			// 무한대로 초기화
			for (int i = 1; i < N+1; i++) {
	            Arrays.fill(dist[i], INF);
	            dist[i][i] = 0; 
	        }
			
			// 간선 정보 입력
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int vex = Integer.parseInt(st.nextToken());
				
				dist[from][to] = vex;
				dist[to][from] = vex;
			}
			
			int K = Integer.parseInt(br.readLine()); // 친구 수
			int[] friends = new int[K]; // 친구들 방 위치
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < K; i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}
			
			// 플로이드 워셜은 k -> i -> j
			for (int k = 1; k < N+1; k++) { // 거쳐서 가는 곳이 제일 끝
				for (int i = 1; i < N+1; i++) {
					for (int j = 1; j < N+1; j++) {
						if(dist[i][k] != INF && dist[k][j] != INF && (dist[i][j] > dist[i][k] + dist[k][j])) {
							// i -> j 갈때 k 거쳐서 가는게 빠르면 갱신
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}
				}
			}
			
			// 친구 -> 모임 장소 거리 총합
			int room = 0; // 모임 장소 번호
			int minDist = Integer.MAX_VALUE;
			
			for (int i = 1; i < N+1; i++) {
				int total = 0; // 각 방마다 거리 총합
				
				for (int j = 0; j < K; j++) {
					total += dist[friends[j]][i];
				}
				
				if(total < minDist) {
					room = i;
					minDist = total;
				}
			}
			
			sb.append(room).append("\n"); // 모임 장소 index 출력
		}
		
		System.out.println(sb);
	}
}