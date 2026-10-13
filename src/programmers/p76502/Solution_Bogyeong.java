package programmers.p76502;

import java.util.*;

class Solution_Bogyeong {
    char[] open = { '(', '[', '{' };
    char[] close = { ')', ']', '}' };
    
    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!isOpen(s.charAt(i))) continue;
            
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            
            int answer = cnt(s2+s1);
            if (answer > 0) return answer;
        }
        return 0;
    }
    
    public int cnt(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dq.isEmpty()) ++answer;
            
            // 현재 여는 괄호
            if (isOpen(s.charAt(i))) {
                dq.offer(s.charAt(i));
                continue;
            }
            // 현재 닫는 괄호
            // 큐가 비었거나 짝이 안 맞으면 안 됨
            if (dq.isEmpty() || !isPair(dq.peekLast(), s.charAt(i))) {
                return 0;
            }
            // 짝이 맞음
            // 큐의 마지막을 빼냄
            dq.pollLast();
        }
        
        if (!dq.isEmpty()) return 0;
        
        return answer;
    }
    
    private boolean isOpen(char c) {
        for (int i = 0; i < open.length; i++) {
            if (open[i] == c) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isPair(char open, char close) {
        if (open == '(') {
            return close == ')';
        }
        if (open == '[') {
            return close == ']';
        }
        if (open == '{') {
            return close == '}';
        }
        return false;
    }
}
