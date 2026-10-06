// https://school.programmers.co.kr/learn/courses/30/lessons/42627?language=java

import java.util.*;

class Solution {
    public int solution(int[][] jobs) { // 요청시각, 소요시간
        int answer = 0;
        
        // 요청시각 오름차순 정렬
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0],b[0]));
        
        // pq: 소요시간, 요청 시각, 작업 번호 - 작은 순(오름차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        
        int now = 0;
        int finished = 0;
        int idx = 0;
        while (finished < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= now){
                pq.offer(new int[]{jobs[idx][1], jobs[idx][0], idx}); // 소요시간, 요청 시각, 작업 번호
                idx++;
            }
            if(!pq.isEmpty()){
                int[] cur = pq.poll();
                now += cur[0];
                answer += now - cur[1];
                finished++;
            }else{
                now = jobs[idx][0];
            }
        }
        return answer / jobs.length;
    }
}

// 채점을 시작합니다.
// 정확성  테스트
// 테스트 1 〉	통과 (4.76ms, 80.8MB)
// 테스트 2 〉	통과 (3.23ms, 89.3MB)
// 테스트 3 〉	통과 (3.94ms, 88.7MB)
// 테스트 4 〉	통과 (2.96ms, 81.9MB)
// 테스트 5 〉	통과 (2.27ms, 72.9MB)
// 테스트 6 〉	통과 (1.04ms, 74.7MB)
// 테스트 7 〉	통과 (2.69ms, 82.9MB)
// 테스트 8 〉	통과 (2.06ms, 83.9MB)
// 테스트 9 〉	통과 (1.57ms, 73.7MB)
// 테스트 10 〉	통과 (2.14ms, 83.1MB)
// 테스트 11 〉	통과 (1.14ms, 76.5MB)
// 테스트 12 〉	통과 (2.24ms, 82.4MB)
// 테스트 13 〉	통과 (0.98ms, 80.5MB)
// 테스트 14 〉	통과 (2.60ms, 86.5MB)
// 테스트 15 〉	통과 (1.76ms, 80.9MB)
// 테스트 16 〉	통과 (0.91ms, 72.6MB)
// 테스트 17 〉	통과 (0.90ms, 74MB)
// 테스트 18 〉	통과 (1.11ms, 80.5MB)
// 테스트 19 〉	통과 (0.93ms, 74.2MB)
// 테스트 20 〉	통과 (1.46ms, 73.9MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
