package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10815 {
	public static void main(String[] args) throws IOException {
	
	///상근이가 가진 카드 개수.
	// 카드
    // 판단할 개수
	// 판단할 카드. 
	 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st=null;
     st=new StringTokenizer(br.readLine());
     int numS = Integer.parseInt(st.nextToken());
     int[] cardS = new int[numS];
     
     st=new StringTokenizer(br.readLine());
     for(int i=0; i < numS;i++) {
    	 cardS[i] = Integer.parseInt(st.nextToken());
     }
     st=new StringTokenizer(br.readLine());
     int numC = Integer.parseInt(st.nextToken());
     int[] cardC = new int[numC];
     int[] result = new int[numC];
     
     st=new StringTokenizer(br.readLine());
     for(int i=0; i < numC;i++) {
    	 cardC[i] = Integer.parseInt(st.nextToken());
     }
     
     sort(cardS);
     
     //갖고 있는 지 판단
     for(int i=0; i < numC;i++) {
    	 result[i] = pandan(cardS, cardC[i]);
     }
     
     
     for(int i=0; i < numC;i++) {
    	 System.out.print(result[i] + " ");
     }


	}

	private static void sort(int[] cardS) {
		
		int temp;
		
		for(int i=0; i<cardS.length; i++) {
			for(int j=i+1;j<cardS.length; j++) {
				if(cardS[i] > cardS[j]) {
					temp = cardS[i];
					cardS[i] = cardS[j];
					cardS[j] = temp;
				}
			}
		}
		
	}

	private static int pandan(int[] cardS, int n) {
		
		int pandan = 0;
		
		int hi = cardS[cardS.length-1];
		int lo = cardS[0];
		int mid = hi+lo/2;
		
		if(mid )
		
		// TODO Auto-generated method stub
		return pandan;
	}
}
