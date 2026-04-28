// https://school.programmers.co.kr/learn/courses/30/lessons/150368?language=java
// 이모티콘 할인행사

package programmers.p150368;
import java.io.*;
import java.util.*;
// 우선순위
// 1. 가입자 최대한 늘리기
// 2. 판매액 최대한 늘리기
class Solution_Jeonghyun {
    static final int[] discounts = {40,30,20,10};
    static int[] selected;
    static int maxUseImoPlus;
    static int maxTotalIncome;

    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        // {40, 30, 20, 10} product 구하기
        selected = new int[emoticons.length];
        dfs(0, emoticons, users);
        
        answer[0] = maxUseImoPlus;
        answer[1] = maxTotalIncome;
        return answer;
    }
    
    static void dfs(int depth, int[] emoticons, int[][] users){
        if (depth == selected.length){
            // product 만들기
            check(selected, emoticons, users);
            return;
        }
        
        for(int d: discounts){
            selected[depth] = d;
            dfs(depth+1, emoticons, users);
        }
    }
    
    static void check(int[] discounts, int[] emoticons, int[][] users){
        int[] prices = new int[emoticons.length]; // 할인 후 가격 저장 리스트
        int[] spends = new int[users.length]; // 고객별 소비한 돈 리스트
        int useImoPlus = 0, totalIncome = 0;

        // 할인 후 가격 저장
        for(int i = 0; i < emoticons.length; i++){
            prices[i] = emoticons[i] * (100-discounts[i]) / 100;
        }
        
        for(int ui = 0; ui < users.length; ui++){
            for(int ei = 0; ei < emoticons.length; ei++){
                if(users[ui][0] <= discounts[ei]) spends[ui] += prices[ei];
            }
        }
        
        int j = 0;
        for(int spend: spends){
            if(spend >= users[j++][1]){ // 한도 이상일 때
                useImoPlus++;
            }else{
                totalIncome += spend;
            }
        }
        
        if(useImoPlus > maxUseImoPlus){
            maxUseImoPlus = useImoPlus;
            maxTotalIncome = totalIncome;
        }else if(useImoPlus == maxUseImoPlus && totalIncome > maxTotalIncome){
            maxTotalIncome = totalIncome;
        }
    }
}

// 테스트 1 〉	통과 (0.04ms, 85.6MB)
// 테스트 2 〉	통과 (0.04ms, 84.3MB)
// 테스트 3 〉	통과 (0.13ms, 90.2MB)
// 테스트 4 〉	통과 (0.75ms, 93.1MB)
// 테스트 5 〉	통과 (0.90ms, 96.8MB)
// 테스트 6 〉	통과 (0.77ms, 70.6MB)
// 테스트 7 〉	통과 (3.81ms, 77.7MB)
// 테스트 8 〉	통과 (1.76ms, 92.2MB)
// 테스트 9 〉	통과 (12.28ms, 75.1MB)
// 테스트 10 〉	통과 (3.08ms, 76.1MB)
// 테스트 11 〉	통과 (47.39ms, 92.2MB)
// 테스트 12 〉	통과 (19.02ms, 92.6MB)
// 테스트 13 〉	통과 (68.91ms, 96.5MB)
// 테스트 14 〉	통과 (82.47ms, 103MB)
// 테스트 15 〉	통과 (11.93ms, 76.4MB)
// 테스트 16 〉	통과 (17.57ms, 76.7MB)
// 테스트 17 〉	통과 (0.14ms, 68.8MB)
// 테스트 18 〉	통과 (4.14ms, 94.8MB)
// 테스트 19 〉	통과 (0.05ms, 79.9MB)
// 테스트 20 〉	통과 (0.05ms, 89.6MB)
// 채점 결과
// 정확성: 100.0
// 합계: 100.0 / 100.0
