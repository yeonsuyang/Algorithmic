/*
1 섬, 0 바다
지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다.


10
1 1 1 0 0 0 0 1 1 1 
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0

* * * 1 0 0 1 * * * 
* * * * 1 0 0 1 * *
* 1 * * 1 1 0 1 * *
1 1 * * * 1 0 0 1 *
0 0 1 * 1 0 0 0 1 *
0 0 0 1 0 0 0 0 1 *
0 0 0 0 1 1 0 0 0 1
0 0 0 0 * * 1 0 0 0
0 0 0 1 * * * 1 0 0
0 0 0 0 1 1 1 0 0 0

3
 */
package com.study.helloworld;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2146 {
	
	static int[] dx ={1,-1,0,0};
	static int[] dy ={0,0,1,-1};
	static int N;
	
	static int[][] input;
	static int[][] move;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //N*N
		input = new int[N][N];
		move = new int[N][N]; //몇개의 다리를 만들었나 셀 배열
		
		StringTokenizer st;
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				
				if(input[i][j] == 1){
					move[i][j] = -1;
					findZero(i,j); //0찾아서 주변을 먼저 다 1로 만들고..,
				}
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				
				if(move[i][j] == 1){
					Bridge(i,j); //0찾으러가기
				}
			}
		}

	}
	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2019. 2. 19.
	 * @param i
	 * @param j
	 */
	private static void findZero(int y, int x) {
		// TODO Auto-generated method stub
		for(int i=0; i<4; i++){
			int hx = x + dx[i];
			int hy = y + dy[i];
			
			if(input[hy][hx] == 0){//다녀간 적이 없으면.
				move[hy][hx] = 1; //섬 주변을 먼저 다 1로 만들고. 
				Bridge(hy,hx);
				
			}
		}
	}
	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2019. 2. 19.
	 */
	private static void Bridge(int y,int x) {
		// TODO Auto-generated method stub
		 Queue<Point> q = new LinkedList<Point>();
		 q.add(new Point(x,y));
		 
			while(!q.isEmpty()){
				Point p = q.poll();
				
				for(int k=0;k<4;k++){
					int hx = p.x+dx[k];
					int hy = p.y+dy[k];
					
					if(hx < 0 || hy< 0 || hx > N-1 || hy > N-1){
						continue;
					}
					if(move[hy][hx] != 0 || move[hy][hx] == -1){
						continue;
					}
					
					move[hy][hx] = move[y][x] + 1;
					q.add(new Point(hx,hy));
				}
				
			}
	}
}
