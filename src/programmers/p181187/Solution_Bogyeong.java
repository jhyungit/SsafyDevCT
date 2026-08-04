package programmers.p181187;

class Solution_Bogyeong {
    public long solution(int r1, int r2) {
        long count = 0;

        long r1Square = (long) r1 * r1;
        long r2Square = (long) r2 * r2;

        // x > 0, y >= 0인 영역만 계산
        for (long x = 1; x <= r2; x++) {
            // 바깥 원 내부에 존재하는 최대 y
            long maxY = (long) Math.floor(
                Math.sqrt(r2Square - x * x)
            );

            // 안쪽 원 위 또는 바깥에 존재하는 최소 y
            long minY;

            if (x < r1) {
                minY = (long) Math.ceil(
                    Math.sqrt(r1Square - x * x)
                );
            } else {
                minY = 0;
            }

            count += maxY - minY + 1;
        }

        // 회전 대칭으로 나머지 영역까지 계산
        return count * 4;
    }
}
