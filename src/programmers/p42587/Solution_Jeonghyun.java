// https://school.programmers.co.kr/learn/courses/30/lessons/42587?language=java

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority: priorities) pq.offer(priority);
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            dq.offer(i);
        }
        
        int answer = 0;
        while(!dq.isEmpty()){
            int cur = dq.poll();
            if(priorities[cur] == pq.peek()){
                pq.poll();
                answer++;
                if(cur == location) return answer;
            }else{
                dq.offer(cur);
            }
        }
        
        return answer;
    }
}

// 채점을 시작합니다.
// 정확성  테스트
// 테스트 1 〉	통과 (1.62ms, 66.4MB)
// 테스트 2 〉	통과 (1.53ms, 66.5MB)
// 테스트 3 〉	통과 (0.38ms, 75.2MB)
// 테스트 4 〉	통과 (0.45ms, 65.6MB)
// 테스트 5 〉	통과 (0.35ms, 67.8MB)
// 테스트 6 〉	통과 (0.48ms, 75.4MB)
// 테스트 7 〉	통과 (0.41ms, 66.7MB)
// 테스트 8 〉	통과 (1.30ms, 75.8MB)
// 테스트 9 〉	통과 (0.39ms, 75.9MB)
// 테스트 10 〉	통과 (1.13ms, 79.7MB)
// 테스트 11 〉	통과 (0.89ms, 65.4MB)
// 테스트 12 〉	통과 (0.33ms, 65MB)
// 테스트 13 〉	통과 (1.00ms, 65.9MB)
// 테스트 14 〉	통과 (0.31ms, 70.2MB)
// 테스트 15 〉	통과 (0.32ms, 76MB)
// 테스트 16 〉	통과 (0.40ms, 66.3MB)
// 테스트 17 〉	통과 (0.83ms, 65.4MB)
// 테스트 18 〉	통과 (0.40ms, 76.7MB)
// 테스트 19 〉	통과 (0.94ms, 69MB)
// 테스트 20 〉	통과 (0.40ms, 80.2MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
