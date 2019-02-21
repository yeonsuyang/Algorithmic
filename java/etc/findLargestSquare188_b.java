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

import java.util.Arrays;
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
public class findLargestSquare188_b {

	  int W;
	   int H;
	   int[][] cacheW; // 해당 지점이 갖는 가장 긴 가로길이 저장
	   int[][] cacheH; // 해당 지점이 갖는 가장 긴 세로길이 저장
	   
	   public int findLargestSquare(char [][]board)
	    {
	        int answer = 0;
	        W = board[0].length; // 배열 열 크기
	        H = board.length; // 배열 행 크기
	        int val=0;
	        int maxVal=0;
	        
	        cacheW = new int[H][W];
	        cacheH = new int[H][W];
	      initCache(); // cahce 배열 -1로 초기화
	        
	        for(int i=0;i<H;i++){
	           System.out.println("**************i : "+i);
	           for(int j=0;j<W;j++){
	              System.out.println("j : "+j);
	              findWidth(i,j,board,1);
	              findHeight(i,j,board,1);
	           }
	        }
	        
	        for(int i=0;i<W;i++){
	           for(int j=0;j<H;j++){
	              if(cacheW[j][i]!=-1&&cacheH[j][i]!=-1){ // -1이 아닌 경우, (-1 == 'X')
	                 val = (cacheW[j][i]>cacheH[j][i])? cacheH[j][i]:cacheW[j][i]; // 더 작은 값을 val에 대입
	                 index:
	                 if(maxVal<val){ // 현재 길이가 지금까지의 최대 길이보다 클 경우, if문
	                    for(int a=i;a<i+val;a++){
	                       for(int b=j;b<j+val;b++){
	                          if(cacheW[b][a]==-1||cacheH[b][a]==-1){
	                             break index;
	                          }
	                       }
	                    }
	                    maxVal = val; // 최대 값에 val대입
	                    answer = val*val;
	                    System.out.println("W : "+i+" H : "+j+"-----------------"+answer);
	                 }
	              }
	           }
	        }
	        
	        for(int i=0;i<cacheW.length;i++){
	           for(int j=0;j<cacheW[0].length;j++){
	              System.out.printf("%2d",cacheW[i][j]);
	           }
	           System.out.println();
	        }
	        System.out.println();
	        for(int i=0;i<cacheH.length;i++){
	           for(int j=0;j<cacheH[0].length;j++){
	              System.out.printf("%2d",cacheH[i][j]);
	           }
	           System.out.println();
	        }
	        return answer;
	    }
	   public int findWidth(int h, int w, char[][]board,int value){
	      
	      if(w>=W||h>=H) return 0; // 기저사례 : 범위 넘어가면 0리턴
	      if(cacheW[h][w]!=-1) return cacheW[h][w];
	      if(board[h][w]=='O'){
	         value += findWidth(h,w+1,board,value);
	         
	      }else{
	         return 0;
	      }
	      cacheW[h][w]=value;
	      return value;
	   }
	   public int findHeight(int h, int w, char[][]board,int value){
	      
	      if(w>=W||h>=H) return 0; // 기저사례 : 범위 넘어가면 0리턴
	      if(cacheH[h][w]!=-1) return cacheH[h][w];
	      if(board[h][w]=='O'){
	         value += findHeight(h+1,w,board,value);
	         
	      }else{
	         return 0;
	      }
	      cacheH[h][w]=value;
	      return value;
	   }
	   
	   public void initCache(){
	      for(int[] a:cacheW){
	         Arrays.fill(a, -1);
	      }//cache를 -1로 초기화
	      for(int[] b:cacheH){
	         Arrays.fill(b, -1);
	      }
	   }
	   
	    public static void main(String[] args)
	    {
	    	findLargestSquare188_b test = new findLargestSquare188_b();
	      char [][]board ={
	      {'O','O','O','O','O','O','O'},
	      {'X','O','O','O','O','O','X'},
	      {'O','O','O','O','O','O','O'},
	      {'O','O','O','O','X','O','O'},
	      {'O','X','O','O','O','O','O'},
	      {'O','O','O','O','X','O','O'},
	      {'O','O','O','O','O','O','O'},
	      {'O','O','O','O','O','O','X'},};
	      
	        System.out.println(test.findLargestSquare(board));
	    }


}
