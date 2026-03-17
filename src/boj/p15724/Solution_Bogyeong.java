package boj.p15724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Bogyeong {
	
	static int N, M, sr, sc, er, ec;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		build();
		
		int K = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			sr = Integer.parseInt(st.nextToken())-1;
			sc = Integer.parseInt(st.nextToken())-1;
			er = Integer.parseInt(st.nextToken())-1;
			ec = Integer.parseInt(st.nextToken())-1;
			
			sb.append(query()).append("\n");
		}
		
		System.out.println(sb);
	}

	private static void build() {
		for (int i = 0; i < N-1; i++) {
			map[i+1][0] += map[i][0];
		}
		
		for (int j = 0; j < M-1; j++) {
			map[0][j+1] += map[0][j];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				map[i][j] += map[i][j-1] + map[i-1][j] - map[i-1][j-1];
			}
		}
	}

	private static int query() {
		int result = map[er][ec];
		
		if (sr > 0) {
			result -= map[sr-1][ec];
		}
		
		if (sc > 0) {
			result -= map[er][sc-1];
		}
		
		if (sr > 0 && sc > 0) {
			result += map[sr-1][sc-1];
		}
		
		return result;
	}

}
