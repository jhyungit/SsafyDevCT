class Solution {
    int n;
    int[][] computers;
    boolean[] visited;
    
    void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < n; ++j) {
            if (i==j || computers[i][j] == 0 || visited[j]) continue;
            dfs(j);
        }
    }
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i]) continue;
            ++ans;
            dfs(i);
        }
        
        return ans;
    }
}