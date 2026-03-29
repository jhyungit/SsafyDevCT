package boj.p14438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_Songhee {
    static class SegmentTree {
        int[] tree;
    }

    private static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 수열 개수
        int[] nums = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 쿼리 개수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken()); // 1 이면 바꾸기, 2면 출력
            int index = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(type == 1) {
                nums[index] = v;
            } else {
                int[] arr = Arrays.copyOfRange(nums, index, v+1);
                Arrays.sort(arr);
                System.out.println(arr[0]); // 제일 작은 값
            }
        }
    }

}
