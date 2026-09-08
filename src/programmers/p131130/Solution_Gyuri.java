import java.util.*;

class Solution {
    int[] cards;
    boolean[] visited;
    
    int findCycle(int i) {
        if (visited[i]) return 0;
        visited[i] = true;
        
        return findCycle(cards[i]-1) + 1;
    }
    
    public int solution(int[] cards) {
        this.cards = cards;
        visited = new boolean[cards.length];
        List<Integer> clenList = new ArrayList<>();
        
        // 1. 모든 사이클 뭉치를 찾는다 (길이만 구해두기)
        for (int i = 0; i < cards.length; ++i) {
            clenList.add(findCycle(i));
        }
        
        if (clenList.size() < 2) return 0;
        
        // 2. 뭉치 길이 제일 긴거 2개 곱하기
        Collections.sort(clenList, Collections.reverseOrder());
        
        return clenList.get(0) * clenList.get(1);
    }
}