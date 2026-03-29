package boj.p5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '<') {
                    if (curr.prev != null)
                        curr = curr.prev;
                } else if (c == '>') {
                    if (curr.next != null)
                        curr = curr.next;
                } else if (c == '-') { // 직전 단어 삭제
                    if (curr.prev != null)
                        curr.prev.next = curr.next;
                    if (curr.next != null)
                        curr.next.prev = curr.prev;
                    curr = curr.prev;
                } else {
                    Node node = new Node();
                    node.word = c;
                    node.prev = curr;

                    if (curr.next != null) {
                        curr.next.prev = node;
                    }
                    curr.next = node;
                    curr = node;
                }
            }
        }
    }
}
