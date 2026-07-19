# https://school.programmers.co.kr/learn/courses/30/lessons/150365?language=python3
# 미로 탈출 명령어

moves = [('d',1,0),('l',0,-1),('r',0,1),('u',-1,0)]
    
def solution(n, m, x, y, r, c, k):
    answer = ''
    cur_x, cur_y = x, y
    
    # 맨해튼 거리 검사: 거리 > 이동 횟수
    start_dist = abs(x-r) + abs(y-c)
    # 이동 횟수 - 거리가 홀수면 도달 불가
    if start_dist > k or (k - start_dist) % 2 != 0:
        return "impossible" 
    
    # k걸음 반복
    for i in range(1, k + 1):
        remain = k - i
        
        for move, dx, dy in moves:
            nx, ny = cur_x + dx, cur_y + dy

            # 범위 체크
            if nx < 1 or nx > n or ny < 1 or ny > m:
                continue
            
            dist = abs(nx - r) + abs(ny - c)
            if dist > remain or (remain - dist) % 2 != 0:
                continue
            
            answer += move
            cur_x, cur_y = nx, ny
            break
            
    return answer
    
    
# 채점을 시작합니다.
# 정확성  테스트
# 테스트 1 〉	통과 (0.03ms, 11.7MB)
# 테스트 2 〉	통과 (0.04ms, 11.7MB)
# 테스트 3 〉	통과 (0.00ms, 11.5MB)
# 테스트 4 〉	통과 (0.01ms, 11.8MB)
# 테스트 5 〉	통과 (0.01ms, 11.6MB)
# 테스트 6 〉	통과 (0.01ms, 11.5MB)
# 테스트 7 〉	통과 (0.01ms, 11.6MB)
# 테스트 8 〉	통과 (0.01ms, 11.7MB)
# 테스트 9 〉	통과 (0.65ms, 11.4MB)
# 테스트 10 〉	통과 (0.63ms, 11.6MB)
# 테스트 11 〉	통과 (0.92ms, 11.6MB)
# 테스트 12 〉	통과 (0.69ms, 11.7MB)
# 테스트 13 〉	통과 (0.66ms, 11.6MB)
# 테스트 14 〉	통과 (0.71ms, 11.5MB)
# 테스트 15 〉	통과 (0.63ms, 11.6MB)
# 테스트 16 〉	통과 (0.75ms, 11.6MB)
# 테스트 17 〉	통과 (0.89ms, 11.6MB)
# 테스트 18 〉	통과 (0.95ms, 11.7MB)
# 테스트 19 〉	통과 (0.66ms, 11.5MB)
# 테스트 20 〉	통과 (0.65ms, 11.7MB)
# 테스트 21 〉	통과 (0.68ms, 11.7MB)
# 테스트 22 〉	통과 (0.67ms, 11.5MB)
# 테스트 23 〉	통과 (0.69ms, 11.7MB)
# 테스트 24 〉	통과 (0.65ms, 11.8MB)
# 테스트 25 〉	통과 (0.64ms, 11.5MB)
# 테스트 26 〉	통과 (0.68ms, 11.6MB)
# 테스트 27 〉	통과 (0.64ms, 11.6MB)
# 테스트 28 〉	통과 (0.67ms, 11.4MB)
# 테스트 29 〉	통과 (0.74ms, 11.5MB)
# 테스트 30 〉	통과 (0.93ms, 11.3MB)
# 테스트 31 〉	통과 (0.00ms, 11.5MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0