package swea.p3000;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_Songhee {
	public static final int DIVIDE_NUM = 20171109;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("sample_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // n번에 걸쳐 자연수 2개
			int a = Integer.parseInt(st.nextToken()); // 처음에 쓴 자연수
			
			int sum = 0;
			
			PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder()); // 제일 큰 숫자가 앞에
			PriorityQueue<Integer> high = new PriorityQueue<>(); // 제일 작은 숫자가 앞에
			
			low.add(a);
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int mid_num = low.peek();
				
				for (int j = 0; j < 2; j++) {
					int x = Integer.parseInt(st.nextToken());
					
					if(x > mid_num) {
						high.add(x);
					} else {
						low.add(x);
					}
				}
				
				while(low.size() - high.size() != 1) {
					if(low.size() > high.size()) {
						high.add(low.poll());
					} else {
						low.add(high.poll());
					}
				}
				
				sum = (sum + low.peek() % DIVIDE_NUM) % DIVIDE_NUM;
			}
			
			System.out.println("#" + (t+1) + " " + sum);
		}
	}

}
