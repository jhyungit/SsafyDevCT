package boj.p14438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 : 64252kb
// 시간 : 612ms
public class Solution_Songhee {

    private static int N;
    private static int[] tree;
    private static int[] nums;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); // 수열 개수
        nums = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 쿼리 개수
        tree = new int[N*4];
        init(1, 1, N); // 초기 트리

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken()); // 1 이면 바꾸기, 2면 출력
            int index = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(type == 1) {
                update(1, 1, N, index, v);
            } else {
                sb.append(query(1, 1, N, index, v)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int init(int node, int start, int end) { // node: 현재 노드 번호 / start, end: 현재 노드가 담당하는 원본 배열의 인덱스 범위
        // 리프 노드 (대진표 맨 밑바닥, 1라운드 참가자)
        if (start == end) {
            return tree[node] = nums[start];
        }

        int mid = (start + end) / 2;
        // 왼쪽 자식과 오른쪽 자식 중 '더 작은 값(최솟값)'을 부모인 내가 가집니다.
        return tree[node] = Math.min(
                init(node * 2, start, mid),
                init(node * 2 + 1, mid + 1, end)
        );
    }

    // 구간 최솟값 구하기
    static int query(int node, int start, int end, int left, int right) {
        // 구간을 완전히 벗어난 경우 (최솟값에 영향을 주지 않는 큰 값 반환)
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        // 구하려는 구간 내에 완전히 포함되는 경우
        if (left <= start && end <= right) {
            return tree[node];
        }
        // 걸쳐있는 경우 반으로 나누어 탐색
        int mid = (start + end) / 2;
        return Math.min(query(node * 2, start, mid, left, right),
                query(node * 2 + 1, mid + 1, end, left, right));
    }

    // 특정 인덱스 값 변경
    static int update(int node, int start, int end, int index, int val) {
        // 변경할 인덱스가 구간 밖이면 현재 트리 값 그대로 반환
        if (index < start || index > end) {
            return tree[node];
        }
        // 리프 노드(단일 값)에 도달하면 값 업데이트
        if (start == end) {
            return tree[node] = val;
        }
        // 자식 노드들을 업데이트한 후, 현재 노드의 최솟값도 다시 갱신
        int mid = (start + end) / 2;
        return tree[node] = Math.min(update(node * 2, start, mid, index, val),
                update(node * 2 + 1, mid + 1, end, index, val));
    }

}
