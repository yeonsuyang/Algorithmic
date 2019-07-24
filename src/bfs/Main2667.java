package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 <그림 1>과 같이 정사각형 모양의 지도가 있다. 
 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. 
 <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 
 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9
 */
public class Main2667 {
	
	static int[][] input;
	static int[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		
	   Scanner sc  = new Scanner(System.in);
	   int N = sc.nextInt();
	   input = new int[N][N];
	   
	   for(int i=0;i<N;i++) {
		   for(int j=0;j<N;j++) {
			   input[i][j] = sc.nextInt();
		   }
	   }
	   
	   for(int i=0;i<N;i++) {
		   for(int j=0;j<N;j++) {
			   if(input[i][j] == 1 && visit[i][j] == 0) {
				   calculate(i,j);
			   }
		   }
	   }
	   
	   
	}
	private static void calculate(int y, int x) {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<Point>();
		
		visit[y][x] = 1;
		q.add(new Point(x,y));
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int hx = x + dx[i];
				int hy = y + dy[i];
				
			//	if()
				
			}
		}
	}
}


