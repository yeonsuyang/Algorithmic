package study;

import java.util.Scanner;

public class Main1783 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = 0;
		
		if(N == 1) {
			ans = 1;
		}else if(N == 2) {
			if(M%2 == 0) {
				ans = M/2;
			}else {
				ans = (M+1)/2;
			}
		}else {//N이 3이상일 경우 
			if(M<=5) { //M이 5보다 작으
				ans = M;
			}else { //M이 5보다 크거나 작으면
				int nowx = 5;
				int nowy = N - 3;
				int now = 2;
				ans = 5;
				
				while(nowy < N && nowy < 0 && nowx < M) {
					ans++;
					if(now == 1) {
						nowx += 1;
						nowy -= 2;
						now = 2;
					}else if(now ==2) {
						nowx += 1;
						nowy += 2;
						now = 3;
					}else if(now ==3) {
						nowx += 2;
						nowy -= 1;
						now = 4;
					}else if(now ==4) {
						nowx += 2;
						nowy += 1;
						now = 1;
					}
				}
				}
		}
		
		System.out.println(ans);
	}
}
