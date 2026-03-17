package boj.p19951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 76392KB
// 시간 1940ms
public class Solution_Songhee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 연병장 크기
        int M = Integer.parseInt(st.nextToken()); // 조교 수
        int[] land = new int[N+1]; // 연병장
        int[] calc = new int[N+1]; // 계산식

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            land[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) { // 조교 지시
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for (int j = start; j < end+1; j++) {
                calc[j] += num;
            }
        }

        for (int i = 1; i < N+1; i++) {
            System.out.print(land[i] + calc[i] + " ");
        }
    }
}
