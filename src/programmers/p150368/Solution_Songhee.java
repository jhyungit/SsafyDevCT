package programmers.p150368;

import java.util.Arrays;

public class Solution_Songhee {

    private static int[][] u;
    private static int[] e;
    private static int[] answer;
    private static final int[] sales = {10, 20, 30, 40};

    public static void main(String[] args) {
        Solution_Songhee sol = new Solution_Songhee();

        u = new int[][]{{40, 10000}, {25, 10000}};
        e = new int[]{7000, 9000};

        int[] result = sol.solution(u, e);

        System.out.println("결과: " + Arrays.toString(result));
    }

    public int[] solution(int[][] users, int[] emoticons) {
        u = users;
        e = emoticons;
        answer = new int[] {0, 0}; // 초기화
        
        dfs(0, new int[emoticons.length]);

        return answer;
    }

    private static void dfs(int index, int[] emosale) {
        if (index == e.length) {
        	// 이모티콘 플러스 가입자 최대
            // 이모티콘 판매액 최대
        	int[] curr = calculate(emosale);
        	
        	if(curr[0] > answer[0]) {
        		answer[0] = curr[0];
        		answer[1] = curr[1];
        	}
        	
        	if(curr[0] == answer[0] && curr[1] > answer[1]) {
    			answer[1] = curr[1];
    		}
        	
        	return; // 재귀 종료
        }

        for (int sale : sales) {
        	emosale[index] = sale; // 현재 이모티콘 할인율
        	dfs(index+1, emosale);
        }
    }
    
    private static int[] calculate(int[] emosale) {
    	int emoPlus = 0;
    	int total = 0;
    	
    	for(int[] user : u) {
    		int tmpTotal = 0;
    		
    		for (int i = 0; i < emosale.length; i++) {
				if(emosale[i] >= user[0]) {
					tmpTotal += e[i] * (100 - emosale[i]) / 100;
				}
			}
    		
    		if(tmpTotal >= user[1]) {
    			emoPlus++;
    		} else {
    			total += tmpTotal;
    		}
    	}
    	
    	return new int[] {emoPlus, total};
    }
}