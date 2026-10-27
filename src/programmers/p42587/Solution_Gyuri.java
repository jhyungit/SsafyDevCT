import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Process> pq = new PriorityQueue<>((a, b) -> b.priority - a.priority);
        Deque<Process> dq = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; ++i) {
            Process p = new Process(i, priorities[i]);
            pq.add(p);
            dq.add(p);
        }
        
        int ans = 1;
        while (true) {
            Process p = dq.pop();
            if (p.priority == pq.peek().priority) {
                if (p.id == location) return ans;
                else {
                    pq.poll();
                    ++ans;
                }
            }
            else {
                dq.add(p);
            }
        }
    }
    
    class Process {
        int id;
        int priority;
        
        Process(int id, int priority) {
            this.id = id;
            this.priority = priority;
        } 
    }
}