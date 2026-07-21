class Solution {
    int[] dx = {1, 0, 0, -1}; // D L R U
    int[] dy = {0, -1, 1, 0};
    char[] ch = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 출발과 도착 지점이 같지는 않지만 도착이 꼭 출발의 우하단은 아님
        
        int d = Math.abs(x-r) + Math.abs(y-c);
        
        if (d > k || ((k-d)&1) != 0)
            return "impossible";
        
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            for (int i = 0; i < 4; ++i) { // scan 4 directions per depth
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 1 || n < nx || ny < 1 || n < ny) continue; // bound check
                
                int nd = Math.abs(nx-r) + Math.abs(ny-c);
                if (nd > k-1) continue; // distance check
                
                sb.append(ch[i]);
                x = nx;
                y = ny;
                --k;
                break;
            }
        }
        
        return sb.toString();
    }
}