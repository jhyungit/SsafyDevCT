package programmers.p87946;

import java.util.*;

class Solution_Bogyeong {
    private static int[][] D;
    private static int N;
    private static int K;
    
    private static boolean[] visited;
    private static int[] p;
    
    private static int max;
    
    public int solution(int k, int[][] dungeons) {
        D = dungeons;
        N = D.length;
        K = k;
        
        visited = new boolean[N];
        p = new int[N];
        
        max = 0;
        perm(0);
        return max;
    }
    
    private void perm(int cnt) {
        if (cnt == N) {
            int r = result();
            if (max < r) {
                max = r;
            }
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            p[cnt] = i;
            perm(cnt+1);
            visited[i] = false;
        }
    }
    
    private int result() {
        int cnt = 0;
        int cur = K;
        for (int i = 0; i < N; i++) {
            if (cur < D[p[i]][0]) continue;
            cur -= D[p[i]][1];
            cnt++;
        }
        return cnt;
    }
}

// 테스트 1 〉	통과 (0.02ms, 80.6MB)
// 테스트 2 〉	통과 (0.03ms, 73MB)
// 테스트 3 〉	통과 (0.08ms, 78.5MB)
// 테스트 4 〉	통과 (0.10ms, 84.2MB)
// 테스트 5 〉	통과 (0.36ms, 76.2MB)
// 테스트 6 〉	통과 (0.90ms, 80.1MB)
// 테스트 7 〉	통과 (2.98ms, 83.6MB)
// 테스트 8 〉	통과 (3.01ms, 81.3MB)
// 테스트 9 〉	통과 (0.11ms, 75.4MB)
// 테스트 10 〉	통과 (1.28ms, 72.2MB)
// 테스트 11 〉	통과 (0.03ms, 72.8MB)
// 테스트 12 〉	통과 (3.64ms, 82.9MB)
// 테스트 13 〉	통과 (4.22ms, 84.2MB)
// 테스트 14 〉	통과 (3.49ms, 79.6MB)
// 테스트 15 〉	통과 (3.43ms, 73.7MB)
// 테스트 16 〉	통과 (0.74ms, 80.8MB)
// 테스트 17 〉	통과 (3.45ms, 82.3MB)
// 테스트 18 〉	통과 (0.02ms, 75.5MB)
// 테스트 19 〉	통과 (0.08ms, 79.1MB)
