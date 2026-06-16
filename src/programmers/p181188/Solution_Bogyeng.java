package programmers.p181188;

import java.util.PriorityQueue;

public class Solution_Bogyeng {
    public int solution(int[][] targets) {
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((i1, i2) -> Integer.compare(i1[1], i2[1]));
    	for (int i = 0; i < targets.length; i++) {
			pq.offer(targets[i]);
		}
    	
        int answer = 0;
    	int last = 0;
    	while (!pq.isEmpty()) {
    		int[] target = pq.poll();
    		if (target[0] < last) continue;
    		answer++;
    		last = target[1];
    	}
    	
        return answer;
    }
}