# 양과 늑대
# https://school.programmers.co.kr/learn/courses/30/lessons/92343

# 0 양, 1 늑대
def dfs(graph, info, node, sheep, wolf, candidates):
    # 양 일 때
    if info[node] == 0:
        sheep += 1
    else:
        wolf += 1
    
    if sheep <= wolf:
        return 0
    
    next_candidates = [c for c in candidates if c != node] + graph[node]
    
    best = sheep
    for next_node in next_candidates:
        best = max(best, dfs(graph, info, next_node, sheep, wolf , next_candidates))
        
    return best

def solution(info, edges):
    graph = [[] for _ in range(len(info))]
    
    for u,v in edges:
        graph[u].append(v)
        
    return dfs(graph, info, 0, 0, 0, [0]) # graph, info, node, sheep, wolf, candidates

print(solution([0,1,0,1,1,0,1,0,0,1,0], [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]))

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 9.27MB)
# 테스트 2 〉	통과 (0.10ms, 9.28MB)
# 테스트 3 〉	통과 (0.01ms, 9.38MB)
# 테스트 4 〉	통과 (0.01ms, 9.39MB)
# 테스트 5 〉	통과 (0.24ms, 9.39MB)
# 테스트 6 〉	통과 (0.19ms, 9.21MB)
# 테스트 7 〉	통과 (0.05ms, 9.18MB)
# 테스트 8 〉	통과 (0.04ms, 9.3MB)
# 테스트 9 〉	통과 (0.36ms, 9.18MB)
# 테스트 10 〉	통과 (3.74ms, 9.38MB)
# 테스트 11 〉	통과 (0.12ms, 9.29MB)
# 테스트 12 〉	통과 (0.90ms, 9.3MB)
# 테스트 13 〉	통과 (0.04ms, 9.3MB)
# 테스트 14 〉	통과 (0.05ms, 9.18MB)
# 테스트 15 〉	통과 (0.34ms, 9.14MB)
# 테스트 16 〉	통과 (0.52ms, 9.29MB)
# 테스트 17 〉	통과 (9.21ms, 9.18MB)
# 테스트 18 〉	통과 (0.39ms, 9.18MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0