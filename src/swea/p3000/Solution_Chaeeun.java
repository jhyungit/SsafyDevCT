# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV-fO0s6ARoDFAXT
# SWEA 3000 중간값 구하기
# Time: 905 ms
# Memory: 121,224 kb
# Approach: PriorityQueue를 사용한 중앙값 업데이트

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> right = new PriorityQueue<>();
	static int N, center;
  	static final int MOD = 20171109;
	
	public static void main(String args[]) throws Exception{
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			center = Integer.parseInt(st.nextToken());
			
			sb.append('#').append(t).append(' ').append(solve()).append('\n');
		}
		System.out.println(sb);		 
	}
	
	static int solve() throws Exception {
		int ans = 0;
		left.clear();
		right.clear();
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if (center >= num1 && center >= num2) {
				left.add(num1);
				left.add(num2);
				right.add(center);
				center = left.poll();
			}
			else if (center <= num1 && center <= num2) {
				right.add(num1);
				right.add(num2);
				left.add(center);
				center = right.poll();
			}
			else {
				int bigger = Math.max(num1, num2);
        int smaller = Math.min(num1, num2);
				right.add(bigger);
				left.add(smaller);
			}
			ans += center;
			ans %= MOD;
		}
		
		return ans;
	}
}
