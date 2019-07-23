package etc;

import java.util.Scanner;

public class n1300 {

		public static void main(String[] args) {
			//N 배열 크기 , A[i][j] = i*j
			// B[N*N] 에 넣음 -> 오름 차순 -> k번째 원소
			
			 Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
			 
		     //N*N 배열에서 k번째 수를 찾기  	
			 int N = scan.nextInt();
		     int k = scan.nextInt();
		     
		     //
		     int lo = 1;
	         int hi = N*N;
	         
	         //중간 수보다 작은 개수가 합이지..그게 k랑 똑같으면 그게 답 그러면 그게 답..
	         int mid = 0;
	         int m = 0;
	         
	         while(m != k) {
	        	 mid = (lo+hi)/2;
	        	 
	        	 m = line(N,mid);
	        	 
	        	 if(m == k) {
	        		 break;
	        	 }
	        	 if(m > k) {
			    	 hi = mid;
			     }else {
			    	 lo = mid;
			     }
	        	 
	        	System.out.println("m: " + m);
	         }
	         
	         
	         
	         
		   
	         //몇번째 행의 몇번째 수 인지 찾으려면 
		     
			System.out.println(mid);
		}

		private static int line(int n, int mid) {
			
		      
		         int hap =0;
		        
		         for(int i=1;i<=n;i++){
		        	 if((mid/i) >= n) {
		        		 hap += n;
		        	 }else {
		        		 hap += (mid/i);
		        	 }
		         }
		       
			return hap;
		}

}
