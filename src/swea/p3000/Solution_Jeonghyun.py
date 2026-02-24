# 메모리 101,308kb
# 실행시간 2.943ms
# 코드길이 1,438

import heapq
import math

def find_mid():
    i, num = map(int, input().split())

    max_heap = []
    min_heap = []
    
    heapq.heappush(max_heap, -num)
    ans = 0
    for _ in range(i):
        for num in list(map(int, input().split())): # x, y for문으로 읽어오기

            # max, min 중 어디에 넣을지 결정
            if num <= -max_heap[0]: # 현재 값 <= max_heapd의 root값
                heapq.heappush(max_heap, -num)
            else:
                heapq.heappush(min_heap, num)

            # 사이즈 맞추기
            if len(max_heap) > len(min_heap)+1: # min힙 개수+1한 거 보다 크면
                heapq.heappush(min_heap, -heapq.heappop(max_heap))
            elif len(min_heap) > len(max_heap): # max힙이 적을 때
                heapq.heappush(max_heap, -heapq.heappop(min_heap))

        ans = (ans + (-max_heap[0])) %  20171109

    return ans
    


# 테스트 케이스 개수 입력
test_case = int(input())



for i in range(test_case):
    mid_value = find_mid()

    print(f"#{i+1} {mid_value}")


# 아이디어!
# 배열 [1,2,3,4,5]를 쪼개면
# [1,2,3], [4,5]로 가능
# left의 모든 값 <= right의 모든 값
# 따라서 left의 최댓값, 오른쪽의 최솟값 꺼내야함
# left는 max_heap, right는 min_heap

# 1,3,2가 들어오면
# max_heap = [-1], min_heap = []
# max_heap = [-1], min_heap = [3]
# max_heap = [-1], min_heap = [2,3] ----- len(left) < len(right) 이므로 이동
# max_heap = [-2,-1], min_heap = [3]
# -max_heap[0]으로 중간값 2 출력
