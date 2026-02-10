import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1228 {
	
	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int allOne = (1 << 10) - 1;
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int n = 0;
			testcase: for (int i = 1; i < 100; i++) {
				int tmp = N*i;
				while (tmp > 0) {
					n = n | (1 << (tmp % 10));
					if (n == allOne) {
						System.out.println("#"+t+" "+N*i);
						break testcase;
					}
					tmp /= 10;
				}
			}
		}
	}
}
