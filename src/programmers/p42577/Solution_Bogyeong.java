package programmers.p42577;

import java.util.Arrays;

class Solution_Bogyeong {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i-1].length() >= phone_book[i].length())
                continue;
            if (phone_book[i].startsWith(phone_book[i-1]))
                return false;
        }
        
        return answer;
    }
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.10ms, 81.7MB)
// 테스트 2 〉	통과 (0.13ms, 73.8MB)
// 테스트 3 〉	통과 (0.10ms, 82.9MB)
// 테스트 4 〉	통과 (0.10ms, 82.5MB)
// 테스트 5 〉	통과 (0.11ms, 75.6MB)
// 테스트 6 〉	통과 (0.17ms, 85.9MB)
// 테스트 7 〉	통과 (0.13ms, 73.4MB)
// 테스트 8 〉	통과 (0.14ms, 81.4MB)
// 테스트 9 〉	통과 (0.11ms, 89.4MB)
// 테스트 10 〉	통과 (0.16ms, 84.4MB)
// 테스트 11 〉	통과 (0.09ms, 80.9MB)
// 테스트 12 〉	통과 (0.10ms, 74.3MB)
// 테스트 13 〉	통과 (0.09ms, 72.1MB)
// 테스트 14 〉	통과 (4.26ms, 82MB)
// 테스트 15 〉	통과 (2.08ms, 88.9MB)
// 테스트 16 〉	통과 (2.20ms, 74.4MB)
// 테스트 17 〉	통과 (2.52ms, 84.8MB)
// 테스트 18 〉	통과 (5.50ms, 89.6MB)
// 테스트 19 〉	통과 (2.50ms, 86.2MB)
// 테스트 20 〉	통과 (2.89ms, 80.8MB)
// 효율성  테스트
// 테스트 1 〉	통과 (13.96ms, 61.4MB)
// 테스트 2 〉	통과 (10.97ms, 61MB)
// 테스트 3 〉	통과 (203.75ms, 119MB)
// 테스트 4 〉	통과 (170.10ms, 109MB)
