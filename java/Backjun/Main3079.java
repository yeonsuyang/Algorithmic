/*
 * com.study.yeonsu Main3079.java 2019. 1. 10.
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

public class Main3079 {
	
	static long bigResult = 0;
	
	public static void main(String args[]) throws IOException{
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st= new StringTokenizer(br.readLine());
	     
	     int N = Integer.parseInt(st.nextToken()); //N개의 심사대 
	     long M = Integer.parseInt(st.nextToken()); //M명	
	     long small = 0,big = 0;
	     
	     long[] Ntime = new long[N];
	     for(int i=0; i<Ntime.length;i++){
	    	 Ntime[i] = Integer.parseInt(br.readLine());
	    	 small = min(small,Ntime[i]);
	    	 big = max(big,Ntime[i]);
	     }
		
	     long lo = 1;
	     long hi = big * M;
	     long answer = 0;
	    
	     while(lo <= hi){
	    	 long mid = (lo+hi)/2;
	    	 long result = calculate(mid,Ntime);
	    	 
	    	 if(result > M){
	    		 hi = mid-1;
	    	 }else{
	    		 if(mid > bigResult && bigResult != 0){
	    			 answer = bigResult;//나머지를 뺀값으로 계산
	    		 }else{
	    			 if(mid < small){
	    				 answer = small;
	    			 }else{ //hi와 lo가 같을 경우의 예외처리
	    				 answer = mid;	 
	    			 }
	    		 }
	    		 lo = mid+1;
	    	 }
	     }
	   System.out.println(answer);
	}

	private static long min(long small, long i) {
		// TODO Auto-generated method stub
		return (small < i && small != 0) ?  small : i;
	}

	private static int calculate(long mid, long[] ntime) {
		// TODO Auto-generated method stub
		int result=0;
		bigResult = 0;
		
		for(int i=0; i<ntime.length;i++){
			result += mid/ntime[i];	
			bigResult = max(bigResult,(mid/ntime[i]) * ntime[i]);
		}
		if(mid > bigResult){
			mid = bigResult;
		}
		
		return result; 
	}

	private static long max(long big, long ntime) {
		// TODO Auto-generated method stub
		return big > ntime ?  big : ntime;
	}

}
