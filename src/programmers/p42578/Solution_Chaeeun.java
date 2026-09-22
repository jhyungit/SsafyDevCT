package programmers.p42578;

import java.util.HashMap;
import java.util.Map;

class Solution_Chaeeun {
    public int solution(String[][] clothes) {
        Map<String, Integer> countByType = new HashMap<>();

        for (String[] cloth: clothes) {
            String type = cloth[1];

            countByType.put(
                type,
                countByType.getOrDefault(type, 0) + 1
            );
        }

        int answer = 1;
        
        for (int count: countByType.values()) {
            // 안 입는 경우를 포함하여 +1
            answer *= (count + 1);
        }
        
        // 전부 안 입는 경우 제외 위해 -1
        return answer - 1;
    }
}
