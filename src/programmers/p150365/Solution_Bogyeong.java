package programmers.p150365;

class Solution_Bogyeong {
    static final char[] dchar = {'d', 'l', 'r', 'u'};
    static final int[] dr = {1, 0, 0,-1};
    static final int[] dc = {0,-1, 1, 0};
    
    static int N, M;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder answer = new StringBuilder();
        N = n;
        M = m;
        
        if (dfs(new boolean[n][m][k], 0, x-1, y-1, r-1, c-1, answer)) {
            return answer.reverse().toString();
        }
        
        return "impossible";
    }
    
    private boolean dfs(boolean[][][] visited, int cnt, int x, int y, int r, int c, StringBuilder answer) {        
        if (cnt == visited[0][0].length) {
            if (x == r && y == c) {
                return true;
            }
            return false;
        }
        
        for (int d = 0; d < dr.length; d++) {
            int nr = x + dr[d];
            int nc = y + dc[d];
            
            if (!check(nr, nc)) continue;
            if (visited[nr][nc][cnt]) continue;
            if (dfs(visited, cnt+1, nr, nc, r, c, answer)) {
                answer.append(dchar[d]);
                return true;
            }
            visited[nr][nc][cnt] = true;
        }
        
        return false;
    }
    
    private boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
