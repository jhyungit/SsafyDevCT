# https://school.programmers.co.kr/learn/courses/30/lessons/388352

from itertools import combinations

def check(candi, q, ans):
    
    for i, num_arr in enumerate(q):
        cnt = 0
        for num in num_arr:
            if num in candi:
                cnt += 1
        if cnt != ans[i]: # 같지 않으면
            return 0

    return 1 # 충족하면

def solution(n, q, ans):
    answer = 0
    
    # 가장 많이 맞는 거 저장
    max_cnt = max(ans)
    max_idx = 0
    
    # 가장 많이 맞는 거의 인덱스 저장
    for i, cnt in enumerate(ans):
        if cnt == max_cnt:
            max_idx = i
    
    # 후보와 개수 저장
    max_set = set(q[max_idx])
    other_set = set(i for i in range(1,n+1) if i not in max_set)
    other_cnt = 5-max_cnt
    
    # 후보 체크
    for m in combinations(max_set, max_cnt):
        for o in combinations(other_set, other_cnt):
            answer += check(set(m+o), q, ans)
    
    return answer

# 정확성  테스트
# 테스트 1 〉	통과 (0.27ms, 9.41MB)
# 테스트 2 〉	통과 (6.86ms, 9.26MB)
# 테스트 3 〉	통과 (0.03ms, 9.21MB)
# 테스트 4 〉	통과 (0.14ms, 9.31MB)
# 테스트 5 〉	통과 (0.04ms, 9.32MB)
# 테스트 6 〉	통과 (0.11ms, 9.31MB)
# 테스트 7 〉	통과 (0.38ms, 9.32MB)
# 테스트 8 〉	통과 (1.04ms, 9.2MB)
# 테스트 9 〉	통과 (9.98ms, 9.3MB)
# 테스트 10 〉	통과 (6.05ms, 9.21MB)
# 테스트 11 〉	통과 (4.22ms, 9.3MB)
# 테스트 12 〉	통과 (51.15ms, 9.22MB)
# 테스트 13 〉	통과 (29.86ms, 9.26MB)
# 테스트 14 〉	통과 (70.05ms, 9.31MB)
# 테스트 15 〉	통과 (56.01ms, 9.25MB)
# 테스트 16 〉	통과 (56.16ms, 9.32MB)
# 테스트 17 〉	통과 (20.39ms, 9.31MB)
# 테스트 18 〉	통과 (2.67ms, 9.3MB)
# 테스트 19 〉	통과 (20.44ms, 9.26MB)
# 테스트 20 〉	통과 (2.91ms, 9.17MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0