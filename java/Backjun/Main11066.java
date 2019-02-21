/*
 * com.study.yeonsu Main11066.java 2019. 1. 11.
 *
 * Copyright (c) 2001-2013 Alticast Corp.
 * All rights reserved. http://www.alticast.com/
 *
 * This software is the confidential and proprietary information of
 * Alticast Corp. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alticast.
 */
package com.study.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 
 * 2
   4
   40 30 30 50
   15
   1 21 3 4 5 35 5 4 3 5 98 21 14 17 32
 */
public class Main11066 {
	
		static int[] book;
		static int[][] dp;
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                                                                                                                                                                                                                                                                                                                                                                                                                                
		
		int N = Integer.parseInt(br.readLine()); // N번실행
		
		for(int i=0; i<N;i++){//N번동안
			
			int M = Integer.parseInt(br.readLine()); //M개의 항을 받겠다.
			book = new int[M+1];
			dp = new int[M+1][M+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=1;j<=M;j++){
				book[j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[j], -1);
			}
			
			System.out.println(calculate(1,M));
		}
	}

	private static int calculate(int n,int m) {
		
		if(n==m){
			return 0;
		}
		
		if(dp[n][m] != -1){
			return dp[n][m];
		}
		
		int sum = 0;
		for(int i=n;i<=m;i++){
			sum += book[i];
		}
		int result = -1;		
		
		for(int i=n;i<m;i++){

			int temp = calculate(n,i) + calculate(i+1,m) + sum;
			
			if(result == -1 || temp < result){
				result = temp;
			}			
		}
		
 		dp[n][m] = result;
		
		return dp[n][m];
	}
}