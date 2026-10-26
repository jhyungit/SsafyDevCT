package programmers.p42587;

import java.util.*;

class Solution_Bogyeong {
    private static final int TARGET = -1;
    
    public int solution(int[] priorities, int location) {
        int[] importance = new int[10];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            ++importance[priorities[i]];
            if (i == location) {
                q.offer(TARGET);
            } else {
                q.offer(priorities[i]);
            }
        }
        
        int target_importance = priorities[location];
        
        int answer = 0;
        int max = 9;
        while (!q.isEmpty()) {
            int v = q.poll();
            
            int n = v == TARGET ? target_importance : v;
            
            boolean canRun = true;
            for (int i = max; i > n; i--) {
                if (importance[i] == 0) {
                    max = i-1;
                    continue;
                }
                canRun = false;
                break;
            }
            
            
            if (canRun) {
                ++answer;
                --importance[n];
                if (v == TARGET) {
                    return answer;
                }
            } else {
                q.offer(v);
            }
        }
        
        return answer;
    }
}

// 테스트 1 〉	통과 (0.20ms, 64.6MB)
// 테스트 2 〉	통과 (0.45ms, 63.4MB)
// 테스트 3 〉	통과 (0.06ms, 88.2MB)
// 테스트 4 〉	통과 (0.14ms, 63.6MB)
// 테스트 5 〉	통과 (0.02ms, 85.1MB)
// 테스트 6 〉	통과 (0.13ms, 64.7MB)
// 테스트 7 〉	통과 (0.13ms, 82.4MB)
// 테스트 8 〉	통과 (0.35ms, 65.7MB)
// 테스트 9 〉	통과 (0.05ms, 77.7MB)
// 테스트 10 〉	통과 (0.14ms, 83.3MB)
// 테스트 11 〉	통과 (0.46ms, 67.5MB)
// 테스트 12 〉	통과 (0.18ms, 63.8MB)
// 테스트 13 〉	통과 (0.82ms, 64MB)
// 테스트 14 〉	통과 (0.03ms, 65MB)
// 테스트 15 〉	통과 (0.07ms, 66.2MB)
// 테스트 16 〉	통과 (0.08ms, 67.5MB)
// 테스트 17 〉	통과 (0.25ms, 67.2MB)
// 테스트 18 〉	통과 (0.04ms, 63.7MB)
// 테스트 19 〉	통과 (0.36ms, 66.8MB)
// 테스트 20 〉	통과 (0.14ms, 65.1MB)
