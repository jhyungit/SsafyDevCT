package swea.p3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_Bogyeong {

	static final int MOD_NUM = 20171109;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			
			// minValue에 1개 더 넣어서, minValue 중 가장 큰 값을 기준으로 볼 것
			PriorityQueue<Integer> minValue = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> maxValue = new PriorityQueue<>();
			
			result = 0;
			minValue.offer(first);
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					minValue.offer(Integer.parseInt(st.nextToken()));
				}
				maxValue.offer(minValue.poll());
				
				if (maxValue.peek() < minValue.peek()) {
					maxValue.offer(minValue.poll());
					minValue.offer(maxValue.poll());
				}
				
				result += minValue.peek();
				if (result >= MOD_NUM) {
					result %= MOD_NUM;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

}
