import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] c : clothes) {
            String type = c[1];
            map.merge(type, 1, Integer::sum);
        }
        
        int ans = 1;
        for (int v : map.values()) ans *= v+1;

        // 하나도 안 입은 경우 제외
        return ans-1;
    }
}