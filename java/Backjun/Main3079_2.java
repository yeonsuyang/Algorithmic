package com.study.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3079_2 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken()); //심사대 수 
		long M = Long.parseLong(st.nextToken()); // M명
		
		long[] time = new long[(int)N]; //걸리는 시간
		long bigger = 0;
		
		for(int i=0; i< time.length; i++){
			time[i] = Long.parseLong(br.readLine());
			bigger = max(bigger,time[i]);
		}
		
		long lo = 0;
		long hi = bigger * M;
		long answer = 0;
		
		while(lo <= hi){
			long mid = (lo + hi) / 2; 
			long result = calculate(mid,time,M);
			
			if(result >= M){
				answer = mid;
				hi = mid-1;	
			}else{
				lo = mid+1;
			}
		}
		
		System.out.println(answer);
	}



	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2019. 1. 17.
	 * @param mid
	 * @param time
	 * @param m
	 * @return
	 */
	private static long calculate(long mid, long[] time, long m) {
		
		long result = 0;
		
		for(int i=0; i<time.length;i++){
			result += (mid/time[i]);
		}
		
		return result;
	}

	/**
	 * 
	 * <p>
	 * 
	 * @since 	1.0
	 * @author 	ysyang - 2019. 1. 17.
	 * @param bigger
	 * @param i
	 * @return
	 */
	private static long max(long bigger, long i) {
		// TODO Auto-generated method stub
		return bigger > i ? bigger:i;
	}
}
