# 어떻게 하면 제한시간을 초과하지 않을 수 있을까?
# KMP = Knuth Morris Pratt 알고리즘 (문자열 안에서 어떤 단어가 몇 번 등장하는지 찾는 알고리즘)
# 시간복잡도 O(N+M) N은 전체 문자열 길이, M은 찾을 문자열 길이

# 아이디어!
# pattern[i]: [0:i]구간에서 앞(prefix)과 뒤(suffix)가 같은 최대 길이 저장
# 이미 i-1까지의 최대 겹침 길이를 알고 있음: j = pi[i-1]
# pattern[0:j-1] == pattern[i-j:i-1]

def solution(text, pattern):
    # pi는 prefix function(부분 일치 함수)
    pi = [0] * len(pattern) # 접두사와 접미사가 일치하는 최대 길이 저장 pi배열

    # 접두사 접미사 일치하는 최대 길이 저장
    # i: pattern에서 현재 보고 있는 인덱스
    # j: 현재까지 일치한 접두사 길이
    for i in range(1,len(pattern)): # 1부터 시작(하나는 의미 없으므로)
        j = pi[i-1]
        
        while j > 0 and pattern[i] != pattern[j]:
            j = pi[j-1] # 이전에 일치했던 위치로 이동
            
        if pattern[i] == pattern[j]:
            j += 1
        
        pi[i] = j
    
    ans = 0
    j = 0
    # i: text에서 현재 보고 있는 위치
    # j: pattern에서 현재까지 연속으로 맞춘 길이(다음에 비교할 pattern 인덱스)
    for i in range(len(text)):
        while j > 0 and text[i] != pattern[j]:
            j = pi[j-1] # 다르면 이전 저장만큼 길이 감소

        if text[i] == pattern[j]:
            j += 1 # 맞춘 길이 증가

        if j == len(pattern): # 맞춘 길이 == 패턴 길이
            ans += 1
            j = pi[j-1] # 이후 겹치는 등장도 찾기 위해 j를 

    return ans

n = int(input())

for i in range(n):
    text = input() # ABABA
    pattern = input() # ABA
    cnt = solution(text, pattern)
    
    print(f"#{i+1} {cnt}")

# 첫 코드 제한시간 초과

# from collections import deque

# def solution(string, check):
#     ans = 0
#     check_dq = deque(check)
#     temp = deque()
    
#     # string의 문자 하나씩 확인
#     for c in string:
#         temp.append(c)
        
#         if temp == check_dq: # 단어 등장
#             ans += 1
#             temp.popleft()

#         # 만들어야하는 첫 번째 알파벳과 다르면 popleft
#         while len(temp) > 0 and temp[0] != check[0] or len(temp) == len(check):
#             temp.popleft()
                
#     return ans

# n = int(input())

# for i in range(n):
#     string = input()
#     check = input()
#     cnt = solution(string, check)
    
#     print(f"#{i+1} {cnt}")