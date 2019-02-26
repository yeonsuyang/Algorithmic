/*
 * com.study.yeonsu ex1.java 2018. 12. 21.
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

import java.util.Scanner;

/*1 2 3 4
  2 4 6 8
  3 6 9 12
   4 8 12 16*/

public class Main1300 {
	public static void main(String[] args) {
		//N 배열 크기 , A[i][j] = i*j
		// B[N*N] 에 넣음 -> 오름 차순 -> k번째 원소
		
		 Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
	     int N = scan.nextInt();
	     int k = scan.nextInt();

	     int lo = 1;  int hi = k;
	     int ans = 0;
	    	 
	     while(lo <= hi){
	    	 int mid = (lo + hi) /2 ;
	    	 System.out.println("mid :"+ mid);
	    	 int hap = 0;
	    	 
	    	 for(int i=1; i<= N; i++){
	    		 hap += min(mid/i,N);
	    		 if(hap > k){
	    			 break;
	    		 }
	    	 }
	    	 
	    	 if(hap >= k){
	    		 ans = mid;
	    		 hi = mid-1;
	    	 }else{
	    		 lo = mid +1;
	    	 }
	    	 System.out.println("ans : "+ans+"hap :"+ hap +",hi:"+hi+",hi:"+lo);
	       }
	     System.out.println(ans);
	}

	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2018. 12. 28.
	 * @param i
	 * @param n
	 * @return
	 */
	private static int min(int a, int b) {
		// TODO Auto-generated method stub
		return a > b ?  b : a;
	}
}
