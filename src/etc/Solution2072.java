package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2072 {	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			
			for(int j=0;j<10;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp % 2 != 0) {
					sum += temp;
				}
			}
			System.out.println("#"+count+" "+sum);
			count++;
		}
		
		
		
	}
}
