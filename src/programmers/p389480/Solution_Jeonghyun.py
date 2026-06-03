# https://school.programmers.co.kr/learn/courses/30/lessons/389480a

def solution(info, n, m):
    INF = float("inf")
    dp = [INF] * n # dp[a_sum] = B 흔적 합의 최솟값
    dp[0] = 0

    for a, b in info:
        ndp = [INF] * n # 이 물건까지 반영한 새 상태
        for a_sum in range(n):
            if dp[a_sum] == INF:    # 도달 못한 상태는 무시
                continue
            b_sum = dp[a_sum]

            # (1) 물건을 A에게
            if a_sum + a < n:
                ndp[a_sum + a] = min(ndp[a_sum + a], b_sum)

            # (2) 물건을 B에게
            if b_sum + b < m:
                ndp[a_sum] = min(ndp[a_sum], b_sum + b)
                
        dp = ndp

    answer = INF
    for a_sum in range(n):
        if dp[a_sum] < m:
            answer = min(answer, a_sum)

    return answer if answer != INF else -1

# 정확성  테스트
# 테스트 1 〉	통과 (0.04ms, 11.5MB)
# 테스트 2 〉	통과 (0.06ms, 11.2MB)
# 테스트 3 〉	통과 (0.06ms, 11.3MB)
# 테스트 4 〉	통과 (0.04ms, 11.4MB)
# 테스트 5 〉	통과 (0.28ms, 11.3MB)
# 테스트 6 〉	통과 (0.14ms, 11.4MB)
# 테스트 7 〉	통과 (0.18ms, 11.5MB)
# 테스트 8 〉	통과 (0.02ms, 11.5MB)
# 테스트 9 〉	통과 (0.12ms, 11.3MB)
# 테스트 10 〉	통과 (0.11ms, 11.3MB)
# 테스트 11 〉	통과 (0.01ms, 11.4MB)
# 테스트 12 〉	통과 (0.01ms, 11.3MB)
# 테스트 13 〉	통과 (0.01ms, 11.5MB)
# 테스트 14 〉	통과 (0.01ms, 11.4MB)
# 테스트 15 〉	통과 (0.06ms, 11.4MB)
# 테스트 16 〉	통과 (0.04ms, 11.3MB)
# 테스트 17 〉	통과 (0.02ms, 11.4MB)
# 테스트 18 〉	통과 (0.04ms, 11.5MB)
# 테스트 19 〉	통과 (0.05ms, 11.3MB)
# 테스트 20 〉	통과 (0.01ms, 11.3MB)
# 테스트 21 〉	통과 (0.04ms, 11.4MB)
# 테스트 22 〉	통과 (0.04ms, 11.4MB)
# 테스트 23 〉	통과 (0.05ms, 11.5MB)
# 테스트 24 〉	통과 (0.04ms, 11.5MB)
# 테스트 25 〉	통과 (0.14ms, 11.5MB)
# 테스트 26 〉	통과 (0.17ms, 11.4MB)
# 테스트 27 〉	통과 (0.17ms, 11.4MB)
# 테스트 28 〉	통과 (0.24ms, 11.3MB)
# 테스트 29 〉	통과 (0.20ms, 11.3MB)
# 테스트 30 〉	통과 (0.09ms, 11.5MB)
# 테스트 31 〉	통과 (0.15ms, 11.3MB)
# 테스트 32 〉	통과 (0.21ms, 11.3MB)
# 테스트 33 〉	통과 (0.23ms, 11.4MB)
# 테스트 34 〉	통과 (0.15ms, 11.4MB)
# 테스트 35 〉	통과 (0.15ms, 11.3MB)
# 테스트 36 〉	통과 (0.31ms, 11.5MB)
# 테스트 37 〉	통과 (0.13ms, 11.4MB)
# 테스트 38 〉	통과 (0.01ms, 11.5MB)
# 테스트 39 〉	통과 (0.01ms, 11.5MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
