package programmers.p92344;

public class Solution_Songhee {
    public int solution(int[][] board, int[][] skill) {
        // board : 건물 내구도
        // skill : 공격/회복 [type, r1, c1, r2, c2, degree]
        int N = board.length;
        int M = board[0].length;
        int[][] calc = new int[N][M];

        int answer = 0; // 파괴되지 않은 건물 수

        for(int[] row : skill) {
            int type = row[0];
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];
            int degree = type == 1 ? -row[5] : row[5];

            // 시작점, 끝점에만 표시해두고 나중에 누적합 구하기
            calc[r1][c1] += degree;
            if(c2 < M-1) calc[r1][c2+1] -= degree; // 그 다음까지
            if(r2 < N-1) calc[r2+1][c1] -= degree; // 그 다음까지
            if(c2 < M-1 && r2 < N-1) calc[r2+1][c2+1] += degree; // 두번 빼짐
        }

        // calc 누적합 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(j > 0) calc[i][j] += calc[i][j-1];
                if(i > 0) calc[i][j] += calc[i-1][j];
                if(i > 0 && j > 0) calc[i][j] -= calc[i-1][j-1];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] + calc[i][j] > 0) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 1. 객체 생성
        Solution_Songhee sol = new Solution_Songhee();

        // 2. 테스트 데이터 설정 (프로그래머스 예시)
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        // 3. 결과 출력
        int result = sol.solution(board, skill);
        System.out.println("파괴되지 않은 건물 수: " + result);
    }
}