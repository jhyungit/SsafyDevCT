package programmers.p118669;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution_Bogyeong {

    private int n;
    private ArrayList<int[]>[] adjList;
    private HashSet<Integer> gateSet, summitSet;
    private final int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.n = n;

        gateSet = new HashSet<Integer>();
        for (int i = 0; i < gates.length; i++) {
            gateSet.add(gates[i]);
        }
        summitSet = new HashSet<Integer>();
        for (int i = 0; i < summits.length; i++) {
            summitSet.add(summits[i]);
        }

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < paths.length; i++) {
            adjList[paths[i][0]].add(new int[]{paths[i][1], paths[i][2]});
            adjList[paths[i][1]].add(new int[]{paths[i][0], paths[i][2]});
        }

        Arrays.sort(summits);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < summits.length; i++) {
            int result = dijkstra(summits[i], pq);
            if (result < answer[1]) {
                answer[0] = summits[i];
                answer[1] = result;
            }
        }

        return answer;
    }

    private int dijkstra(int start, PriorityQueue<int[]> pq) {
        pq.clear();
        pq.offer(new int[]{start, 0});

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int v = node[0];
            int w = node[1];

            if (answer[1] < w)
                break;
            if (visited[v])
                continue;
            if (gateSet.contains(v))
                return w;

            for (int[] next : adjList[v]) {
                int nv = next[0];
                int nw = next[1];

                if (summitSet.contains(nv))
                    continue;

                pq.offer(new int[]{nv, Integer.max(nw, w)});
            }
            visited[v] = true;
        }

        return Integer.MAX_VALUE;
    }
}
