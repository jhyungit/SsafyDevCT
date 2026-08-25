//https://school.programmers.co.kr/learn/courses/30/lessons/1832?language=java
//500×500이면 순수 격자 경로 수만 C(998, 499) -> DP

// 0: free
// 1: x
// 2: 이전에 온 방향으로 직진만 가능
// m: row, n: col



class Solution {
    static int MOD = 20170805;
    static int[][] R; // 오른쪽
    static int[][] D; // 아래로
        
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        R = new int[m][n];
        D = new int[m][n];
        
        // 시작
        R[0][0] = 1;
        
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0) continue; // 초기값 보존
                if(cityMap[row][col] == 1) continue; // 못 가는 길
                
                // R(오른쪽) 계산
                if(col > 0){
                    if(cityMap[row][col-1] == 2){ // 직진만 가능
                        R[row][col] = R[row][col-1];
                    }else{
                        R[row][col] = (R[row][col-1] + D[row][col-1]) % MOD;
                    }
                }
                
                // D(아래로) 계산
                if(row > 0){
                    if(cityMap[row-1][col] == 2){ // 직진만 가능
                        D[row][col] = D[row-1][col];
                    }else{
                        D[row][col] = (R[row-1][col] + D[row-1][col]) % MOD;
                    }
                }
            }
        }
        
        answer = (R[m-1][n-1] + D[m-1][n-1]) % MOD;
        return answer;
    }
}

// 채점을 시작합니다.
// 정확성  테스트
// 테스트 1 〉	통과 (37.85ms, 114MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
