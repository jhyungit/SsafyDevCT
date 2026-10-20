import java.util.*;

class Solution {
    static int[][] d;
    static boolean[] visited;

    public static int dp(int ddx, int k) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < d.length; ++i) {
            int req = d[i][0];
            int cost = d[i][1];
            if (req <= k && !visited[i]) { // 최소 피로도 ok
                visited[i] = true;
                ans.add(dp(i, k-cost) + 1); // 피로도 소모
                visited[i] = false;
            }
        }
        return Collections.max(ans);
    }

    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        visited = new boolean[d.length];
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < d.length; ++i) {
            if (d[i][0] <= k && !visited[i]) { // 최소 피로도 ok
                visited[i] = true;
                ans.add(dp(i, k-d[i][1]) + 1); // 피로도 소모
                visited[i] = false;
            }
        }
        return Collections.max(ans);
    }
}