package programmers.p250136;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Solution_Bogyeong {
	// 석유 덩어리 번호, 석유 덩어리 크기
	private HashMap<Integer, Integer> oilSize = new HashMap<>();
	
	public int solution(int[][] land) {
		init(land);
        
        return maxVertical(land);
    }

	private void init(int[][] land) {
		int k = 1;
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				if (land[i][j] == 1) {
					int cnt = floodFill(i, j, ++k, land);
					oilSize.put(k, cnt);
				}
			}
		}
	}

	private static int[] dr = {0, 1, 0,-1};
	private static int[] dc = {1, 0,-1, 0};
	private Queue<Integer> q = new ArrayDeque<>();
	private int floodFill(int i, int j, int fillNum, int[][] land) {
		q.clear();
		
		int cnt = 1;
		q.add(i*land[0].length+j);
		land[i][j] = fillNum;
		
		while (!q.isEmpty()) {
			int n = q.poll();
			int r = n / land[0].length;
			int c = n % land[0].length;
			
			for (int d = 0; d < dr.length; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc, land)) continue;
				if (land[nr][nc] != 1) continue;
				++cnt;
				q.offer(nr*land[0].length+nc);
				land[nr][nc] = fillNum;
			}
		}
		
		return cnt;
	}

	private boolean check(int r, int c, int[][] land) {
		return r >= 0 && r < land.length && c >= 0 && c < land[0].length;
	}

	private int maxVertical(int[][] land) {
		int max = 0;
		for (int j = 0; j < land[0].length; j++) {
			int sum = 0;
			boolean[] selected = new boolean[oilSize.size()+2];
			for (int i = 0; i < land.length; i++) {
				if (land[i][j] != 0 && !selected[land[i][j]]) {
					sum += oilSize.get(land[i][j]);
                    selected[land[i][j]] = true;
				}
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
}
