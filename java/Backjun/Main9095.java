package study;

import java.util.Scanner;


public class Main9095 {
	private static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int[] dp = new int[11];
		
		int N = sc.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;	
		
		while(N-- > 0) {
			int num = sc.nextInt();
            
            for(int i=4;i<=num;i++){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
			
			System.out.println(dp[num]);
		}
	}
}