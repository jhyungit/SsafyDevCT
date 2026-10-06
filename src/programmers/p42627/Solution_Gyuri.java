import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시점 기준 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 작업 소요 시간 기준으로 정렬된 pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int totalTime = 0;
        int curTime = 0; // 현재 시간
        int done = 0;
        int idx = 0;
        while (done < jobs.length) {
            
            // 현재 시간까지 요청된 작업들을 pq에 추가
            while (idx < jobs.length && jobs[idx][0] <= curTime) {
                pq.add(jobs[idx]);
                ++idx;
            }

            if (!pq.isEmpty()) {
                // 큐가 남아있음 -> 소요 시간이 가장 짧은걸 수행
                int[] j = pq.poll();
                curTime += j[1];
                totalTime += (curTime - j[0]);
                ++done;
            } else {
                // 큐가 비어있음 -> 다음 작업의 요청 시점으로 현재 시간 이동
                curTime = jobs[idx][0];
            }
        }
        
        return totalTime / jobs.length;
    }
}