# https://school.programmers.co.kr/learn/courses/30/lessons/42578
from collections import defaultdict

def solution(clothes):
    items = defaultdict(int)
    
    for name, typee in clothes:
        items[typee] += 1

    # 한개 씩
    answer = sum(items.values())
    if len(items) == 1:
        return answer
    
    # # 곱한 거 (안 입는 거도 있음!!)
    answer = 1
    for n in items.values():
        answer *= (n + 1)
    
    return answer - 1

# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 11.3MB)
# 테스트 2 〉	통과 (0.01ms, 11.4MB)
# 테스트 3 〉	통과 (0.01ms, 11.4MB)
# 테스트 4 〉	통과 (0.01ms, 11.3MB)
# 테스트 5 〉	통과 (0.01ms, 11.3MB)
# 테스트 6 〉	통과 (0.01ms, 11.6MB)
# 테스트 7 〉	통과 (0.01ms, 11.5MB)
# 테스트 8 〉	통과 (0.03ms, 11.4MB)
# 테스트 9 〉	통과 (0.01ms, 11.7MB)
# 테스트 10 〉	통과 (0.03ms, 11.6MB)
# 테스트 11 〉	통과 (0.01ms, 11.4MB)
# 테스트 12 〉	통과 (0.02ms, 11.7MB)
# 테스트 13 〉	통과 (0.02ms, 11.3MB)
# 테스트 14 〉	통과 (0.01ms, 11.3MB)
# 테스트 15 〉	통과 (0.01ms, 11.3MB)
# 테스트 16 〉	통과 (0.01ms, 11.3MB)
# 테스트 17 〉	통과 (0.01ms, 11.4MB)
# 테스트 18 〉	통과 (0.02ms, 11.5MB)
# 테스트 19 〉	통과 (0.01ms, 11.3MB)
# 테스트 20 〉	통과 (0.01ms, 11.4MB)
# 테스트 21 〉	통과 (0.01ms, 11.4MB)
# 테스트 22 〉	통과 (0.01ms, 11.3MB)
# 테스트 23 〉	통과 (0.01ms, 11.3MB)
# 테스트 24 〉	통과 (0.01ms, 11.3MB)
# 테스트 25 〉	통과 (0.01ms, 11.3MB)
# 테스트 26 〉	통과 (0.01ms, 11.4MB)
# 테스트 27 〉	통과 (0.01ms, 11.5MB)
# 테스트 28 〉	통과 (0.01ms, 11.6MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
