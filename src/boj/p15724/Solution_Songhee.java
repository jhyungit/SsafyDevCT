package boj.p15724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 119748KB
// 시간 1256ms
public class Solution_Songhee { // 누적합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1]; // 첫째줄 다 0

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                int total = Integer.parseInt(st.nextToken());
                total += map[i][j-1];
                total += map[i-1][j];
                total -= map[i-1][j-1];
                map[i][j] = total;
            }
        }

        int c = Integer.parseInt(br.readLine()); // 직사각형 개수

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            System.out.println(map[endX][endY] - map[startX-1][endY] - map[endX][startY-1] + map[startX-1][startY-1]);
        }
    }
}
