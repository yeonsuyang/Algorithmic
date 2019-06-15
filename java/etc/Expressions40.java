package etc;
/*
 * com.study.yeonsu Expressions40.java 2016. 12. 8.
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

/** 
수학을 공부하던 민지는 재미있는 사실을 발견하였습니다. 
그 사실은 바로 연속된 자연수의 합으로 어떤 숫자를 표현하는 방법이 여러 가지라는 것입니다. 
예를 들어, 15를 표현하는 방법은
(1+2+3+4+5)
(4+5+6)
(7+8)
(15)

로 총 4가지가 존재합니다. 
숫자를 입력받아 연속된 수로 표현하는 방법을 반환하는 expressions 함수를 
만들어 민지를 도와주세요. 예를 들어 15가 입력된다면 4를 반환해 주면 됩니다.
 */
public class Expressions40 {
	
	public int expressions(int num) {
		int answer = 0;
		int sum = 0;
		int tmp = 1;
		
		for (int i = 1; i < num; i++) {
			sum = i;
				
			for (int j = i+1; j <= num; j++) {
		
				sum += j;
				if (sum > num) {
					sum = 0;
					break;
				}
				
				if(sum == num){
					System.out.println(i+"부터"+j+"까지");
					tmp ++;
					break;
				}
			}
		}	
		
		answer = tmp;
		return answer;
	}

	public static void main(String args[]) {
		Expressions40 expressions = new Expressions40();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(expressions.expressions(15));
	}

}
