package programmers.p150365;

class Solution {
    static int DIR = 4;
    char[] directions = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        int distance = Math.abs(x - r) + Math.abs(y - c);
        
        if (isImpossible(k, distance)) return "impossible";
        
        StringBuilder answer = new StringBuilder();
        
        // 알파벳 순으로 가장 빠른 문장 찾아 이동
        for (int move = 0; move < k; move++) {
            int remain= k - move - 1;
            
            // 알파벳 순 4방향 탐색
             for (int i = 0; i < DIR; i++) {
                 int nx = x + dx[i];
                 int ny = y + dy[i];
                 
                 // 범위 밖이면 지나침
                 if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                 }
                 
                 distance = Math.abs(nx - r) + Math.abs(ny - c);
                 
                 if (isImpossible(remain, distance)) continue;

                 answer.append(directions[i]);
                 x = nx;
                 y = ny;
                 break;
             }
        }
        
        return answer.toString();
    }
    
    boolean isImpossible(int k, int distance){
        // 아예 도착하지 못하는 경우
        // 움직일 수 있는 횟수보다 도착지가 멀거나
        // 남은 횟수로 도착할 수 없는 위치일 경우
        if (distance > k || (k - distance) % 2 != 0) return true;
        
        return false;
    }
    
}
