package swea.p1288;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution_Bogyeong {
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String allNum = "0123456789";
         
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            String s = allNum;
            for (int i = 1; i < 100; i++) {
                int number = n * i;
                s = s.replaceAll(toRegex(number), "");
                if (s.length() == 0) {
                    System.out.println("#"+t+" "+number);
                    break;
                }
            }
        }
    }

    private static String toRegex(int number) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(number).append("]");
        return sb.toString();
    }
}
