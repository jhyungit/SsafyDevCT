package swea.8898;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW45TzHae8UDFAQ7
// SWEA 8898 3차원 농부
// Time: 2341 ms
// Memory: 152,136 kb
// Approach: Binary Search를 이용한 최단 거리 탐색
import java.util.*;
import java.io.*;
 
public class Solution {
    static final int MAX = 500000;
    static int T, N, M, c, h;
    static int cows[] = new int[MAX];
    static int horses[] = new int[MAX];
    static int min, count, constDist;
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cows[i] = Integer.parseInt(st.nextToken());
            }
          
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                horses[j] = Integer.parseInt(st.nextToken());
            }
             
            min = Integer.MAX_VALUE;
            count = 0;
            constDist = Math.abs(c - h);
             
            findPairs();
            sb.append('#').append(t).append(' ').append(min).append(' ').append(count).append('\n');
        }    
         
        System.out.print(sb);
    }
 
    static void findPairs() {
        Arrays.sort(horses, 0, M);
         
        for (int i = 0; i < N; i++) {
            int insertIdx = binarySearch(cows[i]);
            if (insertIdx != 0) {
                updateMin(calcDist(i, insertIdx - 1));
            }
            if (insertIdx != M) {
                updateMin(calcDist(i, insertIdx));
            }
        }
    }
     
    static void updateMin(int dist) {
        if (dist < min) {
            min = dist;
            count = 1;
        }
         
        else if (dist == min) {
            count++;
        }
    }
     
    static int binarySearch(int target) {
        int left = 0, right = M;
         
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < horses[mid]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
         
        return right;
    }
     
    static int calcDist(int cIdx, int hIdx) {
        return constDist + Math.abs(cows[cIdx] - horses[hIdx]);     
    }
}
