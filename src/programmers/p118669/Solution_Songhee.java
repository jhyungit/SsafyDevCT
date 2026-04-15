package programmers.p118669;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_Songhee {
    private static boolean[] isSummit;
    private static int[] intensity;
    private static final int INF = Integer.MAX_VALUE;
    private static PriorityQueue<Node> pq;
    private static List<List<Node>> graph;
    // 다익스트라

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];

            // 양방향
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        isSummit = new boolean[n + 1];
        for (int summit : summits) {
            isSummit[summit] = true;
        }

        intensity = new int[n + 1];
        Arrays.fill(intensity, INF);

        pq = new PriorityQueue<>();

        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensity[gate] = 0;
        }

        Arrays.sort(summits);

        int minSummit = -1;
        int minIntensity = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }

        return new int[]{minSummit, minIntensity};
    }

    static void dijkstra() {
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.to;
            int w = current.weight;

            if (w > intensity[u] || isSummit[u])
                continue;

            // 인접한 노드들 탐색
            for (Node next : graph.get(u)) {
                int v = next.to;
                int nextWeight = Math.max(w, next.weight);

                if (nextWeight < intensity[v]) {
                    intensity[v] = nextWeight;
                    pq.offer(new Node(v, nextWeight));
                }
            }
        }
    }
}
