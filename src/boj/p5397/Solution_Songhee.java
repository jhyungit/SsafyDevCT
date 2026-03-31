package boj.p5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 : 122664KB
// 시간 : 516ms
public class Solution_Songhee {
    static class Node {
        char word;
        Node prev;
        Node next;
    }

    static Node curr;
    static Node start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            start = new Node(); // 빈값
            start.word = ' ';
            curr = start;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '<') {
                    if (curr != start) // prev로 체크말고 start 아닐 경우에만
                        curr = curr.prev;
                } else if (c == '>') {
                    if (curr.next != null)
                        curr = curr.next;
                } else if (c == '-') { // 직전 단어 삭제
                    if (curr != start) {
                        curr.prev.next = curr.next;
                        if (curr.next != null)
                            curr.next.prev = curr.prev;
                        curr = curr.prev;
                    }
                } else {
                    Node node = new Node();
                    node.word = c;
                    node.prev = curr;

                    if (curr.next != null) {
                        node.next = curr.next;
                        curr.next.prev = node;
                    }
                    curr.next = node;
                    curr = node;
                }
            }

            StringBuilder sb = new StringBuilder();

            Node n = start.next;
            while (n != null) {
                sb.append(n.word);
                n = n.next;
            }

            System.out.println(sb);
        }
    }
}
