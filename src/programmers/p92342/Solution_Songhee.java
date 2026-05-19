package programmers.p92342;

public class Solution_Songhee {

    // 🌟 static을 제거하여 테스트 케이스마다 독립적으로 작동하도록 수정
    private int n;
    private int[] info;
    private int[] answer;
    private int maxVal;

    public int[] solution(int n, int[] info) {
        // 🌟 넘겨받은 인자값으로 멤버 변수 초기화 필수!
        this.n = n;
        this.info = info;

        this.answer = new int[11];
        this.maxVal = 0; // 점수 차이

        // 라이언 n개만큼 맞힘
        // 맞힌 개수 같으면 어피치가 점수 가져감
        // 이길 방법 없으면 [-1]
        dfs(0, 10, new int[11]);

        return maxVal > 0 ? answer : new int[]{-1};
    }

    private void dfs(int count, int score, int[] ryan) {
        if (count == n) {
            // 점수 계산하고 max 값 확인
            int apeachScore = 0;
            int ryanScore = 0;

            for (int i = 0; i < 11; i++) {
                if (info[i] >= ryan[i] && info[i] != 0) {
                    apeachScore += 10 - i;
                } else if (ryan[i] > info[i]) {
                    ryanScore += 10 - i;
                }
            }

            int diff = ryanScore - apeachScore;

            if (diff > maxVal) {
                maxVal = diff;
                answer = ryan.clone();
            } else if (diff == maxVal && diff > 0) { // 🌟 diff가 0보다 클 때만 동점 비교 수행 (0점 대 0점 방지)
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > answer[i]) {
                        answer = ryan.clone();
                        break;
                    } else if (answer[i] > ryan[i]) {
                        break; // 가지치기
                    }
                }
            }

            return;
        }

        for (int i = score; i >= 0; i--) { // score로 해야 중복 방지
            ryan[10 - i]++;
            dfs(count + 1, i, ryan);
            ryan[10 - i]--; // 백트래킹
        }
    }
}