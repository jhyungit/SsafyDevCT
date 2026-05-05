package programmers.p388352;

import java.util.ArrayList;
import java.util.List;

public class Solution_Songhee {

    public static void main(String[] args) {
        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};
        System.out.println(solution(n, q, ans)); // 3
    }

    private static List<int[]> list;
    private static int[] result;

    public static int solution(int n, int[][] q, int[] ans) {
        list = new ArrayList<>();
        int answer = 0;
        result = new int[5];
        // 정답 다 구해놓고 맞을 경우에만 카운트 올리기
        combination(0, 1, n);


        return answer;
    }

    private static void combination(int depth, int start, int n) {
        if (depth == 5) {
            list.add(result.clone()); // clone 해야 값만 복사. 아니면 같은 메모리 주소가 들어감
            return;
        }

        for (int i = start; i < n + 1; i++) {
            result[depth] = i;
            combination(depth + 1, i + 1, n); // start가 아닌 i 다음 숫자부터
        }
    }
}
