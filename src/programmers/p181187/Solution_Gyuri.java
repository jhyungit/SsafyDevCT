class Solution {
    public long solution(int r1, int r2) {
        long ans = 0;
        final long r1s = (long)r1*r1;
        final long r2s = (long)r2*r2;
        
        // 1사분면만 합산
        for (int x = 1; x <= r2; ++x) {
            final long xs = (long)x*x;

            // 큰 원 안쪽의 최대 y
            long mxY = (long)Math.floor(Math.sqrt(r2s - xs));

            // 작은 원 바깥쪽의 최소 y
            long mnY = 0;
            if (x < r1)
                mnY = (long)Math.ceil(Math.sqrt(r1s - xs));

            // 현재 x에서 조건을 만족하는 y 개수 합산
            ans += (mxY - mnY + 1);
        }

        // 4개 사분면
        return ans << 2;
    }
}