/*
스도쿠는 매우 간단한 숫자 퍼즐이다. 9×9 크기의 보드가 있을 때, 
각 행과 각 열, 그리고 9개의 3×3 크기의 보드에 1부터 9까지의 숫자가 중복 없이 나타나도록 보드를 채우면 된다. 
예를 들어 다음을 보자.



위 그림은 참 잘도 스도쿠 퍼즐을 푼 경우이다. 각 행에 1부터 9까지의 숫자가 중복 없이 나오고, 
각 열에 1부터 9까지의 숫자가 중복 없이 나오고, 각 3×3짜리 사각형(9개이며, 위에서 색깔로 표시되었다)에 
1부터 9까지의 숫자가 중복 없이 나오기 때문이다.

하다 만 스도쿠 퍼즐이 주어졌을 때, 마저 끝내는 프로그램을 작성하시오.

103000509
002109400
000704000
300502006
060000050
700803004
000401000
009205800
804000107

143628579
572139468
986754231
391542786
468917352
725863914
237481695
619275843
854396127

 */
package com.study.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2239 {
	
		static int[][] stoku;
		
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		
		stoku = new int[9][9];
		
		
		
		for(int i=0;i<9;i++){
			st = br.readLine();
			for(int j=0;j<9;j++){
				stoku[i][j] = st.charAt(j)-'0';
				
			}
		}//입력받고
	
		calculate();
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(stoku[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	
	private static boolean calculate(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(stoku[i][j] == 0){
					if(!changeInput(i,j)){
						return false;
					};
				}				
			}
		}
		
		return true;
	}
	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2019. 3. 28.
	 * @param i
	 * @param j
	 */
	private static boolean changeInput(int y, int x) {
	

		for(int i=1;i<=9;i++){
			stoku[y][x] = i;
			boolean check = check(y,x);
			
			if(check){
				if(!calculate()){
					stoku[y][x] = 0;
				}else{
					break;
				}
			}else{	
				stoku[y][x] = 0;
				if(i == 9){
					return false;
				}
			}
		}
		
		if(stoku[y][x] == 0){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2019. 3. 15.
	 * @param i
	 * @param j
	 */
	private static boolean check(int y, int x) {
		// TODO Auto-generated method stub
		
		int xstart=0,xend=0;
		int ystart=0,yend=0;
		
		if(y<3){
			ystart = 0;
			yend = 2;
		}else if(y<6){
			ystart = 3;
			yend = 5;
		}else{
			ystart = 6;
			yend = 8;
		}
		
		if(x<3){
			xstart = 0;
			xend = 2;
		}else if(x<6){
			xstart = 3;
			xend = 5;
		}else{
			xstart = 6;
			xend = 8;
		}

		
		boolean checkFlag = true;	
			//사각형 검사
			for(int i = ystart; i<=yend;i++){
				for(int j=xstart;j<=xend;j++){
					if(i != y && j != x){
						if(stoku[i][j] == stoku[y][x]){
							checkFlag = false;
							break;
						}
					}
				}
			}
			//가로검사
			for(int j = 0; j< 9;j++){
				if(j != x){
					if(stoku[y][j]== stoku[y][x]){
						checkFlag = false;
						break;
					}
				}
			}
			//세로검사 	
			for(int i = 0; i< 9;i++){
				if( i != y){
					if(stoku[i][x] == stoku[y][x]){
						checkFlag = false;
						break;
					}
				}
			}
		
		return checkFlag;
	}
}
