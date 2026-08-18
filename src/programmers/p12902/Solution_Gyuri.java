import java.util.*;

class Solution {
    final int MOD = 1_000_000_007;
    int[] memo = new int[5001];
    
    long dp(int n) {
        if (n == 0) return 1;
        if (n == 2) return 3;
        
        if (memo[n] != -1) return memo[n];
        
        // optimized
        // long res = (dp(n-2) * 3 + 2) % MOD;
        // for (int i=n-4; i>=2; i-=2) {
        //     res += dp(i) * 2;
        //     res %= MOD;
        // }
        long res = (4*dp(n-2) - dp(n-4)) % MOD; // 4, 6, 8...
        
        // 모듈러 값 간의 차이기 때문에 순간적으로 음수가 될 경우 예외처리
        if (res < 0) res += MOD;
        
        return memo[n] = (int)res;
    }
    
    public int solution(int n) {
        // n이 홀수면 못 채움
        if ((n&1)==1) return 0;
        
        Arrays.fill(memo, -1);
        
        return (int)dp(n);
    }
}