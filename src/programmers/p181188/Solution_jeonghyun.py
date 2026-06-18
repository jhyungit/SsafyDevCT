# 정석 O(nlogn) 풀이
def solution(targets):
    answer = 0
    targets.sort(key = lambda x : x[1])
    last_e = float("-inf")
    
    for s, e in targets:
        if s >= last_e:
            answer += 1
            last_e = e
        
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 11.2MB)
# 테스트 2 〉	통과 (0.01ms, 11.4MB)
# 테스트 3 〉	통과 (0.02ms, 11.3MB)
# 테스트 4 〉	통과 (0.13ms, 11.4MB)
# 테스트 5 〉	통과 (1.65ms, 13.1MB)
# 테스트 6 〉	통과 (26.66ms, 27.7MB)
# 테스트 7 〉	통과 (158.07ms, 91.6MB)
# 테스트 8 〉	통과 (157.42ms, 91.8MB)
# 테스트 9 〉	통과 (141.66ms, 78.5MB)
# 테스트 10 〉	통과 (22.33ms, 73.8MB)
# 테스트 11 〉	통과 (0.00ms, 11.4MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0

# O(n^2) 풀이 통과는 함
from collections import deque

def solution(targets):
    answer = 0
    targets.sort(key = lambda x : x[1])
    dq = deque(targets)
    
    while dq:
        cur = dq.popleft()
        s,e = cur
        
        cnt = 0
        for ns, ne in dq:
            if ns < e:
                cnt += 1
                continue
            else:
                break
        while cnt:
            dq.popleft()
            cnt -= 1

        answer += 1
        
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 11.4MB)
# 테스트 2 〉	통과 (0.02ms, 11.4MB)
# 테스트 3 〉	통과 (0.02ms, 11.6MB)
# 테스트 4 〉	통과 (0.17ms, 11.7MB)
# 테스트 5 〉	통과 (2.12ms, 13.2MB)
# 테스트 6 〉	통과 (30.98ms, 27.2MB)
# 테스트 7 〉	통과 (178.45ms, 91.5MB)
# 테스트 8 〉	통과 (194.00ms, 91.7MB)
# 테스트 9 〉	통과 (184.82ms, 78.1MB)
# 테스트 10 〉	통과 (36.40ms, 73.8MB)
# 테스트 11 〉	통과 (0.01ms, 11.2MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
