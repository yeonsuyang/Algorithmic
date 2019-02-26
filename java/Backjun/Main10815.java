package com.study.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main10815 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		//입력받고 
		int N = Integer.parseInt(br.readLine());
		int[] s = new int[N];
		
		
		st =  new StringTokenizer(br.readLine());
		for(int i=0;i<s.length;i++){
			s[i] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(s);
		
		int M = Integer.parseInt(br.readLine());
		int[] card = new int[M];
		
		st =  new StringTokenizer(br.readLine());
		for(int i=0;i<card.length;i++){
			card[i] = Integer.parseInt(st.nextToken());			
		}
		
		for(int i=0;i<card.length;i++){
			System.out.print(search(card[i],s)+" ");		
		}
		
	}


	private static int search(int num, int[] s) {
		
		int result = 0;
		int lo = 1; int hi = s.length; 
		int mid = 0;
		
		while(lo <= hi){ 
			mid = (lo+hi) / 2 ; 
								
								
			if(s[mid-1] == num){
				result = 1;
				break;
			}else if(s[mid-1] > num){ 
				hi = mid-1; 
			}else if(s[mid-1] < num){
				lo = mid+1; 
			}
		}
		return result;
	}
}
