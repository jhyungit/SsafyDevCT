package programmers.p92344;

class Solution_Chaeeun {
    int N, M;
    int[][] diff, board;
        
    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        this.board = board;
        
        diff = new int[N+1][M+1];
            
        for(int[] line : skill){
            update(line);
        }
        
        calcPrefix();
        
        int answer = countRemain();
        
        return answer;
    }
    
    void update(int[] line){
        int degree = line[5];
        int r1 = line[1], c1 = line[2], r2 = line[3], c2 = line[4];
        if (line[0] == 1){
            degree = -degree;
        }
        diff[r1][c1] += degree;
        diff[r1][c2 + 1] -= degree;
        diff[r2 + 1][c1] -= degree;
        diff[r2 + 1][c2 + 1] += degree;        
    }
    
    void calcPrefix(){
        for (int c = 0; c < M; c++){
            for (int r = 1; r < N; r++){
                diff[r][c] += diff[r-1][c];
            }
        }

        for (int r = 0; r < N; r++){
            for (int c = 1; c < M; c++){
                diff[r][c] += diff[r][c-1];
            }
        }
    }
    
    int countRemain(){
        int ans = 0;
         for (int r = 0; r < N; r++){
            for (int c = 0; c < M; c++){
                if (board[r][c] + diff[r][c] > 0 ){
                    ++ans;
                }
            }
         }
        return ans;
    }
}

/* 
정확성  테스트
테스트 1 〉	통과 (0.02ms, 73.4MB)
테스트 2 〉	통과 (0.03ms, 74.8MB)
테스트 3 〉	통과 (0.08ms, 86.9MB)
테스트 4 〉	통과 (0.13ms, 72.8MB)
테스트 5 〉	통과 (0.16ms, 85.6MB)
테스트 6 〉	통과 (0.22ms, 74.4MB)
테스트 7 〉	통과 (0.28ms, 70.4MB)
테스트 8 〉	통과 (0.44ms, 83.2MB)
테스트 9 〉	통과 (0.80ms, 80.1MB)
테스트 10 〉	통과 (1.15ms, 88.1MB)

효율성  테스트
테스트 1 〉	통과 (49.96ms, 212MB)
테스트 2 〉	통과 (40.59ms, 207MB)
테스트 3 〉	통과 (48.80ms, 211MB)
테스트 4 〉	통과 (41.55ms, 211MB)
테스트 5 〉	통과 (40.22ms, 219MB)
테스트 6 〉	통과 (47.98ms, 218MB)
테스트 7 〉	통과 (41.20ms, 216MB)
*/
