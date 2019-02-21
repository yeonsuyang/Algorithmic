/*
 * com.study.yeonsu Main14501.java 2019. 1. 11.
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 
 * Main14501 Class
 * 클래스가 어떠한 것을 처리하기 위한 클래스인지 명시 한다.
 * (ex:이 클래스는 어떤것을 처리하기 위해 작성된 클래스이다.)
 * <p>
 * 클래스(Main14501) 사용의 Sample을 명시 한다.
 * <pre>; 
 * Main14501 c = new Main14501();
 * c.test();
 * <pre>;
 * <p>클래스 사용중 중요 이슈를 명시 한다. 
 * (ex:미완성중인 것이라던가 어떠한 Method는 어떠한 Class는 꼭 어떻게 써야 한다라든가)
 * 
 * <p>Copyright (c) 1997-2013 Alticast, Inc. All rights reserved.
 *
 * @since	1.0
 * @author	ysyang - 2019. 1. 11.
 */
public class Main14501 {
/*	7
	3 10
	5 20
	1 10
	1 20
	2 15
	4 40
	2 200*/
	static int N;
	static int[] time;
	static int[] money;
	static int[] dp;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   	    
		N = Integer.parseInt(br.readLine());
	    time = new int[N+1];
	    money = new int[N+1];
	    dp = new int[N+1];
	    
	    for(int i=1;i<=N;i++){
	    	 StringTokenizer st= new StringTokenizer(br.readLine());
	    	 time[i] = Integer.parseInt(st.nextToken()); //걸리는 일 수 
	    	 money[i] = Integer.parseInt(st.nextToken()); // 받는 돈 	
	    }
	    
	    Arrays.fill(dp, -1);
	    
	    dp[1]  = money[1];
	    
	    int ans = 0;
	    
	    for(int k=N;k>=1;k--){
	    	ans = Math.max(calculate(k),ans); //db[7]이랑 ans비교 내려가면서 다 비교
	    }
	    System.out.println(ans);
	}

	private static int calculate(int k) {
		
		if(k+time[k] > N+1){ //7+2 는 불가능.
			return 0;
		}
		
		if(dp[k] != -1){
			return dp[k];
		}
		
		int result = 0;
		
		
		for(int i=0;i<k;i++){
			int temp = money[k];
			if(i+time[i] < k+1){ 
				temp += calculate(i);
			}
			if(temp > result){
				result = temp;
			}
		}		
		dp[k] = result;
		return result;
	}



	   

}
