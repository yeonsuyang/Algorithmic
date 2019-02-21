package com.study.helloworld;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6236{
	
	public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st= new StringTokenizer(br.readLine());
	     
	     int N = Integer.parseInt(st.nextToken()); //N일 동안
	     int M = Integer.parseInt(st.nextToken()); //M 번
	     int[] useMoney = new int[N];
	     int minimum = 0;
	     int hap = 0;
	     
	     for(int i=0; i<N; i++) {
	    	 useMoney[i] = Integer.parseInt(br.readLine());
	    	 minimum = min(minimum,useMoney[i]); // 최소 이만큼은 있어야 함
	    	 hap += useMoney[i]; // 최대 : 다 더한 값
	     }
        
	     int hi = hap;
	     int low = minimum;
	     int answer = 0;
	     
	     while(low <= hi){
	    	 int mid = (hi+low) /2;
	    	 int num = use(useMoney,M,mid);
	    
			if(num > M) {
				low  = mid+1;
			}else if(num <= M) {
				answer = mid;
				hi = mid -1;
			}
	     }
	     
	     System.out.println(answer);
	}

	private static int use(int[] useMoney, int m, int mid) {
		
		int gazindon = mid;
		int num = 1;
		for(int i=0; i<useMoney.length; i++) {
			if(gazindon < useMoney[i]) {
				gazindon = mid;
				num++;
                if(num > m){
					break;
				}
			}
			gazindon -= useMoney[i];
		}
		return num;
	}

	private static int min(int minimum, int i) {
		return minimum > i ? minimum : i;
	}
}