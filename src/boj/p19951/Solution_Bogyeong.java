package boj.p19951;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Bogyeong {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] map = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] delta = new int[N+2];
		delta[1] = map[1];
		for (int i = 2; i <= N; i++) {
			delta[i] = map[i] - map[i-1];
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			delta[start] += k;
			delta[end+1] -= k;
		}
		
		StringBuilder sb = new StringBuilder();
		int result = 0;
		for (int i = 1; i <= N; i++) {
			result += delta[i];
			sb.append(result).append(" ");
		}
		System.out.println(sb);
	}

}
