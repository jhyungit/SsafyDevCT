package programmers.p131130;

class Solution_Bogyeng {
    public int solution(int[] cards) {
        int[] list = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            list[i] = cards[i] - 1;
        }
        
        boolean[] select = new boolean[cards.length];
        
        int fir = 0, sec = 0;
        for (int i = 0; i < cards.length; i++) {
            if (select[i]) continue;
            int cur = i;
            int cnt = 0;
            while (!select[cur]) {
                select[cur] = true;
                ++cnt;
                cur = list[cur];
            }
            if (fir < cnt) {
                sec = fir;
                fir = cnt;
            } else if (sec < cnt) {
                sec = cnt;
            }
        }
        
        return fir * sec;
    }
}
