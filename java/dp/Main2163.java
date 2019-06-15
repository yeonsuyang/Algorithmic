package dp;

import java.util.Scanner;

public class Main2163 {
	
	static int[][] cache = new int[300][300];
	
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //개수
		int M = sc.nextInt();
			
		System.out.println(calculate(N,M)); 
	}

	private static int calculate(int n, int m) {
		if(cache[n][m] != 0) {
			return cache[n][m];
		}
		
		if(n == 1) {
			return cache[n][m] = m-1;
		}else {
			return cache[n][m] = (n-1) + n * calculate(1,m) ;
		}
	}
}
