package swea.p1248; //공통조상
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD&

import java.io.*;
import java.util.*;


public class Solution_Jeonghyun{
	static int T,V,E;
	static int[] Parent;
	static List<List<Integer>> SubTree;
	
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			Parent = new int[V+1];
			
			SubTree = new ArrayList<>();
			// 내부를 ArrayList로 초기화 즉 [[],[],[]] 형태
			for(int i = 0; i<= V; i++) {
				SubTree.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int v = 0; v<E; v++) {
				// p 부모, c 자식
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				Parent[c] = p;
				SubTree.get(p).add(c); //서브트리 미리 구해놓기(시간 복잡도 감소)
			}
			
			int subRoot = findSubRoot(v1,v2);
			int subSize = countSubtree(subRoot);
			System.out.println("#"+tc+" "+subRoot+" " + subSize);
		}
		
	}
	
	static int findSubRoot(int v1, int v2) {
		boolean[] visited = new boolean[V+1];
		
		while(v1 != 0) { // 루트까지 방문하며 true처리 
			visited[v1] = true;
			v1 = Parent[v1];
		}
		
		while(!visited[v2]) { // 루트까지 가는  길에 처음 만난 true위치의 노드 반환 
			v2 = Parent[v2];
		}
		
		return v2;	
	}
	
	static int countSubtree(int root) {
		int cnt = 1; //자기 자신포함
		
		
		for(int child: SubTree.get(root)) {
			cnt += countSubtree(child); 
		}
		return cnt;
	}

}

//2
//13 12 8 13
//1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 10 6 11 11 13
//10 9 2 10
//1 2 1 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10

//#1 3 8
//#2 1 10
