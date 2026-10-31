// https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java

import java.util.*;

class Solution {
    static boolean[] visited;
    static char[] selected;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int n = numbers.length();
        
        selected = new char[n];
        visited = new boolean[n];
        set = new HashSet<>();
        perm(numbers, 0, n);
        
        int answer = 0;
        for(int num : set){
            if(sosu(num)) answer++;
        }
        
        return answer;
    }
    
    private void perm(String numbers, int depth, int n){
        if(depth > 0){
            set.add(Integer.parseInt(new String(selected,0, depth)));
        }
        
        if(depth == n) return;
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = numbers.charAt(i);
            perm(numbers, depth + 1, n);
            visited[i] = false;
        }
    }
        
    private boolean sosu(int num){
        if(num == 0 || num == 1) return false;
        
        for(int i = 2; i*i <= num; i++){
            if(num%i == 0) return false;
        }
        
        return true;
    }
}

// 채점을 시작합니다.
// 정확성  테스트
// 테스트 1 〉	통과 (0.18ms, 65.6MB)
// 테스트 2 〉	통과 (1.83ms, 65.1MB)
// 테스트 3 〉	통과 (0.05ms, 65.7MB)
// 테스트 4 〉	통과 (1.88ms, 78.4MB)
// 테스트 5 〉	통과 (6.17ms, 84.4MB)
// 테스트 6 〉	통과 (0.07ms, 63.8MB)
// 테스트 7 〉	통과 (0.22ms, 76.6MB)
// 테스트 8 〉	통과 (4.09ms, 85MB)
// 테스트 9 〉	통과 (0.06ms, 69.2MB)
// 테스트 10 〉	통과 (2.60ms, 66.1MB)
// 테스트 11 〉	통과 (0.70ms, 75.3MB)
// 테스트 12 〉	통과 (0.77ms, 64.8MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0

