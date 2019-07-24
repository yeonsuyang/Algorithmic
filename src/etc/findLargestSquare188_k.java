package etc;/*
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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
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
public class findLargestSquare188_k {

	    private static final Logger logger = Logger.getLogger(findLargestSquare188_k.class.getName());
	   /**
	    * <p>
	    * @since 1.0
	    * @author kyungsook - 2016. 12. 6.
	    * @param args
	    */
	   public int findLargestSquare(char[][] board) {
	      int answer = 0;
	      logger.info("start");

	      int boardX = board.length;
	      int boardY = board[0].length;
	      int min = boardX-1;
	      if(boardX > boardY)
	         min = boardY-1;
	      
	      int[][] mask;
	      List<Integer> widths = new ArrayList();
	      for(int i = 0 ; i< min  ; i++){
	         //mask = new int[i][i];
	         
	         for (int j = 0; j < boardX - i ; j++) {
	            f1:for (int k = 0; k < boardY - i; k++) {
	               //int xCheck = 0;
	               for (int u = j; u < j + i +1 ; u++) {
	                  for (int x = k; x < k + i +1; x++) {
	                     if (board[u][x] == 'X'){
	                        //logger.info(u + ", " + x + " = " + board[u][x]);
	                        continue f1;
	                     }
	                  }
	               }
	               
	               widths.add((i+1)*(i+1));
	            }
	         }
	         
	      }
	      
	      for (int i = 0; i < widths.size(); i++) {
	         //logger.info(""+widths.get(i));
	         if (answer < widths.get(i))
	            answer = widths.get(i);
	      }
	      
	      
	      return answer;
	   }

	    public static void main(String[] args) {

	    	findLargestSquare188_k test = new findLargestSquare188_k();

	        char[][] board = { { 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X','X', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O','X', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' },
	                           { 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O','O', 'O', 'O', 'X' }};

	        System.out.println(test.findLargestSquare(board));
	    } 
	
}
