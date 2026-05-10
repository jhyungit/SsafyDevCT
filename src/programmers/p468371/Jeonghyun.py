# 꼼수 풀이..
# 이렇게 풀면 혼나요~

def solution(signals):
    answer = 0
    light = []
    
    for signal in signals:
        temp = ""
        temp += 'G' * signal[0]
        temp += 'Y' * signal[1]
        temp += 'R' * signal[2]
        temp *= 1_000_000
        light.append(list(temp))
        
    time = 1

    while time < 3_000_000:
        check = set()
        for l in light:
            check.add(l[time])
        time += 1
        if check == set('Y'):
            return time

    return -1

# 정확성  테스트
# 테스트 1 〉	통과 (147.35ms, 171MB)
# 테스트 2 〉	통과 (117.64ms, 168MB)
# 테스트 3 〉	통과 (188.04ms, 204MB)
# 테스트 4 〉	통과 (189.94ms, 262MB)
# 테스트 5 〉	통과 (203.59ms, 263MB)
# 테스트 6 〉	통과 (288.31ms, 399MB)
# 테스트 7 〉	통과 (348.47ms, 458MB)
# 테스트 8 〉	통과 (529.65ms, 676MB)
# 테스트 9 〉	통과 (133.45ms, 185MB)
# 테스트 10 〉	통과 (265.07ms, 369MB)
# 테스트 11 〉	통과 (1121.85ms, 309MB)
# 테스트 12 〉	통과 (345.41ms, 487MB)
# 테스트 13 〉	통과 (251.15ms, 311MB)
# 테스트 14 〉	통과 (302.89ms, 398MB)
# 테스트 15 〉	통과 (426.32ms, 569MB)
# 테스트 16 〉	통과 (466.74ms, 620MB)
# 테스트 17 〉	통과 (1296.62ms, 585MB)
# 테스트 18 〉	통과 (1390.78ms, 645MB)
# 테스트 19 〉	통과 (510.59ms, 605MB)
# 테스트 20 〉	통과 (644.33ms, 660MB)
# 테스트 21 〉	통과 (553.53ms, 637MB)
# 테스트 22 〉	통과 (663.74ms, 628MB)
# 테스트 23 〉	통과 (706.43ms, 640MB)
# 테스트 24 〉	통과 (794.65ms, 709MB)
# 테스트 25 〉	통과 (871.26ms, 638MB)
# 채점 결과
# 정확성: 100.0
# 합계: 100.0 / 100.0
