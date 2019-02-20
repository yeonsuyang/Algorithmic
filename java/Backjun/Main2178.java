package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
//이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//
//위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

//4 6
//101111
//101010
//101011
//111011

//15

public class Main2178 {
	
	static int[][] input;
	static boolean[][] visit;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, -1, 0, 1 };
    static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine());
	     
	     N = Integer.parseInt(st.nextToken()); //세로
	     M = Integer.parseInt(st.nextToken()); //가로
	     
	    input = new int[N+1][M+1];
	    visit = new boolean[N+1][M+1];
	     
	     for(int i=1; i<= N;i++) {
	    	 st = new StringTokenizer(br.readLine());
	    	 System.out.println(" i : " + i);
	    	 for(int j=1;j<=M;j++) {
	    		 input[i][j] = Integer.parseInt(st.nextToken()); //입력받음
	    	 }
	     }
	     
	    Arrays.fill(visit, false);
	    visit[1][1] = true;
	    bfs(1,1);
	     
	}

	private static void bfs(int y, int x) {
		// TODO Auto-generated method stub
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x,y));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			
			for(int i=0; i<4;i++) {
				int hx = d.x + dx[i];
				int hy = d.y + dy[i];
				

				if(hx < 1 || hy < 1 || hx > M || hy > N) {
					continue;
				}
				
				if(visit[hy][hx] || input[hy][hx] == 0) { //방문안함
				   continue;
				}
				
				q.add(new Dot(hx,hy));
			    input[hy][hx] = input[d.y][d.x] + 1;
			    visit[hy][hx] = true;
				
			}

		}
		
	}
}
//
//class Dot{
//	int x;
//	int y;
//	
//	Dot(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
