package swea.p4038;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_Bogyeong {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			String target = br.readLine().trim();
			String pattern = br.readLine().trim();
			
			int n = target.length();
			int m = pattern.length();
			
			int[] lps = findLPS(pattern);
			
		    int result = 0;
			int i = 0, j = 0;
		    while (i < n) {
		        if (target.charAt(i) == pattern.charAt(j)) {
		            i++;
		            j++;
		        }

		        if (j == m) {
		            result++;
		            j = lps[j - 1];
		            continue;
		        }
		        if (i < n && target.charAt(i) != pattern.charAt(j)) {
		            if (j != 0) {
		                j = lps[j - 1];
		            } else {
		                i++;
		            }
		        }
		    }
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static int[] findLPS(String s) {
		int m = s.length();
		int[] lps = new int[m];
		
		int num = 0;
		int i = 1;
		while (i < m) {
			if (s.charAt(i) == s.charAt(num)) {
				lps[i++] = ++num;
				continue;
			}
			
			if (num == 0) {
				lps[i++] = 0;
				continue;
			}
			num = lps[num-1];
		}
		
		return lps;
	}

	
}
