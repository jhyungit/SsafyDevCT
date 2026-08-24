package programmers.p1832;

class Solution_Bogyeong {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        // 0: 왼 -> 오, 1: 위 -> 아래
        int[][][] cnt = init(m, n, cityMap);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue;
                if (cityMap[i][j] == 2) {
                    cnt[i][j][0] = cnt[i][j-1][0];
                    cnt[i][j][1] = cnt[i-1][j][1];
                    continue;
                }
                cnt[i][j][0] = cnt[i][j][1] = (cnt[i][j-1][0] + cnt[i-1][j][1]) % MOD;
            }
        }

        return cnt[m-1][n-1][0];
    }

    private int[][][] init(int m, int n, int[][] cityMap) {
        int[][][] cnt = new int[m][n][2];

        int i = 0;
        while (i < m) {
            if (cityMap[i][0] == 1) break;

            cnt[i][0][1] = 1;

            if (cityMap[i][0] != 2) {
                cnt[i][0][0] = 1;
            }

            i++;
        }

        int j = 0;
        while (j < n) {
            if (cityMap[0][j] == 1) break;

            cnt[0][j][0] = 1;

            if (cityMap[0][j] != 2) {
                cnt[0][j][1] = 1;
            }

            j++;
        }

        return cnt;
    }
}
