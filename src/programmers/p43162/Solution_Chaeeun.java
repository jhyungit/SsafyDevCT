package programmers.p43162;

class Solution_Chaeeun {
     private boolean[] visited;
    private int[][] computers;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.visited = new boolean[n];

        int answer = 0;

        for (int computer = 0; computer < n; computer++) {
            if (!visited[computer]) {
                dfs(computer);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int current) {
        visited[current] = true;

        for (int next = 0; next < computers.length; next++) {
            if (computers[current][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }
}
