package dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1916 {
	
	static int city;
	static int[][] cost;
	static int[] cal;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		city = sc.nextInt();
		int bus = sc.nextInt();
		
		cost = new int[city+1][city+1];
		cal = new int[city+1];
		
		Arrays.fill(cal, -1);
		
		for(int i=0;i<bus;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			int temp = sc.nextInt();
			if(cost[start][end] == 0 || cost[start][end] > temp) {
				cost[start][end] = temp;
			}
		}//그래프를 다 입력 받고
		
		int ansStart = sc.nextInt();
		int ansEnd = sc.nextInt();
		

		calculate(ansStart);
		
		
		System.out.println(cal[ansEnd]);
		
	}

	private static void calculate(int start) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(start);
		cal[start] = 0;
		
		while(!q.isEmpty()) {
			int startPoint = q.poll();
			
			for(int i=1;i<=city;i++) {
				if(cost[startPoint][i] != 0 &&  (cal[i] == -1  || cal[i] > cal[startPoint]+cost[startPoint][i])) { //값이 아직 없거나. 더한 값이 더 작으면
					cal[i] = cal[startPoint]+cost[startPoint][i];
					q.add(i);
				}
                 if(i==city && cal[i] == -1) {
			    	cal[i] = 0;
			    }
			}
			
			
		}
	}
}
