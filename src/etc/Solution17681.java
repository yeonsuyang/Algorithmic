package etc;

import java.util.Scanner;

public class Solution17681 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //n 입력받고
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		for(int i=0; i<n;i++) {
			arr1[i] = sc.nextInt();
		}
		for(int i=0; i<n;i++) {
			arr2[i] = sc.nextInt();
		}
		
		
	}
	
	  public String[] solution(int n, int[] arr1, int[] arr2) {
		 
		  	String[] answer = {};
		  	
			for(int i=0;i<n;i++) {
				
				String ans = "";
				int temp = arr1[i]|arr2[i];
				char[] bi = Integer.toBinaryString(temp).toCharArray();
				
				for(int j=0;j<bi.length;j++) {
					if(bi[j] == '1') {
					    ans += "#";
					}else {
						ans += "";
					}
				}
				answer[i] = ans;
			}
			
	      return answer;
	  }
}
