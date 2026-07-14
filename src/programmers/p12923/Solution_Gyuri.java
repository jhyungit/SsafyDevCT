class Solution {
    public long[] solution(long begin, long end) {
        long[] ans = new long[(int)(end-begin+1)];
        
        // x = kn 여부 검사 (단, k >= 2)
        int idx = 0;
        boolean check = false;
        for (long pos = begin; pos <= end; ++pos) {
            
            long tmp = 1;
            for (long k=2; k*k <= pos; ++k) {
                if (pos % k != 0) continue; // 약수 아님
                long n = pos/k;
                if (n > 10_000_000) {
                    tmp = k; // n은 너무 크니까 작은 k라도 저장해둠
                    continue; // 가능한 블록 값 초과
                }
                ans[idx++] = n;
                check = true;
                break;
            }
            
            if (!check) ans[idx++] = tmp; // n 못찾음 -> fallback
            else check = false;
        }
        
        // corner case: 1번째 칸은 무조건 0
        if (begin == 1) ans[0] = 0;
        
        return ans;
    }
}