/*
 * com.study.yeonsu Main11048.java 2019. 1. 18.
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

/** 
 * Main11048 Class
 * 클래스가 어떠한 것을 처리하기 위한 클래스인지 명시 한다.
 * (ex:이 클래스는 어떤것을 처리하기 위해 작성된 클래스이다.)
 * <p>
 * 클래스(Main11048) 사용의 Sample을 명시 한다.
 * <pre>; 
 * Main11048 c = new Main11048();
 * c.test();
 * <pre>;
 * <p>클래스 사용중 중요 이슈를 명시 한다. 
 * (ex:미완성중인 것이라던가 어떠한 Method는 어떠한 Class는 꼭 어떻게 써야 한다라든가)
 * 
 * <p>Copyright (c) 1997-2013 Alticast, Inc. All rights reserved.
 *
 * @since	1.0
 * @author	ysyang - 2019. 1. 18.
 */
public class Main11048 {
	public static void main(String arsg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		
		int[][] candy = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());	
			for(int j=1;j<=M;j++){
				candy[i][j] = Integer.parseInt(st.nextToken());
			}
		}//표 입력받고
		
		for(int i=1;i<N+1;i++){
			for(int j=1;j<M+1;j++){
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]); //왼쪽 위 두개 비교
				dp[i][j] = Math.max(dp[i][j], dp[i][j-1]); //왼쪽 옆 비교
				dp[i][j] += candy[i][j]; // 지금 현재 더해주고
			}
		}
		
		System.out.println(dp[N][M]);
		
	}
}
