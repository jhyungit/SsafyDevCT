package programmers.p176962;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Solution_Bogyeong {
	private String[] names;
	private PriorityQueue<int[]> remainingTasks;
	
	public String[] solution(String[][] plans) {
		names = new String[plans.length];
		remainingTasks = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
		
		for (int i = 0; i < plans.length; i++) {
			names[i] = plans[i][0];
			// [index, start, playtime]
			int[] task = new int[3];
			task[0] = i;
			task[1] = convertTime(plans[i][1]);
			task[2] = Integer.parseInt(plans[i][2]);
			remainingTasks.offer(task);
		}
		
		String[] answer = new String[plans.length];
		schedule(answer);
        return answer;
    }

	private void schedule(String[] answer) {
		int i = 0;
		ArrayDeque<int[]> stoppedTasks = new ArrayDeque<int[]>();
		
		int[] task;
		int endTime, nextTime;
		while (!remainingTasks.isEmpty()) {
			task = remainingTasks.poll();
			
			endTime = task[1] + task[2];
			if (remainingTasks.isEmpty()) {
				nextTime = 24 * 60 + 1000 * 100;
			} else {
				nextTime = remainingTasks.peek()[1];
			}
			
			if (endTime > nextTime) {
				// [index, remainingTime]
				stoppedTasks.add(new int[] {task[0], endTime-nextTime});
			} else {
				answer[i++] = names[task[0]];
				while (endTime < nextTime && !stoppedTasks.isEmpty()) {
					int[] stoppedTask = stoppedTasks.pollLast();
					endTime += stoppedTask[1];
					if (endTime > nextTime) {
						stoppedTask[1] = endTime-nextTime;
						stoppedTasks.add(stoppedTask);
					} else {
						answer[i++] = names[stoppedTask[0]];
					}
				}
			}
		}
	}

	// "01:30" -> 90 (비교 연산이 쉽도록 단일 숫자 형태로 변환)
	private int convertTime(String strTime) {
		String[] splitTime = strTime.split(":");
		int hour = Integer.parseInt(splitTime[0]);
		int minute = Integer.parseInt(splitTime[1]);
		return hour*60+minute;
	}
}
