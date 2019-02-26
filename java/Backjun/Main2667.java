/*
 * 
 * 
1은 집이 있는 곳을, 0은 집이 없는 곳
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.

첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오

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
package com.study.helloworld;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2667 {
	
	static int N = 0;
	static int count = 0;
	static int[][] input;
	static int[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[N][N];
		visit = new int[N][N];
		
		for(int i=0;i<N;i++){
			String st = sc.next();
			for(int j=0;j<N;j++){
				input[i][j] = st.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(input[i][j] == 1 && visit[i][j] == 0){
					calculate(i,j);
				}
			}
		}
		
		int[] ans = new int[count];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(input[i][j] != 0){
					ans[input[i][j]-1]++;
				}
			}
		}

		Arrays.sort(ans);
		System.out.println(ans.length);
		for(int i=0;i<ans.length;i++){
			System.out.println(ans[i]);
		}
	}


	private static void calculate(int y, int x) {
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
}
