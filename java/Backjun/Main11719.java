package com.study.helloworld;

import java.util.ArrayList;
import java.util.Scanner;

public class Main11719 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aList = new ArrayList<>();
		
		int c=0;
		
		while(scan.hasNextLine()){
				String a = scan.nextLine();
				aList.add(a);
				c++;
				if(c==100){
					break;
				}
			}
		
		scan.close();
		
		for(int i=0;i<aList.size();i++){
			System.out.println(aList.get(i));
		}
	}
}