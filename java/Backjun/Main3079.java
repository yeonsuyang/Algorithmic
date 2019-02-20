package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3079 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //심사관 인원수	
		int M = Integer.parseInt(st.nextToken()); //친구들 인원 수
		
		int[] time = new int[N];
		
		for(int i=0; i<time.length;i++) {
			time[i] = Integer.parseInt(br.readLine());
		}//7 10
		
		Arrays.sort(time);
		int[] hap = calculate(time,M);
		int max =0;
		for(int i=1; i<hap.length;i++) {
			max = cmax(hap[i-1],hap[i]);
		}
		System.out.println(max);
	}

	private static int cmax(int i, int j) {
		// TODO Auto-generated method stub
		return i>j ? i:j;
	}

	private static int[] calculate(int[] time, int m) {
		
		int[] now = new int[time.length];
		int[] tn = new int[time.length];
		
		for(int i=0;i<m;i++) { 
			int select = 0;
			for(int j=1; j<tn.length;j++){
				if(tn[j] < tn[j-1]) {
					if(tn[j-1]+time[j-1] > tn[j] + time[j]) {
						select = j;
					}else {
						select = j-1;
					}
				}else {
					select = j-1;
				}
			}
			now[select]++;
			tn[select] = now[select] * time[select];
		}
		
		return tn;
	}
}
