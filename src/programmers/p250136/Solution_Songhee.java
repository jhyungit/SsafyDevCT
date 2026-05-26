package programmers.p250136;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution_Songhee {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[][] land;
    private int[] columns;
    private int landR;
    private int landC;

    public static void main(String[] args) {
        Solution_Songhee sol = new Solution_Songhee();

        land = new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};

        int result = sol.solution(land);
    }

    public int solution(int[][] land) {
        landR = land.length;
        landC = land[0].length;
        visited = new boolean[landR][landC];
        // 각 컬럼별로 석유량 저장
        columns = new int[landC];

        for (int i = 0; i < landR; i++) {
            for (int j = 0; j < landC; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        int answer = 0;

        for (int n : columns) {
            if (n > answer) {
                answer = n;
            }
        }
        return answer;
    }

    private void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        int oil = 0;
        Set<Integer> cols = new HashSet<>(); // 컬럼
        cols.add(c);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            oil++;

            int x = cur[0];
            int y = cur[1];
            cols.add(y);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < landR && ny >= 0 && ny < landC) {
                    if (land[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        for (int col : cols) {
            columns[col] += oil;
        }
    }
}
