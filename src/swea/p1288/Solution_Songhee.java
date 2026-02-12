package swea.p1288;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_Songhee {
    public static void main(String[] args) throws FileNotFoundException {
        // N의 배수 양 세기. 언제 0-9 숫자 다 보는지

        System.setIn(new FileInputStream("songheeHong/sample_input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=1; i<T+1; i++) {
            int n = sc.nextInt();
            int[] numbers = new int[10];
            int count = 1; // 몇 배수인지

            while(true) {
                int mul = n * count;
                char[] arr = String.valueOf(mul).toCharArray();

                for(char a : arr) {
                    int index = Character.getNumericValue(a);
                    numbers[index]++;
                }

                int check = 0;

                for(int num : numbers) {
                    if(num > 0) {
                        check++;
                    }
                }

                if(check == 10) {
                    break;
                } else {
                    count++;
                }
            }

            System.out.println("#" + i + " " + (n*count));
        }
    }
}
