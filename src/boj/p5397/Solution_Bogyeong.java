package boj.p5397;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_Bogyeong {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			LinkedList password = new LinkedList();
			char[] chars = br.readLine().trim().toCharArray();
			for (char c : chars) {
				switch (c) {
				case '<':
					password.moveFront();
					break;
				case '>':
					password.moveBack();
					break;
				case '-':
					password.removeFront();
					break;
				default:
					password.addNext(c);
					break;
				}
			}
			
			System.out.println(password);
		}
	}

	private static class LinkedList {
		Node head;
		Node tail;
		Node cur;
		
		public LinkedList() {
			head = new Node(' ');
			tail = new Node(' ');
			
			head.next = tail;
			tail.pre = head;
			
			cur = head;
		}
		
		public void addNext(char data) {
			Node newNode = new Node(data);
			Node next = cur.next;
			
			cur.next = newNode;
			newNode.pre = cur;
			
			next.pre = newNode;
			newNode.next = next;
			
			cur = newNode;
		}
		
		public void moveFront() {
			if (cur == head) {
				return;
			}
			
			cur = cur.pre;
		}
		
		public void moveBack() {
			if (cur.next == tail) {
				return;
			}
			
			cur = cur.next;
		}
		
		public void removeFront() {
			if (cur == head) {
				return;
			}
			
			Node pre = cur.pre;
			Node next = cur.next;
			
			pre.next = next;
			next.pre = pre;
			
			cur = pre;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			Node cur = head.next;
			while (cur != tail) {
				sb.append(cur.data);
				cur = cur.next;
			}
			
			return sb.toString();
		}

		private static class Node {
			Node pre;
			char data;
			Node next;
			
			public Node(char data) {
				this.pre = null;
				this.data = data;
				this.next = null;
			}
		}
	}
}
