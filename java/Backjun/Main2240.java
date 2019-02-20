package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2240 {
	
	static int[] namu;
	static int[][] dp;
	static int T,W;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		namu = new int[T+1];
		dp = new int[T+1][W+1];
		
		for(int i=1;i<=T;i++) {
			namu[i] = Integer.parseInt(br.readLine());
			Arrays.fill(dp[i], -1);
		}
		System.out.println(Math.max(calculate(1,0), calculate(1,1)));
	}

	private static int calculate(int start, int turn) {
		
		if(start+1 > T+1) {
			return 0;
		}
		
		if(turn > W) {
			return 0;
		}

		if(dp[start][turn] != -1) {
			return dp[start][turn];
		}
		
		int where = 1;
		if(turn % 2 != 0) {
			where = 2;
		}
		
		dp[start][turn] = Math.max(calculate(start+1,turn+1),calculate(start+1,turn));// 움직인 경우와 안움직인 경우 중에 큰 
		dp[start][turn] += (where == namu[start] ? 1:0);
		
		return dp[start][turn];
	}
}
