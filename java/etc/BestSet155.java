/*
 * com.study.yeonsu num02.java 2016. 12. 7.
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

/** 
 * num02 Class
 * 클래스가 어떠한 것을 처리하기 위한 클래스인지 명시 한다.
 * (ex:이 클래스는 어떤것을 처리하기 위해 작성된 클래스이다.)
 * <p>
 * 클래스(num02) 사용의 Sample을 명시 한다.
 * <pre>; 
 * num02 c = new num02();
 * c.test();
 * <pre>;
 * <p>클래스 사용중 중요 이슈를 명시 한다. 
 * (ex:미완성중인 것이라던가 어떠한 Method는 어떠한 Class는 꼭 어떻게 써야 한다라든가)
 * 
 * <p>Copyright (c) 1997-2013 Alticast, Inc. All rights reserved.
 *
 * @since	1.0
 * @author	ysyang - 2016. 12. 7.
 */
import java.util.Arrays; //테스트로 출력해 보기 위한 코드입니다.

public class BestSet155 {

    public int[] bestSet(int n, int s){
        int[] answer = new int[n];
        int tmp = 0;
        
        
        int d = s/n;
        int r = s%n;
        
        for(int i = 0; i < n; i++){
        	answer[i] = d;
        }
        for(int i=0; i < r; i++){
        	answer[(n-1)-i] += 1;
        }
        
        
     loop1: for(int i=1; i < n; i++){
        	
        	if(answer[i] == 0 ){
        		answer = new int[1];
        		answer[0] = -1;
        		break loop1;
        	}
        	
        }
        
        
        
        
        return answer;
    }
    public static void main(String[] args) {
    	BestSet155 c = new BestSet155();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(Arrays.toString(c.bestSet(14,13)));
    }

}
