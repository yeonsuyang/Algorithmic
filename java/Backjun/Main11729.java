package com.study.helloworld;

import java.util.Scanner;

public class Main11729{
	public static void main(String[] args) {
		Scanner	sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //개수
		
		System.out.println((int)(Math.pow(2, N) -1));
		
		StringBuilder sb = new StringBuilder();
		move(sb,N,1,3);
		System.out.println(sb);
	}

	private static void move(StringBuilder sb, int n, int start, int end) {
		if(n == 0){
			return;
		}
			move(sb,n-1,start,6-start-end);
			sb.append(start+" "+end+"\n");
			move(sb,n-1,6-start-end,end);
		
	}

}