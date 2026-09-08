# https://school.programmers.co.kr/learn/courses/30/lessons/131130?language=python3
def solution(cards):
    n = len(cards)
    visited = [False] * (n+1)
    group = []
    
    for i in range(1, n+1):
        if visited[i]:
            continue
        
        cnt = 0
        j = i
        while not visited[j]:
            visited[j] = True
            cnt += 1
            j = cards[j-1] # 인덱스는 -1
        group.append(cnt)
    
    if len(group) < 2:
        return 0
    
    group.sort(reverse = True)
    return group[0] * group[1]

# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 11.6MB)
# 테스트 2 〉	통과 (0.01ms, 11.7MB)
# 테스트 3 〉	통과 (0.01ms, 11.4MB)
# 테스트 4 〉	통과 (0.01ms, 11.5MB)
# 테스트 5 〉	통과 (0.01ms, 11.6MB)
# 테스트 6 〉	통과 (0.01ms, 11.5MB)
# 테스트 7 〉	통과 (0.01ms, 11.7MB)
# 테스트 8 〉	통과 (0.02ms, 11.2MB)
# 테스트 9 〉	통과 (0.02ms, 11.4MB)
# 테스트 10 〉	통과 (0.01ms, 11.2MB)
# 테스트 11 〉	통과 (0.01ms, 11.5MB)
# 테스트 12 〉	통과 (0.01ms, 11.6MB)
# 테스트 13 〉	통과 (0.01ms, 11.3MB)
# 테스트 14 〉	통과 (0.01ms, 11.5MB)
# 테스트 15 〉	통과 (0.01ms, 11.3MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
