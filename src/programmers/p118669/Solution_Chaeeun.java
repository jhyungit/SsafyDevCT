package programmers.p118669;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution_Chaeeun {
    final int INF = 1_000_000_000;

    PriorityQueue<State> pq = new PriorityQueue<>();
    List<Node>[] graph;

    int[] distance;
    boolean[] visited, isGate, isSummit;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];

        Arrays.fill(distance, INF);
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : paths) {
            int v = edge[0];
            int u = edge[1];
            int w = edge[2];

            graph[v].add(new Node(u, w));
            graph[u].add(new Node(v, w));
        }

        for (int s : summits) {
            isSummit[s] = true;
        }

        for (int g : gates) {
            isGate[g] = true;

            distance[g] = 0;
            pq.add(new State(g, 0));
        }

        dijkstra();

        Arrays.sort(summits);
        int[] answer = {-1, INF};
        for (int s : summits) {
            if (distance[s] < answer[1]) {
                answer = new int[]{s, distance[s]};
            }
        }

        return answer;
    }

    void dijkstra() {
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int ct = cur.target;
            int cw = cur.weight;

            if (visited[ct])
                continue;
            visited[ct] = true;
            if (isSummit[ct])
                continue;

            for (Node next : graph[ct]) {
                int nt = next.target;
                int nw = next.weight;
                if (isGate[nt])
                    continue;
                if (distance[nt] > Math.max(distance[ct], nw)) {
                    distance[nt] = Math.max(distance[ct], nw);
                    pq.add(new State(nt, distance[nt]));
                }
            }
        }
    }

    class State implements Comparable<State> {
        int target;
        int weight;

        State(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(State s) {
            return Integer.compare(this.weight, s.weight);
        }
    }

    class Node {
        int target;
        int weight;

        Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
