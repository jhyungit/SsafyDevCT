# https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIoEJzarUwDFAWN
# SWEA 4038 단어가 등장하는 횟수
# Time: 232 ms
# Memory: 68,504 kb
# Approach: KMP 알고리즘 

def build_pi(p):
    m = len(p)
    pi = [0] * m
    j = 0
    for i in range(1, m):
        while j > 0 and p[i] != p[j]:
            j = pi[j - 1]
        if p[i] == p[j]:
            j += 1
            pi[i] = j
    return pi

def kmp(text, pattern):
    n, m = len(text), len(pattern)
    if m == 0 or n < m:
        return 0
    pi = build_pi(pattern)
    j = 0
    cnt = 0
    for i in range(n):
        while j > 0 and text[i] != pattern[j]:
            j = pi[j - 1]
        if text[i] == pattern[j]:
            j += 1
            if j == m:
                cnt += 1
                j = pi[j - 1] 
    return cnt
                
if __name__ == "__main__":
    T = int(input().strip())
    for test_case in range(1, T+1):
        B = input().strip()
        S = input().strip()
        ans = kmp(B, S)
        print(f"#{test_case} {ans}")
