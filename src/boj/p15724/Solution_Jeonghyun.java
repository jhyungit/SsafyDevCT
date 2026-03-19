package boj.p15724;
// 주지수
//https://www.acmicpc.net/problem/15724

import java.io.*;
import java.util.*;


public class Solution_Jeonghyun{
	static int N, M, K;
	static int[][] map;
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				int n = Integer.parseInt(st.nextToken());
				map[r][c] = n;
			}	
		}
		
		// 누적합 생성
		makeMatrix();
		
		System.out.println(Arrays.deepToString(map));
		K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());  
		}
	}
	
	static void makeMatrix() {
		//가로 누적합
		for(int r = 1; r <= N; r++) {
			for(int c = 2; c <= M; c++) {
				map[r][c] += map[r][c-1];
			}	
		}
		//세로 누적합
		for(int c = 1; c <= M; c++) {
			for(int r = 2; r <= N; r++) {
				map[r][c] += map[r-1][c];
			}	
		}
	}

}
