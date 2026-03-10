package swea.p8898;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3차원 농부
public class Solution_Songhee {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc+1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 소 개수
            int M = Integer.parseInt(st.nextToken()); // 말 개수

            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken()); // 소 x 좌표
            int c2 = Integer.parseInt(st.nextToken()); // 말 x 좌표
            int[] cow = new int[N]; // 소들의 z 좌표
            int[] horse = new int[M]; // 말의 z 좌표

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cow[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                horse[i] = Integer.parseInt(st.nextToken());
            }

            int minDist = Integer.MAX_VALUE;
            int count = 0; // 최소 거리 쌍의 개수

            // 각 소에 대해 가장 가까운 말 위치 찾기
            Arrays.sort(horse);

            for(int c : cow) { // 이분탐색
                int left = 0;
                int right = M-1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    int diff = c - horse[mid];

                    // 절대값 차이 계산 및 최소값 갱신 로직
                    int absDiff = Math.abs(diff);
                    if (absDiff < minDist) {
                        minDist = absDiff;
                        count = 1; // 카운트 리셋
                    } else if (absDiff == minDist) {
                        count++;
                    }

                    if (diff < 0) right = mid - 1;
                    else if (diff > 0) left = mid + 1;
                    else break; // 차이가 0이면 더 찾을 필요 없음
                }
            }

            minDist += Math.abs(c1 - c2);
            sb.append("#").append(t).append(" ").append(minDist).append(" ").append(count).append("\n"); // 거리와 쌍들의 개수
        }

        System.out.println(sb.toString());
    }
}
