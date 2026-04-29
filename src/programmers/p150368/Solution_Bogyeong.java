package programmers.p150368;

class Solution_Bogyeong {
    
    static final int[] discounts = { 10, 20, 30, 40 };
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        // 각 할인에 대해 각 이모티콘의 가격
        int[][] prices = new int[discounts.length][emoticons.length];
        for (int i = 0; i < discounts.length; i++) {
            for (int j = 0; j < emoticons.length; j++) {
                prices[i][j] = emoticons[j] * (100 - discounts[i]) / 100;
            }
        }
        
        perm(0, users, new int[emoticons.length][2], prices, answer);
        
        return answer;
    }
    
    // promotion: [할인율, 할인된 가격] -> 중복 순열의 한 결과
    private void perm(int cnt, int[][] users, int[][] promotion, int[][] prices, int[] answer) {
        if (promotion.length == cnt) {
            sum(users, promotion, answer);
            return;
        }
        
        for (int i = 0; i < discounts.length; i++) {
            promotion[cnt][0] = discounts[i];
            promotion[cnt][1] = prices[i][cnt];
            perm(cnt+1, users, promotion, prices, answer);
        }
    }
    
    private void sum(int[][] users, int[][] promotions, int[] answer) {
        int newUser = 0;
        int totalPrice = 0;
        
        for (int[] user : users) {
            int price = 0;
            for (int[] promotion : promotions) {
                if (user[0] <= promotion[0]) {
                    price += promotion[1];
                }
            }
            
            if (price >= user[1]) {
                ++newUser;
            } else {
                totalPrice += price;
            }
        }
        
        if (answer[0] < newUser || (answer[0] == newUser && answer[1] < totalPrice)) {
            answer[0] = newUser;
            answer[1] = totalPrice;
        }
    }
}