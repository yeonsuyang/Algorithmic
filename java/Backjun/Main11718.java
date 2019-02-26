package com.study.helloworld;

import java.util.ArrayList;
import java.util.Scanner;

public class Main11718 {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
        ArrayList<String> aList = new ArrayList<>();
         
        while (scan.hasNextLine()) {
            String a = scan.nextLine();
            if (a == null || a.isEmpty()) {
                break;
            }
            aList.add(a);
        }
 
        for (int i = 0; i < aList.size(); ++i) {
            System.out.println(aList.get(i));
        }
	}
}