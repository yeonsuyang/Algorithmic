package study;
// 빈 .
// 울타리 #
// 양 O
// 늑대 v
// 양의 수 > 늑대 : 양 win 

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3184 {
	static char[][] input;
	static boolean[][] visit;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int ans_wolf,ans_sheep;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		 Scanner sc = new Scanner(System.in);
	     N = sc.nextInt();//세로
	     M = sc.nextInt();//가로
	     
	     input = new char[N][M];
	     visit = new boolean[N][M]; //방문했는지 
	     
	     for(int i=0; i< N;i++) {
	    	 String st = sc.next();
	    	 for(int j=0;j<M;j++) {
	    		 input[i][j] = st.charAt(j); //받았어
	    	 }
	     }
	     
	     for(int i=0;i<N;i++) {
	    	 for(int j=0;j<M;j++) {
	    		 if((input[i][j] == 'o' || input[i][j] == 'v') && visit[i][j] != true) { //양이나 늑대면서 방문하지 않았으면
	    			 visit[i][j] = true;
	    			 bfs(i,j);
	    		 }
	    	 }
	     }
	     
	     
	     System.out.println(ans_sheep + " " + ans_wolf);
	     
	}

	private static void bfs(int y, int x) {
		// TODO Auto-generated method stub
		Queue<Dot> q = new LinkedList<Dot>();
		int wolf = 0, sheep = 0;
		
		q.add(new Dot(x,y)); //방문해야 할 점을 큐에 넣어주기 
		
		if(input[y][x] == 'v') {
			wolf++;
		}else if(input[y][x] == 'o') {
			sheep++;
		}
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			
			for(int i=0; i<4;i++) {
				int hx = d.x + dx[i];
				int hy = d.y + dy[i];
				

				if(hx < 0 || hy < 0 || hx > M || hy > N) {
					continue;
				}
				
				if(visit[hy][hx] || input[hy][hx] == '#') { //방문안함
				   continue;
				}
				
				q.add(new Dot(hx,hy));
			    visit[hy][hx] = true;
			    if(input[hy][hx] == 'v') {
					wolf++;
				}else if(input[hy][hx] == 'o') {
					sheep++;
				}
				
			}

		}
		
		if(wolf >= sheep) { //늑대가 많거나 같으면
			ans_wolf += wolf; 
		}else { //양이 더 많으면 양의 승.	s
			ans_sheep += sheep;
		}
		
	}
}

class Dot{
	int x;
	int y;
	
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}