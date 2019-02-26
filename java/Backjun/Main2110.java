package com.study.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 
 도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
 도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 
 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 
 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
 C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 
5 3
1
2
8
4
9

 3
 */
public class Main2110 {
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int house = Integer.parseInt(st.nextToken());
		int STB = Integer.parseInt(st.nextToken());
		
		int[] arrayhouse = new int[house];
		int min = 0;
		int max = 0;
		
		for(int i=0; i<arrayhouse.length;i++){
			arrayhouse[i] = Integer.parseInt(br.readLine());
		}//집거리 입력
		
		Arrays.sort(arrayhouse);
		
		int lo = min;
		int high = arrayhouse[arrayhouse.length-1]-arrayhouse[0];
		int ans = 0;
		
		while(lo <= high){
			int mid = (lo+high)/2;
			int result = calculate(arrayhouse,mid,STB);
			
			if(result >= STB){	 //최소값일때는 지정된 값 < result : 저장 불가. 지정된 값 >= result : 저장
				ans = mid;         //최대값일때는 result >= 지정된 값 : 저장 , result < 지정된 값 : 저장불가 
				lo = mid+1;			
			}else{
				high = mid -1;
			}
			
		}
	
		System.out.println(ans);
	}

	private static int calculate(int[] arrayhouse, int mid, int stb) {
		int cnt = 1;
		int select = arrayhouse[0];
		
		for(int i=1;i<arrayhouse.length;i++){
			if(arrayhouse[i]-select >= mid){
				cnt++;
				select = arrayhouse[i];
				if(cnt > stb){
					break;
				}
			}
		}
		return cnt;
	}
}