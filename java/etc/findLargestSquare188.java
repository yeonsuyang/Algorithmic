/*
 * com.study.yeonsu num01.java 2016. 12. 6.
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
 * num01 Class 클래스가 어떠한 것을 처리하기 위한 클래스인지 명시 한다. (ex:이 클래스는 어떤것을 처리하기 위해 작성된 클래스이다.)
 * <p>
 * 클래스(num01) 사용의 Sample을 명시 한다.
 * 
 * <pre>
 * ; num01 c = new num01(); c.test();
 * 
 * <pre>
 * ;
 * <p>
 * 클래스 사용중 중요 이슈를 명시 한다. (ex:미완성중인 것이라던가 어떠한 Method는 어떠한 Class는 꼭 어떻게 써야 한다라든가)
 * 
 * <p>
 * Copyright (c) 1997-2013 Alticast, Inc. All rights reserved.
 *
 * @since 1.0
 * @author ysyang - 2016. 12. 6.
 */
public class findLargestSquare188 {

	public int findLargestSquare(char[][] board) {
		int answer = 0;
		int tmp = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == 'O') {

					int c = i;
					int d = j;
					int width = 0;
					int heigh = 0;

					// x 가 나올때까지 좌표를 늘려가며 width 길이더하기.
					while (board[c][d] == 'O') {
						width++;
						d++;

						// 만약 d가 배열 길이 보다 길어졌다면 멈추기
						if (d > (board[i].length - 1)) {
							break;
						}
					}

					// 다시초기화
					c = i;
					d = j;

					// x 가 나올때까지 좌표를 늘려가며 heigh 길이더하기.
					while (board[c][d] == 'O') {
						heigh++;
						c++;

						// 만약 c가 배열 길이 보다 길어졌다면 멈추기
						if (c > (board.length - 1)) {
							break;
						}
					}

					// 정사각형이여야 하니 나왔을 때 더 짧은로 정사각형 길이 계산하기
					int max = 0;
					if (width >= heigh) {
						max = heigh;
					}
					else if (width < heigh) {
						max = width;
					}

					// 그안에 있는게 다 'O'인지 체크'
					// x가나오면 그냥 for문 나와버리기.
					for (int x = j; x < j + (max); x++) {
						for (int y = i; y < i + (max); y++) {
							if (board[y][x] == 'X') {
								if (x >= y) {
									if (max > (x - j)) {
										max = (x - j);
									}

								}
								else if (y > x) {
									if (max > (y - i)) {
										max = (y - i);
									}

								}
							}
						}
					}

					tmp = max * max;

					// tmp 가 더 길면 answer바꿔주기.
					if (tmp > answer) {
						answer = tmp;
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {

		findLargestSquare188 test = new findLargestSquare188();

		char[][] board = { { 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' }, 
				           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X' } };

		System.out.println(test.findLargestSquare(board));
	}

}
