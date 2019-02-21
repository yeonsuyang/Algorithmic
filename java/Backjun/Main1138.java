/*
 * com.study.yeonsu Main1138.java 2019. 1. 25.
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

/** 
N명의 사람들은 매일 아침 한 줄로 선다. 
이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.
어느날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다. 
그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.
사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다. 

N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.
각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.

4 
2 1 1 0

1 

4 2 1 3

 */
public class Main1138 {
	
	//4
	//2 1 1 0
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //N명;
	    int[] A = new int[N];
	    int[] ans = new int[N];
	    
	    for(int i=0; i<N;i++) {
	    	A[i] = sc.nextInt();
	    }

	    
	    for(int i=0; i<N; i++) {
	    	int temp = A[i];
	    	for(int j=0; j<N;j++) {
		    	if(temp == 0 && ans[j] == 0) {
		    		ans[j] = i+1;
		    		break;
		    	}else if(ans[j] > i+1 || ans[j] == 0){
		    		temp --;
		    	}
	    	}
	    	
	    }
	     
	   for(int i=0;i<N;i++) {
		   System.out.print(ans[i]+" ");
	   }

	
	}
}
