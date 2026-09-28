package programmers.p43163;

import java.util.*;

class Solution_Bogyeong {
    public int solution(String begin, String target, String[] words) {
        if (!isContainsTarget(target, words)) return 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < words.length; i++) {
            if (canTransition(begin, words[i])) {
                if (words[i].equals(target)) {
                    return 1;
                }
                q.offer(new int[] {i, 1});
            }
        }
        
        boolean[] visited = new boolean[words.length];
        
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int index = pair[0];
            int depth = pair[1];
            
            if (visited[index]) continue;
            visited[index] = true;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (canTransition(words[index], words[i])) {
                    if (words[i].equals(target)) {
                        return depth+1;
                    }
                    q.offer(new int[] {i, depth+1});
                }
            }
        }
        
        return 0;
    }
    
    private boolean isContainsTarget(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean canTransition(String a, String b) {
        boolean isDifferent = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) continue;
            if (isDifferent) return false;
            isDifferent = true;
        }
        return isDifferent;
    }
}
