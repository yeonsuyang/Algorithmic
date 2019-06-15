package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6236 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st= new StringTokenizer(br.readLine());
	     
	     int N = Integer.parseInt(st.nextToken()); //N일 동안
	     int M = Integer.parseInt(st.nextToken()); //M 번
	     int[] useMoney = new int[N];
	     int minimum = 0;
	     int hap = 0;
	     
	     for(int i=0; i<N; i++) {
	    	 useMoney[i] = Integer.parseInt(br.readLine());
	    	 minimum = min(minimum,useMoney[i]);
	    	 hap = useMoney[i];
	     }
	     
	     int mid = minimum+hap /2;
	     use(useMoney,M,mid);
	}

	private static void use(int[] useMoney, int m, int minimum) {
		
		int gazindon = minimum;
		int num = 1;
		for(int i=0; i<useMoney.length; i++) {
			if(gazindon < useMoney[i]) {
				gazindon = minimum;
				num++;
				if(num > m) {
					break;
				}
			}
			gazindon -= useMoney[i];
		}
		
		if(num > m) {
			use(useMoney,m,minimum+1);
		}else if(num < m) {
			use(useMoney,m,minimum-1);
		}else {
			System.out.println(minimum);
		}
	}

	private static int min(int minimum, int i) {
		// TODO Auto-generated method stub
		return minimum > i ? minimum : i;
	}
}