from collections import deque

def solution(phone_book):
    answer = True
    phone_book.sort()

    dq = deque(phone_book)
    while dq:
        num1 = dq.popleft()
        n = len(num1)
        for num2 in dq:
            if num1 == num2[:n]:
                return False
            else:
                break
        
    return answer

# def solution(phone_book):
#     answer = True
#     phone_book.sort()
#     for i in range(len(phone_book)-1):
#         if phone_book[i+1].startswith(phone_book[i]):
#             return False
#     return answer

채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.01ms, 11.3MB)
테스트 2 〉	통과 (0.01ms, 11.3MB)
테스트 3 〉	통과 (0.01ms, 11.1MB)
테스트 4 〉	통과 (0.01ms, 11.3MB)
테스트 5 〉	통과 (0.01ms, 11.3MB)
테스트 6 〉	통과 (0.01ms, 11.2MB)
테스트 7 〉	통과 (0.01ms, 11.3MB)
테스트 8 〉	통과 (0.01ms, 11.5MB)
테스트 9 〉	통과 (0.00ms, 11.4MB)
테스트 10 〉	통과 (0.00ms, 11.2MB)
테스트 11 〉	통과 (0.01ms, 11.3MB)
테스트 12 〉	통과 (0.01ms, 11.3MB)
테스트 13 〉	통과 (0.01ms, 11.3MB)
테스트 14 〉	통과 (0.21ms, 11.3MB)
테스트 15 〉	통과 (0.25ms, 11.4MB)
테스트 16 〉	통과 (0.32ms, 11.3MB)
테스트 17 〉	통과 (0.41ms, 11.7MB)
테스트 18 〉	통과 (0.48ms, 11.5MB)
테스트 19 〉	통과 (0.38ms, 11.6MB)
테스트 20 〉	통과 (0.66ms, 11.4MB)
효율성  테스트
테스트 1 〉	통과 (1.89ms, 11.7MB)
테스트 2 〉	통과 (1.86ms, 11.7MB)
테스트 3 〉	통과 (88.03ms, 28.8MB)
테스트 4 〉	통과 (71.76ms, 26.5MB)
채점 결과
정확성: 83.3
효율성: 16.7
합계: 100.0 / 100.0
