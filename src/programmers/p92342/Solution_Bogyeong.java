package programmers.p92342;

public class Solution_Bogyeong {
private static final int MAX_SCORE = 10;
	
	private static int maxTotal = 0;
	private static int maxRemainingN = 0;
	private static boolean[] maxSelected = new boolean[MAX_SCORE+1];
	
	private static boolean[] selected = new boolean[MAX_SCORE+1];
	
	public int[] solution(int n, int[] info) {
		if (n == info[0]) {
			return new int[] {-1};
		}
        
		subset(0, n, n, info);
        
        if (maxTotal == 0) {
        	return new int[] {-1};
        }
		
        int[] answer = new int[MAX_SCORE+1];
        int remainingN = n;
        for (int i = 0; i < MAX_SCORE-1; i++) {
        	if (maxSelected[i]) {
        		answer[i] = info[i] + 1;
        		remainingN -= answer[i];
        	}
		}
        answer[MAX_SCORE] = remainingN;
        
        return answer;
    }

	private void subset(int cnt, int n, int remainingN, int[] info) {
		if (remainingN < 0) return;
		
		if (remainingN == 0 || cnt == MAX_SCORE) {
			int total = calTotal(info);
			if (total > maxTotal || (total == maxTotal && isWinner(remainingN))) {
				maxTotal = total;
				maxRemainingN = remainingN;
				maxSelected = selected.clone();
			}
			return;
		}
		
		selected[cnt] = true;
		subset(cnt+1, n, remainingN-info[cnt]-1, info);
		selected[cnt] = false;
		subset(cnt+1, n, remainingN, info);
	}
	
	private int calTotal(int[] info) {
		int total = 0;
		for (int i = 0; i < info.length; i++) {
			if (selected[i]) {
				total += MAX_SCORE-i;
			} else if (info[i] != 0) {
				total -= MAX_SCORE-i;
			}
		}
		return total;
	}
    
    private boolean isWinner(int remainingN) {
    	if (remainingN != maxRemainingN) {
            return remainingN > maxRemainingN;
        }
		for (int i = MAX_SCORE-1; i > 0; i--) {
			if (maxSelected[i] != selected[i]) {
				return selected[i];
			}
		}
		return false;
	}
}