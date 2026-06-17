package programmers.p181188;

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));
        
        int answer = 0;
        int last = -1;
        
        for (int[] now: targets){
            int s = now[0];
            int e = now[1];
            
            if (last <= s){
                answer++;
                last = e;
            }
        }
        
        return answer;
    }
}
