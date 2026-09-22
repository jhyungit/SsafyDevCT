package programmers.p42578;

import java.util.HashMap;

class Solution_Bogyeong {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> cntMap = new HashMap<>();
        
        for (String[] c : clothes) {
            cntMap.put(c[1], cntMap.getOrDefault(c[1], 0)+1);
        }
        
        int answer = 1;
        for (int v : cntMap.values()) {
            answer *= v + 1;
        }
        
        return answer-1;
    }
}
