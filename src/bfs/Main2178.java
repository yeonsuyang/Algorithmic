package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


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
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N,M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//세로
		M = sc.nextInt();//가로

		input = new int[N][M];
		visit = new boolean[N][M]; //방문했는지

		for(int i=0; i< N;i++) {
			String st = sc.next();
			for(int j=0;j<M;j++) {
				input[i][j] = st.charAt(j)-'0'; //받았어
			}
		}

		bfs(0,0);
		System.out.println(input[N-1][M-1]);
	}

	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y,x));
		visit[y][x] = true;

		while(!q.isEmpty()){
			Point p = q.poll();

			for(int i=0;i<4;i++){
				int hx = p.x + dx[i];
				int hy = p.y + dy[i];

				if(hx<0 || hy <0 || hx > M-1 || hy > N-1){
					continue;
				}
				if(visit[hy][hx] || input[hy][hx] == 0){
					continue;
				}
				q.add(new Point(hx,hy));
				visit[hy][hx] = true;
				input[hy][hx] = input[p.y][p.x] + 1;
			}
		}

	}
}
