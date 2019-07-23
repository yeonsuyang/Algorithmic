package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1260 {
//	
//	그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
//	단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
//	더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//	
//	첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
//	다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다
//	
//	첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
	 public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 int N = sc.nextInt(); //정점의 개수
		 int M = sc.nextInt(); //간선의 개수
		 int V = sc.nextInt(); //탐색을 시작할 정점의 번호 
		 
		 int[][] a = new int[N+1][N+1];
		 
		for(int i=0;i<M;i++) {
			int k = sc.nextInt();
			int j = sc.nextInt();
			
			a[k][j] = 1; //이어진 곳이 1 
			a[j][k] = 1;
		}
		
		boolean[] c = new boolean[N+1];
		
		dfs(V,c,a); //dfs(1,a);
		Arrays.fill(c, false);
		System.out.println("");
		bfs(V,c,a);
		
	}

	private static void bfs(int v, boolean[] c, int[][] a) {
		// TODO Auto-generated method stub
		
		Queue<Integer> q = new LinkedList<>();

		int n = a.length -1 ;
		q.add(v);
	    c[v] = true;
		
	    while(!q.isEmpty()) {
	    	
	    	v = q.poll(); //꺼내온다 없으면. null;
	    	System.out.print(v + " ");
	    	
	    	for(int i=1;i<=n;i++) {
	    		
	    		if(a[v][i] == 1 && !c[i]) {
	    			q.add(i);
	    			c[i] = true;
	    		}
		    }
	    	
	    }
		
	}
	
	
	private static void dfs(int v, boolean[] c, int[][] a) {
		// TODO Auto-generated method stub
		
		int n = a.length -1 ; 
		c[v] = true;
		
		System.out.print(v+" ");
		
		for(int i=1;i<=n;i++) {
				//2때 1이 되겠지?
			if(a[v][i] == 1 && !c[i]) {
				dfs(i,c,a); //dfs(2,c,a);;
			}
		}
	}
}
