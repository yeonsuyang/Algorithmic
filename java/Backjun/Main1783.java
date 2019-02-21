/*
 * com.study.yeonsu Main1783.java 2019. 1. 29.
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
병든 나이트가 N * M 크기 체스판의 가장 왼쪽아래 칸에 위치해 있다. 
병든 나이트는 건강한 보통 체스의 나이트와 다르게 4가지로만 움직일 수 있다.

2칸 위로, 1칸 오른쪽
1칸 위로, 2칸 오른쪽
1칸 아래로, 2칸 오른쪽
2칸 아래로, 1칸 오른쪽
병든 나이트는 병들었지만, 그래도 명색이 체스 나이트이기 때문에 많은 칸을 방문하고 싶어 한다. 
병든 나이트의 이동에는 제약이 있다. 
만약, 이동 횟수가 4번 이상인 경우에는 위의 이동 방법을 각각 한 번 이상 이용해야 한다.

체스판의 크기가 주어졌을 때, 병든 나이트가 방문할 수 있는 칸의 최대 개수를 출력하는 프로그램을 작성하시오. 
처음에 있는 칸도 센다.

첫째 줄에 체스판의 세로 길이 N와 가로 길이 M이 주어진다. N과 M은 2,000,000,000보다 작거나 같은 자연수이다.

100 50 
48

1 1
1

17 5
4

2 4
2 

20 4
4

 */
public class Main1783 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //세로
		int M = sc.nextInt(); //가로
		
		int ans = 0;
		
		if(N == 1){
			ans = 1;
		}else if(N == 2){
            if(M <= 6){
			ans = M/2 + M%2;
            }else{
                ans = 4;
            }
		}else{
			if(M <= 3){
				ans = M;
			}else if(4<= M && M < 7){
				ans = 4;
			}else{
				ans = M-2;
			}
		}
		
		System.out.println(ans);
	}
}
