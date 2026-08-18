package programmers.p12902;

class Solution_Bogyeong {
    public int solution(int n) {
        final long MOD = 1_000_000_007L;

        // 3 * n의 넓이가 홀수이면 2칸짜리 타일로 채울 수 없음
        if (n % 2 == 1) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (n == 2) {
            return 3;
        }

        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (4 * dp[i - 2] - dp[i - 4]) % MOD;

            if (dp[i] < 0) {
                dp[i] += MOD;
            }
        }

        return (int) dp[n];
    }
}
