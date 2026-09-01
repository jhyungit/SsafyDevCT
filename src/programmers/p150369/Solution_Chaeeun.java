package programmers.p150369;

class Solution_Chaeeun {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverRemain = 0;
        int pickupRemain = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            deliverRemain += deliveries[i];
            pickupRemain += pickups[i];
            
            while (deliverRemain > 0 || pickupRemain > 0) {
                deliverRemain -= cap;
                pickupRemain -= cap;
                
                answer += (i + 1) * 2;
            }
        }

        return answer;
    }
}
