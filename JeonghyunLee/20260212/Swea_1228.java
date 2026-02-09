package swea;

import java.io.*;
import java.util.*;

//새로운 불면증 치료법
public class Solution_1288{
	public static void main(String[] args)  throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine().trim());
		
		for(int i=1; i<=test_case; i++) {
			int n = Integer.parseInt(br.readLine().trim()); // 입력한 숫자
			int k = 1;
			
			Set<Character> set = new HashSet<>();
			
			while(set.size()!=10) {
				int kn = n*k++;
				String numString = String.valueOf(kn);
				
				for(int j = 0; j < numString.length(); j++) {
					char c = numString.charAt(j);
						set.add(c);
				}
			}
			System.out.println("#"+i+" "+ ((n*k)-n));
		}

	}

}

//5
//1
//2
//11
//1295
//1692

//#1 10
//#2 90
//#3 110
//#4 6475
//#5 5076
