package boj.p14438;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Bogyeong {
	
	static int N;
	static int[] nums;
	static int[] seg;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		nums = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		seg = new int[4*N];
		build(1, 1, N);
		
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				update(1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} else {
				sb.append(
					query(1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))
				).append("\n");
			}
		}
		System.out.print(sb);
	}

	private static int build(int node, int start, int end) {
		if (start == end) {
			return seg[node] = nums[start];
		}
		
		int mid = (start + end) / 2;
		return seg[node] = Math.min(build(node*2, start, mid), build(node*2+1, mid+1, end));
	}

	private static int update(int node, int start, int end, int idx, int value) {
		if (start == end && idx == start) {
			return seg[node] = value;
		}
		
		if (start > idx || end < idx) {
			return seg[node];
		}
		
		int mid = (start + end) / 2;
		return seg[node] = Math.min(update(node*2, start, mid, idx, value), update(node*2+1, mid+1, end, idx, value));
	}

	private static int query(int node, int start, int end, int left, int right) {
		if (end < left || right < start) {
			return Integer.MAX_VALUE;
		}
		
		if (start >= left && right >= end) {
			return seg[node];
		}
		
		int mid = (start + end) / 2;
		return Math.min(query(node*2, start, mid, left, right), query(node*2+1, mid+1, end, left, right));
	}

}
