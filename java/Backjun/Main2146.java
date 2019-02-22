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

3
 */
package com.study.helloworld;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2146 {
	
	static int[] dx ={1,-1,0,0};
	static int[] dy ={0,0,1,-1};
	static int N = 0;
	
	static int[][] input;
	static int[][] move;
	static int[][] visit;
	static int count = 0;
	static int ans = -1;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //N*N
		input = new int[N][N];
		visit = new int[N][N];
		
		StringTokenizer st;
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				
				if(input[i][j] == 1 && visit[i][j] == 0){
					divide(i,j); //영역을 나누고
				}
			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(input[i][j] != 0){
					Bridge(i,j); //찾으러가기
				}
			}
		}
		
		System.out.println(ans);

	}

	private static void divide(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		
		visit[y][x] = 1;
		q.add(new Point(x,y));
		count++;
		input[y][x] = count;
		
		while(!q.isEmpty()){
			Point p = q.poll();
			
			for(int i=0;i<4;i++){
				int hy = p.y + dy[i];
				int hx = p.x + dx[i];
				
				if(hy < 0 || hx < 0 || hy > N-1 || hx > N-1){
					continue;
				}
				
				if(input[hy][hx] == 0 || visit[hy][hx] == 1){
					continue;
				}
				
				q.add(new Point(hx,hy));
				visit[hy][hx] = 1;
				input[hy][hx] = count;
			}
		}
	}	
	
	private static void Bridge(int y,int x) {
		// TODO Auto-generated method stub

		
		for(int i=0;i<4;i++){ // 둘러보다가 
			
			int cx = x+dx[i];
			int cy = y+dy[i];
			
			if(cx < 0 || cy< 0 || cx > N-1 || cy > N-1){
				continue;
			}
		
			if(input[cy][cx] == 0){//다른 다리를 찾아 나서기 
				 visit = new int[N][N];
				 move = new int[N][N];//몇개의 다리를 만들었나 셀 배열
				 
				 Queue<Point> q = new LinkedList<Point>();
				 q.add(new Point(cx,cy));
				 visit[cy][cx] = 1;
				 move[cy][cx] = 1;
				 
					while(!q.isEmpty()){
						Point p = q.poll();
						
						for(int k=0;k<4;k++){
							int hx = p.x+dx[k];
							int hy = p.y+dy[k];
							
							if(hx < 0 || hy< 0 || hx > N-1 || hy > N-1){
								continue;
							}
							if(input[hy][hx] == input[y][x] || visit[hy][hx] != 0){ //같은 다리니까 그냥 지나치기
								continue;
							}
							
							if(input[hy][hx] != 0 && input[hy][hx] != input[cy][cx]){
								if(ans == -1 || ans > move[p.y][p.x]){
									ans = move[p.y][p.x];
								}
							}else{
								int mov = move[p.y][p.x] + 1;
								move[hy][hx] = mov; //디버깅 끝나면 변경
								q.add(new Point(hx,hy));
								visit[hy][hx] = 1;
							}
						}
						 
					}
			}
		}
	}
}
