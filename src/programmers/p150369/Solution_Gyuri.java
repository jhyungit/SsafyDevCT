class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans = 0;
        int give = 0;
        int take = 0;
        
        // 가장 먼 집부터 탐색
        for (int i = n-1; i >= 0; --i) {
            give += deliveries[i];
            take += pickups[i];
            
            while (give > 0 || take > 0) {
                give -= cap;
                take -= cap;
                ans += (long) (i+1)<<1; // 현 위치(i+1)까지의 왕복 거리
            }
        }
        
        return ans;
    }
}