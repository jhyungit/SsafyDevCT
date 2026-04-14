# 등산코스 정하기
# https://school.programmers.co.kr/learn/courses/30/lessons/118669

import heapq

INF = float("inf")

# 출발지 -> 산봉우리 경로 중
# 경로 내 최대 간선 값의 최소 구하기  
def dijkstra(n, gates, summits, graph):
    heap = []
    dist = [INF] * (n + 1)
    
    # 모든 출입구 넣기
    for gate in gates:
        heapq.heappush(heap, (0, gate))
        dist[gate] = 0
    
    summits_set = set(summits)
    
    while heap:
        intensity, cur = heapq.heappop(heap)
        
        # 이미 저장된 intensity가 작을 떄
        if intensity > dist[cur]:
            continue
        
        # 정상이면
        if cur in summits_set:
            continue
        
        for v, w in graph[cur]:
            new_intensity = max(w, intensity)
            
            if new_intensity < dist[v]:
                dist[v] = new_intensity
                heapq.heappush(heap, (dist[v], v))
                
    return dist

# 지점, 등산로 정보, 출입구, 산봉우리
def solution(n, paths, gates, summits):
    graph = [[] for _ in range(n+1)]
    
    for u, v, w in paths:
        graph[u].append((v,w))
        graph[v].append((u,w))
    
    dist = dijkstra(n, gates, summits, graph)
    
    summits.sort()
    answer = [0, INF]
    
    for summit in summits:
        if dist[summit] < answer[1]:
            answer = [summit, dist[summit]]
    
    return answer

# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (0.02ms, 9.23MB)
# 테스트 2 〉	통과 (0.02ms, 9.23MB)
# 테스트 3 〉	통과 (0.03ms, 9.26MB)
# 테스트 4 〉	통과 (0.01ms, 9.28MB)
# 테스트 5 〉	통과 (0.02ms, 9.37MB)
# 테스트 6 〉	통과 (0.07ms, 9.27MB)
# 테스트 7 〉	통과 (0.07ms, 9.29MB)
# 테스트 8 〉	통과 (0.07ms, 9.27MB)
# 테스트 9 〉	통과 (0.13ms, 9.14MB)
# 테스트 10 〉	통과 (0.48ms, 9.37MB)
# 테스트 11 〉	통과 (0.24ms, 9.28MB)
# 테스트 12 〉	통과 (0.33ms, 9.27MB)
# 테스트 13 〉	통과 (5.52ms, 10.7MB)
# 테스트 14 〉	통과 (29.55ms, 19.1MB)
# 테스트 15 〉	통과 (318.21ms, 73.6MB)
# 테스트 16 〉	통과 (308.16ms, 76.2MB)
# 테스트 17 〉	통과 (309.70ms, 76.3MB)
# 테스트 18 〉	통과 (16.61ms, 14.7MB)
# 테스트 19 〉	통과 (102.32ms, 33MB)
# 테스트 20 〉	통과 (292.54ms, 70.1MB)
# 테스트 21 〉	통과 (399.08ms, 66.8MB)
# 테스트 22 〉	통과 (14.94ms, 14MB)
# 테스트 23 〉	통과 (105.22ms, 30MB)
# 테스트 24 〉	통과 (63.38ms, 25.7MB)
# 테스트 25 〉	통과 (573.07ms, 87.5MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0