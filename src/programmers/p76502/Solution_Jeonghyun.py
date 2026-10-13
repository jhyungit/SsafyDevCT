# https://school.programmers.co.kr/learn/courses/30/lessons/76502
from collections import deque

def rotate(dq):
    first = dq.popleft()
    dq.append(first)
    return dq

def is_right(now):
    stack = []
    
    for qwal in now:
        stack.append(qwal)
        if len(stack) < 2:
            continue

        if stack[-2] == "(" and stack[-1] == ")":
            stack.pop()
            stack.pop()
        elif stack[-2] == "{" and stack[-1] == "}":
            stack.pop()
            stack.pop()
        elif stack[-2] == "[" and stack[-1] == "]":
            stack.pop()
            stack.pop()
            
    return 0 if len(stack) else 1

def solution(s):
    answer = 0
    n = len(s)
    dq = deque(s)
    
    for _ in range(n):
        answer += is_right(dq)
        dq = rotate(dq)
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (93.86ms, 11.5MB)
# 테스트 2 〉	통과 (96.48ms, 11.2MB)
# 테스트 3 〉	통과 (99.31ms, 11.4MB)
# 테스트 4 〉	통과 (98.24ms, 11.3MB)
# 테스트 5 〉	통과 (122.37ms, 11.3MB)
# 테스트 6 〉	통과 (106.32ms, 11.1MB)
# 테스트 7 〉	통과 (112.88ms, 11.4MB)
# 테스트 8 〉	통과 (98.91ms, 11.3MB)
# 테스트 9 〉	통과 (104.25ms, 11.3MB)
# 테스트 10 〉	통과 (86.61ms, 11.3MB)
# 테스트 11 〉	통과 (73.70ms, 11.4MB)
# 테스트 12 〉	통과 (0.01ms, 11.3MB)
# 테스트 13 〉	통과 (0.01ms, 11.1MB)
# 테스트 14 〉	통과 (0.01ms, 11.2MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
