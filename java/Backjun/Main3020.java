/*
 * 
 * 
개똥벌레 한 마리가 장애물(석순과 종유석)로 가득찬 동굴에 들어갔다. 
동굴의 길이는 N미터이고, 높이는 H미터이다. (N은 짝수) 첫 번째 장애물은 항상 석순이고, 
그 다음에는 종유석과 석순이 번갈아가면서 등장한다.
아래 그림은 길이가 14미터이고 높이가 5미터인 동굴이다. (예제 그림)

이 개똥벌레는 장애물을 피하지 않는다. 
자신이 지나갈 구간을 정한 다음 일직선으로 지나가면서 만나는 모든 장애물을 파괴한다.
위의 그림에서 4번째 구간으로 개똥벌레가 날아간다면 파괴해야하는 장애물의 수는 총 여덟개이다. 
(4번째 구간은 길이가 3인 석순과 길이가 4인 석순의 중간지점을 말한다)


동굴의 크기와 높이, 모든 장애물의 크기가 주어진다. 
이때, 개똥벌레가 파괴해야하는 장애물의 최솟값과 그러한 구간이 총 몇 개 있는지 구하는 프로그램을 작성하시오.

첫째 줄에 N과 H가 주어진다. N은 항상 짝수이다. (2 ≤ N ≤ 200,000, 2 ≤ H ≤ 500,000)
다음 N개 줄에는 장애물의 크기가 순서대로 주어진다. 장애물의 크기는 H보다 작은 양수이다.

첫째 줄에 개똥벌레가 파괴해야 하는 장애물의 최솟값과 그러한 구간의 수를 공백으로 구분하여 출력한다.

14 5
1
3
4
2
2
4
3
4
3
3
3
2
3
3

7 2
 */
package com.study.helloworld;

import java.util.Arrays;
import java.util.Scanner;

public class Main3020 {
	public static void main(String[] args) {
		
		
		 Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
	     int N = scan.nextInt(); //N미터
	     int H = scan.nextInt(); //높이

	     int[] j = new int[N/2]; //종유석
	     int[] s = new int[N/2]; //석순
	     int[] obstacle_s = new int[H+1];
	     int[] obstacle_j = new int[H+1];
		
	     for(int i=0; i<(N/2); i++){
	    	 s[i] = scan.nextInt(); //차례로 입력
	    	 obstacle_s[s[i]]++;
	    	 j[i] = scan.nextInt();
	    	 obstacle_j[j[i]]++;
	    	
	     }
	     for(int i=H-1;i>=1;i--){
	    	 obstacle_s[i] = obstacle_s[i] + obstacle_s[i+1]; // 4= 4+5 , 3 = 3+4 , 2 = 2+3 
	    	 obstacle_j[i] = obstacle_j[i] + obstacle_j[i+1]; 
	     }

	     int cnt = 0;
	     int min = N;
	     
	     for(int i=0; i< H;i++){ // 모든 높이동안 
	    	 int temp = obstacle_s[i+1]+ obstacle_j[H-i];
	    	
	    	 if(temp < min){
	    		 min = temp;
	    		 cnt = 1;
	    	 }else if(temp == min){
	    		 cnt++;
	    	 }
	       }
	     
	     System.out.println(min+" "+cnt);
	}
}
