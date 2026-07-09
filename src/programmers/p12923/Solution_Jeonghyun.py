import math

def solution(begin, end):
    answer = []
    
    for i in range(begin,end+1):
        if i == 1:
            answer.append(0)
            continue
            
        best = 1 # 없으면 1번 블록
        for n in range(2, int(math.sqrt(i)) + 1):
            if i % n == 0: # 짝수 번째
                if i // n <= 10_000_000:
                    best = i // n # 1000만 이하 최대 몫
                    break
                best = n
        answer.append(best)

    return answer


# 정확성  테스트
# 테스트 1 〉	통과 (0.06ms, 11.4MB)
# 테스트 2 〉	통과 (0.08ms, 11.6MB)
# 테스트 3 〉	통과 (0.08ms, 11.3MB)
# 테스트 4 〉	통과 (0.05ms, 11.4MB)
# 테스트 5 〉	통과 (0.03ms, 11.3MB)
# 테스트 6 〉	통과 (0.12ms, 11.3MB)
# 테스트 7 〉	통과 (0.03ms, 11.5MB)
# 테스트 8 〉	통과 (0.06ms, 11.2MB)
# 테스트 9 〉	통과 (0.13ms, 11.4MB)
# 테스트 10 〉	통과 (0.11ms, 11.5MB)
# 테스트 11 〉	통과 (0.04ms, 11.6MB)
# 테스트 12 〉	통과 (0.04ms, 11.3MB)
# 테스트 13 〉	통과 (0.25ms, 11.5MB)
# 테스트 14 〉	통과 (0.14ms, 11.5MB)
# 테스트 15 〉	통과 (0.01ms, 11.6MB)
# 효율성  테스트
# 테스트 1 〉	통과 (429.16ms, 11.4MB)
# 테스트 2 〉	통과 (627.85ms, 11.5MB)
# 테스트 3 〉	통과 (778.80ms, 11.2MB)
# 테스트 4 〉	통과 (1005.52ms, 11.5MB)
# 테스트 5 〉	통과 (1129.82ms, 11.3MB)
# 테스트 6 〉	통과 (874.83ms, 11.2MB)
# 채점 결과
# 정확성: 71.4
# 효율성: 28.6
# 합계: 100.0 / 100.0
