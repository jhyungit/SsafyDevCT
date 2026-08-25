import java.util.*;

class Solution {
    final int MOD = 20170805;
    int[][][] count = new int[500][500][2]; // r, c, dir(1:v 0:h)
    boolean[][][] visited = new boolean[500][500][2];

    public int solution(int m, int n, int[][] cityMap) {
        Queue<int[]> q = new ArrayDeque<>();

        // init
        count[0][0][0] = 1;
        visited[0][0][0] = true;
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int d = cur[2];

            // 오른쪽으로 이동 가능한 경우
            if (cityMap[y][x] == 0 || (cityMap[y][x] == 2 && d == 0)) {
                int ny = y;
                int nx = x + 1;

                if (nx < n && cityMap[ny][nx] != 1) { // 통행 가능하면
                    count[ny][nx][0] = (count[ny][nx][0] + count[y][x][d]) % MOD;
                    
                    if (!visited[ny][nx][0]) {
                        visited[ny][nx][0] = true;
                        q.add(new int[]{ny, nx, 0});
                    }
                }
            }

            // 아래쪽으로 이동 가능한 경우
            if (cityMap[y][x] == 0 || (cityMap[y][x] == 2 && d == 1)) {
                int ny = y + 1;
                int nx = x;

                if (ny < m && cityMap[ny][nx] != 1) { // 통행 가능하면
                    count[ny][nx][1] = (count[ny][nx][1] + count[y][x][d]) % MOD;
                    
                    if (!visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        q.add(new int[]{ny, nx, 1});
                    }
                }
            }
        }
        
        // v + h
        return (count[m-1][n-1][0] + count[m-1][n-1][1]) % MOD;
    }
}