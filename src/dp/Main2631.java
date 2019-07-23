package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Main2631 {
		static int[] child ;
		static int[] dp;
		static int N;
		private static Scanner sc;
	
		public static void main(String[] args) {
			sc = new Scanner(System.in);
			N = sc.nextInt();
			child = new int[N+1];
			dp = new int[N+1];
			
		    for(int i=1;i<=N;i++) {
		    	child[i] = sc.nextInt();
		    }
		    Arrays.fill(dp, -1);
		    
		    int max = 0;
		    for(int i=1;i<=N;i++) {
		    	max = Math.max(calculate(i),max);
		    }
		    
		    System.out.println(N-max); //아이들 수에서 1부터 했을 때 제일 정렬 되어 있는 수(이걸 lis라고 부릅)의 개수를 빼면 정렬해야 할 아이들.	
	}

		private static int calculate(int i) {
			
			if(i >= N) {
				return 1;
			}
			
			if(dp[i] != -1) {
				return dp[i];
			}
			int result = 1;
			
			for(int j=i+1;j<=N;j++) {
				int temp = 1;
				if(child[i] < child[j]) {
					temp += calculate(j);//두번째 자리부터 쩨일 큰 수랑. 더하깅.
				}
				
				if(result == -1 || temp > result) {
					result = temp;
				}
			}
			dp[i] = result;
			
			return dp[i];
		}
}
