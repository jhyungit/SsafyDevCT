# https://school.programmers.co.kr/learn/courses/30/lessons/87946

from itertools import permutations

def go(k, d):
    cnt = 0
    for need,use in d:
        if k >= need:
            cnt += 1
            k -= use
        else:
            break
    return cnt

def solution(k, dungeons):
    answer = 0
    n = len(dungeons)

    for d in (permutations(dungeons, n)):
        answer = max(answer, go(k, d))

    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.02ms, 11.2MB)
# 테스트 2 〉	통과 (0.01ms, 11.4MB)
# 테스트 3 〉	통과 (0.04ms, 11.4MB)
# 테스트 4 〉	통과 (0.05ms, 11.5MB)
# 테스트 5 〉	통과 (0.19ms, 11.4MB)
# 테스트 6 〉	통과 (1.32ms, 10.9MB)
# 테스트 7 〉	통과 (12.12ms, 11.2MB)
# 테스트 8 〉	통과 (12.94ms, 11.3MB)
# 테스트 9 〉	통과 (0.03ms, 11.4MB)
# 테스트 10 〉	통과 (1.82ms, 11.1MB)
# 테스트 11 〉	통과 (0.01ms, 11.1MB)
# 테스트 12 〉	통과 (7.55ms, 11.4MB)
# 테스트 13 〉	통과 (5.96ms, 11.4MB)
# 테스트 14 〉	통과 (5.41ms, 11.5MB)
# 테스트 15 〉	통과 (5.33ms, 11.5MB)
# 테스트 16 〉	통과 (0.76ms, 11.4MB)
# 테스트 17 〉	통과 (5.48ms, 11.3MB)
# 테스트 18 〉	통과 (0.01ms, 11.1MB)
# 테스트 19 〉	통과 (0.03ms, 11.4MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
