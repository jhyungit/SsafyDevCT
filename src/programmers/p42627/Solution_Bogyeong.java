package programmers.p42627;

import java.util.*;

class Solution_Bogyeong {
    public int solution(int[][] jobs) {
        // 작업 번호, 요청 시각, 소요 시간
        int[][] jobList = new int[jobs.length][3];
        for (int i = 0; i < jobs.length; i++) {
            jobList[i][0] = i;
            jobList[i][1] = jobs[i][0];
            jobList[i][2] = jobs[i][1];
        }
        
        Arrays.sort(jobList, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 작업 번호, 요청 시각, 소요 시간 (jobList 구조와 동일)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        
        int job = 0, time = 0, rtSum = 0;
        while (!pq.isEmpty() || job < jobs.length) {
            if (pq.isEmpty() && time < jobList[job][1]) {
                time = jobList[job][1];
            }
            
            while (job < jobs.length && jobList[job][1] <= time) {
                pq.offer(jobList[job++]);
            }
            
            int[] j = pq.poll();
            time += j[2];
            rtSum += time - j[1];
        }
        
        return rtSum / jobs.length;
    }
}
