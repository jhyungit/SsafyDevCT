// https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=java

// 유형    : DFS/BFS
// 자료구조: ArrayDeque
// 종료조건: 못 바꾸거나 target일 때
// 무엇이 노드인가: 단어
// 무엇이 간선인가: 다른 글자가 정확히 1개 일 때, diff(a,b) == 1
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        answer = dfs(begin, target, words);
        return answer;
    }
    
    private int dfs(String begin, String target, String[] words){
        Deque<int[]> dq = new ArrayDeque<>();
        int n = words.length;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i <  n; i++){
            if(diff(begin,words[i]) == 1){
                dq.offer(new int[]{i, 1});
                visited[i] = true;
            }
        }

        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int idx = cur[0];
            int cnt = cur[1];
            
            if(words[idx].equals(target)) return cnt;
            
            for(int i = 0; i < n; i++){
                if(!visited[i] && diff(words[idx], words[i]) == 1){
                    dq.offer(new int[]{i, cnt+1});
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    private int diff(String cur, String word){
        int cnt = 0;
        for(int i = 0; i < cur.length(); i++){
            if(cnt > 1) return -1;
            if(cur.charAt(i) == word.charAt(i)) continue;
            cnt += 1;
        }
        return cnt;
    }
}

// 채점을 시작합니다.
// 정확성  테스트
// 테스트 1 〉	통과 (0.02ms, 73.1MB)
// 테스트 2 〉	통과 (0.07ms, 72.8MB)
// 테스트 3 〉	통과 (0.10ms, 83.1MB)
// 테스트 4 〉	통과 (0.03ms, 73.7MB)
// 테스트 5 〉	통과 (0.03ms, 78.6MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
