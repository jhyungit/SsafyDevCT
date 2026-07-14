package programmers.p12923;

import java.util.Arrays;

class Solution_Bogyeong {
    private static final int MAX_BLOCK = 10_000_000;

    public int[] solution(long begin, long end) {
        int length = (int) (end - begin + 1);
        int[] answer = new int[length];

        Arrays.fill(answer, 1);

        if (begin == 1) {
            answer[0] = 0;
        }

        for (long i = 2; i * i <= end; i++) {
            long firstMultiple = ((begin + i - 1) / i) * i;

            long start = Math.max(firstMultiple, i * i);

            for (long number = start; number <= end; number += i) {
                int index = (int) (number - begin);
                long pair = number / i;

                answer[index] = Math.max(answer[index], (int) i);

                if (pair <= MAX_BLOCK) {
                    answer[index] = Math.max(answer[index], (int) pair);
                }
            }
        }

        return answer;
    }
}
