package study;

import java.util.Scanner;

public class Main1120 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		int ans = -1;
		
		for(int i=0; i<=b.length() - a.length(); i++) {
			int cnt = 0;
			for(int j=0; j<a.length(); j++) {
				if(a.charAt(j) != b.charAt(j+i)) {
					cnt++;
				}
			}
			
			if(ans == -1 || ans > cnt) {
				ans = cnt;
			}
		}
		
		System.out.println(ans);
	}
}
