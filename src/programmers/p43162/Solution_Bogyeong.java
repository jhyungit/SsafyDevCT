package programmers.p43162;

class Solution_Bogyeong {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, visited, computers);
            ++answer;
        }
        
        return answer;
    }
    
    private void dfs(int cur, boolean[] visited, int[][] computers) {
        for (int next = 0; next < computers[cur].length; next++) {
            if (visited[next]) continue;
            if (computers[cur][next] == 0) continue;
            visited[next] = true;
            dfs(next, visited, computers);
        }
    }
}
