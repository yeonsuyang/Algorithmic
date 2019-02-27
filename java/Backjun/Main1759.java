/*

최소 한 개의 모음과 두 개의 자음
증가하는 순서로 배열

새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 
이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다.
 C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.

첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 
C개의 문자들이 공백으로 구분되어 주어진다. 
주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.

각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.

4 6
a t c i s w

acis
acit
aciw
acst
acsw
actw
aist
aisw
aitw
astw
cist
cisw
citw
istw
 */
package com.study.helloworld;

import java.util.Arrays;
import java.util.Scanner;

public class Main1759 {
	
	static int L;
	static int C;
	static char[] input;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); //암호 글자 수
		C = sc.nextInt(); //만들 암호 수
		
		input = new char[C];
		for(int i=0;i<C;i++){
			input[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(input); //순서대로 하기 위해 정렬
	
		for(int i=0;i<C;i++){
			char[] pw = new char[L];
			int mcount = 0; //모음카운트
			int jcount = 0; //자음 카운트 
			int lcount = 0; //글자수 카운트 
			if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' 
					|| input[i] == 'o' || input[i] == 'u' ){
				mcount++;
			}else{
				jcount++;
			}
			pw[lcount] = input[i];  //0번째에 pw가 들어감. 
			creatPw(pw,mcount,jcount,lcount+1,i+1);
		}
	}

	private static void creatPw(char[] pw, int mc, int jc, int lc,int start) {
		// TODO Auto-generated method stub
		if(lc > L-1){
			return;
		}
				
		for(int i=start;i<C;i++){
			
			int mcount = mc;
			int jcount = jc;
			int lcount = lc;
			
			if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' 
					|| input[i] == 'o' || input[i] == 'u' ){
				if(mcount >= (L-2)){
					continue;
				}
				mcount++;
			}else{
				if(mcount >= (L-1)){
					continue;
				}
				jcount++;
			}
			
			pw[lcount] = input[i];
			if(lcount == L-1){
				if(mcount > 0 && jcount > 1){
					for(int j=0;j<pw.length;j++){
						System.out.print(pw[j]);
					}
					System.out.println();
				}
			}else{
				creatPw(pw,mcount,jcount,lcount+1,i+1);
			}
		}
	}
}
