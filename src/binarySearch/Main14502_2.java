package binarySearch;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
연구소는 크기가 N×M인 직사각형
일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 
새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)
둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 
0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.
빈 칸의 개수는 3개 이상이다.

7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

27

4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

9

8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0

3
 */
public class Main14502_2 {
	
	static int[][] input;
	static int[][] visit;
	static int[][] copyInput;
	static int[][] copyVisit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N;
	static int M;
	static int ans = -1;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로 
		M = Integer.parseInt(st.nextToken()); //가로
		input = new int[N][M];
		visit = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				input[i][j] = Integer.parseInt(st.nextToken()); //input 받기 
			}
		}
		
		//벽 3 세우기.
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(input[i][j] == 0 && visit[i][j] == 0) {//빈칸이면서 방문한 적이 없으면 
					input[i][j] = 1;
					visit[i][j] = 1;
					createWall(1); //벽 갯수와 함께 보내기.
					input[i][j] = 0;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void createWall(int countWall) {
		
		if(countWall > 3) {
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(input[i][j] == 0 && visit[i][j] == 0) {//빈칸이면서 방문한 적이 없으면 
					input[i][j] = 1;
					if(countWall == 2) {
						copyInput();//바이러스뿌리러가기.
					}else {
						createWall(countWall + 1); //벽 갯수와 함께 보내기.
					}
					input[i][j] = 0;
				}
			}
		}
		
	}

	private static void copyInput() {
		copyInput = new int[N][M];
		copyVisit = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyInput[i][j] = input[i][j];
			}
		}
		
		//바이러스뿌리기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyInput[i][j] == 2 && copyVisit[i][j] == 0) {
					copyVisit[i][j] = 1;
					spreadVirus(i,j);
				}
			}
		}
		
		int safeZone = 0;
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copyInput[i][j] == 0) {
					safeZone++;
				}
			}
		}
		//개수세기 안정영역의 최대값 구하기 
		
		if(ans == -1 || ans < safeZone) {
			ans = safeZone;
		}
	}

	private static void  spreadVirus(int y, int x) {
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int hy = p.y + dy[i];
				int hx = p.x + dx[i];
				
				if(hy < 0 || hx < 0 || hy > N-1 || hx > M-1) {
					continue;
				}
				
				if(input[hy][hx] == 1 || copyVisit[hy][hx] == 1) {
					continue;
				}
				
				q.add(new Point(hx,hy));
				copyInput[hy][hx] = 2;
				copyVisit[hy][hx] = 1;
			}
		}
	}
}
