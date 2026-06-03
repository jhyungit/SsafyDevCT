package programmers.p389480;

import java.util.Arrays;

public class Solution_Songhee {
    public void main(String[] args) {
        Solution sol = new Solution();
        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 4;
        int m = 4;

        int result = sol.solution(info, n, m);
    }

    class Solution {
        int[][] info;
        int n;
        int m;
        int[][] memo;
        // 오버플로우를 방지하기 위해 Integer.MAX_VALUE 대신 충분히 큰 상수를 사용합니다.
        final int INF = 1_000_000_000;

        public int solution(int[][] info, int n, int m) {
            // 1. this를 붙여 전역 변수에 매개변수 값을 올바르게 대입합니다.
            this.info = info;
            this.n = n;
            this.m = m;

            this.memo = new int[info.length][m];

            for (int i = 0; i < info.length; i++) {
                Arrays.fill(memo[i], -1);
            }

            int answer = dfs(0, 0);

            // 2. 결과가 INF이거나, A의 제한 조건인 n 이상이라면 경찰에 잡힌 것이므로 -1을 리턴합니다.
            return (answer >= INF || answer >= n) ? -1 : answer;
        }

        private int dfs(int index, int sum) {
            if (index == info.length) {
                return 0;
            }

            if (memo[index][sum] != -1) {
                return memo[index][sum];
            }

            int minA = INF;

            // a가 훔치는 경우
            int stealA = dfs(index + 1, sum);
            if (stealA != INF) {
                // INF 대신 10억을 썼기 때문에 더해도 오버플로우가 나지 않습니다.
                minA = Math.min(minA, stealA + info[index][0]);
            }

            // b가 훔치는 경우
            if (sum + info[index][1] < m) {
                int stealB = dfs(index + 1, sum + info[index][1]);
                if (stealB != INF) {
                    minA = Math.min(minA, stealB);
                }
            }

            return memo[index][sum] = minA;
        }
    }
}
