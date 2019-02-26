/*
 * com.study.yeonsu Main2613.java 2019. 1. 28.
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
첫째 줄에 구슬의 개수 N과 그룹의 수 M이 주어진다. 둘째 줄에는 각 구슬이 적혀진 숫자가 왼쪽부터 차례로 주어진다. 
N은 300 이하의 자연수, M은 N이하의 자연수이며, 구슬에 적혀진 숫자는 100 이하의 자연수이다.

각 그룹의 합 중 최댓값이 최소가 되도록 M개의 그룹으로 나누었을 때 그 최댓값을 첫째 줄에 출력하고, 
둘째 줄에는 각 그룹을 구성하는 구슬의 개수를 왼쪽부터 순서대로 출력한다. 
구슬의 개수를 출력할 때는 사이에 한 칸의 공백을 둔다. 
만약 그룹의 합의 최댓값이 최소가 되도록 하는 경우가 둘 이상이라면 그 중 하나만을 출력한다.

8 3
5 4 2 6 9 3 8 7

17
4 2 2
 */
public class Main2613 {
	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//구슬 개수
		int M = Integer.parseInt(st.nextToken()); //그룹의 수
		
		int[] bead = new int[N];
		int hap = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<bead.length;i++){
			bead[i] = Integer.parseInt(st.nextToken()); //구슬 넣어주기.
			max = Math.max(max, bead[i]);
			hap += bead[i];
		}
		
		int lo = max; //구슬중에 제일 큰 값, 최소 큰 값이 들어갈 수 있어야 하기때문에
		int hi = hap; //합이 제일 큰 값. 
		int ans = 0;
		int[] result = new int[N];
		
		while(lo <= hi){
				if(N==M){
					ans = lo;
					Arrays.fill(result, 1);
					break;
				}
			int mid = (lo+hi)/2;
			int[] temp = calculate(bead,mid,M);
			
			if(cnt <= M){
				ans = mid;
				result = temp;
				hi = mid -1;
			}else{
				lo = mid+1; 
			}
			
		}
		System.out.println(ans);
		for(int i=0; i<M;i++){
			System.out.print(result[i]+" ");
		}
	}

	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2019. 1. 29.
	 * @param bead
	 * @param m
	 * @return
	 */
	private static int[] calculate(int[] bead,int  mid,  int m) {
		
		cnt = 1;
		int rcnt = 0;
		int sum = 0;
		int[] temp = new int[bead.length];
		
		for(int i=0;i<bead.length;i++){
			sum += bead[i];
			if(sum > mid){
				temp[cnt-1] = rcnt;
				rcnt=0;
					if(bead.length-i == (m-cnt)){
						for(int j=i;j<bead.length;j++){
							cnt++;
							temp[cnt-1] = 1;
						}
						break;
					}
				cnt++;
				sum = bead[i];
					if(cnt > m){
						break;
					}
			}
			rcnt++; 
			if(i==bead.length-1){
				temp[cnt-1] = rcnt;
			}
		}
		
		return temp;
	}
}
