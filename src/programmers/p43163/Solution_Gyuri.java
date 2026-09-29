import java.util.*;

class Solution {
    public boolean ok(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                diff += 1;
            }
        }
        return diff == 1;
    }
    
    static class Node {
        String word;
        int cnt;
        
        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        
        // init
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        wordsList.add(begin);
        
        int n = wordsList.size();
        
        for (int i = 0; i < n; ++i) {
            String wordI = wordsList.get(i);
            visited.put(wordI, false);
            adj.put(wordI, new ArrayList<>());
        }
        
        for (int i = 0; i < n; ++i) {
            String wordI = wordsList.get(i);
            visited.put(wordI, false);
            for (int j = i+1; j < n; ++j) {
                String wordJ = wordsList.get(j);
                if (ok(wordI, wordJ)) {
                    adj.get(wordI).add(wordJ);
                    adj.get(wordJ).add(wordI);
                }
            }
        }
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(begin, 0));
        visited.put(begin, true);
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            String word = cur.word;
            int cnt = cur.cnt;
            
            if (word.equals(target)) {
                return cnt;
            }
            
            for (String nw : adj.get(word)) {
                if (!visited.getOrDefault(nw, false)) {
                    q.add(new Node(nw, cnt+1));
                    visited.put(nw, true);
                }
            }
        }
        
        return 0;
    }
}