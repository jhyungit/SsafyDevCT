package programmers.p468371;

public class Solution_Bogyeong {
	public int solution(int[][] signals) {        
        // [현재 신호, 현재 신호에서 흐른 시간]의 형태인 배열
        int[][] cur = new int[signals.length][2];
        for (int i = 0; i < signals.length; i++) {
            cur[i][0] = 0;
            cur[i][1] = 1;
        }
        
        // 최대 반복 시간
        int maxLoop = lcm(signals);
        for (int t = 1; t <= maxLoop; t++) {            
            if (isAllYellow(cur)) return t;
            for (int i = 0; i < signals.length; i++) {
                if (cur[i][1] != signals[i][cur[i][0]]) {
                    cur[i][1]++;
                    continue;
                }
                cur[i][0] = (cur[i][0] + 1) % signals[i].length;
                cur[i][1] = 1;
            }
        }
        
        return -1;
    }
    
    private boolean isAllYellow(int[][] cur) {
        for (int[] n : cur) {
            if (n[0] != 1) return false;
        }
        return true;
    }
    
    private int lcm(int[][] signals) {
        int result = sum(signals[0]);
        for (int i = 1; i < signals.length; i++) {
            result = lcm(result, sum(signals[i]));
        }
        return result;
    }
    
    private int sum(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result += n;
        }
        return result;
    }
    
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
