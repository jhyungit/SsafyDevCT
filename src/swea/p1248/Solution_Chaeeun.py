# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD&
# SWEA 1248 공통조상
# Time: 99 ms
# Memory: 60,544 kb
# Approach: 인접리스트, 부모 배열을 통한 그래프 저장 + BFS

import sys 
from collections import deque

input = sys.stdin.readline 
write = sys.stdout.write 

def solve(test_case):
    V, E, node1, node2= map(int, input().split())
    parent_of = [0] * (V + 1)
    childs_of = [[] for _ in range(V + 1)]
    
    edges = list(map(int, input().split()))
  
    for i in range(E):
        parent = edges[2 * i]
        child = edges[2 * i + 1]
        parent_of[child] = parent
        childs_of[parent].append(child)
        
    visited = [False] * (V + 1)
    
    while (node1 != 0):
        visited[node1] = True
        node1 = parent_of[node1]
        
    while (not visited[node2]):
        node2 = parent_of[node2]
        
    subtree_count = 0
    q = deque([node2])
  
    while q:
        now = q.popleft()
        subtree_count += 1
        for child in childs_of[now]:
            q.append(child)
    
    write(f"#{test_case} {node2} {subtree_count}\n")
                
if __name__ == "__main__":
    T = int(input())
    for test_case in range(1, T+1):
        solve(test_case)
