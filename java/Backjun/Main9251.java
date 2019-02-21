/*
 * com.study.yeonsu Main9251.java 2019. 1. 17.
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


public class Main9251 {
	public static void main(String args[]) throws IOException{
		
/*		LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
		예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String st1 = br.readLine();
		String st2 = br.readLine();
		
		char[] s1 = st1.toCharArray();
		char[] s2 = st2.toCharArray(); 

		int[][] dp = new int[s1.length+1][s2.length+1];
		
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[i].length;j++){
				if(s1[i-1] == s2[j-1]){
					dp[i][j] = dp[i-1][j-1] + 1; //같으면 대각선 왼쪽의 수의 +1
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // 다르면 왼쪽이나 위에꺼 중 큰 수 택
				}
			}
		}
		
		System.out.println(dp[s1.length][s2.length]);
	}	
}
