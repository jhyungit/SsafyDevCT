package programmers.p468371;

class Solution_Chaeeun {
    int[][] signals;
    int[] lengths;
    int traficLightCnt;
        
    public int solution(int[][] signals) {
        this.signals = signals;
        traficLightCnt = signals.length;
        
        lengths = new int[traficLightCnt];
        
        int limit = 1;
        for(int i = 0; i < traficLightCnt; i++){
            lengths[i] = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, lengths[i]);
        }
        
        int maxGreen = 0;
        for(int j = 0; j < traficLightCnt; j++){
            maxGreen = Math.max(maxGreen, signals[j][0]);
        }
        
        for(int t = maxGreen + 1; t <= limit; t++){
            if (isAllYellow(t)){
                return t;
            }
        }
        return -1;
    }
    
    boolean isAllYellow(int t){
        for(int i = 0; i < traficLightCnt; i++){
            if (!isYellow(t, i)){
                return false;
            }
        }
        return true;
    }
    
    boolean isYellow(int t, int i){
        int green = signals[i][0];
        int yellow = signals[i][1];
        
        int cur = (t - 1) % lengths[i];
        
        return green <= cur && cur < green + yellow;
    }
    
    int gcd(int a, int b) {
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }
}


/*
테스트 1 〉	통과 (0.02ms, 60.2MB)
테스트 2 〉	통과 (0.03ms, 60.9MB)
테스트 3 〉	통과 (0.04ms, 63.8MB)
테스트 4 〉	통과 (0.27ms, 62.2MB)
테스트 5 〉	통과 (0.03ms, 64.2MB)
테스트 6 〉	통과 (0.03ms, 62.8MB)
테스트 7 〉	통과 (0.02ms, 62.9MB)
테스트 8 〉	통과 (0.03ms, 61.2MB)
테스트 9 〉	통과 (0.02ms, 61.8MB)
테스트 10 〉	통과 (0.02ms, 62.7MB)
테스트 11 〉	통과 (0.14ms, 67.7MB)
테스트 12 〉	통과 (0.02ms, 63.3MB)
테스트 13 〉	통과 (0.02ms, 61.5MB)
테스트 14 〉	통과 (0.28ms, 62.4MB)
테스트 15 〉	통과 (0.21ms, 61.5MB)
테스트 16 〉	통과 (0.91ms, 63.8MB)
테스트 17 〉	통과 (0.55ms, 62.5MB)
테스트 18 〉	통과 (4.02ms, 62.1MB)
테스트 19 〉	통과 (3.11ms, 60.2MB)
테스트 20 〉	통과 (4.86ms, 62.9MB)
테스트 21 〉	통과 (3.18ms, 62.5MB)
테스트 22 〉	통과 (4.85ms, 62.4MB)
테스트 23 〉	통과 (5.11ms, 60.7MB)
테스트 24 〉	통과 (6.49ms, 63.1MB)
테스트 25 〉	통과 (5.86ms, 63.6MB)
*/
