package programmers.p92343;

import java.util.*;

class Solution {
    int N, maxSheep = -1; 
    int[] info;
    List<Integer> graph[];
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.N = info.length;
        graph = new ArrayList[N];
        
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            int v = edge[0];
            int u = edge[1];
            
            graph[v].add(u);
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Set<Integer> candidates = new HashSet<>();
        dfs(0, 1, 0, visited, candidates);
        return maxSheep;
    }
    
    public void dfs(int now, int sheep, int wolf, Set<Integer> visited, Set<Integer> candidates){
        maxSheep = Math.max(maxSheep, sheep);
        
        // 지금 위치의 자식들을 후보에 추가
        Set<Integer> updatedC = new HashSet<>(candidates);
        for(int next: graph[now]){
            updatedC.add(next);
        }
        
        // 후보들에 대해서
        for(int cand: updatedC){
            // 다음 노드가 방문한 적 있는 곳이면 건너뛰기
            if (visited.contains(cand)){
                continue;
            }
            
            // 다음 노드가 방문한 적 없는 곳이면
            else{
                // 방문하기 위해 방문지 업데이트
                Set<Integer> updatedV = new HashSet<>(visited);
                updatedV.add(cand);
                
                // 양이면 이동
                if (info[cand] == 0){
                    dfs(cand, sheep + 1, wolf, updatedV, updatedC);
                }
                // 늑대면 개수 보고 이동
                else {
                    if (sheep > wolf + 1){
                        dfs(cand, sheep, wolf + 1, updatedV, updatedC);
                    }
                }
            }
        }
    }
}
