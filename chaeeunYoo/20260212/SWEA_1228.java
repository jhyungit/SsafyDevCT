import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1228 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int SIZE = 10;
	static boolean visited[] = new boolean[SIZE];
	static long N;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			sb.append('#').append(t).append(' ').append(countSheep()).append('\n');
		}
		System.out.println(sb);	
	}
	
	static long countSheep() {
		Arrays.fill(visited, false);
		long now = 0;
		int seen = 0;
		
		while(seen < 10) {
			now += N; 
			long temp = now; 
			while(temp > 0) {
				int last = (int) (temp % 10);
				temp /= 10;
				if (visited[last]) continue;
				visited[last] = true;
				seen ++;
			}
		}
		
		return now;
	}
}
