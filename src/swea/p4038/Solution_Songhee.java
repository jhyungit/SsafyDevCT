package swea.p4038;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_Songhee {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int t=1; t<test+1; t++) {
            String book = br.readLine();
            String word = br.readLine();
            int count = 0;

            for (int i = 0; i <= book.length() - word.length(); i++) {
                int tmp = 0;
                for (int j = 0; j < word.length(); j++) {
                    if(book.charAt(i+j) == word.charAt(j)) {
                        tmp++;
                    } else {
                        break;
                    }
                }

                if(tmp == word.length()) {
                    count++;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
