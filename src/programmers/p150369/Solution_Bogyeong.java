package programmers.p150369;

class Solution_Bogyeong {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int max = 0;
        for (int i = n-1; i >= 0; i--) {
            if (deliveries[i] == 0 && pickups[i] == 0) continue;
            max = i;
            break;
        }
        int d = 0, p = 0, di = max, pi = max;
        while (max >= 0) {
            d = 0;
            p = 0;
            for (; di >= 0; di--) {
                if (deliveries[di] == 0) continue;
                d += deliveries[di];
                if (d <= cap) continue;
                deliveries[di] = d - cap;
                break;
            }
            
            for (; pi >= 0; pi--) {
                if (pickups[pi] == 0) continue;
                p += pickups[pi];
                if (p <= cap) continue;
                pickups[pi] = p - cap;
                break;
            }
            
            if (d == 0 && p == 0) break;
            
            answer += (max+1) * 2;
            max = Math.max(di, pi);
        }
        
        return answer;
    }
}
