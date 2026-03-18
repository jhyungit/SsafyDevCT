package programmers.p92344;

public class Solution_Bogyeong {
	
	static int[][] diff;
	
	public int solution(int[][] board, int[][] skill) {
		int N = board.length;
        int M = board[0].length;
        
        diff = new int[N+1][M+1];
        for (int i = 0; i < skill.length; i++) {
        	int r1 = skill[i][1], c1 = skill[i][2];
        	int r2 = skill[i][3], c2 = skill[i][4];
        	int degree = skill[i][5];
			if (skill[i][0] == 1) {
				degree = -degree;
			}
			diff[r1][c1] += degree;
			diff[r2+1][c2+1] += degree;
			diff[r1][c2+1] -= degree;
			diff[r2+1][c1] -= degree;
		}
        
        for (int i = 0; i < N; i++) {
			for (int j = 1; j < M; j++) {
				diff[i][j] += diff[i][j-1];
			}
		}
        
        for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				diff[i][j] += diff[i-1][j];
			}
		}
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] + diff[i][j] > 0) {
					answer++;
				}
			}
		}
        
        return answer;
    }
}
