package boj.p14438;

// https://www.acmicpc.net/problem/5397
// BOJ 5397 키로거
// Time: 568 ms
// Memory: 198,580 kb
// Approach: Stack 2개를 활용한 커서 좌 우측 관리

import java.util.*;
import java.io.*;

class Main {
    static Deque<Character> left = new ArrayDeque<>();
    static Deque<Character> right = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String line = br.readLine().trim();
            findPassword(line);
        }

        System.out.println(sb);
    }

    static void findPassword(String line){
        left.clear();
        right.clear();
        int size = line.length();
        
        for (int i = 0; i < size; i++) {
            char c = line.charAt(i);

            if (c == '<'){
                if (!left.isEmpty()){
                    char move = left.pollLast();
                    right.add(move);
                }
            }

            else if (c == '>'){
                if (!right.isEmpty()){
                    char move = right.pollLast();
                    left.add(move);
                }
            }

            else if (c == '-'){
                if (!left.isEmpty()){
                    left.pollLast();
                }
            }

            else{
                left.add(c);
            }
        }

        while(!right.isEmpty()){
            char move = right.pollLast();
            left.add(move);
        }

        while(!left.isEmpty()){
            sb.append(left.poll());
        }
        sb.append('\n');
    }
}
