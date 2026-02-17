package swea.p1248;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_Songhee {

    static class Node {
        int parent; // 부모
        int left; // 이진트리라 무조건 두개
        int right;
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<T+1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken()); // 정점의 개수
            int e = Integer.parseInt(st.nextToken()); // 간선의 개수
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            Node[] list = new Node[v+1]; // 부모에서 자식

            for(int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if(list[from].left == 0) {
                    list[from].left = to;
                } else {
                    list[from].right = to;
                }

                list[to].parent = from;
            }

            // 가장 가까운 조상 번호, 서브 트리 크기
            System.out.println("#" + tc);
        }

    }
}
