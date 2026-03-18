# 파괴되지 않은 건물
# https://school.programmers.co.kr/learn/courses/30/lessons/92344

# 아이디어: 2차원 차분 배열 활용
def attack(r1, c1, r2, c2, degree, temp):
    # -        +
    # +        -
    temp[r1][c1] -= degree
    temp[r1][c2+1] += degree
    temp[r2+1][c1] += degree
    temp[r2+1][c2+1] -= degree

def recover(r1, c1, r2, c2, degree, temp):
    # +        -
    # -        +
    temp[r1][c1] += degree
    temp[r1][c2+1] -= degree
    temp[r2+1][c1] -= degree
    temp[r2+1][c2+1] += degree

def solution(board, skill):
    r = len(board)
    c = len(board[0])
    
    temp = [[0] * (c+1) for _ in range(r+1)] # 차분 배열 초기화
    
    for sk in skill:
        typ, r1, c1, r2, c2, degree = sk
        if(typ == 1): # 공격
            attack(r1, c1, r2, c2, degree, temp)
        else: # 회복
            recover(r1, c1, r2, c2, degree, temp)
            
    # 가로 누적
    for i in range(r+1):
        for j in range(1,c+1):
            temp[i][j] += temp[i][j-1]
    
    # 세로 누적
    for j in range(c+1):
        for i in range(1,r+1):
            temp[i][j] += temp[i-1][j]
    
    answer = 0
    
    for i in range(r):
        for j in range(c):
            if board[i][j] + temp[i][j] > 0:
                answer += 1
    
    return answer

# 	정확성  테스트
# 테스트 1 〉	통과 (0.01ms, 9.38MB)
# 테스트 2 〉	통과 (0.10ms, 9.2MB)
# 테스트 3 〉	통과 (0.38ms, 9.31MB)
# 테스트 4 〉	통과 (0.76ms, 9.31MB)
# 테스트 5 〉	통과 (0.66ms, 9.29MB)
# 테스트 6 〉	통과 (0.98ms, 9.28MB)
# 테스트 7 〉	통과 (2.67ms, 9.3MB)
# 테스트 8 〉	통과 (3.87ms, 9.36MB)
# 테스트 9 〉	통과 (2.63ms, 9.38MB)
# 테스트 10 〉	통과 (7.08ms, 9.51MB)

# 효율성  테스트
# 테스트 1 〉	통과 (796.80ms, 134MB)
# 테스트 2 〉	통과 (791.54ms, 134MB)
# 테스트 3 〉	통과 (687.39ms, 134MB)
# 테스트 4 〉	통과 (687.89ms, 134MB)
# 테스트 5 〉	통과 (523.36ms, 100MB)
# 테스트 6 〉	통과 (539.46ms, 100MB)
# 테스트 7 〉	통과 (565.50ms, 100MB)

# 채점 결과
# 정확성: 53.8
# 효율성: 46.2
# 합계: 100.0 / 100.0
