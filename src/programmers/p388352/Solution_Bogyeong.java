package programmers.p388352;

class Solution_Bogyeong {
	private static final int CODE_LENGTH = 5;
	private int answer = 0;
	
    public int solution(int n, int[][] q, int[] ans) {
        combi(0, 1, new int[CODE_LENGTH], n, q, ans);
        return answer;
    }

	private void combi(int cnt, int start, int[] code, int n, int[][] q, int[] ans) {
		if (cnt == CODE_LENGTH) {
			if (isValidCodes(code, q, ans)) answer++;
			return;
		}
		
		for (int i = start; i <= n; i++) {
			code[cnt] = i;
			combi(cnt+1, i+1, code, n, q, ans);
		}
	}

	private boolean isValidCodes(int[] code, int[][] q, int[] ans) {
		for (int i = 0; i < ans.length; i++) {
			if (!isValidCode(code, q[i], ans[i])) return false;
		}
		return true;
	}

	private boolean isValidCode(int[] code, int[] q, int ans) {
		int i = 0, j = 0, result = 0;
		while (i < CODE_LENGTH && j < CODE_LENGTH) {
			if (code[i] == q[j]) {
				++result;
				++i;
				++j;
			} else if (code[i] > q[j]) {
				++j;
			} else if (code[i] < q[j]) {
				++i;
			}
		}
		return result == ans;
	}
}
