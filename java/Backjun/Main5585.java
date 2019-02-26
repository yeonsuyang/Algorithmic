/*
 * com.study.yeonsu Main5585.java 2019. 1. 25.
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
타로는 자주 JOI잡화점에서 물건을 산다. 
JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 
언제나 거스름돈 개수가 가장 적게 잔돈을 준다. 
타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 
받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.

예를 들어 입력된 예1의 경우에는 아래 그림에서 처럼 4개를 출력해야 한다.

입력은 한줄로 이루어져있고, 타로가 지불할 돈(1 이상 1000미만의 정수) 1개가 쓰여져있다.
제출할 출력 파일은 1행으로만 되어 있다. 잔돈에 포함된 매수를 출력하시오.
 */
public class Main5585 {
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		int N = sc.nextInt(); //개수	
		
		int count = 0;
		int namuji = 1000 - N;
		
		if(namuji >= 500){
			count += namuji/500;
			namuji -= 500 * (namuji/500);
		}
		
		if(namuji >= 100){
			count += namuji/100;
			namuji -= 100 * (namuji/100);
		}
		if(namuji >= 50){
			count += namuji/50;
			namuji -= 50 * (namuji/50);
		}
		if(namuji >= 10){
			count += namuji/10;
			namuji -= 10 * (namuji/10);
		}
		if(namuji >= 5){
			count += namuji/5;
			namuji -= 5 * (namuji/5);
		}
		
		count += namuji;
		
		System.out.println(count);
	}
}
