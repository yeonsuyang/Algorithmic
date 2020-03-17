package backTracking;

import java.util.Scanner;

public class Main9663 {
	
	static int count = 0;
	static int N;
	static int[] col;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N]; //각 행에 몇열에 놨는 지 넣을 변수
		
		calCount(0);
		
		System.out.println(count);
	}
	private static void calCount(int h) {
		// TODO Auto-generated method stub
		
		if(h > N-1) {
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			boolean ck = check(h,i);
			
		     if(ck == true) {
				 col[h] = i; //여왕세우기 
				 if(h == N-1) {
					 count++;
				 }else {
					 calCount(h+1);
					 col[h] = -1; //여왕세우기 
				 }
		     }
		}
	}
	private static boolean check(int h, int i) {
		
		boolean ok = true;
		// TODO Auto-generated method stub
		 //이 열에 세운 사람이 없고.
	     for(int j=0;j<h;j++) { //아직 h 전까지밖에 안세웠음으로.
	    	 if(col[j] == i) {
	    		 ok = false;
	    		 break; //이열에 세웠으면 못세움 
	    	 }
	     }
	     
	     if(ok == true) {//대각선도 검사하기.
	    	 int temp = 0;
	    	 for(int k=h-1;k>=0;k--) {
	    		 temp++;
	    		 if(col[k] == i-temp && i > 0) {
	    			 ok = false;
		    		 break; //이열에 세웠으면 못세움 
	    		 }
	    		 if(col[k] == i+temp && i < N-1) {
	    			 ok = false;
		    		 break; //이열에 세웠으면 못세움 
	    		 }
	    	 }
	     }
	     
	     return ok;
	}
}
