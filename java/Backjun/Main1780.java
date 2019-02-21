/*
 * com.study.yeonsu Main1780.java 2019. 1. 3.
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
import java.util.StringTokenizer;

public class Main1780 {
	
	static int[] ans = new int[3];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][N];
		
		for(int i=0;i<N;i++){
			st =  new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		re(a,N,0,0);
		
		for(int i=0; i<ans.length;i++){
			System.out.println(ans[i]);
		}
		
	}


	private static void re(int[][] a, int n, int x, int y) {
		// TODO Auto-generated method stub
		if(equal(a,n,x,y) != true){
			int c = n/3;
			if(c > 0){
				for(int i=0;i<n;i+=c){
					for(int j=0;j<n;j+=c){
						re(a,c,x+i,y+j);
					}
				}
			}			
		}
	}


	private static boolean equal(int[][] a,int n, int x, int y) {
				
		int c = a[x][y];
		
		for(int i=x; i<x+n;i++){
			for(int j=y;j<y+n;j++){
				
				if(a[i][j] != c){
					return false;
				}
				
			}
		}
		
		ans[c+1]++;
		return true;
	}

	
}
