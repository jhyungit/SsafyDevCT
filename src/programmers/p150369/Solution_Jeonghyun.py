# https://school.programmers.co.kr/learn/courses/30/lessons/150369

def solution(cap, n, deliveries, pickups):
    answer = 0
    d = 0 # 배달 장부
    p = 0 # 수거 장부
    
    for i in range(n - 1, -1, -1):
        # 집의 상자를 장부에 더하기
        d += deliveries[i]
        p += pickups[i]
        
        # 둘 중 하나가 양수면 트럭 필요
        while d > 0 or p > 0:
            answer += ((i+1) * 2)
            d -= cap
            p -= cap
    return answer

# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (0.00ms, 11.3MB)
# 테스트 2 〉	통과 (0.00ms, 11.4MB)
# 테스트 3 〉	통과 (0.01ms, 11.6MB)
# 테스트 4 〉	통과 (0.01ms, 11.6MB)
# 테스트 5 〉	통과 (0.01ms, 11.5MB)
# 테스트 6 〉	통과 (0.01ms, 11.5MB)
# 테스트 7 〉	통과 (0.10ms, 11.4MB)
# 테스트 8 〉	통과 (0.19ms, 11.4MB)
# 테스트 9 〉	통과 (0.84ms, 11.5MB)
# 테스트 10 〉	통과 (0.74ms, 11.4MB)
# 테스트 11 〉	통과 (0.33ms, 11.5MB)
# 테스트 12 〉	통과 (0.31ms, 11.7MB)
# 테스트 13 〉	통과 (0.29ms, 11.4MB)
# 테스트 14 〉	통과 (0.26ms, 11.4MB)
# 테스트 15 〉	통과 (5.38ms, 13.3MB)
# 테스트 16 〉	통과 (139.22ms, 13MB)
# 테스트 17 〉	통과 (18.10ms, 13.2MB)
# 테스트 18 〉	통과 (9.73ms, 13.2MB)
# 테스트 19 〉	통과 (8.60ms, 13.1MB)
# 테스트 20 〉	통과 (9.52ms, 13.3MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0