# https://school.programmers.co.kr/learn/courses/30/lessons/92342
# 우승자에게 불리하게
# 우승자가 나중에 쏘기
# k점 화살 같을 경우 2등이 가져감

def solution(n, info):
    answer = [0] * 11
    max_diff = 0
    
    # 현재 점수칸, 남은 화살 수, 라이언 점수 배열
    def dfs(idx, left_arrow, lion_arr):
        nonlocal max_diff, answer
        
        # 종료 조건
        if idx == 11 or left_arrow == 0:
            temp = lion_arr[:]
            # 남은 화살 처리
            temp[10] += left_arrow # 마지막에 모두 더해줌(가장 낮은 점수를 더 많이 맞힌 경우를 return 조건)
            
            l_score, p_score = 0, 0
            # 점수 차 계산 -> 갱신
            for i in range(11):
                if temp[i] > info[i]:
                    l_score += 10 - i
                elif info[i] > 0:
                    p_score += 10 - i
            
            diff = l_score - p_score
            
            if diff > max_diff:
                max_diff = diff
                answer = temp[:]
            elif diff == max_diff and diff > 0:
                for i in range(10, -1, -1):
                    if temp[i] > answer[i]: # 현재가 더 낮은 점수 많이 쐈으면
                        answer = temp[:]
                        break
                    elif temp[i] < answer[i]: # 이미 더 낮은 점수 많이 쏨
                        break
            return
            
        
        # 1. 0발 쏘기)
        dfs(idx+1, left_arrow, lion_arr)
        
        # 2. 어피치 + 1발 쏘기)
        need = info[idx] + 1
        if left_arrow >= need:
            lion_arr[idx] = need
            dfs(idx+1, left_arrow - need, lion_arr)
            lion_arr[idx] = 0
            
    dfs(0, n, [0] * 11)
    return answer if max_diff > 0 else [-1]


# 정확성  테스트
# 테스트 1 〉	통과 (0.08ms, 9.11MB)
# 테스트 2 〉	통과 (1.34ms, 8.98MB)
# 테스트 3 〉	통과 (1.56ms, 9.33MB)
# 테스트 4 〉	통과 (0.41ms, 9.17MB)
# 테스트 5 〉	통과 (1.30ms, 9.26MB)
# 테스트 6 〉	통과 (1.17ms, 9.25MB)
# 테스트 7 〉	통과 (0.62ms, 8.98MB)
# 테스트 8 〉	통과 (0.23ms, 9.11MB)
# 테스트 9 〉	통과 (0.40ms, 8.99MB)
# 테스트 10 〉	통과 (0.15ms, 9MB)
# 테스트 11 〉	통과 (0.40ms, 9.16MB)
# 테스트 12 〉	통과 (0.27ms, 9.26MB)
# 테스트 13 〉	통과 (0.72ms, 9.22MB)
# 테스트 14 〉	통과 (1.01ms, 9.13MB)
# 테스트 15 〉	통과 (1.01ms, 9.21MB)
# 테스트 16 〉	통과 (0.53ms, 9.17MB)
# 테스트 17 〉	통과 (0.56ms, 9.14MB)
# 테스트 18 〉	통과 (0.06ms, 9.31MB)
# 테스트 19 〉	통과 (0.02ms, 9.22MB)
# 테스트 20 〉	통과 (1.03ms, 9.07MB)
# 테스트 21 〉	통과 (1.52ms, 9.17MB)
# 테스트 22 〉	통과 (1.81ms, 8.95MB)
# 테스트 23 〉	통과 (0.13ms, 9.21MB)
# 테스트 24 〉	통과 (1.15ms, 9.09MB)
# 테스트 25 〉	통과 (1.12ms, 9.13MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
