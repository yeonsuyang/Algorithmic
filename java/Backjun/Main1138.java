package study;

import java.util.Scanner;

public class Main1138 {
	
	//4
	//2 1 1 0
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //N명;
	    int[] A = new int[N];
	    int[] ans = new int[N];
	    
	    for(int i=0; i<N;i++) {
	    	A[i] = sc.nextInt();
	    }

	    
	    for(int i=0; i<N; i++) {
	    	int temp = A[i];
	    	for(int j=0; j<N;j++) {
		    	if(temp == 0 && ans[j] == 0) {
		    		ans[j] = i+1;
		    		break;
		    	}else if(ans[j] > i+1 || ans[j] == 0){
		    		temp --;
		    	}
	    	}
	    	
	    }
	     
	   for(int i=0;i<N;i++) {
		   System.out.print(ans[i]+" ");
	   }

	
	}
}
