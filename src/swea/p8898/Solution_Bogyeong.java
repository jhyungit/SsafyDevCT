package swea.p8898;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_Bogyeong {
     
    static int N, M, c, d, cnt;
    static int[] cow;
    static int[] horse;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken());
            if (c < 0) {
                c = -c;
            }
             
            cow = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cow[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cow);
            horse = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                horse[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(horse);
             
            d = Integer.MAX_VALUE;
            cnt = 0;
            diff();
            System.out.println("#"+t+" "+d+" "+cnt);
        }
    }
 
    private static void diff() {
        int ci = 0, hi = 0;
        while (ci < N && hi < M) {
            checkMin(c + distZ(cow[ci], horse[hi]));
             
            if (cow[ci] > horse[hi]) {
                hi++;
            } else {
                ci++;
            }
        }
    }
 
    private static void checkMin(int nd) {
        if (d > nd) {
            d = nd;
            cnt = 1;
        } else if (d == nd) {
            cnt++;
        }
    }
     
    private static int distZ(int z1, int z2) {
        return Math.abs(z2-z1);
    }
 
}
