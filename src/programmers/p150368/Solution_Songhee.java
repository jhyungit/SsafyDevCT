package programmers.p150368;

import java.util.Arrays;

public class Solution_Songhee {

    private static int[][] users;
    private static int[] emoticons;
    private static int[] answer;
    private static final int[] sales = {10, 20, 30, 40};

    public static void main(String[] args) {
        Solution_Songhee sol = new Solution_Songhee();

        users = new int[][]{{40, 10000}, {25, 10000}};
        emoticons = new int[]{7000, 9000};

        int[] result = sol.solution(users, emoticons);

        System.out.println("결과: " + Arrays.toString(result));
    }

    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘 플러스 가입자 최대
        // 이모티콘 판매액 최대
        answer[0] = 0;
        answer[1] = 0;

        dfs(0);

        return answer;
    }

    private static void dfs(int index) {
        if (index == emoticons.length) {
            // 최대 비교
        }

        for (int sale : sales) {

        }
    }
}