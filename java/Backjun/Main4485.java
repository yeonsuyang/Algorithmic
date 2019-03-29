/*
링크 위치 : [0][0]번 칸
제일 오른쪽 아래 칸인 [N-1][N-1]까지 이동해야 한다. 

이 칸을 지나면 해당 도둑루피의 크기만큼 소지금을 잃게 된다. 
링크는 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 하며, 
한 번에 상하좌우 인접한 곳으로 1칸씩 이동할 수 있다.

링크가 잃을 수밖에 없는 최소 금액은?

입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스의 첫째 줄에는 동굴의 크기를 나타내는 정수 N이 주어진다. 
(2 ≤ N ≤ 125) N = 0인 입력이 주어지면 전체 입력이 종료된다.

이어서 N개의 줄에 걸쳐 동굴의 각 칸에 있는 도둑루피의 크기가 공백으로 구분되어 차례대로 주어진다.
 도둑루피의 크기가 k면 이 칸을 지나면 k루피를 잃는다는 뜻이다. 여기서 주어지는 모든 정수는 0 이상 9 이하인 한 자리 수다.


3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0

Problem 1: 20
Problem 2: 19
Problem 3: 36
 */
package com.study.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4485 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int count = 0;

		while (n != 0) {

			count++;

			int[][] input = new int[n][n];
			int[][] lost = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(lost[i], -1);
			}

			int ans = calculate(input, lost, n);
			System.out.println("Problem " + count + ": " + ans);

			n = Integer.parseInt(br.readLine());
		}

	}

	private static int calculate(int[][] input, int[][] lost, int n) {
		// TODO Auto-generated method stub
		PriorityQueue<NodeD> pq = new PriorityQueue<NodeD>();
		
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		lost[0][0] = input[0][0];
		
		pq.add(new NodeD(0,0,lost[0][0]));

		while(!pq.isEmpty()){
			NodeD d = pq.poll();
			
			for(int i=0;i<4;i++){
				int hx = d.x + dx[i];
				int hy = d.y + dy[i];
				
				if(hx < 0 || hy < 0 || hy > n-1 || hx > n-1){
					continue;
				}
				
				if(lost[hy][hx] != -1 && d.cost + input[hy][hx] >= lost[hy][hx]){ //이미 값이 있는데 지금 비용이 더크면 패스
					continue;
				}
				
				lost[hy][hx] = d.cost + input[hy][hx];
				pq.add(new NodeD(hx,hy,lost[hy][hx]));
			}
			
		}
		
		return lost[n-1][n-1];
	}
}

class NodeD implements Comparable<NodeD>
{
	int x;
	int y;
	int cost;
	
	NodeD(int x, int y, int cost){
		this.y = y; 
		this.x = x;
		this.cost = cost; 
	}
	
	@Override
	public int compareTo(NodeD o) {
		return this.cost - o.cost;
	}
}