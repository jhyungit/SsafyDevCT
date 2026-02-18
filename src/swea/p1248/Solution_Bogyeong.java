package swea.p1248;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_Bogyeong {

	static int V, E, n1, n2, num;
	static Node node1, node2, root;
	static HashMap<Integer, Node> nodeMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		nodeMap = new HashMap<Integer, Node>();
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			
			// 간선 입력받아 저장
			nodeMap.clear();
			root = new Node(1);
			nodeMap.put(root.value, root);
			st = new StringTokenizer(br.readLine());
			int n;
			Node parent, child;
			for (int i = 0; i < E; i++) {
				n = Integer.parseInt(st.nextToken());
				parent = getOrMake(n);
				n = Integer.parseInt(st.nextToken());
				child = getOrMake(n);
				child.parent = parent;
				parent.setChild(child);
			}
			
			Node common = findCommon();
			num = 0;
			childNum(common);
			System.out.println("#"+t+" "+common.value+" "+num);
		}
	}

	private static Node getOrMake(int n) {
		Node node = nodeMap.get(n);
		if (node != null) {
			return node;
		}
		node = new Node(n);
		nodeMap.put(node.value, node);
		
		if (n == n1) {
			node1 = node;
		} else if (n == n2) {
			node2 = node;
		}

		return node;
	}

	private static Node findCommon() {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(node1.value);
		set.add(node2.value);
		Node n1 = node1, n2 = node2;
		while (n1.parent != null && n2.parent != null) {
			n1 = n1.parent;
			if (set.contains(n1.value)) {
				return n1;
			}
			set.add(n1.value);
			n2 = n2.parent;
			if (set.contains(n2.value)) {
				return n2;
			}
			set.add(n2.value);
		}
		while (n1.parent != null) {
			n1 = n1.parent;
			if (set.contains(n1.value)) {
				return n1;
			}
			set.add(n1.value);
		}
		while (n2.parent != null) {
			n2 = n2.parent;
			if (set.contains(n2.value)) {
				return n2;
			}
			set.add(n2.value);
		}
		return root;
	}

	private static void childNum(Node node) {
		num++;
		if (node.left == null) {
			return;
		}
		childNum(node.left);
		if (node.right == null) {
			return;
		}
		childNum(node.right);
	}

}

class Node {
	Node parent;
	Node left;
	int value;
	Node right;
	
	public Node(int value) {
		this.parent = null;
		this.left = null;
		this.value = value;
		this.right = null;
	}
	
	void setChild(Node node) {
		if (left == null) {
			left = node;
			return;
		}
		
		right = node;
	}
}