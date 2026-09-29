package programmers.p43163;

import java.util.*;

class Solution_Chaeeun {

    List<List<Integer>> graph;

    public int solution(String begin, String target, String[] words) {
        String[] Allwords = Arrays.copyOf(words, words.length + 1);
        Allwords[Allwords.length - 1] = begin;

        makeGraph(Allwords);

        return bfs(Allwords, target);
    }

    // 한 글자만 다른 단어를 그래프로 연결
    void makeGraph(String[] words) {
        int n = words.length;
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = 0;

                for (int k = 0; k < words[i].length(); k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        diff++;
                    }

                    if (diff > 1) {
                        break;
                    }
                }

                if (diff == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
    }

    int bfs(String[] words, String target) {
        Queue<Integer> queue = new ArrayDeque<>();

        int[] distance = new int[words.length];
        Arrays.fill(distance, -1);

        int start = words.length - 1;

        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (words[current].equals(target)) {
                return distance[current];
            }

            for (int next : graph.get(current)) {
                if (distance[next] != -1) {
                    continue;
                }

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }
        
        return 0;
    }
}
