package etc;

import java.util.Scanner;

public class n1209 {
	
	private static Scanner s;
	
	public static void main(String[] args) {
		
		 int[][] array = new int[100][100];
		 
		 s = new Scanner(System.in);
		
		//총 10번의 회차가 주어진다.
		 
	    for(int i=0; i< 10; i++) {
	    	int a = s.nextInt(); //회
	    	
	    	for(int j=0; j<100; j++) {
	    		for(int k=0; k<100; k++) {
	    			array[j][k] = s.nextInt(); 
	    		}
	    	}//배열 입력을 받고 
	    	
	    	int[] harray = new int[100]; //가로
	    	int[] varray = new int[100]; //세로
	    	int[] darray = new int[2]; //대각선	
	    	
	        int max=0;
	        
	    	//가로 더하기	
	    	for(int j=0; j<100; j++) {
	    		for(int k=0; k<100; k++) {
	    			harray[j] += array[j][k];
	    			varray[j] += array[k][j];
	    			
	    			if(j==k) {
	    				darray[0] += array[j][k];
	    			    darray[1] += array[j][99-j];
	    			}
	    			
	    		}
	    		
	    		max = Math.max(max, (Math.max(harray[j], varray[j])));
	    	}
	    	for(int c=0; c< darray.length; c++ ) {
	    		max = Math.max(max, darray[c]);
	    	}
	    	
	    	System.out.println("#"+a+" "+max);
	    }
	}
}
