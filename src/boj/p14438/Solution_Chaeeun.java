package boj.p14438;

// https://www.acmicpc.net/problem/14438
// BOJ 14438 수열과 쿼리 17
// Time: 588 ms
// Memory: 61,924 kb
// Approach: 세그먼트 트리를 활용한 지속 업데이트

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int a[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        SegmentTree segT = new SegmentTree(N);
        segT.init(a, 1, 0, N-1);
        
        M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (q == 1){
                a[i-1] = j;
                segT.update(1, 0, N-1, i-1, j);
            }
            else {
                sb.append(segT.min(1, 0, N-1, i-1, j-1)).append('\n');
            }
        }
        System.out.println(sb);
    }
}

class SegmentTree{
    int tree[];
    final int INF = Integer.MAX_VALUE;

    SegmentTree(int arrSize){
        int h = (int)Math.ceil(Math.log(arrSize) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new int[treeSize];
        Arrays.fill(tree, INF);
    }

    int init(int a[], int node, int start, int end){
        if (start == end){
            return tree[node] = a[start];
        }

        int mid = (start + end) / 2;
        tree[node] = Math.min(
            init(a, node * 2, start, mid),
            init(a, node * 2 + 1, mid + 1, end)
        );
        return tree[node];
    }

    int update(int node, int start, int end, int idx, int value){
        if (idx < start || end < idx){
            return tree[node];
        }

        if (start == end) {
            return tree[node] = value;
        }
        
        int mid = (start + end) / 2;
        return tree[node] = Math.min(
            update(node * 2, start, mid, idx, value),
            update(node * 2 + 1, mid + 1, end, idx, value)
        );
    }

    int min(int node, int start, int end, int left, int right){
        if (left > end || right < start){
            return INF;
        }

        if (left <= start && end <= right){
            return tree[node];
        }

        int mid = (start + end) / 2;
        return Math.min( 
            min(node*2, start, mid, left, right),
            min(node*2+1, mid + 1, end, left, right)
        );
    }
    
}
