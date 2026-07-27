def solution(n, computers):
    
    def find_parent(x):
        if parent[x] != x:
            parent[x] = find_parent(parent[x])
        return parent[x]
    
    def union_parent(a,b):
        ra = find_parent(a)
        rb = find_parent(b)
        
        if ra == rb:
            return False # 사이클
        parent[ra] = rb
        return True # 병합 성공
    
    parent = [i for i in range(n)]
    
    for x, computer in enumerate(computers):
        for y, status in enumerate(computer):
            if x == y or not status:
                continue
            if parent[x] != parent[y]:
                union_parent(x,y)
    
    answer = set()
    for i in range(n):
        root = find_parent(i)
        answer.add(root)

    return len(answer)

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 11.5MB)
# 테스트 2 〉	통과 (0.01ms, 11.5MB)
# 테스트 3 〉	통과 (0.04ms, 11.5MB)
# 테스트 4 〉	통과 (0.03ms, 11.4MB)
# 테스트 5 〉	통과 (0.01ms, 11.8MB)
# 테스트 6 〉	통과 (0.12ms, 11.5MB)
# 테스트 7 〉	통과 (0.02ms, 11.7MB)
# 테스트 8 〉	통과 (0.09ms, 11.6MB)
# 테스트 9 〉	통과 (0.08ms, 11.5MB)
# 테스트 10 〉	통과 (0.06ms, 11.6MB)
# 테스트 11 〉	통과 (0.36ms, 11.6MB)
# 테스트 12 〉	통과 (0.28ms, 11.6MB)
# 테스트 13 〉	통과 (0.14ms, 11.7MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
